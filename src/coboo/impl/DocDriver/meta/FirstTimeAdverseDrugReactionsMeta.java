 package coboo.impl.DocDriver.meta;

   /**
	 * 药物不良反应
	 * cbywblfy1
	 * @author WangZhendong
	 *
	 */
public   class FirstTimeAdverseDrugReactionsMeta extends Meta {
    	public String metaname="药物不良反应";
		String[] SIds = new String[]{"ywblfy1","s1:cbywblfy1"};
		String[] SValues = new String[]{"",""};
		String HValue;	

    	/*
    	 * (non-Javadoc)
    	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
    	 */
    	void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("无")) {
				SValues[0] = "1";
			}
			else if (humanReadValue.equals("有")) {
				SValues[0] = "2";
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
				HValue = "无";
			else if (storeValueList[0].equals("2"))
				HValue = "有";
			else
				HValue = "";
			top();
			return;
		}
		public FirstTimeAdverseDrugReactionsMeta(){
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