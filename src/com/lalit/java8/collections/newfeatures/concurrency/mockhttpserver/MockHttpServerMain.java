package com.lalit.java8.collections.newfeatures.concurrency.mockhttpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//TODO Implement Mock Http Server who can receive request and send back response
public class MockHttpServerMain {

    public static void main(String... s) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Wow! I got my first Client");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    // if (line.equalsIgnoreCase("")) {
                    // break;
                    //    } else
                    // line = bufferedReader.readLine();

                }
            }catch(Exception e){
                    e.printStackTrace();
                } finally{
                    // bufferedReader.close();
                }

            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("HTTP/1.0 200 OK");
            pw.println("Content-type: text/html");
            pw.println();
            pw.println("<html><body>Welcome</body></html>");
            pw.close();
            clientSocket.close();
        }
    }
}

