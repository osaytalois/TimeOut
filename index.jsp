<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Timeout</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Timeout</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#features">Features</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#aboutus">About Us</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#login">Log in</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Schedule. Play. Update.</h1>
                <hr>
                <p>The word's leading platform for playing your favorite sport!</p>
                <a href="#login" class="btn btn-primary btn-xl page-scroll">Get Started - For Free</a>
            </div>
        </div>
    </header>

    <aside class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Timeout</h2>
                    <hr class="light">
                    <p class="text-faded">Get started with your dream  basketball career. With Timeout, you can expand your pals along playing your favorite sport. Be a champion. Be the Most Valuable Player of the world of basketball.</p>
                    <a href="#features" class="btn btn-default btn-xl page-scroll">Know More</a>
                </div>
            </div>
        </div>
    </aside>

    <section id="features">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Our Services</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-calendar wow bounceIn text-primary"></i>
                        <h3>Schedule Games</h3>
                        <p class="text-muted">What, When, Where. Experience this within your grasp</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-users wow bounceIn text-primary" data-wow-delay=".1s"></i>
                        <h3>Play with your friends</h3>
                        <p class="text-muted">Enjoy the game with your best buddies</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-trophy wow bounceIn text-primary" data-wow-delay=".2s"></i>
                        <h3>Compete to the boards</h3>
                        <p class="text-muted">Give your best shot. Be the best player of the game</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <aside class="bg-dark" id="login">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Start your sporting career now!</h2>
                <hr class="primary">
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-12 text-center">
                    <h3> Log in </h3>
                    <form class="form" role="form" method="post" action="LoginServlet" accept-charset="UTF-8" id="login-nav">
                        <center><div class="form-group">
                            <label class="sr-only" for="login_username">username</label>
                            <input type="text" class="form-control textfield" id="login_username" placeholder="Username" required="" name="username_login">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="login_password">Password</label>
                            <input type="password" class="form-control textfield" id="login_password" placeholder="Password" required="" name="password_login">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block textfield">Sign in</button>
                        </div></center>
                    </form>
                </div>
                <!-- Signup -->
                <div class="col-lg-6 col-md-12 text-center">
                    <h3> Sign Up </h3>
                    <form class="form" role="form" method="post" action="SignupServlet" accept-charset="UTF-8" id="login-nav">
                        <center><div class="form-group">
                            <label class="sr-only" for="signup_firstname">First Name</label>
                            <input type="text" class="form-control textfield" id="signup_firstname" placeholder="First Name" required="" name="firstName">
                        </div>
                        <div class="form-group">    
                            <label class="sr-only" for="signup_lastname">Middle Name</label>
                            <input type="text" class="form-control textfield" id="signup_middlename" placeholder="Middle Name" required="" name="middleName">
                        </div>
                        <div class="form-group">    
                            <label class="sr-only" for="signup_lastname">Last Name</label>
                            <input type="text" class="form-control textfield" id="signup_lastname" placeholder="Last Name" required="" name="lastName">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="signup_username">Username</label>
                            <input type="text" class="form-control textfield" id="signup_email" placeholder="Username" required="" name="userName_signup">
                        </div>
                        <div class="form-group">    
                            <label class="sr-only" for="signup_position">Position</label>
                            <input type="text" class="form-control textfield" id="signup_position" placeholder="Position (e.g. G, F, SG)" required="" name="position">
                        </div>
                        <div class="form-group">    
                            <label class="sr-only" for="signup_location">Location</label>
                            <input type="text" class="form-control textfield" id="signup_location" placeholder="Location" required="" name="location">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="signup_password1">Password</label>
                            <input type="password" class="form-control textfield" id="signup_password1" placeholder="Password" required="" name="password_signup">
                        </div>
                        <div class="form-group">    
                            <label class="sr-only" for="signup_password2">Re-type your Password</label>
                            <input type="password" class="form-control textfield" id="signup_password2" placeholder="Re-type Password" required="" name="password1_signup">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block textfield">Sign Up</button>
                        </div></center>
                    </form>
                </div>
            </div>
        </div>
    </aside>

    <section id="aboutus">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Our Team</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="service-box">
                       <!-- <i class="fa fa-4x fa-calendar wow bounceIn text-faded"></i> -->
                       <center><div class="fa fa-4x wow bounceIn circle-img" id="img_beno"></div></center>
                        <h3>John Benolirao</h3>
                        <i><p class="text-muted">God is spirit, and his worshipers must worship in the Spirit and in truth. | John 4:24</p></i>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="service-box">
                        <!-- <i class="fa fa-4x fa-trophy wow bounceIn text-faded" data-wow-delay=".1s"></i> -->
                        <center><div class="fa fa-4x wow bounceIn circle-img" id="img_anton"></div></center>
                        <h3>Anton de Joya</h3>
                        <i><p class="text-muted">For I know the plans I have for you, declares the Lord, plans to prosper you and not to harm you, plans to give you hope and a future. | Jeremiah 29:11</p></i>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 text-center">
                    <div class="service-box">
                       <!-- <i class="fa fa-4x fa-users wow bounceIn text-faded" data-wow-delay=".2s"></i> -->
                       <center><div class="fa fa-4x wow bounceIn circle-img" id="img_lois"></div></center>
                        <h3>Lois Osayta</h3>
                        <i><p class="text-muted">So whether you eat or drink or whatever you do, do it all for the glory of God. 32 Do not cause anyone to stumble, whether Jews, Greeks or the church of God. even as I try to please everyone in every way. For I am not seeking my own good but the good of many, so that they may be saved. | 1 Corinthians 10:31-33</p></i>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- copyright at the bottom of the page -->
    <aside id="copyright" class="bg-dark">
        <hr>
            <div class="col-lg-12 col-md-2 text-center">
                <footer>
                    <p class="text-faded">&copy; Copyright 2016 Timeout</p>
                </footer>
            </div>
    </aside>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>

</body>

</html>
