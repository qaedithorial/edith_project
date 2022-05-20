package openu.java.unit2.mamah2.qi789;

public class B extends A {

    private int _x;

    public B(int xA, int xB)  {

        super(xA);
        _x = xB;
    }
    public int getX()  {
        return _x;
    }
    public int superX()  {
        return super.getX();
    }
    public int tenTimesX()  {
        return 10*_x;
    }
    public int subXhelper()  {
        return _x-2;
    }
}