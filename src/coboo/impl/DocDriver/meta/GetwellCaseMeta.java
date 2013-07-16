 package coboo.impl.DocDriver.meta;



/**
	 * 既往医疗，康复情况
	 * 对应字段 cbxldjkfqk_ss, cbxldjkfqk_ywzl, cbxldjkfqk_ctff,
	 * cbxldjkfqk_ll, cbxldjkfqk_kfxl, cbxldjkfqk_qt, cbxldjkfqk_syjz
	 * @author 任笑言
	 */
public	class GetwellCaseMeta extends Meta {
	public String metaname="既往医疗，康复情况";
	String[] SIds = new String[] { "cbxldjkfqk_ss:ss","cbxldjkfqk_ywzl:ywzl", "cbxldjkfqk_ctff:ctff", "cbxldjkfqk_ll:ll","cbxldjkfqk_kfxl:kfxl", "cbxldjkfqk_qt", "cbxldjkfqk_syjz"} ;
	String[] SValues = new String[]{"","","","","","",""};
	String HValue;
	
	
		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
		 */
		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[7];
			readValueList = humanReadValue.split("/");
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = readValueList[4];
			SValues[5] = readValueList[5];
			SValues[6] = readValueList[6];
			top();
			return;
		}
		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
		 */
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = "";
			if (storeValueList[0].equals("true")) {
				HValue += "手术/";
			}
			if (storeValueList[1].equals("true")) {
				HValue += "药物治疗/";
			}
			if (storeValueList[2].equals("true")) {
				HValue += "传统方法/";
			}
			if (storeValueList[3].equals("true")) {
				HValue += "理疗/";
			}
			if (storeValueList[4].equals("true")) {
				HValue += "康复训练/";
			}
			if (storeValueList[5].equals("true")) {
				HValue += "其他/";
			}
			if (storeValueList[6].equals("true")) {
				HValue += "使用假肢、矫形器及辅助用具/";
			}
			top();
			return;
		}
		public GetwellCaseMeta(){
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