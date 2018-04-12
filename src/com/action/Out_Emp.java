package com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Out_Emp implements Action {
	private Data_con con = new Data_con() ;
	private String info ;
	private String reason ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date() ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd") ;
		String str = df.format(date) ;
		String[] s = this.getInfo().split(" - ") ;
		String sql = "insert into outemp(EMPNO,ENAME,OUTDATE,REASON) values('"+s[0]+"','"+s[1]+"','"+str+"','"+this.getReason()+"')" ;
		con.getStat().execute(sql) ;
		String sql1 = "update emp set STATUS='已离职' where EMPNO='"+s[0]+"'" ;
		con.getStat().execute(sql1) ;
		return SUCCESS ;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
