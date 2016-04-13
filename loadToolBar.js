
	$(document).ready(function() {
		//Top Toolbar
		$hideTop = $("<div id = hideTop></div>");
		$topTools = $("<div id = toolbartop ></div>");
		$logo = $("<div id = 'logo'></div>");
		$logout = $("<div id = 'logOut' class = 'toolButtons' onclick = 'loadLanding()'></div>").html("Logout");
		$toolDiv = $("<div class = 'toolDiv'></div>");
		$form = $("<form action='SearchServlet' method='POST'></form>");
		$textBox = $("<input type='text' id = 'toolSearch' name = 'searchBox' placeholder = 'Search Timeout'>");
		$($textBox).focus(function(){
			$(this).attr('placeholder', '');
		}).blur(function(){
			$(this).attr('placeholder', 'Search Timeout');
		});
		$searchButton = $("<div></div>");
		$($searchButton).attr("id", "searchButton");
		$($form).append($textBox);
		$($form).append($searchButton);
		$($toolDiv).append($form);
		$($topTools).append($logo);
		$($topTools).append($logout);
		$($topTools).append($toolDiv);
		$($hideTop).append($topTools);
		$("body").append($hideTop);
		
		//Bottom Toolbar
		
		$hideBot = $("<div id = hide></div>");
		$botTools = $("<div id = toolbar ></div>");
		$toolDivMid = $("<div class = 'toolDivMid'></div>");
		$button7 = $("<div id = 'double7' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadSettings()'></div>").html("Settings");
		$button6 = $("<div id = 'double6' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadNotifs()'></div>").html("Notifications");
		//$button5 = $("<div id = 'double5' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadHoF()'></div>").html("Hall of Fame");
		$button4 = $("<div id = 'double4' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadMess()'></div>").html("Messages");
		$button3 = $("<div id = 'double3' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadProfile()'></div>").html("Profile");
		$button2 = $("<div id = 'double2' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadEvent()'></div>").html("Events");
		$button1 = $("<div id = 'double1' class = 'toolIconRB' onmouseover = 'botButtonDoubleH(this)' onmouseout = 'botButtonDoubleO(this)' onclick = 'loadNews()'></div>").html("What's New");
		//$myForm4 = $("<form name = 'myForm4' method = 'POST'>");
		$($toolDivMid).append($button7);
		$($toolDivMid).append($button6);
		//$($toolDivMid).append($button5);
		$($toolDivMid).append($button4);
		$($toolDivMid).append($button3);
		$($toolDivMid).append($button2);
		$($toolDivMid).append($button1);
		$($botTools).append($toolDivMid);
		$($hideBot).append($botTools);
		$("body").append($hideBot);
		
		//docks
		$botDiv = $("<div id = botDiv></div>");
		$botIcon1 = $("<div id = botIcon class = 'double1' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadNews()'></div>");
		$botIcon2 = $("<div id = botIcon class = 'double2' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadEvent()'></div>");
		$botIcon3 = $("<div id = botIcon class = 'double3' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadProfile()'></div>");
		$botIcon4 = $("<div id = botIcon class = 'double4' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadMess(0)'></div>");
		//$botIcon5 = $("<div id = botIcon class = 'double5' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadHoF()'></div>");
		$botIcon6 = $("<div id = botIcon class = 'double6' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadNotifs()'></div>");
		$botIcon7 = $("<div id = botIcon class = 'double7' onmouseover = 'botIconDoubleH(this)' onmouseout = 'botIconDoubleO(this)' onclick = 'loadSettings()'></div>");
		$botDiv.append($botIcon1);
		$botDiv.append($botIcon2);
		$botDiv.append($botIcon3);
		$botDiv.append($botIcon4);
		//$botDiv.append($botIcon5);
		$botDiv.append($botIcon6);
		$botDiv.append($botIcon7);
		$("body").append($botDiv);
		resizeBotDiv();
		$botDiv.css("visibility", "visible");
	});
	window.onresize = resizeBotDiv;
	function resizeBotDiv(){
		var botDivWidth = $("#botDiv").width();
		var toolDivMidWidth = $(".toolDivMid").width();
		var windowWidth = $(window).width();
		$($botDiv).css("marginLeft",((windowWidth/2|0)-(botDivWidth/2|0))+"px");
		$($toolDivMid).css("marginLeft",((windowWidth/2|0)-(toolDivMidWidth/2|0))+"px");
	}