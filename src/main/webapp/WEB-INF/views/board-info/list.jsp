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
	<h3 style="text-align:center">발로란트 게시판</h3>
	<div class="container">

		<table class="table" style="text-align:center">
			<thead>
				<tr class="table-success">
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">작성시간</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardInfoList}" var="boardInfo">
					<tr>
						<th>${boardInfo.biNum }</th>
						<td><a href="/board-info/view?biNum=${boardInfo.biNum }">${boardInfo.biTitle }</a></td>
						<td>${boardInfo.uiNum }</td>
						<td>${boardInfo.credat }</td>
						<td>${boardInfo.cretim }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right"><button type="button" class="btn btn-success" onclick="goPage('/board-info/insert')">등록</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>