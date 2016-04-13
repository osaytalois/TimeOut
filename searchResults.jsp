<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.User" %>
<%@page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#container{
	position:fixed;
	width: 93%;
	height: 70%;
	margin: 3%;
}
		
.head{
	font-family:sans-serif; 
	font-size:1.3em;
	color:white;
	text-align:left;
	padding:2px;
	padding-left:8px;
	border-bottom: 3px solid black;
	background:red;
	opacity:0.7;
	margin-top:40px;			
}

.list{
	position:relative;
	height: 95%;
	margin-top:2px;
	overflow-y:scroll;
}

.row{
	width:98%;
	height:25px;
	font-size:14px;
	color: red; 
	background-color:white;
	padding:8px;
	border:0px;
	border-bottom:1px;
	border-style:solid;
	border-color:black;
	opacity:0.7;
	float:right;
}

.no_results{
	width:98%;
	height:25px;
	font-size:14px;
	color: red; 
	background-color:white;
	padding:8px;
	opacity: 0.7;
}
.dp{
	height: 27px;
	width: 27px;
	border: 1px;
	//background-color: orange;
	float: left;
	margin-right: 5px;
	border: 1px solid;
	background-repeat:no-repeat;
    background-size:cover;
}
.user_name{
	font-size:18px;
	font-style:bold;
}

.user_info{
	font-size:13px;
	color: grey;
}
.row:hover{
	background-color:black;
	color:white;
	border-color:black;
	-webkit-transition: all 0.25s; /* For Safari 3.1 to 6.0 */
	transition: all 0.25s;
	cursor:pointer;
}
a{
	text-decoration:none;
}

	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Timeout</title>
	<script src= "jquery-2.2.0.js"></script>
	<link href= "jquery-ui.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="styles.css" />
	<script src="jquery-ui.js"></script>
</head>
<body>
	<div id = "container">
			<div class = "head">Search Results</div>
			<div class = "list">
				<c:forEach items="${searchUsers}" var="searchResult" begin="0" end="${fn:length(searchUsers)}">
						<c:choose>
						<c:when test="${searchResult.username != 'null'}">
							<a href = "PerformSearchProfile?username=${searchResult.username}">
								<div class = "row">
									<div class = "dp" style="background-image: url('${searchResult.dp}');"></div>
									<div class = "user_name">${searchResult.firstName} ${searchResult.surName} | ${searchResult.position}</div>
								</div>
							</a>
						</c:when>
						<c:otherwise>
							<div class = "no_results">
								loop! No Search Results found!
							</div>
						</c:otherwise>
						</c:choose>
				</c:forEach>
			</div>
			</div>

<script src="script.js"></script>	
<script src="loadToolBar.js"></script>
</body>
</html>