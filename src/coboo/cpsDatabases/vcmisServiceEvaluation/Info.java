/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author user
 *
 */
public class Info {

	/**
	 * 
	 */
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	Date	diagTime;
    Doctor doctor;
	private Long id;
	boolean if_cardio_vascular_disease;
	boolean if_cerebral_vascular_disease;
	boolean if_respiratoryDisease;
	boolean if_standardManage;
	boolean if_gxy;	
	boolean if_tnb;
	boolean if_zl;
	List<YearService> yearServices = new ArrayList<YearService>();
	public Date getDiagTime() {
		return diagTime;
	}
	public void setDiagTime(Date diagTime) {
		this.diagTime = diagTime;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isIf_cardio_vascular_disease() {
		return if_cardio_vascular_disease;
	}
	public void setIf_cardio_vascular_disease(boolean if_cardio_vascular_disease) {
		this.if_cardio_vascular_disease = if_cardio_vascular_disease;
	}
	public boolean isIf_cerebral_vascular_disease() {
		return if_cerebral_vascular_disease;
	}
	public void setIf_cerebral_vascular_disease(boolean if_cerebral_vascular_disease) {
		this.if_cerebral_vascular_disease = if_cerebral_vascular_disease;
	}
	public boolean isIf_respiratoryDisease() {
		return if_respiratoryDisease;
	}
	public void setIf_respiratoryDisease(boolean if_respiratoryDisease) {
		this.if_respiratoryDisease = if_respiratoryDisease;
	}
	public boolean isIf_standardManage() {
		return if_standardManage;
	}
	public void setIf_standardManage(boolean if_standardManage) {
		this.if_standardManage = if_standardManage;
	}
	public boolean isIf_gxy() {
		return if_gxy;
	}
	public void setIf_gxy(boolean if_gxy) {
		this.if_gxy = if_gxy;
	}
	public boolean isIf_tnb() {
		return if_tnb;
	}
	public void setIf_tnb(boolean if_tnb) {
		this.if_tnb = if_tnb;
	}
	public boolean isIf_zl() {
		return if_zl;
	}
	public void setIf_zl(boolean if_zl) {
		this.if_zl = if_zl;
	}
	public List<YearService> getYearServices() {
		return yearServices;
	}
	public void setYearServices(List<YearService> yearServices) {
		this.yearServices = yearServices;
	}
	

}