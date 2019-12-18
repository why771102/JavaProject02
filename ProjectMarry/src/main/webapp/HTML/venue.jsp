<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="../CSS/combine.css">
 <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>
<style>
  #map {
      
      
        width: 100%;
        height: 60vh;
      

    }

</style>
<title>Venue</title>
</head>
<body>

  <div class="wrap" id="bg">
        <!-- header -->
        <div class="wrap end_gray_border" id="head">
           <iframe class="fullwidth" src="Header.jsp" frameborder="0"></iframe>
        </div>
<br>
<div><br></div>
        <!-- article -->
        <div class="wrap end_gray_border" id="Product_list">
            <!-- top  -->
            <!-- <div class="wrap end_gray_border" id="chooseAll">
                <input type="checkbox"> <label for=""> 全部選取</label>
            </div> -->
            <!-- content  -->
            <div class="wrapRow" id="content">

                <!-- left  -->
                <div class="wrapStart" id="product_left">

                    <!-- 圖片輪播  style 跟javascript 有關 不能改 -->
                    <div class="wrap" id="pictureBG">
                        <div class="w3-content wrap One_width vh_height100" id="bigpic" >
                             
                            <img class="mySlides P_Bimg" src="img/1.jpg" style=" display:none">
                            <img class="mySlides P_Bimg" src="img/2.jpg">
                            <img class="mySlides P_Bimg" src="img/3.jpg" style="display:none">
                            <img class="mySlides P_Bimg" src="img/44.jpg" style="display:none">

                            <!-- small picture -->
                            <div class="wrapRow" style="height: 15vh; width: 80%; padding: 2vh; "id="smallpic">
                                <div class="w3-col s4 w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/1.jpg"
                                        style="  cursor:pointer" onclick="currentDiv(1)">
                                </div>

                                <div class="w3-col s4 w3cpicture ">
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/2.jpg"
                                        style="  cursor:pointer" onclick="currentDiv(2)">
                                </div>

                                <div class="w3-col s4 w3cpicture" >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100 " src="img/3.jpg"
                                        style="   cursor:pointer" onclick="currentDiv(3)">
                                </div>

                                <div class="w3-col s4  w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/4.jpg"
                                        style="  cursor:pointer" onclick="currentDiv(4)">
                                </div>


                            </div>
                            <!-- small picture -->
                        </div>
                    </div>
                    <!-- 圖片輪播  -->

                    <!-- 空白排版用 -->
                    <div class="wrapList">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                    <!-- 分隔商品資訊框框 -->
                    <div class="wrapList end_gray_border">

                        <p class="STital">場地資訊</p>
                        <div class="wrapRow">
                            <div class="wrapStart VH_R_padding15">

                                <p class="text">場地材質</p>
                                <p class="text">場地來源</p>
                                <p class="text">庫存</p>
                            </div>
                            <div class="wrapStart">
                                <p class="text">不鏽鋼</p>
                                <p class="text">商品來源</p>
                                <p class="text">庫存</p>
                            </div>
                        </div>



                    </div>
                    <!-- 分隔商品資訊框框 -->

                    <!-- 空白排版用 -->
                    <div class="wrapList">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->


                    <!-- 預定時間 -->
                    <div class="wrapList end_gray_border">

                        <div class="wrapList height100" >
                            <p class="STital">可預訂時間</p>

                            <div class="wrapRow One_width" >
                                <div class="wrap One_width" >

                                    <div class="wrapRowStart One_width"  id="datepicker_show"></div>
                                    <!-- <iframe src="calendar.html" width="100%" height="40" frameborder="0" scrolling="no"></iframe> -->



                                </div>



                            </div>
                        </div>

                    </div>
                    <!-- 預定時間 -->
                </div>

                <!-- right  -->
              <div class="wrapStart " id="product_right">
                    <form action="../PutItemInShoppingCartServlet" method="post" class="fullwidth" id="VenueForm">
                        <div class="wrapList">
                            <p class="tital ">典華飯店 A廳</p>
                            <input type="hidden" name="vendor" value="paul">
                            <input type="hidden" name="Hall" value="a">
                            <input type="hidden" name="Price" value="600">
                            <input type="hidden" name="ProductID" value="V1">

                            <input type="hidden" name="VendorID" value="1">
                        </div>
                        <div class="wrapList">
                            <p class="tital">NT$600</p>
                        </div>


                        <div class="wrapList "> <label for="">桌數</label></div>


                        <div class="wrapList">
                            <input  class=" fullwidth" type="number" max="100" min="0" name="Table" id="table" required>
                        </div>
                        <div class=""> <br></div>
                        <div class="wrapList"> <label for="">選擇日期</label></div>
                        <div class="wrapRowBtw  LR_samll_padding small_padding">
                            <div class="width40">Date: <input style="width: 100%;" type="text" name="Date" id="datepicker_onlick"></div>
                            
                        </div>
                    
                        <div class=" fullwidth LR_samll_padding small_padding">
                           Time:
                        <select class="product_sel" name="Time" id="time"  onclick="c()">
                                    <option value="" selected="" disabled="">請選擇時段</option>
                                    　 <option value="0">早場</option>
                                    　 <option value="1">晚場</option>

                                </select>
                            </label>
                        </div>

                        <div class="wrapList ">
                            <br>


                            <div class="submitButton"
                                onclick="Check_Submit_Form()">

                                <p>加入購物車</p>
                            </div>



                        </div>
                    </form>
                    <div class="wrapList end_gray_border ">
                        <p>付款後，從備貨到寄出商品為 2 個工作天。（不包含假日）
                            設計館提供統一發票或免用統一發票收據</p>
                    </div>

                    <div class="wrapList">
                        <p></p><br><br>
                    </div>

                    <!-- 分隔商品資訊框框 -->
                    <div class="wrapList end_gray_border">
                        <div class="wrapList">
                            <p class="STital">關於場地</p>
                            <div class="wrapRow">
                                <div class="wrapStart VH_R_padding15" >

                                    <p class="text">飯店名稱</p>
                                    <p class="text">星級</p>
                                    <p class="text">樓層</p>
                                </div>
                                <div class="wrapStart">
                                    <p class="text">倫倫飯店</p>
                                    <p class="text">5</p>
                                    <p class="text">2F</p>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- 分隔商品資訊框框 -->
                    <!-- 空白排版用 -->
                    <div class="wrapList">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                    <!-- 分隔商品資訊框框 -->
                    <div class="wrapList end_gray_border">
                        <div class="wrapList">
                            <p class="STital">交通資訊</p>
                            <div class="wrapRow">
                                <div class="wrapStart VH_R_padding15" >

                                    <p class="text">場地地址</p>
                                    <p class="text">捷運</p>
                                    <p class="text">公車</p>
                                </div>
                                <div class="wrapStart">
                                    <p class="text">台北市大安區</p>
                                    <p class="text">捷運大安站</p>
                                    <p class="text">258</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 分隔商品資訊框框 -->
                    <!-- 空白排版用 -->
                    <div class="wrapList">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                  <!-- 這邊是地圖 -->
                    <div class="wrapList end_gray_border">
                        <div class="wrapList fullwidth">
                            <p class="STital">MAP</p>
                            <div class="map" >
                                <div id='map' ></div>
                            </div>
                        </div>
                    </div>
                    <!-- 這邊是地圖 -->


                </div>



            </div>






        </div>

         <!-- foot -->
          <div class="wrap" id="footBG" style="background-color: #e2d4b9 !important;">
        <div class="wrap " style="color: white">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
        <div style="color: white"> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
           </div>
             <!-- foot -->
    </div>
   


   
    <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA==" crossorigin=""></script>

    <script>
/*map*/
function map(){
            
            map = L.map('map').setView([25.0837472,121.5548008], 20);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	attribution: '<a href="https://www.openstreetmap.org/">OSM</a>',
	maxZoom: 18,
    
}).addTo(map);
L.marker([25.0837472,121.5548008],'典華飯店').addTo(map);
        }
    map();

        function c(){
            console.log("========================")
        console.log("text:" + $("#time").text);
        console.log("value:" + $("#time").val());
        console.log("========================")
        }
   

        /*日曆 */
        $(function () {
            $("#datepicker_show").datepicker({
                numberOfMonths: 2,
                showButtonPanel: true
            });
        });

        $(function () {
            $("#datepicker_onlick").datepicker();
        });
        /*日曆 */
        /*輪播圖 */
        function currentDiv(n) {
            showDivs(slideIndex = n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("demo");
            if (n > x.length) { slideIndex = 1 }
            if (n < 1) { slideIndex = x.length }
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
            }
            x[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " w3-opacity-off";
        }
        /*輪播圖 */
        /*檢查check Form*/
           function Check_Submit_Form() {
        	
        	cookieArray = document.cookie.split(";");
            console.log(cookieArray);
            if (cookieArray == "") {
                   alert("請先登入!");
                   window.location.replace("LogIn.jsp");
             }else{
            	 var txt = "";
                 if ( $("#time").val() == null){
                     txt += "請選擇時段\n";
                 }
             
                 if ( $("#datepicker_onlick").val() == ""){
                     txt += "請選擇日期\n";
                 }
                 if ( $("#table").val() == ""){
                     txt += "請選擇桌數\n";
                 }
                 if(txt ==""){
                     $("#VenueForm").submit();
                 }else{
                     alert(txt);
                 }
             }
        	   
        }

           /*塞圖進去輪播圖 */
          function putpicture(){
           for(let i =1 ; i<=img.length; i++){
               if(i==1){
                   $(function () {
               $("#bigpic").append("<img class='mySlides P_Bimg'src='"+img[i]+"' > ");
           });
               }
           $(function () {
               $("#bigpic").append("<img class='mySlides P_Bimg'src='"+img[i]+"' style='display:none'> ");
           });

           $(function () {
               $("#smallpic").append("<div class='w3-col s4 w3cpicture '> <img class='demo w3-opacity w3-hover-opacity-off height_width100' src='a.jpg' style=' cursor:pointer' onclick='currentDiv("+i+")'></div>");
           });
       }
   }
       /*塞圖進輪播圖 */

    </script>




</body>
</html>