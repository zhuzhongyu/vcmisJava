 package coboo.impl.DocDriver.meta;


/**
     * 运动
     * @author WangZhendong
     * HR51_01_184_31 次/周 HR51_01_182_31 分钟/次
     * HR51_01_184_32 次/周 HR51_01_182_32 分钟/次
     */
public	class FourthTimeSportsMeta extends Meta {
	public String metaname=" 第二次随访--用药情况--用法2--每日几次";
	String[] SIds = new String[]{"ydz7:HR51_01_184_31","ydfz7:HR51_01_182_31",
            "ydz8:HR51_01_184_32","ydfz8:HR51_01_182_32" };
	String[] SValues = new String[]{"","","",""};
	String HValue;	

		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
		 */
		void con_hvalue2svalue(String humanReadValue) {
			String[] valueList = new String[4];
			valueList = humanReadValue.split("/");
			SValues[0] = valueList[0];
			SValues[1] = valueList[1];
			SValues[2] = valueList[2];
			SValues[3] = valueList[3];
			top();
			return;
		}
		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
		 */
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = storeValueList[0]  + "/" + storeValueList[1] 
			                 + "/" + storeValueList[2] + "/" + storeValueList[3];
			top();
			return;
		}
		public FourthTimeSportsMeta(){
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
	