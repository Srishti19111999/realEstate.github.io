<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Search</title>

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
          <a href="#" class="nav-link">
            <i class="fa fa-home fa-lg"></i>
            Home </a>
        </li>
        <li class="nav-item ">
          <a href="seller_dashboard.jsp" class="nav-link">
            <i class="fa fa-info fa-lg"></i>
            Seller Dashboard </a>
        </li>
        <li class="nav-item ">
          <a href="show_wishlist.jsp"  class="nav-link">
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
    <a href="search_result.jsp" class="active" id="all_props"><i class="fa fa-building" aria-hidden="true"></i>All Properties</a>
    <a href="profile.jsp"><i class="fa fa-user" aria-hidden="true"></i>Your Profile</a>
  </div>



<input type="hidden" name="user_property_propId" id="user_property_propId" value="${userProperty.property.propertyId}">

<input type="hidden" name="search_key" id="search_key" value="${param.search}">
<input type="hidden" name="by" id="by" value="${param.by}">
<input type="hidden" name="city" id="city" value="${param.city}">
<input type="hidden" name="type" id="type" value="${param.type}">
<input type="hidden" name="price" id="price" value="${param.price}">


  <div class="container" >
    <div class="row row-content" >
      <h2 class="col-12 mt-4" align="center" style="font-family: 'Vollkorn SC', serif; font-size: 45px">All Properties</h2>
      <div id="cont_all_prop">

      </div>
    </div>
  </div>



  <script src="static/js/search_result.js"></script>
  
</body>

</html>