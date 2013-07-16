 package coboo.impl.DocDriver.meta;

  /**
	 * 此次随访分类
	 * HR55_01_037_1
	 * @author WangZhendong
	 *
	 */
public  class FirstTimeFollowUpClassificationMeta extends Meta {
    	public String metaname="此次随访分类";
		String[] SIds = new String[]{"sffl1:HR55_01_037_1"};
		String[] SValues = new String[]{""};
		String HValue;	
		

    	/*
    	 * (non-Javadoc)
    	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
    	 */
    	void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("控制满意")) {
				SValues[0] = "1";
			}
			else if (humanReadValue.equals("控制不满意")) {
				SValues[0] = "2";
			}
			else if (humanReadValue.equals("不良反应")) {
				SValues[0] = "3";
			}
			else if (humanReadValue.equals("并发症")) {
				SValues[0] = "4";
			}
			else{
				SValues[0] = "";
			}
			top();
			return;
		}
        /*
         * (non-Javadoc)
         * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
         */
		void con_svalue2hvalue(String[] storeValueList) {
			if (storeValueList[0].equals("1"))
				HValue = "控制满意";
			else if (storeValueList[0].equals("2"))
				HValue = "控制不满意";
			else if (storeValueList[0].equals("3"))
				HValue = "不良反应";
			else if (storeValueList[0].equals("4"))
				HValue = "并发症";
			else
				HValue = "";
			top();
			return;
		}
		public FirstTimeFollowUpClassificationMeta(){
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