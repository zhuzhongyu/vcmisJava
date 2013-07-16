package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 新生儿家庭访视记录表 未完成
 * 
 * @author Wangzhendong/任笑言
 * 
 */

public class NeonatalFamilyFollowUpRecordTab extends Table {
	AddressMeta				homeaddr				= new AddressMeta();
	BirthDateMeta			birthDate				= new BirthDateMeta();
	SexMeta					sexMeta					= new SexMeta();
	PersonIdMeta			personId				= new PersonIdMeta();
	WasBornSituationMeta	WasBornSituation		= new WasBornSituationMeta();
	WhetherDeformityMeta	WhetherDeformityMeta	= new WhetherDeformityMeta();
	ComplexionMeta			ComplexionMeta			= new ComplexionMeta();
	NeckBagPieceMeta		NeckBagPieceMeta		= new NeckBagPieceMeta();
	EyeMetay				eyes					= new EyeMetay();
	PulseRateMetay 			PulseRateMeta			=new PulseRateMetay();
	Meta[]	metas= {
												
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			sexMeta, // 性别
			birthDate, // 出生日期
			personId, // 身份证
			homeaddr, // 家庭住址
			new NameOfFatherMeta(), // 父亲--姓名
			new FatherCareerMeta(), // 父亲--职业
			new FatherContactTelMeta(), // 父亲--联系电话
			new DateOfBirthFatherMeta(), // 父亲--出生日期
			new NameOfMotherMeta(), // 母亲--姓名
			new MotherCareerMeta(), // 母亲--职业
			new MotherContactTelMeta(), // 母亲--联系电话
			new DateOfBirthMotherMeta(), // 母亲--出生日期
			new GestationalAgeAtBirthMeta(), // 出生孕周
			new PrevalenceOfPregnancyMeta(), // 妊娠期患病情况
			new NameOfMidwiferyOrganizationMeta(), // 助产机构名称
			WasBornSituation, // 出生情况
			new AsphyxianeonatorumMeta(), // 新生儿窒息
			WhetherDeformityMeta, // 是否有畸形
			new NewbornHearingScreeningMeta(), // 新生儿听力筛查
			new BirthWeightMeta(), // 新生儿--出生体重
			new WeightMeta(),//目前体重
			new WasBornLongMeta(), // 新生儿--出生身长
			new FeedingMeta(), // 新生儿--喂养方式
			new BodyTemperatureMeta(), // 体温
			new RespiratoryRateMeta(), // 呼吸频率
			PulseRateMeta, // 脉率
			ComplexionMeta, // 面色
			new SinciputMeta(), // 前囟
			eyes, // 眼
			new LimbsMobilityMeta(), // 四肢活动度
			new EarMeta(), // 耳
			NeckBagPieceMeta, // 颈部包块
			new NoseMeta(), // 鼻
			new SkinMeta(), // 皮肤
			new OralCavityMeta(), // 口腔
			new AnusMeta(), // 肛门
			new CardiopulmonaalMeta(), // 心肺
			new GenitalsMeta(), // 外生殖器
			// new AbdomenMeta(), // 腹部
			new SpinalColumnMeta(), // 脊柱
			new UmbilicalCordMeta(), // 脐带
			new WhetherReferralMeta(), // 转诊
			new GuidanceXSEMeta(), // 指导
			new VisitingDataMeta(),					// 访视表单
						
			new DiseaseScreeningMeta(),//新生儿疾病筛查	
			new JaundicePositionMeta(),
			new AbdominalPalpationMeta()

			
	};

	private String			Rpath					= "D/A";
	private String[]		Keys					= { "newbornhomevisit" };
	private String[]		Values					= { "true" };

	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
		homeaddr.setSIds(new String[]{"jtzz01"});
		birthDate.setSIds(new String[]{"csrq1"});
					
		sexMeta.setSIds( new String[] { "xb1" });
		personId.setSIds(new String[] { "sfzh01" });
		WasBornSituation.setSIds(new String[] { "xm13", "xm14", "zd03" });
		WhetherDeformityMeta.setSIds(new String[] { "xm16", "xm17" });
		ComplexionMeta.setSIds(new String[] { "sstz7", "sstz8", "jy13" });
		NeckBagPieceMeta.setSIds(new String[] { "jy7", "jy8" });
		eyes.setSIds(new String[]{"jy1","jy2"});
		PulseRateMeta.setSIds(new String[] { "sstz6" });
		
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
