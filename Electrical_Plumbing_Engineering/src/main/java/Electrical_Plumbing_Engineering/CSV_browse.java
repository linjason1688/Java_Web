/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electrical_Plumbing_Engineering;

import static Electrical_Plumbing_Engineering.CSV.UTF8_BOM;
import java.io.IOException;
/**
 *
 * @author Jason
 */
public class CSV_browse extends CSV {
    public CSV_browse(String realPathOfservlet, String frontFileName) {
        super (realPathOfservlet, frontFileName);
    }
    
    public String htmlForBrowse() throws IOException {
        String str = "";
        
        String tempString="";
        String strReadline = "";
        String[] spt = null;
        
        str = "<table width='100%' style='table-layout:fixed;'>";
        int row=0;
        int col=0;
        
        while((strReadline=bufferReader.readLine()) != null) { //data row
            spt = strReadline.split(token);
            tempString = "";
            
            if (row == 0) { //the operation of the first row
                for(String k:spt) {
                    tempString += "<td style='background-color:yellow; color:red;'>" + k + "</td>";
                    col++;
                }
                tempString = "<tr>" + tempString + "</tr>";
                
                for (int k=0; k<col; k++) { // the width setting of columns
                    if (k == (col-1)) {
                        tempString = "<col width='4%' />" + tempString;
                    }
                    else {
                        tempString = "<col width='24%' />" + tempString;
                    }
                    
                    str = str + tempString; //set column width
                }
            }
            
            else {
                for (int k=0;k<col;k++) {
                    if (k >= spt.length) {
                        tempString += "<td>" + "" + "</td>";
                    }
                    else {
                        tempString += "<td>" + spt[k] + "</td>";
                        str += "<tr>" + tempString + "</tr>";
                    }
                }
            }
            
            row++;
        }
        
        str += "</table>";
        return str;
    }
    
    public String showFields() throws IOException {
        String str = "";
        String strReadLine = null;
        String[] spt = null;
        
        str = "";
        int num=1;
        while ((strReadLine=bufferReader.readLine()) != null) {
            spt = str.split(token);
            
            for (String k:spt) {
                str += "Field" + Integer.toString(num) + ":" + htmlSpace + htmlSpace + k + "<br>";
                num++;
            }
            break;
        }
        
        return str;
    }
    
    public String getSlides() throws IOException {
        String strReadLine = "", str = "";
        int i = 0;
        
        while ((strReadLine=bufferReader.readLine()) != null) {
            if (i != 0) {
                str += strReadLine + ",";
                i++;
            }
        }
        return str;
    }
    
    public String getFieldOfShoppingCar() throws IOException {
        String str = "";
        String strReadLine = null;
        String[] spt = null;
        
        str = "";
        int num = 1;
        while ((strReadLine=bufferReader.readLine()) != null) {
            spt = strReadLine.split(token);
            
            str = "<table class='InputOfContainer_B' type='hidden' width='80%' style='color:blue;'><thead><tr>";
            for (String k:spt) {
                str += "<th>" + k + "</th>";
                num++;
            }
            
            str += "</tr></thead></table>";
            break;
        }
        
        return str;
    }
    
    public String getMenu() throws IOException {
        String str="", tempString="", strReadLine="", k="", kList="", kParameters="";
        String[] spt = null;
        
        int row = 0;
        int col = 0;
        
        while ((strReadLine = bufferReader.readLine()) != null) {
            if (row == 0) {
                row++;
                continue;
            }
            
            if (strReadLine.startsWith(UTF8_BOM)) {
                strReadLine = strReadLine.substring(1);
                spt = strReadLine.split(token);
            }
            
            if (spt[0].equalsIgnoreCase("begin")) {
                k = "type_" + String.valueOf(row);
                kList = "typeList_" + String.valueOf(row);
                str += "<li><a href='#' id='"+k+"' onclick='toggleMenu(\""+kList+"\");'>" +
                        spt[1] +
                        "</a>" +
                        "<ol id='" +
                        kList +
                        "' style='display:none;'>";
                row++;
                continue;
            }
            
            if (spt[0].equalsIgnoreCase("end")) {
                str += "</ol></li>";
                row++;
                continue;
            }
            
            kParameters = "\"" + spt[1] + "\"" + "," +
                          "\"" + spt[2] + "\"" + "," +
                          "\"" + spt[3] + "\"" + "," +
                          "\"" + spt[4] + "\"" + "," +
                          "\"" + spt[5] + "\"";
            
            str += "<li><a href='#' id='" +
                    spt[1] +
                    "' onclick='addShoppingCart('" +
                    kParameters +
                    ");'>" +
                    spt[2] +
                    "</a></li>";
            row++;
        }
        
        return str;
    }
    
    public String getProduct() throws IOException {
        String strReadLine="", str="";
        int row=0;
        
        while ((strReadLine = bufferReader.readLine()) != null) {
            if (strReadLine.startsWith(UTF8_BOM)) {
                strReadLine = strReadLine.substring(1);
                str += String.valueOf(row) + "," + "\n";
                row++;
            }
        }
        str = str.substring(0, str.length() - 1);
        
        return str;
    }
    
    public String getProductType() throws IOException {
        String strReadLine="", str="";
        int row = 0;
        
        while ((strReadLine = bufferReader.readLine()) != null) {
            if (strReadLine.startsWith(UTF8_BOM)) {
                strReadLine = strReadLine.substring(1);
                str += String.valueOf(row) + "," + "\n";
                row++;
            }
        }
        str = str.substring(0, str.length()-1);
        
        return str;
    }
}
