 package coboo.impl.DocDriver.meta;

/**
 * 婚姻状况 对应字段 HR02_06_001
 * 
 * @author 任笑言
 */

	public class MarriageStatueMeta extends Meta {
		public String metaname="婚姻状况";
			String[] SIds = new String[] { "hyzk:HR02_06_001:hf"};
			String[] SValues = new String[]{""};
			String HValue;
			
	
			// ================数据元两种格式转换=================

			void con_hvalue2svalue(String h) {
				if (h.equals("未婚")) {
					SValues[0] = "1";
				}
				if (h.equals("已婚")) {
					SValues[0] = "2";
				}
				if (h.equals("丧偶")) {
					SValues[0] = "3";
				}
				if (h.equals("离婚")) {
					SValues[0] = "4";
				}
				if (h.equals("未说明的婚姻状况")) {
					SValues[0] = "5";
				}
				top();
				return;
			}
			void con_svalue2hvalue(String[] s) {
				if (SValues[0].equals("1"))
					HValue = "未婚";
				if (SValues[0].equals("2"))
					HValue = "已婚";
				if (SValues[0].equals("3"))
					HValue = "丧偶";
				if (SValues[0].equals("4"))
					HValue = "离婚";
				if (SValues[0].equals("5"))
					HValue = "未说明的婚姻状况";
				top();
				return;
			}

			public MarriageStatueMeta(){
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