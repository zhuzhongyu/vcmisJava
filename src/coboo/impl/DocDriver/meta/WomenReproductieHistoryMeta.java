 package coboo.impl.DocDriver.meta;

/**
 * 孕产史
 * "HR51_01_412_91_01", "HR51_01_412_91_02","HR51_01_104_01",
 * "HR51_01_104_02", "HR51_01_104_03","HR51_01_104_04", 
 * "HR51_01_104_05", "HR51_01_104_06","HR51_01_104_07", "HR51_01_104_08" 
 */
public class WomenReproductieHistoryMeta extends Meta {
	public String metaname = "孕产史 ";
	String[] SIds = new String[] { "sys1:HR51_01_412_91_01", "sys2:HR51_01_412_91_02",
			"xyzn1", "xyzn2", "xyzn3:HR51_01_104_01",
			"xyzn4:HR51_01_104_02", "xyzn5:HR51_01_104_03"};
	String[] SValues = new String[] { "", "", "", "", "", "", ""};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[10];
		readValueList = humanReadValue.split("/");
if(readValueList.length==7){
	SValues[0] = readValueList[0].replace("孕", "");
	SValues[1] = readValueList[1].replace("产", "");
	SValues[2] = readValueList[2].replace("男", "");
	SValues[3] = readValueList[3].replace("女", "");
	SValues[4] = readValueList[4].replace("足月产", "");
	SValues[5] = readValueList[5].replace("剖腹产", "");
	SValues[6] = readValueList[6].replace("早产", "");

}else{
		SValues[0] = readValueList[0].replace("孕", ""); 
		SValues[1] = readValueList[1].replace("产", "");
		SValues[2] = readValueList[2].replace("足月产", "");
		SValues[3] = readValueList[3].replace("剖宫产", "");
		SValues[4] = readValueList[4].replace("早产", "");
		SValues[5] = readValueList[5].replace("流产", "");
		SValues[6] = readValueList[6].replace("引产", "");
		SValues[7] = readValueList[7].replace("死胎", "");
		SValues[8] = readValueList[8].replace("死产", "");
		SValues[9] = readValueList[9].replace("新生儿死亡", "");
}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
if(storeValueList.length==7){
	HValue = "孕" + storeValueList[0] + "/产" + storeValueList[1]+"/男"+storeValueList[2]
			+"/女"+storeValueList[3]+"/足月产"+storeValueList[4]+"/剖腹产"+storeValueList[5]+"/早产"+storeValueList[6];
}else{
		HValue = "孕" + storeValueList[0] + "/产" + storeValueList[1] + "/足月产"
				+ storeValueList[2] + "/剖宫产" + storeValueList[3] + "/早产"
				+ storeValueList[4] + "/流产" + storeValueList[5] + "/引产"
				+ storeValueList[6] + "/死胎" + storeValueList[7] + "/死产"
				+ storeValueList[8] + "/新生儿死亡" + storeValueList[9];
}
		top();
		return;
	}

	public WomenReproductieHistoryMeta() {
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