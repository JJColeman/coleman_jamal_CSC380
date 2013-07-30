import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/27/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
    public static void main(String [] args) throws IOException
    {
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try
        {
            HttpURLConnection conn1 = (HttpURLConnection) new URL("http://localhost:8080/RestServlet").openConnection();
            conn1.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            String input1 = "";
            String result1 = "";
            while((input1=in.readLine()) !=null){
                result1 += input1 + "\n";
            }
            System.out.println(result1);

            HttpURLConnection conn2 = (HttpURLConnection) new URL("http://localhost:8080/PickOrder").openConnection();
            conn2.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
            String input2 = "";
            String result2 = "";
            while((input2=in.readLine()) !=null){
                result2 += input2 + "\n";
            }
            System.out.println(result2);

            HttpURLConnection conn3 = (HttpURLConnection) new URL("http://localhost:8080/GrabOrder").openConnection();
            conn3.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(conn3.getInputStream()));
            String input3 = "";
            String result3 = "";
            while((input3=in.readLine()) !=null){
                result3 += input3 + "\n";
            }
            System.out.println(result3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
