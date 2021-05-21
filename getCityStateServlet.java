package com.example.Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;



@WebServlet(name = "getCityStateServlet", value = "/getCityStateServlet")
public class getCityStateServlet extends HttpServlet {

    HashMap<String, String> zip_map = new HashMap<String, String>();
    HashMap<String, String> tax_map = new HashMap<String, String>();
    HashMap<String, String> map = new HashMap<String, String>();

    public void init (ServletConfig config)
    {
        String line = "";
        String line2 = "";
        String splitBy = ",";

        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("/Users/aliyahfaith/IdeaProjects/Project3/src/main/webapp/zip_codes.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                zip_map.put(line.split(splitBy)[0].substring(1, line.split(splitBy)[0].length()-1), line.split(splitBy)[2].substring(1, line.split(splitBy)[2].length()-1) + ", "+ line.split(splitBy)[1].substring(1, line.split(splitBy)[1].length()-1));
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.print("IM DONE ZIP");
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br2 = new BufferedReader(new FileReader("/Users/aliyahfaith/IdeaProjects/Project3/src/main/webapp/tax_rates2.csv"));
            while ((line2 = br2.readLine()) != null)   //returns a Boolean value
            {

                tax_map.put(line2.split(splitBy)[1], line2.split(splitBy)[3]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("i did not read tax rates 2 file.");
        }
//        System.out.print("IM DONE TAX");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String zip = request.getParameter("Zip Code");  // by name, not id
//        System.out.println("this is our second print statement in getCityStateServlet" + zip);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
  //          System.out.println("before getting into first if condition");
            if (zip_map.containsKey(zip)) {
  //              System.out.println("ENTERS HERE ZIP IS IN ZIP MAP ");
                if (tax_map.containsKey(zip)) {
 //                   System.out.println("ENTERS HERE ZIP IS IN TAX MAP ");
  //                  System.out.println(zip_map.get(zip) + ", " + tax_map.get(zip));
                    out.write(zip_map.get(zip) + ", " + tax_map.get(zip));
                }
//                out.write(map.get(zip));
            }
            else
                out.write(" , ");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
