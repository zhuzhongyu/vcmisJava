package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 3～6岁儿童健康检查记录表
 * 
 */

public class Age3_6ChildrenVisitRecordTab  extends Table{
	 GuidanceMeta  GuidanceMeta=new GuidanceMeta();
	Meta[] metas={
			
			
			new Age3YearMeta(),//3岁
			new Age4YearMeta(),//4岁
			new Age5YearMeta(),//5岁
			new Age6YearMeta()//6岁
	};
	private String Rpath="D/D";
	private String[] Keys={"yearoldchildrenfollowup3"};
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
