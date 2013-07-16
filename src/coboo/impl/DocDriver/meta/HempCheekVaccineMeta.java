 package coboo.impl.DocDriver.meta;



/**
	 * 麻腮疫苗
	 * HR42_02_065_017,cbjzbw_017,HR53_03_001_02_017,cbyxrq_017,HR53_99_001_017,HR22_01_020_017,cbbz_017
	 */
public	class HempCheekVaccineMeta extends Meta {
		public String metaname="麻腮疫苗";
		String[] SIds = new String[]{"jzrq17:HR42_02_065_017","jzbw17:cbjzbw_017","ymph17:HR53_03_001_02_017","yxrq17:cbyxrq_017","scqy17:HR53_99_001_017","jzys17:HR22_01_020_017","bz17:cbbz_017"};
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
		public HempCheekVaccineMeta(){
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