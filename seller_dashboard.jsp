<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>seller Dashboard</title>

  <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
  <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">


  <script src="static/jquery/dist/jquery.slim.min.js"></script>
  <script src="static/popper.js/dist/umd/popper.min.js"></script>
  <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="static/css/seller_dashboard.css">

  <script>
    $(document).ready(function () {
      $(".close").click(function () {
        $("#myAlert").alert("close");
      });
    });
    function openNav() {
      document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
      document.getElementById("mySidenav").style.width = "0";
    }
  </script>
</head>

<body>

  <input type="hidden" name="usr_id" id="usr_id" value="${user.userId}">

  <nav class="navbar navbar-expand-sm fixed-top">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
    
    <div class="dropdown">
      <button class="btn btn-light dropdown-toggle" style="margin-left: 6em;margin-right: 5px; border-radius: 10px;" type="button" id="dropdownMenuButton"
          data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="btn_by">
         <strong>By</strong> 
      </button>
      
      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
          <a class="dropdown-item" ><strong>All</strong></a>
          <a class="dropdown-item" ><strong>Location</strong></a>
          <a class="dropdown-item" ><strong>Property Type</strong></a>
          <a class="dropdown-item" ><strong>Price</strong></a>
      </div>
  </div>


      <div class="form-group has-search">
          <input type="hidden" name="by" value="All" id="by">
          <span class="fa fa-search form-control-feedback"></span>
          <input type="text" class="form-control" name="search" id="search" placeholder="Search">
          <i class="fa fa-arrow-right" id="fa-arrow-right"></i>
      </div>

    

    <div class="collapse navbar-collapse " id="Navbar">
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
    </div>

    <img src="showprofilepic.do" alt="" class="mr-auto d-none d-md-block" style="width:45px; height:45px; border-radius: 50%;">

  </nav>

  <div id="mySidenav" class="sidenav" style="font-family: 'Vollkorn SC', serif;">
    <a class="navbar-brand" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png" class="img-fluid"
        height="60" width="50"></a>
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <hr>
    <form class="search-form" role="search">

      <div class="form-group md-form mt-0 pt-1 pb-1 ">
        <input type="text" class="form-control" placeholder="Search" id="search_">
      </div>
    </form>
    <hr>
    <a href="seller_dashboard.jsp" class="active" id="all_props"><i class="fa fa-building" aria-hidden="true"></i>All Properties</a>
    <a href="get_all_bidders.jsp"><i class="fa fa-hand-paper-o" aria-hidden="true"></i>Bids on your property </a>
    <a href="#"><i class="fa fa-check-circle" aria-hidden="true"></i>Property Sold</a>
    <a href="profile.jsp"><i class="fa fa-user" aria-hidden="true"></i>Your Profile</a>
  </div>

  <div class="container">
    <div class="row">
      <ol class="col-12 breadcrumb">
        <li class="breadcrumb-item"><a href="./index.jsp">Home</a></li>
        <li class="breadcrumb-item "><a href="./profile.jsp">Profile</a></li>
        <li class="breadcrumb-item active">Seller Dashboard</li>
      </ol>
    </div>
  </div>

  <c:choose>
    <c:when test="${property != null}">
      <div class="alert alert-success alert-dismissible fade show mt-5 mb-5" role="alert" id="myAlert">
        <center>
          <h4 class="alert-heading">Great!</h4>
          <strong>Property Posted Successfully</strong>
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </center>
      </div>
    </c:when>
  </c:choose>



  <div class="container" >
    <div class="row row-content" >
      <h2 class="col-12" align="center" style="font-family: 'Vollkorn SC', serif; font-size: 45px; margin-top:-1em;">All Properties</h2>
      <div id="cont_all_prop">

      </div>
    </div>
  </div>



  <script src="static/js/seller_dashboard.js"></script>
  <script src="static/js/property.js"></script>
</body>

</html>