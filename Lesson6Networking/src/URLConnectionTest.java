import java.io.*;
import java.net.*;
import java.util.*;

public class URLConnectionTest {
	public static void main(String[] args) {
		try {
			String urlName;
			if (args.length > 0) urlName = args[0];
			else urlName = "http://horstmann.com";
			
			System.out.println("Creating url form " + urlName);
			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			
			System.out.println("connection...");
			connection.connect();
			
			System.out.println("getting headers...");
			Map<String, List<String>> headers = connection.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
				String key = entry.getKey();
				for (String value : entry.getValue()) {
					System.out.println(key + ": " + value);
				}
			}
			
			System.out.println("getContentType: " + connection.getContentType());
			System.out.println("getContentLenght: "+ connection.getContentLength());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
