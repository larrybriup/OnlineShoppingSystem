<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+
						request.getServerPort()+path+"/";
					%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/myAjax.js"></script>
<script type="text/javascript">
	var xmlHttpRequest=null;
	function checkName(){
		var username=document.getElementById("username").value;
		var span1=document.getElementById("span1");
		var flag=false;
		if(username==""){
		span1.innerHTML="<font color='red'>~.~用户名不能为空</font>";
		return flag ;
		}
		if(username.length>20){
		span1.innerHTML="<font color='red'>~.~您输入的用户名长度为"+username.length+",大于最大长度20个字符</font>";
		return flag ;
		}
		alert(username.length);
		if(xmlHttpRequest==null){
			xmlHttpRequest=createXMLHttpRequest();
		}
		xmlHttpRequest.open("get","checkServlet?username="+username,true);
		xmlHttpRequest.onreadystatechange=ajaxCallBack;
		if(ajaxCallBack()){
		flag=true;
		}
		xmlHttpRequest.send(null);
		return flag;
	}
	function ajaxCallBack(){
		var span1=document.getElementById("span1");
		var flag=false;
		var color="green";
		if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
			var msg=xmlHttpRequest.responseText;
			if(msg.length==17){
				color="red";
			}else{
			flag=true;
			}
			span1.innerHTML="<font color='"+color+"'>"+msg+"</font>";
		}
		return flag;
	}
	function checkPassword(){
		var password=document.getElementById("password").value;
		var span2=document.getElementById("span2");
		var flag=false;
		if(password.length<6){
			span2.innerHTML="<font color='red'>~.~密码不能少于六位</font>"
		}else{
			span2.innerHTML="<font color='green'>^_^密码格式正确</font>"
			flag=true;
		}
		return flag;
	}
	function checkAge(){
		var age=document.getElementById("age").value;
		var span3=document.getElementById("span3");
		var flag=false;
		if(age<=0||age>150){
			span3.innerHTML="<font color='red'>请输入正确的年龄</font>"
		}else{
			span3.innerHTML="<font color='green'>^_^年龄正确</font>"
			flag=true;
		}
		return flag;
	}
	function validateForm(){
		if(!checkAge()||!checkPassword()||!ajaxCallBack()){
			alert("您的输入有误,请检查后再提交!");
			return false;
		}
		return true;
	}
</script>
<title>register.jsp</title>
</head>
<body>
	<h3>${msg }</h3>
	<form action="RegisterServlet" method="post" onsubmit="return validateForm()">
		用户名:<input type="text" id="username" name="username" onblur="checkName()"/>
				<span id="span1"></span><br>
		密码:<input type="password" id="password" name="password" onblur="checkPassword()"/>
				<span id="span2"></span><br>
		年龄:<input type="text" id="age" name="age" onblur="checkAge()"/>
				<span id="span3"></span><br>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>