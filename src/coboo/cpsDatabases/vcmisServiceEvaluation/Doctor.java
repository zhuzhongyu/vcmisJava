package coboo.cpsDatabases.vcmisServiceEvaluation;

public class Doctor {
String DoctorId;
String DoctorName;
Org org;
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public String getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}

}
