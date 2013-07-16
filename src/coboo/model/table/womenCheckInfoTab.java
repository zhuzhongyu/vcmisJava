 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 妇女检查记录表
 * 
 * @author ghy
 * 
 */
public class womenCheckInfoTab extends Table {
	Meta[] metas = { 
			new NameMeta(), // 姓名
			new CheckDataMeta(), // 检查日期
			new WDocCodeMeta(), // 编号
			new AgeDataMeta(), // 年龄
			new PersonIdMeta(), // 身份证编号
			new PhoneMeta(), // 联系电话
			new MarryingAgeMeta(), // 结婚年龄
			new MarriageStatusMeta(), // 婚姻状况
			new MenstrualHistoryMeta(), // 月经史
			new LastMenstrualMeta(), // 末次月经
			new AmenorrhoeaAgeMeta(), // 闭经年龄
			new WomenReproductieHistoryMeta(), // 孕产史
			new WTemperatureMeta(), // 生命特征--心脏
			new WPulseMeta(), // 生命特征--脉搏
			new WBreathingMeta(), // 生命特征--肝脾
			new WBloodPressureMeta(), // 生命特征--血压
			new LeftBreastCheckMeta(), // 乳腺检查--左
			new RightBreastCheckMeta(), // 乳腺检查--右
			new VulvaeCheckMeta(), // 妇科检查--外阴
			new VaginalCheckMeta(), // 妇科检查--阴道
			new CervicalCheckMeta(), // 妇科检查--宫颈
			new UterineCheckMeta(), // 妇科检查--子宫
			new AdnexitisCheckMeta(), // 妇科检查--附件
			new AdnexitisLeftCheckMeta(), // 妇科检查--左侧
			new AdnexitisRightCheckMeta(),// 妇科检查--右侧
			new ElectronicVaginalEndoscopyMeta(), // 电子阴道镜检查
			new BSonographyExaminationMeta(), // B超检查
			new LeucorrheaSmearMeta(), // 辅助检查--白带涂片
			new CervicalAirCompressorMeta(), // 辅助检查--宫颈刮片
			new CheckConclusionMeta() // 检查结论

	};
	private String Rpath="C/A";	
	private String[] Keys={"womenCheckInfoTab"};
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
