<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Event</title>
		<script src = "jquery-2.2.0.js"></src>
		<link href="jquery-ui.css" rel="stylesheet" type="text/css" />
		<script src="jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link href = "stylesEvents.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
		<script src="script.js"></script>
		<script src="loadToolBar.js"></script>
		<%@ page import="java.util.Calendar,java.text.SimpleDateFormat,java.util.ArrayList,logic.User,logic.Event,implementation.EventService,logic.Post,implementation.PostService,implementation.UserDAO" %>
		<%!	Event a;
			User host;
			UserDAO uD = new UserDAO();%>
		<% a =  (Event)session.getAttribute("currentEvent"); 
			host = uD.getUserByID(a.getUserID());
			%>
		<div class = 'eventPopCurr'>
			<div class = 'eventPic' style = "background-image:url('<% out.print(a.getImgPath());%>')"></div>
			<div class = 'eventDetails'>
				<div class = 'eventDescElem'>
					<div class = 'eventTitles'>
						<span class = 'descriptionTitle'>Game Title:</span>
					</div>
					<div class = 'eventDescription'>
						<span class = 'descriptionInfo'><% out.print(a.getTitle()); %></span>
					</div>
				</div>
				<div class = 'eventDescElem'>
					<div class = 'eventTitles'>
						<span class = 'descriptionTitle'>Hosted By:</span>
					</div>
					<div class = 'eventDescription'>
						<span class = 'descriptionInfo'><% out.print(host.getUsername()); %></span>
					</div>
				</div>
				<div class = 'eventDescElem'>
					<div class = 'eventTitles'>
						<span class = 'descriptionTitle'>Venue:</span>
					</div>
					<div class = 'eventDescription'>
						<span class = 'descriptionInfo'><% out.print(a.getLocation()); %></span>
					</div>
				</div>
				<div class = 'eventDescElem'>
					<div class = 'eventTitles'>
						<span class = 'descriptionTitle'>Date and Time</span>
					</div>
					<div class = 'eventDescription'>
						<span class = 'descriptionInfo'><% Calendar cal = Calendar.getInstance();
						cal.add(Calendar.DATE, 1);
						SimpleDateFormat format1 = new SimpleDateFormat("EE, d MMM yyyy HH:mm");

						out.print(format1.format(a.getDate().getTime())); %></span>
					</div>
				</div>
				<div class = 'eventDescElem'>
					<div class = 'eventTitles'>
						<span class = 'descriptionTitle'>Description:</span>
					</div>
					<div class = 'eventDescription'>
						<span class = 'descriptionInfo'><% out.print(a.getDesc()); %></span>
					</div>
				</div>
				<div class = 'eventDescElem'>
					<div class = 'eventButt'>Update</div>
				</div>
			</div>
		</div>
		<script>
		</script>
		<script src="loadDP.js"></script>
		<%	out.println("<script> $(document).ready(function(){setDP(\""+((User)session.getAttribute("user")).getDp()+"\");}) </script>");%>
</body>
</html>