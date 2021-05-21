
function getPlace(zip)
{
    if (window.XMLHttpRequest)
    {  // IE7+, Firefox, Chrome, Opera, Safari
        var xhr = new XMLHttpRequest();
    }
    else
    {  // IE5, IE6
        var xhr = new ActiveXObject ("Microsoft.XMLHTTP");
    }

    // Register the embedded handler function
    // This function will be called when the server returns
    // (the "callback" function)
    xhr.onreadystatechange = function ()
    { // 4 means finished, and 200 means okay.
        if (xhr.readyState == 4 && xhr.status == 200)
        { // Data should look like "Fairfax, Virginia, 0.08"
            var result = xhr.responseText;
            var place = result.split (', ');
            //if (document.getElementById ("city").value == "")
            document.getElementById ("city").value = place[0];
            //if (document.getElementById ("state").value == "")
            document.getElementById ("state").value = place[1];

            document.getElementById("total_price").value = parseFloat(((parseFloat(place[2]) + 1.0) * parseFloat(document.getElementById("total_price").value)).toString()).toFixed(2) ;
        }
    }
    // Call the response software component
    //xhr.open ("GET", "getCityState?zip=" + zip, true);
    //xhr.send ();
    xhr.open ("POST", "getCityStateServlet", true);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    xhr.send ("Zip Code="+zip);
}