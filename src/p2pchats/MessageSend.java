
package p2pchats;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MessageSend extends Thread {
    String message,hostname;
    int port ;

    public MessageSend(String message, String hostname, int port) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname,port);
            s.getOutputStream().write(message.getBytes());
            s.close();
            
        } catch (IOException ex) {
            System.out.println("bağlanılamadı");
        }
        
        
    }
    
}
