 package coboo.impl.DocDriver.meta;



	/**
	 * 乙脑(减毒)活疫苗	
	 *  HR42_02_065_024,cbjzbw_024,HR53_03_001_02_024,cbyxrq_024,HR53_99_001_024,HR22_01_020_024,cbbz_024,
	    HR42_02_065_025,cbjzbw_025,HR53_03_001_02_025,cbyxrq_025,HR53_99_001_025,HR22_01_020_025,cbbz_025
	 */
public	class JapaneseEncephalitisVaccineMeta extends Meta {
		public String metaname="乙脑(减毒)活疫苗";
		String[] SIds = new String[]{"jzrq24:HR42_02_065_024","jzbw24:cbjzbw_024","ymph24:HR53_03_001_02_024","yxrq24:cbyxrq_024","scqy24:HR53_99_001_024","jzys24:HR22_01_020_024","bz24:cbbz_024",
				"jzrq25:HR42_02_065_025","jzbw25:cbjzbw_025","ymph25:HR53_03_001_02_025","yxrq25:cbyxrq_025","scqy25:HR53_99_001_025","jzys25:HR22_01_020_025","bz25:cbbz_025"};
		String[] SValues = new String[]{"","","","","","","","","","","","","",""};
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
		public JapaneseEncephalitisVaccineMeta(){
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