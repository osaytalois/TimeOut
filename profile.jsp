<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
                    <a href="#"><img src="dp1.jpg" width="150" height="150" /></a>
                </div>
                 
                <div class="data">
                    <h1>${user.firstName} ${user.surName}</h1>
                    <h3>London, England</h3>
                    <h4>${user.position}</h4>
                    <div class="sep"></div>
                    <ul class="numbers clearfix">
                        <li class = "withbrdr">Total Games<strong>50</strong></li>
                        <li class = "withbrdr">Wins<strong>50</strong></li>
                        <li>Losses<strong>0</strong></li>
                    </ul>
                </div>
            </div>
				
				<div id = "about" class = "clearfix">
					<div class = "head"><h1>About Me <a href = "info.html">Update</a></h1></div>
					<div class = "boxy">
						<div class = "tabname">
							<li><a href="#" onclick="show('basicinfo')">Basic Information</a></li>
							<li><a href="#" onclick="show('contact')">Contact Details</a></li>
							<li><a href="#" onclick="show('education')">Work and Education</a></li>
							<li><a href="#" onclick="show('events')">Events attended</a></li>
						</div>
						<div class = "tabs" id = "basicinfo" style = "visibility:visible">
							<div class = "tabdetail">Ganda ko daw.</div>
						</div>
						<div class = "tabs" id = "contact">
							<div class = "tabdetail">My mama don't like you.</div>
						</div>
						<div class = "tabs" id = "education">
							<div class = "tabdetail">
								<div class = "company">De La Salle University</div>
								<div class = "position">Student</div>
							</div>	
						</div>
						<div class = "tabs" id = "events">
							<div class = "tabdetail">I never liked to admit that I was wrong.</div>	
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
							<div class = "friend" onclick = "loadFriend()">
						   		<a href="#"><img src="" width="30" height="30"/></a><span class="friendly"><a href="#"><c:out value="${afriend.firstName}" /> <c:out value="${afriend.surName}" /></a></span>
						    </div>			    	    
						</c:forEach>	
						

					</div>
					
				</div>
			</div>
        </div>
    </div>
<script src="script.js"></script>	
<script src="loadToolBar.js"></script>	
	

</body>

</html>