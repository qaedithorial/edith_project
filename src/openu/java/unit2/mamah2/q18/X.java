package openu.java.unit2.mamah2.q18;

public abstract class X {
    protected int _xVal;

    public  X(){
        _xVal = 3;
    }
    public X(int xVal){
        _xVal = xVal;
    }

    public  abstract boolean foo(int n);

    public boolean equals (Object obj){
        if(!(obj instanceof X)){
            return false;
        }
        return true;
    }
}

