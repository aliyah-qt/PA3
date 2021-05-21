# inf124-web-dev

Programming assignment group 7:
Aliyah F. Clayton,
Santiago Jr. Morales,
Samhitha Tarra


--GENERAL LAYOUT/DESIGN:

CheckoutServlet.java:
     The CheckoutServlet displays all items currently in the cart, the total price, and a purchase order form for the user to fill out. Upon the user clicking the "Submit" button, it will call the validateForm() method in the form_validation.js file to ensure that the user inputted completely valid data. If the function returns true, the servlet then redirects to the OrderDetailsServlet via the form action attribute.
	 
     
DatabaseHelper.java:
	 This is a file that establishes a database connection that helps get individual boba tea information from the database.
	 
     
getCityStateServlet.java:
	 Reads zip codes and tax rates from the csv files and enters them into hashmaps, which are used to check against user input. If both are valid then the information is sent to cityState.js in order to display them.
	
    
OrderHistoryServlet.java:
     The OrderHistoryServlet displays the last 5 items in the user's cart.
	 
     
About.html:
     Includes information about our store and a brief description on the origins of boba.
	 
     
cityState.js:
	 The cityState.js file has a single fucntion, getPlace(), which takes in a single parameter, zip code. It automatically populates the city and state text fields in the purchase order information form as soon as the user clicks out of the zip code text field in the purchase order information form.
	 
     
form_validation.js:
     The form_validation.js file contains a single function called validateForm() that takes in 3 parameters: street, apt, city. This function is used to validate (via javascript regular expressions) that the inputted user data for these 3 specific fields. All other form fields are validated via html attributes. This function returns a boolean value.
	
    
Index.jsp:
     Our website lands on index.jsp which displays our menu of boba tea products and a drop down menu allowing the customer to choose an individula boba tea page to explore. If the user successfully ordered a product on our website, this index.jsp will also display the last 5 products the user recently ordered.
	 
	 
OrderDetails.jsp:
	 This jsp file retrieves the user data from the purchase order information form and sends it to the database. The file then proceeds to display an order successful message to the user along with displaying some of the user's submitted information.
     
ProductDetails.jsp:
	 This jsp file used to be handled by a servlet but by converting it into a jsp file we keep the majority of it as html code and then use a little bit of java logic to dynamically display the appropriate information from the database. It will dynamically display the boba selected's name, description, price, images, and an "Add to Cart" button which redirects to the CheckoutServlet.


styles.css:
	 We use this file in order to style our html code so it looks more appealing to the user's eye.
	 
     
tax_rate.csv:
	 This file has all the zip codes and according tax rates which is used for the autofill feature in Requirement 2. This file is read and indexed in the getCityStateServlet and used to calculate the updated total price of the user's shopping cart.
	 
     
team.html:
	 This page just displays information about the team behind the project!
	 
     
zip_codes.csv:
	 This file has all the zip codes and according city/states which is used for the autofill feature in Requirement 2. This file is read and indexed in the getCityStateServlet and used to automatically fill in the user's city and state fields when ordering a product after they enter their zipcode.
     
PurchaseOrderFormInfo.java:
        Includes setters and getters for each input field on the purchase order information form.
     
Api.java
        Includes 3 REST API calls using GET and DELETE methods.
        





-REQUIREMENTS TO BE SATISFIED: 

1. This requirement is satisfied as we changed our index.html to index.jsp which contains all our boba tea menu products. We then changed our ProductDetailsServlet.java to a ProductDetails.jsp file which now is mostly html code with some java logic to simply replace certain values with information from the database. We do the same thing with the OrderHistoryServlet.java which is now OrderDetails.jsp where we create a confirmation page displaying order data getting values using minimal java logic from the database. 

2. We have two features that use Ajax: autofilling the user's city and state once they enter the zipcode, and displaying the total order price calculated by including the tax rate of their city. We use zip_codes.csv and tax_rates2.csv to provide the data which indexes the getCityStateServlet.java file. Then we use Ajax in cityState.js file to display the information on the webpage.
        
        
        
        
        
        
    -EXTRA CREDIT:

        1. GET method that retrieves the last row of data in the table (aka most recent customer in table)
        
        1a. Request URL: http://localhost:8080/Project3_war_exploded/api/order/0
        
        1b. Sample response:
        
        {
            "id": 30,
            "firstName": "Daffy",
            "lastName": "Duck",
            "phoneNumber": "444-444-6655",
            "addressLine1": "456 Texas Way",
            "addressLine2": "Bldg 5",
            "city": "New York",
            "state": "NY",
            "zipCode": "10012",
            "shipping": "Overnight",
            "creditCard": "88888888888888",
            "expiry": "January2021",
            "security": "325"
        }
        
        
        
        
        2. GET method that retrieves all the data in the table
        
        2a.Request URL: http://localhost:8080/Project3_war_exploded/api/order
        
        2b. Sample response:
        
        [
            {
                "id": 32,
                "firstName": "Aliyah",
                "lastName": "Clayton",
                "phoneNumber": "123-456-7891",
                "addressLine1": "1234 Irvine Way",
                "addressLine2": "Apt 32",
                "city": "New York",
                "state": "NY",
                "zipCode": "10012",
                "shipping": "6day",
                "creditCard": "7777777777777",
                "expiry": "January2021",
                "security": "001"
            },
            {
                "id": 33,
                "firstName": "Stacy",
                "lastName": "Q",
                "phoneNumber": "562-293-4056",
                "addressLine1": "456 Disneyland Dr",
                "addressLine2": "",
                "city": "New York",
                "state": "NY",
                "zipCode": "10012",
                "shipping": "Overnight",
                "creditCard": "8888888888888",
                "expiry": "January2021",
                "security": "002"
            },
            {
                "id": 34,
                "firstName": "Sam",
                "lastName": "Cam",
                "phoneNumber": "394-593-5943",
                "addressLine1": "789 Anteater Parkway",
                "addressLine2": "Bldg 4",
                "city": "New York",
                "state": "NY",
                "zipCode": "10012",
                "shipping": "2day",
                "creditCard": "99999999999999",
                "expiry": "March2025",
                "security": "003"
            }
        ]
        
        
        

        3.  DELETE method that deletes the last row of data in the table (aka most recent customer in table)

        3a.     Request URL: http://localhost:8080/Project3_war_exploded/api/order/26
        
        3b. Sample response:
                Order Deleted Successfully
