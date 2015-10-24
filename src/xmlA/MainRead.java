package xmlA;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

public class MainRead {

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream is = new FileInputStream("prop.xml");

        prop.loadFromXML(is); // is はこのメソッドが終了すると close される

        for (Entry<Object, Object> entry : prop.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}