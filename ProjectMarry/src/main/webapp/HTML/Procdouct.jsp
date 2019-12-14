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
    <link rel="stylesheet" href="http://resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="<c:url value='/CSS/combine.css'/>">

<title>Prodoct</title>
</head>
<body>

  <div class="wrap" id="bg">
        <!-- header -->
        <div class="wrap end_gray_border" id="head">
            <div class="wrap">
                <p class="tital">MARY ME | 場地選項</p>
            </div>
            <div>
                <p class="text">場地|配件｜樣式｜婚禮小物｜新秘｜攝影</p>
            </div>
            <hr>
        </div>

        <!-- article -->
        <div class="wrap end_gray_border" id="Product_list">
            <!-- top  -->
            <!-- <div class="wrap end_gray_border" id="chooseAll">
                <input type="checkbox"> <label for=""> 全部選取</label>
            </div> -->
            <!-- content  -->
            <div class="wrapRow" id="content">

                <!-- left  -->
                <div class="wrapStart" id="product_left">

                    <!-- 圖片輪播  style 跟javascript 有關 不能改 -->
                    <div class="wrap" id="pictureBG">
                        <div class="w3-content wrap One_width vh_height100" >
                             
                            <img class="mySlides P_Bimg" src="a.jpg" style=" display:none">
                            <img class="mySlides P_Bimg" src="b.jpg">
                            <img class="mySlides P_Bimg" src="c.png" style="display:none">
                            <img class="mySlides P_Bimg" src="c.png" style="display:none">

                            <!-- small picture -->
                            <div class="wrapRow" style="height: 15vh; width: 80%; padding: 2vh;">
                                <div class="w3-col s4 w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="a.jpg"
                                        style="  cursor:pointer" onclick="currentDiv(1)">
                                </div>

                                <div class="w3-col s4 w3cpicture ">
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="b.jpg"
                                        style="  cursor:pointer" onclick="currentDiv(2)">
                                </div>

                                <div class="w3-col s4 w3cpicture" >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100 " src="c.png"
                                        style="   cursor:pointer" onclick="currentDiv(3)">
                                </div>

                                <div class="w3-col s4  w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="c.png"
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

                    <div class="wrapList">
                        <p class="tital "> 場地名稱</p>
                    </div>
                    <div class="wrapList">
                        <p class="tital">ＮＴ＄10000</p>
                    </div>
                    <form action="" method="get" >
                    <div class="wrapList "> <label for="">場地樣式
                            <select class="product_sel" name="" id="">
                                <option value="Taipei" selected="" disabled="">請選擇樣式</option>
                                　<option value="Taoyuan">A</option>
                                　<option value="Taoyuan">B</option>
                                　<option value="Hsinchu">C</option>
                            </select>
                        </label>
                    </div>
                    <div class="wrapList "> <label for="">桌數</label></div>


                    <div class="wrapList"> <select class="product_sel" name="" id="" value="商品樣式">
                            <option value="Taipei" selected="" disabled="">桌數</option>
                            <option value="Taoyuan">1</option>
                            　<option value="Taoyuan">2</option>
                            　<option value="Hsinchu">3</option>
                        </select>
                    </div>
                    <div class="wrapList "> <label for="">選擇日期</label></div>
                    <div class="wrapRowBtw  LR_samll_padding">
                        <div >Date: <input type="text" id="datepicker_onlick"></div>
                        <div>Time: <input type="text" id="Time_onlick"></div>



                    </div>


                    <div class="wrapList ">
                        <br>
                       
                        <a href="" type="submit" > 
                            <div class="submitButton" > 加入購物車</div>
                        </a>
                  

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
                                <div class="wrapStart VH_R_padding10" >

                                    <p class="text">名稱</p>
                                    <p class="text">捷運</p>
                                    <p class="text">公車</p>
                                </div>
                                <div class="wrapStart">
                                    <p class="text">不鏽鋼</p>
                                    <p class="text">商品來源</p>
                                    <p class="text">庫存</p>
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
                                <div class="wrapStart VH_R_padding10" >

                                    <p class="text">場地地址</p>
                                    <p class="text">捷運</p>
                                    <p class="text">公車</p>
                                </div>
                                <div class="wrapStart">
                                    <p class="text">不鏽鋼</p>
                                    <p class="text">商品來源</p>
                                    <p class="text">庫存</p>
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
                        <div class="wrapList">
                            <p class="STital">MAP</p>
                            <div class="map"></div>
                        </div>
                    </div>
                    <!-- 這邊是地圖 -->


                </div>



            </div>






        </div>

         <!-- foot -->
          <div class="wrap" id="footBG">
        <div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
        <div> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
           </div>
    </div>
   


   
    <script>

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

    </script>




</body>
</html>