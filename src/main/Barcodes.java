package main;

/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.RandomStringUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Barcodes {

    /** The resulting PDF. */
    private static final String RESULT = "barcodes.pdf";

    /**
     * Generates a PDF file with different types of barcodes.
     *
     * @param args
     *            no arguments needed here
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException,
            DocumentException {
        new Barcodes().createPdf(RESULT);
    }

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(String filename) throws IOException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A4,200,50,15,15);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String strDate = sdf.format(cal.getTime());
        // CODE 128
        document.add(new Paragraph("Title : "));
        document.add(new Paragraph("-------------------------------------------------------"));
        document.add(new Paragraph("Issue "+strDate));
        document.add(new Paragraph("-------------------------------------------------------"));
        Barcode128 code128 = new Barcode128();

        BaseFont bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.WINANSI,BaseFont.EMBEDDED);
        Font font = new Font(bf, 12);

        for(int i = 0;i<10;i++){
        	System.out.println(i);
        code128.setCode(RandomStringUtils.randomAlphanumeric(8));
        /*
        MUFG専用記号あり
        code128.setCode(RandomStringUtils.random(8, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$+-./:=?@[]^_`|"));
        SMBC専用文字種限定
        code128.setCode(RandomStringUtils.random(8, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        String random3 = RandomStringUtils.random(10, "ABC123!%&'");
        */
        code128.setFont(bf);
        document.add(new Paragraph(Integer.toString(i)));
        document.add(code128.createImageWithBarcode(cb, null, null));
        }
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("0123456789",font));
        document.add(new Paragraph("ABCDEFGHIJKLMNOPQRSTUVWXYZ",font));
        document.add(new Paragraph("abcdefghijklmnopqrstuvwxyz",font));

        // step 5
        document.close();
    }

    public void createPdf(String filename,
    						String title,
    						int length,
    						String classify,
    						String letters,
    						String comment) throws IOException, DocumentException {

    	BaseFont bfJ = BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.EMBEDDED);
        Font fontJ = new Font(bfJ,12);

        // step 1
        Document document = new Document(PageSize.A4,200,50,15,15);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String strDate = sdf.format(cal.getTime());
        // CODE 128
        document.add(new Paragraph("種別 : "+title,fontJ));
        document.add(new Paragraph("-------------------------------------------------------"));
        document.add(new Paragraph("発行 : "+strDate,fontJ));
        document.add(new Paragraph("-------------------------------------------------------"));
        Barcode128 code128 = new Barcode128();

        /*
        BaseFont bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.WINANSI,BaseFont.EMBEDDED);
        Font font = new Font(bf, 12);
        */

        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.WINANSI,BaseFont.EMBEDDED);
        Font font = new Font(bf, 12);
        

        for(int i = 0;i<10;i++){
        	if (classify.equals("Letters")){
        		code128.setCode(RandomStringUtils.random(length,letters));
        	}else if (classify.equals("Alphanumeric")){
        		code128.setCode(RandomStringUtils.randomAlphanumeric(length));
        	}else if (classify.equals("Ascii")){
        		code128.setCode(RandomStringUtils.randomAscii(length));
        	}else if (classify.equals("Alphabetic")){
        		code128.setCode(RandomStringUtils.randomAlphabetic(length));
        	}else if (classify.equals("Numeric")){
        		code128.setCode(RandomStringUtils.randomNumeric(length));
        	}

        /*
        MUFG専用記号あり
        code128.setCode(RandomStringUtils.random(8, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$+-./:=?@[]^_`|"));
        SMBC専用文字種限定
        code128.setCode(RandomStringUtils.random(8, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        String random3 = RandomStringUtils.random(10, "ABC123!%&'");
        */
        code128.setFont(bf);
        document.add(new Paragraph(Integer.toString(i)));
        document.add(code128.createImageWithBarcode(cb, null, null));
        }
        document.add(new Paragraph(" "));
        //document.add(new Paragraph("-------------------------------------------------------"));
        document.add(new Paragraph("摘要 : "+comment,fontJ));
        document.add(new Paragraph("-------------------------------------------------------"));
        code128.setFont(bf);
        document.add(new Paragraph("0123456789",font));
        document.add(new Paragraph("ABCDEFGHIJKLMNOPQRSTUVWXYZ",font));
        document.add(new Paragraph("abcdefghijklmnopqrstuvwxyz",font));

        // step 5
        document.close();
    }
}