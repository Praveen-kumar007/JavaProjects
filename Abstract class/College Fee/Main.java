import java.util.Scanner;
public class UserInterface {
public static void main(String[] args) {
 
 Scanner sc = new Scanner(System.in);
 
 System.out.println("Enter Student Id");
 int studentId= Integer.parseInt(sc.nextLine());
 System.out.println("Enter Student name");
 String name=sc.nextLine();
 System.out.println("Enter Department name");
 String deptName=sc.nextLine();
 System.out.println("Enter gender");
 String gender=sc.nextLine();
 System.out.println("Enter category");
 String category=sc.nextLine();
 System.out.println("Enter College fee");
 double collegeFee=Double.parseDouble(sc.nextLine());
 
 if(category.equals("DayScholar")){
 System.out.println("Enter Bus number");
 int busNumber=Integer.parseInt(sc.nextLine());
 System.out.println("Enter the distance");
 int distance=Integer.parseInt(sc.nextLine());
 
 DayScholar dayScholar=new DayScholar(studentId, name, deptName, gender,
category, collegeFee, busNumber, distance);
 System.out.println("Total College fee is 
"+dayScholar.calculateTotalFee());
 }
 else{
 System.out.println("Enter the room number");
 int roomNumber=Integer.parseInt(sc.nextLine());
 System.out.println("Enter the Block name");
 char blockName=sc.nextLine().charAt(0);
 System.out.println("Enter the room type");
 String roomType=sc.nextLine();
 
 Hosteller hosteller=new 
Hosteller(studentId,name,deptName,gender,category,collegeFee,roomNumber,blockName,r
oomType);
 System.out.println("Total College fee is 
"+hosteller.calculateTotalFee());
 }
 
}
}