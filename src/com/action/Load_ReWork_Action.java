package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_ReWork_Action implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<temp> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<temp>() ;
		String sql = "select *from rework" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new temp(rs.getString("EMPNO"),rs.getString("ENAME"),rs.getString("FRONT_DEPTNO"),rs.getString("NOW_DEPTNO"),rs.getString("FRONT_JOB"),rs.getString("NOW_JOB"),rs.getString("REDATE").substring(0,rs.getString("REDATE").length()-2))) ;
		}
		return SUCCESS ;
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
		private String FRONT_DEPTNO ;
		private String NOW_DEPTNO ;
		private String FRONT_JOB ;
		private String NOW_JOB ;
		private String REDATE ;
		
		public temp(){} ;
		public temp(String EMPNO,String ENAME,String FRONT_DEPTNO,String NOW_DEPTNO,String FRONT_JOB,String NOW_JOB,String REDATE){
			this.EMPNO = EMPNO ;
			this.ENAME = ENAME ;
			this.FRONT_DEPTNO = FRONT_DEPTNO ;
			this.FRONT_JOB = FRONT_JOB ;
			this.NOW_DEPTNO = NOW_DEPTNO ;
			this.NOW_JOB = NOW_JOB ;
			this.REDATE = REDATE ;
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
		public String getNOW_DEPTNO() {
			return NOW_DEPTNO;
		}
		public void setNOW_DEPTNO(String nOW_DEPTNO) {
			NOW_DEPTNO = nOW_DEPTNO;
		}
		public String getFRONT_JOB() {
			return FRONT_JOB;
		}
		public void setFRONT_JOB(String fRONT_JOB) {
			FRONT_JOB = fRONT_JOB;
		}
		public String getNOW_JOB() {
			return NOW_JOB;
		}
		public void setNOW_JOB(String nOW_JOB) {
			NOW_JOB = nOW_JOB;
		}
		public String getREDATE() {
			return REDATE;
		}
		public void setREDATE(String rEDATE) {
			REDATE = rEDATE;
		}
	}
}
