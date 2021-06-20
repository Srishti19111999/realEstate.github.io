<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Property</title>
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="static/css/add_property.css">
    <link rel="stylesheet" href="static/css/user_profile.css">
    <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.64.0/maps/maps.css'>
    <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/ZoomControls/1.0.11/ZoomControls.css'>
    <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/PanControls/1.0.12//PanControls.css'/>
    <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/SearchBox/2.24.2/SearchBox.css'>
    
</head>

<body>
    <nav class="navbar navbar-expand-sm fixed-top">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand mr-auto" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png"
                class="img-fluid" height="70" width="60"></a>
        <div class="form-group has-search">
            <span class="fa fa-search form-control-feedback"></span>
            <input type="text" class="form-control" placeholder="Search">
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
                        seller Dashboard </a>
                </li>
                <li class="nav-item ">
                    <a href="show_wishlist.jsp" target="_blank" class="nav-link">
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

        <img src="showprofilepic.do" alt="" class="mr-auto" style="width:45px; height:45px; border-radius: 50%;">

    </nav>


    <div class="container">

        <div class="row row-content align-self-center">
            <div class="col-12 col-md-10 offset-sm-1">
                <div class="card mt-2">
                    <h3 class="card-header text-white " style="font-family: 'Vollkorn SC', serif; font-size: 40px">Post Property</h3>
                    <div class="card-body">
                        <input type="hidden" id="property_id" value="">
                        <form style="display: block;">
                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable">You are looking to..? </label>
                                <div class="col-12 col-md-8 ml-auto">
                                    <c:forEach var="propFor" items="${propFors}">
                                        <div class=" form-check form-check-inline ">
                                            <input type="radio" class="form-check-input" name="sell_rent" id="sell_rent"
                                                value="${propFor.forId}">
                                            <label class="form-check-label" for="sell_rent" style="font-size: 18px;"><b>
                                                    ${propFor.forType}</b></label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="form-group row ">
                                <label for="prpty_type" class="col-md-3 col-form-lable">Your property is a ?</label>
                                <select name="prpty_type" class="form-control col-md-6 custom-select" id="prpty_type">
                                    <option value="0" selected>Select Type</option>
                                    <c:forEach var="propType" items="${propTypes}">
                                        <option value="${propType.propertyTypeId}">${propType.propertyType}</option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group row">
                                <label for="prpty_status" class="col-md-3 col-form-lable">Construction Status</label>
                                <select class="form-control col-md-6 custom-select" id="prpty_status"
                                    name="prpty_status">
                                    <option value="0" selected>Select</option>
                                    <c:forEach var="propStatus" items="${propStatuses}">
                                        <option value="${propStatus.propertyStatusId}">${propStatus.propertyStatusType}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="propName">Property Name</label>
                                <input type="text" class="form-control col-md-8" name="propName">
                            </div>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="propPrice">Property Price</label>

                                <input type="number" class="form-control col-md-4" name="proptotalPrice"
                                    placeholder="Total price">
                                <input type="number" class="form-control col-md-3 offset-md-1" name="propPerPrice"
                                    placeholder="Price per sq-ft">
                            </div>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="propArea">Area of Property</label>
                                <input type="text" class="form-control col-md-8" name="propArea"
                                    placeholder="(in sq.fts)">
                            </div>

                            <button type="submit" class="btn btn-sm btn-success offset-sm-10">Save & Next</button>
                        </form>

                        <form style="display: none;">
                            <h1 class="form-group row product_title"></h1>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="propAddress">Property Address</label>
                                <input type="text" class="form-control col-md-8" name="propAddress" id="propAddress">
                            </div>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="propCity">City</label>
                                <input type="text" class="form-control col-md-8" name="propCity" id="propCity">
                                <input type="hidden" name="city_id" id="city_id" value="">
                                <input type="hidden" name="state_id" id="state_id" value="">
                                <input type="hidden" name="state" id="state" value="">
                                <input type="hidden" name="country_id" id="country_id" value="">
                                <input type="hidden" name="country" id="country" value="">

                                <div id="scrh_res" style="display: none;" class="col-md-8 offset-md-3"></div>                     
                            </div>

                            <div class="form-group row">
                                <label class="col-md-3 col-form-lable" for="description">Provide Property
                                    Description</label>
                                <textarea name="description" class="form-control col-md-8" rows="10"></textarea>
                            </div>

                            <button type="submit" class="btn btn-sm btn-success offset-sm-10">Save & Next</button>
                        </form>

                        <form style="display: none;">
                            <h3 class="row-header offset-md-1 mb-4 mt-2 pb-2">Property Features</h3>
                            <div class="form-group row mt-2" id="add_feature">
                                <input type="text" class="form-control col-md-8 offset-md-1 features" name="propFeatures" id="propFeatures">
                                <i class="fa fa-plus-circle col-md-2" style="font-size:36px" id="add_more_feature"></i>
                            </div>
                            <button type="submit" class="btn btn-sm btn-success mt-4 offset-sm-10">Save & Next</button>
                        </form>

                        <form action="property_pic_upload.do" method="POST" enctype="multipart/form-data" style="display: none;">
                            <h3 class="row-header offset-md-1 mb-4 mt-2 pb-2">Upload Property Pics</h3>
                            <div class="form-group row mt-2" id="add_pics">
                                <input type="file" class="form-control offset-md-1 col-md-8 pics" name="propPics" id="propPics">
                                <i class="fa fa-plus-circle col-md-2" style="font-size:36px" id="add_more_pics"></i>
                            </div>
                            <button type="submit" class="btn btn-md btn-success mt-4 offset-sm-10">Post Now</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
           

        </script>
        
        <script src="static/jquery/dist/jquery.slim.min.js"></script>
        <script src="static/popper.js/dist/umd/popper.min.js"></script>
        <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
        <script src="static/js/add_property.js"></script>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.64.0/maps/maps-web.min.js"></script>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/ZoomControls/1.0.11/ZoomControls-web.js"></script>
        <script src='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/PanControls/1.0.12//PanControls-web.js'></script>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/SearchBox/2.24.2/SearchBox-web.js"></script>
        <script src='https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.65.0/services/services-web.min.js'></script>
   
        
</body>

</html>