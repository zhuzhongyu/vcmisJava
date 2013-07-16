 package coboo.impl.DocDriver.meta;


	/**
	 * 体格检查:眼 对应字段 HR51_02_197_1,HR51_02_197_2
	 * 
	 * @author 任笑言
	 */
public	class HealthCheckupEyeMeta extends Meta {
	public String metaname=" 体格检查:眼";
	String[] SIds = new String[]{ "tj5","tj7" };
	String[] SValues = new String[]{"",""};
	String HValue;	
	

		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[2];
			readValueList = humanReadValue.split("/");
			if (readValueList[0].equals("未见异常") && readValueList[1].equals("")) {
				SValues[0] = "1";
				SValues[1] = "";
			} else {
				SValues[0] = "2";
				SValues[1] = readValueList[1];
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			String form = "";
			String line = "";
			if (storeValueList[0].equals("1") && storeValueList[1].equals("")) {
				form = "未见异常";
			} else {
				form = "异常";
				line = storeValueList[1];
			}
			HValue = form + "/" + line;
			top();
			return;
		}
		public HealthCheckupEyeMeta(){
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

	