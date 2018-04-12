package Bean;

public class Staff {
		private String EMPNO ;
		private String ENAME ;
		private String JOB ;
		private String MGR ;
		private String HIREDATE ;
		private String SAL ;
		private String COMM ;
		private String DEPTNO ;
		private String STATUS ;
		public Staff(String EMPNO,String ENAME,String JOB,String MGR,String HIREDATE,String SAL,String COMM,String DEPTNO,String STATUS){
			this.EMPNO = EMPNO ;
			this.ENAME = ENAME ;
			this.JOB = JOB ;
			this.MGR = MGR ;
			this.HIREDATE = HIREDATE ;
			this.SAL = SAL ;
			this.COMM = COMM ;
			this.DEPTNO = DEPTNO ;
			this.STATUS = STATUS ;
			
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
