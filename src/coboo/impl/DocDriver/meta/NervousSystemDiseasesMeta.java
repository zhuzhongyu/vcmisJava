/**
 * 
 */
package coboo.impl.DocDriver.meta;

/**
 * @author user
 *
 */
public class NervousSystemDiseasesMeta extends Meta {

	public String metaname="神经系统疾病";
	String[] SIds = new String[]{"s0","s1"};
	String[] SValues = new String[]{"",""};
	String HValue;	

	void con_hvalue2svalue(String humanReadValue) {
	
	}
	void con_svalue2hvalue(String[] storeValueList) {
	
	}
	public NervousSystemDiseasesMeta(){
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
