package Bean;

public class dept{
	private String DEPTNO ;
	private String DNAME ;
	private String LOC ;
	private String NUM ;
	
	public dept(String DEPTNO,String DNAME,String LOC){
		this.DEPTNO = DEPTNO ;
		this.DNAME = DNAME ;
		this.LOC = LOC ;
		
	}
	public dept(String DEPTNO,String DNAME,String LOC,String NUM){
		this.DEPTNO = DEPTNO ;
		this.DNAME = DNAME ;
		this.LOC = LOC ;
		this.NUM = NUM ;
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