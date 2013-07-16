 package coboo.impl.DocDriver.meta;



/**
	 * 麻腮风疫苗 
	 * HR42_02_065_015,cbjzbw_015,HR53_03_001_02_015,cbyxrq_015,HR53_99_001_015,HR22_01_020_015,cbbz_015,
	 * HR42_02_065_016,cbjzbw_016,HR53_03_001_02_016,cbyxrq_016,HR53_99_001_016,HR22_01_020_016,cbbz_016
	 */
public	class Mmr2VaccineMeta extends Meta {
		public String metaname="麻腮风疫苗";
		String[] SIds = new String[]{"jzrq15:HR42_02_065_015","jzbw15:cbjzbw_015","ymph15:HR53_03_001_02_015","yxrq15:cbyxrq_015","scqy15:HR53_99_001_015","jzys15:HR22_01_020_015","bz15:cbbz_015",
				"jzrq16:HR42_02_065_016","jzbw16:cbjzbw_016","ymph16:HR53_03_001_02_016","yxrq16:cbyxrq_016","scqy16:HR53_99_001_016","jzys16:HR22_01_020_016","bz16:cbbz_016"};
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
		public Mmr2VaccineMeta(){
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