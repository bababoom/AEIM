package com.action;

import java.sql.ResultSet;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Pre_InEmp implements Action {
	private Data_con con  = new Data_con() ;
	private String EMPNO_str = "" ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select EMPNO from emp" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			
			EMPNO_str += rs.getString("EMPNO") ;
			EMPNO_str += ","  ;
		}
		EMPNO_str = EMPNO_str.substring(0, EMPNO_str.length()-2) ;
		return SUCCESS ;
	}
	public String getEMPNO_str() {
		return EMPNO_str;
	}
	public void setEMPNO_str(String eMPNO_str) {
		EMPNO_str = eMPNO_str;
	}

}
