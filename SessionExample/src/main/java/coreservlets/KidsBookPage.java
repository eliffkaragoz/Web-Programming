package coreservlets;
import javax.servlet.annotation.WebServlet;

@WebServlet("/KidsBookPage")
public class KidsBookPage extends CatologPage{
	 public void init() {
		 String[] ids = { "lewis001", "alexander001", "rowling001" };
		 setItems(ids);
		 setTitle("All-Time Best Children's Fantasy Books");
	 }
}
