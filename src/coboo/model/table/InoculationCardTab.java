 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 预防接种卡
 * @author ghy
 *
 */
public class InoculationCardTab extends Table {
	GuardianPhoneMeta GuardianPhoneMeta=new GuardianPhoneMeta();
	Meta[] metas = {
			new NameMeta(),				// 姓名
			new DocCodeMeta(),		//编号
			new SexMeta(),				//性别
			new BirthDateMeta(),	//出生年月日
			new GuardianMeta(),		//监护人姓名
			new GuardianRelationMeta(),	//监护人与儿童关系
			GuardianPhoneMeta,		//监护人联系电话
			new HomeAddressMeta(),//家庭住址
			new CensusRegisterAddressMeta(),//户籍地址
			new IngoingTimeMeta(),//迁入时间
			new EmigrationTimeMeta(),		//迁出时间
			new EmigrationReasonMeta(),	//迁出原因
			new VaccineAllergiesHistoryMeta(),//疫苗异常反映史
			new VaccinationTabooMeta(),	//接种禁忌
			new InfectHistoryMeta(),		//传染病史
			new BuildCardDateMeta(),		//建卡日期
			new BuilderMeta(),		//建卡人
			new HepatitisBVaccineMeta(),//乙肝疫苗
			new BCGVaccineMeta(),	//卡介苗
			new OPVaccineMeta(),	//脊灰疫苗
			new PDTVaccineMeta(),	//百白破疫苗
			new DTVaccineMeta(),	//白破疫苗 
			new LeprosyVaccineMeta(),		//麻风疫苗
			new Mmr2VaccineMeta(),	//麻腮风疫苗
			new HempCheekVaccineMeta(),	//麻腮疫苗
			new MeaslesVaccineMeta(),		//麻疹疫苗
			new AEpidemicEncephalitisVaccineMeta(),	//A群流脑疫苗
			new ACEpidemicEncephalitisVaccineMeta(),//A+C群流脑疫苗
			new JapaneseEncephalitisVaccineMeta(),	//乙脑(减毒)活疫苗
			new EncephalitisBInactiVatedvaccineMeta(),//乙脑灭活疫苗
			new LiveHepatitisAVaccineMeta(),				//甲肝减毒活疫苗
			new HepatitisAInactivatedVaccineMeta(),	//甲肝灭活疫苗
			new TypeIIVaccineMeta()		//二类疫苗
	};
	private String Rpath="F/A";
    private String[] Keys={"InoculationCardTab"};
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
