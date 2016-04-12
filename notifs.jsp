<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#notifsec{
	position:fixed;
	width:93%;
	height:70%;
	margin:3%;
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
	height:95%;
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
}

.info{
	font-size:15px;
	font-style:bold;
}

.timestamp{
	font-size:10px;
	color:grey;
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
		<script src = "jquery-2.2.0.js"></src>
		<link href="jquery-ui.css" rel="stylesheet" type="text/css" />
		<script src="jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>    
			<div id = "notifsec">
			<div class = "head">Your Notifications</div>
			
			<div class = "list">
				<c:forEach items="${notifslist}" var="aNotif" begin="0" end="${fn:length(notifslist)}">
					<a href = "PerformNotificationServlet?notifType=${aNotif.notifType}&recipientID=${aNotif.recipientID}&senderID=${aNotif.senderID}">
					<div class = "row">
						<div class = "info">${aNotif.notifMessage}</div>
						<div class = "timestamp">${aNotif.timeStamp}</div>
					</div>
					</a>
				</c:forEach>
			</div>
			</div>

			
<script src="script.js"></script>	
<script src="loadToolBar.js"></script>	

</body>

</html>