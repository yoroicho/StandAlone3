/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



http://boubiroku28.blog.fc2.com/blog-entry-4.html

【Webアプリ】　iTextによるPDF出力

一部省略部あり、サイトを参照のこと。


 */
package pdfMaker;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author 00499
 */
public class doPost {
    /**
}
    protected void doIngPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ByteArrayOutputStream bout = null;
	PdfWriter writer = null;
	Document doc = null;
	BookDAO dao = null;
	int lineCursor = 1;
	int shoukei = 0;
	int soukei = 0;

        dao = new BookDAO();
        ArrayList list = dao.getBookListForPDF();
        bout = new ByteArrayOutputStream();
        doc = new Document(PageSize.A4, 50, 50, 50, 50);
        writer = PdfWriter.getInstance(doc, bout);
        Rectangle pageSize = doc.getPageSize();
        writer.setBoxSize("art",
                new Rectangle(36,50,
                        pageSize.getWidth() - 50,
                        pageSize.getHeight() - 36)
        );
        writer.setPageEvent(new PdfPageEventHelper() {
            //ヘッダーのフォント
            Font font_header = new Font(BaseFont.createFont(
                    "HeiseiKakuGo-W5", "UniJIS-UCS2-H",
                    BaseFont.NOT_EMBEDDED), 10, Font.ITALIC);
            
            //フッターのフォント
            Font font_page = new Font(BaseFont.createFont(
                    "HeiseiKakuGo-W5", "UniJIS-UCS2-H",
                    BaseFont.NOT_EMBEDDED), 9, Font.NORMAL);
            
            @Override
            public void onEndPage(PdfWriter writer, Document document) {
                Rectangle rect = writer.getBoxSize("art");
                
                //ヘッダー表示
                Phrase header = new Phrase("書籍マスター一覧", font_header);
                
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_LEFT, header, rect.getLeft(),
                        rect.getTop(), 0);
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
                Phrase headerDate = new Phrase(sdf1.format(new Date()), font_header);
                
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, headerDate, rect.getRight(),
                        rect.getTop(), 0);
                
                //フッター（ページ）表示
                Phrase page = new Phrase(String.format("- %d -",
                        writer.getPageNumber()), font_page);
                
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_CENTER, page,
                        (rect.getLeft() + rect.getRight()) / 2,
                        rect.getBottom(), 0);
                
            }
            
        });
        doc.open();
        BaseFont bf;
        Font font;
        bf = BaseFont.createFont("KozMinPro-Regular","UniJIS-UCS2-H",BaseFont.EMBEDDED);
        font = new Font(bf, 10);
        doc.addAuthor("ウニバーサルコンピュータ");
        doc.addSubject("書籍マスタ一覧");
        PdfPTable table = new PdfPTable(3);
        float[] columnWidths = {3, 14, 4};
        table.setWidths(columnWidths);
        for( Object BookBean : list ) {
            
            //以下、すべてのif文を通すこと。else if でくくってはいけない
            if(lineCursor % 52 == 1) {
                // ヘッダ
                PdfPCell hcell1 = new PdfPCell(new Paragraph("書籍番号", font));
                PdfPCell hcell2 = new PdfPCell(new Paragraph("書籍名", font));
                PdfPCell hcell3 = new PdfPCell(new Paragraph("金額", font));
                hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell1);
                table.addCell(hcell2);
                table.addCell(hcell3);
                lineCursor++;
            }
            if(lineCursor % 52 != 0 && lineCursor % 52 != 1) {
                //通常の行
                PdfPCell cell1 = new PdfPCell(new Paragraph(item.getBookid(), font));
                PdfPCell cell2 = new PdfPCell(new Paragraph(item.getBooknm(), font));
                int tmpvalue = Integer.parseInt(item.getBookprice());
                PdfPCell cell3 = new PdfPCell(new Paragraph(
                        String.format("%1$,3d", tmpvalue), font)
                );
                cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                lineCursor++;
                shoukei += Integer.parseInt(item.getBookprice());
                soukei += Integer.parseInt(item.getBookprice());
            }
            if(lineCursor % 52 == 0) {
                // 小計フッタ
                Paragraph s_footer1 = new Paragraph("小計", font);
                s_footer1.setAlignment(Element.ALIGN_CENTER);
	PdfPCell fscell1 = new PdfPCell(s_footer1);
	PdfPCell fscell2 = new PdfPCell(new Paragraph(String.format("%1$,3d", shoukei), font));
	fscell1.setColspan(2);
	fscell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	table.addCell(fscell1);
	table.addCell(fscell2);
	shoukei = 0;
	lineCursor++;
	}
	}
        Paragraph s_footer1 = new Paragraph("小計", font);
        s_footer1.setAlignment(Element.ALIGN_CENTER);
        PdfPCell fscell1 = new PdfPCell(s_footer1);
        PdfPCell fscell2 = new PdfPCell(new Paragraph(String.format("%1$,3d", shoukei), font));
        fscell1.setColspan(2);
        fscell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(fscell1);
        table.addCell(fscell2);
        Paragraph footer1 = new Paragraph("総計", font);
        footer1.setAlignment(Element.ALIGN_CENTER);
        PdfPCell fcell1 = new PdfPCell(footer1);
        PdfPCell fcell2 = new PdfPCell(new Paragraph(String.format("%1$,3d", soukei), font));
        fcell1.setColspan(2);
        fcell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(fcell1);
        table.addCell(fcell2);
        Paragraph para1 = new Paragraph();
        para1.add(table);
        doc.add(para1);

	response.setContentType("application/pdf");
	response.setContentLength(bout.size());
	OutputStream out = response.getOutputStream();
	out.write(bout.toByteArray());
	out.close();
}

    private static class BookDAO {

        public BookDAO() {
        }
**/
    }
