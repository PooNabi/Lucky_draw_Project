

package luckyflow;

import java.sql.*;
import java.util.*;

public class LuckyPeople {
public static void main(String[] args) throws Exception {
	Random r=new Random();
	Scanner sc=new Scanner(System.in);
	boolean f=true;
	while(f)
	{
		System.out.println("Choose valid option");
		System.out.println("1. Enter into game");
		System.out.println("2. Exit");
		switch(sc.nextInt())
		{
		case 1: {
			int SG[] =new int[5];
			for(int i=0;i<5;i++)
			{
				SG[i]=r.nextInt(9);
			}
			//System.out.println(Arrays.toString(SG));
			System.out.println("Enter slno");
			int slno=sc.nextInt();
			System.out.println("Enter Your Name");
			String name=sc.next();
			
			int UE[]=new int[5];
			int Credits=0;
			for(int i=0;i<5;i++)
			{
				System.out.println("Enter number");
				UE[i]=sc.nextInt();
				if(UE[i]==SG[i])
				{
					Credits+=10;
					System.out.println("Lucky");
				}
				else
				{
					System.out.println("Ooops");
				}
			}
			System.out.println("System generated numbers are"+Arrays.toString(SG));
			System.out.println("Numbers entered by you"+Arrays.toString(UE));
			System.out.println("Total points earned by "+name+"are "+Credits);
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/luckyflow","root","root");
			PreparedStatement p=c.prepareStatement("insert into luckies values(?,?,?,?,?)");
			p.setInt(1, slno);
			p.setString(2, name);
			p.setString(3, Arrays.toString(SG));
			p.setString(4, Arrays.toString(UE));
			p.setInt(5, Credits);
			int i=p.executeUpdate();
			c.close();
			
			
		}
		break;
		case 2:
		{
			System.out.println("Thank You");
		}
		break;
		default:
		{
			System.out.println("Enter the valid option");
		}
		}
	}
	
}
}
