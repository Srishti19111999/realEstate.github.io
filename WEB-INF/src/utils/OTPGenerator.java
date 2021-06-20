package utils;

import java.util.Random;

public class OTPGenerator{
    public static String generateOTP(){
        StringBuffer sb = new StringBuffer();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        
        for(int i=0;i<6;i++){
            if(r.nextInt(10)%2==0)
                sb.append(r.nextInt(10));
            else if(r.nextInt(10)%3==0)
                sb.append(str.toLowerCase().charAt(r.nextInt(10)));
            else
                sb.append(str.charAt(r.nextInt(10)));
        }
        return sb.toString();
    }
}