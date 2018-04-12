package com.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import Data.Data_con;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Login_Action implements Action {
	private Data_con con = new Data_con() ;
	//private PreparedStatement stmt = null ;
	private ResultSet rs = null ;
	private String username ;
	private String password ;
	private String info ="";
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		Map session = (Map)ActionContext.getContext().getSession(); 
		if(con!=null){
			
			if(con.judge(this.getUsername(), this.getPassword())) {
				session.put("username", this.getUsername());
				this.info = "" ;
				return SUCCESS ;
			}
			else{
				session.put("username","");
				this.info = "登录失败，请检查用户名等是否有误！" ;
				return "fail" ;
			}
			
			//return SUCCESS ;
		}else return SUCCESS ;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
