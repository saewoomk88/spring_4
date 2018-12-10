<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board} Update</h1>
<p>
	<form action="./${board}Update" method="post">
	<input type="hidden" name="num" value="${dto.num }">
	<input type="text" readonly="readonly" name="writer" value="${dto.writer}">
	<input type="text" name="title" value="${dto.title }">
	<textarea name="contents">${dto.contents }</textarea>
	
	<button>update</button>
	</form>
</p>

</body>
</html>