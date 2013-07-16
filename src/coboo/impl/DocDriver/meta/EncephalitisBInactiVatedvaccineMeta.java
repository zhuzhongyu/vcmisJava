 package coboo.impl.DocDriver.meta;



/**
	 * 乙脑灭活疫苗 
	 * HR42_02_065_026,cbjzbw_026,HR53_03_001_02_026,cbyxrq_026,HR53_99_001_026,HR22_01_020_026,cbbz_026,
	 * HR42_02_065_027,cbjzbw_027,HR53_03_001_02_027,cbyxrq_027,HR53_99_001_027,HR22_01_020_027,cbbz_027,
	 * HR42_02_065_028,cbjzbw_028,HR53_03_001_02_028,cbyxrq_028,HR53_99_001_028,HR22_01_020_028,cbbz_028,
	 * HR42_02_065_029,cbjzbw_029,HR53_03_001_02_029,cbyxrq_029,HR53_99_001_029,HR22_01_020_029,cbbz_029
	 */
public	class EncephalitisBInactiVatedvaccineMeta extends Meta {
		public String metaname="乙脑灭活疫苗";
		String[] SIds = new String[]{"jzrq26:HR42_02_065_026","jzbw_026:cbjzbw_026","ymph26:HR53_03_001_02_026","yxrq26:cbyxrq_026","scqy26:HR53_99_001_026","jzys26:HR22_01_020_026","bz26:cbbz_026",
				"jzrq27:HR42_02_065_027","jzbw27:cbjzbw_027","ymph27:HR53_03_001_02_027","yxrq27:cbyxrq_027","scqy27:HR53_99_001_027","jzys27:HR22_01_020_027","bz27:cbbz_027",
				"jzrq28:HR42_02_065_028","jzbw28:cbjzbw_028","ymph28:HR53_03_001_02_028","yxrq28:cbyxrq_028","scqy28:HR53_99_001_028","jzys28:HR22_01_020_028","bz28:cbbz_028",
				"jzrq29:HR42_02_065_029","jzbw29:cbjzbw_029","ymph29:HR53_03_001_02_029","yxrq29:cbyxrq_029","scqy29:HR53_99_001_029","jzys29:HR22_01_020_029","bz29:cbbz_029"};
		String[] SValues = new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
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
		public EncephalitisBInactiVatedvaccineMeta(){
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
