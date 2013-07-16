 package coboo.impl.DocDriver.meta;


/**
	 * 住院治疗情况--住院史  hospitalization history
	 * HR42_02_104_1,HR42_02_105_1,HR54_01_009_1,HR21_01_031_1,HR01_00_010_1,
	   HR42_02_104_2,HR42_02_105_2,HR54_01_009_2,HR21_01_031_2,HR01_00_010_2
	 */
public	class HospitalizationHistoryMeta extends Meta {
		public String metaname="住院治疗情况--住院史";
		String[] SIds = new String[]{ "ryrq:HR42_02_104_1","cyrq:HR42_02_105_1","zysyy1:HR54_01_009_1","zysyljgmc1:HR21_01_031_1","zysbah1:HR01_00_010_1",
				"ryrq1:HR42_02_104_2","cyrq1:HR42_02_105_2","zysyy2:HR54_01_009_2","zysyljgmc2:HR21_01_031_2","zysbah2:HR01_00_010_2"};
		String[] SValues = new String[]{"","","","","","","","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			String[] readValueList = new String[10];	
			readValueList =	humanReadValue.split("/");
			for(int i =0;i<readValueList.length;i++){
				SValues[i] = readValueList[i];
			}top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = "";
			for(int i=0;i<storeValueList.length;i++) {
				
				if(i<(storeValueList.length-1)){
					HValue+=storeValueList[i]+"/";
				}else{
					HValue+=storeValueList[i];
				}
			}top();
			return;
		}
		public HospitalizationHistoryMeta(){
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