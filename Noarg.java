class test
{
public int add()
{
int i=10;
int j=20;
int s=i+j;
return s;

}
}
public class Noarg
{
public static void main(String args[])
{
int s;
test t1=new test();
s=t1.add();
System.out.println("Sum is "+s);

}
}