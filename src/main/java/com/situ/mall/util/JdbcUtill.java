package com.situ.mall.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;


public class JdbcUtill {
	
/*	private static final String driverClass="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/java002";
	private static final String userNmae ="root";
	private static final String password="zhangzhen";*/
	private static  String  driverClass;
	private static String   url;
	private static String   userNmae ;
	private static String   password;
	public static void init(ServletContext context){
		InputStream inputStream = null;
		Properties properties = new Properties();
		try {
			inputStream  = context.getResourceAsStream("/WEB-INF/classes/db.properties");
			properties.load(inputStream);
			driverClass = properties.getProperty("driverClass");
		    url = properties.getProperty("url");
		    userNmae = properties.getProperty("userNmae");
		    password = properties.getProperty("password");
    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//加载驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	static {
           /*Properties properties = new Properties();
           FileInputStream  fileIputStream = null;
		try {
			fileIputStream = new FileInputStream("D:\\EclipseSpace\\java001\\src\\db.properties");
			properties.loasza fdce34d(fileIputStream);
			driverClass = properties.getProperty("driverClass");
		    url = properties.getProperty("url");
		    userNmae = properties.getProperty("userNmae");
		    password = properties.getProperty("password");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//加载驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userNmae, password);
	}

	public static void Close(Connection connection, Statement statement, ResultSet resultSet) {
		// TODO Auto-generated method stub
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void Close(Connection connection, PreparedStatement preparedStatement) {
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void Close(ResultSet resultSet, Connection connection, PreparedStatement preparedStatement) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if ( connection!= null) {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (preparedStatement!= null) {
			try {
				preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
