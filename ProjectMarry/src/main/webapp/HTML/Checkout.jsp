<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.Bean.OrderDetailProductsBean, com.Bean.OrderDetailVenuesBean, com.Bean.UserBean,
    java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	
    List<OrderDetailProductsBean> odpb = (ArrayList<OrderDetailProductsBean>)request.getAttribute("odpbSEND");
    List<OrderDetailVenuesBean> odvb = (ArrayList<OrderDetailVenuesBean>)request.getAttribute("odvbSEND");
    
    int plength = 0;
    int vlength = 0;
    if(odvb.get(0).getOrderID().equals(0)){
    	System.out.println("沒有存venue");
    	
    }else{
    	vlength = odvb.size();
    }
    if(odpb.get(0).getOrderID().equals(0)){
    	System.out.println("沒有存product");
    }else{
    	plength = odpb.size();
    }
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>結帳明細</title>
<link rel="stylesheet" type="text/css" href="CSS/combine.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
	function warn() {
		alert("即將前往新增信用卡頁面，請依步驟完成信用卡綁定");
	}
</script>
</head>

<body>
	<div class="wrap" id="bg">
	          <!-- header -->
        <div class="wrap end_gray_border" id="head">
           <iframe class="fullwidth" src="HTML/Header.jsp" frameborder="0"></iframe>
        </div>
<br>
<div><br></div>
       
		<!-- article -->
		<div class="wrap" id="cartShopList">
			<!-- top  -->
			<div class="wrap shoppingCart_detail_left">
				<a href="GetShoppingCartFromDBServlet"> ＜ 返回購物車</a>
			</div>
			<div class="spacingGeneral"></div>
			<!-- content  -->
			<div class="wrap" id="content">
				<!-- product && deliver  -->
				<div class="wrapStart shoppingCart_detail_left" id="insertHere">

					<div class="spacingGeneral" id="payment"></div>
					<!-- subtotal + discount -->
					<div class="spacingGeneral"></div>
				</div>
			</div>
		</div>
		   <!-- foot -->
        <div class="wrap" id="footBG" style="background-color: #e2d4b9 !important ;hieght:110px !important;">
            <div class="wrap " style="color: white">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
            <div style="color: white"> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
               </div>
                 <!-- foot -->
		
		<script>
		var plength = <%=plength%>;
		var vlength = <%=vlength%>;
		console.log(plength);
		console.log(vlength);
		var p = ${productDetail};
		var v = ${venueDetail};
		//product JSON
		const pObjStr = JSON.stringify(p);
		const pObj = (JSON.parse(pObjStr));
		//Venue JSON
		const vObjStr = JSON.stringify(v);
		const vObj = (JSON.parse(vObjStr));
		
		//Products
		var pTotal = 0;
		var pp = 0;
		console.log(p);
		
		
		for(var i = 0; i < plength; i++){
			pp += pObj[i].UnitPrice * pObj[i].Quantity * (1-pObj[i].Discount);
			pTotal = new Number(pp).toLocaleString("en-AU");
			let pPrice = new Number(pObj[i].UnitPrice).toLocaleString("en-AU");
			$('#insertHere').prepend("<div class='wrapStart sc_frame fullwidth'><div class='wrapList spacing_tb'><p class='STital text3'>"+pObj[i].PSupplierName+"</p></div><div class='wrapRow fullwidth'><div class='wrapTop topLine ' id='productInfo'><!--same shop   diffrent product  --><div class='wrapStart halfwidth'><!-- same shop unit product  --><div class='wrapRowStart' style='justify-content: space-between; padding: 1vh 0vh 2vh 1vh; border-block-end: solid #eeeeef;'><div class='Pimg3 wrapTop '><img src='HTML/img/Weddinggift1.jpg' alt=''></div><div class='wrapList' style='padding: 0% 0% 15% 10%;' id=''><a href='/ProjectMarry/ProductDetail?ProductID="+pObj[i].ProductID+"' class='noChangeLine'>"+pObj[i].ProductName+"</a><p style='padding: 0% 8% 0% 0%;'> 數量："+pObj[i].Quantity+"</p></div><div class='wrapRowEnd'><p>NT$ "+ pPrice +"</p></div></div><div class='wrapList wrapRight'><div class='wrapRowEnd pay_padding'><div class='wrapRowEnd' style='width: 65%;'><p class=''>商品小計</p></div><div style='width: 10%;'></div><div class='wrapRowEnd' style='width: 25%;'><div class=''>NT$ "+ pTotal +"</div></div></div><div class='wrapRowEnd pay_padding'><div class='wrapRowEnd' style='width: 65%;'><p class=''>運費</p></div><div style='width: 10%;'></div><div class='wrapRowEnd' style='width: 25%;'><div class=''>NT$ 0</div></div></div></div></div><div class='wrapRow width03'></div><!-- deliver  --><div class='wrapList' id='deliverInfo'><p>收件資訊</p><div class='spacingGeneral'><div class='container'><!-- Button to Open the Modal -->					<div class='infoButton' data-toggle='modal' data-target='#myModal2"+i+"'>		    <p class='spacing_b'>姓名：<span id='PmemName"+i+"'></span></p>		    <p class='spacing_b'>電話：<span id='Pmobile"+i+"'></span></p>		    <p class='spacing_b'>地址：<span id='Paddr"+i+"'></span></p>		</div>		<!-- The Modal2 新增地址 -->		<div class='modal' id='myModal2"+i+"'>		    <div class='modal-dialog'>		        <div class='modal-content'>		            <!-- Modal Header -->		            <div class='modal-header'>		                <h4 class='modal-title'>請填寫收件人與購買人資料</h4> <button type='button' class='close' data-dismiss='modal'>×</button>		            </div><!-- Modal body -->		            <div class='modal-body'>		                <form method='' action=''>收件人姓名<span>*</span> <br> <input type='text' id='Pname"+i+"' required=''		                        ><br>		                    <div class='tel'>收件人手機<span>*</span> <br> <select name='countryCode'>		                            <option>+886</option>		                        </select> <input type='text' id='Ptel"+i+"' required=''><br> <br></div>		                    <h5>商品寄往</h5>寄往 <br> <select id='Pcountry"+i+"'>		                        <option>台灣</option>		                        <option>海外</option>		                    </select><br> 地址<span>*</span> <br> <input type='text' id='Paddress"+i+"'><br>郵遞區號<span>*</span> <input type='text' id='PpostalCode"+i+"'>		                </form>		            </div><!-- Modal footer -->		            <div class='modal-footer'><button type='button' class='btn btn-danger' data-dismiss='modal'		                    data-toggle='modal' data-target='#myModal'>Close</button> <button type='button' class='btn btn-danger' id='P"+i+"' onclick='useInfo(this)' data-dismiss='modal'>使用地址</button> </div></form>		        </div>		    </div>		</div>		</div><div class='spacing_top'><p>運送方式：宅配</p></div></div><div class='memo'><p>備註</p><div class='spacingGeneral'>				<textarea placeholder='給店家的訊息或注意事項' maxlength='200' onkeyup='autogrow(this);'></textarea></div></div></div></div></div></div>");
			$("#PmemName"+i).text("${User.name}");
			$("#Pmobile"+i).text("${User.mobile}");
			$("#Paddr"+i).text("${User.address}");
		}
			
		function useInfo(Pro){
			let proId = Pro.id.substring(Pro.id.length - 1, Pro.id.length);
			let PmemName = "#PmemName"+proId;
			let Pmobile = "#Pmobile"+proId;
			let Pname = "#Pname"+proId;
			let Ptel = "#Ptel"+proId;
			let Paddr = "#Paddr"+proId;
			let Pcountry = "#Pcountry"+proId;
			let PpostalCode = "#PpostalCode"+proId;
			let Paddress = "#Paddress"+proId;
			
			$(PmemName).text($(Pname).val());
			$(Pmobile).text($(Ptel).val());
			let add = $(Pcountry).val() + $(PpostalCode).val() + $(Paddress).val();
			$(Paddr).text(add);
		}
			
		//Venue
		let vTotal = 0;
		console.log(v);
	
		for(var x = 0; x < vlength; x++){
	        //計算場地場次      	
        	let venueTime = null;
        	if(vObj[x].StartTime == 0){
        		//0: 午場
        		venueTime = "中午場";
        	}else{
        		//1: 晚場
        		venueTime = "晚上場";
        	}
			//計算場地金額
			vTotal = vObj[x].Price;
			let vPrice = new Number(vTotal).toLocaleString("en-AU");
			$('#insertHere').prepend("<div class='wrapStart sc_frame fullwidth'><div class='wrapList spacing_tb'><p class='STital text3'>"+vObj[x].Vendor+"</p></div><div class='wrapRow fullwidth'><div class='wrapTop topLine ' id='productInfo'><!--same shop   diffrent product  --><div class='wrapStart halfwidth'><!-- same shop unit product  --><div class='wrapRowStart' style='justify-content: space-between; padding: 1vh 0vh 2vh 1vh; border-block-end: solid #eeeeef;'><div class='Pimg3 wrapTop '><img src='img/venue1.jpg' alt=''></div><div class='wrapList' style='padding: 0% 0% 15% 10%;' id=''><a href='' class='noChangeLine'>"+vObj[x].Hall+"</a><span>"+vObj[x].Location+"</span><span>"+vObj[x].Date+"</span><span>"+venueTime+"</span><p style='padding: 0% 8% 0% 0%;'> 桌數："+vObj[x].TableCount+"</p></div><div class='wrapRowEnd'><p>NT$ "+ vPrice +"</p></div></div><div class='wrapList wrapRight'><div class='wrapRowEnd pay_padding'><div class='wrapRowEnd' style='width: 65%;'><p class=''>商品小計</p></div><div style='width: 10%;'></div><div class='wrapRowEnd' style='width: 25%;'><div class=''>NT$ "+ vPrice +"</div></div></div><div class='wrapRowEnd pay_padding'><div class='wrapRowEnd' style='width: 65%;'><p class=''>運費</p></div><div style='width: 10%;'></div><div class='wrapRowEnd' style='width: 25%;'><div class=''>NT$ 0</div></div></div></div></div><div class='wrapRow width03'></div><!-- deliver  --><div class='wrapList' id='deliverInfo'><p>收件資訊</p><div class='spacingGeneral'><div class='container'><!-- Button to Open the Modal -->					<div class='infoButton' data-toggle='modal' data-target='#myModal1"+x+"'>		    <p class='spacing_b'>姓名：<span id='memName"+x+"'></span></p>		    <p class='spacing_b'>電話：<span id='mobile"+x+"'></span></p>		    <p class='spacing_b'>地址：<span id='addr"+x+"'></span></p>		</div>		<!-- The Modal2 新增地址 -->		<div class='modal' id='myModal1"+x+"'>		    <div class='modal-dialog'>		        <div class='modal-content'>		            <!-- Modal Header -->		            <div class='modal-header'>		                <h4 class='modal-title'>請填寫收件人與購買人資料</h4> <button type='button' class='close' data-dismiss='modal'>×</button>		            </div><!-- Modal body -->		            <div class='modal-body'>		                <form method='' action=''>收件人姓名<span>*</span> <br> <input type='text' id='Rname"+x+"' required=''		                        ><br>		                    <div class='tel'>收件人手機<span>*</span> <br> <select name='countryCode'>		                            <option>+886</option>		                        </select> <input type='text' id='Rtel"+x+"' required=''><br> <br></div>		                    <h5>商品寄往</h5>寄往 <br> <select id='country"+x+"'>		                        <option>台灣</option>		                        <option>海外</option>		                    </select><br> 地址<span>*</span> <br> <input type='text' id='address"+x+"'><br>郵遞區號<span>*</span> <input type='text' id='postalCode"+x+"'>		                </form>		            </div><!-- Modal footer -->		            <div class='modal-footer'><button type='button' class='btn btn-danger' data-dismiss='modal'		                    data-toggle='modal' data-target='#myModal'>Close</button> <button type='button' class='btn btn-danger' id='V"+x+"' onclick='useInfov(this)' data-dismiss='modal'>使用地址</button> </div></form>		        </div>		    </div>		</div>		</div><div class='spacing_top'><p>運送方式：宅配</p></div></div><div class='memo'><p>備註</p><div class='spacingGeneral'>				<textarea placeholder='給店家的訊息或注意事項' maxlength='200' onkeyup='autogrow(this);'></textarea></div></div></div></div></div></div>");	
			$("#memName"+x).text("${User.name}");
			$("#mobile"+x).text("${User.mobile}");
			$("#addr"+x).text("${User.address}");
		}
		
		function useInfov(Ven){
			let venId = Ven.id.substring(Ven.id.length - 1, Ven.id.length);
			let memName = "#memName"+venId;
			let mobile = "#mobile"+venId;
			let addr = "#addr"+venId;
			let Rname = "#Rname"+venId;
			let Rtel = "#Rtel"+venId;
			let country = "#country"+venId;
			let postalCode = "#postalCode"+venId;
			let address = "#address"+venId;
			
			$(memName).text($(Rname).val());
			$(mobile).text($(Rtel).val());
			let add1 = $(country).val() + $(postalCode).val() + $(address).val();
			$(addr).text(add1);
		}
	
		var vppp = vTotal + pp;
		console.log("vppp= " + vppp);
		var vpSubtotal = new Number(vppp).toLocaleString("en-AU");
		
		var subtotal = new Number(vppp - 50).toLocaleString("en-AU");;
		//Payment
			$('#payment').append("<div class='sc_frame'><div class='wrapList payInfo spacing_tb'><p class='STital text3'>請選擇付款方式</p>	</div><div class='wrapRow fullwidth'>				<div class='wrapTop' id='productInfo'>					<!--same shop diffrent product-->					<div class='wrapStart halfwidth'>						<!--same shop unit product-->						<div class='wrapRowStart pay_padding'>							<p>商品總計</p>							<div class='pay_right'>NT$ "+vpSubtotal+"</div>						</div>						<div class='wrapRowStart pay_padding'>							<p>運費總計</p>							<div class='pay_right'>NT$ 0</div>						</div>						<div class='wrapRowStart pay_padding spacing_b'>							<p>其他折抵</p>							<div class='pay_right'>NT$ -50</div>						</div>						<br>						<div class='wrapRowStart pay_padding topLine'>							<p>結帳總金額</p>							<div class='pay_right'>NT$ "+ subtotal +"</div>						</div>					</div>					<div class='wrapRow width03'></div>					<!--credit card-->					<div class='wrapList spacing_rl' id='deliverInfo'>						<p style='font-weight: bold;'>新增信用卡快速付款（首次新增送 500 點紅利)</p>						<div class='spacingGeneral'>							<div class='topLine '>								<a href=''>									<p class='spacing_top' id='pColor' onclick='warn();'>+										新增常用信用卡</p>								</a>							</div>						</div>						<div class='spacing_top'>新增成功後，下次結帳免輸入卡號即可直接付款。新增信用卡時，							MARRY ME將會進行一筆 1 元測試交易，此筆款項不會實際扣款， 請放心依步驟進行認證。</div>						<p class='spacing_top1 spacing_b' style='font-weight: bold;'>其他付款方式</p>						<div class='spacingGeneral topLine'>							<input type='radio' name='payment' id='convenient7'><label								for='convenient7' style='display: inline;'> 7-11 ibon代碼繳費</label><br>							<input type='radio' name='payment' id='convenient_family'								class='spacing_top1'><label for='convenient_family'								class='spacing_top1' style='display: inline;'> 全家代碼繳費</label><br> <input								type='radio' name='payment' id='atm' class='spacing_top1'><label								for='atm' style='display: inline;'> ATM 轉帳繳費</label><br> <input type='radio'								name='payment' id='linepay' class='spacing_top1'><label								for='linepay' style='display: inline;'> LINE Pay</label><br>						</div>						<div class='wrapList'>															<div class='submitButton' onclick='confirmOrder()'>									<p id='sc_center' style='margin-bottom: 0;'>確認付款</p>								</div>													</div>					</div>				</div>			</div>		</div>");
			
		function confirmOrder(){
			document.forms[0].action="<c:url value='PlaceOrder'/>";
            document.forms[0].method = "POST";
            document.forms[0].submit();
		}
		</script>
		
</body>
</html>