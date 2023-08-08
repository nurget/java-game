<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>유저 리스트</h3>
	<select name="searchType" id="searchType">
		<option value="1">번호</option>
		<option value="2">이름</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button onclick="loadFunc()" type="button" class="btn btn-success">검색</button>
	<div class="container">
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>생일</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="tBody">

			</tbody>
		</table>
	</div>

	<script>
		const loadFunc = function() {
			const xhr = new XMLHttpRequest();
			const searchStr = document.querySelector('#searchStr');
			const searchType = document.querySelector('#searchType');

			let url = '/user-info/list?';
			if (searchStr.value != '') {
				url += 'searchType=' + searchType.value + '&searchStr='
						+ searchStr.value;
			}

			xhr.open('GET', url);
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						const list = JSON.parse(xhr.responseText);
						let html = '';
						for (const user of list) {
							html += '<tr>';
							html += '<td>' + user.uiNum + '</td>';
							html += '<td>' + user.uiName + '</td>';
							html += '<td>' + user.uiId + '</td>';
							html += '<td>' + user.uiBirth + '</td>';
							html += '<td>' + user.credat + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();

		}
		window.addEventListener('load', loadFunc);
	</script>
	<a href="/user-info/insert">등록</a>
</body>
</html>