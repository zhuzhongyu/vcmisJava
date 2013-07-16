package coboo.impl.DocDriver.meta;

/**
 * 档案编号
 * 
 * @author zzy
 * 
 */
// ======================= 档案编号 ==========================================
public class DocCodeMeta extends Meta {
	public String metaname = "档案编号";
	String[] SIds = new String[] { "s0:HR01_00_006_s1","s1:HR01_00_006_s2","s2:HR01_00_006_s3","s3:HR01_00_006_s4","s4:HR01_00_006_s5","s5:HR01_00_006_s6","s6:HR01_00_006_x1","s7:HR01_00_006_x2","s18:HR01_00_006_x3","HR01_00_006_1","bh1:bh16:HR01_00_006_2", "bh2:bh17:HR01_00_006_3",
			"bh3:bh11:HR01_00_006_4", "bh4:bh12:HR01_00_006_5", "bh5:bh13:HR01_00_006_6", "bh6:bh14:HR01_00_006_7",
			"sbh7:bh7:bh15:HR01_00_006_8" };
	String[] SValues = new String[] { "","", "", "", "", "", "", "","","", "", "", "", "", "", "","" };
	String HValue="";

	// ================数据元两种格式转换=================

	void con_hvalue2svalue(String h) {
		HValue=h;
		SValues[0] = h.substring(0, 1);
		SValues[1] = h.substring(1, 2);
		SValues[2] = h.substring(2, 3);
		SValues[3] = h.substring(3, 4);
		SValues[4] = h.substring(4, 5);
		SValues[5] = h.substring(5, 6);
		SValues[6] = h.substring(6, 7);
		SValues[7] = h.substring(7, 8);
		SValues[8] = h.substring(8, 9);
		SValues[9] = h.substring(9, 10);
		SValues[10] = h.substring(10, 11);
		SValues[11] = h.substring(11, 12);
		SValues[12] = h.substring(12, 13);
		SValues[13] = h.substring(13, 14);
		SValues[14] = h.substring(14, 15);
		SValues[15] = h.substring(15, 16);
		SValues[16] = h.substring(16, 17);
		top();
		return;
		}


	void con_svalue2hvalue(String[] s) {
		SValues=s;
		for(int i=0;i<s.length;i++){
			HValue=HValue+s[i];
		}
		top();
		return;
	}

	public DocCodeMeta() {
		top();
	}

	void top() {
		super.SIds = SIds;
		super.SValues = SValues;
		super.HValue = HValue;
		super.metaname = metaname;
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
