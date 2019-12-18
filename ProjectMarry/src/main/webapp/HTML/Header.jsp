<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <title>Header</title>
    <link href="css/slider.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.4.1.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Parisienne&display=swap" rel="stylesheet">
    
    
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
    
  

    

    
    /* 按鈕 選單系列 */
    #bg {
        width: 100%;
        height: 100%;
    }
    
    /*  跟header 網頭 有關系列 */
    #head {
        width: 100%;
        height: 100%;
        padding: 20vh 0px;
        color:white;
        background-color: #e2d4b9;
        position: fixed;
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
        /*            position: fixed;*/
        bottom: 0;
    }
    
    /* foot  */
    
    /* 文字相關大小*/
    p.BTital {
        color: black;
        text-align:center;
        font-size: 28vh;
        font-weight: bold;
    }
    
    p.tital {
        color: black;
        text-align: center;
        font-size: 12vh;
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
        font-size: 13.5vh;
        width: 100%;
    }
    
    /* 文字相關大小*/
    

    
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
        /*    border: solid 1px;*/
        margin-top: 22vh;
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
        /*    border: 1px solid;*/
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
        /*     background-image: url(img/1.jpg); */
        /*     background-repeat: no-repeat; */
        /*     background-size: 300px 200px; */
        /*     background-position: top center; */
    }
    
    .placeimg {
        width: auto;
        height: 200px;
        /*            border: 1px solid;*/
        display: flex;
        justify-content: center;
    }
    
    .plassimg1 {
        /*            object-fit: fill;*/
        width: auto;
        height: 200px;
        /*            margin: auto;*/
        /*            display: block;*/
    }
    
    .placename {
        /*            border: 1px solid;*/
        height: 50px;
        /*            margin-bottom: 2px;*/
        margin-top: 1px;
        text-align: center;
        font-size: 1.5em;
    }
    
    .placedetail {
        height: 50px;
        width: auto;
        padding-left: 10px;
        padding-right: 5px;
        text-align: left;
        font-size: 1em;
    }
    
    .placeTitle {
        text-align: center;
        margin-bottom: 35px;
    }
    
    .shoppingIcon {
        width: 200px;
        margin: 0 auto;
        position: relative;
    }
    a{
    color:white;
	text-decoration: none;
}
   
    </style>
    </head>
    
    <body>
        <div class="wrap " id="bg">
            <!-- header -->
            <div id="head">
                <div class="headleft"></div>
                <div class="headcenter">
                    <div>
                        <p class="BTital" onclick="returnIdex()" style="font-family: 'Parisienne', cursive  !important; color:white;">Mary Me</p>
                    </div>
                    <div>
                        <p class="text" style=" color:whitesmoke;">場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</p>
    
                    </div>
    
                </div>
                <div class="headright">
                    <div class="shoppingIcon" >
                        <div>
                            <p style="color:white;">
                                <span id="name" style="color:white;"></span>，你好！
                            </p>
                        </div>
                        <div style="position: absolute; right: 0px; top: -3px;">
    
                            <a href="../GetShoppingCartFromDBServlet"><img 
                                src="img/shoppingcartIcon64.png" width="50px" height="50px"  onclick="goshoppingCart()"></a>
                        </div>
                        <div style="clear: both">
                            <a href="" id="register" onclick='goRegister()'>註冊</a> 
                            <a href="" id="login" onclick='goLogin()' >登入</a> 
                                <a href=
                                id="logout" onclick="goLoginOut()">登出</a> <a href="../UserDataQuery" id="Query">會員資料</a>
                        </div>
                    </div>
    
                </div>
            </div>
          
    
    
 
        </div> 
    
    
        <script>
            cookieArray = document.cookie.split("; ");
            console.log(cookieArray);
            if (cookieArray == "") {
                $("#name").text("訪客");
                $("#logout").hide();
                $("#Query").hide();
                $("#redpoint").hide();
            } else {
                for (i = 0; i < cookieArray.length; i++) {
                    nameArrays = cookieArray[i].split("=");
                    console.log(nameArrays);
                    if (nameArrays[0] == "name") {
                        $("#name").text(nameArrays[1]);
                    }
                }
                $("#register").hide();
                $("#login").hide();
            }
    
    
            $(function() {
                $.get("../ShowProduct", function(responseText) {
    
                    var jsonPro = JSON.parse(responseText);
    
                    txt = "";
                    for (i = 0; i < jsonPro.length; i++) {
                        var num = (i + 1).toString();
                        txt += "<div class='place'><div class='placeimg'><img class='plassimg1' src='img/Weddinggift" + num + ".jpg'></div><div class='placename' id='pro2'>" + jsonPro[i]["ProductName"] + "</div><div class='placedetail'>" + jsonPro[i]["Depiction"] + "</div></div>";
                    }
                    $("#pro").html(txt);
                });
            });
    
    
    
            var $a = $(".buttons a");
            var $s = $(".buttons span");
            var cArr = [ "p7", "p6", "p5", "p4", "p3", "p2" ];
            var index = 0;
            $(".next").click(function() {
                nextimg();
            })
            $(".prev").click(function() {
                previmg();
            })
            //上一张
            function previmg() {
                cArr.unshift(cArr[5]);
                cArr.pop();
                //i是元素的索引，从0开始
                //e为当前处理的元素
                //each循环，当前处理的元素移除所有的class，然后添加数组索引i的class
                $("li").each(function(i, e) {
                    $(e).removeClass().addClass(cArr[i]);
                })
                index--;
                if (index < 0) {
                    index = 5;
                }
                show();
            }
    
            //下一张
            function nextimg() {
                cArr.push(cArr[0]);
                cArr.shift();
                $("li").each(function(i, e) {
                    $(e).removeClass().addClass(cArr[i]);
                })
                index++;
                if (index > 5) {
                    index = 0;
                }
                show();
            }
    
            //通过底下按钮点击切换
            $a.each(function() {
                $(this).click(function() {
                    var myindex = $(this).index();
                    var b = myindex - index;
                    if (b == 0) {
                        return;
                    } else if (b > 0) {
                        /*
                         * splice(0,b)的意思是从索引0开始,取出数量为b的数组
                         * 因为每次点击之后数组都被改变了,所以当前显示的这个照片的索引才是0
                         * 所以取出从索引0到b的数组,就是从原本的这个照片到需要点击的照片的数组
                         * 这时候原本的数组也将这部分数组进行移除了
                         * 再把移除的数组添加的原本的数组的后面
                         */
                        var newarr = cArr.splice(0, b);
                        cArr = $.merge(cArr, newarr);
                        $("li").each(function(i, e) {
                            $(e).removeClass().addClass(cArr[i]);
                        })
                        index = myindex;
                        show();
                    } else if (b < 0) {
                        /*
                         * 因为b<0,所以取数组的时候是倒序来取的,也就是说我们可以先把数组的顺序颠倒一下
                         * 而b现在是负值,所以取出索引0到-b即为需要取出的数组
                         * 也就是从原本的照片到需要点击的照片的数组
                         * 然后将原本的数组跟取出的数组进行拼接
                         * 再次倒序,使原本的倒序变为正序
                         */
                        cArr.reverse();
                        var oldarr = cArr.splice(0, -b)
                        cArr = $.merge(cArr, oldarr);
                        cArr.reverse();
                        $("li").each(function(i, e) {
                            $(e).removeClass().addClass(cArr[i]);
                        })
                        index = myindex;
                        show();
                    }
                })
            })
    
            //改变底下按钮的背景色
            function show() {
                $($s).eq(index).addClass("blue").parent().siblings().children()
                        .removeClass("blue");
            }
    
            //点击class为p2的元素触发上一张照片的函数
            $(document).on("click", ".p2", function() {
                previmg();
                return false; //返回一个false值，让a标签不跳转
            });
    
            //点击class为p4的元素触发下一张照片的函数
            $(document).on("click", ".p4", function() {
                nextimg();
                return false;
            });
    
            //            鼠标移入box时清除定时器
            $(".box").mouseover(function() {
                clearInterval(timer);
            })
    
            //            鼠标移出box时开始定时器
            $(".box").mouseleave(function() {
                timer = setInterval(nextimg, 4000);
            })
    
            //            进入页面自动开始定时器
            timer = setInterval(nextimg, 4000);


            function returnIdex(){
                top.location.href = "index.html";

            }
            
            function  goshoppingCart(){
            	 top.location.href = "../GetShoppingCartFromDBServlet";
            }
            
            function  goLogin(){
           	 top.location.href = "LogIn.jsp";
           }
            function  goLoginOut(){
              	 top.location.href = "../UserLogOut";
              }
            function  goRegister(){
             	 top.location.href = "UserRegister.jsp";
             }
        </script>
    
    
    
    </body>
    
    </html>
    
    
    