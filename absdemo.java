abstract class Shape
{
int l,b;
Shape(int x,int y)
{
l=x;
b=y;
}
void dips()
{
System.out.println("Shape disp");
}
abstract int area();
}
class Rect extends Shape
{
Rect(int x,int y)
{
super(x,y);
}
void disp()
{
System.out.println("Rectangle disp");
}
int area()
{
return (l*b);
}
}
public class absdemo
{
public static void main(String args[])
{
Rect r=new Rect(10,20);
r.disp();
int a=r.area();
System.out.println("Area is "+a);
}
}