import java.io.*;
import java.net.*;
import java.util.*;

public class Lesson6NetworkingClient {
	public static void main(String[] args) throws IOException {
		
		String host;
		int port;
		
		if (args.length == 4) {
			host = args[1];
			port = Integer.parseInt(args[3]);
		}
		else {
			port = 8080;
			host = "127.0.0.1";
		}

		try{
			Socket s = new Socket(host, port);
			Scanner in = new Scanner(s.getInputStream(), "UTF-8");
			System.out.println("host: " + host);
			System.out.println("port: " + port);
			System.out.println();
			
			while(in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
		finally {
			System.out.println("Done");
		}
	}
}
