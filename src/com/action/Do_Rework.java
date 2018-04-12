package com.action;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Do_Rework implements Action {
	private Data_con con = new Data_con() ;
	private String info ;
	private String D_info ;
	private String JOB ;
	private String DEPTNO ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date() ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		String str = df.format(date) ;
		String[] s = this.getInfo().split(" - ") ;
		String[] A = this.getD_info().split(" - ") ;
		String[] D = new String[2] ;
		String sql = "select DEPTNO,JOB from emp where EMPNO = '"+s[0]+"'" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		while(rs.next()){
			D[0] = rs.getString("DEPTNO") ;
			D[1] = rs.getString("JOB") ;
		}
		if(!this.getJOB().equals("")){
			 sql = "insert into rework(EMPNO,ENAME,FRONT_DEPTNO,NOW_DEPTNO,FRONT_JOB,NOW_JOB,REDATE) values('"+s[0]+"','"+s[1]+"','"+D[0]+"','"+A[0]+"','"+D[1]+"','"+this.getJOB()+"','"+str+"')" ;
			con.getStat().execute(sql) ;
			sql = "update emp set STATUS='在职',JOB='"+this.getJOB()+"',DEPTNO='"+A[0]+"' where EMPNO='"+s[0]+"'" ;
			con.getStat().execute(sql) ;
		}else{
			sql = "insert into rework(EMPNO,ENAME,FRONT_DEPTNO,NOW_DEPTNO,FRONT_JOB,NOW_JOB,REDATE) values('"+s[0]+"','"+s[1]+"','"+D[0]+"','"+A[0]+"','"+D[1]+"','"+D[1]+"','"+str+"')" ;
			con.getStat().execute(sql) ;
			sql = "update emp set STATUS='在职' ,DEPTNO='"+A[0]+"' where EMPNO='"+s[0]+"'" ;
			con.getStat().execute(sql) ;
		}
		return SUCCESS;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
	public String getD_info() {
		return D_info;
	}
	public void setD_info(String d_info) {
		D_info = d_info;
	}

}
