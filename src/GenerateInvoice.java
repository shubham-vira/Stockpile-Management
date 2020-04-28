
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public class GenerateInvoice {  
    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;
    private int billId;
    private String chequeNo;
    public GenerateInvoice(int billId,String chequeNo) {
        this.billId = billId;
        this.chequeNo = chequeNo;
    }
 public void createPDF (File path,ResultSet rs,String name,String contact,String gst,String email){

  Document doc = new Document();
  PdfWriter docWriter = null;
  initializeFonts();
  try {
   docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
   doc.addAuthor("betterThanZero");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("MySampleCode.com");
   doc.addTitle("Invoice");
   doc.setPageSize(PageSize.A5);

   doc.open();
   PdfContentByte cb = docWriter.getDirectContent();
   
   boolean beginPage = true;
   int y = 0,y1=615;
   int total = 0;
   double cgst = 0.00;
   double cPercent=0,gPercent=0,iPercent=0;
   double iAmount=0,cAmount=0,gAmount=0;
   for(int i=0; i < 100; i++ ){
    if(beginPage){
     beginPage = false;
     generateLayout(doc, cb); 
     y = 615; 
     y1=430;
    }
    if(!rs.next())
   	break;
   //Need to change the name of the columns according to the table's column names.....
   generateDetail(rs.getString("productname"),rs.getInt("quantity"),rs.getFloat("cost"),rs.getFloat("cgst"),rs.getFloat("sgst"),rs.getFloat("igst"),rs.getFloat("mrp"),rs.getString("mass"),doc, cb, i, y1);
   total += rs.getInt("mrp") * rs.getInt("quantity");
   cgst += ((total*rs.getFloat("cgst"))/100.00);
   cPercent += rs.getFloat("cgst");
   gPercent += rs.getFloat("sgst");
   iPercent += rs.getFloat("igst");
   iAmount += ((rs.getFloat("cost") * rs.getInt("quantity") * rs.getFloat("igst"))/100.00);
   gAmount += ((rs.getFloat("cost") * rs.getInt("quantity") * rs.getFloat("sgst"))/100.00);
   cAmount += ((rs.getFloat("cost") * rs.getInt("quantity") * rs.getFloat("cgst"))/100.00);
   
       System.out.println("iAmount " + iAmount);
    y = y - 15;
    y1 -= 15;
    if(y < 50){
     printPageNumber(cb);
     doc.newPage();
     beginPage = true;
    }
   }
      createContent(cb, 355, 137, total + "", PdfContentByte.ALIGN_RIGHT);
      createContent(cb,50,502,name,PdfContentByte.ALIGN_LEFT);
      createContent(cb,265,502,contact+"",PdfContentByte.ALIGN_LEFT);
      createContent(cb, 50, 482, email, PdfContentByte.ALIGN_LEFT);
      createContent(cb,260,482,gst,PdfContentByte.ALIGN_LEFT);
      
      createContent(cb,190,75,cPercent + "",PdfContentByte.ALIGN_LEFT);
      createContent(cb,190,58,gPercent + "",PdfContentByte.ALIGN_LEFT);
      createContent(cb,190,41,iPercent + "",PdfContentByte.ALIGN_LEFT);
      
      createContent(cb,300,75,cAmount + "",PdfContentByte.ALIGN_LEFT);
      createContent(cb,300,58,gAmount  + "",PdfContentByte.ALIGN_LEFT);
      createContent(cb,300,41, iAmount + "",PdfContentByte.ALIGN_LEFT);
      Connection conn = MySqlConnect.connectDB();
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE bill SET cgst = ?,sgst = ?,igst = ? WHERE billid = ?");
      preparedStatement.setFloat(1,(float)cAmount);
      preparedStatement.setFloat(2,(float)gAmount);
      preparedStatement.setFloat(3,(float)iAmount);
      preparedStatement.setInt(4,this.billId);
      preparedStatement.execute();
   printPageNumber(cb);

  }
  catch (DocumentException dex)
  {
   dex.printStackTrace();
  }
  catch (Exception ex)
  {
   ex.printStackTrace();
  }
  finally
  {
   if (doc != null)
    {
     doc.close();
    }
    if (docWriter != null)
    {
     docWriter.close();
    }
}
 }

 private void generateLayout(Document doc, PdfContentByte cb)  {

  try {

   cb.setLineWidth(1f);



   //GST Description box
   cb.rectangle(20,30,380,90);
   createHeadings(cb,160,110,"***GST DESCRIPTION***");
   createHeadings(cb,45,95,"Tax Desc.");
   createHeadings(cb,190,95,"Tax %.");
   createHeadings(cb,300,95,"Tax Amount (Rs.)");
   createHeadings(cb,45,75,"GST");
   createHeadings(cb,45,58,"SGST");
   createHeadings(cb,45,41,"IGST");

   // Invoice Header box layout
   cb.rectangle(20,475,380,40);
   cb.moveTo(20, 495);
   cb.lineTo(400,495);
   
   cb.moveTo(220, 515);
   cb.lineTo(220,475);

   cb.stroke();

   createHeadings(cb,22,520,"Date :" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
   createHeadings(cb,320,520,"Bill no :" + this.billId);
   // Invoice Header box Text Headings 
   createHeadings(cb,22,502,"Name :");
   createHeadings(cb,222,502,"Contact :");
   createHeadings(cb,22,482,"email :");
   createHeadings(cb,222,482,"GST :");

   // Invoice Detail box layout 
   cb.rectangle(20,130,380,340);
   
   cb.moveTo(20,445);
   cb.lineTo(400,445);
   //sr no
   cb.moveTo(45, 150);
   cb.lineTo(45,470);
   //product description
   cb.moveTo(120,150);
   cb.lineTo(120,470);
   
   //mass
   cb.moveTo(160,150);
   cb.lineTo(160,470);
   //quantity
   cb.moveTo(200,150);
   cb.lineTo(200,470);
   //cost
   cb.moveTo(235,150);
   cb.lineTo(235,470);
   //cgst
   cb.moveTo(270,150);
   cb.lineTo(270,470);
   //sgst
   cb.moveTo(305,150);
   cb.lineTo(305,470);
   //igst
   cb.moveTo(340,150);
   cb.lineTo(340,470);
   //total
   cb.moveTo(20,150);
   cb.lineTo(400,150);
   
   cb.stroke();

   // Invoice Detail box Text Headings 
   createHeadings(cb,22,455,"Sr No.");
   createHeadings(cb,50,455,"Product Desc..");
   createHeadings(cb,125,455,"Mass");
   createHeadings(cb,165,455,"Quantity");
   createHeadings(cb,210,455,"Cost");
   createHeadings(cb,242,455,"CGST");
   createHeadings(cb,276,455,"SGST");
   createHeadings(cb,313,455,"IGST");
   createHeadings(cb,355,455,"Total(Rs.)");
   createHeadings(cb,30,137,"Total Amount(Rs.)");
   createHeadings(cb,160,10,"***Thankyou for shopping***");

   //add the images
   Image companyLogo = Image.getInstance("C:\\Users\\shubham\\Pictures\\Screenshots\\MDS.png");
   companyLogo.setAbsolutePosition(30,525);
   companyLogo.scalePercent(55);
   doc.add(companyLogo);

  }

  catch (DocumentException dex){
   dex.printStackTrace();
  }
  catch (Exception ex){
   ex.printStackTrace();
  }

 }
 
 
 private void generateDetail(String description,
                            int quantity,
                            double cost,
                            double cgst,
                            double sgst,
                            double igst,
                            float total,
                            String mass,
                            Document doc, 
                            PdfContentByte cb, 
                            int index, 
                            int y)  {
  DecimalFormat df = new DecimalFormat("0.00");
  
  try {

   createContent(cb,37,y,String.valueOf(index+1),PdfContentByte.ALIGN_RIGHT);
   createContent(cb,48,y, description,PdfContentByte.ALIGN_LEFT);
   createContent(cb,130,y,mass + "",PdfContentByte.ALIGN_LEFT);
   createContent(cb,175,y,quantity + "",PdfContentByte.ALIGN_LEFT);
   createContent(cb,205,y,quantity*cost + "",PdfContentByte.ALIGN_LEFT);
   createContent(cb,240,y,cgst + "%",PdfContentByte.ALIGN_LEFT);
   createContent(cb,275,y,sgst + "%",PdfContentByte.ALIGN_LEFT);
   createContent(cb,310,y,igst + "%",PdfContentByte.ALIGN_LEFT);
   createContent(cb,345,y,quantity*total + "",PdfContentByte.ALIGN_LEFT);
   
   double price = Double.valueOf(df.format(Math.random() * 10));
   double extPrice = price * (index+1) ;
   createContent(cb,498,y, df.format(price),PdfContentByte.ALIGN_RIGHT);
   createContent(cb,568,y, df.format(extPrice),PdfContentByte.ALIGN_RIGHT);
   
  }

  catch (Exception ex){
   ex.printStackTrace();
  }

 }

 private void createHeadings(PdfContentByte cb, float x, float y, String text){


  cb.beginText();
  cb.setFontAndSize(bfBold, 8);
  cb.setTextMatrix(x,y);
  cb.showText(text.trim());
  cb.endText(); 

 }
 
 private void printPageNumber(PdfContentByte cb){


  cb.beginText();
  cb.setFontAndSize(bfBold, 8);
  cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber+1), 570 , 25, 0);
  cb.endText(); 
  
  pageNumber++;
  
 }
 
 private void createContent(PdfContentByte cb, float x, float y, String text, int align){


  cb.beginText();
  cb.setFontAndSize(bf, 8);
  cb.showTextAligned(align, text.trim(), x , y, 0);
  cb.endText(); 

 }

 private void initializeFonts(){


  try {
   bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

  } catch (DocumentException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }


 }
    
}
