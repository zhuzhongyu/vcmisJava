/**
 * 
 */
package coboo.impl.DocDriver.meta;

/**
 * @author user
 *
 */
public class AbdominalMeta extends Meta {

	public String metaname="查体-腹部";
	String[] SIds = new String[]{"yt1:HR51_02_188_02","yt2:HR51_02_188_01","bk1:HR51_02_187_02","bk2:HR51_02_187_01","gd1:HR51_02_185_02","gd2:HR51_02_185_01","pd1:HR51_02_186_02","pd2:HR51_02_186_01","ydxzy1:HR51_02_189_02","ydxzy2:HR51_02_189_01"};
	String[] SValues = new String[]{"","","","","","","","","",""};
	String HValue;	

	void con_hvalue2svalue(String humanReadValue) {
	
	}
	void con_svalue2hvalue(String[] storeValueList) {
	
	}
	public AbdominalMeta(){
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
