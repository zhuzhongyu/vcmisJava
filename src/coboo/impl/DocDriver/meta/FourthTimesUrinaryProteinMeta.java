 package coboo.impl.DocDriver.meta;



/**
	 * 第四次随访尿蛋白
	 * HR51_03_097_03
	 */
public	class FourthTimesUrinaryProteinMeta extends Meta {
		public String metaname="第四次随访尿蛋白";
		String[] SIds = new String[]{"ndr3:HR51_03_097_03"};
		String[] SValues = new String[]{""};
		String HValue;
		

		void con_hvalue2svalue(String humanReadValue) {
			
			SValues[0]=humanReadValue;
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = storeValueList[0];
			top();
			return;
		}
		public FourthTimesUrinaryProteinMeta(){
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