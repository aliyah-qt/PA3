<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.jpeg">
    <title>Homepage</title>
</head>

<body>
<header>
    <h1 class="boba-header">Unoriginal Boba Store</h1>

    <div class="navbar-container">

        <a class="navbar" href="about.html">About Us</a>
        <a class="navbar" href="team.html">The Team</a>
        <a class="navbar" href="index.jsp">Menu</a>
    </div>
</header>

<%--<h1><%= "Hello World!" %></h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<section id="menu">
    <h3>Menu</h3>

    <%
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/OrderHistoryServlet");
        requestDispatcher.include(request, response);
    %>

    <form action="ProductDetails.jsp" method="get">
    <select name="pid" id="pid" required>\n
                <option value="Select">Select</option>\n" +
                <option value="Black Milk Tea">Black Milk Tea</option>
                <option value="Coffee Milk Tea">Coffee Milk Tea</option>
                <option value="Earl Grey Milk Tea">Earl Grey Milk Tea</option>
                <option value="Jasmine Milk Tea">Jasmine Milk Tea</option>
                <option value="Mango Lychee Tea">Mango Lychee Tea</option>
                <option value="Oolong Milk Tea">Oolong Milk Tea</option>
                <option value="Panda Milk Tea">Panda Milk Tea</option>
                <option value="Peach Green Tea">Peach Green Tea</option>
                <option value="Taro Milk Tea">Taro Milk Tea</option>
                <option value="Thai Iced Tea">Thai Iced Tea</option>
            </select>
        <button type="submit">Take me there!</button>
    </form>

    <!--these 2 line breaks are so the user can easily access the pid drop down
    and not get annoyed with accidentally hovering over black milk tea image-->
    <br>
    <br>


    <div class="menu-container">

        <div class="menu-item">
            <img src="images/thaitea.jpeg" alt="thai tea" class="img-boba">
            <p><strong><em>Thai Iced Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (400 reviews)</p>
            <p>$5.15</p>

            <!-- <p>Caffeinated black tea with creamer.<br><br>$4.75 </p> -->
        </div>

        <div class="menu-item">
            <img src="images/jasmine.jpeg" alt="jasmine milk tea" class="img-boba">
            <p ><strong><em>Jasmine Milk Tea</em></strong>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (552 reviews)</p>
            <p>$4.75</p>
            <!-- <p >Jasmine tea sweetened with sugar, simple syrup, and creamer.<br><br>$4.75</p> -->
        </div>

        <div class="menu-item">
            <img src="images/blackmilktea.jpeg" alt="black milk tea" class="img-boba">
            <p ><strong><em>Black Milk Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;&#9733; (450 reviews)</p>
            <p>$4.75</p>
            <!-- <p >Black tea sweetened with sugar, simple syrup, and creamer.<br><br>$4.75</p> -->
        </div>

        <div class="menu-item">
            <img src="images/peachgreen.jpeg" alt="peach green tea" class="img-boba">
            <p ><strong><em>Peach Green Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (301 reviews)</p>
            <p>$4.75</p>
            <!-- <p > Jasmine green tea with peach syrup.<br><br>$4.75 </p> -->
        </div>

        <div class="menu-item">
            <img src="images/taro.jpeg" alt="taro milk tea" class="img-boba">
            <p ><strong><em>Taro Milk Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (294 reviews)</p>
            <p>$5.15</p>
            <!-- <p >Jasmine tea sweetened with syrup, taro flavoring, and soy milk.<br><br>$4.75</p> -->
        </div>

        <div class="menu-item">
            <img src="images/coffee.jpeg" alt="coffee milk tea" class="img-boba">
            <p ></p><strong><em>Coffee Milk Tea</em></strong>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (460 reviews)</p>
            <p>$4.75</p>
            <!-- <p >Classic milk tea topped with a shot of espresso.<br><br>$5.50</p> -->
        </div>

        <div class="menu-item">
            <img src="images/earl.jpeg" alt="earl milk tea" class="img-boba">
            <p class="grid-item-text"><strong><em>Earl Grey Milk Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;&#9733;</i> (260 reviews)</p>
            <p>$4.75</p>
            <!-- <p class="grid-item-text">Sweetend with brown sugar and creamer.<br><br>$5.50</p> -->
        </div>

        <div class="menu-item">
            <img src="images/panda.jpeg" alt="panda milk tea" class="img-boba">
            <p class="grid-item-text"><strong><em>Panda Milk Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (400 reviews)</p>
            <p>$4.75</p>
            <!-- <p class="grid-item-text">Classic milk tea with black and white tapioca pearls.<br><br>$5.50</p> -->
        </div>

        <div class="menu-item">
            <img src="images/oolong.jpeg" alt="ooling milk tea" class="img-boba">
            <p class="grid-item-text"><strong><em>Oolong Milk Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;<i class="fa fa-star-half-full"></i> (350 reviews)</p>
            <p>$4.75</p>
            <!-- <p class="grid-item-text">Oolong milk tea with sugar, cream, and pink Himalayan salt.<br><br>$5.50</p> -->
        </div>

        <div class="menu-item">
            <img src="images/mango.jpeg" alt="mango lychee tea" class="img-boba">
            <p class="grid-item-text"><strong><em>Mango Lychee Tea</em></strong></p>
            <p style="text-transform: lowercase;">&#9733;&#9733;&#9733;&#9733;&#9733; (200 reviews)</p>
            <p>$4.75</p>
            <!-- <p class="grid-item-text">Mango & lychee!<br><br>$5.50</p> -->
        </div>
    </div>
</section>
</body>

<footer>
    <br>
    <p> 123 Sesame Street, Imagination Land, 123456</p>
    <p>HOURS: 9AM-9PM DAILY</p>
    <p >© 2021 POWERED BY THE UNORIGINAL BOBA STORE</p>


</footer>
</html>