package fr.adaming.model;


import java.io.IOException;


import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;


public class PdfFactureVoyage {

public static final String LOGO="C:\\Users\\inti0490\\Desktop\\Cosas para proyectos\\logoBoVoyage.png";
public static final String dest= "C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1";
	
	

	public void generarPdf(String dest) throws IOException{
PdfWriter writer= new PdfWriter(dest);
		PdfDocument pdf= new PdfDocument(writer);
	Document document= new Document(pdf);
	
	Image logo= new Image(ImageDataFactory.create(LOGO));
	
	
	
	document.add(new Paragraph("Récapitulatif de votre voyage"));
	List list= new List().setSymbolIndent(12).setListSymbol("\u2002");
	list.add(new ListItem("Voyage basic aller et retour à")).add(new ListItem("L'hôtel que vous avez pris est le "));
	document.add(list);
	
	document.close();
	
	}
}
