package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Pre_OutEmp implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<String> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<String>() ;
		String sql = "select EMPNO,ENAME from emp where STATUS ='在职'" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			String temp = rs.getString("EMPNO")+" - "+rs.getString("ENAME") ;
			list.add(temp) ;
			
		}
		ActionContext.getContext().put("list", list) ;
		return SUCCESS;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
