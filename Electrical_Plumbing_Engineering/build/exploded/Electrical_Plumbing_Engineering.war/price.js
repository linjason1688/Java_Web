function toilet_drop_down() {
    var ol = document.getElementById("toilet_ol");
    
    if (ol.innerHTML.length == 0) {
        ol.innerHTML += "<li>" + "和成HCG</li>" +
                        "<li>" + "TOTO</li>" + 
                        "<li>" + "凱薩</li>";
    }
    else {
        ol.innerHTML = "";
    }
}

function caculate() {
    var unit_price = parseInt(document.getElementById("unit_price").textContent);
    var count = parseInt(document.getElementById("input_1").value);
    var total = unit_price * count;
    
    document.getElementById("total").textContent = total;
}

function deleteItem() {
    var count = parseInt(document.getElementById("input_1").value);
    var unit_price = document.getElementById("unit_price");
    var tb = document.getElementById("tb");
    
    if (count.innerHTML != 0) {
        tb.innerHTML = "";
    }
}