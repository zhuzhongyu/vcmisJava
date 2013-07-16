package coboo.impl.DocDriver.meta;



/**
	 * A+C群流脑疫苗
	 * 
	 * HR42_02_065_022,cbjzbw_022,HR53_03_001_02_022,cbyxrq_022,HR53_99_001_022,HR22_01_020_022,cbbz_022,
	 * HR42_02_065_023,cbjzbw_023,HR53_03_001_02_023,cbyxrq_023,HR53_99_001_023,HR22_01_020_023,cbbz_023
	 */
public	class ACEpidemicEncephalitisVaccineMeta extends Meta{
		public String metaname="A+C群流脑疫苗";
		String[] SIds = new String[]{"jzrq22:HR42_02_065_022","jzbw22:cbjzbw_022","ymph22:HR53_03_001_02_022","yxrq22:cbyxrq_022","scqy22:HR53_99_001_022","jzys22:HR22_01_020_022","bz22:cbbz_022",
				"jzrq23:HR42_02_065_023","jzbw23:cbjzbw_023","ymph23:HR53_03_001_02_023","yxrq23:cbyxrq_023","scqy23:HR53_99_001_023","jzys23:HR22_01_020_023","bz23:cbbz_023"};
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
		public ACEpidemicEncephalitisVaccineMeta(){
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

