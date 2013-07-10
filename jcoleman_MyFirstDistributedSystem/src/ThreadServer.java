import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/9/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadServer extends Thread
{
    private Socket clientsocket = null;

    public ThreadServer(Socket clientsocket)
    {
        this.clientsocket = clientsocket;
    }

    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

            String inputLine = "";
            String readLines = "";

            MathLogic mathLogic = new MathLogic();
            out.println("Server:'Received a connection'");
            out.flush();
            out.println("Type in 'add' to do addition");
            out.flush();
            out.println("Type in 'subtract' to do subtraction");
            out.flush();
            out.println("Type in 'exit' to end your session");
            out.flush();
            out.println("Insert Now");
            out.flush();

            while((readLines = in.readLine()) != null ||
                    (readLines = in.readLine()).equals("") ||
                    (readLines = in.readLine()) == null)
            {
                out.println("Insert Now");
                out.flush();

                if(readLines.matches("[0-9]*,[0-9]*,add"))
                {
                    String[] split = readLines.split(",");
                    int firstNumber = Integer.parseInt(split[0]);
                    int secondNumber = Integer.parseInt(split[1]);
                    int totalNumber = 0;
                    totalNumber = mathLogic.add(firstNumber,secondNumber);
                    out.println(totalNumber);
                    out.flush();
                }

                else if(readLines.matches("[0-9]*,[0-9]*,subtract"))
                {
                    String[] split = readLines.split(",");
                    int firstNumber = Integer.parseInt(split[0]);
                    int secondNumber = Integer.parseInt(split[1]);
                    int totalNumber = 0;
                    totalNumber = mathLogic.subtract(firstNumber,secondNumber);
                    out.println(totalNumber);
                    out.flush();
                }

                else if(readLines.equals("exit"))
                {
                    out.close();
                    in.close();
                    clientsocket.close();
                    break;
                }
            }

            out.close();
            in.close();
            clientsocket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
