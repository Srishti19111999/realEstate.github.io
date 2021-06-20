<link href="https://fonts.googleapis.com/css2?family=Corben:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Audiowide&display=swap" rel="stylesheet">
<header class="jumbotron jumbotron-fluid">
    <nav class="navbar  navbar-expand-sm">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
            <span class="navbar-toggler-icon">&#9776;</span>
        </button>
        <a class="navbar-brand mr-auto" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png"
                class="img-fluid"></a>

        <div class="collapse navbar-collapse" id="Navbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a class="nav-link act" href="index.jsp"> Home</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="aboutus.jsp"> About</a></li>
                
                <li class="nav-item"><a class="nav-link" href="contactus.jsp"> Contact</a></li>
                <li class="nav-item"><a class="nav-link" href="profile.do">Profile</a></li>
            </ul>
            <span class="navbar-text">
                <c:choose>
                    <c:when test="${user==null}">
                        <a id="mysignup" role="button" data-toggle="modal" data-target="#signupmodal" data-backdrop="static">
                            <span class="fa fa-sign-in"></span> SignUp</a>
                    </c:when>
                    <c:otherwise>
                        <a href="signout.do"
                            style="text-decoration: none; color:white;">Log Out</a>
                    </c:otherwise>
                </c:choose>
            </span>
        </div>

    </nav>
    <%@ include file="signup.jsp"%>
    <div class="container">
        <div class="row row-header">
            <div class="col-12 col-sm-6 offset-sm-1">
                <h1 style="font-family: 'Corben', cursive;color: rgb(0, 0, 0); font-size: 60px ;margin-top: -10px;">Pick
                    a Brick</h1>
                <p
                    style="font-family: Georgia, 'Times New Roman', Times, serif; color:white;font-size: 22px; font-weight: bold; background-color: #0a043b8f; margin-left: 2em; border-radius: 5px;">
                    - Dream Home Reaching for the Stars!</p>
            </div>

        </div>
    </div>
</header>