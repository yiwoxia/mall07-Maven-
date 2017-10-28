package com.situ.mall.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelConvert {

	public static List<Map<String, Object>> convertList(ResultSet rs) {
		
		// 新建�?个map list集合用于存放多条查询记录
		
		List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			ResultSetMetaData md = rs.getMetaData();//结果集（rs）的结构信息，比如字段数，字段名等�??
			
			int columnCount = md.getColumnCount();//取得查询出来的字段个�?
			
			while(rs.next()){//迭代rs
				//新建�?个map集合 将查询出内容按照字段名：�? 的键值对形式存储在map集合�?
				Map<String,Object>rowData = new HashMap<String,Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnLabel(i),rs.getObject(i));
				}
				list.add(rowData);//将map放入list集合
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//关闭连接
			
		
				try {
					if(rs != null)
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return list;
		
	}
	
}
