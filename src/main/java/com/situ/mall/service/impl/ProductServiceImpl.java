package com.situ.mall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IStaticPageService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	@Resource(name="productDao")
	private ProductDao productDao;
	@Autowired
	private IStaticPageService staticPageService;
	//获取所有信息
	@Override
	public List<Product> finAll() {
		return productDao.finAll();
	}
	//分页无条件
	@Override
	public PageBean<Product> pageList(Integer pageIndex, Integer pageSize) {

		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(pageIndex);//获得当前页
		pageBean.setPageSize(pageSize);//获得这一页的数据条数
		//获得数据库一共用多少数据
		int totalCount = productDao.totalSize();
		//获得多少页
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageIndex = (pageIndex - 1) * pageSize;
		pageBean.setTotalpage(totalPage);
		pageBean.setTotalCount(totalCount);
		List<Product> list = productDao.pageList(pageIndex, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	//分页有条件
	@Override
	public PageBean<Product> pageListByCondition(SearchCondition condition) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPageIndex(condition.getPageIndex());
		condition.setPageIndex((condition.getPageIndex()-1)*condition.getPageSzie());
		//设置一页有多少数据
		pageBean.setPageSize(condition.getPageSzie());
		int totalSize = productDao.totalSizeByCondition(condition);//获得符合条件的个数
		//看看有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSzie());
		pageBean.setTotalCount(totalSize);
		pageBean.setTotalpage(totalPage);
		List<Product> list = productDao.pageListByCondition(condition);
		for (Product product : list) {
		  System.out.println(list);	
		}
		pageBean.setList(list);
		return pageBean;
	}

	
	//添加
	@Override
	@ResponseBody
	public ServerResponse addProduct(Product product) {
		try {
			int result = productDao.addProduct(product);
			if (result > 0) {
				return ServerResponse.createSuccess("添加商品成功");
			} else {
				return ServerResponse.createError("添加商品失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加商品失败");
		}
		
	}
	//修改
	@Override
	public boolean updateProduct(Product product) {
		
		return productDao.updateProduct(product);
	}
	@Override
	public boolean updateStatus(Product product) {
		
		int status = product.getStatus();
		
		if (status == 1) {
			status = 2;
		} else if (status == 2) {
			status = 1;
		}
		
		product.setStatus(status);
		int result  = productDao.updateStatus(product);
		
		if ( result > 0) {
			return true;
		} else {
			return false;
		}
	}
	//根据Id查询
	@Override
	public Product findById(Integer id) {
		System.out.println("++++++++++++++++++"+ productDao.findById(id));
		return productDao.findById(id);
	}
	//删除
	@Override
	public ServerResponse deleteById(int id) {
		try {
		int reslut = productDao.deleteById(id);
		if ( reslut > 0) {
			return ServerResponse.createSuccess("删除商品成功");
		} else {
			return ServerResponse.createError("删除商品失败");
		}
	}catch (Exception e) {
			return ServerResponse.createError("删除商品失败");
		}
	}
	
	//全部删除
/*	@Override
	public boolean delAll(int[] selectIds) {
		int result = productDao.delAll(selectIds);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}*/
	@Override
	public boolean delAll(int[] selectIds) {
		boolean result = false;
		for (Integer id : selectIds) {
			productDao.deleteById(id);
			result = true;
		}
		return result;
		
	}
	//批量修改
	@Override
	public boolean updateAll(Map<Integer, Integer> map) {
		int result = 0;
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			
			int status = entry.getValue();
			if(status == 1){
				status = 2;
			}else if(status == 2){
				status = 1;
			}
			result = productDao.updateAll(entry.getKey(),status);
			result += result;
		}
		return result>0?true:false;
	}
	//修改商品的状态ajax
	@Override
	public ServerResponse updateStatusByAjax(Integer id, Integer status) {
if (id == null) {
			
			return ServerResponse.createError("id不能为空");
		}
		if (status == 1) {
			status = 2;
		} else if (status == 2) {
			status = 1;
		}
		
		int result  = productDao.updateAll(id, status);
		if (result < 0) {
			return ServerResponse.createError("上线失败");
		}
		
		Product product = productDao.findById(id);
		System.out.println(product);
		if (product == null) {
			
			return ServerResponse.createError("商品不能存在");
		}
		
		Map root = new HashMap();
		root.put("product", product);
		 //按照“，”分割subImages，
	    String subImagesStr = product.getSubImages();
	    if (null != subImagesStr && !subImagesStr.equals("")) {
	       String[] subImages = subImagesStr.split(",");
	       for (int i = 0; i < subImages.length; i++) {
	           subImages[i] = MallConstant.SERVER_ADDRES + subImages[i];
	       }
	       root.put("subImages", subImages);
	}
	    
	    if (staticPageService.productIndex(root, id)) {
	    	return ServerResponse.createSuccess("静态化页面修改成功");
	    }
	    return ServerResponse.createError("静态化页面修改失败");
	
		}

}
