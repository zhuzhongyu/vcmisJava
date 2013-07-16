/**
 * 
 */
 package coboo.impl.DocDriver.meta;

/**
 * 民族
 * HR02_05_001_1, HR02_05_001_2
 * 
 * @author user
 *
 */
public class EthnicMeta extends Meta{
	public String metaname="民族";
	String[] SIds =  new String[] {"ssmz:HR02_05_001_1:mz", "nation:HR02_05_001_2"  };
	String[] SValues = new String[]{"",""};
	String HValue;

	
	
	void con_svalue2hvalue(String[] storeValueList) {
		if (SValues[1].equals("1"))
			HValue = "汉族";
		if (SValues[1].equals("2"))
			HValue = storeValueList[1] + '/' + "少数民族";
		top();
		return;
		
	}
	
	void con_hvalue2svalue(String humanReadValue) {

		if (humanReadValue.equals("汉族")) {
			SValues[0] = "";
			SValues[1] = "1";
		} else {
			SValues[0] = humanReadValue;
			SValues[1] = "2";
		}
		top();
		return;
		
	}
	public EthnicMeta(){
		top();
	}
	void top(){
		super.SIds=SIds;
		super.SValues=SValues;
		super.HValue=HValue;
	    super.metaname=metaname;	
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
