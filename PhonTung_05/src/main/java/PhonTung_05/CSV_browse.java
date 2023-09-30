package PhonTung_05;

import static PhonTung_05.CSV.UTF8_BOM;
import java.io.IOException;


public class CSV_browse extends CSV {

    public CSV_browse(String realPathOfservlet, String frontFileName) {
        super(realPathOfservlet, frontFileName);
    }
    
    public String htmlForBrowse() throws IOException{
        String str="";

        String tempString="";
        String strReadline="";
        String[] y=null;
        
        str ="<table width='100%' style='table-layout:fixed;'>";
        int i=0,    // row index
            j=0;    // col index
        
        while ((strReadline=bufferReader.readLine()) != null) { // data row
            y=strReadline.split(token);
            tempString="";
            
            if(i==0) {  //the operation of the first row
                for(String k:y) {
                    tempString +="<td style='background-color:yellow; color:red; ' >"+k+"</td> ";
                    j++;
                }
                tempString ="<tr>"+tempString+"</tr>";
                for(int k=0; k<j; k++) {        // the width setting of columns
                    if(k==(j-1)) tempString ="<col width='4%' />"+tempString;
                    else tempString ="<col width='24%' />"+tempString;
                }
                str=str+tempString; // set column width
            }
            else {
                for(int k=0; k<j; k++) 
                    if(k >= y.length) tempString +="<td>"+""+"</td> "; 
                    else tempString +="<td>"+y[k]+"</td> ";
                str +="<tr>"+tempString+"</tr>";
            }
            
            
            i++; 
        }           
        str += "</table>"; 
        return str;
    }
    public String showFields() throws IOException{
        String str="";
        String strReadline=null;
        String[] y=null;
        
        str ="";
        int i=1;
        while ((strReadline=bufferReader.readLine()) != null) { // data row
            y=strReadline.split(token);

            for(String k:y) {
                str +="Field "+Integer.toString(i)+" :"+htmlSpace+htmlSpace+k+"<br> ";
                i++;
            }           
            break;
        }
        return str;
   }
    
    public String getSlides() throws IOException{
        String strReadline="", str="";
        int i=0;    // row index
        
        while ((strReadline=bufferReader.readLine()) != null) { 
            if(i != 0) str += strReadline+",";
            i++;
        }
        return str;
    }
    
    
public String getFieldsOfShoppingCar() throws IOException{
        String str="";
        String strReadline=null;
        String[] y=null;
        
        str ="";
        int i=1;
        while ((strReadline=bufferReader.readLine()) != null) { // data row
            y=strReadline.split(token);

            str="<table class='InputOfContainer_B' type='hidden' width='80%' style='color:blue;'><thead><tr>";
            for(String k:y) {
                str +="<th> "+k+"</th> ";
                //str +=k+",  ";
                i++;
            }           
            str += "</tr></thead></table>";
            break;
        }
        return str;
   }

public String getMenu() throws IOException{
        String str="", tempString="", strReadline="", k="", kList="", kParameters="";
        String[] y=null;
        
        
        int i=0,    // row index
            j=0;    // col index
        /*
        /*
            y[4]: html_li
            y[5]: html_li
        
        */
        
        while ((strReadline=bufferReader.readLine()) != null) { // data row
            if(i==0) {  i++; continue; }  //the operation of the first row
            if (strReadline.startsWith(UTF8_BOM)) strReadline = strReadline.substring(1);  // remove UTF8_BOM
            y=strReadline.split(token);
            if(y[0].equalsIgnoreCase("begin") ){    // begin of product type
                k="type_"+String. valueOf(i);
                kList="typeList_"+String. valueOf(i);
                str += "<li><a href='#' id='"+k+"' onclick='toggleMenu(\""+kList+"\");'>"+
                        y[1]+
                        "</a>"+
                        "<ol id='"+
                        kList+
                        "' style='display:none;'>";
                i++;
                continue;
            }    
            if(y[0].equalsIgnoreCase("end") ){  // end of product type
                str += "</ol></li>";
                i++;
                continue;
            }
            kParameters="\""+y[1]+"\""+","+
                        "\""+y[2]+"\""+","+
                        "\""+y[3]+"\""+","+
                        "\""+y[4]+"\""+","+
                        "\""+y[5]+"\"";
            str += "<li><a href='#' id='"+          // product items
                               y[1]+
                               "' onclick='addShoppingCart("+
                               kParameters+
                               ");'>"+
                               y[2]+
                               "</a></li>";
            i++; 
        }           
        return str;
}

public String getProduct() throws IOException{
    String strReadline="", str="";
    int i=0;
    while ((strReadline=bufferReader.readLine()) != null) {
        if (strReadline.startsWith(UTF8_BOM)) strReadline = strReadline.substring(1);  // remove UTF8_BOM
        str += String.valueOf(i)+","+strReadline+"\n";
        i++;
    }    
    str=str.substring(0, str.length()-1);
    
    return str;
}

public String getProductType() throws IOException{
    String strReadline="", str="";
    int i=0;
    while ((strReadline=bufferReader.readLine()) != null) {
        if (strReadline.startsWith(UTF8_BOM)) strReadline = strReadline.substring(1);  // remove UTF8_BOM
        str += String.valueOf(i)+","+strReadline+"\n";
        i++;
    }    
    str=str.substring(0, str.length()-1);
    
    return str;
}


    

}
