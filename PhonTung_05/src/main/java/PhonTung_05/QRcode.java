/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhonTung_05;

/**
 *
 * @author eugene
 */
public class QRcode {
    
    
    
public String getHomePageWithTableNo(String TableNo){
    
    return "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"    <title>TODO supply a title</title>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <link rel=\"stylesheet\" href=\"home.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"menu.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"shoppingCar.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"companyFlip.css\" />\n" +
"    <script src=\"slideShow.js\"></script>\n" +
"    <script src=\"shoppingCar.js\"></script>\n" +
"    <script src=\"menu.js\" ></script>        \n" +
"</head>\n" +
"<body>\n" +
"    <div class=\"headTitle\">\n" +
"        \n" +
"        <label class=\"headTitle_common\" id=\"headTitle_A\" for=\"checkByLabel\" style=\"color:blue;\">參觀</label>\n" +
"        \n" +
"        <label class=\"headTitle_common\" \n" +
"               id=\"headTitle_B\" \n" +
"               for=\"checkByLabel_Order\"  \n" +
"               style=\"color:red;\"\n" +
"               onclick='toggle_InputOfContainer_B();'>點餐</label>\n" +
"        \n" +
"        <div class=\"headTitle_common\" id=\"headTitle_C\">\n" +
"            新城風糖餐廳  \n" +
"        </div>\n" +
"    </div>\n" +
"    \n" +
"  \n" +
"                        \n" +
"    <input type=\"checkbox\" id=\"checkByLabel\" style=\"display:none; width:0; height:0;\" >          \n" +
"    <div id=\"slidingMenu_A\">\n" +
"        <div id=\"YYY\" style=\"display: flex; flex-direction: column; background-color: white;\">\n" +
"                <h3 style=\"color: purple; left: 0;\">金牌饌</h3>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">品牌介紹</a>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">營運</a>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">美食定位</a>\n" +
"\n" +
"\n" +
"                <h3 style=\"color: purple; left: 0;\">產品介紹</h3>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">雞肉</a>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">雞蛋</a>\n" +
"                <a href=\"\" style=\"color: green; padding-left: 10px; font-size: 16px; font-family: 標楷體;\">糖</a>\n" +
"                \n" +
"        </div>\n" +
"    </div>\n" +
"    \n" +
"    <input type=\"checkbox\" id=\"checkByLabel_Order\" style=\"display:none; width:0; height:0;\">                          \n" +
"    <div id=\"slidingMenu_B\">\n" +
"        <ul id='menu' style='list-style: none;  padding-left: 5px'>\n" +
"\n" +
"        </ul>       \n" +
"    </div>     \n" +
"\n" +
"    \n" +
"    \n" +
"\n" +
"    <div id=\"container_A\">\n" +
"        <div class=\"displayRow_1\">\n" +
"            <div class=\"slideShow \" id=\"slideShow\">  <!-- https://www.w3schools.com/howto/howto_js_slideshow.asp -->\n" +
"\n" +
"                <a class=\"prev\" onclick=\"prev();\">&#10094;</a>\n" +
"                <a class=\"next\" onclick=\"next();\">&#10095;</a>                \n" +
"            </div>\n" +
"        </div>    \n" +
"        <div class=\"displayRow_2\">\n" +
"              <div class=\"card-wrap\" >\n" +
"                <div class=\"card\">            \n" +
"                    <div class=\"companyfront\" id=\"companyLeft\"\n" +
"                         style=\"background-image:url(image/A.PNG);\">  \n" +
"                        <span style=\"z-index:1; \n" +
"                                   font-size: 24; \n" +
"                                   float:left; color:red; \n" +
"                                   background-color: yellow; \n" +
"                                   font-family: 標楷體; \">務本踏實</span>\n" +
"                    </div>\n" +
"                    <div class=\"companyback\">\n" +
"                        <p style=\"color: blue; font-family: 標楷體; font-size: 32;\">品質第一</p> \n" +
"                        <p style=\"color: blue; font-family: 標楷體; font-size: 32;\">堅持專業</p> \n" +
"                        <p style=\"color: blue; font-family: 標楷體; font-size: 32;\">供需雙贏</p>\n" +
"                    </div>\n" +
"                </div>\n" +
"              </div>  \n" +
"              <div class=\"card-wrap\" >\n" +
"                <div class=\"card\">            \n" +
"                    <div class=\"companyfront\" \n" +
"                         style=\"background-image:url(image/D.PNG);\">  \n" +
"                        <span style=\"z-index:1; \n" +
"                                   font-size: 24; \n" +
"                                   float:left; color:red; \n" +
"                                   background-color: yellow; \n" +
"                                   font-family: 標楷體; \">永續經營</span>\n" +
"                    </div> \n" +
"                    <div class=\"companyback\">\n" +
"                        <p style=\"color: red; font-family: 標楷體; font-size: 32;\">唯才是用</p>\n" +
"                        <p style=\"color: red; font-family: 標楷體; font-size: 32;\">崇尚品德</p>\n" +
"                        <p style=\"color: red; font-family: 標楷體; font-size: 32;\">職人精神 </p>\n" +
"                    </div>\n" +
"                </div><!-- comment -->\n" +
"              </div>              \n" +
"        </div>    \n" +
"        <div class=\"displayRow_3\">\n" +
"            TEL:，FAX：；地址：；http：\n" +
"        </div>       \n" +
"    </div>    \n" +
"    \n" +
"    \n" +
"    \n" +
"    <div id=\"container_B\" >\n" +
"        <div id='container_B_shoppingHead'>\n" +
"            <div id='container_B_shoppingType'>\n" +
"                <input type=\"radio\" id=\"forHere\" name=\"serviceType\" value=\"內用\"><label for=\"forHere\">內用</label>\n" +
"                <span id='tableNo' style='display:flex; flex-direction:row;'></span>\n" +
"                <input type='text' value='5' size='2' style='text-align: center; font-size: 14px; '>桌                \n" +
"                <input type=\"radio\" id=\"toGo\" name=\"serviceType\" value=\"外帶\"><label for=\"toGo\">外帶</label>\n" +
"                <input type=\"radio\" id=\"delivery\" name=\"serviceType\" value=\"外送\"><label for=\"delivery\">外送</label>\n" +
"                <button value='下單' id='buttonPlaceOrder'\n" +
"                        style='background-color: greenyellow; color:red; \n" +
"                        border:none; \n" +
"                        display:flex; align-self: center; \n" +
"                        font-size: 24px; font-family: 標楷體;'\n" +
"                        onclick='placeOrder();'>下單\n" +
"                </button>\n" +
"\n" +
"            </div>\n" +
"            <div id=\"container_B_shoppingTypeContent\">\n" +
"                <input type=\"text\" id=\"deliveryTel\" name=\"deliveryTel\" value=\"電話\" size=\"9\" style=\"width:25%; align-self: center;\">\n" +
"                <input type=\"text\" id=\"deliveryName\" name=\"deliveryName\" value=\"名字\" size=\"9\" style=\"width:15%; align-self: center;\">\n" +
"                <input type=\"text\" id=\"deliveryAddress\" name=\"deliveryAddress\" value=\"地址\" size=\"30\" style=\"width:60%; align-self: center;\">                \n" +
"            </div>\n" +
"        </div>\n" +
"            <div id='container_B_placeOrder'></div>    \n" +
"    </div>\n" +
"\n" +
"    <span id=\"storeMaps\" style=\"display: none;\"></span>  <!-- retrieve maps from server and store responseStr here -->\n" +
"    <span id=\"storeProduct\" style=\"display: none;\"></span>  <!-- retrieve product to build array -->\n" +
"    <span id=\"storeProductType\" style=\"display: none;\"></span>  <!-- retrieve product to build array -->\n" +
"</body>\n" +
"</html>\n" +
"\n" +
"\n" +
"";
}

    
}
