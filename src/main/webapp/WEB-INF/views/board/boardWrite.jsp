<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${board} Write</h1>
<p>
	<form action="./${board}Write" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="text" name="writer">
		<textarea name="contents"></textarea>
		<input type="button" value="ADD">
		<div id="files">
			<div>
				<input type="file" name="f1"><span>X</span>
			</div>
		</div>
		
		<button>write</button>
	</form>
</p>

</body>
</html>