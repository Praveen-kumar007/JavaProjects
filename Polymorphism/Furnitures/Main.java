import java.util.Scanner;
public class Main {
public static void main(String[] args) {
 
 double TotalPrice=0;
 Discount d=new Discount();
 Scanner sc = new Scanner(System.in);
 
 System.out.println("Enter Customer Name");
 String cname=sc.nextLine();
 System.out.println("Enter Phone Number");
 long phno=Long.parseLong(sc.nextLine());
 System.out.println("Enter address");
 String ads=sc.nextLine();
 System.out.println("Enter Bero Type");
 String btype=sc.nextLine();
 System.out.println("Enter Bero Colour");
 String bColour=sc.nextLine();
 
 if(btype.equals("Wooden Bero")){
 System.out.println("Enter Wood Type");
 String wType=sc.nextLine();
 
 WoodenBero wb = new WoodenBero(btype,bColour,wType);
 
 wb.calculatePrice();
 TotalPrice= wb.getPrice()-d.calculateDiscount(wb);
 
 System.out.printf("Amount needs to be paid 
Rs.%.2f",TotalPrice);
 }
 
 else if (btype.equals("Steel Bero")){
 System.out.println("Enter Bero Height");
 int height=Integer.parseInt(sc.nextLine());
 
 SteelBero sb =new SteelBero(btype,bColour,height);
 
 sb.calculatePrice();
 TotalPrice=sb.getPrice()-d.calculateDiscount(sb);
 
 System.out.printf("Amount needs to be paid 
Rs.%.2f",TotalPrice);
 
 } 
}
}
