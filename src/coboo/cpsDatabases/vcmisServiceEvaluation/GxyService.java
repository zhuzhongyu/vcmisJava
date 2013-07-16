package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.util.Date;


public class GxyService  extends Service{
	
	private Long id;
	boolean if_BpOK;


	String otherDeal;
	int  serviceNumberInYear;
	public GxyService() {
	}


	public Doctor getDoctor() {
		return doctor;
	}
	
	
	public Long getId() {
		return id;
	}

	
	public String getOtherDeal() {
		return otherDeal;
	}
	public int getServiceNumberInYear() {
		return serviceNumberInYear;
	}
	public Date getServiceTime() {
		return serviceTime;
	}
	public boolean isIf_BpOK() {
		return if_BpOK;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIf_BpOK(boolean if_BpOK) {
		this.if_BpOK = if_BpOK;
	}
	public void setOtherDeal(String otherDeal) {
		this.otherDeal = otherDeal;
	}
	public void setServiceNumberInYear(int serviceNumberInYear) {
		this.serviceNumberInYear = serviceNumberInYear;
	}
	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	
	
}
