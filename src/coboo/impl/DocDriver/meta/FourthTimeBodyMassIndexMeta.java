 package coboo.impl.DocDriver.meta;


/**
	 * 体质指数
	 * HR51_02_021_4
	 * @author WangZhendong
	 */
public	class FourthTimeBodyMassIndexMeta extends Meta {
		public String metaname=" 体质指数";
		String[] SIds = new String[]{ "tzzs4:HR51_02_021_4"};
		String[] SValues = new String[]{""};
		String HValue;	

		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
		 */
		void con_hvalue2svalue(String humanReadValue) {
			SValues[0] = humanReadValue;
			top();
			return;
		}
		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
		 */
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = storeValueList[0];
			top();
			return;
		}
		public FourthTimeBodyMassIndexMeta(){
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