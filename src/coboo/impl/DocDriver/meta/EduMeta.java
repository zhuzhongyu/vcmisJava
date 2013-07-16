 package coboo.impl.DocDriver.meta;
	/**
	 * 文化程度 对应字段 HR02_08_001
	 * 
	 * @author 任笑言
	 */
public class EduMeta extends Meta {

		public String metaname="文化程度";
		String[] SIds = new String[]{"education:HR02_08_001"};
		String[] SValues = new String[]{""};
		String HValue;		
		void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("文盲及半文盲")) {
				SValues[0] = "1";
			}
			if (humanReadValue.equals("小学")) {
				SValues[0] = "2";
			}
			if (humanReadValue.equals("初中")) {
				SValues[0] = "3";
			}
			if (humanReadValue.equals("高中/技校/中专")) {
				SValues[0] = "4";
			}
			if (humanReadValue.equals("大学专科及以上")) {
				SValues[0] = "5";
			}
			if (humanReadValue.equals("不详")) {
				SValues[0] = "6";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (SValues[0].equals("1"))
				HValue = "文盲及半文盲";
			if (SValues[0].equals("2"))
				HValue = "小学";
			if (SValues[0].equals("3"))
				HValue = "初中";
			if (SValues[0].equals("4"))
				HValue = "高中/技校/中专";
			if (SValues[0].equals("5"))
				HValue = "大学专科及以上";
			if (SValues[0].equals("6"))
				HValue = "不详";
			top();
			return;
		}
		public EduMeta(){
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