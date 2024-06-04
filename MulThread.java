import java.lang.Thread.*;
class A extends Thread
{
 String Tname;
 A(String name)
 {
  Tname=name;
  System.out.println("Creating thread "+Tname);
 }
 public void run()
 {
  for(int i=1;i<=5;i++)
  {
   System.out.println("From thread A "+i);
  }
  System.out.println("Thread A is over");
 }
}
class B extends Thread
{
 String Tname;
 B(String name)
 {
  Tname=name;
  System.out.println("Creating thread "+Tname);
 }
 public void run()
 {
  for(int i=1;i<=5;i++)
  {
   System.out.println("From thread B "+i);
  }
  System.out.println("Thread B is over");
 }
}
class C extends Thread
{
 String Tname;
 C(String name)
 {
  Tname=name;
  System.out.println("Creating thread "+Tname);
 }
 public void run()
 {
  for(int i=1;i<=5;i++)
  {
   System.out.println("From thread C "+i);
   if(i==3)
   {
	   stop();
   }
  }
  System.out.println("Thread C is over");
 }
}
class MulThread
{
 public static void main(String args[])throws Exception
 {
  A a=new A("Thread A");
  System.out.println("A is Alive?"+a.isAlive());
  B b=new B("Thread B");
  System.out.println("B is Alive?"+b.isAlive());
  C c=new C("Thread C");
  c.start();
  b.start();b.join(); a.start();
  System.out.println("C is Alive?"+c.isAlive());
 }
}
