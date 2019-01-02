package fr.adaming.model;


import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;







public class PdfFactureVoyage {


public static final String DEST= "C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1";
	
	

	public void generarPdf(String dest) throws IOException{
PdfWriter writer= new PdfWriter(dest);
		PdfDocument pdf= new PdfDocument(writer);
	Document document= new Document(pdf);
	document.add(new Paragraph("Récapitulatif de votre voyage"));
	
	
	
	document.close();
	
	}
}
