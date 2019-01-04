package fr.adaming.model;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFactureVoyage {

	public static final String dest = "C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1";
	public static final String FONT = "C:\\Users\\INTI0485\\Desktop\\FormationNantesOctobre\\FreeSans.ttf";

	public void generarPdf(String dest) throws IOException {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(dest));
			document.open();
			PdfPTable table = new PdfPTable(2);
			table.addCell("Winansi");

			table.addCell(getNormalCell("Test", null, 12));

			table.addCell("Winansi");
			table.addCell(getNormalCell("Test", null, -12));
			table.addCell("Greek");
			table.addCell(getNormalCell("\u039d\u03cd\u03c6\u03b5\u03c2", "greek", 12));
			table.addCell("Czech");
			table.addCell(getNormalCell("\u010c,\u0106,\u0160,\u017d,\u0110", "czech", 12));
			table.addCell("Test");
			table.addCell(getNormalCell(" ", null, 12));
			table.addCell("Test");
			table.addCell(getNormalCell(" ", "greek", 12));
			table.addCell("Test");
			table.addCell(getNormalCell(" ", "czech", 12));
			document.add(table);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static PdfPCell getNormalCell(String string, String language, float size)
			throws DocumentException, IOException {
		if (string != null && "".equals(string)) {
			return new PdfPCell();
		}
		Font f = getFontForThisLanguage(language);
		if (size < 0) {
			f.setColor(BaseColor.RED);
			size = -size;
		}
		f.setSize(size);
		PdfPCell cell = new PdfPCell(new Phrase(string, f));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return cell;
	}

	public static Font getFontForThisLanguage(String language) {
		if ("czech".equals(language)) {
			return FontFactory.getFont(FONT, "Cp1250", true);
		}
		if ("greek".equals(language)) {
			return FontFactory.getFont(FONT, "Cp1253", true);
		}
		return FontFactory.getFont(FONT, null, true);
	}

}
