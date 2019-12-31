<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/CSS/combine.css'/>">
<title>會員登入</title>
<style>
a {
	text-decoration: none;
}
.wrap123{
    padding: 5vh 3vh;
    
    background-color: rgba(255, 255, 255, 0.8);
    
    
    z-index: 0 ;
  
  
}
#bg{
    background-image:url("..\\HTML\\img\\Allbg1.jpg");
    background-repeat: no-repeat;
    background-color:rgba(255, 255, 255, 0.8);
    background-size: cover;
    /* background-size:1000px,100vh; */
    background-position: 50% 50%;
    height: 100vh;
   
   
  
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
      <div class="wrap end_gray_border" id="Product_list">
          <!-- top  -->

          <!-- content  -->
          <div class="wrapRow" id="content">

            <div class="wrap123" >
            <div style="  z-index: 1 ;">
            
                <form method="POST" action="<c:url value='/UserLogin'/>">
                <h2>會員登入</h2>
    
                <span>帳號:</span> <input type="text" id="account" name="Account"
                    value="${param.Account}" />${errorMsgMap.noAccount} <br> <span>密碼:</span>
    
                <input type="password" id="pwd" name="Pwd" value="${param.Pwd}" />${errorMsgMap.PwdNoMatch}
                
                <div>
                <br>
                    <input type="submit" value="登入" class="submitButton" style="height: 4vh;">
                </div>
                <br>
                <div><input type="submit" value="立刻註冊" class="submitButton"  style="height: 4vh; " formmethod="POST" formaction="UserRegister.jsp"></div>
            </form>
            
            
            </div>
               
                </div>


          </div>

      </div>

    
  </div>
 
    <!-- foot -->
    <div class="wrap" id="footBG" style="background-color: #e2d4b9 !important;">
        <div class="wrap " style="color: white">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
        <div style="color: white"> 場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
           </div>
    <!-- foot -->

        </div>

	
</body>
</html>