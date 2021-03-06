<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
 
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
    <link rel="stylesheet" href="<c:url value='/CSS/combine.css'/>">
<!--     <link rel="stylesheet" href="combine.css"> -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 
    <title>Document</title>
    <style>
        a {
            color: #6e5f40;
            font-size: 2vh;
 
        }
    </style>
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
        <div class="wrap" id="cartShopList">
            <!-- top  -->
 
            <!-- content  -->
            <div class="wrapRow" id="content">
 
                <!-- left  -->
                <div class="wrapStart" id="detail_left">
                    <div class="menu">
                        <h2>MARY ME</h2>
                        <a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">
                            <p class="text">購買訂單</p>
                        </a>
                        <p class="text">退款申請</p>
                        <p class="text">會員專區</p>
                        <p class="text">帳號設定</p>
                        <div class="setting">
                            <ul>
                                <li>基本設定</li>
                                <li>關於我</li>
                                <li>常用地址簿</li>
                                <li>通知設定</li>
                            </ul>
                        </div>
                    </div>
 
                    <!-- 分隔商品資訊框框 -->
                </div>
                <!-- right  -->
                <div class="wrapStart" id="detail_right">
 
                    <div class="wrapList"></div>
                    <div class="wrapList">
                        <p class="tital">購買訂單</p>
 
                        <div class="tablist">
                            <ul>
                                <li><a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">尚未付款</a></li>
                                <li><a href="<c:url value='/HTML/OrderDetailProcessing.jsp'/>">處理中</a></li>
                                <li><a href="<c:url value='/HTML/OrderDetailCompleted.jsp'/>" class="active">
                                        <c:set var="status" value="已完成" />已完成</a></li>
                                <li><a href="<c:url value='/HTML/OrderDetailCancelled.jsp'/>">已取消</a></li>
                            </ul>
                        </div>
 
                        <!-- <div class="empty-list">
                           <div class="image">
                               <img src="img/order_v2.png" alt="">
                           </div>
                           <div class="text"></div>
                        </div> -->
 
                        <!-- wrap box-->
                        <div class="wrapList order_list" id="putDatabox">
 
                            <!-- from DB need to create div -->
                            <!-- <div class="wrapList order_list" id="Databox">
                                
                                <div class="wrapRowStart order_title" style="background-color:#f8f4f2;">
 
                                    <div id="date">
                                        <c:out value="${OrderDetails.OrderDate}" default="2018-05-28" />2018-05-28</div>
                                    <div id="shop">
                                        <a href="">
                                            <c:out value="${VenueVendor.Vendor}" default="cat soup" />cat soup</a>
                                    </div>
                                </div>
                                
                                <div class="order_details" style="padding:0vh 1vh ;box-sizing: border-box;">
                                    <a href="1202購物清單.html">
                                        <div class="wrapRow" style=" padding: 1vh 0vh;">
                                            <p class="text">狀態</p>
                                            <div id="spacing"></div>
                                            <div id="status">
                                                <c:out value="${Order.PaymentStatus}" default="已完成" />已完成</div>
                                        </div>
                                        <div class="wrapRow" style=" padding: 0.5vh 0vh;">
                                            <p class="text">寄往</p>
                                            <div id="spacing"></div>
                                            <div id="location">台灣</div>
                                        </div>
                                        <div class="wrapRow" style=" padding: 0.5vh 0vh;">
                                            <p class="text">訂單編號</p>
                                            <div id="spacing"></div>
                                            <div id="orderID">
                                                <c:out value="${Order.OrderID}" default="2018052500000" />2018052500000"
                                            </div>
                                        </div>
                                        <div class="wrapRow" style=" padding: 0.5vh 0vh;">
                                            <p class="text">總計</p>
                                            <div id="spacing"></div>
                                            <div id="orderTotal">
                                                <c:set var="subtotal" value="${OrderDetails.Subtotal}" />NT$900</div>
                                        </div>
                                        <div class="wrapRow" style=" padding: 0.5vh 0vh;">
                                            <p class="text">購買項目</p>
                                            <div id="spacing"></div>
                                            <div id="img">
                                                <c:set var="subtotal" value="${OrderDetails.Subtotal}" />貓貓ｂ衣服</div>
                                            <img src="" alt="">
                                        </div>
                                        <div class="wrapRow" style=" padding: 0.5vh 0vh;">
                                            <p class="text">購買備註</p>
                                            <div id="spacing"></div>
                                            <div id="orderTotal">
                                                <c:set var="subtotal" value="${OrderDetails.Subtotal}" />想要早一點拿到ｂ</div>
                                        </div>
                                
                             	   </a>
                         	   </div>
                     	    </div> -->
                     	 <!-- from DB need to create div -->
                     	
                        </div>
                        <!-- wrap box-->
                </div>
            </div>
 
 
        </div>
 
 
    </div>
 
    </div>
    <!-- foot -->
    <div class="wrap" id="footBG" style="background-color: #e2d4b9 !important ;hieght:110px !important;">
        <div class="wrap " style="color: white">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
        <div style="color: white"> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
    </div>
    <!-- foot -->
 
 
    </div>
 
    <script>
 	var date = "a";
    // 一個while 迴圈  如果裡面還有東西 就跑  // 用for 迴圈取出有幾筆
 
 
 
 
        $( "#putDatabox" ).append( "<div class='wrapList order_list' id='Databox'>"+
                                "<div class='wrapRowStart order_title' style='background-color:#f8f4f2;'>"
 
                                    +"<div id='date'><c:out value='${OrderDetails.OrderDate}' default='2018-05-28' />2018-05-28</div>"
                                    +"<div id='shop'><a href=''><c:out value='${VenueVendor.Vendor}' default='cat soup' />cat soup</a></div>"
                                +"</div>"
                            
                                +"<!-- inner -->"
                                +"<div class='order_details' style='padding:0vh 1vh ;box-sizing: border-box;'>"
                                    +"  <a href='1202購物清單.html'>"
                                        +"  <div class='wrapRow' style=' padding: 1vh 0vh;'>"
                                         	  +"   <p class='text'>狀態</p><div id='spacing'></div><div id='status' style='border-radius: 1vh; padding: 0.5vh;'><c:out value='${Order.PaymentStatus}' default='已完成' />已完成</div>"
                                        +"  </div>"
                                 	   +"  <div class='wrapRow' style=' padding: 0.5vh 0vh;'>"
                                         	  +"   <p class='text'>寄往</p><div id='spacing'></div><div id='location'>台灣</div>"
                                        +"</div>"
                                        +"<div class='wrapRow' style=' padding: 0.5vh 0vh;'>"
                                         	  +"<p class='text'>訂單編號</p><div id='spacing'></div><div id='orderID'><c:out value='${Order.OrderID}' default='2018052500000' />2018052500000'</div>"
                                        +"</div>"
                                        +"<div class='wrapRow' style=' padding: 0.5vh 0vh;'>"
                                         	  +"<p class='text'>總計</p><div id='spacing'></div><div id='orderTotal'><c:set var='subtotal' value='${OrderDetails.Subtotal}' />NT$900</div>"
                                        +"</div>"
                                        +"<div class='wrapRow' style=' padding: 0.5vh 0vh;'>"
                                                +"<p class='text'>購買項目</p><div id='spacing'></div><div id='img'><c:set var='subtotal' value='${OrderDetails.Subtotal}' />貓貓ｂ衣服</div><img src='' alt=''>"
                                        +"</div>"
                                        +"<div class='wrapRow' style=' padding: 0.5vh 0vh;'>"
                                                +"<p class='text'>購買備註</p><div id='spacing'></div><div id='orderTotal'>c:set var='subtotal' value='${OrderDetails.Subtotal}' />想要早一點拿到ｂ</div>"
                                        +"</div>"
                                    +"</a>"
                                +" </div>"
                            +" </div>"
            +"  <!-- from DB need to create div -->' ");
 
 
 
 
 
 
 
 
 
 
 
    </script>
 
</body>
 
</html>
