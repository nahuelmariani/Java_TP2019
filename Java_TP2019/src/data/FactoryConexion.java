package data;

import java.sql.*;

public class FactoryConexion {

	private static FactoryConexion instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="jhdjjtqo9w5bzq2t.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
	private String port="3306";
	private String user="r88cfwaeidtmnxpq";
	private String password="e9es9cbc9exrc72j";
	private String db="hboaeol4brbx751m";
	
	private int conectados=0;
	private Connection conn=null;
	
	//Singleton = Constructor privado + instancia privada + metodo con un if
	//
	
	private FactoryConexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoryConexion getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2D3", user, password);
				//conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);

				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}