public class student {
private String name;
private int e1;
private int e2;
public static String[] pole = new String[5];

public void setValue(String name,int e1,int e2,int value)
    {
    this.name = name;
    if(e1<0)
        e1=0;
    if(e2<0)
        e2=0;
    this.e1 = e1;
    this.e2 = e2;
        String all,result;
        if((e1+e2)/2>50){
            result = "прошёл";
        }
        else{
            result = "непрошёл";
        }
        all = name + " " + result;
        pole[value] = all;
    }
public String getValue(int i)
{
String all;
all = pole[i];
return all;
}
}
