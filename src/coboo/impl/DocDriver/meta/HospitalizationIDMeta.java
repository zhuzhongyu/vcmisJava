 package coboo.impl.DocDriver.meta;


/**
	 * 门诊号/住院号
	 * mzh
	 * @author WangZhendong
	 *
	 */
	// ============================== 门诊号/住院号 =================================
public	class HospitalizationIDMeta extends Meta {
		public String metaname="门诊号/住院号";
		String[] SIds = new String[]{"mzh:cbzyh"};
		String[] SValues = new String[]{""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			SValues[0] = humanReadValue;
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = storeValueList[0];
			top();
			return;
		}
		public HospitalizationIDMeta(){
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