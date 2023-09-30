/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this tempYlate
 */
    //var menu=[
    //    ['productType','productId','品名', '單價']
    //];
    var menu=null;

getMenu();
    //getProduct(); 
    
    
   // buildMenu();




function buildMenu(){
    document.addEventListener('readystatechange', event => { 
    // When HTML/DOM elements are ready:
    //if (event.target.readyState === "interactive") {   //does same as:  ..addEventListener("DOMContentLoaded"..
    //    alert("hi 1");
    //}
    


    // When window loaded ( external resources are loaded too- `css`,`src`, etc...) 
    // https://stackoverflow.com/questions/807878/how-to-make-javascript-execute-after-page-load
    if (event.target.readyState === "complete") {
        
        var y=null, x=null, str="", k="",kList="";
        //alert("1.   build menu types ;    //alert("after loading");
        //alert("2.   build products        //alert("after loading");
        y=document.getElementById("storeProductType").innerHTML;
        const y_length=y.split("\n").length;
        var tempY="", tempX="";
        //alert(document.getElementById("storeProduct").innerHTML);
        //alert("y length:  "+y.length);   
        for(let i=1; i<y.length; i++){
            //if(i === 0) continue;
            //x=y.split("\n")[i].split(",");
            if(!(y.split("\n"))|| y.length === 0 || y.split("\n")[i].split(",").length < 2) continue;    // 1. sequence no, x[0]; 2. menuType, x[1]; There are some appdening by system, currently no known.
            if(y.split("\n")[i].split(",")[1] === "end") break;
            k="type_"+i;
            kList="typeList_"+i;
            str += "<li><a href='#' id='"+k+"' onclick='toggleMenu(\""+kList+"\");'>"+y.split("\n")[i].split(",")[1]+"</a>"+
                    "<ul id='"+kList+"' style='display:none;'></ul>"+
                    "</li>";
            //j++;
        }
        document.getElementById("menu").innerHTML=str;
        
        str="";
        
        x=document.getElementById("storeProduct").innerHTML;
        const x_length=x.split("\n").length;
        //alert("x length:  "+x.length);
        //var p=0;
        for(let i=1; i<y.length; i++){      // productType
            
            if(!(y.split("\n"))|| y.length === 0 || y.length < 2) continue;          
            if(y.split("\n")[i].split(",")[1] === "end") break;
            
            //alert(++p);
            //z=x.split("\n")[i].split(",");                      // 1. sequence no, z[0]; 2. menuType z[1], product id z[2], product name z[3]; There are some appdening by system, currently no known.
            str="";
            tempY=y.split("\n")[i].split(",");            
            for(let j=1; j<x.split("\n")[j].length; j++){    // product
                tempX=x.split("\n")[j].split(",");
                if(x.split("\n")[j].split(",").length < 2) continue;
                if(x.split("\n")[j].split(",")[1] === "end") break; // html add two more lines to database; so, making an 'end' 
                
                //if(tempY[1].trim() === "海鮮") alert("tempY[1]= "+tempY[1]+"tempX[1]=  "+tempX[1]+", length "+x_length);
                switch(tempX[1]){
                   case tempY[1]:
                        
                        str += "<li><a href='#' id='"+
                               tempX[2]+
                               "' onclick='shopping(\""+
                               tempX[2]+
                               "\");'>"+
                               tempX[3]+
                               "</a></li>";
                       
                    break;
                    
                   default:
                   
               }
            }
            //alert(y.split("\n")[i].split(",")[1]+"   "+str);
            k="typeList_"+i;
            document.getElementById(k).innerHTML=str;
            
        }

                   
    }
    });    
    
    
    
   
    
}






function getMenu(){
    document.addEventListener('readystatechange', event => {     
    if (event.target.readyState === "complete"){
        //alert("getMenu  before ");
    
        var urlMenu="CSVservlet"+            // servlet 
                "?actionID=getMenu"+
                "&fileName=menu.csv"; ;   // parameters";


        let x=fetch(urlMenu)
            .then((response) => response.text())
            .then(y=>{
                document.getElementById("menu").innerHTML=y;
                //alert("get menu ..  "+y);
        
        });
                
        }
        

    });
}


function toggleMenu(k){
    var x= document.getElementById(k).style.display;
    var y=document.getElementById(k);
    if (x === "block" || x==="") y.style.cssText = "display: none;";
    else y.style.cssText = "display: block;";
}


function toggle_menu_B(){
    var x= document.getElementById("menu_B").style.display;  
    var y=document.getElementById("menu_B");
    if (x === "block" || x==="") y.style.cssText = "display: none;";
    else y.style.cssText = "display: block;";
}

function toggle_menu_A(){
    var x= document.getElementById("menu_A").style.display;  
    var y=document.getElementById("menu_A");
    if (x === "block" || x==="") y.style.cssText = "display: none;";
    else y.style.cssText = "display: block;";
}

function swapSlidingMenu(){
    var x= document.getElementById("headTitle_A").style.transform; 
    var y=document.getElementById("headTitle_A");
    if (x === "scaleX(0)") {
        alert("scaleX(0)");
        y.style.cssText = "transform: scaleX(1);";
    }
    else {
        alert(y.toString());
        y.style.cssText = "transform: scaleX(0);";
    }    
}