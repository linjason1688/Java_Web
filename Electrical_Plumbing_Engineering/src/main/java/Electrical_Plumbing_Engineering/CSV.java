/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electrical_Plumbing_Engineering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Jason
 */
//讀檔處理
public class CSV {
    String backendFileName="", frontFileName="";
    File filePointer = null;
    BufferedReader bufferReader = null;
    static final String UTF8_BOM = "\uFEFF";
    static final String token = ",", htmlSpace = "&nbsp";
    
    public CSV(String realPathOfservlet, String frontFileName) {
        this.frontFileName = frontFileName;
        
        String str = "", projectDirectory = "", projectName = "";
        String[] spt = null;
        String fileDirectory = "", imageDirectory = "";
        
        spt = realPathOfservlet.split(".war");
        realPathOfservlet = spt[0];
        spt = realPathOfservlet.split("\\\\");
        projectName=spt[spt.length-1];
        
        spt = realPathOfservlet.split(projectName);
        projectDirectory = spt[0];
        fileDirectory = projectDirectory + projectName + "\\src\\main\\java\\" + projectName + "\\Data";
        imageDirectory = projectDirectory + projectName +"\\src\\main\\webapp\\image\\";
        backendFileName = fileDirectory + frontFileName;
    }
    
    //設定讀檔緩衝區讀不到檔案, 不支援解碼發生的例外情況
    public void setReadBuffer() throws FileNotFoundException,UnsupportedEncodingException {
        //1.引用檔案
        //2.讀檔
        //3.將讀取到的檔案放到緩衝讀取器裡面撰寫
        filePointer = new File(backendFileName);
        InputStreamReader readDevice = new InputStreamReader(new FileInputStream(filePointer), "UTF-8");
        bufferReader = new BufferedReader(readDevice);
    }
    
    //設定關檔爆錯流程
    public void close() throws IOException {
        //1.緩衝區關閉檔案
        //2.如果檔案有存在或檔案為空值，將讀檔指標清空
        bufferReader.close();
        if (filePointer.exists() || filePointer.isFile()) {
            filePointer = null;
        }
    }
    
    //設定欄位清單的爆錯流程
    public String fieldsList() throws IOException {
        //1.當緩衝讀取區的資料不是空值
        //2.如果讀取資料的起始編碼為UTF8_BOM，移除UTF8_BOM
        String str = "";
        String strReadLine = null;
        String[] spt = null;
        
        str = "<select name='selectionFields' id='selectionFields' style='width: 120px;'>";
        int num = 0;//放在迴圈裡面
        while ((strReadLine = bufferReader.readLine()) != null) {
            if (strReadLine.startsWith(UTF8_BOM)) {
                strReadLine = strReadLine.substring(1);
                spt = strReadLine.split(token);
            }
            
            for(String opt_val:spt) {
                str += "<option value'" + Integer.toString(0) + opt_val + "</option>";
                num++;
            }
            break;
        }
        
        return str + "</select>";
    }
}
