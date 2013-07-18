import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class ThreadServer extends Thread
{
    private Socket clientsocket = null;

    public ThreadServer(Socket clientsocket)
    {
        this.clientsocket = clientsocket;
    }

    public boolean tryParseByte(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Byte.parseByte(input);
        }
        catch(NumberFormatException e)
        {
            inputParseAble = false;
        }

        return inputParseAble;
    }

    public boolean tryParseShort(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Short.parseShort(input);
        }
        catch(NumberFormatException e)
        {
            inputParseAble = false;
        }

        return inputParseAble;
    }

    public boolean tryParseInteger(String input)
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

    public boolean tryParseLong(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Long.parseLong(input);
        }
        catch(NumberFormatException e)
        {
            inputParseAble = false;
        }

        return inputParseAble;
    }

    public boolean tryParseFloat(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Float.parseFloat(input);
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

    public boolean tryParseBoolean(String input)
    {
        boolean inputParseAble = true;
        try
        {
            Boolean.parseBoolean(input);
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

            String path = "src";
            File folder = new File(path);
            List<Class> classes = new ArrayList<Class>();

            for(int i=0;i < folder.listFiles().length;i++)
            {
                Class grabbingClass = Class.forName(folder.listFiles()[i].getName().replaceFirst(".java",""));
                classes.add(grabbingClass);
            }

            out.println("Type in one of the following classes to use");

            for(Class l : classes)
            {
                out.println(l.getName());
            }

            out.println("");
            readLines = in.readLine();

            Class <?> UsingClass = Class.forName(readLines);
            boolean done = false;
            Method[] methods = UsingClass.getDeclaredMethods();

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
                        if(((Integer.parseInt(readLines))) == x + 1)
                        {
                             choice = x;
                        }
                    }

                    out.println("Please enter the in the number/text correct");
                    out.println("If there are multiply things that need to be enter, please separate them by comas");
                    out.println("For example: 3993,hello,6.5,WIll 5.5");
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

                    if(correctFormat)
                    {
                        for(int i = 0; i < userConverterObjects.length;i++)
                        {
                            if(methods[choice].getGenericParameterTypes()[i].equals(Integer.TYPE))
                            {
                                boolean isInt = tryParseInteger(userInput[i]);
                                if(isInt)
                                {
                                    userConverterObjects[i] = Integer.parseInt(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Byte.TYPE))
                            {
                                boolean isByte = tryParseByte(userInput[i]);
                                if(isByte)
                                {
                                    userConverterObjects[i] = Byte.parseByte(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Short.TYPE))
                            {
                                boolean isShort = tryParseShort(userInput[i]);
                                if(isShort)
                                {
                                    userConverterObjects[i] = Short.parseShort(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Long.TYPE))
                            {
                                boolean isLong = tryParseLong(userInput[i]);
                                if(isLong)
                                {
                                    userConverterObjects[i] = Long.parseLong(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Float.TYPE))
                            {
                                boolean isFloat = tryParseFloat(userInput[i]);
                                if(isFloat)
                                {
                                    userConverterObjects[i] = Float.parseFloat(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Double.TYPE))
                            {
                                boolean isDouble = tryParseDouble(userInput[i]);
                                if(isDouble)
                                {
                                    userConverterObjects[i] = Double.parseDouble(userInput[i]);
                                }
                            }

                            else if(methods[choice].getGenericParameterTypes()[i].equals(Boolean.TYPE))
                            {
                                boolean isBoolean = tryParseBoolean(userInput[i]);
                                if(isBoolean)
                                {
                                    userConverterObjects[i] = Boolean.parseBoolean(userInput[i]);
                                }
                            }

                            else
                            {
                                userConverterObjects[i] = userInput[i];
                            }
                        }

                        Method UsingMethod =  UsingClass.getDeclaredMethod(methods[choice].getName(), methods[choice].getParameterTypes());
                        Object usingClass = UsingClass.newInstance();
                        out.println(UsingMethod.invoke(usingClass,userConverterObjects));

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