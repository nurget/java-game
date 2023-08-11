<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/input">
		이름 : <input type="text" name="name"><br>
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		자기소개 : <textarea name="desc"></textarea><br>
		성별 : <input type="radio" name="trans" value="남">남 <input type="radio" name="trans" value="여">여<br>
		직업 : 
		<select name="job">
			<option value="">선택</option>
			<option value="개발자">개발자</option>
			<option value="백수">백수</option>
		</select>
		<button>저장</button>
	</form>
</body>
</html>