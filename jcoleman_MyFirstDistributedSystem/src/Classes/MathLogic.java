package Classes;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/9/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class MathLogic
{
    public MathLogic(){}

    public int subtract(int a, int b)
    {
        return a - b;
    }

    public int add(int a, int b)
    {
        return a + b;
    }

    public int add(int a) {
        return a;
    }

    public int fight(int a, Rogue l)
    {
       return a + l.happy;
    }

    public int l(Rogue l)
    {
        return l.happy;
    }
}
