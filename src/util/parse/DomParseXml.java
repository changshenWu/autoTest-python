package util.parse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *利用DOM模式解析APP 页面布局的XML文件
 * */
public class DomParseXml {

	private Document document;
	private HashMap<String, HashMap<String, String>> factorsHashMap;
	private XPath xPath;
    
	public DomParseXml() {
		this.factorsHashMap = new HashMap<String, HashMap<String,String>>();
	}
	
	private void openXmlFile(File xmlFile) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			document = db.parse(xmlFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Element getRootElement() {
		return document.getDocumentElement();
	}

	public void getNodeAttributes(Element element) {
		HashMap< String, String> hashMap = new HashMap<String, String>();
        NamedNodeMap namedNodeMap = element.getAttributes();
		int length = namedNodeMap.getLength();
		if (length == 0) {
			//System.out.println("不用理会这个节点了,这不是我们不需要用的参数");
			return;
		}
		for (int i = 0;i < length; i++) {
			Node node = namedNodeMap.item(i);
			String nodeName = node.getNodeName();
			/*System.out.println(node);
			System.out.println(nodeName);
			System.out.println(node.getTextContent());*/
			if (nodeName.equals("resource-id")) {
				hashMap.put("id", node.getTextContent());
			} else if (nodeName.equals("index")) {
				hashMap.put("index", node.getTextContent());
			} else if (nodeName.equals("instance")) {
				hashMap.put("instance", node.getTextContent());
				factorsHashMap.put(element.getTagName()+"_"+node.getTextContent(), hashMap);
			} else if (nodeName.equals("text")) {
				hashMap.put("text", node.getTextContent());
			} else if (nodeName.equals("class")) {
				hashMap.put("class", node.getTextContent());
			} else if (nodeName.equals("bounds")) {
				hashMap.put("bounds", node.getTextContent());
			}
			
		}
	}

	public void getChildrenNode(Node currNode) {
		NodeList nodeList = currNode.getChildNodes();
		int len = nodeList.getLength();
		if (len == 0) {
			//System.out.println("哥们,到底了,没下一个节点了!");
			return;
		}
		
		for (int i= 0;i < len; i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				//System.out.println(node.getNodeName());
				getNodeAttributes((Element)node);
				getChildrenNode(node);

			}
		}	
	}

	public int getChildCount(Node node) {
		return node.getChildNodes().getLength();	
	}

	public boolean isLeaf(Node node) {
		return getChildCount(node) == 0;
	}
    
    /**
     * 返回定位元素标志的HashMap对象
     * @return  HashMap<String, HashMap<String,String>>
     * HashMap<节点名称,<子节点名称,子节点的属性值>>
     * */
	public HashMap<String, HashMap<String,String>> getFactorsHashMap(File xmlFile) {
		openXmlFile(xmlFile);
		getChildrenNode(getRootElement());
		
		//调试用的代码
		System.out.println(factorsHashMap.size());
		for (String key : factorsHashMap.keySet()) {
			System.out.println(key);
			HashMap<String, String> attrHashMap = factorsHashMap.get(key);
			for (String attributeName : attrHashMap.keySet()) {
				System.out.println(attributeName + " = "+attrHashMap.get(attributeName));	
			}
			System.out.println("************************************");
		}
		return factorsHashMap;
	}
	
	public void xpathParseXml() {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		xPath =  xPathFactory.newXPath();
		try {
			String result = xPath.evaluate("*", document);
			System.out.println(result);
		} catch (XPathExpressionException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DomParseXml px = new DomParseXml();
		px.getFactorsHashMap(new File("element.xml"));
	}
}
