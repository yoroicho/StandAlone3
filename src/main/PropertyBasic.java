package main;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyBasic {

private int i;


public static void main(String[] args) {

PropertyBasic ps = new PropertyBasic();
ps.getProp();
}


public void getProp(){

//プレーンテキストを使用したプロパティ情報の取得
Properties propText = new Properties();
Class<? extends PropertyBasic> thisClass = this.getClass();
/*try {

propText.load(new InputStreamReader(thisClass.getResourceAsStream("/jp/co/ctc/sample/sampleapp/prop/prop_text.txt")));
System.out.println(propText.getProperty("123"));
System.out.println(propText.getProperty("@@@"));
System.out.println(propText.getProperty("abc"));
System.out.println(propText.getProperty("年収"));

} catch (IOException e) {
e.printStackTrace();
}
*/
//XMLを使用したプロパティ情報の取得
try {
propText.loadFromXML(thisClass.getResourceAsStream("/main/prop_xml.xml"));
System.out.println(propText.getProperty("key"));
System.out.println(propText.getProperty("プロパティ"));
i = 1;
while(propText.getProperty(Integer.toString(i))!=null){
	 
	  System.out.println(i);
	  System.out.println(propText.getProperty(Integer.toString(i)));
	  i++;
}

} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}
}

}
