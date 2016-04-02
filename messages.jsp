<!Doctype html>
<html>
	<head>
		<script src="jquery-2.2.0.js"></script>
		<link href="jquery-ui.css" rel="stylesheet" type="text/css" />
		<script src="jquery-ui.js"></script>
		<link href = "styles.css" rel = "stylesheet" type = "text/css"/>
		<link href = "stylesMessage.css" rel = "stylesheet" type = "text/css"/>
		<script src="script.js"></script>
		<script src="loadToolBar.js"></script>
	</head>
	<body>
		<%@ page import="java.util.ArrayList,logic.User,logic.Message,implementation.MessageService,implementation.UserDAO" %>
		<%!	UserDAO uD = new UserDAO();
			MessageService p = new MessageService();
			ArrayList<Message> mssgs = new ArrayList<Message>();
			ArrayList<User> users = new ArrayList<User>();
			int pTCtr;
			String uname; 
			String others;
			User myUser;%>
		<% 	myUser = uD.getUserByUsername(session.getAttribute("user").toString());
			if(session.getAttribute("talkingWith")==null)
				session.setAttribute("talkingWith", p.getTop(myUser.getIdUser()));
			mssgs = p.getAllMessages(myUser.getIdUser(), uD.getUserByUsername(session.getAttribute("talkingWith").toString()).getIdUser());
			//users = p.getAllUserTalked(myUser.getIdUser());%>
		<div class = "content">
			<div style = "float:left;height:100%;width:20%;margin:0;padding:0;">
				<div class = "personFilter">
					<form action = "javascript:search()">
						<input type = "text" class = "personSearch" placeholder = "Enter a name/username" onFocus = "this.placeholder='Enter a name/username'" onBlur = "this.placeholder = 'Enter a name/username'"> </text>
						<div class = "addButton" onclick = "addPerson()">+</div>
					</form>
				</div>
				<div class = "personNav">
			<%
			for(int i = 0; i < users.size(); i++){
				out.println("<div class = 'personHolder' onclick = 'personClick()'>");
				out.println("<div class = 'who' style = 'float:left;'></div>");
				out.println("<div class = 'person'>");
				out.println(users.get(i).getUsername());
				out.println("</div></div>");
			}%>
				</div>
			</div>
			<div class = "messNav">
			</div>
			<form action = "javascript:send()" class = "message">
				<textarea class = "toSend" value = "" placeholder = "Send a Message">
				</textarea>
				<div class = "sendButton" onclick = "send()">Send</div>
			</form>
		</div>
		<script>
			$(".toSend").val("");
			var justSent = true;
			var justReced = true;
			var x = 0;
			for(var i = 0; i < 2; i++){ //add Person1 and Person2 and load their messages
				$newPH = $("<div></div>");
				$($newPH).addClass("personHolder");
				$newP = $("<div></div>");
				$($newP).addClass("person");
				$($newP).html("Person"+(i+1));
				$personDP = $("<div></div>");
				$($personDP).addClass("who");
				$($personDP).css("float", "left");
				$($newPH).append($personDP);
				$($newPH).append($newP);
				$($newPH).attr("id", "person"+(i));
				$(".personNav").append($newPH);
				$($newPH).click(function(){
					localStorage.setItem("person"+x, $(".messNav").html());
					$("#person"+x).css("borderColor", "black");
					$("#person"+x).css("backgroundColor", "black");
					$(".messNav").empty();
					$(".messNav").append(localStorage.getItem($(this).attr("id")));
					x = parseInt($(this).attr("id").replace( /^\D+/g, ''));
					$(this).css("borderColor", "red");
					$(this).css("backgroundColor", "grey");
					toBottom(".messNav");
				});
			}
			$("#person0").css("borderColor", "red");
			$("#person0").css("backgroundColor", "grey");
			if(parseInt(localStorage.getItem("fromProfile")) == 1){//add the person in nav if from profile
				$newPH = $("<div></div>");
				$($newPH).addClass("personHolder");
				$newP = $("<div></div>");
				$($newP).addClass("person");
				$($newP).html(localStorage.getItem("fromName"));
				$personDP = $("<div></div>");
				$($personDP).addClass("who");
				$($personDP).css("float", "left");
				$($newPH).append($personDP);
				$($newPH).append($newP);
				$($newPH).attr("id", "person"+($( ".personNav .personHolder" ).last().index()+1));
				$($newPH).css("borderColor", "red");
				$($newPH).css("backgroundColor", "grey");
				localStorage.setItem("person"+x, $(".messNav").html());
				$("#person"+x).css("borderColor", "black");
				$("#person"+x).css("backgroundColor", "black");
				$(".messNav").empty();
				$(".messNav").append(localStorage.getItem($(this).attr("id")));
				x = $( ".personNav .personHolder" ).last().index()+1;
				$(".personNav").prepend($newPH);
				$($newPH).click(function(){
					localStorage.setItem("person"+x, $(".messNav").html());
					$("#person"+x).css("borderColor", "black");
					$("#person"+x).css("backgroundColor", "black");
					$(".messNav").empty();
					$(".messNav").append(localStorage.getItem($(this).attr("id")));
					x = parseInt($(this).attr("id").replace( /^\D+/g, ''));
					$(this).css("borderColor", "red");
					$(this).css("backgroundColor", "grey");
					toBottom(".messNav");
				});
				$(".personSearch").val("");
			}
			function personClick(){
				localStorage.setItem("person"+x, $(".messNav").html());
				$("#person"+x).css("borderColor", "black");
				$("#person"+x).css("backgroundColor", "black");
				$(".messNav").empty();
				$(".messNav").append(localStorage.getItem($(this).attr("id")));
				x = parseInt($(this).attr("id").replace( /^\D+/g, ''));
				$(this).css("borderColor", "red");
				$(this).css("backgroundColor", "grey");
				toBottom(".messNav");
			}
			function addPerson(){
				$newPH = $("<div></div>");
				$($newPH).addClass("personHolder");
				$newP = $("<div></div>");
				$($newP).addClass("person");
				$($newP).html($(".personSearch").val());
				$personDP = $("<div></div>");
				$($personDP).addClass("who");
				$($personDP).css("float", "left");
				$($newPH).append($personDP);
				$($newPH).append($newP);
				$($newPH).attr("id", "person"+($( ".personNav .personHolder" ).last().index()+1));
				$($newPH).css("borderColor", "red");
				$($newPH).css("backgroundColor", "grey");
				localStorage.setItem("person"+x, $(".messNav").html());
				$("#person"+x).css("borderColor", "black");
				$("#person"+x).css("backgroundColor", "black");
				$(".messNav").empty();
				$(".messNav").append(localStorage.getItem($(this).attr("id")));
				x = $( ".personNav .personHolder" ).last().index()+1;
				$(".personNav").prepend($newPH);
				$($newPH).click(function(){
					localStorage.setItem("person"+x, $(".messNav").html());
					$("#person"+x).css("borderColor", "black");
					$("#person"+x).css("backgroundColor", "black");
					$(".messNav").empty();
					$(".messNav").append(localStorage.getItem($(this).attr("id")));
					x = parseInt($(this).attr("id").replace( /^\D+/g, ''));
					$(this).css("borderColor", "red");
					$(this).css("backgroundColor", "grey");
				});
				$(".personSearch").val("");
			}
			function send(){
				if($("div[class = messNav] div").last()!=null)
					justSent = $("div[class = messNav] div.pattern1").last().hasClass("sender");
				else
					justSent = false;
				var message = $(".toSend").val();
				//fix message
				//fix /Ns here
				message = message.replace("\n", "</br>");
				$newMess = $("<div></div>");
				$($newMess).addClass("sent");
				$($newMess).addClass("messageDisplay");
				$($newMess).html(message);
				$container = $("<div style = 'width:100%;clear:both;'></div>");
				$($container).addClass("pattern1");
				$($container).addClass("sender");
				$dp = $("<div></div>");
				if(!justSent){
					$($dp).addClass("who");
					$name = $("<div></div>");
					$($name).addClass("me");
					$($name).html("me");
					$($container).append($dp);
					$($container).append($name);
					$container2 = $("<div style = 'width:100%;clear:both;'></div>");
					$($container2).addClass("pattern1");
					$($container2).addClass("sender");
					$dp2 = $("<div></div>");
					$($dp2).addClass("whohide");
					$($dp2).css("float", "left");
					$($container2).append($dp2);
					$($container2).append($newMess);
					$(".messNav").append($container);
					$(".messNav").append($container2);
				}
				else{
					$($dp).addClass("whohide");
					$($container).append($dp);
					$($container).append($newMess);
					$(".messNav").append($container);
				}
				if($($newMess).width()>($(".messNav").width()*0.85|0)){
					$newMess.css("width", $(".messNav").width()*0.85|0+"px");
					//$($message).css("width", $($newMess).width()*0.99|0+"px");
				}
				console.log($($newMess).width());
				console.log($($newMess).width()*0.9|0);
				//console.log($($message).width());
				$($dp).css("float", "left");
				$(".toSend").val("");
				
				var number = 1 + Math.floor(Math.random() * 2);
				if(number == 1){
					if($("div[class = messNav] div").last()!=null)
						justReced = $("div[class = messNav] div.pattern1").last().hasClass("receiver");
					else
						justReced = false;
					var message2 = "abhdnsiafmsjm";
					//$message2 = $("<span></span>").html(message2.replace("\n", "</br>"));
					message2 = message2.replace("\n", "</br>");
					$newMess2 = $("<div></div>");
					$($newMess2).addClass("received");
					$($newMess2).addClass("messageDisplay");
					$($newMess2).append(message2);
					$container3 = $("<div style = 'width:100%;clear:both;'></div>");
					$($container3).addClass("pattern1");
					$($container3).addClass("receiver");
					$dp3 = $("<div></div>");
					if(!justReced){
						$($dp3).addClass("who2");
						$name2 = $("<div></div>");
						$($name2).addClass("them");
						$($name2).html("receiver");
						$($container3).append($dp3);
						$($container3).append($name2);
						$container4 = $("<div style = 'width:100%;clear:both;'></div>");
						$($container4).addClass("pattern1");
						$($container4).addClass("receiver");
						$dp4 = $("<div></div>");
						$($dp4).addClass("whohide");
						$($dp4).css("float", "left");
						$($container4).append($dp4);
						$($container4).append($newMess2);
						$(".messNav").append($container3);
						$(".messNav").append($container4);
					}
					else{
						$($dp3).addClass("whohide");
						$($container3).append($dp3);
						$($container3).append($newMess2);
						$(".messNav").append($container3);
					}
					if($($newMess2).width()>($(".messNav").width()*0.85|0)){
						$newMess2.css("width", $(".messNav").width()*0.85|0+"px");
						//$($message2).css("width", $($newMess2).width()*0.99|0+"px");
					}
					$($dp3).css("float", "left");
				}
				toBottom(".messNav");
			}
			function toBottom(x){
			  var parent = $(x);
			  var height = parent[0].scrollHeight;
			  parent.scrollTop(height);
			}
			function search(){
			}
			$(window).load(function(){
				$(".content").css("width", (screen.width*0.95|0)+"px");
				$(".content").css("visibility", "visible");
				//console.log(screen.width*0.95|0);
			});
		</script>
	</body>
</html>