package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_Out implements Action {
	private Data_con con = new Data_con() ;
	
	private ArrayList<temp> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<temp>() ;
		String sql = "select EMPNO,ENAME,OUTDATE from outemp" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new temp(rs.getString("EMPNO"),rs.getString("ENAME"),rs.getString("OUTDATE").substring(0,rs.getString("OUTDATE").length()-2))) ;
		}
		return SUCCESS;
	}
	public ArrayList<temp> getList() {
		return list;
	}
	public void setList(ArrayList<temp> list) {
		this.list = list;
	}
	class temp{
		private String EMPNO ;
		private String ENAME ;
		private String OUTDATE ;
		public temp(){} ;
		public temp(String EMPNO,String ENAME,String OUTDATE){
			this.EMPNO = EMPNO ;
			this.ENAME = ENAME ;
			this.OUTDATE = OUTDATE ;
		}
		public String getEMPNO() {
			return EMPNO;
		}
		public void setEMPNO(String eMPNO) {
			EMPNO = eMPNO;
		}
		public String getENAME() {
			return ENAME;
		}
		public void setENAME(String eNAME) {
			ENAME = eNAME;
		}
		public String getOUTDATE() {
			return OUTDATE;
		}
		public void setOUTDATE(String oUTDATE) {
			OUTDATE = oUTDATE;
		}
		
	}
}
