<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料修改</title>

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
	background-color: white;
}

/* warp 如何對齊 系列 */

/* 排版垂直column置中 */
.wrap {
	/*Flex屬性區*/
	width: 540px;
	display: flex;
	flex-flow: column nowrap;
	justify-content: center;
	align-items: center;
	border-block-end-color: brown;
	box-sizing: border-box;
}

.wrap123 {
	/*Flex屬性區*/
	display: flex;
	flex-flow: column nowrap;
	justify-content: center;
	align-items: center;
	/*   border: solid 1px black; */
	border-block-end-color: brown;
	box-sizing: border-box;
	height: 450px;
	padding: auto;
	margin: auto;
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
	height: 100px;
	padding: 10px 0px;
	/*    border:1px solid;*/
	background-color: azure;
	/* 	position: fixed; */
	top: 0px;
	z-index: 10;
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
	height: 110px;
	position: fixed;
	bottom: 0;
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
	text-align: center;
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
	text-align: center;
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
	height: 200px;
	padding: 1vh;
	/* border and padding in box */
	box-sizing: border-box;
}

.headleft {
	float: left;
	width: 33%;
	background-color: antiquewhite;
	/*    border: solid 1px;*/
	margin-top: 2vh;
}

.headright {
	width: 33%;
	float: left;
	/*	border: solid 1px;*/
	margin-top: 4vh;
	text-align: center;
	/*    padding-right: 50px;*/
	/*    display: inline-block;*/
}

.headcenter {
	float: left;
	align-content: center;
	margin-top: 2vh;
	width: 33%;
}

.placelist {
	width: 1000px;
	/*            border: 1px solid;*/
	padding-left: 12px;
	margin-top: 30px;
}

.place {
	float: left;
	width: 32%;
	height: 300px;
	/*            border: 1px solid;*/
	margin-right: 10px;
	margin-bottom: 20px;
	background-image: url(img/1.jpg);
	background-repeat: no-repeat;
	background-size: 300px 200px;
	background-position: top center;
}

.placeimg {
	
}

.plassimg1 {
	/*            object-fit: fill;*/
	width: 200px;
	height: 200px;
	float: none;
}

.placename {
	border: 1px solid;
	height: 50px;
	/*            margin-bottom: 2px;*/
	margin-top: 205px;
	text-align: center;
	font-size: 2em;
}

.placedetail {
	border: 1px solid;
	height: 50px;
	/*            margin-bottom: 0px;*/
	/*            position:absolute;*/
	/*            margin-top: 195px;*/
	text-align: center;
	font-size: 1em;
}

.notice {
	color: red;
	font-size: 11px;
}
</style>

</head>
<body>

	<div class="wrap" id="bg">
		<!-- header -->
		<div id="head">
			<div class="headleft"></div>
			<div class="headcenter">
				<div>
					<p class="tital">MARY ME</p>
				</div>
				<div>
					<p class="text">場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</p>

				</div>

			</div>
		</div>
	</div>

	<div class="wrap123">
		<h2>會員資料修改</h2>
		<form>
			<input type="hidden" value="${User.account}" name="Account" />
			<table border="1">
				<tr>
					<td>姓名</td>
					<td><input type="text" value="${User.name}" name="Name" /></td>
				</tr>

				<tr>
					<td>生日</td>
					<td><input type="text" value="${User.birth}" name="Birth" /></td>
				</tr>
				<tr>
					<td>行動電話</td>
					<td><input type="text" value="${User.mobile}" name="Mobile" /></td>
				</tr>
				<tr>
					<td>市話</td>
					<td><input type="text" value="${User.tel}" name="Tel" /></td>
				</tr>
				<tr>
					<td>電子郵件</td>
					<td><input type="text" value="${User.mail}" name="Mail" /></td>
				</tr>
				<tr>
					<td>住址</td>
					<td><input type="text" value="${User.address}" name="Address" /></td>
				</tr>
			</table>
			<br>
			<div>
				<input type="submit" value="確定修改資料" class="submitButton" onclick="alert('修改成功！')"
					formmethod="POST" formaction="<c:url value='/UserUpdate'/>">
			</div>
			<br>
			<div>
				<a href="HTML/index.html"><input type="button" value="返回首頁"
					id="Index" class="submitButton" /></a>
			</div>
		</form>

	</div>


	<!-- foot -->
	<div class="wrap" id="footBG">
		<div class="wrap">MARY ME |錢沒有不見 &emsp; 只是變成你喜歡的樣子</div>
		<div>場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</div>
	</div>
	<script>
		cookieArray = document.cookie.split(";");
		console.log(cookieArray);
		if (cookieArray == "") {
			window.location.replace("HTML/LogIn.jsp");
		} else {
	
		}
	</script>
</body>
</html>