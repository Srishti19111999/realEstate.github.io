<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>

    <head>
        <title>User_Profile</title>
        <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
        <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="static/css/user_profile.css">
        <link rel='stylesheet' type='text/css'
            href='https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.64.0/maps/maps.css'>
        <link rel='stylesheet' type='text/css'
            href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/ZoomControls/1.0.11/ZoomControls.css'>
        <link rel='stylesheet' type='text/css'
            href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/PanControls/1.0.12//PanControls.css' />
        <link rel='stylesheet' type='text/css'
            href='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/SearchBox/2.24.2/SearchBox.css'>

    </head>

    <body>
        <nav class="navbar navbar-expand-sm fixed-top">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand mr-auto" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png"
                    class="img-fluid" height="70" width="60"></a>


            <div class="dropdown">
                <button class="btn btn-light dropdown-toggle"
                    style="margin-left: 6em;margin-right: 5px; border-radius: 10px;" type="button"
                    id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                    id="btn_by">
                    <strong>By</strong>
                </button>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item"><strong>All</strong></a>
                    <a class="dropdown-item"><strong>Location</strong></a>
                    <a class="dropdown-item"><strong>Property Type</strong></a>
                    <a class="dropdown-item"><strong>Price</strong></a>
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

            <img src="showprofilepic.do" alt="" class="mr-auto" style="width:45px; height:45px; border-radius: 50%;">

        </nav>

        <div class="container">
            <div class="row">
                <ol class="col-12 breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Profile</li>
                </ol>
            </div>
        </div>
        <c:choose>
            <c:when test="${user.firstName!=null}">
                <div class="alert alert-success alert-dismissible fade show mt-5 mb-5" role="alert" id="myAlert">
                    <center>
                      <h4 class="alert-heading">Great!</h4>
                      <h4>Your Profile Is Up to date</h4>
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </center>
                  </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger alert-dismissible fade show mt-5 mb-7" role="alert" id="myAlert">
                    <center>
                      <h4 class="alert-heading">Oh No!</h4>
                      <strong>Your profile is not updated</strong>
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </center>
                  </div>
            </c:otherwise>
        </c:choose>
        <div class="container">
            <div class="row row-content profile">

                <div class="col-12 col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="row profile-sidebar">
                                <!-- SIDEBAR USERPIC -->
                                <div class="col-12 col-md-4 profile-userpic">
                                    <img src="showprofilepic.do" class="img-responsive" alt="user" id="profilepic">
                                    <!--<img src="static/images/pluspng.png" id="add" alt="">-->
                                    <div class="middle">
                                        <div class="text" id="add">Upload</div>
                                    </div>
                                </div>

                                <!-- END SIDEBAR USERPIC -->
                                <!-- SIDEBAR USER TITLE -->
                                <div class="col-12 col-md-8">
                                    <div class="profile-usertitle">
                                        <div class="profile-usertitle-name">
                                            <c:choose>
                                                <c:when test="${user.firstName!=null}">
                                                    ${user.firstName} ${user.lastName}
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.username}
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class=" profile-usertitle-job">
                                            profile
                                        </div>
                                    </div>

                                    <div class="profile-userbuttons ">
                                        <a type="button" class=" btn btn-success btn-sm  pl-4 pr-4"
                                            href="new_property.do">Post
                                            Property</a>
                                        <button type="button" class=" btn btn-danger btn-sm  pl-4 pr-4"><a
                                                href="signout.do" style="text-decoration: none; color:white;">Log
                                                Out</a></button>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <button type="button"
                                    class=" col-12 col-sm-6 btn btn-warning btn-sm pl-5 pr-5 offset-sm-3"
                                    style="font-size: 16px; font-weight: 600;"><a href="edit_profile.do"
                                        style="text-decoration: none; color: black;">Edit Profile</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <div id="profilepicmodal" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg" role="content">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title ml-2 ">Profile Pic</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body col-12 ">
                        <form action="profilepic.do" method="post" enctype="multipart/form-data">
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="profilepic">Profile Pic</label>
                                <div class="col-md-9">
                                    <input type="file" class="form-control" name="profilepic" id="profilepic">
                                </div>
                            </div>
                            <div class="form-group row ">
                                <div class="offset-md-2 col-12">
                                    <button type="submit" id="upload" class="btn col-md-3 ">Upload</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <div class="container">
            <div class="row row-content">
                <h2 class="col-12 mb-5 mt-4" align="center" style="font-family: 'Vollkorn SC', serif; font-size: 35px">
                    Dashboard</h2>

                <div class="col-12 col-md-12">
                    <div class="card">
                        <h4 class="card-header">Your Location</h4>
                        <div class="card-body">
                            <div id="map" style="width:100%;height:300px;">
                                <div class='tt-overlay-panel -center js-message-box' hidden>
                                    <button class='tt-overlay-panel__close js-message-box-close'></button>
                                    <span class='tt-overlay-panel__content'></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row row-content">
                <h2 class="col-12" align="center" style="font-family: Vollkorn SC, serif;font-size: 45px">Your Near By
                    Properties</h2>
                <div id="cont_all_prop" class="row">

                </div>
            </div>
        </div>



        <script src="static/jquery/dist/jquery.slim.min.js"></script>
        <script src="static/popper.js/dist/umd/popper.min.js"></script>
        <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
        <script src="static/js/profile.js"></script>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.64.0/maps/maps-web.min.js"></script>
        <script
            src="https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/ZoomControls/1.0.11/ZoomControls-web.js"></script>
        <script
            src='https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/PanControls/1.0.12//PanControls-web.js'></script>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/plugins/SearchBox/2.24.2/SearchBox-web.js"></script>
        <script src='https://api.tomtom.com/maps-sdk-for-web/cdn/5.x/5.65.0/services/services-web.min.js'></script>


        <script>


            var messageBox = document.querySelector('.js-message-box');
            var messageBoxContent = document.querySelector('.tt-overlay-panel__content');
            var messageBoxClose = messageBox.querySelector('.js-message-box-close');

            var messages = {
                permissionDenied: 'Permission denied. You can change your browser settings' +
                    'to allow usage of geolocation on this domain.',
                notAvailable: 'Geolocation data provider not available.'
            };

            var ttZoomControls = new tt.plugins.ZoomControls({
                className: 'margin-left-30'
            });
            var ttPanControls = new tt.plugins.PanControls();

            tt.setProductInfo('PickABrick', '001');
            var map = tt.map({
                key: "GmgYGsqvP3JJQVKZ5PrcJUCdltJ8qUpw",
                container: "map",
                style: "tomtom://vector/1/basic-main",
                zoom: 10
            });
            var geolocateControl = new tt.GeolocateControl({
                positionOptions: {
                    enableHighAccuracy: true
                }
            });
            /* var marker = new tt.Marker().setLngLat().addTo(map);
             marker.setPopup(new tt.Popup().setHTML('Your Location'));*/


            bindEvents();

            // Handle case when domain permissions are already blocked
            handlePermissionDenied();

            map.addControl(geolocateControl);
            map.addControl(ttZoomControls, 'top-left');
            map.addControl(ttPanControls, 'top-left');

            function handlePermissionDenied() {
                if ('permissions' in navigator) {
                    navigator.permissions.query({ name: 'geolocation' })
                        .then(function (result) {

                            if (result.state === 'denied') {
                                displayErrorMessage(messages.permissionDenied);
                            }
                        });
                }
            }

            function bindEvents() {
                geolocateControl.on('error', handleError);
                messageBoxClose.addEventListener('click', handleMessageBoxClose);
            }

            function handleMessageBoxClose() {
                messageBox.setAttribute('hidden', true);
            }

            function displayErrorMessage(message) {
                messageBoxContent.textContent = message;
                messageBox.removeAttribute('hidden');
            }

            function handleError(error) {
                switch (error.code) {
                    case error.PERMISSION_DENIED:
                        displayErrorMessage(messages.permissionDenied);
                        break;
                    case error.POSITION_UNAVAILABLE:
                    case error.TIMEOUT:
                        displayErrorMessage(messages.notAvailable);
                }
            }

            function callbackFn(result) {
                console.log(result);


            };


            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(showPosition);
                } else {
                    //x.innerHTML = "Geolocation is not supported by this browser.";
                }
            }
            const cont_all_prop = document.querySelector("#cont_all_prop");






            const allNearByProperties = async () => {
                const url = 'search.do?';
                // const query = `search=${search_key.value}&by=${by.value}`;

                const response = await fetch(url, { method: 'post' });
                const data = await response.json();

                return data;
            };

            function showPosition(position) {
                console.log(position.coords.latitude);
                console.log(position.coords.longitude);

                /* tt.services.nearbySearch({
                     key: "GmgYGsqvP3JJQVKZ5PrcJUCdltJ8qUpw",
                     center: [position.coords.longitude,position.coords.latitude],
                     radius: 50000,
                     ext: "json",
                     limit: 150,
                     idxSet: "PAD",
                     countrySet: "IN",
                     categorySet: "7303"
                 })
                     .go()
                     .then(callbackFn);*/
                allNearByProperties()
                    .then((data) => {
                        data.forEach((prop) => {
                            console.log(Math.floor(prop.latitude));
                            console.log(prop);
                            if (Math.floor(position.coords.latitude) == Math.floor(prop.latitude) && Math.floor(position.coords.longitude) == Math.floor(prop.longitude)) {

                                var marker = new tt.Marker().setLngLat([prop.longitude, prop.latitude]).addTo(map)
                                marker.setPopup(new tt.Popup().setHTML("<b>" + prop.propertyName + "</b>"));
                            }
                        })

                        showProperties(data, position.coords.latitude, position.coords.longitude);
                    })
                    .catch((err) => { });

                var marker = new tt.Marker().setLngLat([position.coords.longitude, position.coords.latitude]).addTo(map);
                marker.setPopup(new tt.Popup().setHTML('Your Location'));
            }

            getLocation();
        </script>


    </body>

    </html>