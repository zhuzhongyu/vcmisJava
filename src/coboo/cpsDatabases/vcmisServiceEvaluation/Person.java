/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;
import java.util.Date;

/**
 * @author user
 *
 */
public class Person {
//private AcceptionRec1Info acceptionRec1Info;
private Info acceptionRec2Info;
private String address;
//child//
private Info age0t6Info;
private Date   birthDate;
private Info zlInfo;
private Info consultationRecInfo;
private Doctor CreatDoctor;
private Date CreatTime;
private String dah;
//death//
private DeathRec dealthRec;
//disable//
private Info disableRegInfo;
  

private Info disableTrainRegInfo;
// private FamilyPlanCensusInfo familyPlanCensusInfo;//计划生育普查
private Info familyPlanRegInfo;//计划生育登记

private Info gxbInfo;
//Chronic disease
private Info gxyInfo;
//EMR//
private Info healthCheckInfo;
private boolean if_HealthCheck;
//immunity//
private Info inoculationCardInfo;
private String name;
private Info nzzInfo;
//base Infomation//
private String personId;
//mental//
private Info severeMentalRegInfo;

private String sex;
private Info tnbInfo;
//woman//
private Info womenChkInfo; //妇女检查记录

//ycf//
private Info ycfInfo;
private Info respiratoryInfo;
//#################################################################
public Info getAcceptionRec2Info() {
	return acceptionRec2Info;
}
public String getAddress() {
	return address;
}
public Info getAge0t6Info() {
	return age0t6Info;
}
public Date getBirthDate() {
	return birthDate;
}

public Info getConsultationRecInfo() {
	return consultationRecInfo;
}
/**
 * @return the creatDoctor
 */
public Doctor getCreatDoctor() {
	return CreatDoctor;
}

public Date getCreatTime() {
	return CreatTime;
}
public String getDah() {
	return dah;
}
public DeathRec getDealthRec() {
	return dealthRec;
}
public Info getDisableRegInfo() {
	return disableRegInfo;
}

public Info getDisableTrainRegInfo() {
	return disableTrainRegInfo;
}
public Info getFamilyPlanRegInfo() {
	return familyPlanRegInfo;
}
public Info getGxbInfo() {
	return gxbInfo;
}
public Info getGxyInfo() {
	return gxyInfo;
}
public Info getHealthCheckInfo() {
	return healthCheckInfo;
}
public String getId() {
	return personId;
}
public Info getInoculationCardInfo() {
	return inoculationCardInfo;
}
public String getName() {
	return name;
}
public Info getNzzInfo() {
	return nzzInfo;
}
public String getPersonId() {
	return personId;
}
public Info getSevereMentalRegInfo() {
	return severeMentalRegInfo;
}

public String getSex() {
	return sex;
}
public Info getTnbInfo() {
	return tnbInfo;
}
public Info getWomenChkInfo() {
	return womenChkInfo;
}

public Info getYcfInfo() {
	return ycfInfo;
}
public boolean isIf_HealthCheck() {
	return if_HealthCheck;
}
public void setAcceptionRec2Info(AcceptionRec2Info acceptionRec2Info) {
	this.acceptionRec2Info = acceptionRec2Info;
}
public void setAcceptionRec2Info(Info acceptionRec2Info) {
	this.acceptionRec2Info = acceptionRec2Info;
}
public void setAddress(String address) {
	this.address = address;
}
public void setAge0t6Info(Age0t6Info age0t6Info) {
	this.age0t6Info = age0t6Info;
}
public void setAge0t6Info(Info age0t6Info) {
	this.age0t6Info = age0t6Info;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}

public void setConsultationRecInfo(ConsultationRecInfo consultationRecInfo) {
	this.consultationRecInfo = consultationRecInfo;
}
public void setConsultationRecInfo(Info consultationRecInfo) {
	this.consultationRecInfo = consultationRecInfo;
}
/**
 * @param creatDoctor the creatDoctor to set
 */
public void setCreatDoctor(Doctor creatDoctor) {
	CreatDoctor = creatDoctor;
}
public void setCreatTime(Date creatTime) {
	CreatTime = creatTime;
}
public void setDah(String dah) {
	this.dah = dah;
}
public void setDealthRec(DeathRec dealthRec) {
	this.dealthRec = dealthRec;
}
public void setDisableRegInfo(DisableRegInfo disableRegInfo) {
	this.disableRegInfo = disableRegInfo;
}
public void setDisableRegInfo(Info disableRegInfo) {
	this.disableRegInfo = disableRegInfo;
}

public void setDisableTrainRegInfo(Info disableTrainRegInfo) {
	this.disableTrainRegInfo = disableTrainRegInfo;
}
public void setFamilyPlanRegInfo(FamilyPlanRegInfo familyPlanRegInfo) {
	this.familyPlanRegInfo = familyPlanRegInfo;
}
public void setFamilyPlanRegInfo(Info familyPlanRegInfo) {
	this.familyPlanRegInfo = familyPlanRegInfo;
}
public void setGxbInfo(Info gxbInfo) {
	this.gxbInfo = gxbInfo;
}
public void setGxyInfo(Info gxyInfo) {
	this.gxyInfo = gxyInfo;
}
public void setHealthCheckInfo(HeathCheckInfo healthCheckInfo) {
	this.healthCheckInfo = healthCheckInfo;
}
public void setHealthCheckInfo(Info healthCheckInfo) {
	this.healthCheckInfo = healthCheckInfo;
}

public void setId(String personId) {
	this.personId = personId;
}

public void setIf_HealthCheck(boolean if_HealthCheck) {
	this.if_HealthCheck = if_HealthCheck;
}

public void setInoculationCardInfo(Info inoculationCardInfo) {
	this.inoculationCardInfo = inoculationCardInfo;
}

public void setInoculationCardInfo(InoculationCardInfo inoculationCardInfo) {
	this.inoculationCardInfo = inoculationCardInfo;
}

public void setName(String name) {
	this.name = name;
}

public void setNzzInfo(Info info) {
	this.nzzInfo = info;
}

public void setPersonId(String personId) {
	this.personId = personId;
}

public void setSevereMentalRegInfo(Info severeMentalRegInfo) {
	this.severeMentalRegInfo = severeMentalRegInfo;
}

public void setSevereMentalRegInfo(SevereMentalRegInfo severeMentalRegInfo) {
	this.severeMentalRegInfo = severeMentalRegInfo;
}


public void setSex(String sex) {
	this.sex = sex;
}

public void setTnbInfo(Info tnbInfo) {
	this.tnbInfo = tnbInfo;
}

public void setWomenChkInfo(Info womenChkInfo) {
	this.womenChkInfo = womenChkInfo;
}

public void setWomenChkInfo(WomenChkInfo womenChkInfo) {
	this.womenChkInfo = womenChkInfo;
}

public void setYcfInfo(Info ycfInfo) {
	this.ycfInfo = ycfInfo;
}

public void setYcfInfo(YcfInfo ycfInfo) {
	this.ycfInfo = ycfInfo;
}

/**
 * @return the respiratoryInfo
 */
public Info getRespiratoryInfo() {
	return respiratoryInfo;
}

/**
 * @param respiratoryInfo the respiratoryInfo to set
 */
public void setRespiratoryInfo(Info respiratoryInfo) {
	this.respiratoryInfo = respiratoryInfo;
}
/**
 * @return the zlInfo
 */
public Info getZlInfo() {
	return zlInfo;
}
/**
 * @param zlInfo the zlInfo to set
 */
public void setZlInfo(Info zlInfo) {
	this.zlInfo = zlInfo;
}

}
