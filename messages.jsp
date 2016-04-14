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
		<%@ page import="java.util.ArrayList,logic.User,logic.Recent, logic.Message,implementation.MessageService,implementation.UserDAO" %>
		<%!	UserDAO uD = new UserDAO();
			MessageService p = new MessageService();
			ArrayList<Message> mssgs = new ArrayList<Message>();
			ArrayList<User> users = new ArrayList<User>();
			ArrayList<Recent> recents = new ArrayList<Recent>();
			int pTCtr;
			int justSent = 0;
			int justReced = 0;
			String uname; 
			String others;
			User myUser;
			User other;%>
		<% 	myUser = ((User)session.getAttribute("user"));
			recents = p.getAllRecent(myUser.getIdUser());%>
		<div class = "content">
			<div style = "float:left;height:100%;width:20%;margin:0;padding:0;">
					<form class = "personFilter" name = "messageAddForm" method = "GET">
						<input type = "text" class = "personSearch" style = 'float:left;' placeholder = "Enter a username" onFocus = "this.placeholder='Enter a username'" onBlur = "this.placeholder = 'Enter a username'"> </input>
						<div id = "refresh" class = "addButton" onclick = "refreshPNavForm()"></div>
						<div class = "addButton" style = 'float:left;' onclick = "addPersonForm()">+</div>
						<input type = "hidden" name = "tempMessageSearch" id = "hidemssgsearch"></input>
					</form>
				<div class = "personNav">
					<form name = "choosePerson" method = "GET" class = "persons">
						<%
						for(int i = 0; i < recents.size(); i++){
							if(session.getAttribute("talkingWith")!=null){
								int talkingWith = ((User)session.getAttribute("talkingWith")).getIdUser();
								if(recents.get(i).getRecipient() == talkingWith)
									out.println("<div id = 'person"+i+"' class = 'personHolder' style = 'border-color:red; background-color: grey;' onclick = 'personClick("+recents.get(i).getRecipient()+")'>");
								else
									out.println("<div id = 'person"+i+"' class = 'personHolder' style = 'border-color:black; background-color: black;' onclick = 'personClick("+recents.get(i).getRecipient()+")'>");
								out.println("<div class = 'who' style = 'float:left;background-image:url(\""+uD.getUserByID(recents.get(i).getRecipient()).getDp()+"\");'></div>");
								out.println("<div class = 'person'>");
								out.println(uD.getUserByID(recents.get(i).getRecipient()).getUsername());
								out.println("</div></div>");
							} else{
								if(i == 0){
									out.println("<div id = 'person"+i+"' class = 'personHolder' style = 'border-color:red; background-color: grey;' onclick = 'personClick("+recents.get(i).getRecipient()+")'>");
									session.setAttribute("talkingWith", uD.getUserByID(recents.get(i).getRecipient()));
								}else
									out.println("<div id = 'person"+i+"' class = 'personHolder' style = 'border-color:black; background-color: black;' onclick = 'personClick("+recents.get(i).getRecipient()+")'>");
								out.println("<div class = 'who' style = 'float:left;background-image:url(\""+uD.getUserByID(recents.get(i).getRecipient()).getDp()+"\")''></div>");
								out.println("<div class = 'person'>");
								out.println(uD.getUserByID(recents.get(i).getRecipient()).getUsername());
								out.println("</div></div>");
							}
						}%>
						<input type = "hidden" name = "tempPersonClick" id = "hidePersonClick"></input>
					</form>
				</div>
			</div>
			<div class = "messNav">
				<%	if((User)session.getAttribute("talkingWith")!=null){
						mssgs = p.getAllMessages(myUser.getIdUser(), ((User)session.getAttribute("talkingWith")).getIdUser());
						other = (User)session.getAttribute("talkingWith");
						if(mssgs!=null){
							for(int i = 0; i < mssgs.size(); i++){
								if((i!=0)&&(mssgs.get(i).getUserID() != mssgs.get(i-1).getUserID()))
									justSent = 1;
								else if(i==0)
									justSent = 1;
								else
									justSent = 0;
								if((i!=0)&&(mssgs.get(i).getReceiveID() != mssgs.get(i-1).getReceiveID()))
									justReced = 1;
								else if(i==0)
									justReced = 1;
								else
									justReced = 0;
								if(mssgs.get(i).getUserID() ==  myUser.getIdUser()){
									if(justSent == 1){
										out.println("<div class = 'pattern1 sender' style = 'width:100%;clear:both;'>");
											out.println("<div class = 'who' style = 'float:left;background-image:url(\""+uD.getUserByID(mssgs.get(i).getUserID()).getDp()+"\");'>");
											out.println("</div>");
											out.println("<div class = 'me'>me</div>");
										out.println("</div>");
									}
									out.println("<div class = 'pattern1 sender' style = 'width:100%;clear:both;'>");
										out.println("<div style = 'float:left;' class = 'whohide'>");
										out.println("</div>");
										out.println("<div class = 'sent messageDisplay'>"+mssgs.get(i).getMessage()+"</div>");
									out.println("</div>");
								}
								else{
									if(justReced == 1){
										out.println("<div class = 'pattern1 receiver' style = 'width:100%;clear:both;'>");
											out.println("<div class = 'who2' style = 'float:left;background-image:url(\""+uD.getUserByID(mssgs.get(i).getReceiveID()).getDp()+"\");'>");
											out.println("</div>");
											out.println("<div class = 'them'>"+uD.getUserByID(mssgs.get(i).getUserID()).getUsername()+"</div>");
										out.println("</div>");
									}
									out.println("<div class = 'pattern1 receiver' style = 'width:100%;clear:both;'>");
										out.println("<div style = 'float:left;' class = 'whohide'>");
										out.println("</div>");
										out.println("<div class = 'received messageDisplay'>"+mssgs.get(i).getMessage()+"</div>");
									out.println("</div>");
								}
							}
						}
					}
				%>
			</div>
			
			<% int tW = ((User)session.getAttribute("talkingWith")).getIdUser(); %>
			<% int u = ((User)session.getAttribute("user")).getIdUser();%>
			<div id = "refresh" class = "addButton" style = "width:50px; height:50px; z-index:10; position:absolute; right:0;" onclick = "refreshForm()"></div>			
			<form name = "messageSendForm" method = "POST" class = "message">
				<textarea class = "toSend" value = "" placeholder = "Send a Message"></textarea>
				<%out.println("<div class= 'sendButton' onclick = send("+tW+")>Send</div>"); %>
				<input type = "hidden" name = "tempMessageSend" id = "hidemssgsend"></input>
			</form>
		</div>
		<script>
			$(".personSearch").val("");
			var justSent = true;
			var justReced = true;
			var x = 0;
			$(document).keypress(
				    function(event){
				        if (event.which == '13') {
				           event.preventDefault();
				         }
				   });
			function personClick(a){
				$("#hidePersonClick").val(a);
				document.choosePerson.action = "PersonClickServlet";
				document.choosePerson.submit();
			}
			function addPersonForm(){
				$("#hidemssgsearch").val($(".personSearch").val());
				$(".personSearch").val("");
				document.messageAddForm.action = "MessageAddServlet";
				document.messageAddForm.submit();
			}
			function refreshPNavForm(){
				document.messageAddForm.action = "RefreshPNavServlet";
				document.messageAddForm.submit();
			}
			function refreshForm(){
				window.location.href = "messages.jsp";
			}
			function send(tW){
				var message = $(".toSend").val();
				$(".toSend").val("");
				message = message.replace("\n", "</br>");
				$("#hidemssgsend").val(message);
				document.messageSendForm.action = "SendNotificationServlet?notif_type=2&recipientID="+tW+"";
				document.messageSendForm.submit();
			}
			function toBottom(x){
			  var parent = $(x);
			  var height = parent[0].scrollHeight;
			  parent.scrollTop(height);
			}
			function search(){
			}
			$( ".messageDisplay" ).each(function( index ) {
				if($(this).width()>($(".messNav").width())){
					$(this).css("width", $(".messNav").width()+"px");
				}
			});
			$(window).load(function(){
				$(".content").css("width", (screen.width*0.95|0)+"px");
				$(".content").css("visibility", "visible");
				toBottom(".messNav");
			});
		</script>
		<script src="loadDP.js"></script>
		<%	out.println("<script> $(document).ready(function(){setDP(\""+myUser.getDp()+"\");}) </script>");%>
	</body>
</html>