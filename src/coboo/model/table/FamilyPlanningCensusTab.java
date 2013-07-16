package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 计划生育普查表
 * 
 * @author ghy
 * 
 */
public class FamilyPlanningCensusTab extends Table {
	Meta[] metas = { 
			new DepartmentMeta(),
			new FirstFamilyManNameMeta(), 
			new FirstFamilyManWorkUnitMeta(),
			new FirstFamilyManPersonIdMeta(), 
			new FirstFamilyWomenNameMeta(),
			new FirstFamilyWomenWorkUnitMeta(),
			new FirstFamilyWomenPersonIdMeta(), 
			new FirstFamilyChildName(),
			new FirstFamilyAdress(), 
			new SecondFamilyManNameMeta(),
			new SecondFamilyManWorkUnitMeta(),
			new SecondFamilyManPersonIdMeta(),
			new SecondFamilyWomenNameMeta(),
			new SecondFamilyWomenWorkUnitMeta(),
			new SecondFamilyWomenPersonIdMeta(),
			new SecondFamilyChildName(),
			new SecondFamilyAdress(), 
			new ThirdFamilyManNameMeta(),
			new ThirdFamilyManWorkUnitMeta(), 
			new ThirdFamilyManPersonIdMeta(),
			new ThirdFamilyWomenNameMeta(), 
			new ThirdFamilyWomenWorkUnitMeta(),
			new ThirdFamilyWomenPersonIdMeta(), new ThirdFamilyChildName(),
			new ThirdFamilyAdress(), new FourthFamilyManNameMeta(),
			new FourthFamilyManWorkUnitMeta(),
			new FourthFamilyManPersonIdMeta(), new FourthFamilyWomenNameMeta(),
			new FourthFamilyWomenWorkUnitMeta(),
			new FourthFamilyWomenPersonIdMeta(), new FourthFamilyChildName(),
			new FourthFamilyAdress(), new FifthFamilyManNameMeta(),
			new FifthFamilyManWorkUnitMeta(), new FifthFamilyManPersonIdMeta(),
			new FifthFamilyWomenNameMeta(), new FifthFamilyWomenWorkUnitMeta(),
			new FifthFamilyWomenPersonIdMeta(), new FifthFamilyChildName(),
			new FifthFamilyAdress(), new SixthFamilyManNameMeta(),
			new SixthFamilyManWorkUnitMeta(), new SixthFamilyManPersonIdMeta(),
			new SixthFamilyWomenNameMeta(), new SixthFamilyWomenWorkUnitMeta(),
			new SixthFamilyWomenPersonIdMeta(), new SixthFamilyChildName(),
			new SixthFamilyAdress(), new SeventhFamilyManNameMeta(),
			new SeventhFamilyManWorkUnitMeta(),
			new SeventhFamilyManPersonIdMeta(),
			new SeventhFamilyWomenNameMeta(),
			new SeventhFamilyWomenWorkUnitMeta(),
			new SeventhFamilyWomenPersonIdMeta(), new SeventhFamilyChildName(),
			new SeventhFamilyAdress(), new EighthFamilyManNameMeta(),
			new EighthFamilyManWorkUnitMeta(),
			new EighthFamilyManPersonIdMeta(), new EighthFamilyWomenNameMeta(),
			new EighthFamilyWomenWorkUnitMeta(),
			new EighthFamilyWomenPersonIdMeta(), new EighthFamilyChildName(),
			new EighthFamilyAdress(), new NinthFamilyManNameMeta(),
			new NinthFamilyManWorkUnitMeta(), new NinthFamilyManPersonIdMeta(),
			new NinthFamilyWomenNameMeta(), new NinthFamilyWomenWorkUnitMeta(),
			new NinthFamilyWomenPersonIdMeta(), new NinthFamilyChildName(),
			new NinthFamilyAdress()

	};
	private String Rpath="C/C";
    private String[] Keys={"FamilyPlanningCensusTab"};
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
