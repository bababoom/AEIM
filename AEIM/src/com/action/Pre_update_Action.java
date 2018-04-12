package com.action;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import Bean.Staff ;
public class Pre_update_Action implements Action {
	private Staff staff ;
	private String EMPNO ;
	private String ENAME ;
	private String JOB ;
	private String MGR ;
	private String HIREDATE ;
	private String SAL ;
	private String COMM ;
	private String DEPTNO ;
	private String STATUS ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			JOB =  java.net.URLDecoder.decode(JOB,"UTF-8");
			ENAME =  java.net.URLDecoder.decode(ENAME,"UTF-8");
			STATUS = java.net.URLDecoder.decode(STATUS,"UTF-8");
			} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			}
		staff = new Staff(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO,STATUS) ;
		ActionContext.getContext().put("staff", staff) ;
		return SUCCESS;
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
	public String getMGR() {
		return MGR;
	}
	public void setMGR(String mGR) {
		MGR = mGR;
	}
	public String getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE;
	}
	public String getSAL() {
		return SAL;
	}
	public void setSAL(String sAL) {
		SAL = sAL;
	}
	public String getCOMM() {
		return COMM;
	}
	public void setCOMM(String cOMM) {
		COMM = cOMM;
	}
	public String getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
}
