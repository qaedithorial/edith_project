package openu.java.unit2.mamah2.qi1011;

public class BB extends AA {
    private String _st;
    public BB (){
        _st="bb";
    }
    public BB(String st, int val){
        super(val);
        _st=st;
    }
    public String getSt(){
        return _st;
    }
// שימו לב במחלקה BB יש 3 שיטות שונות בשם equals //

    public boolean equals (Object ob)//  שיטה 1
    {
        if ((ob != null) && (ob instanceof BB))
        {
            if (_st.equals(((BB)ob)._st)  &&  (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
    public boolean equals (AA ob)  //  שיטה 2
    {
        if ((ob != null) && (ob instanceof BB))
        {
            if (_st.equals(((BB)ob)._st)  && (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
    public boolean equals (BB ob) //  שיטה 3
    {
        if (ob != null)
        {
            if (_st.equals(((BB)ob)._st)  && (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
}