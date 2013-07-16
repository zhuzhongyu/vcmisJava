package com.coboo.userRights;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String cuc = "1.0.0.0";
		String maxUserCode = "1.2.0.0";
		String[] code = cuc.split("\\.");
		String[] code1 = maxUserCode.split("\\.");
		String reStr = "";
		for(int i = 0;i<code.length;i++){
			if(code[i].equals("0")){
				code1[i] = String.valueOf(Integer.valueOf(code1[i]).intValue() + 1);
				break;
			}
		}
		
		for(int j=0;j<code1.length;j++){
			reStr += code1[j];
			if(j < code1.length-1){
				reStr +=".";
			}
		}
		System.out.println(reStr);

	}

}
