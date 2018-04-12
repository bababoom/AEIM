package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_Moved implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<temp> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<temp>() ;
		String sql = "select EMPNO,ENAME,FRONT_DEPTNO,FRONT_JOB,AFTER_DEPTNO,AFTER_JOB,MOVEDATE from move" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new temp(rs.getString("EMPNO"),rs.getString("ENAME"),rs.getString("FRONT_DEPTNO"),rs.getString("AFTER_DEPTNO"),rs.getString("FRONT_JOB"),rs.getString("AFTER_JOB"),rs.getString("MOVEDATE").substring(0,rs.getString("MOVEDATE").length()-2))) ;
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
		private String ENAME;
		private String FRONT_DEPTNO ;
		private String AFTER_DEPTNO ;
		private String FRONT_JOB ;
		private String AFTER_JOB ;
		private String MOVEDATE ;
		public temp(){} ;
		public temp(String EMPNO,String ENAME,String FRONT_DEPTNO,String AFTER_DEPTNO,String FRONT_JOB,String AFTER_JOB,String MOVEDATE){
			this.EMPNO = EMPNO ;
			this.ENAME = ENAME ;
			this.FRONT_DEPTNO= FRONT_DEPTNO ;
			this.FRONT_JOB = FRONT_JOB ;
			this.AFTER_DEPTNO = AFTER_DEPTNO ;
			this.AFTER_JOB = AFTER_JOB ;
			this.MOVEDATE = MOVEDATE ;
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
		public String getFRONT_DEPTNO() {
			return FRONT_DEPTNO;
		}
		public void setFRONT_DEPTNO(String fRONT_DEPTNO) {
			FRONT_DEPTNO = fRONT_DEPTNO;
		}
		public String getAFTER_DEPTNO() {
			return AFTER_DEPTNO;
		}
		public void setAFTER_DEPTNO(String aFTER_DEPTNO) {
			AFTER_DEPTNO = aFTER_DEPTNO;
		}
		public String getFRONT_JOB() {
			return FRONT_JOB;
		}
		public void setFRONT_JOB(String fRONT_JOB) {
			FRONT_JOB = fRONT_JOB;
		}
		public String getAFTER_JOB() {
			return AFTER_JOB;
		}
		public void setAFTER_JOB(String aFTER_JOB) {
			AFTER_JOB = aFTER_JOB;
		}
		public String getMOVEDATE() {
			return MOVEDATE;
		}
		public void setMOVEDATE(String mOVEDATE) {
			MOVEDATE = mOVEDATE;
		}
	}
}
