var slideOfSlideShow=document.getElementsByClassName("slideOfSlideShow"); // get an array of classes
var win = window,
        doc = document,
        docElem = doc.documentElement,
        body = doc.getElementsByTagName('body')[0];
var slideImage=null;
 
/* 
 1. 'setInterval' repeats executing rotateImg function every 6 seconds
 2. https://developer.mozilla.org/zh-TW/docs/Web/API/setInterval
*/
var activeSlide=window.setInterval(carouselImg, 10000);  // activeSlide is useles in this command

function carouselOfDisplayRow_1(){      // init active element when papge loaded
    activeSlide=0;        // initial value
    doc.getElementById("slideShow").style.backgroundImage="url(image/"+activeSlide+".jpg)";
   //doc.getElementById("slideShow").style.backgroundImage="url(image/2.jpg)";
    
}

function carouselImg(){
    activeSlide++;
    if(activeSlide >= slideOfSlideShow.length-1) activeSlide=0;
    doc.getElementById("slideShow").style.backgroundImage="url(image/"+activeSlide+".jpg)";
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