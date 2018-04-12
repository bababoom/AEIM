package com.action;

import Data.Data_con;

import com.opensymphony.xwork2.Action;

public class Delete_Dept_Action implements Action {
	private String DEPTNO ;
	private Data_con con = new Data_con() ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from dept where DEPTNO='"+this.getDEPTNO()+"'" ;
		con.getStat().execute(sql) ;
		return SUCCESS;
		
	}
	public String getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}

}
