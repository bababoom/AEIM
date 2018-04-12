package com.action;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Add_Dept_Action implements Action {
	private String DEPTNO ;
	private String DNAME ;
	private String LOC ;
	
	private Data_con con = new Data_con() ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if((DNAME!=null&&(!DNAME.equals("")))&&(LOC!=null&&(!LOC.equals("")))){
			String sql = "insert into dept(DEPTNO,DNAME,LOC) values('"+this.getDEPTNO()+"','"+this.getDNAME()+"','"+this.getLOC()+"')" ;
			con.getStat().execute(sql) ;
		}else if(DNAME!=null||(!DNAME.equals(""))){
			String sql = "insert into dept(DEPTNO,DNAME) values('"+this.getDEPTNO()+"','"+this.getDNAME()+"')";
			con.getStat().execute(sql) ;
		}else if(LOC!=null||(!LOC.equals(""))){
			String sql = "insert into dept(DEPTNO,LOC) values('"+this.getDEPTNO()+"','"+this.getLOC()+"')" ;
			con.getStat().execute(sql) ;
		}else{
			String sql = "insert into dept(DEPTNO) values('"+this.getDEPTNO()+"')" ;
			con.getStat().execute(sql) ;
		}
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

}
