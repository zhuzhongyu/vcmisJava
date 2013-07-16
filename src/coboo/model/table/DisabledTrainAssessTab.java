 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 肢残训练评估    "(G).(B).(B)"
 * @author 笑言
 *
 */
public class DisabledTrainAssessTab extends Table {

	Meta[] metas = { 
			new DocCodeMeta(), // 编号
			new NameMeta(), // 姓名
			new SexMeta(), // 性别
			new PubEthnicMeta(), // 民族
			new BirthDateMeta(),// 出生日期
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new ProfessionMeta(),// 职业
			new GuardianMeta(),// 监护人
			new DisRelationMeta(),// 与残疾人关系
			new PhoneMeta(),// 联系电话
			new EmancipatMeta(),// 翻身
			new SitMeta(),// 坐
			new StoodMeta(),// 站
			new TransferMeta(),// 转移
			new WalkMeta(),// 步行
			new UpAndDownMeta(),// 上下台阶
			new EatMeta(),// 进食
			new WearClothingMeta(),// 穿脱衣物
			new WashMeta(),// 洗漱
			new GoToToiletMeta(),// 入厕
			new FirstExchangeMeta(),// 第一次交流
			new HouseworkMeta(),// 做家务
			new SecondExchangeMeta(),// 第二次交流
			new TotalPointMeta(),// 总体分数
			new AssessDateMeta() // 评估时间
	};
	private String Rpath="G/B/B";
	private String[] Keys={"DisabledTrainAssessTab"};
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
