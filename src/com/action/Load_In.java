package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Load_In implements Action {
	private Data_con con = new Data_con() ;
	private ArrayList<temp> list ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new ArrayList<temp>() ;
		String sql = "select EMPNO,ENAME,MGR,LOC,JOB,DEPTNO,EMAIL,SAL,INDATE,TEL,ADDRESS from inemp" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			list.add(new temp(rs.getString("EMPNO"),rs.getString("ENAME"),rs.getString("MGR"),rs.getString("LOC"),rs.getString("JOB"),
					rs.getString("DEPTNO"),rs.getString("EMAIL"),rs.getString("SAL"),rs.getString("INDATE").substring(0,rs.getString("INDATE").length()-2),rs.getString("TEL"),rs.getString("ADDRESS"))) ;
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
		private String MGR ;
		private String LOC ;
		private String JOB ;
		private String DEPTNO ;
		private String EMAIL ;
		private String SAL ;
		private String INDATE ;
		private String TEL ;
		private String ADDRESS ;
		
		public temp(){} ;
		public temp(String EMPNO,String ENAME,String MGR,String LOC,String JOB,String DEPTNO,String EMAIL,String SAL,String INDATE,String TEL,String ADDRESS){
			this.EMAIL = EMAIL ;
			this.EMPNO = EMPNO ;
			this.ENAME = ENAME ;
			this.JOB = JOB ;
			this.SAL = SAL ;
			this.ADDRESS = ADDRESS ;
			this.INDATE = INDATE ;
			this.MGR = MGR ;
			this.TEL = TEL ;
			this.DEPTNO = DEPTNO ;
			this.LOC = LOC ;
			
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
		public String getMGR() {
			return MGR;
		}
		public void setMGR(String mGR) {
			MGR = mGR;
		}
		public String getLOC() {
			return LOC;
		}
		public void setLOC(String lOC) {
			LOC = lOC;
		}
		public String getJOB() {
			return JOB;
		}
		public void setJOB(String jOB) {
			JOB = jOB;
		}
		public String getDEPTNO() {
			return DEPTNO;
		}
		public void setDEPTNO(String dEPTNO) {
			DEPTNO = dEPTNO;
		}
		public String getEMAIL() {
			return EMAIL;
		}
		public void setEMAIL(String eMAIL) {
			EMAIL = eMAIL;
		}
		public String getSAL() {
			return SAL;
		}
		public void setSAL(String sAL) {
			SAL = sAL;
		}
		public String getINDATE() {
			return INDATE;
		}
		public void setINDATE(String iNDATE) {
			INDATE = iNDATE;
		}
		public String getTEL() {
			return TEL;
		}
		public void setTEL(String tEL) {
			TEL = tEL;
		}
		public String getADDRESS() {
			return ADDRESS;
		}
		public void setADDRESS(String aDDRESS) {
			ADDRESS = aDDRESS;
		} 
		
	}
}
