package com.action;

import Bean.dept;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class pre_update_Dept implements Action {
	private String DEPTNO ;
	private String DNAME ;
	private String LOC ;
	private String NUM ;
	
	private dept temp ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		temp = new dept(this.getDEPTNO(),this.getDNAME(),this.getLOC(),this.getNUM()) ;
		ActionContext.getContext().put("temp", temp) ;
		return SUCCESS;
	}
	public String getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}
	public String getDNAME() {
		return DNAME;
	}
	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}
	public String getLOC() {
		return LOC;
	}
	public void setLOC(String lOC) {
		LOC = lOC;
	}
	public String getNUM() {
		return NUM;
	}
	public void setNUM(String nUM) {
		NUM = nUM;
	}

}
