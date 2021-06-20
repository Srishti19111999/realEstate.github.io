<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="static/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-social/bootstrap-social.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn+SC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Philosopher:wght@700&display=swap" rel="stylesheet">
  
  
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="main">
        <c:choose>
            <c:when test="${success!=NULL}">
                <div class="result success">
                    <div class="alert alert-success alert-dismissible fade show mt-5 mb-5" role="alert" id="myAlert">
                        <center>
                          <h4 class="alert-heading">Great!</h4>
                          <strong>Account Activated Successfully</strong>
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </center>
                      </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="result fail">
                    <div class="alert alert-danger alert-dismissible fade show mt-5 mb-5" role="alert" id="myAlert">
                        <center>
                          <h4 class="alert-heading">Oops!</h4>
                          <strong>Couldn't Activate your account</strong>
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </center>
                      </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

   <script src="static/js/signup.js"></script>
    <script src="static/jquery/dist/jquery.slim.min.js"></script>
    <script src="static/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

</body>
</html>