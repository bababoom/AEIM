package com.action;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Do_Move implements Action {
	private Data_con con = new Data_con() ;
	private String E_list ;
	private String D_list ;
	private String tip ;
	private String JOB ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date() ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		String str = df.format(date) ;
		String[] E = this.getE_list().split(" - ") ;
		String[] D = this.getD_list().split(" - ") ;
		String[] front = new String[2] ; 
		String sql = "select DEPTNO,JOB from emp where EMPNO='"+E[0]+"'" ;
		ResultSet rs = con.getStat().executeQuery(sql) ;
		
		while(rs.next()){
			front[0] = rs.getString("DEPTNO") ;
			front[1] = rs.getString("JOB") ;
		}
		String sql1 ="" ;
		if(!this.getJOB().trim().equals("")){
			sql = "insert into move(EMPNO,ENAME,FRONT_DEPTNO,AFTER_DEPTNO,MOVEDATE,FRONT_JOB,AFTER_JOB,TIP) values('"+E[0]+"','"+E[1]+"','"+front[0]+"','"+
					D[0]+"','"+str+"','"+front[1]+"','"+this.getJOB()+"','"+this.getTip()+"')";
			sql1 = "update emp set DEPTNO = '"+D[0]+"',JOB='"+this.getJOB().trim()+"' where EMPNO='"+E[0]+"'" ;
		}else{
			sql = "insert into move(EMPNO,ENAME,FRONT_DEPTNO,AFTER_DEPTNO,MOVEDATE,FRONT_JOB,AFTER_JOB,TIP) values('"+E[0]+"','"+E[1]+"','"+front[0]+"','"+
					D[0]+"','"+str+"','"+front[1]+"','"+front[1]+"','"+this.getTip()+"')";
			sql1 = "update emp set DEPTNO = '"+D[0]+"' where EMPNO='"+E[0]+"'" ;
		}
		con.getStat().execute(sql) ;
		con.getStat().execute(sql1) ;
		return SUCCESS ;
	}
	public String getE_list() {
		return E_list;
	}
	public void setE_list(String e_list) {
		E_list = e_list;
	}
	public String getD_list() {
		return D_list;
	}
	public void setD_list(String d_list) {
		D_list = d_list;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}

}
