package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.util.Date;

public class TnbService extends Service{

	int  serviceNumberInYear;

	boolean if_BgOK;
	boolean if_Test_BloodGlucose;
	String otherDeal;
	
	public TnbService() {
		// TODO Auto-generated constructor stub
	}

	public int getServiceNumberInYear() {
		return serviceNumberInYear;
	}
	public void setServiceNumberInYear(int serviceNumberInYear) {
		this.serviceNumberInYear = serviceNumberInYear;
	}
	public Date getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}
	public boolean isIf_BgOK() {
		return if_BgOK;
	}
	public void setIf_BgOK(boolean if_BgOK) {
		this.if_BgOK = if_BgOK;
	}
	public boolean isIf_Test_BloodGlucose() {
		return if_Test_BloodGlucose;
	}
	public void setIf_Test_BloodGlucose(boolean if_Test_BloodGlucose) {
		this.if_Test_BloodGlucose = if_Test_BloodGlucose;
	}
	public String getOtherDeal() {
		return otherDeal;
	}
	public void setOtherDeal(String otherDeal) {
		this.otherDeal = otherDeal;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
