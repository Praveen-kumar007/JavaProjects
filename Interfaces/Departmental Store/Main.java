import java.util.Scanner;
public class Main {
public static void main(String[] args) {
 Scanner sc = new Scanner (System.in);
 
 System.out.println("Enter the customer name");
 String cname=sc.nextLine();
 System.out.println("Enter the phone number");
 String pno=sc.nextLine();
 System.out.println("Enter the street name");
 String streetname=sc.nextLine();
 System.out.println("Enter the bill Amount");
 double billAmount=Double.parseDouble(sc.nextLine());
 System.out.println("Enter the distance");
 int distance=Integer.parseInt(sc.nextLine());
 CustomerDetails cd=new 
CustomerDetails(cname,pno,streetname,billAmount,distance);
 System.out.println("Customer name "+cd.getCustomerName());
 System.out.println("phone number "+cd.getPhoneNumber());
 System.out.println("Street name "+cd.getStreetName());
 System.out.println("Bonus points "+cd.calculateBonusPoints());
 System.out.println("Delivery charge "+cd.deliveryCharge());
}
}
