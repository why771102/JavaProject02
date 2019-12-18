<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#tabs").tabs();
	});
	$(function() {
		$("#tabs1").tabs();
	});
	$(document).ready(function() {
		$("tr:even").css("background-color", "#fdf5e6");
		$("tr:odd").css("background-color", "#ddffcc");
	});
	cookieArray = document.cookie.split(";");
	console.log(cookieArray);
	if (cookieArray == "") {
		document.getElementById("name").innerText = "訪客";
		document.getElementById("logout").style.display = "none";
	} else {
		nameArrays = cookieArray[1].split("=");
		document.getElementById("name").innerText = nameArrays[1];
		document.getElementById("register").style.display = "none";
		document.getElementById("login").style.display = "none";
	}
</script>
<title>Document</title>
<style>
/* CSS reset */
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form,
	fieldset, input, textarea, p, blockquote, th, td {
	margin: 0;
	padding: 0;
}

html, /* 這邊做初始化設定 全部字體為正黑體  並且字體大小以百分比控制  */ body {
	margin: 0;
	padding: 0;
	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
	font-size: 100%;
}

/* warp 如何對齊 系列 */

/* 排版垂直column置中 */
.wrap {
	/*Flex屬性區*/
	display: flex;
	flex-flow: column nowrap;
	justify-content: center;
	align-items: center;
	border: solid 1px black;
	border-block-end-color: brown;
	box-sizing: border-box;
}

/* 排版垂直column向左 */
.wrapStart {
	/*Flex屬性區*/
	display: flex;
	flex-flow: column nowrap;
	justify-content: flex-start;
	align-items: flex-start;
	border: solid 1px black;
	border-block-end-color: brown;
	/* 撐開長寬 */
	/* width: 100%; */
	height: 100%;
	/* border and padding in box */
	box-sizing: border-box;
}
/* 排版一列row 向左 */
.wrapRowStart {
	/*Flex屬性區*/
	display: flex;
	flex-flow: row nowrap;
	justify-content: flex-start;
	align-items: flex-start;
	border: solid 1px black;
	border-block-end-color: brown;
	/* 撐開長寬 */
	width: 100%;
	height: 100%;
	/* border and padding in box */
	box-sizing: border-box;
}

/* 排版同列row 置中 */
.wrapRow {
	display: flex;
	flex-flow: row nowrap;
	justify-content: center;
	align-items: center;
	order: solid 1px black;
	border-block-end-color: brown;
}

/* in article have padding */
.wrapList {
	/*Flex屬性區*/
	display: flex;
	flex-flow: column nowrap;
	justify-content: flex-start;
	align-items: flex-start;
	border: solid 1px black;
	border-block-end-color: brown;
	/* 撐開長寬 */
	width: 100%;
	/* height: 100%; */
	/* border and padding in box */
	box-sizing: border-box;
	padding: 0% 1% 1% 1%;
}
/* warp 如何對齊 系列 */

/* 按鈕 選單系列  */
select {
	background-color: #fc6d6d;
	color: white;
	padding: 0.5% 4%;
	width: 100%;
	height: 4vh;
	border: none;
	font-size: 100%;
	box-shadow: 0 5px 25px rgba(0, 0, 0, 0.2);
	-webkit-appearance: button;
	appearance: button;
	outline: none;
	text-align: center;
	border-radius: 5px;
}

label {
	width: 100%;
}

.submitButton {
	/* 送出按鈕 */
	margin: 0px 0px 0px;
	border: none;
	border-radius: 5px;
	background-color: #fc6d6d;
	width: 100%;
	height: 100%;
	color: white;
	font-size: 2vh;
}
/* 按鈕 選單系列 */
#bg {
	width: 100%;
	height: 100%;
}
/*  跟header 網頭 有關系列 */
#head {
	width: 100%;
	height: 150px;
	padding: 10px 0px;
}
/*  跟header 網頭 有關系列 */
#cartShopList {
	width: 65%;
	height: 100%;
}

#chooseAll {
	display: flex;
	flex-flow: row nowrap;
	justify-content: center;
	align-items: flex-start;
	width: 100%;
	height: 10%;
}

/* 中間內文 */
#content {
	display: flex;
	flex-flow: row nowrap;
	justify-content: center;
	align-items: flex-start;
	width: 100%;
}
/* 中間內文 的左邊 還有 右邊 */
#left {
	width: 100%;
	height: 100vh;
}

#right {
	width: 50%;
	height: 100ｂvh;
	padding: 0% 3% 2%;
}
/* 跟img 有關系列 */
#pictureBG {
	background-color: #d8d8d8;
	width: 100%;
	height: 75%;
}

.Bimg {
	width: 100%;
	height: 65%;
	background-color: #949393;
}

.Simg {
	width: 20%;
	height: 50%;
	background-color: #949393;
	padding: 1% 1%;
}
/* 跟img 有關系列 */
/* 跟 a 連結 有關系列 */
a {
	width: 100%;
}
/* foot 網頁最底層有關  */
#footBG {
	background-color: #d8d8d8;
	width: 100%;
	height: 400px;
}
/* foot  */

/* 文字相關大小*/
p.BTital {
	color: black;
	text-align: left;
	font-size: 4.5vh;
	font-weight: bold;
}

p.tital {
	color: black;
	text-align: left;
	font-size: 4vh;
	font-weight: bold;
	width: 100%;
}

p.STital {
	color: black;
	text-align: left;
	font-size: 3vh;
	width: 100%;
}

p.text {
	color: black;
	text-align: left;
	font-size: 2vh;
	width: 100%;
}
/* 文字相關大小*/

/* map 相關設定 */
.map {
	width: 100%;
	height: 600px;
	background-color: cadetblue;
}
/* map 相關設定 */

/* product &deliver 相關設定 */
#deliverInfo {
	width: 50%;
	height: 100%;
	background-color: #d8d8d8;
	padding: 1vh;
	/* border and padding in box */
	box-sizing: border-box;
	border-radius: 5px;
}

#productInfo {
	width: 100%;
	height: 900px;
	padding: 1vh;
	/* border and padding in box */
	box-sizing: border-box;
}

.headright {
	/* 	border: 2px green solid; */
	/* 	 display:block; */
	/* 	 margin-right: 50px; */
	position: fixed;
	top: 40px;
	right: 30px;
}

.headcenter {
	display: inline-block;
}

table {
	border-collapse: separate;
	border-spacing: 4px;
	
}

#tb_tra {
	width: 75%;
	border-collapse: collapse;
	text-align: center;
	height: 700px;
}

#tabs {
	width: 100%;
	height: 80%;
	font-size: 40px;
}

#tabs1 {
	width: 100%;
	height: 100%;
	font-size: 40px;
}
}
.ui-tabs .ui-tabs-nav .ui-tabs-anchor {
    /* float: left; */
    padding: .5em 1em;
    text-decoration: none;
    padding-top: 20px;
    /* margin: 20px 0px; */
}

.enter{
text-align:center

}

/* map 相關設定 */
</style>
</head>

<body>
	<div class="wrap" id="bg">
		<!-- header -->
		<div class="wrap" id="head">
			<div class="headcenter">
				<div class="wrap">
					<p class="tital">MARY ME | 場地選項</p>
				</div>
				<div>
					<p class="text">場地|配件｜樣式｜婚禮小物｜新秘｜攝影</p>

				</div>

			</div>
			<div class="headright">
			
				
				<a href="backstagelogin.html"><input
					type="button" value="登出" id="logout" /></a>

			</div>
		</div>
		<!-- article -->
		<div class="wrap" id="cartShopList">
			<!-- top  -->

			<!-- content  -->
			<div class="wrap" id="content">

				<!-- product && deliver  -->
				<div class="wrapStart" id="left">
					<div class="wrapList">
						<p class="STital">場地後台</p>
					</div>

					<div class="wrapRow" style="width: 100%;">
						<div class="wrapRow" id="productInfo">
							<div id = "tabs1">
								<ul>
									<li><a href="#tabs1-1">場地</a></li>
									<li><a href="#tabs1-2">商品</a></li>
								</ul>
								<div id="tabs">
									<ul>
										<li><a href="#tabs-1">新增</a></li>
										<li><a href="#tabs-2">修改</a></li>
										<li><a href="#tabs-3">查詢</a></li>
										<li><a href="#tabs-4">刪除</a></li>
									</ul>
									<div id="tabs-1">
										<form class="enter" method="post" action="../createvenue">
										<table class="SQl">
										<tr><td>廠商編號:</td>
											<td><input type="text" name="vendorid"/></td></tr>
										<tr><td>地址:</td>
											<td><input type="text" name="venueaddress"/></td></tr>
										<tr><td>廳:</td>
											<td><input type="text" name="hall"/></td></tr>
										<tr><td>桌數:</td>
											<td><input type="text" name="tables"/></td></tr>
										<tr><td>室內室外:</td>
											<td><input type="text" name="inoutdoor"/></td></tr>
										<tr><td>午價錢:</td>
											<td><input type="text" name="lunchprice"/></td></tr>
										<tr><td>晚價錢:</td>
											<td><input type="text" name="dinnerprice"/></td></tr>
											<tr></tr>
										<input type="hidden" value=1 name="venuestatus"/>
										</table>
										<br><input type="submit"  value="確定"/>
											
										</form>
										</div>
									<div id="tabs-2">
										<form method="post" class="enter" action="../updatevenue">
										<table>
										<tr><td>場地編號:</td><td><input type="text" name="productid"/></td></tr>
										
										<tr><td>廠商編號:</td><td><input type="text" name="vendorid"/></td></tr>
										<tr><td>地址:</td><td><input type="text" name="venueaddress"/></td></tr>
										<tr><td>廳:</td><td><input type="text" name="hall"/></td></tr>
										<tr><td>桌數:</td><td><input type="text" name="tables"/></td></tr>
										<tr><td>室內室外:</td><td><input type="text" name="inoutdoor"/></td></tr>
										<tr><td>午價錢:</td><td><input type="text" name="lunchprice"/></td></tr>
										<tr><td>晚價錢:</td><td><input type="text" name="dinnerprice"/></td></tr>
										</table>
										<input type="submit" value="確定"/>
										</form>
									</div>
									<div id="tabs-3">
										<form method="post" action="../getallvenue">
										<input type="submit" value="確定"/>
										</form>
									</div>
									<div id="tabs-4">
										<form method="post" action="../deletevenue">
										場地編號:<input type="text" name="productid"/><p>
										<input type="submit" value="確定"/>
									</form>
									</div>
								</div>
							</div>
						</div>


					</div>
					<!-- 預定時間 -->

					<!-- 分隔商品資訊框框 -->

					<!-- 分隔商品資訊框框 -->
				</div>



			</div>

		</div>
		<!-- foot -->
		<div class="wrap" id="footBG">
			<div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
			<div>場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
		</div>


	</div>





</body>

</html>