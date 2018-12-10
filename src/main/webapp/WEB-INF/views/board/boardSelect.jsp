<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var msg = '${msg}';
		if(msg !=""){
			alert(msg);
		}
		
		$("#del").click(function() {
			$("#frm").submit();
		});
		
	});
</script>
</head>
<body>

<h1>${board }Select</h1>
<h1>num : ${dto.num }</h1>
<h1>title : ${dto.title }</h1>
<h1>writer : ${dto.writer }</h1>
<h1>contents : ${dto.contents}</h1>

<a href="./${board}List">${board}List</a>
<a href="./${board}Update?num=${dto.num}">${board}Update</a>
<span id="del">${board}Delete</span>
<form id="frm" action="./${board}Delete" method="post">
	<input type="hidden" name="num" value="${dto.num }">
</form>
<c:if test="${board ne 'notice'}">
<a href="./${board}Reply?num=${dto.num}">${board}Reply</a>
</c:if>
</body>
</html>