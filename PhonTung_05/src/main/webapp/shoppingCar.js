/* //
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

    
var shoppingCart=[
        ['rowNo','productType','品名', '單價','數量','小計','product ID', '餐點', '刪除']  // rowNo: -1  ->  delete
    ];

function placeOrder(){
  let text = "確定下單嗎?";    
  if (confirm(text) === true) {
    text = "You pressed OK!";
  } else {
    text = "You canceled!";
  }    
}    
function addShoppingCart(a1,a2,a3,a4,a7){
    // a1: product type
    // a2: product name
    // a3: unit price
    // a4: product ID
    // a8: image

    var found=false;
    var i=0;
  
    let b0=shoppingCart.length,
//        a1='沙拉';     product type
//        a2='沙拉A'     product name   
//        a3='3.00',    unit price 
//        a4='沙拉001',  product ID 
        b7='<div class="dishDiv"><img class="dishImage" src="'+a7+'" ></div>',
        b8='<input type="submit" value="刪" onclick="deletshoppingItem(' + b0 +')">';

    var b4=0,  // qty
        b5=0;   // subtotal
    //alert("length= "+shoppingCart.length);        
    for(var i=0; i<shoppingCart.length; i++){
        //alert("shoppingCart[i][0]= "+shoppingCart[i][0]);        
        //a4 and b[6] are product ID, b[4] is qty;
        if((a4 === shoppingCart[i][6]) && (shoppingCart[i][0] !== '-1')) {
            shoppingCart[i][4]=parseInt(shoppingCart[i][4])+1;
            shoppingCart[i][5]=shoppingCart[i][4]*a3;
            found=true;
            //alert("found= "+found);   
            //alert("a4=  "+a4+",  b6= "+shoppingCart[i][6]);
            break;
            //alert("found true");
        }
    }          
    
    if (!found) {
        //alert("not found");
        b4=1; 
        b5=b4*parseInt(a3);
        shoppingCart.push([b0,a1,a2,a3, b4, b5, a4,  b7, b8]);
    }
 
        
    //var found=false;
    
    displayShoppingCart();

} 

function updateQty(k, qty, unitPrice){
    for(var i=0; i<shoppingCart.length; i++){
        if(i===k) {
            shoppingCart[i][4]=qty;
            shoppingCart[i][5]=qty*unitPrice;
            break;
        }
    }
    displayShoppingCart();
}
    
    


function deletshoppingItem(a1){
    shoppingCart[a1][0]='-1';
    displayShoppingCart();
}

function displayShoppingCart(){
    //alert('before push    '+shoppingCart.length);
    
    
    var str="<table class='shoppingCartInContainer_B'>";;
    let i=0, j=0;
    var subtotal=0, total=0;
    var update_id='';
    while (shoppingCart.length > i) { // data row
        if(shoppingCart[i][0] === '-1') {i++;  continue;}
        switch (i){
            case 0:
                str +="<thead><tr style='padding:0; margin:0; line-height:16px;'>";
                j=0;
                for(const k of shoppingCart[i]) {
                    if (checkColumn(j)) {j++; continue;}
                    str +="<th style='color:red; width:\"10%\"; text-align: center;'> "+k+"</th>";
                    j++;
                }
                str +="</tr></thead>";
                break;
            default:
                //alert('i= '+shoppingCart.length);
                str +="<tr>";
                j=0;
                //subtotal=0;
                
                for(var k of shoppingCart[i]){
                    if (checkColumn(j)) {j++; continue;}
                    if(j===4){
                        subtotal=shoppingCart[i][j]*shoppingCart[i][j-1];
                        total += subtotal;
                        update_id='input_'+i;
                        k='<input id='+ '\"'+update_id +'\"'+
                            'type="text" \n\
                            size="2" \n\
                            value="'+
                            shoppingCart[i][j]+
                            '" style="border: none; \n\
                                   font-siz:24px; \n\
                                   color:red; \n\
                                   text-align: center; \n\
                                   height: 100%;\n\
                                   top:0px; \n\
                                   font-weight:bold;"'+
                            'onchange=updateQty('+ i +','+ 'document.getElementById("'+update_id +'").value'+','+shoppingCart[i][j-1]+ ');   >';
                    }
                    str +="<td style='text-align: center; padding:0; margin:0;'> "+k+"</td> ";
                    j++;
                }
                str +="</tr>";
        }
        i++;
    }
    str +="<tr style='border:none'>";       // total
    str +="<td style='border:none; text-align: center; color:red'> "+"總計"+"</td> ";
    str +="<td style='border:none; text-align: center;'> "+""+"</td> ";
    str +="<td style='border:none; text-align: center;'> "+""+"</td> ";
    str +="<td style='border:none; text-align: center; color:red'> "+total+"</td> ";  
    str +="</tr>";
    str += "</table>";
        //alert(str);
        
        document.getElementById("container_B_placeOrder").innerHTML =str;
}

function checkColumn(x){ //non display column
    if(x<2 || x===6)
        return true;
}


function getShoppingCar(){
    
    var xhr = new XMLHttpRequest();
    var urlShoppingCar="CSVservlet"+            // servlet 
            "?actionID=getShoppingCar"+
            "&fileName=shoppingCar.csv"; ;   // parameters
    xhr.open('GET', urlShoppingCar, true);
    xhr.send(null);    
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            //alert(xhr.responseText);
            document.getElementById("container_B_shoppingCar").innerHTML =xhr.responseText;  // two steps for getSlides, 
        }
    }    
}




function toggle_InputOfContainer_B(){
   
    //var y=document.getElementById("InputOfContainer_B").type;
    //var x=document.getElementById("InputOfContainer_B");
    
    var y=document.getElementsByClassName('InputOfContainer_B');
    var x=null;
    
    if(y.length>0) {
        for(const x of y){
            switch(x.type){
            case 'hidden':
                for(const k of y) k.type='text';
                break;
            case 'text':
                for(const k of y) k.type='hidden';
            break;
            default:    
        }            
        }
        
    }
    
}