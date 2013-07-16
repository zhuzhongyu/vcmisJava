 package coboo.impl.DocDriver.meta;


 /**
	 * 药物依从性
	 * HR51_01_179_4
	 * @author WangZhendong
	 *
	 */
    public class FourthTimeDrugComplianceMeta extends Meta {
    	public String metaname=" 药物依从性 ";
		String[] SIds = new String[]{ "fyycx4:HR51_01_179_4"};
		String[] SValues = new String[]{""};
		String HValue;	

    	/*
    	 * (non-Javadoc)
    	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
    	 */
    	void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("规律")) {
				SValues[0] = "1";
			}
			if (humanReadValue.equals("间断")) {
				SValues[0] = "2";
			}
			if (humanReadValue.equals("不服药")) {
				SValues[0] = "3";
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
				HValue = "规律";
			if (storeValueList[0].equals("2"))
				HValue = "间断";
			if (storeValueList[0].equals("3"))
				HValue = "不服药";
			top();
			return;
		}
		public FourthTimeDrugComplianceMeta(){
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
  