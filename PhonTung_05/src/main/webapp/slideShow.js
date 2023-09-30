var slideOfSlideShow=null, activeSlide=null;
var win = window,
        doc = document,
        docElem = doc.documentElement,
        body = doc.getElementsByTagName('body')[0];
var slideImage=null;

initBody(); // before page loaded, get slides first

 
/* 
 1. 'setInterval' repeats executing carouselImg function every 10 seconds
 2. https://developer.mozilla.org/zh-TW/docs/Web/API/setInterval
*/
var activeSlide=window.setInterval(carouselImg, 10000);  // activeSlide is useles in this command

function initBody(){      // init active slide through servlet
/* 
 1. call java from javascript 
 2. https://stackoverflow.com/questions/3028490/calling-a-java-servlet-from-javascript
 3. https://www.w3schools.com/js/js_ajax_intro.asp
*/    
    
    var xhr = new XMLHttpRequest();
    var url="CSVservlet"+            // servlet 
            "?actionID=getSlides"+
            "&fileName=slides.csv";   // parameters
    xhr.open('GET', url, true);
    xhr.send(null);    
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            document.getElementById("storeMaps").textContent =xhr.responseText;  // two steps for getSlides, 
                                                                            // (1): storing into a span when page has not been loaded
            //alert("in   "+document.getElementById("storeMaps").textContent );
            getSlides();                                                      // (2): getting storage from the span after page has not been loaded
            carouselImg();                                                  // setting time interval
        }
    };
    

    
    activeSlide=0;        // initial value
    
    

    //getProductType();    // these files must be done before build menu
    //getProduct();      // these two extractions cannot be put togethre, they interference each other



}
/* two steps for getSlides,  
  (2): getting storage from the span after page has not been loaded
 */
function getSlides(){
    slideOfSlideShow=document.getElementById("storeMaps").textContent.split(",");
}

function carouselImg(){
    if(activeSlide >= slideOfSlideShow.length-1) activeSlide=0;
    doc.getElementById("slideShow").style.backgroundImage="url("+slideOfSlideShow[activeSlide]+")";
    activeSlide++;
}

function prev(){
    activeSlide--;
    if(activeSlide <0) activeSlide=slideOfSlideShow.length-1;
    doc.getElementById("slideShow").style.backgroundImage="url(image/"+activeSlide+".jpg)";    // making previous element active
}
        
function next(){
    activeSlide++;
    if(activeSlide >= slideOfSlideShow.length-1) activeSlide=0;
    doc.getElementById("slideShow").style.backgroundImage="url(image/"+activeSlide+".jpg)";
    
}  

function getProductType(){
    var xhrType = new XMLHttpRequest();
    var urlType="CSVservlet"+            // servlet 
            "?actionID=getProductType"+
            "&fileName=productType.csv"; ;   // parameters
    
    xhrType.open('GET', urlType, true);
    xhrType.send(null);    
    xhrType.onreadystatechange = function() {
        if (xhrType.readyState === 4) {
            //alert(xhr.responseText);
            document.getElementById("storeProductType").innerHTML =xhrType.responseText;  // two steps for getSlides, 
            //alert("Type  ...  "+xhrType.responseText);
        }
    }        
    
/*
    var urlProductType="CSVservlet"+            // servlet 
            "?actionID=getProductType"+
            "&fileName=productType.csv"; // parameters";
    
    
    var a=null,b=null;
    fetch(urlProductType)
        .then((response) => response.text())
        .then(responseType=>{
            //if(!isEmpty(document.getElementById("storeProductType").innerHTML))
            document.getElementById("storeProductType").innerHTML =responseType;
            //alert("Type  ...  "+responseType);
            
    });    
 */    

}

function getProduct(){
    var urlProduct="CSVservlet"+            // servlet 
            "?actionID=getProduct"+
            "&fileName=product.csv"; // parameters";
    
    
    var a=null,b=null;
    fetch(urlProduct)
        .then((response) => response.text())
        .then(responseProduct=>{
            //if(!isEmpty(document.getElementById("storeProduct").innerHTML))
                document.getElementById("storeProduct").innerHTML =responseProduct;
            //alert(document.getElementById("storeProduct").innerHTML);
    });    
}

function isEmpty(val){
    return (val === undefined || val == null || val.length <= 0) ? true : false;
}





