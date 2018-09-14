package nia.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kerr.
 *
 * Listing 1.1 Blocking I/O example
 */
public class BlockingIoExample {

    /**
     * Listing 1.1 Blocking I/O example
     * */
    public void serve(int portNumber) throws IOException {
        //创建socket 监听端口的连接请求
        ServerSocket serverSocket = new ServerSocket(portNumber);
        //accept() blocking 一直阻塞到一个connect establish
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        //readLine() blocking until input
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            //处理请求
            response = processRequest(request);
            out.println(response);
        }
    }

    private String processRequest(String request){
        return "Processed";
    }
}
