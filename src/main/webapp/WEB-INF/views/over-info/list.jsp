<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

</head>
<body>
	<div class="d-flex justify-content-center mt-3">
		<h3>오버워치 게시판</h3>
	</div>
	<div class="container">
		<div class="form-group row mt-3 mb-3">
			<div class="col-auto">
				<select class="form-select" aria-label="Default select example"
					name="searchType" id="searchType">
					<option value="1">번호</option>
					<option value="2">이름</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input class="form-control" type="text"
					aria-label="default input example" type="text" name="searchStr"
					placeholder="검색어" id="searchStr">
			</div>
			<div class="col-auto">
				<button onclick="loadFunc()" type="button" class="btn btn-success">검색</button>
			</div>
		</div>
	</div>



	<div class="container">
		<table class="table table-hover" style="text-align: center;">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>역할</th>
					<th>국적</th>
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

			let url = '/over-info/list?';
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
						for (const over of list) {
							html += '<tr>';
							html += '<td>' + over.oiNum + '</td>';
							html += '<td>' + over.oiName + '</td>';
							html += '<td>' + over.oiPos + '</td>';
							html += '<td>' + over.oiNat + '</td>';
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
	<button>
		<a href="/over-info/insert">등록</a>
	</button>
</body>
</html>