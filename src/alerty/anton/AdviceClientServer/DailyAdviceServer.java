package alerty.anton.AdviceClientServer;
import java.net.*;
import java.io.*;

public class DailyAdviceServer {

	String[] adviceArray = {"Don`t eat raw tomates", "Earn more money",  "Travel more", "Get married before you die" };
	
	
	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	public void go() {
		try {
			ServerSocket servSock = new ServerSocket(4242);
			
			while (true) {
				Socket sock = servSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println("servSide " + advice);
			}
		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceArray.length);
		return adviceArray[random];
	}
}
