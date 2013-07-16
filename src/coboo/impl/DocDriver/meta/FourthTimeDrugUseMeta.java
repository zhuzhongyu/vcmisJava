 package coboo.impl.DocDriver.meta;


  /**
	 * 用药情况
	 * @author WangZhendong
	 *----------------------------------------------------------------
	 *         |用药情况--药物名称         用法--每日几次      每次几mg
	 *----------------------------------------------------------------
	 * 药物1    |HR53_01_002_31		|HR52_01_037_01_31 |HR52_01_037_03_31
	 *----------------------------------------------------------------  
	 * 药物2    |HR53_01_002_32		|HR52_01_037_01_32 |HR52_01_037_03_32
	 *----------------------------------------------------------------
	 * 药物3    |HR53_01_002_33		|HR52_01_037_01_33 |HR52_01_037_03_33
	 *----------------------------------------------------------------
	 * 其他药物  |HR53_01_002_34		|HR6 			   |HR7
	 *----------------------------------------------------------------
	 */
public class FourthTimeDrugUseMeta  extends Meta {
		public String metaname=" 辅助检查 ";
		String[] SIds = new String[]{"ywmc4:HR53_01_002_31" ,"yf7:HR52_01_037_01_31","yf8:HR52_01_037_03_31",
				   "ywmc8:HR53_01_002_32" ,"yf15:HR52_01_037_01_32","yf16:HR52_01_037_03_32",
				   "ywmc12:HR53_01_002_33" ,"yf23:HR52_01_037_01_33","yf24:HR52_01_037_03_33",
				   "ywmc16:HR53_01_002_34" ,"yf31:HR6","yf32:HR7" };
		String[] SValues = new String[]{"","","","","","","","","","","",""};
		String HValue;	

        /*
         * (non-Javadoc)
         * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
         */ 
		void con_hvalue2svalue(String humanReadValue) {
			String[] valueList = new String[12];
			valueList = humanReadValue.split("/");
			SValues[0] = valueList[0];
			SValues[1] = valueList[1];
			SValues[2] = valueList[2];
			SValues[3] = valueList[3];
			SValues[4] = valueList[4];
			SValues[5] = valueList[5];
			SValues[6] = valueList[6];
			SValues[7] = valueList[7];
			SValues[8] = valueList[8];
			SValues[9] = valueList[9];
			SValues[10] = valueList[10];
			SValues[11] = valueList[11];
			top();
			return;
		}
		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
		 */
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = storeValueList[0]+"/" +storeValueList[1]+"/"+storeValueList[2]+"/" +storeValueList[3]+"/"+
			                 storeValueList[4]+"/" +storeValueList[5]+"/"+storeValueList[6]+"/" +storeValueList[7]+"/"+
			                 storeValueList[8]+"/" +storeValueList[9]+"/"+storeValueList[10]+"/" +storeValueList[11];
			top();
			return;
		}
		public FourthTimeDrugUseMeta(){
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