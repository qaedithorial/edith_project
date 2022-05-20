package openu.java.unit2.mamah2.qi789;

public class A {

    private int _x;

    public A(int x)  {
        _x = x;
    }
    public int getX()   {
        return _x;
    }
    public int doubleX()  {
        return 2*getX();
    }
    public int tripleX()   {
        return 3*_x;
    }
    public int subXhelper()  {
        return _x-1;
    }
    public int subX()  {
        return subXhelper();
    }
}