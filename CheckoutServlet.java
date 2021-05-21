package com.example.Project3;

import com.mysql.cj.Session;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    List<String> cart = new ArrayList<String>();
    int counter = 0;
    Double totalPrice = 0.0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(true);
        String item = request.getParameter("button");
        session.setAttribute("cart", cart);

        if (item.equals("Add Black Milk Tea to Cart")) {
            //counter++;
            cart.add("Black Milk");
            totalPrice += 4.75;
        }
        else if(item.equals("Add Coffee Milk Tea to Cart")){
            // counter++;
            cart.add("Coffee Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Earl Grey Milk Tea to Cart")){
            // counter++;
            cart.add("Earl Grey Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Jasmine Milk Tea to Cart")){
            // counter++;
            cart.add("Jasmine Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Mango Lychee Tea to Cart")){
            // counter++;
            cart.add("Mango Lychee");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Oolong Milk Tea to Cart")){
            //counter++;
            cart.add("Oolong Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Panda Milk Tea to Cart")){
            // counter++;
            cart.add("Panda Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Peach Green Tea to Cart")){
            //counter++;
            cart.add("Peach Green");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Taro Milk Tea to Cart")){
            //counter++;
            cart.add("Taro Milk");
            totalPrice += 5.75;
        }
        else if(item.equals("Add Thai Iced Tea to Cart")){
            //counter++;
            cart.add("Thai Iced");
            totalPrice += 5.75;
        }
        ArrayList<String> attr = (ArrayList<String>)session.getAttribute("cart");

        writer.println("<html lang = \"en\"> <head>");
        writer.println("<meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <script type = \"text/JavaScript\" src = \"cityState.js\">" +
                "    <link rel=\"shortcut icon\" type=\"image/png\" href=\"favicon.jpeg\">" +
                "    <title>Checkout Page</title>");

        writer.println("<script language=\"JavaScript\">");


        RequestDispatcher rd = request.getRequestDispatcher("form_validation.js");
        rd.include(request, response);

        writer.println("</script>");
        writer.println("</head>");
        writer.println("<header>\n" +
                "    <h1 class=\"boba-header\">Unoriginal Boba Store</h1>\n" +
                "\n" +
                "    <div class=\"navbar-container\">\n" +
                "\n" +
                "        <a class=\"navbar\" href=\"about.html\">About Us</a>\n" +
                "        <a class=\"navbar\" href=\"team.html\">The Team</a>\n" +
                "        <a class=\"navbar\" href=\"index.jsp\">Menu</a>\n" +
                "\n" +
                "    </div>\n" +
                "</header>");
        writer.println("<body>");
        writer.println("<h3>Current items in your cart: </h3>");

        for (int i = 0; i < attr.size(); i++) {

            if(i == attr.size()-1){
                writer.println(attr.get(i));
            }
            else{
                writer.println(attr.get(i) + ", ");
            }
        }

        String no = String.format("%.2f", totalPrice);

        writer.println("<h3> Total Before Tax: $" + no + "</h3><br>");
        writer.println("<label for=\"total_price\">Total After Tax: $</label>" +
                "<input type=\"text\" id=\"total_price\" value =" + no + ">");

        writer.println("<form name=\"PurchaseOrderForm\"\n" +
                "      onsubmit=\"return validateForm()\"\n" +
                "      action=\"OrderDetails.jsp\"\n" +
                "      method=\"POST\"\n" +
                "\n" +
                "    <fieldset>\n" +
                "        <legend>Purchase Order Form</legend>\n" +
                "        <br>\n" +
                "        <div class=\"form-container\">\n" +
                "            <div class=\"form-item\">\n" +
                "\n" +
                "                <label for=\"fname\">First Name:</label><br>\n" +
                "                <input type=\"text\" id=\"fname\" maxlength=\"32\" name=\"First Name\" pattern=\"[A-Za-z]{1,32}\" required><br>\n" +
                "\n" +
                "                <br>\n" +
                "\n" +
                "                <label for=\"lname\">Last Name:</label><br>\n" +
                "                <input type=\"text\" id=\"lname\" maxlength=\"32\" name=\"Last Name\" pattern=\"[A-Za-z]{1,32}\" required><br>\n" +
                "\n" +
                "                <br>\n" +
                "\n" +
                "                <label for=\"phone\">Phone Number:</label><br>\n" +
                "                <input type=\"tel\" id=\"phone\" name=\"Phone Number\" placeholder=\"i.e. 123-456-7891\" pattern=\"[0-9]{3}-[0-9]{3}-[0-9]{4}\" required><br>\n" +
                "\n" +
                "                <br>\n" +
                "                <label for=\"ship_addr\"><u>Shipping Address Information</u></label><br>\n" +
                "                <label for=\"addr\">Street:</label><br>\n" +
                "                <input type=\"text\" id=\"addr\" name=\"Address Line 1\" placeholder=\"i.e. 1234 W Irvine Drive\" required><br><br>\n" +
                "                <label for=\"addr\">Apt/Suite/Bldg:</label><br>\n" +
                "                <input type=\"text\" id=\"addr2\" name=\"Address Line 2\" placeholder=\"i.e. Apt 4\"><br><br>\n" +
                "\n" +
                "\n" +
                "\n" +
                "            </div><!-- class form item -->\n" +
                "            <div class=\"form-item\">\n" +
                "<label for=\"zip_code\">Zip Code:</label><br>\n" +
                "                <input type=\"text\" id=\"zip_code\" name=\"Zip Code\" pattern=\"[0-9]{5,5}\" onblur=\"getPlace(this.value)\" title=\"Zip code should be exactly 5 digits. e.g. 92801\" required>\n" +
                "                <br><label for=\"city\">City:</label><br>\n" +
                "                <input type=\"text\" id=\"city\" name=\"City\" required><br><br>\n" +
                "\n" +
                "                <label for=\"state\">State:</label><br>\n" +
                "                <input type=\"text\" id=\"state\" name=\"State\" size=\"5\" pattern=\"[A-Z]{2,2}\" placeholder=\"i.e. CA\" required><br><br>\n" +
                "\n" +
                "\n" +
                "                <br>\n" +
                "                <br>\n" +
                "\n" +
                "                <label for=\"ship_method\">Shipping Method:</label><br>\n" +
                "                <input type=\"radio\" id=\"overnight\" name=\"Shipping Method\" value=\"Overnight\" required>\n" +
                "                <label for=\"overnight\">Overnight</label><br>\n" +
                "\n" +
                "                <input type=\"radio\" id=\"2day\" name=\"Shipping Method\" value=\"2day\" required>\n" +
                "                <label for=\"2day\">2-day expedited</label><br>\n" +
                "\n" +
                "                <input type=\"radio\" id=\"6day\" name=\"Shipping Method\" value=\"6day\" required>\n" +
                "                <label for=\"6day\">6-days ground</label><br>\n" +
                "\n" +
                "                <br>\n" +
                "\n" +
                "                <label for=\"credit_card\"><u>Credit Card Information</u></label><br>\n" +
                "                <label for=\"card_num\">Card Number:</label><br>\n" +
                "                <input type=\"text\" id=\"card_num\" name=\"Card Number\" pattern=\"[0-9]{13,16}\" title=\"Credit card number should be between 13 and 16 digits.\" required><br><br>\n" +
                "\n" +
                "                <label for=\"expiry1\">Expiry Date:</label><br>\n" +
                "                <select id=\"expiry1\" name=\"Expiration Month\">\n" +
                "                    <option value=\"January\">01</option>\n" +
                "                    <option value=\"February\">02</option>\n" +
                "                    <option value=\"March\">03</option>\n" +
                "                    <option value=\"April\">04</option>\n" +
                "                    <option value=\"May\">05</option>\n" +
                "                    <option value=\"June\">06</option>\n" +
                "                    <option value=\"July\">07</option>\n" +
                "                    <option value=\"August\">08</option>\n" +
                "                    <option value=\"September\">09</option>\n" +
                "                    <option value=\"October\">10</option>\n" +
                "                    <option value=\"November\">11</option>\n" +
                "                    <option value=\"December\">12</option>\n" +
                "                </select>\n" +
                "\n" +
                "                <select id=\"expiry2\" name=\"Expiration Year\">\n" +
                "                    <option value=\"2021\">21</option>\n" +
                "                    <option value=\"2022\">22</option>\n" +
                "                    <option value=\"2023\">23</option>\n" +
                "                    <option value=\"2024\">24</option>\n" +
                "                    <option value=\"2025\">25</option>\n" +
                "                    <option value=\"2026\">26</option>\n" +
                "                    <option value=\"2027\">27</option>\n" +
                "                    <option value=\"2028\">28</option>\n" +
                "                    <option value=\"2029\">29</option>\n" +
                "                    <option value=\"2030\">30</option>\n" +
                "                </select>\n" +
                "\n" +
                "                <br>\n" +
                "                <br>\n" +
                "\n" +
                "                <label for=\"sCode\">Security Code:</label><br>\n" +
                "                <input type=\"text\" id=\"sCode\" name=\"Security Code\" size=\"4\" pattern=\"[0-9]{3,4}\" required><br><br>\n" +
                "\n" +


                "                <br>\n" +
                "\n" +
                "                <input type=\"submit\" value=\"Submit\">\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "    </fieldset>\n" +
                "</form>");


        writer.println("</body><footer>");
        writer.println("<br>");
        writer.println("<p> 123 Sesame Street, Imagination Lan 123456</p>");
        writer.println("<p>HOURS: 9AM-9PM DAILY</p>");
        writer.println("<p >© 2021 POWERED BY THE UNORIGINAL BOBA STORE</p>");
        writer.println("</footer></html>");
    }
}
