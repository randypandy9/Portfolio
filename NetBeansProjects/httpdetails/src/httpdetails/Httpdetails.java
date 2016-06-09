package httpdetails;

import java.io.*;
import java.net.*;

public class Httpdetails {

    public static void main(String[] args) throws Exception {
        String incoming = "www.uea.ac.uk/~m014436/test_page.html";

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println("Enter URL to dissect:");
            incoming = buffer.readLine();
        } 
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        URL topro = new URL(incoming);
        
        System.out.println("Protocol: " + topro.getProtocol());
        System.out.println("Authority: " + topro.getAuthority());
        System.out.println("Host: " + topro.getHost());
        System.out.println("Port: " + topro.getPort());
        System.out.println("Path: " + topro.getPath());
        System.out.println("Query: " + topro.getQuery());
        System.out.println("Filename: " + topro.getFile());
        System.out.println("-------------------");
        Httpdetails.main(args);
    }
}
