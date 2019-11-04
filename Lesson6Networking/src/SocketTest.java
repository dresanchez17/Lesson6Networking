
import java.io.*;
import java.net.*;
import java.util.*;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		
		/**
		 * Opens a socket at port 13
		 * Pretty much does the same thing as Telnet code.
		 */
		try(Socket s = new Socket("time-a.nist.gov", 13);
				Scanner in = new Scanner(s.getInputStream(), "UTF-8")) {
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
