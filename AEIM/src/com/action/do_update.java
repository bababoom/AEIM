package com.action;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class do_update implements Action {
	private String EMPNO ;
	private String ENAME ;
	private String JOB ;
	private String SAL ;
	
	private Data_con con = new Data_con() ;
	@Override
	public String execute() throws Exception {
		
		// TODO Auto-generated method stub
		String sql = "update emp set ENAME='"+this.getENAME()+"',JOB='"+this.getJOB()+"',SAL='"+this.getSAL()+"' where EMPNO='"+this.getEMPNO()+"'" ;
		con.getStat().execute(sql) ;
		return SUCCESS ;
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
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public String getSAL() {
		return SAL;
	}
	public void setSAL(String sAL) {
		SAL = sAL;
	}

}
