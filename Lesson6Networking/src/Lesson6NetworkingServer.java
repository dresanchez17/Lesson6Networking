import java.io.*;
import java.net.*;
import java.util.*;

public class Lesson6NetworkingServer {
	public static void main(String[] args) throws IOException {
		int port;
		if (args.length == 2) {
			port = Integer.parseInt(args[1]);
		}
		else {
			port = 8080;
		}
		System.out.println("Server running on port: " + port);
		
		try (ServerSocket s = new ServerSocket(port)){
			System.out.println("Waiting for connection...");
			try(Socket incoming = s.accept()){
				System.out.println("Connected");
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				try(PrintWriter out = new PrintWriter(
						new OutputStreamWriter(outStream,"UTF-8"), true)) {
					out.println("<html>");
					out.println("<head><title>Java Networking</title></head>");
					out.println("<body>");
					out.println("<h1>Java Networking</h1>");
					out.println("</html>");
				}
			}
		}
	}
}
