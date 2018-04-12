package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_Rework implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<String> E_list ;
	private ArrayList<String> D_list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		E_list = new ArrayList<String>() ;
		D_list = new ArrayList<String>() ;
		String sql = "select EMPNO,ENAME from emp where STATUS='已离职'" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			E_list.add(rs.getString("EMPNO")+" - "+rs.getString("ENAME")) ;
		}
		sql = "select DEPTNO,DNAME from dept" ;
		rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			D_list.add(rs.getString("DEPTNO")+" - "+rs.getString("DNAME")) ;
		}
		return SUCCESS;
	}
	public ArrayList<String> getE_list() {
		return E_list;
	}
	public void setE_list(ArrayList<String> e_list) {
		E_list = e_list;
	}
	public ArrayList<String> getD_list() {
		return D_list;
	}
	public void setD_list(ArrayList<String> d_list) {
		D_list = d_list;
	}
	

}
