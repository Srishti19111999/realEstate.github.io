<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pick A Brick</title>
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/form.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">


    <script src="https://www.google.com/recaptcha/api.js" async defer></script>


</head>

<body>

    <%@ include file="header.jsp"%>
    <div class="container" id="search_id">
        <div class="card card-body bg-white " id="searching">

            <div class="form-group row ">
                <div class="col-4 col-md-3 d-flex flex-wrap">
                    <label for="prpty-type" class="col-form-lable">Looking For</label>
                    <select class="form-control custom-select" id="prpty-type">
                        <option value="0" selected>Select Type</option>
                        <c:forEach var="propType" items="${propTypes}">
                            <option value="${propType.propertyTypeId}">${propType.propertyType}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="col-4 col-md-3 d-flex flex-wrap">
                    <label for="city" class="col-form-lable">Select City</label>
                        <input type="text" class="form-control" name="propCity" id="propCity" placeholder="Type City Name">
                        <input type="hidden" name="city_id" id="city_id" value="">
                        <input type="hidden" name="city" id="city" value="">
                        <input type="hidden" name="state_id" id="state_id" value="">
                        <input type="hidden" name="state" id="state" value="">
                        <input type="hidden" name="country_id" id="country_id" value="">
                        <input type="hidden" name="country" id="country" value="">
                        <div id="scrh_res" style="display: none;" ></div>                     
                </div>

                <div class="col-4 col-md-3 d-flex flex-wrap ">
                    <label class="col-form-lable" for="prpty-range">Price</label>
                    <input type="range" class="form-control custom-range" min="50000" max="500000000" step="500"
                        id="prpty-range">
                    <span style="position:absolute; background-color: #020420;color:rgb(217, 212, 241); border:2px solid rgb(10, 10, 43); min-width:50px;border-radius:5px;">
                        <span id="myValue"></span>
                    </span>
                </div>


                <div class=" d-flex align-self-center offset-md-1 offset-sm-4 col-12 col-md-2">
                    <a role="button" name="search" id="search_btn">Search <span
                            class="fa fa-arrow-right fa-sm"></span></a>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="row row-content d-none d-md-block">
            <h2 class="col-12 mb-5  " align="center" style="font-family: 'Vollkorn SC', serif; font-size: 45px">Most
                Popular</h2>

            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <div class="col-12  d-flex flex-nowrap justify-content-around  pb-2 pt-2">
                            <div class="col-md-4 ">
                                <div class="card crd">
                                    <img src="static/images/pexels-binyamin-mellish-106399.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>3 & 4 BHK Villas at Kuniyamuthur, Coimbatore</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-alex-1732414.jpg" alt="pic1" class="card-header">
                                    <div class="card-body">
                                        <h3>3 BHK Residential Apartment in Sector-102 Gurgaon
                                            Emaar Imperial Gardens</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-expect-best-323780.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>2 BHK Residential Apartment in Kandivali (East)
                                            Viceroy Savana</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-12  d-flex flex-nowrap justify-content-around  pb-2 pt-2">
                            <div class="col-md-4 ">
                                <div class="card crd ">
                                    <img src="static/images/pexels-binyamin-mellish-106399.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>5 BHK Residential Apartment in Sector-85 Gurgaon
                                            SS The leaf</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-alex-1732414.jpg" alt="pic1" class="card-header">
                                    <div class="card-body">
                                        <h3>4 BHK Residential Apartment in Sector-81 Gurgaon
                                            DLF The Ultima</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-expect-best-323780.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>3 Bedroom Independent House in Kovur
                                            Greenpro Astrantia Villas</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-12  d-flex flex-nowrap justify-content-around  pb-2 pt-2">
                            <div class="col-md-4 ">
                                <div class="card crd">
                                    <img src="static/images/pexels-binyamin-mellish-106399.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>3 BHK Residential Apartment in Marine Drive
                                            Prestige Neptunes Courtyard</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-alex-1732414.jpg" alt="pic1" class="card-header">
                                    <div class="card-body">
                                        <h3>3 & 4 BHK Villas at Kuniyamuthur, Coimbatore</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card crd">
                                    <img src="static/images/pexels-expect-best-323780.jpg" alt="pic1"
                                        class="card-header">
                                    <div class="card-body">
                                        <h3>3 Bedroom Independent House in Sangameshwar</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <ol class="carousel-indicators">
                        <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#mycarousel" data-slide-to="1"></li>
                        <li data-target="#mycarousel" data-slide-to="2"></li>
                    </ol>
                    <a class="carousel-control-prev" href="#mycarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#mycarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row row-content">
            <div class="col-12 col-sm-6" style="text-align: center;">
                <img src="static/images/pexels-binyamin-mellish-1396132.jpg" alt="pic 2" height="400px" width="450px"
                    id="frame2-pic">
            </div>
            <div class="col-12 col-sm-6  order-sm-last mt-4 ">
                <h2 style="font-family: 'Vollkorn SC', serif; font-size: 35px;">The Best Way To Find Your Future Home
                </h2>
                <div class="card card-body bg-light mt-5 ">
                    <blockquote class="blockquote ">
                        <p class="mb-0" style="font-family: 'Philosopher', sans-serif;font-size: 22px;"><i
                                class="fa fa-quote-left"></i> Buy <em>real estate</em> in areas where path
                            exists and buy more <em>real estate</em> where there is no path,
                            but you can create your own
                        </p>
                        <footer class="blockquote-footer">David Waronker,
                            <cite title="Source Title">American real estate investor</cite>
                        </footer>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row row-content">
            <div class="col-12 col-sm-6" style="text-align: center;">
                <img src="static/images/pexels-snapwire-245535.jpg" alt="pic 2" height="500px" width="450px"
                    id="frame2-pic">
            </div>
            <div class="col-12 col-sm-6  order-sm-first mt-4 ">
                <h2 style="font-family: 'Vollkorn SC', serif;font-size: 35px;">Sell for more than just the home next
                    door</h2>
                <div class="card card-body bg-light mt-4 "
                    style="font-family: 'Philosopher', sans-serif; font-size: 20px;">
                    <p class="mb-0">Wondering where to advertize your rentals? <br /> <br />"Pick A Brick" will make
                        your property reach out to potential buyers and tentants<br />
                        All you need to do is furnish a comprehensive property list with accurate
                        and relevant detail of your property
                    </p>
                    <div class=" d-flex align-self-start p-4">
                        <a href="#" role="button" id="sell_btn">Sell Property</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row row-content ">
            <h2 class="col-12 " align="center" style="font-family: 'Vollkorn SC', serif;  font-size: 45px;">How it works
            </h2>

            <div class="how-it-works d-md-flex flex-nowrap justify-content-around">
                <div class="col-12 col-md-3">
                    <div class="card crd-wrk">
                        <h5 class="card-header card-works ">
                            Buy a property
                        </h5>
                        <div class="card-body crd-wrks-bdy">
                            <p>Search home,shop or any property you wish, on your device screen you can stay ahead of
                                other buyers to get right home </p>
                            <div class=" d-flex justify-content-center ">
                                <a href="#search_id" role="button" id="wrkbtn">Buy Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-3">
                    <div class="card crd-wrk">
                        <h5 class="card-header card-works ">
                            Sell your property
                        </h5>
                        <div class="card-body crd-wrks-bdy">
                            <p>Got a property to sell or to rent? List it and get leads on it by meeting ready buyers
                                quickly.</p>
                            <div class=" d-flex justify-content-center pt-4">
                                <a href="add_property.jsp" role="button" id="wrkbtn">Sell Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-3">
                    <div class="card crd-wrk">
                        <h5 class="card-header card-works ">
                            Rent a property
                        </h5>
                        <div class="card-body crd-wrks-bdy">
                            <p>Being able to rent a property that is closer to your office and had all the amenities to
                                make life comfortable,<br /> has now made easy.</p>
                            <div class=" d-flex justify-content-center ">
                                <a href="add_property.jsp" role="button" id="wrkbtn">Rent Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <%@ include file="footer.jsp"%>
    <script src="static/js/signup.js"></script>
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <script src="static/js/index.js"></script>
    <script src="static/js/signin.js"></script>
</body>

</html>