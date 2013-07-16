 package coboo.impl.DocDriver.meta;


	/**
	 * 双向转诊(回转)单--主要检查结果
	 * @author WangZhendong
	 *
	 */
	// ============================== 双向转诊(回转)单--主要检查结果  =================================
public	class TBackMainCheckResultsMeta extends Meta {
		public String metaname = "双向转诊(回转)单--主要检查结果";
		String[] SIds = new String[] { "HR51_01_008_2" };
		String[] SValues = new String[] { "" };
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
		public TBackMainCheckResultsMeta() {
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