<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<h3 style="text-align: center">게시물 수정</h3>
	<div class="container">
		<form method="POST" action="/board-info/update">
		<input type="hidden" name="biNum" value="${board.biNum }">
			<div class="form-group">
				<label for="biTitle">제목</label> 
				<a href="#" class="badge badge-success">Title</a>
				
				<input type="text" class="form-control"
					id="biTitle" name="biTitle" placeholder="제목" value="${board.biTitle }">
			</div>
			<div class="form-group">
				<label for="biContent">내용</label>
				<a href="#" class="badge badge-success">Content</a>
				<textarea class="form-control" id="biContent" name="biContent" placeholder="내용" value="${board.biContent }"></textarea>
			</div>
		 	<div class="button-div" style="align:right">
			<button type="submit" class="btn btn-outline-success">수정</button>
			</div>
		</form>
	</div>
</body>
</html>