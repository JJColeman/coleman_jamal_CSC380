import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Socket;
import java.lang.Object;

public class ThreadServer extends Thread
{
    private Socket clientsocket = null;

    public ThreadServer(Socket clientsocket)
    {
        this.clientsocket = clientsocket;
    }

    public boolean tryParseInt(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            inputParseAble = false;
        }

        return inputParseAble;
    }

    public boolean tryParseDouble(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Double.parseDouble(input);
        }
        catch(NumberFormatException e)
        {
            inputParseAble = false;
        }

        return inputParseAble;
    }

    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

            String readLines = "";

            Class<?> mathLogic = Class.forName("MathLogic");
            boolean done = false;

            Method[] methods = mathLogic.getDeclaredMethods();

            while(!done)
            {
                out.println("Choose your method to use, type in the number to use that method");

                for(int i = 0; i < methods.length;i++)
                {
                    out.println((i + 1) + " for: " + methods[i].getName());
                    out.println("To use this method, you must enter in-order a: ");
                    for(int j = 0; j < methods[i].getParameterTypes().length;j++)
                    {
                        out.println(methods[i].getParameterTypes()[j]);
                    }
                }

                out.println((methods.length + 1)+ " for: exit");
                out.println("");

                readLines = in.readLine();

                if((methods.length + 1 == (Integer.parseInt(readLines))))
                {
                    done = true;
                }

                else if ((Integer.parseInt(readLines)) <= methods.length)
                {
                    int choice = 0;
                    for(int x = 0; x < methods.length;x++)
                    {
                        if(((Integer.parseInt(readLines))) == x)
                        {
                             choice = x;
                        }
                    }

                    out.println("Please enter the in the number/text correct");
                    out.println("If there are multiply things that need to be enter, please separate them by comas");
                    out.println("For example: 3993,hello,6.5");
                    out.println("MUST ENTER A DOUBLE or STRING or INTEGER");
                    out.println("The format of the method " + methods[choice] + "is: ");
                    for(int h = 0; h < methods[choice].getParameterTypes().length;h++)
                    {
                        out.println(methods[choice].getParameterTypes()[h]);
                    }
                    out.println("");

                    readLines = in.readLine();

                    String[] userInput = readLines.split(",");
                    Object[] userConverterObjects = new Object[userInput.length];
                    boolean correctFormat = true;

                    if(userInput.length > methods[choice].getParameterTypes().length)
                    {
                       correctFormat = false;
                    }

                    for(int i = 0; i < userConverterObjects.length;i++)
                    {
                        if(tryParseInt(userInput[i]))
                        {
                           userConverterObjects[i] = Integer.parseInt(userInput[i]);
                        }

                        else if(tryParseDouble(userInput[i]))
                        {
                            userConverterObjects[i] = Double.parseDouble(userInput[i]);
                        }

                        else
                        {
                             userConverterObjects[i] = userInput[i];
                        }
                    }

                    if(correctFormat)
                    {
                        Class<?>[] classesParemeters = new Class[methods[choice].getParameterTypes().length];
                        for(int i = 0;i < methods[choice].getParameterTypes().length;i++)
                        {
                            classesParemeters[i] = methods[choice].getParameterTypes()[i].getClass();
                        }

                        Constructor<? extends MathLogic> reflect2 = (Constructor<? extends MathLogic>) mathLogic.getConstructor(methods[choice].getParameterTypes());

                        out.println(methods[choice].invoke(reflect2,(Object) methods[choice].getParameterTypes()));
                    }

                    else
                    {
                        out.println("Incorrect input, please type in this order");
                        out.println("For example input of a method with parameters(int,string,double): 3993,hello,6.5");
                        out.println();
                    }
                }

                else
                {
                    out.println("Wrong format, please use numbers to choose the method or exit");
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

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}