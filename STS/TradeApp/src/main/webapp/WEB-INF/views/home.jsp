<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
        <title>Trading Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/example.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/trade.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/JS/background.cycle.js"></script>
		<script src="<%=request.getContextPath()%>/resources/JS/modernizr.custom.js"></script>
		<script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("body").backgroundCycle({
                    imageUrls: [
                        '<%=request.getContextPath()%>/resources/IMG/bg1.jpg',
                        '<%=request.getContextPath()%>/resources/IMG/bg2.jpg',
                        '<%=request.getContextPath()%>/resources/IMG/bg3.jpg'
                    ],
                    fadeSpeed: 2000,
                    duration: 5000,
                    backgroundSize: SCALING_MODE_COVER
                });
            });
			
            function hideDiv()
            {
            	var ele=Document.getElementById("hideIt");
            	ele.style.display='none';
            }
			function toggleIt(id,id1)
			  {
				var signup=document.getElementById(id);
				var signin=document.getElementById(id1);
				var displaySetting=signup.style.display;
				if(displaySetting=='none')
				{
					signup.style.display='block';
					signin.style.display='none';
					
				}
				else
				{
					signup.style.display='none';
					signin.style.display='block';
				}
			  }
			  
			  function toggleNow(id,id1)
			  {
				var signup=document.getElementById(id);
				var signin=document.getElementById(id1);
				var displaySetting=signin.style.display;
				if(displaySetting=='none')
				{
					signup.style.display='none';
					signin.style.display='block';
					
				}

			  }
			  var xmlHttp;
			  xmlHttp=new XMLHttpRequest();
			  function chkUser()
			  {
				  if (xmlHttp == null)
                  {
                      alert("Your browser does not support AJAX!");
                      return;
                  }
				  else
				  {
					  var nameUser=document.getElementById("nameOfUser").value;
					  var pwUser=document.getElementById("pwOfUser").value;
				  }
				 
				  xmlHttp.onreadystatechange = function stateChanged()
				  {
					  if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
						  {
						  
						  var returnedValue=xmlHttp.responseText;
						  if(returnedValue.trim()=="false")
							  {
							  document.getElementById("hideIt").innerHTML="Id and password could not be found";
							 
							  }
						  else
							  {
							  location.href="/trading/investorWorkspace.htm";
							  }
						  }
				  };
				  var query= "Username=" + nameUser + "&password=" + pwUser;
				  xmlHttp.open("POST","searchinvestor.htm",true);
				  xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xmlHttp.send(query);
				
				  return null;
			  }
        </script>
</head>
<body style="margin: 0;">
    <div class="jquery-script-ads" align="center"><script type="text/javascript"><!--
google_ad_client = "ca-pub-2783044520727903";
/* jQuery_demo */
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
</div>
    <div class="wrapper">
        <div class="container-fluid">
			<div class="row">
				<div class="transparentBox">
                </div><!--transparent box closed-->
			</div><!--row closed-->
		</div><!--Container-fluid closed-->
	</div><!--wrapper closed-->
	<div class="topNav">
	<nav class="navbar navbar-inverse">
       <div class="container-fluid">
           <div class="navbar-header">
                 <a class="navbar-brand" href="#">TradeShares.com</a>
           </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
       </div>
     </nav>
	 </div>
	<div class="heads">
	<p>Fastest Trading</p>
	<p class="ever"><b>EVER</b></p>
	</div>
	<div class="subs">
	<p>More than 7,000,000 accounts opened</p>
	<p class="seccondline">more than 1,500,000 trades per day</p>
	</div>
	<div class="butts">
    <input type="button" id="showRight" value="TRADE NOW" class="butn">
	</div>
    <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
			
			<input type="button" value="SIGN IN" onclick="toggleNow('signingUp','getStarted')" class="smallbutn signin" /> <input type="button" value="SIGN UP" onclick="toggleIt('signingUp','getStarted')" class=" smallbutn register" />
			<div id="getStarted" style="display:block;">
			
			<form action="searchinvestor.htm" method="post">
			
			<input type="text" class="form-control emailId" placeholder="Username" name="usernames" id="nameOfUser" onfocus="hideDiv()" required/> 
			<input type="password" placeholder="password" class="pw form-control" name="pw" id="pwOfUser" required/>
			<div id="box"><input type="checkbox"><span class="reme"> Remember Me</span></div>
			<div id="hideIt"></div>
			<input type="button" value="Login" onclick="chkUser()" class="smallbutn logs" />
			
			</form>
			</div>
			
			<div style="display:none;" id="signingUp">
			
			<form:form action="addinvestor.htm" commandName="investor" method="post">
			
			<input type="text" class="form-control emailId" placeholder="First Name" name="fName" required/>
			<font color="red"><form:errors path="fName"/></font>
			<input type="text" class="form-control emailId" placeholder="Last Name" name="lName" required/> 
			<font color="red"><form:errors path="lName"/></font>
			<input type="email" class="form-control emailId" placeholder="Email ID" name="eMailID" required/> 
			<font color="red"><form:errors path="eMailID"/></font>
			<input type="text" class="form-control emailId" placeholder="Username" name="userName" required/> 
			<font color="red"><form:errors path="userName"/></font>
			<input type="password" placeholder="password" class="pw form-control" name="password" required/>
			<font color="red"><form:errors path="password"/></font>
			<input type="text" placeholder="Contact Number" class="form-control emailId" name="contact" required/>
			<font color="red"><form:errors path="contact"/></font>
			<input type="text" placeholder="PAN Card Number" class="form-control emailId" name="panCardNum" required/>
			<font color="red"><form:errors path="panCardNum"/></font>
			<input type="text" placeholder="Account Number" class="form-control emailId" name="accountNum" required/>
			<font color="red"><form:errors path="accountNum"/></font>
			<input type="text" placeholder="Address" class="form-control emailId" name="address" required/>
			<font color="red"><form:errors path="address"/></font>
			<input type="hidden" name="action" value="addInvestor"/>
			<input type="submit" value="Register" class=" smallbutn logs" />
			
			</form:form>
			</div>
			
	</nav>
	<script src="<%=request.getContextPath()%>/resources/JS/classie.js"></script>
		<script>
			var	menuRight = document.getElementById( 'cbp-spmenu-s2' ),
				showRight = document.getElementById( 'showRight' ),
				body = document.body;

			showRight.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( menuRight, 'cbp-spmenu-open' );
				disableOther( 'showRight' );
			};
		
			function disableOther( button ) {
				if( button !== 'showRight' ) {
					classie.toggle( showRight, 'disabled' );
				}
			
			}
		</script>
    <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

    </body>
</html>
