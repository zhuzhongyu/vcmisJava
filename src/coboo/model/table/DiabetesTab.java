package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 糖尿病
 * 
 * @author rp
 */

public class DiabetesTab extends Table {
	Meta[] metas = {
			new NameMeta(), 
			new DocCodeMeta(),
			new TheFirstFollowUpDate1(),//第一次随访时间
			new TheFirstFollowUpDate2(),//第2次随访时间
			new TheFirstFollowUpDate3(),//第3次随访时间
			new TheFirstFollowUpDate4(),//第4次随访时间
			new TheFirstFollowUpMode1(),//第一次随访方式
			new TheFirstFollowUpMode2(),//第2次随访方式
			new TheFirstFollowUpMode3(),//第3次随访方式
			new TheFirstFollowUpMode4(),//第4次随访方式
			new TheFirstFollowUpSymptoms1(),//第一次症状
			new TheFirstFollowUpSymptoms2(),//第2次症状
			new TheFirstFollowUpSymptoms3(), //第3次症状
			new TheFirstFollowUpSymptoms4(),//第4次症状
			new TheFirstFollowUpSymptomsOthor1(),//第一次症状其他
			new TheFirstFollowUpSymptomsOthor2(),//第2次症状其他
			new TheFirstFollowUpSymptomsOthor3(),//第3次症状其他
			new TheFirstFollowUpSymptomsOthor4(), //第4次症状其他
			new Low1(),//1血压左
			new Low2(),//2血压左
			new Low3(),//3血压左
			new Low4(),//4血压左
			new High1(),//1血压右
			new High2(),//2血压右
			new High3(),//3血压右
			new High4(),//4血压右
			new WeightLeft1(), //1体重左
			new WeightLeft2(),//2体重左
			new WeightLeft3(), //3体重左
			new WeightLeft4(), //4体重左
			new WeightRight1(),//1体重右
			new WeightRight2(),//2体重右
			new WeightRight3(),//3体重右
			new WeightRight4(),//4体重右
			new BodyMassIndex1(),//1体质指数
			new BodyMassIndex2(),//2体质指数
			new BodyMassIndex3(),//3体质指数
			new BodyMassIndex4(),//4体质指数
			new DorsalisPedisArteryPulse1(),//1足背动脉搏动
			new DorsalisPedisArteryPulse2(),//2足背动脉搏动
			new DorsalisPedisArteryPulse3(),//3足背动脉搏动
			new DorsalisPedisArteryPulse4(),//4足背动脉搏动
			new OtherSigns1(),//1其他
			new OtherSigns2(),//2其他
			new OtherSigns3(),//3其他
			new OtherSigns4(),//4其他
			new OnSmokingLeft1(), 
			new OnSmokingLeft2(), 
			new OnSmokingLeft3(),
			new OnSmokingLeft4(), 
			new OnSmokingRight1(), 
			new OnSmokingRight2(),
			new OnSmokingRight3(), 
			new OnSmokingRight4(),
			new OnAlcoholConsumptionLeft1(), 
			new OnAlcoholConsumptionLeft2(),
			new OnAlcoholConsumptionLeft3(), 
			new OnAlcoholConsumptionLeft4(),
			new OnAlcoholConsumptionRight1(), 
			new OnAlcoholConsumptionRight2(),
			new OnAlcoholConsumptionRight3(), 
			new OnAlcoholConsumptionRight4(),
			new MovementTimesWeekUp1(), 
			new MovementTimesWeekUp2(),
			new MovementTimesWeekUp3(), 
			new MovementTimesWeekUp4(),
			new MovementPointsSecondUp1(), 
			new MovementPointsSecondUp2(),
			new MovementPointsSecondUp3(), 
			new MovementPointsSecondUp4(),
			new MovementTimesWeekDown1(), 
			new MovementTimesWeekDown2(),
			new MovementTimesWeekDown3(), 
			new MovementTimesWeekDown4(),
			new MovementPointsSecondDown1(), 
			new MovementPointsSecondDown2(),
			new MovementPointsSecondDown3(), 
			new MovementPointsSecondDown4(),
			new StapleLeft1(), 
			new StapleLeft2(), 
			new StapleLeft3(),
			new StapleLeft4(), 
			new StapleRight1(), 
			new StapleRight2(),
			new StapleRight3(), 
			new StapleRight4(),
			new PsychologicalAdjustment1(), 
			new PsychologicalAdjustment2(),
			new PsychologicalAdjustment3(), 
			new PsychologicalAdjustment4(),
			new TreatmentCompliance1(), 
			new TreatmentCompliance2(),
			new TreatmentCompliance3(), 
			new TreatmentCompliance4(),
			new FastingGlucose1(), 
			new FastingGlucose2(),
			new FastingGlucose3(), 
			new FastingGlucose4(),
			new GlycatedHemoglobin1(), 
			new GlycatedHemoglobin2(),
			new GlycatedHemoglobin3(), 
			new GlycatedHemoglobin4(),
			new InspectionDate1(), 
			new InspectionDate2(),
			new InspectionDate3(), 
			new InspectionDate4(),
			new OtherChecksOther1(), 
			new OtherChecksOther2(),
			new OtherChecksOther3(), 
			
			new OtherChecksOther4(),
			new DrugCompliance1(), 
			new DrugCompliance2(),
			new DrugCompliance3(), 
			new DrugCompliance4(),
			new AdverseDrugReactions1(), 
			new AdverseDrugReactions2(),
			new AdverseDrugReactions3(), 
			new AdverseDrugReactions4(),
			
			new TheFollowUpClassification1(), 
			new TheFollowUpClassification2(),
			new TheFollowUpClassification3(), 
			new TheFollowUpClassification4(),
			new DrugName11(), 
			new DrugName12(), 
			new DrugName13(),
			new DrugName14(), 
			new DailyTimes11(), 
			new DailyTimes12(),
			new DailyTimes13(), 
			new DailyTimes14(), 
			new EveryFewMg11(),
			new EveryFewMg12(), 
			new EveryFewMg13(), 
			new EveryFewMg14(),
			new DrugName21(), 
			new DrugName22(), 
			new DrugName23(),
			new DrugName24(), 
			new DailyTimes21(),
			new DailyTimes22(),
			new DailyTimes23(),
			new DailyTimes24(), 
			new EveryFewMg21(),
			new EveryFewMg22(), 
			new EveryFewMg23(), 
			new EveryFewMg24(),
			new DrugName31(), 
			new DrugName32(), 
			new DrugName33(),
			new DrugName34(), 
			new DailyTimes31(), 
			new DailyTimes32(),
			new DailyTimes33(), 
			new DailyTimes34(), 
			new EveryFewMg31(),
			new EveryFewMg32(),
			new EveryFewMg33(),
			new EveryFewMg34(),
			new Insulin1(),
			new Insulin2(), 
			new Insulin3(),
			new Insulin4(),
			new ReferralReason1(),
			new ReferralReason2(),
			new ReferralReason3(),
			new ReferralReason4(),
			new AgenciesAndDivisions1(),
			new AgenciesAndDivisions2(),
			new AgenciesAndDivisions3(), 
			new AgenciesAndDivisions4(),
			new DateOfNextFollowUp1(), 
			new DateOfNextFollowUp2(),
			new DateOfNextFollowUp3(),
			new DateOfNextFollowUp4(),
			new FollowUpPhysicianSignature1(),
			new FollowUpPhysicianSignature2(),
			new FollowUpPhysicianSignature3(),
			new FollowUpPhysicianSignature4(),
			new LowBloodSugarReaction1(),
			new LowBloodSugarReaction2(),
			new LowBloodSugarReaction3(),
			new LowBloodSugarReaction4()
	};
	private String Rpath="E/B";
    private String[] Keys={"tnb"};
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
		// TODO Auto-generated method stub
		super.saveFile(this);
	}


}