 package coboo.impl.DocDriver.meta;



/**
	 * 生活方式--饮食习惯 Eating habits
	 * HR51_01_185_1,HR51_01_185_2,HR51_01_185_3
	 */
	public class EatingHabitsMeta extends Meta{
		public String metaname="生活方式--饮食习惯";
		String[] SIds = new String[]{"yscg1:HR51_01_185_1","yscg2:HR51_01_185_2","yscg3:HR51_01_185_3"};
		String[] SValues = new String[]{"","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[3];	
			readValueList =	humanReadValue.split("/");

			for(int i =0;i<readValueList.length;i++) {
				SValues[i] = readValueList[i];
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = "";
			for(int i =0;i<storeValueList.length;i++) {
				if(i<(storeValueList.length-1)) {
					HValue += storeValueList[i]+"/";
				}else {
					HValue += storeValueList[i];
				}
			}top();
			return;
		}
		public EatingHabitsMeta(){
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