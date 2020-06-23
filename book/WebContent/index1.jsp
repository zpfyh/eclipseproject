<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

function reloadCheckImg()
{
	$("img").attr("src","index.jsp?t="+(new Date().getTime()))
}

$(document).reday(function(){
	$("#checkCodeid").blur(function(){
		alert(iii);
	
	var $checkcode = $("#checkCodeid").val();
		$.post(
				"checkcodeservlet",//服务器地址
				"checkCodeid="+$checkcode,
				function(result){
					var resulthtml = $("<img src='"+result+"' widght='30' height='30'")
					
					$("#tip").html(resulthtml);
				}
				);
	});
});
</script>
</head>
<body>
	验证码：
	<input type="text" name="checkCode"  id="checkCodeid" size="4">
	<!-- 验证码 -->
	<a href="javascript:reloadCheckImg();"><img src="index.jsp"></a>
	<span id="tip"></span>
	
	
	
</body>
</html>