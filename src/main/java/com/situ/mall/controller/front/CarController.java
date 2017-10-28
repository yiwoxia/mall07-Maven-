package com.situ.mall.controller.front;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

@Controller
@RequestMapping("/cart")
public class CarController {

	@Autowired
	private IProductService productService;
	//购物车减
	@RequestMapping("/cart")
	public String cart(Model model,HttpServletRequest request){
		
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		//只有对象里面不是null的才转换
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		
		BuyCartVO buyCartVO = null;
		Cookie[] cookies = request.getCookies();
		//1.如果cookie有这个购物车对象，那就从cookie里面取出这个购物车对象
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("buy_cart_cookie".equals(cookie.getName())) {
					//之前已经有购物车
					//"{\"items\":[{\"product\":{\"id\":45},\"amount\":1}],\"productId\":45}"
					//存在buy_cart_cookie
					String value = cookie.getValue();
						try {
							buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			}
		}
		
		//放到域对象中返回到前端展示的这个购物车，需要将Product对象填满数据才行
		List<CartItemVO> items = buyCartVO.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}
		model.addAttribute("buyCartVO",buyCartVO);
		return "cart";
		
	}
	//购物车加
	@RequestMapping("/addCart")
	public String addCart(Integer productId, Integer amount, Model model,HttpServletRequest request, HttpServletResponse response){

		System.out.println("productId:" + productId);
		System.out.println("amount:" + amount);
		
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		//只有对象里面不是null的才转换
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		
		BuyCartVO buyCartVO = null;
		Cookie[] cookies = request.getCookies();
		//遍历cookies 查找buy_cart_cookie 不创建buyCart
		if (null != cookies && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if ("buy_cart_cookie".equals(cookie.getName())) {
					//之前已经有购物车
					//"{\"items\":[{\"product\":{\"id\":45},\"amount\":1}],\"productId\":45}"
					//存在buy_cart_cookie
					String value = cookie.getValue();
					try {
						buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		//2.如果cookie没有这个购物车对象，才需要new BuyCartVO
		if (buyCartVO == null) {
			buyCartVO = new BuyCartVO();
		}
		
		//把购物项放到购物车里面
		if (null != productId) {
			Product productTemp = productService.findById(productId);
		}
		
		//把购物项放到购物车里面
		if(null != productId){
			Product productTemp = productService.findById(productId);
			Product product = new Product();
			product.setId(productId);
			product.setStock(productTemp.getStock());
			CartItemVO cartItemVO = new CartItemVO();
			cartItemVO.setProduct(product);
			cartItemVO.setAmount(amount);
			buyCartVO.addItem(cartItemVO);
			buyCartVO.setProductId(productId);
			
			//把购物车对象BuyCartVO以json形式写到cookie里面
			StringWriter stringWriter = new StringWriter();
		   try {
				objectMapper.writeValue(stringWriter, buyCartVO);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		   //将购物车json数据放到cookie里面
		   Cookie cookie = new Cookie("buy_cart_cookie", stringWriter.toString());
		   //默认关闭浏览器cookie销毁
		   cookie.setMaxAge(60 * 60 * 24);
		   
		   cookie.setPath("/");
		   
		   //将cookie发送给浏览器
		   response.addCookie(cookie);
		}
		
		//放到域对象中返回到前端展示的这个购物车，需要将Product对象填满数据才行
		List<CartItemVO> items = buyCartVO.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}
		model.addAttribute("buyCartVO",buyCartVO);
		return "redirect:cart.shtml";
		
	}
	
	//删除购物车的商品
		@RequestMapping("/delCart")
		private String delCart(Integer productId, Integer amount, HttpServletRequest request, Model model, HttpServletResponse response) {
		
			BuyCartVO buyCartVO = null;
			
			//springmvc
			ObjectMapper objectMapper = new ObjectMapper();
			
			//获得cookie
			Cookie[] cookies = request.getCookies();
			//遍历cookies 查找buy_cart_cookie 不创建buyCart
			if (null != cookies && cookies.length != 0) {
				for (Cookie cookie : cookies) {
					if ("buy_cart_cookie".equals(cookie.getName())) {
						//之前已经有购物车
						//"{\"items\":[{\"product\":{\"id\":45},\"amount\":1}],\"productId\":45}"
						//存在buy_cart_cookie
						String value = cookie.getValue();
						try {
							buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if (null != productId) {
				List<CartItemVO> cartItems = buyCartVO.getItems();
				if (null != cartItems) {
					a : for (CartItemVO item : cartItems) {
						if (productId == item.getProduct().getId()) {
							Product product = item.getProduct();
							cartItems.remove(item);
							break a;
						}
					}
				/*for (CartItemVO cartItem : cartItems) {
					Product productTemp = productService.findById(cartItem.getProduct().getId());
					Product product = new Product();
					product.setStock(productTemp.getStock());
					product.setPrice(productTemp.getPrice());
					cartItem.setProduct(product);
					buyCartVO.addItem(cartItem);
				}*/
				//把buyCart以json加入到cookie
				StringWriter stringWriter = new StringWriter();
				try {
					objectMapper.writeValue(stringWriter, buyCartVO);
				} catch (JsonGenerationException e) {
					
					e.printStackTrace();
				} catch (JsonMappingException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				//将购物车JSon加入到cookie
				Cookie cookie = new Cookie("buy_cart_cookie", stringWriter.toString());
				//设置默认的cookie存储的时间
				cookie.setMaxAge(60 * 60 *24);
				//设置cookie的路径
				cookie.setPath("/");
				//将cookie发送到浏览器
				response.addCookie(cookie);
			}
		}
			//放到域对象中返回到前端展示的这个购物车，需要将Product对象填满数据才行
			List<CartItemVO> items = buyCartVO.getItems();
			for (CartItemVO item : items) {
				Product product = productService.findById(item.getProduct().getId());
				item.setProduct(product);
			}
			return "redirect:cart.shtml";
			
		}
}
