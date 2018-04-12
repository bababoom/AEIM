package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_Move implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<String> E ;
	private ArrayList<String> D ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		E = new ArrayList<String>() ;
		D = new ArrayList<String>() ;
		String sql1 = "select EMPNO,ENAME from emp where STATUS !='"+"已离职"+"'" ;
		String sql2 = "select DEPTNO,DNAME from dept" ;
		ResultSet rs = con.getStat().executeQuery(sql1) ;
		while(rs.next())E.add(rs.getString("EMPNO")+" - "+rs.getString("ENAME")) ;
		rs = con.getStat().executeQuery(sql2) ;
		while(rs.next())D.add(rs.getString("DEPTNO")+" - "+rs.getString("DNAME")) ;
		return SUCCESS;
	}
	public ArrayList<String> getE() {
		return E;
	}
	public void setE(ArrayList<String> e) {
		E = e;
	}
	public ArrayList<String> getD() {
		return D;
	}
	public void setD(ArrayList<String> d) {
		D = d;
	}

}
