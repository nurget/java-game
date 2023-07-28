<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<h3 style="text-align: center">게시판 상세화면</h3>
	<div class="container">
		<form method="POST" action="/board-info/delete">
			<input type="hidden" name="biNum" value="${board.biNum}">
			<table class="table table-borderless">

				<thead>
					<tr>
						<th scope="col">번호</th>
						<td>${board.biNum}</td>
					</tr>
					<tr>
						<th scope="col">제목</th>
						<td>${board.biTitle}</td>
					</tr>
					<tr>
						<th scope="col">내용</th>
						<td>${board.biContent}</td>
					</tr>
					<tr>
						<th scope="col">작성자</th>
						<td>${board.uiNum}</td>
					</tr>
					<tr>
						<th scope="col">작성일</th>
						<td>${board.credat}</td>
					</tr>
					<tr>
						<th scope="col">작성시간</th>
						<td>${board.cretim}</td>
					</tr>
					<tr>
						<th scope="col">최종수정일</th>
						<td>${board.lmodat}</td>
					</tr>
					<tr>
						<th scope="col">최종수정시간</th>
						<td>${board.cretim}</td>
					</tr>
					<c:if test="${user.uiNum == board.uiNum }">
						<tr class="text-right">
							<th colspan="2" style="align-item:right">
								<button type="button" class="btn btn-primary" onclick="goPage('/board-info/update?biNum=${board.biNum}')">수정</button>
								<button type="button" class="btn btn-danger">삭제</button>
							</th>
						</tr>
					</c:if>
				</thead>
			</table>
		</form>
		<script>
			function goPage(url) {
				location.href = url;
			}
		</script>
	</div>
</body>
</html>