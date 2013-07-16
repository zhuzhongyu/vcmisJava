package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 妇女病检查登记表
 * 
 * @author ghy
 * 
 */
public class womenDiseaseCheckInfoTab extends Table {
	Meta[] metas = { 
			new NameMeta(), // 姓名
			new CheckDataMeta(), // 检查日期
			new BirthDayMeta(), // 出生年月
			new PersonIdMeta(), // 身份证号
			new MarriageStatusMeta(), // 婚姻状况
			new PhoneMeta(), // 联系电话
			new HealthStateMeta(), // 健康状况
			new FamilyAdressMeta(), // 家庭住址
			new VulvaeCheckBoxMeta(), // 检查内容--外阴选项
			new VulvaeAbnormalMeta(), // 检查内容--外阴异常
			new VaginalSecretionsCheckBoxMeta(), // 检查内容--阴道分泌物选项
			new VaginalOrtherSecretionsMeta(), // 检查内容--阴道分泌物其他异常
			new CervixMeta(), // 检查内容--宫颈
			new AdnexitisMeta(), // 检查内容--附件炎
			new PelvicInflammationMeta(), // 检查内容--盆腔炎
			new UterineFibroidsMeta(), // 检查内容--子宫肌瘤
			new AdnexitisTumorMeta(), // 检查内容--附件肿瘤
			new OvarianCancerMeta(), // 检查内容--卵巢癌
			new BreastCancerMeta(), // 检查内容--乳腺癌
			new SyphilisMeta(), // 检查内容--梅毒
			new GonorrheaMeta(), // 检查内容--淋病
			new AcutenessWetWartMeta(), // 检查内容--尖锐湿疹
			new BreastCheckResultsMeta(), // 乳腺检查结果
			new BSonographyCheckResultsMeta() // B超检查结果

	};
	private String Rpath="C/B";
    private String[] Keys={"womenDiseaseCheckInfoTab"};
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
