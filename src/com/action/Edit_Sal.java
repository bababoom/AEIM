package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Edit_Sal implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<temp> list ;
	private String test ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<temp>() ;
		String sql = "select GRADE,LOSAL,HISAL from salgrade" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new temp(rs.getString("GRADE"),rs.getString("LOSAL"),rs.getString("HISAL"))) ;
		}
		int i = Integer.valueOf(list.get(list.size()-1).getGRADE()) ;
		i++ ;
		String t = String.valueOf(i) ;
		if(this.getTest()!=null){
			if(this.getTest().equals("1"))list.add(new temp(t,"","")) ;
		}
		return SUCCESS ;
	}
	public ArrayList<temp> getList() {
		return list;
	}
	public void setList(ArrayList<temp> list) {
		this.list = list;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	class temp{
		private String GRADE ;
		private String LOSAL ;
		private String HISAL ;
		public temp(){} ;
		public temp(String GRADE,String LOSAL,String HISAL){
			this.GRADE = GRADE ;
			this.LOSAL = LOSAL ;
			this.HISAL = HISAL ;
			
		}
		public String getGRADE() {
			return GRADE;
		}
		public void setGRADE(String gRADE) {
			GRADE = gRADE;
		}
		public String getLOSAL() {
			return LOSAL;
		}
		public void setLOSAL(String lOSAL) {
			LOSAL = lOSAL;
		}
		public String getHISAL() {
			return HISAL;
		}
		public void setHISAL(String hISAL) {
			HISAL = hISAL;
		}
	}
}