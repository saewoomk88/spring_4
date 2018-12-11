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
		var check = false;
		$("#id").blur(function() {
			var id=$(this).val();
			$.get("./idCheck?id="+id, function(result) {
				result = result.trim();
				var msg = '사용할 수 없는 ID 입니다';
				if(result!=0){
					msg='사용 가능한 ID';
					check = true;
				}
				$("#result").html(msg);
			});
		})
		
		$("#btn").click(function() {
			if(check){
			$("#frm").submit();
				
			}else{
				alert("중복확인 하세요");
			}
		});
	});
</script>
</head>
<body>
	<h1>Member Join</h1>

	<form id="frm" action="./join" method="post">
		<div>ID :<input type="text" name="id" id="id"><p id="result"></p></div>
		<div>PW :<input type="password" name="pw"></div>
		<div>NAEM :<input type="text" name="name"></div>
		<div>EMAIL :<input type="email" name="email"></div>
		<div>PHONE :<input type="text" name="phone"></div>
		<div>ADDRESS :<input type="text" name="address"></div>
		<input type="button" value="가입" id="btn">
	</form>

</body>
</html>