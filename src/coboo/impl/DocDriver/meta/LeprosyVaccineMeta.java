 package coboo.impl.DocDriver.meta;



/**
	 * 麻风疫苗 
	 * HR42_02_065_014,cbjzbw_014,HR53_03_001_02_014,cbyxrq_014,HR53_99_001_014,HR22_01_020_014,cbbz_014
	 */
public	class LeprosyVaccineMeta extends Meta {
		public String metaname="麻风疫苗";
		String[] SIds = new String[]{"jzrq14:HR42_02_065_014","jzbw14:cbjzbw_014","ymph14:HR53_03_001_02_014","yxrq14:cbyxrq_014","scqy14:HR53_99_001_014","jzys14:HR22_01_020_014","bz14:cbbz_014"};
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
		public LeprosyVaccineMeta(){
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