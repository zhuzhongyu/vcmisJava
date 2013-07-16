 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 计划生育登记表
 * @author ghy
 *
 */
public class FamilyPlanningRegisterTab extends Table {
	
	Meta[] metas = {
			new RegisterDateMeta(), 			//注册日期
			new NameMeta(),								//姓名
			new PublicSexMeta(),								//性别
			new BirthDayMeta(),						//出生年月
			new PoliticalMeta(),					//政治面貌
			new WorkUnitMeta(),						//工作单位
			new PositionMeta(),						//职务
			new HusbandNameMeta(),				//配偶姓名
			new HusbandSexMeta(),					//配偶性别
			new HusbandBirthDayMeta(),		//配偶出生日期
			new HusbandPoliticalMeta(),		//配偶政治面貌
			new HusbandWorkUnitMeta(),		//配偶工作单位
			new HusbandPositionMeta(),		//配偶职务
			new Child1NameMeta(),					//子女姓名1 
			new Child1SexMeta(),					//子女性别1 
			new Child1SituationMeta(),		//子女情况1 
			new Child1BirthDayMeta(),			//子女出生日期1 
			new Child1ReasonMeta(),				//原因1 
			new Child1ApprovalAuthorityMeta(),//机关批准1 
			new Child2NameMeta(),					//子女姓名2
			new Child2SexMeta(),					//子女性别2 
			new Child2SituationMeta(),		//子女情况2 
			new Child2PropertiesMeta(),		//子女性质 2
			new Child2BirthDayMeta(),			//子女出生日期2 
			new Child2ReasonMeta(), 			//原因2 
			new Child2ApprovalAuthorityMeta(),//机关批准2
			new Child3NameMeta(),					//子女姓名3
			new Child3SexMeta(),					//子女性别3
			new Child3SituationMeta(),		//子女情况3
			new Child3PropertiesMeta(),		//子女性质 3
			new Child3BirthDayMeta(),			//子女出生日期3
			new Child3ReasonMeta(),				//原因3
			new Child3ApprovalAuthorityMeta(),//机关批准3
			new Child4NameMeta(),					//子女姓名4
			new Child4SexMeta(),					//子女性别4
			new Child4SituationMeta(),		//子女情况4
			new Child4PropertiesMeta(),		//子女性质 4
			new Child4BirthDayMeta(),			//子女出生日期4
			new Child4ReasonMeta(),				//原因4
			new Child4ApprovalAuthorityMeta(),//机关批准4
			new BasicFactsMeta(),				//违反计划生育政策处理情况--基本事实
			new Handle1SituationMeta(),	//违反计划生育政策处理情况--处理情况1
			new Handle1TimeMeta(),				//违反计划生育政策处理情况--处理时间1
			new Handle1AuthorityMeta(),		//违反计划生育政策处理情况--处分机关1
			new Handle2SituationMeta(),	//违反计划生育政策处理情况--处理情况2
			new Handle2TimeMeta(),				//违反计划生育政策处理情况--处理时间2
			new Handle2AuthorityMeta(),		//违反计划生育政策处理情况--处分机关2
			new Handle3SituationMeta(),	//违反计划生育政策处理情况--处理情况3
			new Handle3TimeMeta(),		//违反计划生育政策处理情况--处理时间3
			new Handle3AuthorityMeta(),		//违反计划生育政策处理情况--处分机关3
			new ExplainProblemMeta()			//需要向组织说明的问题	
	};
	private String Rpath="C/D";
    private String[] Keys={"FamilyPlanningRegisterTab"};
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
