package com.pdfread;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBoxReadFromFile {

	public static void main(String[] args) {
		
		//READ TEXT FROM PDF        CODE---1
		
//		 PDFManager pdfManager = new PDFManager();
//	        pdfManager.setFilePath("F:/MY_CODE/Bhupendra-resume.pdf");
//	        try {
//	            String text = pdfManager.toText();
//	            System.out.println(text);
//	        } catch (IOException ex) {
//	            ex.printStackTrace();
//	        }
		
		
		//READ TEXT FROM PDF        CODE---2
		String text=null;
		PDDocument pd;
		File file = new File("F:/MY_CODE/abc.pdf");
		try {
//			PDDocument pd = PDDocument.load(file);
			pd = PDDocument.load(file);
			PDFTextStripper pts = new PDFTextStripper();
//			String text = pts.getText(pd);
			text = pts.getText(pd);
//			System.out.println(text);
			
			pd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(text);
		
		//CREATE PDF        CODE---1
		
		File file1 = new File("F:/MY_CODE/blank.pdf");
		PDDocument pd1  = new PDDocument();
		try {
//			pd.save("F:/MY_CODE/blank1.pdf");
			pd1.save(file1);
			PDPage blpg = new PDPage();
			pd1.addPage(blpg);
			pd1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		System.out.println("created");

		
		//WRITE TEXT TO PDF        CODE---1
		
//		File file1 = new File("F:/MY_CODE/blank.pdf");
		try {
			PDDocument pdd = PDDocument.load(file1);

//		    for (int i=0; i<2; i++) {  
		    	PDPage blankPage = new PDPage();  
		  
		    	pdd.addPage( blankPage );  
//		    }
			
			PDPage page = pdd.getPage(0);
			PDPageContentStream cntstrm = new PDPageContentStream(pdd,page);
			cntstrm.beginText();
			cntstrm.setFont( PDType1Font.TIMES_BOLD_ITALIC, 14);
			text = text.replace("\n", "").replace("\r", "");

			cntstrm.newLineAtOffset(20, 450);
//			cntstrm.showText("I CREATED NEW BLANK PDF FILE!!!!!!");
		
			cntstrm.showText(text);
			cntstrm.endText();
			
			cntstrm.close();
			
			pdd.save(file1);
			
			pdd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
