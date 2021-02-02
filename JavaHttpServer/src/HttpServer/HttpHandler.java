package HttpServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpHandler extends Thread{
	
	private Socket socket;
	
	private InputStream inStream;
	private OutputStream outStream;
	
	public HttpHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		System.out.println("connect " + socket.getPort() + " " + socket.getInetAddress());
		
        try {
            System.out.printf("New Client Connect! Connected IP : %s, Port : %d\n",
                    socket.getInetAddress(), socket.getPort());

            inStream = socket.getInputStream();
            outStream = socket.getOutputStream();
            
            DataOutputStream dos = new DataOutputStream(outStream);
            byte[] body = "Hello World".getBytes();
            
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("\r\n");
            
            dos.write(body, 0, body.length);
            dos.writeBytes("\r\n");
            dos.flush();
    		
            urlReader url = new urlReader(inStream);
            System.out.println(url.getData("test"));
            
            dos.close();
            inStream.close();
            socket.close();
        }catch (IOException e) {
			e.printStackTrace();
        }

		
	}
}
