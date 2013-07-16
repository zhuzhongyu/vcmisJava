 package coboo.impl.DocDriver.meta;


/**
	 * 健康指导 Health guide
	 * cbjkzd1,cbjkzd2,cbjkzd3,cbjkzd4
	 */
public class HealthGuideMeta extends Meta {
		public String metaname="健康指导";
		String[] SIds = new String[]{"jkzd1:cbjkzd1","jkzd2:cbjkzd2","jkzd3:cbjkzd3","jkzd4:cbjkzd4"};
		String[] SValues = new String[]{"","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[4];	
			readValueList =	humanReadValue.split("/");
			
			for(int i =0;i<readValueList.length;i++) {
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
		public HealthGuideMeta(){
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