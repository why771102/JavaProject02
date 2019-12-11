<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:url value='/CSS/combine.css'/>">

<title>orderList</title>
</head>
<body>

    <div class="wrap" id="bg">
        <!-- header -->
        <div class="wrap end_gray_border" id="head">
            <div></div>
            <div class="wrap">
                <p class="tital">MARY ME | 場地選項</p>
            </div>
            <div>
                <p class="text">場地|配件｜樣式｜婚禮小物｜新秘｜攝影</p>
            </div>
        </div>
        <!-- article -->
        <div class="wrap" id="cartShopList">
            <!-- top  -->
            <div class="wrap" id="chooseAll">
<!--                 <input type="checkbox"> <label for=""> 全部選取</label> -->
            </div>
            <!-- content  -->
            <div class="wrapRow" id="content">
                <!-- left  -->
                <div class="wrapStart" id="list_left">
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
                                <li> 基本設定</li>
                                <li> 關於我</li>
                                <li> 常用地址簿</li>
                                <li> 通知設定</li>
                            </ul>
                        </div>
                    </div>

                    <!-- 分隔商品資訊框框 -->
                </div>

                <!-- middle  -->
                <div class="wrapStart" id="list_middle">

                    <!-- 分隔商品資訊框框 -->
                    <div class="wrapList">
                        <div class="wrapRowStart small_padding">
                            <div><a href="<c:url value='/HTML/OrderDetailCompleted.jsp'/>">已完成</a></div>
                            <div>> 2018052500000</div>
                               

                        </div>
                       
                        <div class="wrapList small_padding">
                            <div class="wrapRowStart wrapRowBtw " >
                                <p class="text width50" ><u >cat soup</u></p>
                             <div id="order_date ">2019-12-02 </div> 
                               
                            </div>

                            <div class="small_padding" id="status">已完成</div>
                            <div class="ship_status wrapRowStart small_padding">
                                <p class="text">運送狀態</p>
                            </div>

                                


                           

                        </div>
                        <div><br></div>
                        <div class="shop_frame wrapList">
                            <div class="shop_details wrapList VH_padding3" >
                                <div class="end_gray_border wrapRowStart" > <p class="text">訂單內容</p></div>
                               
                              <div class=" wrapList end_gray_border  ">
                                <div class="shop_products wrapRowBtw">
                                    <div class="wrapRowStart width60" >
                                            <div id="prodimage"><img src="img/order_v2.png" alt=""></div>
                                            <div id="prod_des">polka dot cat crop t-shirt: navy</div>
                                    </div>
                                    <div  class="wrapRowStart shopping_detail">
                                            <div  class=" VH_RL_padding4 "id="prod_quantity "> X 1</div>
                                            <div id="prod_price">NT$369</div>
                                    </div>

                                 
                                </div>
                                <div class="shop_products wrapRowBtw">
                                        <div class="wrapRowStart width60" >
                                    <div id="prodimage"><img src="img/order_v2.png" alt=""></div>
                                    <div id="prod_des">polka dot cat crop t-shirt: natural</div>
                                        </div>
                                        <div  class="wrapRowStart shopping_detail">
                                    <div  class=" VH_RL_padding4 "id="prod_quantity " > X 1</div>
                                    <div id="prod_price">NT$369</div>
                                    </div>
                                </div>
                                <div class="shop_products wrapRowBtw">
                                        <div class="wrapRowStart width60" >
                                    <div id="prodimage"><img src="img/order_v2.png" alt=""></div>
                                    <div id="prod_des">polka dot cat crop t-shirt: pink</div>
                                </div>
                                    <div  class="wrapRowStart shopping_detail">
                                    <div  class=" VH_RL_padding4 "id="prod_quantity " > X 1</div>
                                    <div id="prod_price">NT$369</div>
                                </div>
                                </div>
                                <div class="shop_products wrapRowBtw">
                                        <div class="wrapRowStart width60" >
                                    <div id="prodimage"><img src="img/order_v2.png" alt=""></div>
                                    <div id="prod_des">polka dot cat crop t-shirt: white</div>
                                </div>
                                    <div  class="wrapRowStart shopping_detail">
                                    <div  class=" VH_RL_padding4 "id="prod_quantity " > X 1</div>
                                    <div id="prod_price">NT$369</div>
                                </div>
                                </div>
                              </div>
                            </div>
                        </div>
                    </div>
                    <!-- 分隔商品資訊框框 -->


                </div>
                <!-- right  -->
                <div class="wrapStart" id="list_right">

                    <div class="wrapList">
                        <div class="chat_history wrapRowStart">
                            <p class="text">查看對話紀錄</p>
                        </div>
                        <div class="contact wrapRowStart">
                            <p class="text">聯絡方式</p>
                        </div>
                        <div class="refund wrapRowStart">
                            <p class="text">申請退款</p>
                        </div>
                        <div class="order_history wrapList VH_padding1p5" >
                            <p class="text">訂單歷史</p>
                            <ul>
                                <li>給予評價</li>
                                <li>訂單完成</li>
                                <li>收到商品</li>
                                <li>已出貨</li>
                            </ul>
                            <hr>

                        </div>
                    </div>



                </div>


            </div>

        </div>
        <!-- foot -->
        <div class="wrap" id="footBG">
            <div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
            <div> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
        </div>


    </div>




</body>
</html>