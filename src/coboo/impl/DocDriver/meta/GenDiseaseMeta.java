 package coboo.impl.DocDriver.meta;


/**
	 * 遗传病史 对应字段 HR51_01_002_29,HR51_01_002_30
	 * 
	 * @author 任笑言
	 */
public	class GenDiseaseMeta extends Meta {

	
	public String metaname="遗传病史";
	String[] SIds = new String[]{"ycbx_name:HR51_01_002_29",
			"ycbs:HR51_01_002_30"};
	String[] SValues = new String[]{"",""};
	String HValue;	
	
		void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("无")) {
				SValues[0] = "";
				SValues[1] = "1";
			} else {
				SValues[0] = humanReadValue;
				SValues[1] = "2";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (SValues[1].equals("1"))
				HValue = "无";
			if (SValues[1].equals("2")){
				HValue = storeValueList[0];
			}
			top();
			return;
		}
		public GenDiseaseMeta(){
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