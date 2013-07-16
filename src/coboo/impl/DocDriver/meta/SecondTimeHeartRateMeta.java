 package coboo.impl.DocDriver.meta;

/**
 * 心率 
 * "HR51_02_042_2", "HR13"
 * @author WangZhendong
 */
public class SecondTimeHeartRateMeta extends Meta {
	public String metaname = " 心率 ";
	String[] SIds = new String[] { "xl3:HR51_02_042_2", "xl4:HR13" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String[] valueList = new String[2];
		valueList = humanReadValue.split("/");
		SValues[0] = valueList[0];
		SValues[1] = valueList[1];
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0] + "/" + storeValueList[1];
		top();
		return;
	}

	public SecondTimeHeartRateMeta() {
		top();
	}

	void top() {
		super.SIds = SIds;
		super.SValues = SValues;
		super.HValue = HValue;
		super.metaname = metaname;
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
		if(sValues.length!=2){
			this.SValues=new String[2];
			this.SValues[0]=sValues[0];
			this.SValues[1]="";
		}else{
		SValues = sValues;
		}
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