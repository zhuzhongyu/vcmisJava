 package coboo.model.table;


import coboo.impl.DocDriver.meta.*;

/**
 * 3-6岁儿童随访服务记录表
 * 
 * @author 任笑言
 * 
 */
public class Age3ChildrenVisitRecordTab extends Table {
	HealthCheckupFaceMeta HealthCheckupFaceMeta= new HealthCheckupFaceMeta();
	HealthCheckupGaitMeta HealthCheckupGaitMeta=new HealthCheckupGaitMeta();
	 HistoryOfSickMeta HistoryOfSickMeta=new HistoryOfSickMeta();
	 GuidanceMeta GuidanceMeta=new GuidanceMeta();
	 Meta[] metas={		
	new NameMeta(), // 姓名
	new DocCodeMeta(), // 编号
	new VisitDateMeta(), // 随访日期
	new WeightMetay1(), // 体重
	new HeightMeta(), // 身高
	new GrowthEvaluationMeta(),// 体格发育评价
	HealthCheckupFaceMeta,// 体格检查:面色
	HealthCheckupGaitMeta,// 体格检查:步态
	new HealthCheckupEyeMeta(),// 体格检查:眼
	new HealthCheckupEarMeta(),// 体格检查:耳朵
	new HealthCheckupHeart_lungMeta(),// 体格检查:心肺
	new HealthCheckupLiver_SpleenMeta(),// 体格检查:肝脾
	new HealthCheckupActionMeta(),// 体格检查:行为
	new HealthCheckupSocialMeta(),// 体格检查:社交
	HistoryOfSickMeta,// 幼儿期患病情况
	new HistoryOfAllergyMeta(),// 过敏史
	new OtherMetay1(),// 其他
	new ReferralMeta(),// 转诊
	GuidanceMeta,// 指导
	new DoctorNameMeta(),// 随访医生签名
	 };
		private String Rpath="D/D";
		private String[] Keys={"yearoldchildrenfollowup3"};
		private String[] Values={"true"};


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

	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.saveFile(this);
	}


	
	 }
