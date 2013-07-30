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
            HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:8080/RestServlet").openConnection();
            conn.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input = "";
            String result = "";
            while((input=in.readLine()) !=null){
                result += input;
            }
            System.out.println(result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
