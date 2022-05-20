package openu.java.unit2.mamah2.q18;

public class Y extends X {
    private int _yVal;
     public Y(int xVal, int yVal){
         super(xVal);
         _yVal = yVal;
     }
     public boolean foo(int n){
         return n == _yVal;
     }
     public boolean equals (X obj){
         if(!(obj instanceof Y)){
         //if(_xVal!= obj.xVal || _yVal!=obj.yVal){ - imposible since there is no _yVal or yVal obj in X
             return false;
         }
         return true;
     }
}
