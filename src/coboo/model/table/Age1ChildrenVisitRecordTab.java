package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

public class Age1ChildrenVisitRecordTab extends Table{
	Meta[] metas={
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new Age1MonthMeta(),//满月
			new Age1Month3Meta(),//3月龄
			new Age1Month6Meta(),//6月龄
			new Age1Month8Meta()//8月龄
	};
	private String Rpath="D/B/";
    private String[] Keys={"Age1ChildrenVisitRecordTab"};
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

	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.saveFile(this);
	}


	
	
}
