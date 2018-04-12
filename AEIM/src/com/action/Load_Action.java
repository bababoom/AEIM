package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import Bean.Staff ;
public class Load_Action implements Action {
	
	private ArrayList<Staff> list ;
	private Data_con con = new Data_con() ;
	private String test ;
	private String username ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
			String sql = "" ;
			list = new ArrayList<Staff>() ;
			
			if(this.getTest()==null||this.getTest().equals("")){
				sql = "select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO,STATUS from emp" ;
				
			}else {
				this.setTest(new String(this.getTest().getBytes("iso-8859-1"),"UTF-8"));
			
				sql = "select distinct EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO,STATUS from emp where EMPNO like '%"+this.getTest().trim()+"%' or ENAME like '%"+this.getTest().trim()+"%'" ; 
			}
			ResultSet rs = con.getStat().executeQuery(sql) ;
			while(rs.next()){
				list.add(new Staff(rs.getString("EMPNO"),
						rs.getString("ENAME"),
						rs.getString("JOB"),
						rs.getString("MGR"),
						rs.getString("HIREDATE").substring(0, 10),
						String.valueOf(rs.getFloat("SAL")),
						rs.getString("COMM"),
						rs.getString("DEPTNO"),
						rs.getString("STATUS")));
					
			}
			ActionContext.getContext().put("list", list);
			return SUCCESS ;
		
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
