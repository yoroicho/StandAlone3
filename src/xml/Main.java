package xml;



public class Main {
	public static void main(String[] args) throws Exception {
		XmlReader reader = new XmlReader();
		reader.domRead("src/xml/sample.xml");
	}
}
