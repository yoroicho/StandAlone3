/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psManage;




import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.Key;
//import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * AES暗号化のテスト
 *
 * @author karura
 *
 */
public class CipherAES128 {

    // 定数
    private static final int KEY_LENGTH = 128;  // 共通鍵の長さ[bit]
    private static final int BLOCK_LENGTH = 128;  // ブロック長[bit]

    // In and out.
    public static String encrypteCipherAES128(String preKeyStr,String plainText) throws Exception {
        // AES暗号オブジェクト・CBC用の初期ベクトルの作成
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[BLOCK_LENGTH / 8]);

        // AES暗号鍵(SecureRandomで作成したランダム値)の作成
        //Key             key     = null;
        //KeyGenerator    keyGen  = KeyGenerator.getInstance( "AES" );
        //keyGen.init( KEY_LENGTH );
        //key = keyGen.generateKey();
        
        // AES暗号鍵(指定値)の作成。任意の文字列(128bit)を利用する場合
        byte[] keyStr = preKeyStr.getBytes();
        Key key = new SecretKeySpec(keyStr, "AES");

        // 共通鍵
        //System.out.println(String.format("Key(hex)    : %s", toHexStr(key.getEncoded())));

        // 平文
        byte[] plain = plainText.getBytes();
        System.out.println(String.format("Plain       : %s", new String(plain)));
        //System.out.println(String.format("Plain(hex)  : %s", toHexStr(plain)));

        // 暗号文
        c.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encode = c.doFinal(plain);
        // Base64エンコード
        String encryptedText = Base64.encode(encode);
        System.out.println(encryptedText);
        System.out.println(String.format("Encode      : %s", new String(encode)));
        //System.out.println(String.format("Encode(hex) : %s", toHexStr(encode)));

        // 復号文
        
        // Base64エンコードされた文字列をデコード
        byte[] encrypted = Base64.decode(encryptedText);
        
        c.init(Cipher.DECRYPT_MODE, key, iv);
        //byte[] decode = c.doFinal(encode);
        byte[] decode = c.doFinal(encrypted);
        System.out.println(String.format("Decode      : %s", new String(decode)));
        //System.out.println(String.format("Decode(hex) : %s", toHexStr(decode)));

        return encryptedText;
    }
    
    /**
     * 起動関数
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new CipherAES128();
    }

    /**
     * コンストラクタ
     *
     * @throws Exception
     */
    public CipherAES128() throws Exception {
        // AES暗号オブジェクト・CBC用の初期ベクトルの作成
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[BLOCK_LENGTH / 8]);

        // AES暗号鍵(SecureRandomで作成したランダム値)の作成
        Key             key     = null;
        KeyGenerator    keyGen  = KeyGenerator.getInstance( "AES" );
        keyGen.init( KEY_LENGTH );
        key = keyGen.generateKey();
        
        // AES暗号鍵(指定値)の作成。任意の文字列(128bit)を利用する場合
        //byte[] keyStr = "1234567890ABCDEF".getBytes();
        //Key key = new SecretKeySpec(keyStr, "AES");

        // 共通鍵
        System.out.println(String.format("Key(hex)    : %s", toHexStr(key.getEncoded())));

        // 平文
        byte[] plain = "This is plain text.".getBytes();
        System.out.println(String.format("Plain       : %s", new String(plain)));
        System.out.println(String.format("Plain(hex)  : %s", toHexStr(plain)));

        // 暗号文
        c.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encode = c.doFinal(plain);
        // Base64エンコード
        String encryptedText = Base64.encode(encode);
        System.out.println(encryptedText);
        System.out.println(String.format("Encode      : %s", new String(encode)));
        System.out.println(String.format("Encode(hex) : %s", toHexStr(encode)));

        // 復号文
        
        // Base64エンコードされた文字列をデコード
        byte[] encrypted = Base64.decode(encryptedText);
        
        c.init(Cipher.DECRYPT_MODE, key, iv);
        //byte[] decode = c.doFinal(encode);
        byte[] decode = c.doFinal(encrypted);
        System.out.println(String.format("Decode      : %s", new String(decode)));
        System.out.println(String.format("Decode(hex) : %s", toHexStr(decode)));

    }

    /**
     * byte配列を16進数表記の文字列に変換
     *
     * @param bytes
     * @return
     */
    protected String toHexStr(byte[] bytes) {
        // 戻り値用変数の準備
        String hexStr = "";

        // byte配列の要素を1つずつ16進数に変換
        for (byte b : bytes) {
            hexStr += String.format("%02x", b);
        }

        // 戻り値を返す
        return hexStr;
    }

}
