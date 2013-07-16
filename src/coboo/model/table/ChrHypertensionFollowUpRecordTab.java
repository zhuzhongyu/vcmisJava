package coboo.model.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Doctor;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxyInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxyService;
import coboo.cpsDatabases.vcmisServiceEvaluation.Info;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.cpsDatabases.vcmisServiceEvaluation.YearService;
import coboo.impl.DocDriver.meta.DocCodeMeta;
import coboo.impl.DocDriver.meta.FirstTimeAdverseDrugReactionsMeta;
import coboo.impl.DocDriver.meta.FirstTimeAuxiliaryExaminationMeta;
import coboo.impl.DocDriver.meta.FirstTimeBloodPressureMeta;
import coboo.impl.DocDriver.meta.FirstTimeBodyMassIndexMeta;
import coboo.impl.DocDriver.meta.FirstTimeDateOfNextFollowUpMeta;
import coboo.impl.DocDriver.meta.FirstTimeDrinkingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.FirstTimeDrugComplianceMeta;
import coboo.impl.DocDriver.meta.FirstTimeDrugUseMeta;
import coboo.impl.DocDriver.meta.FirstTimeFollowUpClassificationMeta;
import coboo.impl.DocDriver.meta.FirstTimeFollowUpDateMeta;
import coboo.impl.DocDriver.meta.FirstTimeFollowUpMethodsMeta;
import coboo.impl.DocDriver.meta.FirstTimeFollowUpPhysicianSignatureMeta;
import coboo.impl.DocDriver.meta.FirstTimeHeartRateMeta;
import coboo.impl.DocDriver.meta.FirstTimePsychologicalAdjustmentMeta;
import coboo.impl.DocDriver.meta.FirstTimeReferralInstitutionsAndDepartmentsMeta;
import coboo.impl.DocDriver.meta.FirstTimeReferralReasonMeta;
import coboo.impl.DocDriver.meta.FirstTimeSaltIntakeCaseMeta;
import coboo.impl.DocDriver.meta.FirstTimeSignsOthersMeta;
import coboo.impl.DocDriver.meta.FirstTimeSmokingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.FirstTimeSportsMeta;
import coboo.impl.DocDriver.meta.FirstTimeSymptomsMeta;
import coboo.impl.DocDriver.meta.FirstTimeTreatmentComplianceMeta;
import coboo.impl.DocDriver.meta.FirstTimeWeightMeta;
import coboo.impl.DocDriver.meta.FourthTimeAdverseDrugReactionsMeta;
import coboo.impl.DocDriver.meta.FourthTimeAuxiliaryExaminationMeta;
import coboo.impl.DocDriver.meta.FourthTimeBloodPressureMeta;
import coboo.impl.DocDriver.meta.FourthTimeBodyMassIndexMeta;
import coboo.impl.DocDriver.meta.FourthTimeDateOfNextFollowUpMeta;
import coboo.impl.DocDriver.meta.FourthTimeDrinkingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.FourthTimeDrugComplianceMeta;
import coboo.impl.DocDriver.meta.FourthTimeDrugUseMeta;
import coboo.impl.DocDriver.meta.FourthTimeFollowUpClassificationMeta;
import coboo.impl.DocDriver.meta.FourthTimeFollowUpDateMeta;
import coboo.impl.DocDriver.meta.FourthTimeFollowUpMethodsMeta;
import coboo.impl.DocDriver.meta.FourthTimeFollowUpPhysicianSignatureMeta;
import coboo.impl.DocDriver.meta.FourthTimeHeartRateMeta;
import coboo.impl.DocDriver.meta.FourthTimePsychologicalAdjustmentMeta;
import coboo.impl.DocDriver.meta.FourthTimeReferralInstitutionsAndDepartmentsMeta;
import coboo.impl.DocDriver.meta.FourthTimeReferralReasonMeta;
import coboo.impl.DocDriver.meta.FourthTimeSaltIntakeCaseMeta;
import coboo.impl.DocDriver.meta.FourthTimeSignsOthersMeta;
import coboo.impl.DocDriver.meta.FourthTimeSmokingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.FourthTimeSportsMeta;
import coboo.impl.DocDriver.meta.FourthTimeSymptomsMeta;
import coboo.impl.DocDriver.meta.FourthTimeTreatmentComplianceMeta;
import coboo.impl.DocDriver.meta.FourthTimeWeightMeta;
import coboo.impl.DocDriver.meta.Meta;
import coboo.impl.DocDriver.meta.NameMeta;
import coboo.impl.DocDriver.meta.SecondTimeAdverseDrugReactionsMeta;
import coboo.impl.DocDriver.meta.SecondTimeAuxiliaryExaminationMeta;
import coboo.impl.DocDriver.meta.SecondTimeBloodPressureMeta;
import coboo.impl.DocDriver.meta.SecondTimeBodyMassIndexMeta;
import coboo.impl.DocDriver.meta.SecondTimeDateOfNextFollowUpMeta;
import coboo.impl.DocDriver.meta.SecondTimeDrinkingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.SecondTimeDrugComplianceMeta;
import coboo.impl.DocDriver.meta.SecondTimeDrugUseMeta;
import coboo.impl.DocDriver.meta.SecondTimeFollowUpClassificationMeta;
import coboo.impl.DocDriver.meta.SecondTimeFollowUpDateMeta;
import coboo.impl.DocDriver.meta.SecondTimeFollowUpMethodsMeta;
import coboo.impl.DocDriver.meta.SecondTimeFollowUpPhysicianSignatureMeta;
import coboo.impl.DocDriver.meta.SecondTimeHeartRateMeta;
import coboo.impl.DocDriver.meta.SecondTimePsychologicalAdjustmentMeta;
import coboo.impl.DocDriver.meta.SecondTimeReferralInstitutionsAndDepartmentsMeta;
import coboo.impl.DocDriver.meta.SecondTimeReferralReasonMeta;
import coboo.impl.DocDriver.meta.SecondTimeSaltIntakeCaseMeta;
import coboo.impl.DocDriver.meta.SecondTimeSignsOthersMeta;
import coboo.impl.DocDriver.meta.SecondTimeSmokingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.SecondTimeSportsMeta;
import coboo.impl.DocDriver.meta.SecondTimeSymptomsMeta;
import coboo.impl.DocDriver.meta.SecondTimeTreatmentComplianceMeta;
import coboo.impl.DocDriver.meta.SecondTimeWeightMeta;
import coboo.impl.DocDriver.meta.ThirdTimeAdverseDrugReactionsMeta;
import coboo.impl.DocDriver.meta.ThirdTimeAuxiliaryExaminationMeta;
import coboo.impl.DocDriver.meta.ThirdTimeBloodPressureMeta;
import coboo.impl.DocDriver.meta.ThirdTimeBodyMassIndexMeta;
import coboo.impl.DocDriver.meta.ThirdTimeDateOfNextFollowUpMeta;
import coboo.impl.DocDriver.meta.ThirdTimeDrinkingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.ThirdTimeDrugComplianceMeta;
import coboo.impl.DocDriver.meta.ThirdTimeDrugUseMeta;
import coboo.impl.DocDriver.meta.ThirdTimeFollowUpClassificationMeta;
import coboo.impl.DocDriver.meta.ThirdTimeFollowUpDateMeta;
import coboo.impl.DocDriver.meta.ThirdTimeFollowUpMethodsMeta;
import coboo.impl.DocDriver.meta.ThirdTimeFollowUpPhysicianSignatureMeta;
import coboo.impl.DocDriver.meta.ThirdTimeHeartRateMeta;
import coboo.impl.DocDriver.meta.ThirdTimePsychologicalAdjustmentMeta;
import coboo.impl.DocDriver.meta.ThirdTimeReferralInstitutionsAndDepartmentsMeta;
import coboo.impl.DocDriver.meta.ThirdTimeReferralReasonMeta;
import coboo.impl.DocDriver.meta.ThirdTimeSaltIntakeCaseMeta;
import coboo.impl.DocDriver.meta.ThirdTimeSignsOthersMeta;
import coboo.impl.DocDriver.meta.ThirdTimeSmokingVolumeOfEveryDayMeta;
import coboo.impl.DocDriver.meta.ThirdTimeSportsMeta;
import coboo.impl.DocDriver.meta.ThirdTimeSymptomsMeta;
import coboo.impl.DocDriver.meta.ThirdTimeTreatmentComplianceMeta;
import coboo.impl.DocDriver.meta.ThirdTimeWeightMeta;

/**
 * 慢性病：高血压患者随访服务记录表
 * 
 * @author WangZhendong
 */
public class ChrHypertensionFollowUpRecordTab extends Table {
	Date[]				visitTime		= new Date[4];
	String[]			doctorId		= new String[4];
	Doctor[]			doctors			= new Doctor[4];
	boolean[]			Bp				= new boolean[4];
	boolean[]			drugReaction	= new boolean[4];
	Meta[]				metas			= { new NameMeta(), // 姓名
			new DocCodeMeta(),// 编号
			// 第一次
			new FirstTimeFollowUpDateMeta(),// 随访日期
			new FirstTimeFollowUpMethodsMeta(),// 随访方式
			new FirstTimeSymptomsMeta(),// 症状
			new FirstTimeBloodPressureMeta(),// 血压
			new FirstTimeWeightMeta(),// 体重
			new FirstTimeBodyMassIndexMeta(),// 体质指数
			new FirstTimeHeartRateMeta(),// 心率
			new FirstTimeSignsOthersMeta(),// 体征--其他
			new FirstTimeSmokingVolumeOfEveryDayMeta(),// 日吸烟量
			new FirstTimeDrinkingVolumeOfEveryDayMeta(),// 日饮酒量
			new FirstTimeSportsMeta(),// 运动
			new FirstTimeSaltIntakeCaseMeta(),// 摄盐情况
			new FirstTimePsychologicalAdjustmentMeta(),// 心理调整
			new FirstTimeTreatmentComplianceMeta(),// 遵医行为
			new FirstTimeAuxiliaryExaminationMeta(),// 辅助检查
			new FirstTimeDrugComplianceMeta(),// 药物依从性
			new FirstTimeAdverseDrugReactionsMeta(),// 药物不良反应
			new FirstTimeFollowUpClassificationMeta(),// 此次随访分类
			new FirstTimeDrugUseMeta(),// 用药情况
			new FirstTimeReferralReasonMeta(),// 转诊--原因
			new FirstTimeReferralInstitutionsAndDepartmentsMeta(),// 转诊--机构及科室
			new FirstTimeDateOfNextFollowUpMeta(),// 下次随访日期
			new FirstTimeFollowUpPhysicianSignatureMeta(),// 随访医生签名
			// 第二次
			new SecondTimeFollowUpDateMeta(), // 随访日期
			new SecondTimeFollowUpMethodsMeta(),// 随访方式
			new SecondTimeSymptomsMeta(),// 症状
			new SecondTimeBloodPressureMeta(),// 血压
			new SecondTimeWeightMeta(),// 体重
			new SecondTimeBodyMassIndexMeta(),// 体质指数
			new SecondTimeHeartRateMeta(),// 心率
			new SecondTimeSignsOthersMeta(),// 体征--其他
			new SecondTimeSmokingVolumeOfEveryDayMeta(),// 日吸烟量
			new SecondTimeDrinkingVolumeOfEveryDayMeta(),// 日饮酒量
			new SecondTimeSportsMeta(),// 运动
			new SecondTimeSaltIntakeCaseMeta(),// 摄盐情况
			new SecondTimePsychologicalAdjustmentMeta(),// 心理调整
			new SecondTimeTreatmentComplianceMeta(),// 遵医行为
			new SecondTimeAuxiliaryExaminationMeta(),// 辅助检查
			new SecondTimeDrugComplianceMeta(),// 药物依从性
			new SecondTimeAdverseDrugReactionsMeta(),// 药物不良反应
			new SecondTimeFollowUpClassificationMeta(),// 此次随访分类
			new SecondTimeDrugUseMeta(),// 用药情况
			new SecondTimeReferralReasonMeta(),// 转诊--原因
			new SecondTimeReferralInstitutionsAndDepartmentsMeta(),// 转诊--机构及科室
			new SecondTimeDateOfNextFollowUpMeta(),// 下次随访日期
			new SecondTimeFollowUpPhysicianSignatureMeta(),// 随访医生签名
			// 第三次
			new ThirdTimeFollowUpDateMeta(), // 随访日期
			new ThirdTimeFollowUpMethodsMeta(),// 随访方式
			new ThirdTimeSymptomsMeta(),// 症状
			new ThirdTimeBloodPressureMeta(),// 血压
			new ThirdTimeWeightMeta(),// 体重
			new ThirdTimeBodyMassIndexMeta(),// 体质指数
			new ThirdTimeHeartRateMeta(),// 心率
			new ThirdTimeSignsOthersMeta(),// 体征--其他
			new ThirdTimeSmokingVolumeOfEveryDayMeta(),// 日吸烟量
			new ThirdTimeDrinkingVolumeOfEveryDayMeta(),// 日饮酒量
			new ThirdTimeSportsMeta(),// 运动
			new ThirdTimeSaltIntakeCaseMeta(),// 摄盐情况
			new ThirdTimePsychologicalAdjustmentMeta(),// 心理调整
			new ThirdTimeTreatmentComplianceMeta(),// 遵医行为
			new ThirdTimeAuxiliaryExaminationMeta(),// 辅助检查
			new ThirdTimeDrugComplianceMeta(),// 药物依从性
			new ThirdTimeAdverseDrugReactionsMeta(),// 药物不良反应
			new ThirdTimeFollowUpClassificationMeta(),// 此次随访分类
			new ThirdTimeDrugUseMeta(),// 用药情况
			new ThirdTimeReferralReasonMeta(),// 转诊--原因
			new ThirdTimeReferralInstitutionsAndDepartmentsMeta(),// 转诊--机构及科室
			new ThirdTimeDateOfNextFollowUpMeta(),// 下次随访日期
			new ThirdTimeFollowUpPhysicianSignatureMeta(),// 随访医生签名
			// 第四次
			new FourthTimeFollowUpDateMeta(), // 随访日期
			new FourthTimeFollowUpMethodsMeta(),// 随访方式
			new FourthTimeSymptomsMeta(),// 症状
			new FourthTimeBloodPressureMeta(),// 血压
			new FourthTimeWeightMeta(),// 体重
			new FourthTimeBodyMassIndexMeta(),// 体质指数
			new FourthTimeHeartRateMeta(),// 心率
			new FourthTimeSignsOthersMeta(),// 体征--其他
			new FourthTimeSmokingVolumeOfEveryDayMeta(),// 日吸烟量
			new FourthTimeDrinkingVolumeOfEveryDayMeta(),// 日饮酒量
			new FourthTimeSportsMeta(),// 运动
			new FourthTimeSaltIntakeCaseMeta(),// 摄盐情况
			new FourthTimePsychologicalAdjustmentMeta(),// 心理调整
			new FourthTimeTreatmentComplianceMeta(),// 遵医行为
			new FourthTimeAuxiliaryExaminationMeta(),// 辅助检查
			new FourthTimeDrugComplianceMeta(),// 药物依从性
			new FourthTimeAdverseDrugReactionsMeta(),// 药物不良反应
			new FourthTimeFollowUpClassificationMeta(),// 此次随访分类
			new FourthTimeDrugUseMeta(),// 用药情况
			new FourthTimeReferralReasonMeta(),// 转诊--原因
			new FourthTimeReferralInstitutionsAndDepartmentsMeta(),// 转诊--机构及科室
			new FourthTimeDateOfNextFollowUpMeta(),// 下次随访日期
			new FourthTimeFollowUpPhysicianSignatureMeta(),// 随访医
										};
	private String		Rpath			= "E/A";
	private String[]	Keys			= { "gxy" };
	private String[]	Values			= { "true" };
	private int			visitNo;
	private String		name;

	// =========================================================================================
	Date StrToDate(String s) {
		SimpleDateFormat sdf;
		if (s.contains("-")) {
			sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		} else if (s.contains("/")) {
			sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		} else {
			sdf = new java.text.SimpleDateFormat("yyyyMMdd");
		}
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	// ----------------------------------------------------------------------------------------
	void iniObjects() throws ParseException {
		for (Meta m : metas) {
			// if (m.getClass().getSimpleName().equals("NameMeta")){
			// this.name=m.getHValue();
			// }
			// time
			if (m.getClass().getSimpleName().equals("FirstTimeFollowUpDateMeta")) {
				this.visitTime[0] = StrToDate(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("SecondTimeFollowUpDateMeta")) {
				this.visitTime[1] = StrToDate(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("ThirdTimeFollowUpDateMeta")) {
				this.visitTime[2] = StrToDate(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("FourthTimeFollowUpDateMeta")) {
				this.visitTime[3] = StrToDate(m.getHValue());

			}
			// blood pression
			else if (m.getClass().getSimpleName().equals("FirstTimeBloodPressureMeta")) {
				this.Bp[0] = ifBpOK(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("SecondTimeBloodPressureMeta")) {
				this.Bp[1] = ifBpOK(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("ThirdTimeBloodPressureMeta")) {
				this.Bp[2] = ifBpOK(m.getHValue());
			} else if (m.getClass().getSimpleName().equals("FourthTimeBloodPressureMeta")) {
				this.Bp[3] = ifBpOK(m.getHValue());
			}
			// doctor
			else if (m.getClass().getSimpleName().equals("FirstTimeFollowUpPhysicianSignatureMeta")) {
				this.doctorId[0] = m.getHValue();
			} else if (m.getClass().getSimpleName().equals("SecondTimeFollowUpPhysicianSignatureMeta")) {
				this.doctorId[1] = m.getHValue();
			} else if (m.getClass().getSimpleName().equals("ThirdTimeFollowUpPhysicianSignatureMeta")) {
				this.doctorId[2] = m.getHValue();
			} else if (m.getClass().getSimpleName().equals("FourthTimeFollowUpPhysicianSignatureMeta")) {
				this.doctorId[3] = m.getHValue();
			}
			// drug reaction
			else if (m.getClass().getSimpleName().equals("FirstTimeAdverseDrugReactionsMeta")) {
				this.drugReaction[0] = m.getSValues()[0].equals("1") ? true : false;
			} else if (m.getClass().getSimpleName().equals("SecondTimeAdverseDrugReactionsMeta")) {
				this.drugReaction[1] = m.getSValues()[0].equals("1") ? true : false;
			} else if (m.getClass().getSimpleName().equals("ThirdTimeAdverseDrugReactionsMeta")) {
				this.drugReaction[2] = m.getSValues()[0].equals("1") ? true : false;
			} else if (m.getClass().getSimpleName().equals("FourthTimeAdverseDrugReactionsMeta")) {
				this.drugReaction[3] = m.getSValues()[0].equals("1") ? true : false;
			}

		}
	}

	private boolean ifBpOK(String HValues) {
		String[] tmp = HValues.split("\\D", 2);
		boolean lok = tmp[0].compareTo("90") < 0;
		boolean hok = tmp[1].compareTo("140") < 0;
		if (lok && hok) {
			return true;
		} else {
			return false;
		}
	}

	// decide which GxyService is Current Service
	private GxyService getGxyService() {
		this.visitNo = 0;
		for (int i = 0; i < this.visitTime.length; i++) {
			if (visitTime[i] != null) {
				this.visitNo = i;
			}
		}
		GxyService gxyService = new GxyService();

		doctors[visitNo] = new Doctor();
		doctors[visitNo].setDoctorId(this.doctorId[visitNo]);
		gxyService.setId(System.nanoTime());
		gxyService.setDoctor(doctors[visitNo]);
		Bp[visitNo] = Bp[visitNo] & this.drugReaction[visitNo];
		gxyService.setIf_BpOK(this.Bp[visitNo]);
		// gxyService.setOtherDeal(otherDeal);
		gxyService.setServiceNumberInYear(visitNo + 1);
		gxyService.setServiceTime(this.visitTime[visitNo]);
		return gxyService;
	}

	/******************************************************************************************
	 * 
	 * this is the method that we need implement
	 * @return 
	 * 
	 * 
	 *******************************************************************************************/
	public void save() {
		try {
			this.iniObjects();
			GxyService currentService = getGxyService();
			CompassSession session = new CobooCompass().getCompass().openSession();
			CompassTransaction tx = session.beginLocalTransaction();
			Person person = null;
			CompassHits hits = session.find("ResidentpersonId:" + this.personId.getHValue());
			if (hits.length() > 0) {
				CompassHit hit = hits.hit(0);
				person = (Person) hit.getData();
			} else {
				return;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.visitTime[visitNo]);
			String StrYear = String.valueOf(cal.get(Calendar.YEAR));

			Info gxyInfo = person.getGxyInfo();
			List<YearService> servicesOfYear = new ArrayList<YearService>();
			if (gxyInfo == null) {
				Info Info = new GxyInfo();
				Info.setIf_gxy(true);
				Info.setDiagTime(new Date());
				person.setGxyInfo(Info);
				gxyInfo = Info;
			} // else {
			
			servicesOfYear = gxyInfo.getYearServices();
			boolean found = false;
			for (YearService ys : servicesOfYear) {
				if (ys.getYear().equals(StrYear)) {
					found = true;
					GxyService[] gxyServices = ys.getServicesOfYear();
					gxyServices[visitNo] = currentService;
					break;
				}

			}
			if (!found) {
				YearService newYs = new YearService();
				newYs.setYear(StrYear);
				GxyService[] gxyServices = newYs.getServicesOfYear();
				for (int i = 0; i < gxyServices.length; i++) {
					gxyServices[i] = new GxyService();
					gxyServices[i].setId(System.nanoTime());
				}
				gxyServices[visitNo] = currentService;
				servicesOfYear.add(newYs);

			}
			// }
			gxyInfo.setYearServices(servicesOfYear);
			person.setGxyInfo(gxyInfo);

			// session.save(this.doctors[this.visitNo]);
			// gxyInfo.setId(System.nanoTime());

			session.save(currentService);
			session.save(person);
			tx.commit();
			session.close();
			super.saveFile(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}

	/**
	 * @return the values
	 */
	public String[] getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(String[] values) {
		Values = values;
	}

	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
		return metas;
	}

	/**
	 * @param metas the metas to set
	 */
	public void setMetas(Meta[] metas) {
		this.metas = metas;
	}

	/**
	 * @return the rpath
	 */
	public String getRpath() {
		return Rpath;
	}

	/**
	 * @param rpath the rpath to set
	 */
	public void setRpath(String rpath) {
		Rpath = rpath;
	}

}
