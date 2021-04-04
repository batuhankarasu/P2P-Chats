
package p2pchats;

import java.io.*;
import java.net.*;
import java.util.logging.*;




public class MessageListen extends Thread {
    ServerSocket ss;
    int port = 6607;
    MsgInterface mi;
    
    public MessageListen(MsgInterface mi ,int port) {
        this.port = port;
        this.mi = mi;
        
        try {
            ss = new ServerSocket(port);
            
        } catch (IOException ex) {
            Logger.getLogger(MessageListen.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }
    
    public MessageListen() {
        try {
            ss =new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        
        try {
            Socket cs ;
            while((cs = ss.accept()) != null ){
                InputStream is = cs.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader (is));
                String message = br.readLine();
                
                if( message != null){
                    mi.write(message);
                }
                
                
            }
        } catch (IOException ex) {
            System.out.println("Accept hatası");
        }
        
    }
    
    
}
