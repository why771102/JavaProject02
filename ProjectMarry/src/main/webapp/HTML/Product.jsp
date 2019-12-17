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

<jsp:useBean id="PB" scope="request" class="com.Bean.ProductBean"/>
 

    <title>Product</title>
</head>
<body>

  <div class="wrap" id="bg">
        <!-- header -->
        <div class="wrap end_gray_border" id="head">
            <div class="wrap">
                <p class="tital">MARY ME | 產品選項 </p>
            </div>
            <div>
                <p class="text">場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</p>
            </div>
            <hr>
        </div>

        <!-- article -->
        <div class="wrap end_gray_border" id="Product_list">
            <!-- top  -->

            <!-- content  -->
            <div class="wrapRow" id="content">

                <!-- left  -->
                <div class="wrapStart" id="product_left">

                    <!-- 圖片輪播  style 跟javascript 有關 不能改 -->
                    <div class="wrap" id="pictureBG">
                        <div class="w3-content wrap One_width vh_height100" >
                             
                            <img class="mySlides P_Bimg" src="img/5.jpg" style="display:none">
                            <img class="mySlides P_Bimg" src="img/6.jpg">
                            <img class="mySlides P_Bimg" src="img/7.jpg" style="display:none">
                            <img class="mySlides P_Bimg" src="img/8.jpg" style="display:none">

                            <!-- small picture -->
                            <div class="wrapRow" style="height: 15vh; width: 80%; padding: 2vh;">
                                <div class="w3-col s4 w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/5.jpg"
                                        style="cursor:pointer" onclick="currentDiv(1)">
                                </div>

                                <div class="w3-col s4 w3cpicture ">
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/6.jpg"
                                        style="cursor:pointer" onclick="currentDiv(2)">
                                </div>

                                <div class="w3-col s4 w3cpicture" >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100 " src="img/7.jpg"
                                        style="cursor:pointer" onclick="currentDiv(3)">
                                </div>

                                <div class="w3-col s4  w3cpicture " >
                                    <img class="demo w3-opacity w3-hover-opacity-off height_width100" src="img/8.jpg"
                                        style="cursor:pointer" onclick="currentDiv(4)">
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

                        <p class="STital">產品介紹</p>
                        <div class="wrapRow">
                            <div class="wrapStart VH_R_padding15">

                                <p class="text">產品材質</p>
                                <p class="text">產品來源</p>
                                <p class="text">庫存</p>
                            </div>
                            <div class="wrapStart">
                                <p class="text">不鏽鋼</p>
                                <p class="text">產品來源</p>
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



                </div>

                <!-- right  -->
                <div class="wrapStart " id="product_right">
                    <form action="PutItemInShoppingCartServlet" method="post" class="fullwidth" id="ProductForm">
                    <div class="wrapList">
                        <p class="tital ">${PB.productName }</p>
                    </div>
                    <div class="wrapList">
                        <p class="tital" >NT$ ${PB.unitPrice }</p>
                    </div>
                            <input type="hidden" name="PSupplierID" value="${PB.psupplierID }">
                            <input type="hidden" name="productName" value="${PB.productName }">
                            <input type="hidden" name="Price" value="${PB.unitPrice }">
                            <input type="hidden" name="ProductID" value="${PB.productID }">
                            <input type="hidden" name="Discount" value="${PB.discount }">
                  <!-- 之後要加product 欄位 type nvarchar  -->
                    <div class="wrapList "> <label for="">產品樣式
                            <select class="product_sel" name="Type" id="type" value="">
                                <option value="" selected="" disabled="">請選擇樣式</option>
                                　<option value="A">巧克力</option>
                                　<option value="B">草莓</option>
                                　<option value="C">牛奶</option>
                            </select>
                        </label>
                    </div>
                    <div class="wrapList "> <label for="">數量</label></div>


                    <div class="wrapList"> <select class="product_sel" name="Quantity" id="quantity" value="">
                            <option value="" selected="" disabled="">數量</option>
                            <option value="1">1</option>
                            　<option value="2">2</option>
                            　<option value="3">3</option>
                        </select>
                    </div>



                    <div class="wrapList ">
                        <br>
                       
                        <div class="submitButton" onclick="Check_Submit_Form()">加入購物車</div>
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
                            <p class="STital">關於產品</p>
                            <div class="wrapRow">
<!--                                 <div class="wrapStart VH_R_padding10" > -->

<!--                                     <p class="text">名稱</p> -->
<!--                                     <p class="text">捷運</p> -->
<!--                                     <p class="text">公車</p> -->
<!--                                 </div> -->
                                <div class="wrapStart">
                                    <p class="text">${ PB.depiction }</p>
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
                            <p class="STital">關於設計館</p>
                            <div class="wrapRow">

                                <div class="wrapStart">
                                    <p class="text">OOXX設計館</p>
                                    <p class="text">來自國家</p>
                                    <p class="text">評價</p>
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
<!--                     <div class="wrapList end_gray_border"> -->
<!--                         <div class="wrapList"> -->
<!--                             <p class="STital">MAP</p> -->
<!--                             <div class="map"></div> -->
<!--                         </div> -->
<!--                     </div> -->
                    <!-- 這邊是地圖 -->


                </div>



            </div>






        </div>

         <!-- foot -->
          <div class="wrap" id="footBG">
        <div class="wrap">MARY ME |錢不會消失 , 只是變成你喜歡的樣子</div>
        <div> 場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</div>
           </div>
    </div>
   


   
    <script>
		
    	
       
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
        /*確認form */
        function Check_Submit_Form() {
            cookieArray = document.cookie.split(";");
            console.log(cookieArray);
            if (cookieArray == "") {
                alert("請先登入!");
                window.location.replace("LogIn.jsp");
            }else{
            	   var txt = "";
                   if ( $("#type").val() == null){
                       txt += "請選擇樣式\n";
                   }
               
                   if ( $("#quantity").val() == null){
                       txt += "請選擇數量\n";
                   }
                 
                   if(txt ==""){
                       $("#ProductForm").submit();
                   }else{
                       alert(txt);
                   }
            }


         
               
        }



    </script>




</body>
</html>