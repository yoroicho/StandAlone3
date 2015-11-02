/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;


 
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BarcodeCodabar;
import com.itextpdf.text.pdf.BarcodeDatamatrix;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BarcodeInter25;
import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.BarcodePostnet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
import javax.imageio.ImageIO;
 

 
public class MakeBarcode {
 private static final Color COLOR_FORE = Color.BLACK;
 private static final Color COLOR_BACK = Color.WHITE;
 private static final String CODE_CODE128 = "yu1row.com";
 private static final String CODE_CODE39 = "YU1ROW.COM";
 private static final String CODE_CODEBAR = "A12345B";
 private static final String CODE_DATAMATRIX = "DATAMATRIX!";
 private static final String CODE_EAN = "49111111111111";
 private static final String CODE_INTER25 = "1234";
 private static final String CODE_PDF417 = "yu1row.com";
 private static final String CODE_POSTNET = "555551234";
 
 public static void main(String[] args) {
  make(new Barcode128(), CODE_CODE128, "CODE128.png");
  make(new Barcode39(), CODE_CODE39, "CODE39.png");
  make(new BarcodeCodabar(), CODE_CODEBAR, "CODEBAR.png");
  make(new BarcodeDatamatrix(), CODE_DATAMATRIX, "DATAMATRIX.png");
  make(new BarcodeEAN(), CODE_EAN, "EAN.png");
  make(new BarcodeInter25(), CODE_INTER25, "INTER25.png");
  make(new BarcodePDF417(), CODE_PDF417, "PDF417.png");
  make(new BarcodePostnet(), CODE_POSTNET, "POSTNET.png");
 }
 
 private static boolean make(Barcode barcode, String code, String fileName) {
  barcode.setCode(code);
  return writeToPngFile(barcode.createAwtImage(COLOR_FORE, COLOR_BACK), fileName);
 }
 
 private static boolean make(BarcodeDatamatrix barcode, String code, String fileName) {
  try {
   barcode.generate(code);
   return writeToPngFile(barcode.createAwtImage(COLOR_FORE, COLOR_BACK), fileName);
  } catch (UnsupportedEncodingException e) {
   return false;
  }
 }
 
 private static boolean make(BarcodePDF417 barcode, String code, String fileName) {
  barcode.setText(code);
  return writeToPngFile(barcode.createAwtImage(COLOR_FORE, COLOR_BACK), fileName);
 }
 
 private static boolean writeToPngFile(Image image, String fileName) {
 
  // ImageをBufferedImageに変換
  BufferedImage bimg = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
  Graphics g = bimg.getGraphics();
  g.drawImage(image, 0, 0, null);
  g.dispose();
 
  // BufferedImageをファイルに保存
  try {
   ImageIO.write(bimg, "PNG", new File(fileName));
  } catch (IOException e) {
   return false;
  }
  return true;
 }
}
