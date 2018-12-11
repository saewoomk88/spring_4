<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./notice/noticeList?curPage=1">noticeList</a>
<hr>
<a href="./qna/qnaList">qnaList</a>
<hr>
<!-- not empty member -->
<c:choose>
	<c:when test="${member ne null }">
	<p><a href="./member/logOut">logout</a>
	<a href="./member/myPage">myPage</a>
	</c:when>
	<c:otherwise>
	<p>
<a href="./member/join">memberJoin</a>
<a href="./member/login">LOGIN</a></p>
	</c:otherwise>
	
</c:choose>

</p>
</body>
</html>
