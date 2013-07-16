 package coboo.impl.DocDriver.meta;



	/**
	 * 甲肝灭活疫苗
	 * HR42_02_065_031,cbjzbw_031,HR53_03_001_02_031,cbyxrq_031,HR53_99_001_031,HR22_01_020_031,cbbz_031,
	   HR42_02_065_032,cbjzbw_032,HR53_03_001_02_032,cbyxrq_032,HR53_99_001_032,HR22_01_020_032,cbbz_032
	 */
public	class HepatitisAInactivatedVaccineMeta extends Meta {
		public String metaname="甲肝灭活疫苗";
		String[] SIds = new String[]{"jzrq31:HR42_02_065_031","jzbw31:cbjzbw_031","ymph31:HR53_03_001_02_031","yxrq31:cbyxrq_031","scqy31:HR53_99_001_031","jzys31:HR22_01_020_031","bz31:cbbz_031",
				"jzrq32:HR42_02_065_032","jzbw32:cbjzbw_032","ymph32:HR53_03_001_02_032","yxrq32:cbyxrq_032","scqy32:HR53_99_001_032","jzys32:HR22_01_020_032","bz32:cbbz_032"};
		String[] SValues = new String[]{"","","","","","","",
				"","","","","","",""};
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
		public HepatitisAInactivatedVaccineMeta(){
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