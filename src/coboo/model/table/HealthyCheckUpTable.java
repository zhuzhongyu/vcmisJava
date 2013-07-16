package coboo.model.table;

import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.impl.DocDriver.meta.*;

/**
 * 健康体检表
 * 
 * @author ghy
 * 
 */

public class HealthyCheckUpTable extends Table {
	Meta[] metas = { 
        	new NameMeta(),// 姓名
			new DocCodeMeta(),// 编号
			new CheckUpDateMeta(),// 体检日期
			new DoctorMeta(),// 责任医师
			new SymptomsMeta(),// 症状
			new TemperatureMeta(),// 一般状况--体温
			new PulseMeta(),// 一般状况--心率
			new BreathingMeta(),// 一般状况--呼吸频率
			new BloodPressureMeta(),// 一般状况--血压
			new HightMeta(),// 一般状况--身高
			new WeightMeta(),// 一般状况--体重
			new WaistlineMeta(),// 一般状况--腰围
			new ElderlyCognitiveMeta(),// 一般状况--老年人认知功能
			new ElderlyEmotionalStateMeta(),// 一般状况--老年人情感状态
			new PhysicalExerciseMeta(),// 生活方式--体育锻炼
			new EatingHabitsMeta(),// 生活方式--饮食习惯
			new SmokingMeta(),// 生活方式--吸烟情况
			new DrinkingMeta(),// 生活方式--饮酒情况
			new OccupationExposuresMeta(),// 生活方式--职业暴露情况
			new OralMeta(),// 脏器功能--口腔
			new VisionMeta(),// 脏器功能--视力
			new ListeningMeta(),// 脏器功能--听力
			new MovementMeta(),// 脏器功能--运动功能
			new FundusMeta(),//眼底
			new SkinMeta(),// 查体--皮肤
			new ScleraMeta(),// 查体--巩膜
			new LymphNodeMeta(),// 查体--淋巴结
			new LungMeta(),// 查体--肺
			new HeartMeta(),// 查体--心脏
			new AbdominalMeta(),// 查体--腹部
			new LegEdemaMeta(),// 查体--下肢水肿
			new FootDorsumArteryMeta(),// 查体--足背动脉搏动
			new RectalTouchMeta(),// 查体--肛门指诊
			new BreastMeta(),// 查体--乳腺
			new VulvaeMeta(),// 妇科--外阴
			new VaginalMeta(),// 妇科--阴道
			new CervicalMeta(),// 妇科--宫颈
			new UterineBodyMeta(),// 妇科--宫体
			new AdnexitisMeta(),// 妇科--附件
			new PhysicalExaminationOrtherMeta(),// 查体-其他
			new RoutineBloodMeta(),// 辅助检查--血常规
			new RoutineUrineMeta(),// 辅助检查--尿常规
			new FastingGlucoseMeta(),// 辅助检查--空腹血糖
			new ElectrocardiogramMeta(),// 辅助检查--心电图			
			new MicroalbuminuriaMeta(),// 辅助检查--尿微量白蛋白
			new FecalOccultBloodMeta(),// 辅助检查--大便潜血
			new GlycatedHemoglobinMeta(),// 辅助检查--糖化血红蛋白
			new HBsAntigenMeta(),// 辅助检查--乙型肝炎表面抗原
			new LiverFunctionMeta(),// 辅助检查--肝功能
			new RenalFunctionMeta(),// 辅助检查--肾功能
			new LipidMeta(),// 辅助检查--血脂
			new ChestXrayMeta(),// 辅助检查--胸部X线片
			new BSonographyMeta(),// 辅助检查--B超
			new CervixSmearMeta(),// 辅助检查--宫颈涂片
			new AuxiliaryExaminationOrtherMeta(),// 辅助检查--其他
			new PingHeZhiMeta(),// 中医体质辨识--平和质
			new QiXuZhiMeta(),// 中医体质辨识--气虚质
			new YangXuZhiMeta(),// 中医体质辨识--阳虚质
			new YinXuZhiMeta(),// 中医体质辨识--阴虚质
			new DanSiZhiMeta(),// 中医体质辨识--淡湿质
			new SiReZhiMeta(),// 中医体质辨识--湿热质
			new XueYuZhiMeta(),// 中医体质辨识--血淤质
			new QiYuZhiMeta(),// 中医体质辨识--气郁质
			new TeBingZhiMeta(),// 中医体质辨识--特秉质
			new CerebrovascularDiseaseMeta(),// 现存主要健康问题--脑血管疾病
			new KidneyDiseaseMeta(),// 现存主要健康问题--肾脏疾病
			new HeartDiseaseMeta(),// 现存主要健康问题--心脏疾病
			new VascularDiseaseMeta(),// 现存主要健康问题--血管疾病
			new EyeDiseasesMeta(),// 现存主要健康问题--眼部疾病
			new MentalDiseasesMeta(),// 现存主要健康问题--神经系统疾病
			new OrtherDiseasesMeta(),// 现存主要健康问题--其他系统疾病
			new HospitalizationHistoryMeta(),// 住院治疗情况--住院史
			new DomesticSickbedHistoryMeta(),// 住院治疗情况--家庭病床史
			new Drug1Meta(),// 主要用药情况--药物1
			new Drug2Meta(),// 主要用药情况--药物2
			new Drug3Meta(),// 主要用药情况--药物3
			new Drug4Meta(),// 主要用药情况--药物4
			new Drug5Meta(),// 主要用药情况--药物5
			new Drug6Meta(),// 主要用药情况--药物6
			new Vaccination1Meta(),// 非免疫规划预防接种史-接种1
			new Vaccination2Meta(),// 非免疫规划预防接种史-接种2
			new Vaccination3Meta(),// 非免疫规划预防接种史-接种3
			new HealthAssessmentMeta(),// 健康评价
			new HealthGuideMeta(),// 健康指导
			new RiskFactorsControlMeta(),// 危险因素控制
        	new PhysiqueIndexesMeta(),//体质指数
        	
        	new ElderlySelfAssessmentOfHealthStatusMeta(),//老年人健康状态自我评估
        	new SelfAssessmentOfTheElderlyLlivingSkillsMeta(),//老年人生活自理能力自我评估
        	new NervousSystemDiseasesMeta()//神经系统疾病
	};
	private String Rpath="B";
	private String[] Keys={"HealthyCheckUpTable"};
	private String[] Values={"true"};
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
	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassHits hits = session.find("ResidentpersonId:" + personId.getHValue());
		if (hits.length() !=1 ) {
		System.out.print("no this peron object,or peron number too many");
			return;
		}
			CompassHit hit = hits.hit(0);
			Person person = (Person) hit.getData();
			person.setIf_HealthCheck(true);
			session.save(person);
			tx.commit();
			session.close();
			super.saveFile(this);
	}


}