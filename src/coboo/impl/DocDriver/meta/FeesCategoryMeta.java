 package coboo.impl.DocDriver.meta;

	/**
	 * 费别
	 * zf,gf, bx, qt
	 * @author WangZhendong
	 *
	 */
	// ============================== 费别 ============================== 
public	class FeesCategoryMeta extends Meta {
		public String metaname="费别";
		String[] SIds = new String[]{ "zf","gf", "bx", "qt" };
		String[] SValues = new String[]{"","","",""};
		String HValue;
		

		void con_hvalue2svalue(String humanReadValue) {		
			String[] readValueList =	humanReadValue.split("/");
			for(int i=0; i<readValueList.length; i++) {
				String value = readValueList[i];
				if(value.equals("自费")) {
					SValues[0]="true";
				}else if(value.equals("公费")) {
					SValues[1]="true";
				}else if(value.equals("保险")) {
					SValues[2]="true";
				}else if(value.equals("其他")) {
					SValues[3]="true";
				}
			}
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {		
			HValue ="";
			if(storeValueList[0].equals("true")){
				HValue +="自费/";
			}
			if(storeValueList[1].equals("true")) {
				HValue += "公费/";
			}
			if(storeValueList[2].equals("true")) {
				HValue += "保险/";
			}
			if(storeValueList[3].equals("true")) {
				HValue += "其他/";
			}		
			top();
			return;
		}
		public FeesCategoryMeta(){
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