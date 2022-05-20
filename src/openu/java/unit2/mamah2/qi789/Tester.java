package openu.java.unit2.mamah2.qi789;

public class Tester {
    public static void main(String [] args)

    {
        A a = new A(1);
        A b = new B(2, 22);
        B bb = (B)b;
        System.out.println(bb.superX());
    }
}
