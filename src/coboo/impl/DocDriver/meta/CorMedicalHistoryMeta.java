package coboo.impl.DocDriver.meta;

import coboo.impl.DocDriver.meta.Meta;

public class CorMedicalHistoryMeta extends Meta {
	String metaname = "既往情况";
	String[] SIds = new String[] {"xjt:HR51_01_006_1", "xjgx:HR51_01_006_2",
			"gmdqs:HR51_01_006_3", "gmjrzls:HR51_01_006_4" };
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;
	
	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = humanReadValue.split("/");
		for(int i=0; i<readValueList.length; i++) {
			String value = readValueList[i];
			if(value.equals("心绞痛")) {
				SValues[0]="true";
			}else if(value.equals("心肌梗塞")) {
				SValues[1]="true";
			}else if(value.equals("冠脉搭桥术")) {
				SValues[2]="true";
			}else if(value.equals("冠脉介入治疗史")) {
				SValues[3]="true";
			}
		}
		top();
		return;
	}
	void con_svalue2hvalue(String[] storeValueList) {
		
		HValue ="";
		if(storeValueList[0].equals("true")){
			HValue +="心绞痛/";
		}
		if(storeValueList[1].equals("true")) {
			HValue += "心肌梗塞/";
		}
		if(storeValueList[2].equals("true")) {
			HValue += "冠脉搭桥术/";
		}
		if(storeValueList[3].equals("true")) {
			HValue += "冠脉介入治疗史/";
		}
		
		top();
		return;
	}
	public CorMedicalHistoryMeta(){
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
