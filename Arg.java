class test
{
public void add(int i,int j)
{

int s=i+j;
System.out.println("Sum is"+s);
}
}
public class Arg
{
public static void main(String args[])
{
test t1=new test();
int a=10;
int b=20;
t1.add(a,b);
}
}