package com.action;

import java.sql.ResultSet;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Update_Dept implements Action {
	private String DEPTNO ;
	private String DNAME ;
	private String LOC ;
	private Data_con con = new Data_con()  ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String name=null,loc=null ;
		ResultSet rs = con.getStat().executeQuery("select DNAME,LOC from dept where DEPTNO='"+this.getDEPTNO()+"'") ;
		
		while(rs.next()) {
			name=rs.getString("DNAME") ;
			loc = rs.getString("LOC") ;
		}
		if(name!=null&&loc!=null){
			if(name.equals(this.getDNAME())&&loc.equals(this.getLOC())) return "fail" ;
			else if(!name.equals(this.getDNAME())&&(!loc.equals(this.getLOC()))){
				String sql = "update dept set DNAME='"+this.getDNAME()+"',LOC='"+this.getLOC()+"' where DEPTNO='"+this.getDEPTNO()+"'" ;
				con.getStat().execute(sql) ;
				return SUCCESS ;
			}else if(!name.equals(this.getDNAME())&&loc.equals(this.getLOC())){
				String sql = "update dept set DNAME='"+this.getDNAME()+"' where DEPTNO='"+this.getDEPTNO()+"'" ;
				con.getStat().execute(sql) ;
				return SUCCESS ;
			}else if(name.equals(this.getDNAME())&&(!loc.equals(this.getLOC()))){
				String sql = "update dept set LOC='"+this.getLOC()+"' where DEPTNO='"+this.getDEPTNO()+"'" ;
				con.getStat().execute(sql) ;
				return SUCCESS ;
			}else return ERROR ;
		}else return ERROR ;
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
