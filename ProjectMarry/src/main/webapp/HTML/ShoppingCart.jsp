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

<link rel="stylesheet" type="text/css" href="../CSS/combine.css">
<title>購物車</title>

</head>
<body>

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
				<div class="wrapStart " id="sc_left">

					<div class="wrap sc_frame fullwidth CartPadding" id="">
						<div class="spacingGeneral " id="chooseAll">
							<input type="checkbox" id="productName" name="Checkbox"> <label for="productName">
								<p class="text3">店家A</p>
							</label>
							<div class="remove margin1">
								<a href="" id="delete">
									<p class="" id="remove_shop" onclick="remove_shop()">X</p>
								</a>
							</div>
						</div>
						<div class=" wrapRowStart topLine" id="SC_products">

							<div class="width25">
								<div class="Pimg2 fullwidth">
									<img src="../img/venue1.jpg" class="fullwidth" alt="venue1">
								</div>
							</div>

							<div class="wrapRow width80">
								<div class="width05"></div>
								<div class="width75">
									<a href="" class="noChangeLine">
										<p class="text3">商 品 名 稱</p>
									</a>
								</div>

								<div class="width05"></div>
								<div class="width10 sc_select">
									<select>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</div>

								<div class="width05"></div>

								<div class="width30">
									<p class="text3">NT$ 10,000</p>
								</div>

								<div class="width02"></div>

								<div class="width05 margin2">
<!-- 									<a href="" id="delete"> -->
										<p id="remove_product" onclick="remove_product()">X</p>
<!-- 									</a> -->
								</div>
							</div>
						</div>


						<div class="Pimg1">
							<div class="spacing_top adjPadding" id="SC_shipping">
								<p>選擇運送方式</p>
								<div class="custom-select spacingGeneral" style="width: 200px;">
									<select>
										<option value="0">請選擇運送方式</option>
										<option value="1">宅配</option>
										<option value="2">超商取貨</option>
									</select>
									<p class="noChangeLine spacing_top">通知出貨後約 2 - 3 天寄達 | 提供追蹤</p>
								</div>
							</div>
						</div>
					</div>
				</div>

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
										<a href="Checkout.jsp">
											<div class="submitButton">
												<p id="sc_center">前往結帳</p>
											</div>
										</a>
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
<script type="text/javascript">
	function remove_shop(){
		
	}
	
	function remove_product(){
		document.getElementById("SC_products").remove();
		document.getElementById("SC_shipping").remove();
	}
</script>
</body>
</html>