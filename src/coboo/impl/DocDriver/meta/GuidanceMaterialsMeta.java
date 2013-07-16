 package coboo.impl.DocDriver.meta;



	/**
	 * 训练指导材料
	 * 对应字段 cbxlzdcl_ztcjxtkfxl, cbxlzdcl_kfzdcs, cbxlzdcl_kfxlpj,
	 * cbxlzdcl_ztcjkf, cbxlzdcl_sclrd
	 * @author 任笑言
	 */
public	class GuidanceMaterialsMeta extends Meta {
		public String metaname="训练指导材料";
		String[] SIds = new String[]{ "cbxlzdcl_ztcjxtkfxl:ztcjxt",
				"cbxlzdcl_kfzdcs:kfzdcs", "cbxlzdcl_kfxlpj:kfxxpj", "cbxlzdcl_ztcjkf:ztcjkf",
				"cbxlzdcl_sclrd:sclrd"};
		String[] SValues = new String[]{"","","","",""};
		String HValue;

		/*
		 * (non-Javadoc)
		 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
		 */
		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[5];
			readValueList = humanReadValue.split("/");
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = readValueList[4];
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
				HValue += "《肢体残疾系统康复训练》 (中国残联编)/";
			}
			if (storeValueList[1].equals("true")) {
				HValue += "《康复指导丛书》 (中国残联编)/";
			}
			if (storeValueList[2].equals("true")) {
				HValue += "康复训练普及读物(中国残联编)/";
			}
			if (storeValueList[3].equals("true")) {
				HValue += "肢体残疾系统康复训练的音像制品(中国残联编)/";
			}
			if (storeValueList[4].equals("true")) {
				HValue += "省残联认定的训练指导材料/";
			}
			top();
			return;
		}
		public GuidanceMaterialsMeta(){
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