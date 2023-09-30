var slideOfSlideShow=document.getElementsByClassName("slideOfSlideShow"); // get an array of classes

/* 
 1. 'setInterval' repeats executing rotateImg function every 6 seconds
 2. https://developer.mozilla.org/zh-TW/docs/Web/API/setInterval
*/
var activeSlide=window.setInterval(carouselImg, 6000);  // activeSlide is useles in this command

function carouselOfDisplayRow_1(){      // init active element when papge loaded
    activeSlide=0;        // initial value
    slideOfSlideShow[activeSlide].style.display="block";
}

function carouselImg(){
    slideOfSlideShow[activeSlide].style.display="none";  // making active element hidden
    
    if(activeSlide >= slideOfSlideShow.length-1) activeSlide=0; // setting next active element
    else activeSlide++;
    
    slideOfSlideShow[activeSlide].style.display="block"; // making next element active

}

function prev(){
    slideOfSlideShow[activeSlide].style.display="none"; 
    activeSlide--;
    if(activeSlide <0) activeSlide=slideOfSlideShow.length-1;
    slideOfSlideShow[activeSlide].style.display="block";    // making previous element active
}
        
function next(){
    slideOfSlideShow[activeSlide].style.display="none"; 
    activeSlide++;
    if(activeSlide >= slideOfSlideShow.length-1) activeSlide=0;
    slideOfSlideShow[activeSlide].style.display="block";    // making previous element active    
}  