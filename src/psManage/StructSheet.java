/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psManage;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author
 */
public class StructSheet {

    private String mainTitle; //
    private String subTitle; //
    private String url; // アクセス先、もしくはプログラム名
    private String userName; // パスワードと対になるユーザー名
    private String scanType; //ランダム分割、順読み分割、循環更新、使い捨て更新など
    private String comment; //
    private String thisPassCode; //シートそのものを暗号化する時のパスコード
    private String randomType; // 文字種の分類
    private String randomText; // 具体的な文字指定
    private int passLength; // ひとつあたりの文字数
    private String passCode; // 

    /**
     *
     * @param mainTitle
     * @param subTitle
     * @param url
     * @param userName
     * @param scanType
     * @param comment
     * @param thisPassCode
     * @param passCode
     */
    public StructSheet( // コンストラクタ
            String mainTitle,
            String subTitle,
            String url,
            String userName,
            String scanType,
            String comment,
            String thisPassCode,
            String passCode) {
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.url = url;
        this.userName = userName;
        this.scanType = scanType;
        this.comment = comment;
        this.thisPassCode = thisPassCode;
        this.passCode = passCode;
    }

    public static String getPassCode(String randomType, String randomText, int passLength) {
        if (randomType == null) {
            System.out.println("Null!");
        } else {
            switch (randomType) {
                case "Letters":
                    if (randomText == null || randomText.trim() == "") { //機能していない
                        return "------------------------";
                    }
                    return RandomStringUtils.random(passLength, randomText);
                case "Alphanumeric":
                    return RandomStringUtils.randomAlphanumeric(passLength);
                case "Ascii":
                    return RandomStringUtils.randomAscii(passLength);
                case "Alphabetic":
                    return RandomStringUtils.randomAlphabetic(passLength);
                case "Numeric":
                    return RandomStringUtils.randomNumeric(passLength);
            }
        }

        return "";
    }

    public static void createPdf(
            String mainTitle,
            String subTitle,
            String url,
            String userName,
            //String scanType,
            String comment,
            //String thisPassCode,
            String passCode,
            String fileDir
    ) throws IOException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A4, 200, 50, 15, 15);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileDir));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String strDate = sdf.format(cal.getTime());
        // CODE 128
        document.add(new Paragraph("件名 : " + mainTitle));
        document.add(new Paragraph("分類 : " + subTitle));
        document.add(new Paragraph("-------------------------------------------------------"));
        document.add(new Paragraph("発行 " + strDate));
        document.add(new Paragraph("-------------------------------------------------------"));
        Barcode128 code128 = new Barcode128();

        BaseFont bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.WINANSI, BaseFont.EMBEDDED);
        Font font = new Font(bf, 12);
        document.add(new Paragraph("指定"));
        document.add(new Paragraph(url));
        code128.setCode(url);
        code128.setFont(bf);
        document.add(code128.createImageWithBarcode(cb, null, null));

        document.add(new Paragraph("USER"));
        document.add(new Paragraph(userName));
        code128.setCode(userName);
        code128.setFont(bf);
        document.add(code128.createImageWithBarcode(cb, null, null));

        document.add(new Paragraph("CODE"));
        document.add(new Paragraph(passCode));
        code128.setCode(passCode);
        code128.setFont(bf);
        document.add(code128.createImageWithBarcode(cb, null, null));

        document.add(new Paragraph("摘要"));
        document.add(new Paragraph(comment));
        // step 5
        document.close();
    }

}
