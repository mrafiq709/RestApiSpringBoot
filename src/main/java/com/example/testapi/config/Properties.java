package com.example.testapi.config;

public class Properties {
	
public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
    public static final String DB_URL = "jdbc:mysql://localhost/test_db";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    
    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    public static final String HIBERNATE_SHOW_SQL = "true";
    public static final String HBM2DDL_AUTO = "update";
    public static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "com.neurogen.genomearc.entity";

}
