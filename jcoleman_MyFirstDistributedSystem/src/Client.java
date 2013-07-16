import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try
        {
            clientSocket = new Socket("",77);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        String readLines = "";
        String userInput = "";
        Scanner scan = new Scanner(System.in);
        boolean done = false;

        while(!done)
        {
             readLines = in.readLine();
             if(readLines.equals(""))
             {
                 userInput = scan.nextLine();
                 out.println(userInput);
             }

             else
             {
                   System.out.println(readLines);
             }
        }

        out.close();
        in.close();
        clientSocket.close();
    }

    static public boolean checkInput(String input)
    {
        boolean check =
            input.equals("Insert Now") ||
            input.equals("Insert the first number") ||
            input.equals("Insert the first number") ||
            input.equals("Insert the second number to add to the first number") ||
            input.equals("Insert the second number to subtract to the first number");

        return check;
    }
}
