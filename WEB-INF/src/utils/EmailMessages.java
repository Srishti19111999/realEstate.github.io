package utils;

public class EmailMessages{
    public static String getAccountActivationMail(String username,String activationCode){
        String accountActivationMessage = 
        "<!DOCTYPE html>"+
            "<html lang='en'>"+
            "<head>"+
            "<meta charset='UTF-8'>"+
            "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
            "<title>Document</title>"+
            "<link href='https://fonts.googleapis.com/css2?family=Corben:wght@700&display=swap' rel='stylesheet'>"+
            "<style>"+
                "body{"+
                    "margin:0px;"+
                    "padding: 0px;"+
                "}"+
                ".container{"+
                    "height: 1000px;"+
                    "background-color: #dad9f3;"+
                    "width: 100%;"+
                "}"+
                ".header{"+
                    
                    "background-color: #04b;"+
                    "color: #ffffff;"+
                    "position: relative;"+
                "}"+
                ".logo{"+
                    "position: absolute;"+
                    "left: 70px;"+
                    "top: 50px;"+
                "}"+
                ".sitename{"+
                    "position: absolute;"+
                    "left: 250px;"+
                    "top: 70px;"+
                    "padding: 10px 5px;"+
                    "font-family: 'Corben', 'cursive';"+
                    "color: rgb(255, 255, 255);"+
                    " font-size: 30px ;"+
                "}"+
                ".main{"+
                    "padding: 4em ;"+
                    "font-size: 16px;"+
                    "color:#03024b;"+
                    "font-family: 'Times New Roman', Times, serif;"+
                "}"+
                "a{"+
                    "text-decoration: none;"+
                    "font-family: Georgia, 'Times New Roman', Times, serif;"+
                    "font-weight: 900;"+
                    "padding: 5px 8px;"+
                    "background-color:#03024b;"+
                    "color:#ffffff;"+
                    "font-size: 16px;"+
                    "border-radius:5px ;"+
                    "box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);"+
                "}"+
            "</style>"+
        "</head>"+
        "<body>"+
            "<div class='container'>"+
                "<div class='header'>"+
                    "<div class='logo'>"+
                        "<img src='https://1.bp.blogspot.com/-zEIss_CLX_k/X5mMjWwrTvI/AAAAAAAAAAM/uYfjyvYDnDUNc3ShZGD27hFhwBaiDXNDgCLcBGAsYHQ/s320/PicsArt_10-07-02.26.27.png' alt='logo' height='55' width='80'>"+
                    "</div>"+
                    "<div class='sitename'>"+
                        "<h1>Pick a Brick</h1>"+
                    "</div>"+
                "</div>"+
                "<div class='main'>"+
                    "<h1 style='color:#b60202;'>Hello "+username+"</h1>"+
                    "<h2>"+
                        "Thank you for registering to our site.<br /><br />"+
                        "We want to let you know that your your registeration is successful.<br />"+
                        "Now, click on the link below to activate your account."+
                    "</h2>"+
                    "<br />"+
                    "<a href='http://localhost:8080/realEstate/activate.do?user="+username+"&code="+activationCode+"'>Activate Account</a>"+
                "</div>"+                
            "</div>"+
        "</body>"+
        "</html>";

        return accountActivationMessage;
    }
}