 package coboo.impl.DocDriver.meta;



/**
	 * 甲肝减毒活疫苗 
	 * HR42_02_065_030,cbjzbw_030,HR53_03_001_02_030,cbyxrq_030,HR53_99_001_030,HR22_01_020_030,cbbz_030
	 */
public	class LiveHepatitisAVaccineMeta extends Meta {
		public String metaname="甲肝减毒活疫苗";
		String[] SIds = new String[]{"jzrq30:HR42_02_065_030","jzbw30:cbjzbw_030","ymph30:HR53_03_001_02_030","yxrq30:cbyxrq_030","scqy30:HR53_99_001_030","jzys30:HR22_01_020_030","bz30:cbbz_030"};
		String[] SValues = new String[]{"","","","","","",""};
		String HValue;
		
		void con_hvalue2svalue(String humanReadValue) {

			String[] readValueList = humanReadValue.split("/");
			for(int i=0;i<readValueList.length;i++){
				SValues[i] = readValueList[i];
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			for(int i=0;i<storeValueList.length;i++){
				HValue+=storeValueList[i];
				if(i<storeValueList.length-1){
					HValue+="/";
				}
			}
			
			top();
			return;
		}
		public LiveHepatitisAVaccineMeta(){
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