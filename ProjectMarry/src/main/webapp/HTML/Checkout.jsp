<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>結帳明細</title>
<link rel="stylesheet" type="text/css" href="../CSS/combine.css">
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
			<div class="wrap shoppingCart_detail_left">
				<a href="ShoppingCart.jsp"> ＜ 返回購物車</a>
			</div>
			<div class="spacingGeneral"></div>
			<!-- content  -->
			<div class="wrap" id="content">
				<!-- product && deliver  -->
				<div class="wrapStart shoppingCart_detail_left">
					<div class="wrapStart sc_frame fullwidth">
						<div class="wrapList spacing_tb">
							<p class="STital text3">店家名稱</p>
						</div>
						<div class="wrapRow fullwidth">
							<div class="wrapTop topLine " id="productInfo">
								<!--same shop   diffrent product  -->
								<div class="wrapStart halfwidth">
									<!-- same shop unit product  -->
									<div class="wrapRowStart"
										style="justify-content: space-between; padding: 1vh 0vh 2vh 1vh; border-block-end: solid #eeeeef;">
										<div class="Pimg3 wrapTop ">
											<img src="../img/venue1.jpg" alt="">
										</div>
										<div class="wrapList" style="padding: 0% 0% 15% 10%;" id="">
											<a href="" class="noChangeLine">商 品 名 稱</a>
											<p style="padding: 0% 8% 0% 0%;">數量</p>
										</div>
										<div class="wrapRowEnd">
											<p>NT$ 1000</p>
										</div>
									</div>
									<div class="wrapList wrapRight">
										<div class="wrapRowEnd pay_padding">
											<div class="wrapRowEnd" style="width: 70%;">
												<p class="">商品小計</p>
											</div>
											<div style="width: 10%;"></div>
											<div class="wrapRowEnd" style="width: 20%;">
												<div class="">NT$ 10,000</div>
											</div>
										</div>
										<div class="wrapRowEnd pay_padding">
											<div class="wrapRowEnd" style="width: 70%;">
												<p class="">運費</p>
											</div>
											<div style="width: 10%;"></div>
											<div class="wrapRowEnd" style="width: 20%;">
												<div class="">NT$ 0</div>
											</div>
										</div>
									</div>
								</div>
								<div class="wrapRow width03"></div>
								<!-- deliver  -->
								<div class="wrapList" id="deliverInfo">
									<p>收件資訊</p>
									<div class="spacingGeneral">
										<div class="container">
											<!-- Button to Open the Modal -->
											<div class="infoButton" data-toggle="modal"
												data-target="#myModal">
												<p class="spacing_b">姓名</p>
												<p class="spacing_b">電話</p>
												<p class="spacing_b">地址</p>
												<p class="spacing_b">購買人</p>
											</div>
											<!-- The Modal  選擇地址-->
											<div class="modal" id="myModal">
												<div class="modal-dialog">
													<div class="modal-content">

														<!-- Modal Header -->
														<div class="modal-header">
															<h4 class="modal-title">請選擇收件人與購買人資料</h4>
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<!-- Model Body -->
														<div class="modal-body">
															<div class="wrapRowStart modal_block1"
																style="display: flex;">
																<div class="mem_detail " style="width: 60%;">
																	<p>收件人</p>
																	<p>Ally</p>
																	<p>0912456789</p>
																	<p>新北市大安區</p>
																	<p>購買人</p>
																	<p>同收件人</p>
																	<p>發票類型</p>
																	<p>二聯式發票</p>
																</div>
																<div class="mem_button" style="width: 40%;">
																	<div class="wrapRow ">
																		<button class="useAddress btn-primary"
																			style="padding: 0 10%;">使用地址</button>
																	</div>
																	<br>
																	<div class="wrapRow">
																		<button class="setting">編輯</button>
																		<button class="delete">刪除</button>
																	</div>
																</div>
															</div>
															<div class="modal_block2">
																<p>收件人</p>
																<p>Ｊesse</p>
																<p>0912456789</p>
																<p>新北市淡水區</p>
																<p>購買人</p>
																<p>同收件人</p>
																<p>發票類型</p>
																<p>二聯式發票</p>
															</div>
														</div>
														<!-- Modal footer -->
														<div class="modal-footer">
															<!-- <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button> -->
															<button type="button" class="btn btn-primary"
																data-dismiss="modal" data-toggle="modal"
																data-target="#myModal2">新增地址</button>
														</div>
													</div>
												</div>
											</div>
											<!-- The Modal2 新增地址 -->
											<div class="modal" id="myModal2">
												<div class="modal-dialog">
													<div class="modal-content">

														<!-- Modal Header -->
														<div class="modal-header">
															<h4 class="modal-title">請填寫收件人與購買人資料</h4>
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<!-- Modal body -->
														<div class="modal-body">
															<form method="post" action="">
																收件人姓名<span>*</span> <br> <input type="text"
																	id="Rname" required><br>
																<div class="tel">
																	收件人手機<span>*</span> <br> <select
																		name="countryCode">
																		<option>+886</option>
																	</select> <input type="text" id="Rtel" required><br>
																	<br>
																</div>
																<h5>商品寄往</h5>
																寄往 <br> <select>
																	<option>台灣</option>
																	<option>海外</option>
																</select><br> 地址<span>*</span> <br> <input type="text"
																	id="address"><br> 郵遞區號<span>*</span> <input
																	type="text" id="postalCode">
															</form>
														</div>

														<!-- Modal footer -->
														<div class="modal-footer">

															<button type="button" class="btn btn-danger"
																data-dismiss="modal" data-toggle="modal"
																data-target="#myModal">Close</button>
															<button type="button" class="btn btn-danger"
																data-dismiss="modal" data-toggle="modal"
																data-target="#myModal">使用地址</button>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="spacing_top">
											<p>運送方式：宅配</p>
										</div>
									</div>
									<div class="memo">
										<p>備註</p>
										<div class="spacingGeneral">
											<textarea placeholder="給店家的訊息或注意事項" maxlength="200"
												onkeyup="autogrow(this);"></textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="spacingGeneral"></div>
					<!-- subtotal + discount -->
					<div class="sc_frame">
						<div class="wrapList payInfo spacing_tb">
							<p class="STital text3">請選擇付款方式</p>
						</div>

						<div class="wrapRow fullwidth">
							<div class="wrapTop" id="productInfo">
								<!--same shop   diffrent product  -->
								<div class="wrapStart halfwidth">
									<!-- same shop unit product  -->
									<div class="wrapRowStart pay_padding">
										<p>商品總計</p>
										<div class="pay_right">NT$ 10,000</div>
									</div>
									<div class="wrapRowStart pay_padding">
										<p>運費總計</p>
										<div class="pay_right">NT$ 0</div>
									</div>
									<div class="wrapRowStart pay_padding spacing_b">
										<p>其他折抵</p>
										<div class="pay_right">NT$ -500</div>
									</div>
									<br>
									<div class="wrapRowStart pay_padding topLine">
										<p>結帳總金額</p>
										<div class="pay_right">NT$ 9,500</div>
									</div>
								</div>
								<div class="wrapRow width03"></div>
								<!-- credit card  -->
								<div class="wrapList spacing_rl" id="deliverInfo">
									<p style="font-weight: bold;">新增信用卡快速付款（首次新增送 500 點紅利)</p>
									<div class="spacingGeneral">
										<div class="topLine ">
											<a href="">
												<p class="spacing_top" id="pColor" onclick="warn();">+
													新增常用信用卡</p>
											</a>
										</div>
									</div>
									<div class="spacing_top">新增成功後，下次結帳免輸入卡號即可直接付款。新增信用卡時，
										MARRY ME將會進行一筆 1 元測試交易，此筆款項不會實際扣款， 請放心依步驟進行認證。</div>
									<p class="spacing_top1 spacing_b" style="font-weight: bold;">其他付款方式</p>
									<div class="spacingGeneral topLine">
										<input type="radio" name="payment" id="convenient7"><label
											for="convenient7" style="display: inline;"> 7-11 ibon代碼繳費</label><br> 
										<input type="radio" name="payment" id="convenient_family"
											class="spacing_top1"><label for="convenient_family"
											class="spacing_top1" style="display: inline;"> 全家代碼繳費</label><br> <input
											type="radio" name="payment" id="atm" class="spacing_top1"><label
											for="atm" style="display: inline;"> ATM 轉帳繳費</label><br> <input type="radio"
											name="payment" id="linepay" class="spacing_top1"><label
											for="linepay" style="display: inline;"> LINE Pay</label><br>
									</div>
									<div class="wrapList">
										<a href="Checkout.jsp">
											<div class="submitButton">
												<p id="sc_center" style="margin-bottom: 0;">確認付款</p>
											</div>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="spacingGeneral"></div>
				</div>
			</div>
		</div>
		<!-- foot -->
		<div class="wrap" id="footBG">
			<div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
			<div>場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
		</div>
</body>
</html>