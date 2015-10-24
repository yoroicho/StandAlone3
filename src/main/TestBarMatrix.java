package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestBarMatrix {

	public static void main(String[] args) {
		TestBarMatrix tbm = new TestBarMatrix();
		try {
			tbm.createTablePdf("test2.pdf",44);
		} catch (IOException | DocumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public void createTablePdf(String filename, int num ) throws IOException, DocumentException, FileNotFoundException
	{
	   // Document settings
	   Document document = new Document(PageSize.A4, 25,25,25,25);
	   PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));

	   document.open();
	   PdfContentByte cb = writer.getDirectContent();

	   // Prepare table
	   float[] columnDefinitionSize = { 25.0f,25,0f,25.0f,25.0f };
	   PdfPTable table = new PdfPTable(columnDefinitionSize);

	   for ( int i=0; i < num; i++ )
	   {
	      Barcode128 code128 = new Barcode128();
	      code128.setCode("ABC");
	      //code128.setCode(UUID.randomUUID().toString());
	      Image barcode = code128.createImageWithBarcode(cb, null, null);
	      Chunk chunk = new Chunk(barcode,0,0);
	      Chunk chunki = new Chunk(Integer.toString(i));
	      PdfPCell cell = new PdfPCell();

	      cell.setFixedHeight(99.0f);

	      cell.addElement(new Phrase("cell"));
	      //cell.setPhrase(new Phrase("1"));
	      cell.addElement(chunk);
	      cell.setBorder(Rectangle.NO_BORDER);
	      table.addCell(cell);
	   }

	   document.add(table);
	   document.close();
	}
}
