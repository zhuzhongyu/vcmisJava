 package coboo.impl.DocDriver.meta;

/**
	 * 药费
	 * @author WangZhendong
	 * yuan,jiao,fen
	 */
	// ============================== 药费 =================================
	public class MedicineExpensesMeta extends Meta {
		String metaname="药费";
		String[] SIds = new String[]{  "yuan:y","jiao:j","fen:f" };
		String[] SValues = new String[]{"","",""};
		String HValue;	


		void con_hvalue2svalue(String humanReadValue) {
			String[] valueList = new String[3];
			valueList = humanReadValue.split("/");
			SValues[0] = valueList[0];
			SValues[1] = valueList[1];
			SValues[2] = valueList[2];
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = storeValueList[0]+"/" +storeValueList[1]+"/"+storeValueList[2];
			top();
			return;
		}
		public MedicineExpensesMeta(){
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