 package coboo.impl.DocDriver.meta;


	/**
	 * 现存主要健康问题--肾脏疾病 Kidney disease
	 * HR51_02_151_1,HR51_02_151_2,HR51_02_151_3,HR51_02_151_4,HR51_02_151_5,HR51_02_151_6
	 */
public	class KidneyDiseaseMeta extends Meta {
		public String metaname="现存主要健康问题--肾脏疾病";
		String[] SIds = new String[]{ "szjb:HR51_02_151_1","szjb1:HR51_02_151_2","szjb2:HR51_02_151_3","szjb3:HR51_02_151_4","szjb4:HR51_02_151_5","szjb5:HR51_02_151_6"};
		String[] SValues = new String[]{"","","","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			boolean healthFlag=false; //判断是否健康 
			int num =-1;			  //保存健康标志在第几个空
			boolean ortherFlag=false; //判断是否有其他
			
			String[] readValueList = new String[6];	
			readValueList =	humanReadValue.split("/");
			
			for(int i=0;i<readValueList.length;i++) {
				
				if(readValueList[i].equals("1")){
					healthFlag = true;
					num=i;
				}
				if(readValueList[i].equals("6")){
					ortherFlag = true;
				}
			}
			
			if(healthFlag) {
				
				for(int i=0;i<readValueList.length;i++){
					if(i == num){
						SValues[i] = readValueList[i];
					}else{
						SValues[i] = "";
					}
				}
			}else {
				
				for(int i=0;i<readValueList.length;i++){
					
					SValues[i] = readValueList[i];
				}
				if(!ortherFlag) {
					
					SValues[0] = "";
				}
			}	top();
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
				
			}	top();
			return;
		}
		public KidneyDiseaseMeta(){
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