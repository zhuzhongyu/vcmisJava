 package coboo.impl.DocDriver.meta;



	/**
	 * 脊灰疫苗
	 * HR42_02_065_05,cbjzbw_05,HR53_03_001_02_05,cbyxrq_05,HR53_99_001_05,HR22_01_020_05,cbbz_05,
	 * HR42_02_065_06,cbjzbw_06,HR53_03_001_02_06,cbyxrq_06,HR53_99_001_06,HR22_01_020_06,cbbz_06,
	 * HR42_02_065_07,cbjzbw_07,HR53_03_001_02_07,cbyxrq_07,HR53_99_001_07,HR22_01_020_07,cbbz_07,
	 * HR42_02_065_08,cbjzbw_08,HR53_03_001_02_08,cbyxrq_08,HR53_99_001_08,HR22_01_020_08,cbbz_08
	 */
public	class OPVaccineMeta extends Meta {
		public String metaname="脊灰疫苗";
		String[] SIds = new String[]{"jzrq5:HR42_02_065_05","jzbw5:cbjzbw_05","ymph5:HR53_03_001_02_05","yxrq5:cbyxrq_05","scqy5:HR53_99_001_05","jzys5:HR22_01_020_05","bz5:cbbz_05",
				"jzrq6:HR42_02_065_06","jzbw6:cbjzbw_06","ymph6:HR53_03_001_02_06","yxrq6:cbyxrq_06","scqy6:HR53_99_001_06","jzys6:HR22_01_020_06","bz6:cbbz_06",
				"jzrq7:HR42_02_065_07","jzbw7:cbjzbw_07","ymph7:HR53_03_001_02_07","yxrq7:cbyxrq_07","scqy7:HR53_99_001_07","jzys7:HR22_01_020_07","bz7:cbbz_07",
				"jzrq8:HR42_02_065_08","jzbw8:cbjzbw_08","ymph8:HR53_03_001_02_08","yxrq8:cbyxrq_08","scqy8:HR53_99_001_08","jzys8:HR22_01_020_08","bz8:cbbz_08"};
		String[] SValues = new String[]{"","","","","","","",
				"","","","","","","",
				"","","","","","","",
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
	