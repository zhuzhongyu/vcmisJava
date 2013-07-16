/**
 * 
 */
package coboo.impl.DocDriver.meta;

/**
 * @author user
 *
 */
public class Age6YearMeta extends Meta {
	String metaname = "6岁";
	String[] SIds = new String[] {
			"sf13", "sf14", "sf15","tg8", "tg15", "tg18", "tg22", "tg26", "tg30", "tg33",
			"tg36", "tg38", "hw5", "hw10","fy15", "fy19", "zz5", "zhid4","xzsfrq4", "sfysqm4"
			,"s20", "s21","s22","s23","s24"};
	String[] SValues = new String[] {
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "" };
	String HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		
	}

	@Override
	void con_svalue2hvalue(String[] storeValueList) {

	
	}

	public Age6YearMeta() {
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
