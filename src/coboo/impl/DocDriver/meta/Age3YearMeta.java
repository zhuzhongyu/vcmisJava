/**
 * 
 */
package coboo.impl.DocDriver.meta;

/**
 * @author user
 *
 */
public class Age3YearMeta extends Meta {
	String metaname = "3岁";
	String[] SIds = new String[] {
			"HR42_02_057:nyr1","HR51_02_004:tzhong1", "shang1", "zhong1", "xia1", "HR51_02_003", "shang2", "zhong2", "s8:xia2", "HR51_02_118:tgpj",
			"s10", "s11", "s12", "HR51_02_086_1:tj9", "s14", "s15", "cbqt:gm3", "cbyrhbqk5","cbyrhbqk1", "cbyrhbqk2", 
			"cbyrhbqk3", "cbyrhbqk4", "HR42_01_010:gm4", "HR52_02_044:gm6", "HR21_01_022:gm7", "s25", "s26", "s27",	"s28", "s29", 
			"cbzd1:zd1", "s31", "cbsfysqm:sfname"};
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

	public Age3YearMeta() {
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
