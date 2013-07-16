 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 产后42天随访记录表
 * 
 * @author 杜荣光
 * 
 */
public class PostpartumFortyTowDaysCheckRecordTab extends Table {
	 WoundMeta WoundMeta=new WoundMeta();
	 GuidanceMeta GuidanceMeta=new GuidanceMeta();
	Meta[] metas = {
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new FollowUpDateMeta(), // 产后随访日期
			new GeneralHealthMeta(), // 一般健康情况
			new GeneralPsychologicalConditionMeta(),// 一般心里状态
			new WCEDBloodPressureMeta(), // 血压
			new WCEDBreastMeta(), // 乳房
			new LochiaMeta(), // 恶露
			new UterusMeta(), // 子宫
			WoundMeta, // 伤口
			new OtherMeta(), // 其他
			new ClassificationMeta(), // 分类
			GuidanceMeta, // 指导
			new ProcessingMeta(), // 转诊
			new DoctorNameMeta() // 随访医生签名
	};
	private String Rpath="C/E/D";
    private String[] Keys={"otherbak14"};
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
