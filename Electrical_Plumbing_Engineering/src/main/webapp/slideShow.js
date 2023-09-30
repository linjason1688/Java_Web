var slideOfSlideShow = document.getElementsByClassName("slideOfSlideShow"); // get an array of classes

var activeSlide = window.setInterval(carouselImg, 10000);  // activeSlide is useles in this command

function carouselOfDisplayRow_1(){      // init active element when papge loaded
    activeSlide = 0;        // initial value
    document.getElementById("slideShow").style.backgroundImage = "url(image/"+activeSlide+".jpg)";    
}

function carouselImg(){
    activeSlide++;

    if(activeSlide >= slideOfSlideShow.length-1) {
        activeSlide = 0;
    }

    document.getElementById("slideShow").style.backgroundImage = "url(image/"+activeSlide+".jpg)";
}

function prev(){
    activeSlide--;

    if(activeSlide < 0) {
        activeSlide = slideOfSlideShow.length-1;
    }

    document.getElementById("slideShow").style.backgroundImage = "url(image/"+activeSlide+".jpg)";    // making previous element active
}
        
function next(){
    activeSlide++;

    if(activeSlide >= slideOfSlideShow.length-1) {
        activeSlide = 0;
    }

    document.getElementById("slideShow").style.backgroundImage = "url(image/"+activeSlide+".jpg)";
}