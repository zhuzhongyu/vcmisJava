/**
 * 
 */
package coboo.impl.DocDriver;

/**
 * @author zzy
 *
 */
public interface IDocDriver {

	/**
	 * 根据Table的类的名称，获取该类表格在个人档案树中的相对路径
	 */

	public abstract String getRpath(String className);

	/**
	 * 获取档案xml(SValue)字符串
	 */
	public abstract String getDocument(String Docfilename);

	/**
	 * @param personId 身份证号
	 * @param tableClassName able 的类的名称
	 * @return 文件名数组
	 */
	public abstract String[][] getDocList(String personId, String tableClassName);

}