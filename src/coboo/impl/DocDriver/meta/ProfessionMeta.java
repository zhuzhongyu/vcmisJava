 package coboo.impl.DocDriver.meta;



	/**
	 * 职业 对应字段 HR02_07_001
	 * 
	 * @author 任笑言
	 */
public	class ProfessionMeta extends Meta {
	public String metaname="职业";
	String[] SIds = new String[]{"zy:HR02_07_001"};
	String[] SValues = new String[]{""};
	String HValue;	
	

		void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("国家机关、党群组织、企业、事业单位负责人")) {
				SValues[0] = "1";
			}
			if (humanReadValue.equals("专业技术人员")) {
				SValues[0] = "2";
			}
			if (humanReadValue.equals("办事人员和相关人员")) {
				SValues[0] = "3";
			}
			if (humanReadValue.equals("商业、服务业人员")) {
				SValues[0] = "4";
			}
			if (humanReadValue.equals("农、林、牧、渔、水利业生产人员")) {
				SValues[0] = "5";
			}
			if (humanReadValue.equals("生产、运输设备操作人员及有关人员")) {
				SValues[0] = "6";
			}
			if (humanReadValue.equals("军人")) {
				SValues[0] = "7";
			}
			if (humanReadValue.equals("不便分类的其他从业人员")) {
				SValues[0] = "8";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (SValues[0].equals("1"))
				HValue = "国家机关、党群组织、企业、事业单位负责人";
			if (SValues[0].equals("2"))
				HValue = "专业技术人员";
			if (SValues[0].equals("3"))
				HValue = "办事人员和相关人员";
			if (SValues[0].equals("4"))
				HValue = "商业、服务业人员";
			if (SValues[0].equals("5"))
				HValue = "农、林、牧、渔、水利业生产人员";
			if (SValues[0].equals("6"))
				HValue = "生产、运输设备操作人员及有关人员";
			if (SValues[0].equals("7"))
				HValue = "军人";
			if (SValues[0].equals("8"))
				HValue = "不便分类的其他从业人员";
			top();
			return;
		}
		public ProfessionMeta(){
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
