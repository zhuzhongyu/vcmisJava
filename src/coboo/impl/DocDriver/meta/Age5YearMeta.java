/**
 * 
 */
package coboo.impl.DocDriver.meta;

/**
 * @author user
 *
 */
public class Age5YearMeta extends Meta {
	String metaname = "5岁";
	String[] SIds = new String[] {
			"s0","s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9",
			"s10", "s11", "s12", "s13", "s14", "s15", "s16", "s17",	"s18", "s19", 
			"s20", "s21", "s22", "s23", "s24", "s25", "s26", "s27",	"s28", "s29", 
			"s30", "s31", "s32"};
	String[] SValues = new String[] {
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "" };
	String HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		
	}

	@Override
	void con_svalue2hvalue(String[] storeValueList) {

	
	}

	public Age5YearMeta() {
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
