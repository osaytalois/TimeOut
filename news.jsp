<!DOCTYPE html>
<html>
	<head>
		<title>News Feed</title>
		<script src = "jquery-2.2.0.js"></src>
		<link href="jquery-ui.css" rel="stylesheet" type="text/css" />
		<script src="jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link rel="stylesheet" type="text/css" href="stylesNews.css">
	</head>
	<body>
		<script src="script.js"></script>
		<script src="loadToolBar.js"></script>
		<%@ page import="java.util.ArrayList,logic.User,logic.Post,implementation.PostService,implementation.UserDAO" %>
		<%!	UserDAO uD = new UserDAO();
			PostService p = new PostService();
			ArrayList<Post> aLP = new ArrayList<Post>();
			int pTCtr;
			User uname;
			%>
		<%	
			if(session.getAttribute("pTCtr")==null)
				session.setAttribute("pTCtr", 0);
			%>
		<%	uname  = (User)session.getAttribute("user");
			aLP = p.getAllMyPost(uname.getUsername());
			pTCtr = Integer.parseInt(session.getAttribute("pTCtr").toString());
			%>
			<!--The Whole Left Pane-->
			<div id = "leftPane"> 
				<div class = "lPTitle">Events
					<div style = "float:right; font-size:15px; padding:5px;"> <a class = "anchor" href="" onclick = "loadEvent()">More</a></div>
				</div>
					<div id = "host" class = "lPSubTitle">Games Hosted</div><!--The Subtitles-->
					<div id = "join" class = "lPSubTitle">Games Joined In</div>
					<div id = "invite" class = "lPSubTitle">Games Invited To</div>

			</div>
			<!--The Whole Right Plane-->
			<div id = "rightPane">
				<form name = "myForm" method = 'POST'>
					<div class = "toolButtons postButton" style = "color:lightgrey;background-color:red;width:90%;margin:5%;" onClick = "reload">Load New Posts</div>
					<textArea id = "textPostArea" name = 'toPost' cols = "40" rows = "10" style = 'width:95%;height:100px;margin:3px;border-radius:3px;'></textArea></BR>
					<div class = "toolButtons postButton" style = "color:lightgrey;background-color:red;margin:5px;" onClick = "postToServlet()">Post</div>
				</form>
			</div>
			<!--The News-->
			<div id = "midPane"><!-- A single News in the Feed-->
			<%
				for(int i = aLP.size()-1; i>=0; i--){
					out.println("<div class = 'news'>");
					out.println("<div class = 'dp' style='background-image: url(\""+uname.getDp()+"\"); background-color: black; background-size: 50px; background-position: 50% 50%; background-repeat: no-repeat;'>");
					out.println("</div>");
					out.println("<div class='nameTime'>");
					out.println("<a href class = 'username anchor'>"+uD.getUserByID(aLP.get(i).getUserID()).getUsername()+"</a></br>");
					java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("EE, d MMM yyyy HH:mm:ss");
		            String timeNow = sDF.format(aLP.get(i).getDate());
		            out.println(timeNow);
					out.println("</div>");
					out.println("<p>"+aLP.get(i).getPost()+"</p>");
					out.println("</div>");
				}
				%>
			</div>
		<script>
			
			//var aLP = ${aLP};
			
			/*addNews("lois.jpg", "John Cena", "6:45 pm", "JOHN CENAAA!!!! IN DA HAUS!!!");
			addNews("dp2.jpg", "John Adriel Benolirao", "6:55 pm", "Won the battle against CHINA");
			addNews("dp1.jpg", "Lois Osayta", "6:56 pm", "Lost againt the Phils...");*/
			$extra = $("<div style = 'height:100px; clear:both;'>");
			$("#midPane").append($extra);
			$($extra).remove();
			/*addNews("profile1.png", "Isaac Lim", "7:00 pm", "I don t know which side to choose");
			addNews("profile1.png", "Jaimie Bringas", "7:02 pm", "GO ARCHERS!!!");
			addNews("profile1.png", "Anton de Joya", "7:05 pm", "Way to go pacers!!!");
			addNews("profile1.png", "Macario Cordel", "7:07 pm", "Gonna play some game later.\nWishing I have some time to start some warm-ups.");
			*/$("#midPane").append($extra);
			addHosted("Loopers Vs The Ringers");
			addHosted("Alpha vs Omega");
			addJoined("The Great Stainz");
			addInvited("Great Wall Shall Fall");
			function postToServlet(){
				document.myForm.action = "PostServlet";
				document.myForm.submit();
				$("#textPostArea").setText("");
			}
			function addNews(image, name, time, story){
				$newNews = $("<div></div>");
				$($newNews).addClass("news");//the whole news div has been created
				$newDP = $("<div></div>");
				$($newDP).addClass("dp");//DP div has been created
				$($newDP).css("background-image", "url("+image+")");
				$($newDP).css("background-size", "50px");
				$($newDP).css("background-repeat", "no-repeat");
				$($newDP).css("background-position", "center");
				$($newDP).css("background-color", "black");
				$newNamePost = $("<div></div>");
				$($newNamePost).addClass("nameTime");//nameTime has been created
				$newNameLink = $("<a href = ''></a>");
				$($newNameLink).addClass("username");
				$($newNameLink).addClass("anchor");
				$($newNameLink).click(function(){loadFriend();});
				$($newNameLink).click(function(e){
					// Special stuff to do when this link is clicked...
					// Cancel the default action
					e.preventDefault();
				});
				$($newNamePost).append($newNameLink);//link created, name post has been appended
				$($newNameLink).append(name);
				$($newNamePost).append($("</br>"));
				$($newNamePost).append(time);
				$($newNews).append($newDP);//append dp to the story
				$($newNews).append($newNamePost);//append nameTime to the story
				$story = $("<p></p>");//story will be appended here
				story = story.replace("\n", "</br>");
				$($story).append(story);//place the post inside this string
				$($newNews).append($story);//append the post to the story
				$("#midPane").append($newNews);//append the new Story
			}
			function addHosted(eventName){
				$temp = $("<div></div>");
				$($temp).addClass("lPLink");
				$($temp).html(eventName);
				$($temp).click(function(){
				});
				$("#host").after($temp);
			}
			function addJoined(eventName){
				$temp = $("<div></div>");
				$($temp).addClass("lPLink");
				$($temp).html(eventName);
				$($temp).click(function(){
				});
				$("#join").after($temp);
			}
			function reload(){
				window.location.href = "news.jsp";
			}
			function addInvited(eventName){
				$temp = $("<div></div>");
				$($temp).addClass("lPLink");
				$($temp).html(eventName);
				$($temp).click(function(){
				});
				$("#invite").after($temp);
			}
			$(window).load(function(){
				$("#leftPane").css("width", (screen.width*0.25|0)+"px");
				$("#rightPane").css("width", (screen.width*0.25|0)+"px");
				$("#rightPane").css("left", (screen.width*0.73|0)+"px");
				$("#midPane").css("width", (screen.width*0.46|0)+"px");
				$("#midPane").css("left", (screen.width*0.26|0)+"px");
				$("#leftPane").css("visibility", "visible");
				$("#rightPane").css("visibility", "visible");
				$("#midPane").css("visibility", "visible");
				//console.log(screen.width*0.95|0);
			});
		</script>
		<script src="loadDP.js"></script>
		<%	out.println("<script> $(document).ready(function(){setDP(\""+uname.getDp()+"\");}) </script>");%>
	</body>
</html>