<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/form.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About us</title>
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/contactus.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
</head>
<body>

    <nav class="navbar navbar-expand-sm fixed-top">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand mr-auto" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png"
                class="img-fluid" height="70" width="60"></a>
        <div class="collapse navbar-collapse" id="Navbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp"> Home</a>
                </li>
                <li class="nav-item active"><a class="nav-link" href="aboutus.jsp"> About</a></li>
                <li class="nav-item"><a class="nav-link" href="profile.jsp"> Profile</a></li>
                <li class="nav-item"><a class="nav-link" href="contactus.jsp"> Contact</a></li>
            </ul>
            
            <span class="navbar-text">
                <a id="mysignup" role="button" data-toggle="modal" data-target="#signupmodal" data-backdrop="static">
                    <span class="fa fa-sign-in"></span> SignUp</a>
            </span>
        </div>
    </nav>
    <%@ include file="signup.jsp"%>

    <div class="about-section">
        <div class="inner-container">
            <h3>We Are Open and Honest About What We Do</h3>
            <p class="text">
                You should never give away your information on a website if you don't know why the website owners are asking for it. To be fully transparent, we are requesting that you submit your housing information today so that we are able to do our due diligence on your house. compile the proper research, and calculate an offer for your within the next 48 hours. Our company buys sells, and rents homes through a very systematic approach. We are not real estate agents or brokers. therefore you will NOT need to pay us a commission when we purchase your house. We are not for everybody, but if you're looking to sell your house quickly to a local real estate expert who can work with you directly, then it makes sense for you to request an all-cash offer today
            </p>
            <div class="skills">
                <span>SELLING</span>
                <span>BUYING</span>
                <span>RENTING</span>
            </div>
        </div>
    </div>

    
    <script src="static/js/signup.js"></script>
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
</body>
</html>