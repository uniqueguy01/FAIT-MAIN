<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="head.jsp"></jsp:include>

<script type="text/javascript" src="/resources/js/cart.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<h3>장바구니</h3>
		</div>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>제품번호</th>
						<th>제품명</th>
						<th>수량</th>
						<th>단가</th>
						<th>주문금액</th>
						<th>관리</th>
					</tr>
				</thead>
			
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">장바구니에 등록 된 제품이 없습니다</td>
						</tr>
					</c:if>	
					
					<c:forEach var="item" items="${list}">
						<c:set var="amount" value="${cart.cart.get(item.id)}"></c:set>
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${amount}</td>
							<td>${item.price}</td>
							<td>${item.price * amount}</td>
							<td><button class="btn btn-sm btn-danger delete" data-id="${item.id}">삭제</button></td>
						</tr>
					</c:forEach>	
				</tbody>	
			</table>
		</div>
		
		<div class="row">
			<div class="col"></div>
			<div class="col-2"><a href="/orders" class="btn btn-sm btn-primary d-grid">주문</a></div>
			<div class="col-2"><a href="." class="btn btn-sm btn-secondary d-grid">처음으로</a></div>
		</div>
	</div>
</body>
</html>