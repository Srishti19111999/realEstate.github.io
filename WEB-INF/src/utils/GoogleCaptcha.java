package utils;

 import java.io.*;
 import java.net.URL;
 import java.net.HttpURLConnection;
 import javax.json.Json;
 import javax.json.JsonReader;
 import javax.json.JsonObject;

 public class GoogleCaptcha{
     public static boolean checkRecaptcha(String captchaResponse)throws IOException{
        String reCaptchaURL = "https://www.google.com/recaptcha/api/siteverify";
        String parameter = "secret=6Le4xdcZAAAAAGJdOaHgbdctcqZG4vtNsZ-h6Z2f"+"&response="+captchaResponse;
        URL url = new URL(reCaptchaURL+"?"+parameter);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        //A URL connection can be used for input and/or output. Set the DoOutput flag to true if you intend to use the URL connection for output, false if not. The default is false.
        con.setDoOutput(true);

        DataOutputStream dos = new DataOutputStream(con.getOutputStream());
        dos.flush();
        dos.close();
        InputStream inputStream;

        int status = con.getResponseCode();
        if(status != HttpURLConnection.HTTP_OK){
            inputStream = con.getErrorStream();
        }else{
            inputStream = con.getInputStream();
        }

        JsonReader jsonReader =	Json.createReader(inputStream);	
        JsonObject jsonObject =	jsonReader.readObject();
        boolean flag = jsonObject.getBoolean("success");

        return flag;
    }
 }