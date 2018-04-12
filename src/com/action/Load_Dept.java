package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.dept;
import Data.Data_con;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Load_Dept implements Action {
	
	
	private Data_con con = new Data_con() ;
	
	private ArrayList<dept> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<dept>() ;
		String sql = "select DEPTNO,DNAME,LOC from dept" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new dept(rs.getString("DEPTNO"),rs.getString("DNAME"),rs.getString("LOC"))) ;
		}
		for(int i=0;i<list.size();i++){
			String dname = list.get(i).getDNAME() ;
			String sql1 = "select EMPNO from emp where DEPTNO=(select DEPTNO from dept where DNAME='"+dname+"')" ;
			ResultSet rr = con.getStat().executeQuery(sql1) ;
			int temp = 0 ;
			if(rr.next()){
				rr.last() ;
				temp = rr.getRow() ;
				
			}
			list.get(i).setNUM(String.valueOf(temp)) ;
		}
		
		ActionContext.getContext().put("list", list);
		return SUCCESS ;
	}
	
	
	
}
