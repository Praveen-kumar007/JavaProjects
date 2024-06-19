public class WoodenBero extends Bero{
private String woodType;
public WoodenBero(String beroType, String beroColour, String woodType){
 super(beroType,beroColour);
 this.woodType=woodType;
}
public void setWoodType(String woodType){
 this.woodType=woodType;
}
public String getWoodType(){
 return woodType;
}
public void calculatePrice() {
 double totalPrice=0;
 if(woodType.equals("Ply Wood")){
 totalPrice=15000;
 }
 else if (woodType.equals("Teak Wood")){
 totalPrice=12000;
 }
 else if (woodType.equals("Engineered Wood")){
 totalPrice=10000;
 } 
 setPrice(totalPrice);
}
}