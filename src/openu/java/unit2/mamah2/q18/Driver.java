package openu.java.unit2.mamah2.q18;

public class Driver {
    public static void main (String [] args){
        X y1 = new Y(2,2);
        X z1 = new Z(5,2);
        Y y2 = new Y(5,2);
        Z z2 = new Z(3, 4);

        System.out.println(y1.foo(2));
        System.out.println(!y2.foo(5));
        System.out.println(y2.foo(2));
        System.out.println(z1.foo(3));
        System.out.println(z2.foo(3));
        System.out.println(!z2.foo(4));
    }
}
