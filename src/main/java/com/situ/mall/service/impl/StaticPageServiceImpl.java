package com.situ.mall.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.situ.mall.service.IStaticPageService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class StaticPageServiceImpl implements IStaticPageService, ServletContextAware{

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
  	private ServletContext servletContext;
	
	@Override
	public boolean productIndex(Map<String, Object> root, Integer id) {
		
		//配置对象
       Configuration configuration = freeMarkerConfigurer.getConfiguration();
       Template template = null;
       //读取模板到内存
       try {
    	   template = configuration.getTemplate("product_detail.ftl");
	} catch (IOException e) {
		e.printStackTrace();
		return false;
	}
     
     //生成的静态的文件
       String path = "/resources/html/" + id + ".html";//44.html
       File file = new File(servletContext.getRealPath(path));
       File parentFile = file.getParentFile();
       if (!parentFile.exists()) {
  		parentFile.mkdir();
  	}
  	
       //输出流---开始生成
       Writer out = null;
       try {
      	//输出流(new FileOutputStream(f), "UTF-8")
    	   out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
  		template.process(root, out);
  	} catch (IOException e1) {
  		e1.printStackTrace();
  		return false;
  	}catch (TemplateException e) {
  		e.printStackTrace();
  		return false;
  	}

  	return true;
  	}
  	
  /*	private String getPath(String name){
  		return servletContext.getRealPath(name);
  	}
*/
  	@Override
  	public void setServletContext(ServletContext servletContext) {

  		this.servletContext = servletContext;
  		
  	}
  	
}
