package HttpServer;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerClass extends Thread {
	
	private ServerSocket servSocket;
	private int port;
	
	public ServerClass(int port) {
		
		try {
			
			this.port = port;
			servSocket = new ServerSocket(port);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.start();
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				new HttpHandler(servSocket.accept()).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
