package com.Init;

public class DBService {
	public  static final String host = "127.0.0.1";
	public  static final String DB_MYSQL = "MYSQL";
	public  static final String DB_SQLSERVER = "SQLSERVER";

	public  static final String DB_TYPE = DB_SQLSERVER;

	private static final String DBURL_SQLServer = "jdbc:sqlserver://" + host + ":1433;databaseName=GetMarry";
	public  static final String USERID_SQLServer = "sa";
	public  static final String PSWD_SQLServer = "P@ssw0rd";

	public  static final String nameMs = "java:comp/env/jdbc/GetMarry";
//	public  static final String nameMy = "java:comp/env/jdbc/BookDataMySQL";
	
	public  static String JNDI_DB_NAME = nameMs;
	
//	static {
//		if (JNDI_DB_NAME.equals(DB_MYSQL)) {
//			JNDI_DB_NAME = nameMy;
//		} else if (JNDI_DB_NAME.equals(DB_SQLSERVER)) {
//			JNDI_DB_NAME = nameMs;
//		}
//	}
//	
//	private static final String DBURL_MySQL = "jdbc:mysql://" + host
//			+ "/jspdb?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei";
//	public static final String USERID_MySQL = "root";
//	public static final String PSWD_MySQL = "Do!ng123";
}
