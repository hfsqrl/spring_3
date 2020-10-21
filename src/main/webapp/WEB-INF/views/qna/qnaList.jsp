<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna list jsp</title>

<c:import url="../template/bootstrap.jsp"></c:import>

</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
  
<div class="container">
	<h3>QnA List</h3>
	<div class="row">
	<div class="col-sm-5">
		<form action="./QnaList">
			<div class="input-group">
				<select class="input-group-sm" id="sel1" name="kind">
					<option value="tt">Title</option>
					<option value="wr">Writer</option>
					<option value="con">Contents</option>
				</select>
				
				<input id="msg" type="text" class="form-control" name="search" placeholder="Additional Info">
			
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
			    </div>
			</div>
		</form>
	</div>
	</div>
  
  <table class="table table-hober">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	<c:forEach items="${lists}" var="dto" varStatus="vs">
  		<tr>
  			<td>${dto.num} : ${vs.last} </td>
  			<td>
	  			<a href="./QnaSelect?num=${dto.num}">
		  			<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
		  			${dto.title}
	  			</a>
	  		</td>
  			<td>${dto.writer}</td>
  			<td>${dto.regDate}</td>
  			<td>${dto.hit}</td>
  		</tr>
  		
  	</c:forEach>
  </table>
  
	<div>
	
		<c:if test="${pager.beforeCheck}">
			<a href="./QnaList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">[이전]</a>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	  		<a href="./QnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
	  	</c:forEach>
	  	
	  	<c:if test="${pager.nextCheck}">
		<a href="./QnaList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a>
		</c:if>
		
	</div>
  
	<a href="./QnaWrite" class="btn btn-danger">Write</a>
  
</div>

</body>
</html>