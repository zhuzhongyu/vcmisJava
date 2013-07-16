package com.common;


public class ConfigBean {
	
	private String name;
	private String url;

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("<mainConfig>\n");
		sb.append("<name>").append(this.name).append("</name>\n");
		sb.append("<URL>").append(url).append("</URL>\n");
		sb.append("</mainConfig>");
		return sb.toString();
	}
	
	
	/**
	 * @return ���� url��
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url Ҫ���õ� url��
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return ���� name��
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Ҫ���õ� name��
	 */
	public void setName(String name) {
		this.name = name;
	}

}