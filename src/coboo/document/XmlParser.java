/**
 * 
 */
package coboo.document;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author user
 *
 */
public class XmlParser {

	/**
	 * @param keyXmlStr 
	 * @return
	 * @throws DocumentException 
	 */
	private String	keys[]		= null;
	private String	values[]	= null;

	public String[] getKeys(String keyXmlStr) {
		if (keys == null) {
			try {
				setKeysAndValues(keyXmlStr);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		return this.keys;

	}

	public String[] getValues(String keyXmlStr) {
		if (keys == null) {
			try {
				setKeysAndValues(keyXmlStr);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		return this.values;

	}
	//keyXmlStr xml字符串，例如<k><gxy>true</gxy><tnb>false</tnb><zl>false</zl><gxb>false</gxb></k>
	private void setKeysAndValues(String keyXmlStr) throws DocumentException {
		Document d = DocumentHelper.parseText(keyXmlStr);
		Element r = d.getRootElement();
		int length = r.nodeCount();
		keys = new String[length];
		values = new String[length];
		int i = 0;
		for (Iterator it = r.elementIterator(); it.hasNext(); i++) {
			Element element = (Element) it.next();
			this.keys[i] = element.getName();
			this.values[i] = element.getText();

		}

		return;
	}

}
