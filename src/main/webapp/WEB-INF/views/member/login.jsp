<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var msg='${msg}';
		if(msg !=""){
			alert(msg);
		}
	});
</script>
</head>
<body>

	<form action="./memberLogin" method="post">
		<div>ID :<input type="text" name="id"></div>
		<div>PW :<input type="password" name="pw"></div>
		
		<input type="submit" value="로그인">
	</form>

</body>
</html>