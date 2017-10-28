package com.situ.mall.util;

import java.io.File;
import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUploadUtil {

		//服务器地址
		public static final String SERVER_ADDRES= "http://ox1pbc20y.bkt.clouddn.com/";
		/**基本配置*/
		//设置好账号的ACCESS_KEY和SECRET_KEY
		private static final  String ACCESS_KEY = "tDHG6RODXw3P71u0-Tq-PHJYKmGs6eQCHU9Oi_Ur";
		private static final  String SECRET_KEY ="oSB1NCz-hpVDQEHXoLCLm9ZfMQy1bRnxYpvwFcaU";
		//要上传的空间--目前用的测试空间--上线要修改
		private static final String BUCKET_NAME ="java1707mall";
		
		/** 指定保存到七牛的文件名--同名上传会报错 {"error":"file exists"} */
		/**
		 * {"hash":"FrQF5eX_kNsNKwgGNeJ4TbBA0Xzr","key":"aa1.jpg"} 正常返回 key为七牛空间地址
		 * http://imagetest.i.haierzhongyou.com/aa1.jpg
		 */
		// 上传到七牛后保存的文件名---不指定的话，七牛随机产生-无后缀
		// String key = "hi.jpg";
		//密钥配置
		private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		// 创建上传对象
		private static UploadManager uploadManager = new UploadManager();
		//简单上传，使用默认策略，只需要设置上传的空间名就可以了
		private static String getUpToken(){
			return auth.uploadToken(BUCKET_NAME);
		}

		public static String upload(byte[] file) {
			try {
				// 调用put方法上传
				Response res = uploadManager.put(file, null, getUpToken());
				// 打印返回的信息
				System.out.println(res.bodyString());
				return (String) res.jsonToMap().get("key");
			} catch (QiniuException e) {
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				try {
					// 响应的文本信息
					System.out.println(r.bodyString());
				} catch (QiniuException e1) {
					// ignore
				}
			}
			return "";
		}

		public static String upload(File file) {
			try {
				// 调用put方法上传
				Response res = uploadManager.put(file, null, getUpToken());
				// 打印返回的信息
				System.out.println(res.bodyString());
				return (String) res.jsonToMap().get("key");
			} catch (QiniuException e) {
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				try {
					// 响应的文本信息
					System.out.println(r.bodyString());
				} catch (QiniuException e1) {
					// ignore
				}
			}
			return "";
		}
		
		/**
	     * 获得url地址
	     */
	    public static String getUrl(String key) {
	        return SERVER_ADDRES + key;
	    }
	}
		

