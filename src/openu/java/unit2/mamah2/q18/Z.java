package openu.java.unit2.mamah2.q18;

public class Z extends X{
    private int _zVal;

    public Z(int xVal, int zVal){
        _zVal = zVal;
    }
    public boolean foo(int n){
        return n == _zVal;
    }
}
