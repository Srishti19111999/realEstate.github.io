<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact us</title>
    <link rel="stylesheet" href="static/css/contactus.css">
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
  </head>
  <body>
    <nav class="navbar navbar-expand-sm fixed-top ">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand mr-auto" href="index.jsp"><img src="static/images/PicsArt_10-07-02.26.27.png"
                class="img-fluid" height="70" width="60"></a>
        <div class="collapse navbar-collapse" id="Navbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp"> Home</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="aboutus.jsp"> About</a></li>
                <li class="nav-item"><a class="nav-link" href="profile.jsp"> Profile</a></li>
                <li class="nav-item active"><a class="nav-link" href="contactus.jsp"> Contact</a></li>
            </ul>
            
            <span class="navbar-text">
                <a id="mysignup" role="button" data-toggle="modal" data-target="#signupmodal" data-backdrop="static">
                    <span class="fa fa-sign-in"></span> SignUp</a>
            </span>
        </div>
    </nav>
    <div class="contact-section">
      <div class="contact-info">
        <div><i class="fas fa-map-marker-alt"></i>Patan Buypass, Jabalpur, India, 482001</div>
        <div><i class="fas fa-envelope"></i>pickabrick.tk@gmail.com</div>
        <div><i class="fas fa-phone"></i>+91 9685 100 XXX</div>
        <div><i class="fas fa-clock"></i>24X7</div>
      </div>
      <div class="contact-form">
        <h2>Contact Us</h2>
        <form class="contact" action="" method="post">
          <input type="text" name="name" class="text-box" placeholder="Your Name" required>
          <input type="email" name="email" class="text-box" placeholder="Your Email" required>
          <textarea name="message" rows="5" placeholder="Your Message" required></textarea>
          <input type="submit" name="submit" class="send-btn" value="Send">
        </form>
      </div>
    </div>
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

  </body>
</html>