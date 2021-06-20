<div id="signupmodal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg" role="content">


        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title ml-2">
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link mytab active" href="#signup" role="tab" data-toggle="tab">Sign up</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mytab" href="#signin" role="tab" data-toggle="tab">Sign in</a>
                        </li>
                    </ul>
                </h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade show active" id="signup">
                    <!-- Modal content-->
                    <div class="modal-body col-12 ">
                        <form action="signup.do" method="POST">
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="username">Username</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="username" id="username"
                                        placeholder="Enter username" minlength="4" maxlength="30">
                                    <%String unerror = (String)request.getAttribute("unerror"); %>
                                    <div id="unvalid" class="valid"></div>
                                    <div id="uninvalid" class="invalid"
                                        style='display:<%= unerror==null?"none":"block" %>'>
                                        <%= unerror %></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="email">Email</label>
                                <div class="col-md-9">
                                    <input type="email" class="form-control" name="email" id="email"
                                        placeholder="Enter email">
                                    <%String eerror = (String)request.getAttribute("eerror"); %>
                                    <div id="evalid" class="valid"></div>
                                    <div id="einvalid" class="invalid"
                                        style='display:<%= eerror==null?"none":"block" %>'>
                                        <%= eerror %></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" id="password"
                                        placeholder="Enter password" minlength="8" maxlength="15">
                                    <%String perror = (String)request.getAttribute("perror"); %>
                                    <div id="pvalid" class="valid"></div>
                                    <div id="pinvalid" class="invalid"
                                        style='display:<%= perror==null?"none":"block" %>'>
                                        <%= perror %></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="repassword">Re-password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="repassword" id="repassword"
                                        placeholder="Re-Enter password" minlength="8" maxlength="15">
                                    <%String reperror = (String)request.getAttribute("reperror"); %>
                                    <div id="repvalid" class="valid"></div>
                                    <div id="repinvalid" class="invalid"
                                        style='display:<%= reperror==null?"none":"block" %>'>
                                        <%= reperror %></div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-8 offset-md-2">
                                    <%String cerror = (String)request.getAttribute("cerror"); %>
                                    <div class="g-recaptcha" data-sitekey="6Le4xdcZAAAAAKfQtwxR_9DbA_rthGbHcP5TorxI">
                                    </div>
                                    <div class="invalid" style='display:<%= cerror==null?"none":"block" %>'>
                                        <%= cerror %></div>
                                </div>
                            </div>

                            <div class="form-group row ">
                                <div class="offset-md-2 col-12">
                                    <button type="submit" id="signupsubmit" class="btn col-md-3 ">Register</button>
                                    <button type="button" id="cancel" class=" btn col-md-3"
                                        data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div role="tabpanel" class="tab-pane fade" id="signin">
                    <div class=" modal-body col-12 ">
                        <form action="signin.do" method="POST">
                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="username">Email/Username</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="nameemail" id="username/email"
                                        placeholder="Enter username/email" minlength="4" maxlength="30">
                                    <%String signinunerror = (String)request.getAttribute("unerror"); %>
                                    <div id="unevalid" class="valid"></div>
                                    <div id="uneinvalid" class="invalid"
                                        style='display:<%= unerror==null?"none":"block" %>'>
                                        <%= signinunerror %></div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-md-2 col-form-lable signup-lable align-self-center"
                                    for="password"><span class="glyphicon glyphicon-eye-open"></span>
                                    Password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" id="password"
                                        placeholder="Enter password" minlength="8" maxlength="15">
                                    <%String signinperror = (String)request.getAttribute("perror"); %>
                                    <div id="pvalid" class="valid"></div>
                                    <div id="pinvalid" class="invalid"
                                        style='display:<%= perror==null?"none":"block" %>'>
                                        <%= signinperror %></div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-8 offset-md-2">
                                    <%String signincerror = (String)request.getAttribute("cerror"); %>
                                    <div class="g-recaptcha" data-sitekey="6Le4xdcZAAAAAKfQtwxR_9DbA_rthGbHcP5TorxI">
                                    </div>
                                    <div class="invalid" style='display:<%= cerror==null?"none":"block" %>'>
                                        <%= signincerror %>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row ">
                                <div class="offset-md-2 col-12">
                                    <button type="submit" id="signinsubmit" class="btn col-md-3 ">Sign In</button>
                                    <button type="button" id="cancel" class=" btn col-md-3"
                                        data-dismiss="modal">Cancel</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>