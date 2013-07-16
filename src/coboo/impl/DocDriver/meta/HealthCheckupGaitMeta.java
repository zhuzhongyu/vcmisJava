 package coboo.impl.DocDriver.meta;


	/**
	 * 体格检查:步态 对应字段 cbbt1,cbbt2
	 * 
	 * @author 任笑言
	 */
	public class HealthCheckupGaitMeta extends Meta {
		public String metaname="体格检查:面色";
		String[] SIds = new String[]{"cbbt1", "cbbt2"};
		String[] SValues = new String[]{"",""};
		String HValue;	
		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[2];
			readValueList = humanReadValue.split("/");
			if (readValueList[0].equals("正常") && readValueList[1].equals("")) {
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
				form = "正常";
			} else {
				form = "异常";
				line = storeValueList[1];
			}
			HValue = form + "/" + line;
			top();
			return;
		}
		public HealthCheckupGaitMeta(){
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