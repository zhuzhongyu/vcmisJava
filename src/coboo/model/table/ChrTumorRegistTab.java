 package coboo.model.table;



import coboo.impl.DocDriver.meta.*;
/**
 * 慢性病：肿瘤登记表
 * @author 任笑言
 */
public class ChrTumorRegistTab extends Table {
	Meta[] metas={
	new DocCodeMeta(), // 编号
	new NameMeta(), // 姓名
	new PublicSexMeta(), // 性别
	new PubEthnicMeta(), // 民族
	new BirthDateMeta(),// 出生日期
	new PersonIdMeta(),// 身份证号
	new AddressMeta(),// 家庭住址
	new CulturalDegreeMeta(),// 文化程度
	new MaritalStatusMeta(),// 婚姻状况
	new ProfessionalMeta(),// 职业
	new PostalAddressMeta(),// 通讯地址
	new TelephoneMeta(),// 固定电话
	new MobilePhoneMeta(),// 联系电话
	new PostalCodeMeta(),// 邮编
	new FirstConfirmDateMeta(),// 初次确诊年龄
	new ConfirmResultMeta(),// 确诊结果
	new HowToTreatMeta(),// 行何种治疗
	new SurgeryDateMeta(),// 手术时间
	new SurgeryHospitalMeta(),// 手术的医院
	new SurgeryWayMeta(),// 术士
	new ChemoMeta(),// 是否行化疗
	new SchemeMeta(),// 方案
	new RadiationMeta(),// 是否行放疗
	new DosageMeta(),// 剂量
	new FamilyHistoryMeta(),// 有无家族史
	new RelapseAndTransferMeta(),// 有无复发及转移
	};
	private String Rpath="E/E";
	private String[] Keys={"zl"};
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

	
