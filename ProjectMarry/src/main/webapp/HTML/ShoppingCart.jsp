<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="CSS/combine2.css">
<title>購物車</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
</head>
<body>
	<form method="POST">
		<div class="wrap" id="bg">
			<!-- header -->
			  <!-- header -->
        <div class="wrap end_gray_border" id="head">
           <iframe class="fullwidth" src="HTML/Header.jsp" frameborder="0"></iframe>
        </div>
<br>
<div><br></div>
			<!-- article -->
			<div class="wrap" id="cartShopList">
				<!-- top  -->
				<div class="wrap spacing_b" id="chooseAll">
<!-- 					<input type="checkbox" id="CheckAll" value="checkall"> <label -->
<!-- 						for="CheckAll"> -->
<!-- 						<p class="text3">全部選取</p> -->
					</label>
				</div>
				<!-- content  -->
				<div class="wrapRowStart " id="startHere">

					<!-- left  -->
					<!--A Product-->
					<%--                 <c:forEach items="${productArray}" var="products"> --%>
					<div class="wrapStart" id="sc_left" style="width: 100%;"></div>

					<!-- right  -->
					<div class="wrapStart" id="sc_right">
						<!-- 						<div class="wrapStart"> -->
						<!-- 							<div class="sc_fix CartTrans"> -->
						<!-- 								<div class="cartFrame1 sc_frame CartTrans "> -->
						<!-- 									<div class="wrapList cartFrame"> -->
						<!-- 										<p class="text1">訂單摘要</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="cartFrame2"> -->
						<!-- 										<div class="wrapRowStart sc_padding1"> -->
						<!-- 											<p class="text1">商品總計</p> -->
						<!-- 											<div class="sc_right">NT$ 10,000</div> -->
						<!-- 										</div> -->
						<!-- 										<div class="wrapRowStart sc_padding1"> -->
						<!-- 											<p class="text1">運費總計</p> -->
						<!-- 											<div class="sc_right">NT$ 0</div> -->
						<!-- 										</div> -->
						<!-- 										<div class="wrapRowStart sc_padding1"> -->
						<!-- 											<p class="text1">其他折抵</p> -->
						<!-- 											<div class="sc_right">NT$ -500</div> -->
						<!-- 										</div> -->
						<!-- 										<div class="wrapRowStart sc_padding1"> -->
						<!-- 											<p class="text2">預留的隱藏欄位</p> -->
						<!-- 										</div> -->
						<!-- 										<br> -->
						<!-- 										<div class="wrapRowStart sc_padding"> -->
						<!-- 											<p class="text1" id="pColor">使用優惠劵、紅利或禮物卡</p> -->
						<!-- 										</div> -->
						<!-- 										<hr> -->
						<!-- 										<div class="wrapRowStart sc_padding"> -->
						<!-- 											<p class="text">結帳總金額</p> -->
						<!-- 											<div class="sc_right">NT$ 9,500</div> -->
						<!-- 										</div> -->
						<!-- 										<div class="wrapList"> -->
						<!-- 											                                        <a href="Checkout.jsp"> -->
						<!-- 											<input type="submit"> -->
						<!-- 											<p id="sc_center">前往結帳</p> -->

						<!-- 											                                        </a> -->
						<!-- 										</div> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</div> -->
					</div>
				</div>
			</div>
			<!-- foot -->
			<div class="wrap" id="footBG">
				<div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
				<div>場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
			</div>


		</div>
	</form>

    <script type="text/javascript">

//從後端傳來的JSONArray
var p = ${productArray};
var v = ${venueArray};

//product JSON
const pObjStr = JSON.stringify(p);
const pObj = (JSON.parse(pObjStr));
//Venue JSON
const vObjStr = JSON.stringify(v);
const vObj = (JSON.parse(vObjStr));
// console.log(pObj[0].ProductID);
// console.log(vObj);
console.log(pObj.length);
console.log(pObj);
//
var sTotal= 0; 
var pTotal= 0;
var vpsub = 0;

$(document).ready(function(){
    //顯示場地
	let vpsubtotal = 0;
	let subtotal = 0;
    var venues = [];
    if(vObj === undefined ){
        console.log("no v");
    }else{
        for(var i = 0; i<vObj.length; i++){
        	sTotal = sTotal + (vObj[i].Price);
        	console.log("sTotal: " + sTotal);
            console.log(i);
//             console.log(${venueArray});
          //計算場地場次      	
        	let venueTime = null;
        	if(vObj[i].StartTime == 0){
        		//0: 午場
        		venueTime = "中午場";
        	}else{
        		//1: 晚場
        		venueTime = "晚上場";
        	}
			var venueDate = vObj[i].Date;
			//顯示場地價格 加逗號要轉為字串
        	var vPrice = new Number(vObj[i].Price).toLocaleString("en-AU");
			//動態新增場地div
            $('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='vendorName' name='Checkbox'> <label for='vendorName'><p class='text3'>"+vObj[i].Vendor+"</p></label><input type='hidden' value='"+vObj[i].VendorID+"' name='vendorID'><div class='remove margin1'><p class='' id='remove_vendor' onclick='remove_vendor()'>X</p></div></div><div class=' wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='img/venue1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='' class='noChangeLine'> <p class='text3'>"+vObj[i].Hall+"</p> <input type='hidden' value='"+vObj[i].ProductID+"' name='vId'> </a><p class='text3 noChangeLine'>"+ vObj[i].Location +"</p><p class='text3 noChangeLine'>"+ venueDate +"</p><p class='text3 noChangeLine'>"+ venueTime +"</p></div><div class='width05'></div><div class='width10 sc_select'><input type='number' max='100' style='width:40px' value='"+vObj[i].TableCount+"' id='tableCount"+i+"' onchange='MaxLimit(this)'></div><div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+ vPrice +"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->       <input type='hidden' value='"+vObj[i].StartTime+"' name='startTime'>      <p id='remove_venue' onclick='remove_venue()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1'><div class='spacing_top adjPadding' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");
//             console.log("------");
//             console.log($(tc).val());
//             venues.push(venue);
//             console.log(venues[i] + "===="+ i);
            
            $('#sc_left').append("<input type='hidden' value='venues' name='venues'>");
        }
        
    }
    console.log("----");
    console.log(venues);
    //Product
    
    if(pObj === undefined){
        console.log("no p");
            }else{
                for(var i = 0; i<pObj.length; i++){
                    console.log("p的i ==== " + i);
                    pTotal = pTotal + (pObj[i].UnitPrice) * (pObj[i].Quantity) * (1-(pObj[i].Discount));
                    console.log("Ptotal: " + pTotal);
                    var pPrice = new Number(pObj[i].UnitPrice).toLocaleString("en-AU");
//                     $('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='productName' name='Checkbox'> <label for='productName'><p class='text3'>"+pObj[i].PSupplierName+"</p></label><input type='hidden' value='"+pObj[i].pSupplierId+"' name='supplierID'><div class='remove margin1' id='remove_shop'><p class='' onclick='remove_shop()'>X</p></div></div><div class=' wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='HTML/img/Weddinggift1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='../ProjectMarry/ProductDetail?ProductID=" + pObj[i]["ProductID"] +  "' class='noChangeLine'> <p class='text3'>"+pObj[i].ProductName+"</p> <input type='hidden' value='"+pObj[i].ProductID+"' name='pId'> </a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock"+i+"' onclick='selectClick(this)'><option hidden value='"+pObj[i].Quantity+"'>"+pObj[i].Quantity+"</option></select></div>         <div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+ pPrice +"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->             <p id='remove_product' onclick='remove_product()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1'>     <div class='spacing_top adjPadding' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");    
                    
                    //如果第一次購買的店家,跑以下div顯示
                    var p1;
                    	if( (i == 0) || (pObj[(i)].pSupplierId != p1)){
                    		console.log("first add");
                    		 p1 = pObj[i].pSupplierId;
//                     		 console.log(typeof i);
//                     		 console.log(typeof p1);
                     		 console.log("p1: " + p1);
                    		$('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='productName' name='Checkbox'> <label for='productName'><p class='text3'>"+pObj[i].PSupplierName+"</p></label><input type='hidden' value='"+pObj[i].pSupplierId+"' name='supplierID'><div class='remove margin1' id='remove_shop'><p class='' onclick='remove_shop()'>X</p></div></div><div class='wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='HTML/img/Weddinggift1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='../ProjectMarry/ProductDetail?ProductID=" + pObj[i]["ProductID"] +  "' class='noChangeLine'> <p class='text3'>"+pObj[i].ProductName+"</p> <input type='hidden' value='"+pObj[i].ProductID+"' name='pId'> </a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock"+i+"' onclick='selectClick(this)'><option hidden value='"+pObj[i].Quantity+"'>"+pObj[i].Quantity+"</option></select></div>         <div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+ pPrice +"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->             <p id='remove_product' onclick='remove_product()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1' id='"+p1+"'>     <div class='spacing_top adjPadding topLine' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");    
                       	}
                    //若選購同商店第二筆以上產品
                    	else if( (i != 0) && (pObj[(i)].pSupplierId == p1) ){
                    		console.log("p1: " + p1);
                    		console.log("more add");
                    		$('#'+p1).prepend("<div class=' wrapRowStart' id='SC_products'><!-- 以下為同一家商品的div --><div class='width25'><div class='Pimg2 fullwidth'><input type='hidden' value='"+pObj[i].pSupplierId+"' name='supplierID'><img src='HTML/img/Weddinggift1.jpg' class='fullwidth' alt='venue1'> </div></div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='../ProjectMarry/ProductDetail?ProductID=" + pObj[i]["ProductID"] +  "'class='noChangeLine'><p class='text3'>"+pObj[i].ProductName+"</p> <input type='hidden' value='"+pObj[i].ProductID+"'name='pId'></a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock"+i+"' onclick='selectClick(this)'><option hidden value='"+pObj[i].Quantity+"'>"+pObj[i].Quantity+"</option></select></div><div class='width05'></div><div class='width30'><p class='text3'>NT$ "+ pPrice +"</p></div><div class='width02'></div><div class='width05 margin2'><!--<a href='' id='delete'> --><p id='remove_product' onclick='remove_product()'>X</p><!-- </a> --></div></div></div>");
//                     		$('#'+p1).prepend("<div class=' wrapRowStart topLine' id='SC_products'><!-- 以下為同一家商品的div --><div class='width25'><div class='Pimg2 fullwidth'><input type='hidden' value='"+pObj[i].pSupplierId+"' name='supplierID'><img src='HTML/img/Weddinggift1.jpg' class='fullwidth' alt='venue1'> </div></div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='../ProjectMarry/ProductDetail?ProductID=" + pObj[i]["ProductID"] +  "'class='noChangeLine'><p class='text3'>"+pObj[i].ProductName+"</p> <input type='hidden' value='"+pObj[i].ProductID+"'name='pId'></a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock"+i+"' onclick='selectClick(this)'><option hidden value='"+pObj[i].Quantity+"'>"+pObj[i].Quantity+"</option></select></div><div class='width05'></div><div class='width30'><p class='text3'>NT$ "+ pPrice +"</p></div><div class='width02'></div><div class='width05 margin2'><!--<a href='' id='delete'> --><p id='remove_product' onclick='remove_product()'>X</p><!-- </a> --></div></div></div>");
                    	}
                    
                    //動態新增下拉式選單商品數(比對庫存)
                    var pq = "#stock"+i;
                    var quantity = pObj[i].stockQty;
                    for (var r = 1; r <= quantity; r++) {
                        var elm2 = document.createElement("option");
                        var newCon2 = document.createTextNode(r);
                        elm2.append(newCon2);
                        $(pq).append(elm2);
                    }
                }    
            }
	vpsub = pTotal + sTotal;
	vpsubtotal = new Number(pTotal + sTotal).toLocaleString("en-AU");
// 	var tester = parseInt(vpsubtotal.split(0,"3"));
// 	console.log(tester);
	var vps = pTotal + sTotal;
	subtotal = new Number(vps-50).toLocaleString("en-AU");
	console.log(subtotal);
	
	console.log("vObj: " + vObj);
	console.log("pObj: " + pObj);
	//訂單金額那個div
	//若是購物車有物品就顯示 else不顯示
	if(vObj != 0 || pObj != 0){
            $('#sc_right').append("<div class='wrapStart'><div class='sc_fix CartTrans'><div class='cartFrame1 sc_frame CartTrans'><div class='wrapList cartFrame'><p class='text1'>訂單摘要</p></div><div class='cartFrame2'><div class='wrapRowStart sc_padding1'><p class='text1'>商品總計</p><div class='sc_right' id='vpsubtotal'>NT$" + vpsubtotal + "</div></div><div class='wrapRowStart sc_padding1'><p class='text1'>運費總計</p><div class='sc_right'>NT$ 0</div></div><div class='wrapRowStart sc_padding1'><p class='text1'>其他折抵</p><div class='sc_right'>NT$ -50</div></div><div class='wrapRowStart sc_padding1'><p class='text2'>預留的隱藏欄位</p></div><br><div class='wrapRowStart sc_padding'><p class='text1' id='pColor'>使用優惠劵、紅利或禮物卡</p></div><hr><div class='wrapRowStart sc_padding'><p class='text'>結帳總金額</p><div class='sc_right' id='subtotal'>NT$ " + subtotal + "</div></div><div class='wrapList'><!-- <a href='Checkout.jsp'> --><div class='submitButton' onclick='checkqty()'><p id='sc_center'>前往結帳</p><!-- </a> --></div></div></div></div></div>");    
}else if(vObj === 0 && pObj === 0){
	$('#sc_left').append("<p class='STital'> 您的購物車內沒有商品!! 歡迎選購😄</p><br><div><a href='HTML/index.html'><p class='STital'>👉回首頁逛逛</p></a></div><br>");
	console.log("no sc");
}
	
})
	    //以下四個function由UpdateShoppingCartServlet呼叫 刪除購物車產品
        //從DB刪除產品店家
        function remove_shop() {
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELSUPPLIER'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
		//從DB刪除產品
        function remove_product() {
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELPRODUCT'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
        //從DB刪除場地廠商
        function remove_vendor(){
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELVENDOR'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
        //從DB刪除場地
        function remove_venue(){
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELVENUE'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
		//按前往結帳後會先更新顧客在購物車更新的商品數量送至CheckOutShoppingCartServlet
        function checkqty(){
                    var venues = [];
                    for(var i = 0; i<vObj.length; i++){
                        var tc = "#tableCount"+i;
                        venues[i] = [vObj[i].ProductID, $(tc).val()];
                    }
                    var products = [];
                    for(var i = 0; i<pObj.length; i++){
                        var pq = "#stock"+i;
                        products[i] = [pObj[i].ProductID, $(pq).val()];
                    }
                    
                    var product = JSON.stringify(products);
                    var venue = JSON.stringify(venues);
                    
                    $('#sc_left').append("<input type='hidden' value='"+venue+"' name='venue'>");
                    $('#sc_left').append("<input type='hidden' value='"+product+"' name='product'>");
                    console.log(venue);
                    console.log(product);
                    document.forms[0].action="<c:url value='CheckOutShoppingCartServlet'/>";
                    document.forms[0].method = "POST";
                    document.forms[0].submit();
                }
        
      //動態更改購物車的總金額
    	function newQty(stockID, index){
            //新修改的數量
            let newP = [];
            var newPTotal = 0;
            //跑迴圈計算更改新數量後的金額
            //舊數量的金額計算後
            for (let a = 0; a < pObj.length; a++) {
            	let ID = stockID+a;
            	//get new quantity given by the user
            	var newQ = $(ID).val();
    			console.log("newQ: " + newQ);        	
            	
            	//新數量
            	if(a == index){
//             		console.log("index in if: " + index);
            		newP[a] = (pObj[a].UnitPrice) * (newQ) * (1 - (pObj[a].Discount));
                    var indexA = newP[a];
//                     console.log("newPTotal + newP[a] = " + newPTotal + "+" +  newP[a])
                    
            	}else {
//             		console.log("index in else: " + index);
            		newP[a] = (pObj[a].UnitPrice) * (newQ) * (1 - (pObj[a].Discount));
                    let indexB = newP[a];
//                     console.log("newPTotal + newP[a] = " + newPTotal + "+" +  newP[a]);
            	}
            	newPTotal = newPTotal + newP[a];
//                 console.log("newP[a]: " + newP[a]);
//                 console.log("newPTotal: " + newPTotal);
                //舊數量
            } 
//             console.log(newPTotal);
            return newPTotal;
    	}
    	
    	function selectClick(myObj) {
    			//get id of div e.g.#stock0
    	        var stID = "#" + myObj.id;
    			//get #stock
    	        var stockID = stID.substring(0, stID.length-1);
//     	        console.log("stockID: " + stockID);
    	        //get number in id e.g. #stock0 ==> 0
    	        //which is also the index for pObj[]
    	        var index = stID.substring(stID.length - 1, stID.length);
//     	        console.log("index: " + index);
                newPTotal = newQty(stockID, index);
//     			console.log("newPTotal" + newPTotal);
                //加上逗號須改為字串
                let newVPsubtotal = new Number(newPTotal).toLocaleString("en-AU");
//                 console.log("newVPsubtotal" + newVPsubtotal);
              	//加上逗號須改為字串
                let subtotal = new Number(newPTotal - 50).toLocaleString("en-AU");
                $('#vpsubtotal').text("NT$" + newVPsubtotal)
                $('#subtotal').text("NT$" + subtotal);
            }

		
		//更改桌數的onchange function
		function MaxLimit(obj){
			//動態抓更改的table ID
			var tableID = "#"+obj.id;
			//抓她的數字 e.g #tableCount0 ==> 0
			var tablelength = tableID.substring(tableID.length-1, tableID.length);
// 			console.log(tableID);
// 			console.log($(tableID).val());
			//桌數不能超過100
			if($(tableID).val() > 100){
				alert("桌數不能超過100");
				$(tableID).val(vObj[tablelength].TableCount);
			}
			
		}
    </script>
</body>
</html>