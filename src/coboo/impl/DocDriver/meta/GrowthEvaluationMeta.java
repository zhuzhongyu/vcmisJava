 package coboo.impl.DocDriver.meta;


	/**
	 * 体格发育评价 对应字段 HR51_02_118
	 * 
	 * @author 任笑言
	 */
public	class GrowthEvaluationMeta extends Meta {
		
			public String metaname="体格发育评价";
			String[] SIds = new String[]{"tgpj"};
			String[] SValues = new String[]{""};
			String HValue;	


		void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("正常")) {
				SValues[0] = "1";
			} else if (humanReadValue.equals("低体重")) {
				SValues[0] = "2";
			} else if (humanReadValue.equals("消瘦")) {
				SValues[0] = "3";
			} else if (humanReadValue.equals("发育迟缓")) {
				SValues[0] = "4";
			} else if (humanReadValue.equals("肥胖")) {
				SValues[0] = "5";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (storeValueList[0].equals("1")) {
				HValue = "正常";
			} else if (storeValueList[0].equals("2")) {
				HValue = "低体重";
			} else if (storeValueList[0].equals("3")) {
				HValue = "消瘦";
			} else if (storeValueList[0].equals("4")) {
				HValue = "发育迟缓";
			} else if (storeValueList[0].equals("5")) {
				HValue = "肥胖";
			}
			top();
			return;
		}
		public GrowthEvaluationMeta(){
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