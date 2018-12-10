<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./memberJoin" method="post">
		<div>ID :<input type="text" name="id"><button id="btn">중복확인</button> </div>
		<div>PW :<input type="password" name="pw"></div>
		<div>NAEM :<input type="text" name="name"></div>
		<div>EMAIL :<input type="email" name="email"></div>
		<div>PHONE :<input type="text" name="phone"></div>
		<div>ADDRESS :<input type="text" name="address"></div>
		<input type="submit" value="가입">
	</form>

</body>
</html>