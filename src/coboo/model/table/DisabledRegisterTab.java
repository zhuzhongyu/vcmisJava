 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 残疾人登记表
 * 
 * @author 任笑言
 */

public class DisabledRegisterTab extends Table {
	Meta[] metas = { 
			new DocCodeMeta(),// 编号
			new NameMeta(),// 姓名
			new SexMeta(),// 性别
			new PubEthnicMeta(),// 民族
			new BirthDateMeta(),// 出生日期
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new MedicalPropertiesMeta(),// 医疗费性质
			new DisabilityCategoryMeta(),// 残疾类别
			new LevelMeta(),// 等级
			new DisabilityCausesMeta(),// 致残原因
			new DisabilityDateMeta(),// 致残时间
			new DisabilityPartMeta(),// 致残部位
			new GuardianMeta(),// 法定监护人
			new SocialReliefMeta(),// 社会救济
			new RelativesSupportMeta(),// 亲属供养
			new MajorProjectMeta(),// 享受优惠政策：主要项目
			new MadeMoneyMeta(),// 享受优惠政策：折款
			new AlreadySurgeryMeta(),// 已接受康复：手术
			new AlreadyCureMeta(),// 已接受康复：精神综合防治
			new AlreadyTrainingMeta(),// 已接受康复：训练
			new AlreadyOtherMeta(),// 已接受康复：其他
			new YetSurgeryMeta(),// 需要接受康复：手术
			new YetCureMeta(),// 需要接受康复：精神综合防治
			new YetTrainingMeta(),// 需要接受康复：训练
			new YetOtherMeta(),// 需要接受康复：其他
			new AlreadySpeciesMeta(),// 已使用器具：种类
			new AlreadyNameMeta(),// 已使用器具：名称
			new YetSpeciesMeta(),// 需要使用器具：种类
			new YetNameMeta(),// 需要使用器具：名称
	};
	private String Rpath="G/A";
	 private String[] Keys={"DisabledRegisterTab"};
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