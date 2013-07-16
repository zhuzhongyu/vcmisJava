 package coboo.impl.DocDriver.meta;



/**
	 * 家族史
	 * HR51_01_002_02,HR51_01_002_03, HR51_01_002_04,HR51_01_002_01
	 */
public	class FamilyMedicalHistoryMeta extends Meta{
		public String metaname="家族史";
		String[] SIds = new String[]{"jzs2:HR51_01_002_01","jzs3:HR51_01_002_02", "jzs4:HR51_01_002_03","jzs:HR51_01_002_04"};
		String[] SValues = new String[]{"","","",""};
		String HValue;	
		
		
		
		void con_hvalue2svalue(String humanReadValue) {
			
			String readValueList[] = new String[4];	
			readValueList =	humanReadValue.split("/");
			if(readValueList[0].equals("1")) {
				
				SValues[0]="1";	SValues[1]="";
				SValues[2]="";	SValues[3]="";
		
			}else {
				
				SValues[0]=readValueList[0];
				SValues[1]=readValueList[1];
				SValues[2]=readValueList[2];
				SValues[3]=readValueList[3];
	
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = storeValueList[0]+"/"+storeValueList[1]+"/"+storeValueList[2]+"/"+storeValueList[3];
			top();
			return;
		}
		public FamilyMedicalHistoryMeta(){
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