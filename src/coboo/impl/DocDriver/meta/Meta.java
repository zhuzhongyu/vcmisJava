package coboo.impl.DocDriver.meta;

/**
 * 该类是所有数据元的共同super class ，在该class中完成共同操作，
 * 也就是共性化操作在Meta中，个性化操作在各个子类中
 */
/**
 * @author zhu zhongyu
 * 
 */
public  class Meta {
	protected String metaname; // 数据元的名称
	protected String[] SIds; // 保存其子类的SIds字符串数组
	protected String[] SValues; // 保存其子类的存储数据元的SIds的对应的值
	protected String HValue; // 该数据元的转换成一个字符串，的方便阅读的形式

	 void con_svalue2hvalue(String[] storeValueList){
		 
	 }

	 void con_hvalue2svalue(String humanReadValue){
		 
	 }
	 /**
		 * @return the sValues
		 */
		public String[] getSValues() {
			return SValues;
		}
	/** 
	 * @param sValues
	 *            the sValues to set
	 */
	public void setSValues(String[] sValues) {
		SValues = sValues;
		con_svalue2hvalue(SValues);
	}
	/**
	 * @return the hValue
	 */
	public String getHValue() {
	
		return HValue;
	}
	/**
	 * @param hValue
	 *            the hValue to set
	 */
	public void setHValue(String hValue) {
		HValue = hValue;
		con_hvalue2svalue(HValue);
	}
	/**
	 * @return the sIds
	 */
	public String[] getSIds() {
		return SIds;
	}
	public String getMetaName() {
		return metaname;
	}
	/**
	 * @param sIds the sIds to set
	 */
	public void setSIds(String[] sIds) {
		SIds = sIds;
	}

}
