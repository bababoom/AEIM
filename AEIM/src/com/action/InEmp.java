package com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class InEmp implements Action {
	private String EMPNO ;
	private String ENAME ;
	private String LOC ;
	private String JOB ;
	private String HEIGHT ;
	private String WEIGHT ;
	private String BIRTH ;
	private String SAL ;
	private String TEL ;
	private String EMAIL ;
	private String GSCHOOL ;
	private String ADDRESS ;
	private String MGR ;
	private String DEPTNO ;
	private Data_con con = new Data_con() ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date() ;
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
		String str = df.format(date) ;
		String sql = "insert into inemp(EMPNO,ENAME,LOC,JOB,HEIGHT,WEIGHT,BIRTH,SAL,TEL,EMAIL,GSCHOOL,ADDRESS,INDATE,DEPTNO,MGR) values('"+this.getEMPNO()+"','"+
				this.getENAME()+"','"+this.getLOC()+"','"+this.getJOB()+"',"+this.getHEIGHT()+","+this.getWEIGHT()+",'"+this.getBIRTH()+"',"+
				this.getSAL()+",'"+this.getTEL()+"','"+this.getEMAIL()+"','"+this.getGSCHOOL()+"','"+this.getADDRESS()+"','"+
				str+"','"+this.getDEPTNO()+"','"+this.getMGR()+"')" ;
	
		con.getStat().execute(sql) ;
		String sql1 = "insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO,STATUS) values('"+this.getEMPNO()+"','"+this.getENAME()+"','"+this.getJOB()+
				"','"+this.getMGR()+"','"+str+"',"+this.getSAL()+",'"+this.getDEPTNO()+"','在职')" ;
		con.getStat().execute(sql1) ;
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
	public String getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(String hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public String getWEIGHT() {
		return WEIGHT;
	}
	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}
	public String getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(String bIRTH) {
		BIRTH = bIRTH;
	}
	public String getSAL() {
		return SAL;
	}
	public void setSAL(String sAL) {
		SAL = sAL;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setE_MAIL(String e_MAIL) {
		EMAIL = e_MAIL;
	}
	public String getGSCHOOL() {
		return GSCHOOL;
	}
	public void setGSCHOOL(String gSCHOOL) {
		GSCHOOL = gSCHOOL;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getMGR() {
		return MGR;
	}
	public void setMGR(String mGR) {
		MGR = mGR;
	}
	public String getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}

}
