import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = null;

        try
        {
            server = new ServerSocket(77);
            System.out.println("Server is made at port 77");
        }
        catch (IOException e)
        {
            System.out.println("Can't listen to this port: 77");
        }

        while(true)
        {
            Socket clientSocket = null;
            try
            {
                clientSocket = server.accept();
                new ThreadServer(clientSocket).start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                server.close();
            }
        }
    }
}
