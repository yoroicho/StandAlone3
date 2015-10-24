
// http://qiita.com/opengl-8080/items/2cb3d0027a867e35029e

package xmlA;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class MainWrite {

    public static void main(String[] args) throws Exception {



        Properties prop = new Properties();
        prop.setProperty("hoge", "ほげ");
        prop.setProperty("fuga", "ふが");
        prop.setProperty("piyo", "ぴよ");


        try (OutputStream os = new FileOutputStream("prop.xml")) {
            prop.storeToXML(os, "コメント");

        }
    }
}