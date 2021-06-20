<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>

    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="static/css/form.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#signinmodal").modal('show');
        });
    </script>

    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

</head>

<body>

    <div id="signinmodal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg" role="content">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title ml-2 text-white">Sign In</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body col-12 ">
                    <form action="signin.do" method="POST">
                        <%String uneperror = (String)request.getAttribute("uneperror"); %>

                        <div id="uneinvalid" class=" offset-md-2 invalid" style='display:<%= uneperror==null?"none":"block" %>'>
                            <%= uneperror %>
                        </div>

                        <div class="form-group row">
                            <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                for="nameemail">Email/Username</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="nameemail" id="nameemail"
                                    placeholder="Enter username/email" minlength="4" maxlength="30">
                                <div id="unevalid" class="valid"></div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-md-2 col-form-lable signup-lable align-self-center" for="password">
                                Password</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="password" id="password"
                                    placeholder="Enter password" minlength="8" maxlength="15">
                                <div id="pvalid" class="valid"></div>
                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-md-8 offset-md-2">
                                <%String cerror = (String)request.getAttribute("cerror"); %>
                                <div class="g-recaptcha" data-sitekey="6Le4xdcZAAAAAKfQtwxR_9DbA_rthGbHcP5TorxI"></div>
                                <div class="invalid" style='display:<%= cerror==null?"none":"block" %>'><%= cerror %>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row ">
                            <div class="offset-md-2 col-12">
                                <button type="submit" id="signinsubmit" class="btn blue-gradient col-md-3 ">Sign In</button>
                                <button type="button" id="cancel" class=" btn col-md-3"
                                    data-dismiss="modal">Cancel</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>