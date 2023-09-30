/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
        x = win.innerWidth || docElem.clientWidth || body.clientWidth,
        y = win.innerHeight|| docElem.clientHeight|| body.clientHeight;

function showOrientalTea_5(){
    document.getElementById("companyLeft_Span").innerHTML="";
    if(x>750)   document.getElementById("companyLeft").style.backgroundImage="url('image/5.png')";
    else        document.getElementById("companyLeft").style.backgroundImage="url('image/5_1.png')";
    document.getElementById("companyLeft_title").innerHTML="三等獎";
}

function showOrientalTea_6(){
    document.getElementById("companyLeft_Span").innerHTML="";
    if(x>750)   document.getElementById("companyLeft").style.backgroundImage="url('image/6.png')";
    else        document.getElementById("companyLeft").style.backgroundImage="url('image/6_1.png')";
}

function showOrientalTea_7(){
    if(x>750)   document.getElementById("companyRight").style.backgroundImage="url('image/7.png')";
    else        document.getElementById("companyRight").style.backgroundImage="url('image/7_1.png')";
    document.getElementById("companyRight_title").innerHTML="綠包裝";
}

function showOrientalTea_9(){
    if(x<750)   {
        document.getElementById("companyLeft_Span").style.fontSize ="12px";
        //alert(document.getElementById("companyLeft_Span").style.fontSize);
    }
    document.getElementById("companyLeft_Span").innerHTML="東方美人茶為高價值的經濟作物。政府與農會舉辦評鑑比賽，並輔導茶農茶園管理、精進製茶、焙茶技術，提昇品質及分級包裝，讓消費者買的放心、喝的安心，進而增加茶農收益與市場競爭力。";
    document.getElementById("companyLeft_title").innerHTML="美人茶簡介";
}

function showOrientalTea_10(){
    if(x<750)   {
        document.getElementById("companyLeft_Span").style.fontSize ="12px";
        //alert(document.getElementById("companyLeft_Span").style.fontSize);
    }
    document.getElementById("companyLeft_Span").innerHTML="據傳十八世紀末十九世紀初台灣茶葉歷史記載---英國商人將台灣出口的茶葉獻給維多利亞女皇品嚐，女皇喜見五色(紅、黃、白、褐、綠)斑瀾的茶葉翻滾舞動，猶如翩然起舞的東方美人，品嚐後對於色、香、味驚嘆不已，因此而命名「東方美人茶」。";
    document.getElementById("companyLeft_title").innerHTML="美人茶簡介";
}

function showOrientalTea_11(){
    if(x<750)   {
        document.getElementById("companyLeft_Span").style.fontSize ="12px";
        //alert(document.getElementById("companyLeft_Span").style.fontSize);
    }
    document.getElementById("companyLeft_Span").innerHTML="茶葉主要盛產於桃園、新竹、苗栗地區的青心大冇種，在夏季芒種前後，嫩芽經浮塵子(小綠葉蟬)蛀蝕後，在身經百戰阿嬤級的巧手採收下，再以傳統技術精製而成，它的茶湯水色甘甜而富蜜香有一種「蝝仔氣」深受品茗人士喜愛，極富商品價值。";
    document.getElementById("companyLeft_title").innerHTML="美人茶簡介";
}