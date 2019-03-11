<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
	<title>EmployeeList</title>
</head>
<body>
	<h3>사원 목록</h3>
	<div id="content">
		<div id="content_search">
			<select name="serch" id="searchOption">
				<option value="all">전체 조회</option>
				<option value="name">이름</option>
				<option value="empno">사원번호</option>
				<option value="deptno">부서명</option>
			</select> 
			<input id="searchWord" type="text" placeholder="검색어 입력" /> 
			<input type="button" id="searchButton" value="검색" />
		</div>
		<div id="content_list">
			<table id="employee_list">
				<tr>
					<th>사원 번호</th>
					<th>이 름</th>
					<th>직 책</th>
					<th>직속 상관</th>
					<th>입사 날짜</th>
					<th>연 봉</th>
					<th>상여 금액</th>
					<th>해당 부서</th>
				</tr>
				<c:forEach items='${list}' var='employee'>
					<tr>
						<td>${employee.empNo}</td>
						<td>${employee.eName}</td>
						<td>${employee.job}</td>
						<td>${employee.mgr}</td>
						<td>${employee.hireDate}</td>
						<td>${employee.sal}</td>
						<td>${employee.comm}</td>
						<td>${employee.deptNo}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script>	
		document.getElementById('searchButton').onclick = function () {
			location.href = "<%= application.getContextPath()%>/employee.do?option="+document.getElementById('searchOption').value+"&word="+document.getElementById('searchWord').value;
		};
	</script>
</body>
</html>