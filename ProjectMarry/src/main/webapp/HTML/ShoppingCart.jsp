<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%=request.getAttribute("venueArray")%> --%>
<%="-------------------"%>
<%=request.getAttribute("productArray")%>
<%-- <%="-------------------"%> --%>
<%-- <%=request.getAttribute("a")%> --%>

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
			<div class="wrap" id="head">
				<div class="wrap">
					<p class="tital">MARY ME | 場地選項</p>
				</div>
				<div>
					<p class="text" style="display: none;">場地|配件｜樣式｜婚禮小物｜新秘｜攝影</p>
				</div>
			</div>
			<!-- article -->
			<div class="wrap" id="cartShopList">
				<!-- top  -->
				<div class="wrap spacing_b" id="chooseAll">
					<input type="checkbox" id="CheckAll" value="checkall"> <label
						for="CheckAll">
						<p class="text3">全部選取</p>
					</label>
				</div>
				<!-- content  -->
				<div class="wrapRowStart " id="">

					<!-- left  -->
					<!--A Product-->
					<%--                 <c:forEach items="${productArray}" var="products"> --%>
					<div class="wrapStart " id="sc_left" style="width: 100%;"></div>

					<!-- right  -->
					<div class="wrapStart" id="sc_right">
						<div class="wrapStart">
							<div class="sc_fix CartTrans">
								<div class="cartFrame1 sc_frame CartTrans ">
									<div class="wrapList cartFrame">
										<p class="text1">訂單摘要</p>
									</div>
									<div class="cartFrame2">
										<div class="wrapRowStart sc_padding1">
											<p class="text1">商品總計</p>
											<div class="sc_right">NT$ 10,000</div>
										</div>
										<div class="wrapRowStart sc_padding1">
											<p class="text1">運費總計</p>
											<div class="sc_right">NT$ 0</div>
										</div>
										<div class="wrapRowStart sc_padding1">
											<p class="text1">其他折抵</p>
											<div class="sc_right">NT$ -500</div>
										</div>
										<div class="wrapRowStart sc_padding1">
											<p class="text2">預留的隱藏欄位</p>
										</div>
										<br>
										<div class="wrapRowStart sc_padding">
											<p class="text1" id="pColor">使用優惠劵、紅利或禮物卡</p>
										</div>
										<hr>
										<div class="wrapRowStart sc_padding">
											<p class="text">結帳總金額</p>
											<div class="sc_right">NT$ 9,500</div>
										</div>
										<div class="wrapList">
											<!--                                         <a href="Checkout.jsp"> -->
											<input type="submit">
											<p id="sc_center">前往結帳</p>

											<!--                                         </a> -->
										</div>
									</div>
								</div>
							</div>
						</div>
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
<%-- 	<c:if test="${productArray} == 'null'"> --%>
	<%
		 Object obj = request.getAttribute("productArray"); 
		if(obj == null){
			System.out.println(obj);
			obj = 1; 
			System.out.println(obj);
		}else{
		}
		
	%>
	<input type="hidden" name="obj" value="0 ${productArray} " id="aaa">
	<input type="hidden" name="obj" value="0 ${venueArray} " id="bbb">
	
	<script type="text/javascript">
//         cookieArray = document.cookie.split(";");
//         console.log(cookieArray);
//         if (cookieArray == "") {
//             window.location.replace("LogIn.jsp");
//         }

// 場地div
console.log(document.getElementById("aaa").value);
console.log(document.getElementById("bbb").value);
var p =document.getElementById("aaa").value;
var v =document.getElementById("bbb").value;
var vArray = null;
var pArray = null;
var x = p.trim();
console.log(x);
console.log(typeof(p));
console.log(typeof(x));
console.log(x.length==1);
 if(x.length == 1){
// 	DB沒有Product
	alert("p equals 0.")
}else{
	pArray= x;
	console.log(pArray);
	pArray.split("0");
	console.log(pArray);
}
	
	
if(v === "0"){
	//DB沒有Venue
}else{
	vArray=${venueArray};
	//cannot use EL~
}

// vArray = ${venueArray};
// console.log(${obj});
// if(${obj} == 0){
// 	pArray = null;
// }else{
// 	pArray = ${productArray};
// }


$(document).ready(function(){
	//Venue
	if(vArray != null){
        for(var i = 0; i<vArray.length; i++){
            $('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='vendorName' name='Checkbox'> <label for='vendorName'><p class='text3'>"+${venueArray}[i].Vendor+"</p></label><input type='hidden' value='"+${venueArray}[i].VendorID+"' name='vendorID'><div class='remove margin1'><a href='' id='delete'><p class='' id='remove_vendor' onclick='remove_vendor()'>X</p></a></div></div><div class=' wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='img/venue1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='' class='noChangeLine'> <p class='text3'>"+${venueArray}[i].Hall+"</p> <input type='hidden' value='"+${venueArray}[i].ProductID+"' name='vId'> </a> </div><div class='width05'></div><div class='width10 sc_select'><input type='text' style='width:40px' value='"+${venueArray}[i].TableCount+"'></div><div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+${venueArray}[i].Price+"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->             <p id='remove_venue' onclick='remove_venue()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1'>     <div class='spacing_top adjPadding' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");    
        }
	}else{
	    console.log("no v");
	}

	//Product
	if(pArray != null){
            for(var i = 0; i<pArray.length; i++){
                $('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='productName' name='Checkbox'> <label for='productName'><p class='text3'>"+${productArray}[i].PSupplierName+"</p></label><input type='hidden' value='"+${productArray}[i].pSupplierId+"' name='supplierID'><div class='remove margin1'><input type='hidden' value='DELSUPPLIER' name='cmd'><a href='' id='delete'><p class='' id='remove_shop' onclick='remove_shop()'>X</p></a></div></div><div class=' wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='img/venue1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='' class='noChangeLine'> <p class='text3'>"+${productArray}[i].ProductName+"</p> <input type='hidden' value='"+${productArray}[i].ProductID+"' name='pId'> </a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock'><option hidden value='"+${productArray}[i].Quantity+"'>"+${productArray}[i].Quantity+"</option></select></div>         <div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+${productArray}[i].UnitPrice+"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->             <p id='remove_product' onclick='remove_product()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1'>     <div class='spacing_top adjPadding' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");    
                //動態新增下拉式選單商品數(比對庫存)
                var quantity = ${productArray}[i].stockQty;
                for (var i = 1; i <= quantity; i++) {
                    var elm2 = document.createElement("option");
                    var newCon2 = document.createTextNode(i);
                    elm2.append(newCon2);
                    $('#stock').append(elm2);
                }
            }    
            }else{
                console.log("no p");
            }
})


// 產品div
// var pArray = ${productArray};
// if(pArray.length != 0){
//     $(window).load(function(){
        
//             for(var i = 0; i<pArray.length; i++){
//                 $('#sc_left').append("<div class='wrap sc_frame fullwidth CartPadding' ><div class='spacingGeneral' id='chooseAll'><input type='checkbox' id='productName' name='Checkbox'> <label for='productName'><p class='text3'>商品店家</p></label><input type='hidden' value='"+${productArray}[i].pSupplierId+"' name='supplierID'><div class='remove margin1'><input type='hidden' value='DELSUPPLIER' name='cmd'><a href='' id='delete'><p class='' id='remove_shop' onclick='remove_shop()'>X</p></a></div></div><div class=' wrapRowStart topLine' id='SC_products'> <div class='width25'><div class='Pimg2 fullwidth'><img src='img/venue1.jpg' class='fullwidth' alt='venue1'> </div> </div><div class='wrapRow width80'><div class='width05'></div><div class='width75'><a href='' class='noChangeLine'> <p class='text3'>"+${productArray}[i].ProductName+"</p> <input type='hidden' value='"+${productArray}[i].ProductID+"' name='pId'> </a> </div><div class='width05'></div><div class='width10 sc_select'><select name='stock' id='stock'><option hidden value='"+${productArray}[i].Quantity+"'>"+${productArray}[i].Quantity+"</option></select></div>         <div class='width05'></div>         <div class='width30'>             <p class='text3'>NT$ "+${productArray}[i].UnitPrice+"</p>         </div>         <div class='width02'></div>         <div class='width05 margin2'>             <!--                                     <a href='' id='delete'> -->             <p id='remove_product' onclick='remove_product()'>X</p>             <!--                                     </a> -->         </div>     </div></div><!-- 以下是新增多個產品div --><!--                             以上是新增多個產品div --><div class='Pimg1'>     <div class='spacing_top adjPadding' id='SC_shipping'>         <p>選擇運送方式</p>         <div class='custom-select spacingGeneral' style='width: 200px;'>             <select>                 <option value='0'>請選擇運送方式</option>                 <option value='1'>宅配</option>                 <option value='2'>超商取貨</option>             </select>             <p class='noChangeLine spacing_top'>通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>         </div>     </div></div></div><br>");    
//                 //動態新增下拉式選單商品數(比對庫存)
//                 var quantity = ${productArray}[i].stockQty;
//                 for (var i = 1; i <= quantity; i++) {
//                     var elm2 = document.createElement("option");
//                     var newCon2 = document.createTextNode(i);
//                     elm2.append(newCon2);
//                     $('#stock').append(elm2);
//                 }
//             }    
//             }else{
//                 console.log("no p")
//             }
            
// //             ${productArray}[i].
//             })
//     }else{
//         console.log("no p")
//     }
        
        function remove_shop() {
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELSUPPLIER'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        

        function remove_product() {
//             document.getElementById("SC_products").remove();
//             document.getElementById("SC_shipping").remove();
            document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELPRODUCT'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
        function remove_vendor(){
        	document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELVENDOR'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
        
        function remove_venue(){
        	document.forms[0].action="<c:url value='UpdateShoppingCartServlet?cmd=DELVENUE'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
        }
    </script>
</body>
</html>

