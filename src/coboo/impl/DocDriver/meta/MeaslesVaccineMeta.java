 package coboo.impl.DocDriver.meta;



/**
	 * 麻疹疫苗 
	 * HR42_02_065_018,cbjzbw_018,HR53_03_001_02_018,cbyxrq_018,HR53_99_001_018,HR22_01_020_018,cbbz_018,
	 * HR42_02_065_019,cbjzbw_019,HR53_03_001_02_019,cbyxrq_019,HR53_99_001_019,HR22_01_020_019,cbbz_019
	 */
public 	class MeaslesVaccineMeta extends Meta {
		public String metaname="麻疹疫苗";
		String[] SIds = new String[]{"jzrq18:HR42_02_065_018","jzbw18:cbjzbw_018","ymph18:HR53_03_001_02_018","yxrq18:cbyxrq_018","scqy18:HR53_99_001_018","jzys18:HR22_01_020_018","bz18:cbbz_018",
				"jzrq19:HR42_02_065_019","jzbw19:cbjzbw_019","ymph19:HR53_03_001_02_019","yxrq19:cbyxrq_019","scqy19:HR53_99_001_019","jzys19:HR22_01_020_019","bz19:cbbz_019"};
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
		public MeaslesVaccineMeta(){
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