 package coboo.impl.DocDriver.meta;


/**
	 * 建档日期
	 * cbjdrqn,cbjdrqy,cbjdrqr
	 * @author WangZhendong
	 *
	 */
	// ========================================================================
	// 建档日期
public	class FileBuildingDateMeta extends Meta {
		public String metaname="建档日期";
		String[] SIds = new String[] {"cbjdrqn:jdrqn","cbjdrqy:ndrqy","cbjdrqr:jdrqr"};
		String[] SValues = new String[]{"","",""};
		String HValue="";
		
		void con_hvalue2svalue(String humanReadValue) {
			String[] valueList = new String[3];
			valueList = humanReadValue.split("/");
			for(int i=0;i<valueList.length;i++){
				SValues[i]=valueList[i];
			}
			
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
		for(int i=0;i<storeValueList.length;i++){
			HValue +=storeValueList[i];
			if(i<storeValueList.length-1)
			HValue +="/";
		}
			top();
			return;
		}
		public FileBuildingDateMeta(){
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
