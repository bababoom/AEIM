package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Data_con {
	private  PreparedStatement stmt=null; 
	private Connection con ;
	private Statement stat =null ;
	private ResultSet rs =null ;
	/**
	 * 连接数据库
	 */
	public Data_con(){
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
		}
		catch(ClassNotFoundException e){
			System.out.println("找不到驱动程序，驱动加载失败");
		}
			String url = "jdbc:mysql://localhost:3306/sql_test" ;    
			String username = "root" ;   
			String password = "123456" ;   
	     		try{   
	    	    Connection con =    
	    	             DriverManager.getConnection(url , username , password ) ;  
	    	    		stat = con.createStatement() ;
	    	     }catch(SQLException se){   
	    	    System.out.println("数据库连接失败！");   
	    	    se.printStackTrace() ;   
	    	     }  
	     		
	     
	}
	
	/**
	 * 关闭数据库的链接
	 */
	public void close(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public String replace(String str){
		return str.replaceAll(".*([';]+|(--)+).*", " ");
	}
	public boolean judge(String username,String password) throws SQLException{
				
		
		String sql = "select *from account where username='"+replace(username)+"' and password='"+replace(password)+"'" ;
		try {
			rs = stat.executeQuery(sql) ;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try { 	
			if(rs.next())return true ;
			else return false ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
		
	}
	/*
	public static void main(String[] args) throws SQLException{
		Data_con con = new Data_con() ;
		String sql = "select *from user_info where username='"+con.replace("root")+"' and password='"+con.replace("123456")+"'" ;
		ResultSet rr = con.getStat().executeQuery(sql) ;
		if(rr.next())System.out.println(true);
		else System.out.println(false);
		
	}
	*/

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	public Statement getStat(){
		return this.stat ;
	}

	
	


	
}
