package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class pre_Add_Dept implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<String> Arr ;
	private String str ; 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		str = "" ;
		Arr = new ArrayList<String>() ;
		String sql = "select DEPTNO from dept" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			Arr.add(rs.getString("DEPTNO")) ;
		}
		for(int i=0;i<Arr.size();i++){
			str += Arr.get(i) ;
			if(i!=Arr.size()-1){
				str += "," ;
			}
		}
		ActionContext.getContext().put("str", str);
		return SUCCESS ;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	

}
