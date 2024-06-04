import java.io.*;
import java.util.*;
class LineMerge
{
	public static void main(String args[])
	{
		FileReader fr1;
		FileReader fr2;
		BufferedReader br1;
		BufferedReader br2;
		try
		{
			fr1= new FileReader(new File("text1.txt"));
			fr2= new FileReader(new File("text2.txt"));
			br1= new BufferedReader(fr1);
			br2= new BufferedReader(fr2);
			String data1= br1.readLine();
			String data2= br2.readLine();
			while(data1!=null && data2!=null)
			{
				System.out.println(data1);
				System.out.println(data2);
				data1= br1.readLine();
				data2= br2.readLine();
			}
			br1.close();
			br2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}