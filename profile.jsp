<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logic.UserInfo"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${user.firstName} ${user.surName}</title>
<script src = "jquery-2.2.0.js"></script>
		<link href="jquery-ui.css" rel="stylesheet" type="text/css" />
		<script src="jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link rel="stylesheet" type="text/css" href="stylesProfile.css">
		
</head>
<body>    
    <div id="content" class="clearfix">
        <div id="left">
            <div id="userStats" class="clearfix">
                <div class="pic">
                    <a href="#"><img src="${user.dp}" width="150" height="150" /></a>
                </div>
                 
                <div class="data">
                    <h1>${user.firstName} ${user.surName}</h1>
                    <h3>${user.location}</h3>
                    <h4>${user.position}</h4>
                    <div class="sep"></div>
                    <ul class="numbers clearfix">
                        <li class = "withbrdr">Total Games<strong>${user.games_played}</strong></li>
                        <li class = "withbrdr">Wins<strong>${user.games_won}</strong></li>
                        <li>Losses<strong>${user.games_lost}</strong></li>
                    </ul>
                </div>
            </div>
				
				<div id = "about" class = "clearfix">
					<div class = "head"><h1>About Me <a href = "info.html">Edit Profile</a></h1></div>
					<div class = "boxy">
						<div class = "tabname">
							<li><a href="#" onclick="show('basicinfo')">Basic Information</a></li>
							<li><a href="#" onclick="show('contact')">Contact Details</a></li>
							<li><a href="#" onclick="show('education')">Work and Education</a></li>
						</div>
						<div class = "tabs" id = "basicinfo" style = "visibility:visible">
							<div class = "tabdetail"><c:out value="${myinfo.basicInfo}" /></div>
						</div>
						<div class = "tabs" id = "contact">
							<div class = "tabdetail"><c:out value="${myinfo.contactType}" /></div>
							<div class = "tabdetail"><c:out value="${myinfo.contactNum}" /></div>
						</div>
						<div class = "tabs" id = "education">
							<div class = "tabdetail"><c:out value="${myinfo.workPosition}" /></div>
							<div class = "tabdetail"><c:out value="${myinfo.institution}" /></div>
						</div>
						
					</div>
				</div>
        </div>
         
        <div id="right">
       		
			
			<div class="gcontent">
				<div class="head"><h1>Friends List (${fn:length(friendslist)})</h1></div>
				<div class="boxy">
			
					<div class="allfriendslist clearfix">
						<c:forEach items="${friendslist}" var="afriend" begin="0" end="${fn:length(friendslist)}">
							<div class = "friend">
						   		<img src="${afriend.dp}" width="30" height="30"/><span class="friendly"><a href="FriendServlet?param1=${afriend.username}"><c:out value="${afriend.firstName}"/> 
						   							<c:out value="${afriend.surName}" /></a></span>
						    </div>			    	    
						</c:forEach>	
						
					</div>
					
				</div>
			</div>
        </div>
    </div>
<script src="script.js"></script>	
<script src="loadToolBar.js"></script>	
<script>
	function show(tabName){
		var x = document.getElementsByClassName("tabs");
		var i;
		for (i = 0; i < x.length; i++) {
			if(x[i].style.visibility == "visible")
			  x[i].style.visibility = "hidden";
		}
		document.getElementById(tabName).style.visibility = "visible" ;
	}
</script>

</body>

</html>