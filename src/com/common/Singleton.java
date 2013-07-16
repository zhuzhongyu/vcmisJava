package com.common;

import org.apache.lucene3_4.index.IndexReader;

public class Singleton {
	
	/** * 私有静态对象,加载时候不做初始化 */
	private static Singleton m_intance = null;

	/** * 私有构造方法,避免外部创建实例 */
	private Singleton() {
	}
	
	public IndexReader[] readers = new IndexReader[2];

	/**
	 * * 静态工厂方法,返回此类的唯一实例.* 当发现实例没有初始化的时候,才初始化. *
	 * 
	 * @return LazySingleton
	 */
	synchronized public static Singleton getInstance() {
		if (m_intance == null) {
			m_intance = new Singleton();
		}
		return m_intance;
	}
}
