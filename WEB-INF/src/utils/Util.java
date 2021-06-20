package utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.servlet.ServletContext;

public class Util{
	public static void streamPic(ServletContext context,OutputStream os,String picPath) throws IOException{		
		InputStream is = context.getResourceAsStream(picPath);
		
		byte[] arr = new byte[1024];
		int count = 0;

		while((count=is.read(arr))!=-1){
			os.write(arr);
		}

		os.flush();
		os.close();
	}
}