package coreservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class CatologPage
 */
@WebServlet("/CatologPage")
public class CatologPage extends HttpServlet {
	 private static final long serialVersionUID = 1L;
       
	 private CatalogItem[] items;
	 private String[] itemIDs;
	 private String title;
    
	 
	 protected void setItems(String[] itemIDs) { //KidsBookPage ve TechBooksPage'den gelen ürün'ler dizisini items dizisinde tutuyor.
		 //items CatologItem class tüpünde bir dizi.
		 this.itemIDs = itemIDs;
		 items = new CatalogItem[itemIDs.length];
		 
		 for(int i=0; i<items.length; i++) {
			 items[i] = Catalog.getItem(itemIDs[i]);
		 }
	 }
	 
	 protected void setTitle(String title) {
		 this.title = title;
     }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if (items == null) {
				 response.sendError(response.SC_NOT_FOUND,"Missing Items.");
				 return;
			}
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 
			 String docType =
			 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			 "Transitional//EN\">\n";
			 
			 out.println(docType +
				 "<HTML>\n" +
				 "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
				 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
				 "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
			 
			 CatalogItem item;
			 for(int i=0; i<items.length; i++) {
				 out.println("<HR>");
				 item = items[i];
				 // Show error message if subclass lists item ID
				 // that's not in the catalog.
				 if (item == null) {
					 out.println("<FONT COLOR=\"RED\">" +
					 "Unknown item ID " + itemIDs[i] +
					 "</FONT>");
				 } else {
					 out.println();
					 String formURL = "/SessionExample/servlet/coreservlets.OrderPage";
					 
					 //item 'deki verileri aldýysan butona basýldýgýnda orderPage'ye git...
					 //Her item için bunu tekrarla
					 
					 // Pass URLs that reference own site through encodeURL.
					 formURL = response.encodeURL(formURL);
					 out.println
						 ("<FORM ACTION=\"" + formURL + "\">\n" +
						 "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
						 " VALUE=\"" + item.getItemID() + "\">\n" +
						 "<H2>" + item.getShortDescription() +
						 " ($" + item.getCost() + ")</H2>\n" +
						 item.getLongDescription() + "\n" +
						 "<P>\n<CENTER>\n" +
						 "<INPUT TYPE=\"SUBMIT\" " +
						 "VALUE=\"Add to Shopping Cart\">\n" +
						 "</CENTER>\n<P>\n</FORM>");
				 }
			 }
			 out.println("<HR>\n</BODY></HTML>");
			 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
