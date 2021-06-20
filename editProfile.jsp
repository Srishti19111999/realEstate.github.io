<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="static/css/editProfile.css">
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
                <li class="nav-item active">
                    <a href="index.jsp" class="nav-link">
                        <i class="fa fa-home fa-lg"></i>
                        Home </a>
                </li>
                <li class="nav-item ">
                    <a href="seller_dashboard.jsp" class="nav-link">
                        <i class="fa fa-info fa-lg"></i>
                        Seller Dashboard </a>
                </li>
                <li class="nav-item ">
                    <a href="show_wishlist.jsp" class="nav-link">
                        <i class="fa fa-list fa-lg"></i>
                        Wishlist </a>
                </li>
                <li class="nav-item ">
                    <a href="show_bids.jsp" class="nav-link">
                        <i class="fa fa-info fa-lg"></i>
                        Your Bids </a>
                </li>
            </ul>
            <span class="navbar-text">
                <a href="profile.jsp" style="text-decoration: none;color: white;" ><i class="fa fa-user" aria-hidden="true"></i> Profile</a>
            </span>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <ol class="col-12 breadcrumb">
                <li class="breadcrumb-item"><a href="./index.html">Home</a></li>
                <li class="breadcrumb-item active">Profile</li>
                <li class="breadcrumb-item active">Edit Profile</li>
            </ol>
        </div>
    </div>
    <div class="container">
        <div class="row row-content align-self-center" >
            <div class="col-12 col-sm-8 offset-sm-2">
                <div class="card">
                    <h3 class="card-header text-white">Edit Profile</h3>
                    <div class="card-body">
                        <form action="save_profile.do" method="POST"> 

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="Username">Username</label>
                                <input type="text" class="form-control form-control col-md-8" name="username"
                                    placeholder="Username" value="${user.username}">
                                    <%String unerror = (String)request.getAttribute("unerror"); %>
                                    <div id="unvalid" class="valid"></div>
                                    <div id="uninvalid" class="invalid"
                                        style='display:<%= unerror==null?"none":"block" %>'>
                                        <%= unerror %>
                                    </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="Email">Email</label>
                                <input type="text" class="form-control form-control col-md-8" name="email"
                                    placeholder="Email" value="${user.email}">
                                    <%String eerror = (String)request.getAttribute("eerror"); %>
                                    <div id="evalid" class="valid"></div>
                                    <div id="einvalid" class="invalid" style='display:<%= eerror==null?"none":"block" %>'>
                                        <%= eerror %></div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="First">First Name</label>
                                <c:choose>
                                    <c:when test="${user.firstName!=null}">                                           
                                        <input type="text" class="form-control form-control col-md-8 " name="first"
                                        placeholder="First Name" value="${user.firstName}">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" class="form-control form-control col-md-8 " name="first"
                                        placeholder="First Name">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="Last">Last Name</label>
                                <c:choose>
                                    <c:when test="${user.lastName!=null}">   
                                        <input type="text" class="form-control form-control col-md-8" name="last"
                                        placeholder="Last Name" value="${user.lastName}">                                        
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" class="form-control form-control col-md-8" name="last"
                                    placeholder="Last Name">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="dob">Date of birth</label>
                                <c:choose>
                                    <c:when test="${user.firstName!=null}">   
                                        <input type="date" class="form-control col-md-8" name="dob"
                                    placeholder="Date of birth" >                          
                                    </c:when>
                                    <c:otherwise>
                                        <input type="date" class="form-control col-md-8" name="dob"
                                        placeholder="Date of birth">                                    
                                    </c:otherwise>
                                </c:choose>              
                            </div>
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="mob">Mobile No</label>
                                <c:choose>
                                    <c:when test="${user.firstName!=null}">   
                                        <input type="text" class="form-control col-md-6" name="mob"
                                    placeholder="Mobile No" id="mob" value="${user.mobile}" >                                      
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" class="form-control col-md-6" name="mob"
                                        placeholder="Mobile No"  id="mob">                                    
                                    </c:otherwise>
                                </c:choose>      
                                <button type="button" class="col-sm-2 btn btn-info btn-sm ml-1" id="otp" disabled  data-toggle="modal" data-target="#otpmodal" data-backdrop="static">Send OTP</button>
                            </div>
                            <div class="form-group offset-md-3 col-sm-auto">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox">
                                    <label class="form-check-label">Remember me
                                    </label>
                                </div>
                            </div>



                            <div id="otpmodal" class="modal fade" role="dialog">
                                <div class="modal-dialog modal-sm" role="content"  id="otpform" style="display:none;">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header bg-warning">
                                            <h4 class="modal-title ml-2 ">O T P</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body col-12 ">
                                            
                                                <div class="form-group row">
                                                    <label class="col-xs-4 ml-2 col-form-lable otp-lable align-self-center"
                                                        for="otp">Enter OTP</label>
                                                    <div class="col-sm-8 ml-1">
                                                        <input type="text" class="form-control" name="otp" id="otp"
                                                             minlength="6" maxlength="6">
                                                    </div>
                                                </div>
                                                <div class="form-group row ">
                                                    <div class="col-12">
                                                        <button type="button" id="otpsubmit" class="btn btn-block btn-primary">Submit</button>
                                                    </div>
                                                </div>
                                         
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-dialog modal-sm" role="content" style="display:block;" id="loader">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title ml-2 ">O T P</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body col-12 ">
                                            <div class="spinner-grow text-warning" role="status"  style="visibility: visible;">
                                                <span style="font-size: 14px;">Loading...</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            
                            <div class="form-group row">
                                <button type="submit" class="offset-md-3 btn btn-primary btn-md pl-5 pr-5" style="font-size: 19x;">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

            
   

  
                <script src="static/jquery/dist/jquery.slim.min.js"></script>
                <script src="static/popper.js/dist/umd/popper.min.js"></script>
                <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
                <script src="static/js/editprofile.js"></script>
</body>

</html>