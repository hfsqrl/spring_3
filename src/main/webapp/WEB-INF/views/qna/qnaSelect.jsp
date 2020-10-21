<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna Select</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="./qna/qnaList">QnA</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <h3>QnA Select Page</h3>
  
  <h3 id="num">${dto.num}</h3>
  <h3>Title : ${dto.title}</h3>
  <h3>Writer : ${dto.writer}</h3>
  <h3>Contents : ${dto.contents}</h3>
  
  <input type="button" title="${dto.num}" value="Delete" class="btn btn-warning" id="del">
  <input type="button" class="btn btn-primary" value="Update" id="update">
  
</div>

<script type="text/javascript">
	// $("css 선택자").메서드();
	$("#update").click(function () {v
		location.href="./qnaUpdate?num=${dto.num}"
	})
	
	$("#del").click(function() {
		// var num = $("#num").html()
		var num = $(this).attr("title")
		alert(num);
		location.href="./qnaDelete?num="+num;
		
	});
</script>

</body>
</html>