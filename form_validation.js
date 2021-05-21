function validateForm(street, apt, city){
    submitOK = true;

    // For street
    var street_pattern = /^[0-9][0-9][0-9](?:[0-9])?(?:[0-9])?(\s[A-Za-z]+){2,}$/;
    var cred_num = document.getElementById("card_num").value;
    var street = document.getElementById("addr").value;

    if(street_pattern.test(street) == false)
    {
        alert("Please input a valid street address.");
        submitOK = false;
    }

    //For apt/suite/bldg
    var apt_pattern = /(Apt|Suite|Ste|Bldg)\s\d+$/;
    var apt = document.getElementById("addr2").value;

    if((apt != "") && (apt_pattern.test(apt) == false)){
        alert("Please input a valid apt/suite/bldg");
        submitOK = false;
    }

    //For city
    var city_pattern = /^[A-Za-z]+(?:[\s-][A-Za-z]+){0,2}$/;
    var city = document.getElementById("city").value;

    if(city_pattern.test(city) == false){
        alert("Please input a valid city");
        submitOK = false;
    }

    return submitOK;
}