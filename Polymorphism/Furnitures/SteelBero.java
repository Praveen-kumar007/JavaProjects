public class SteelBero extends Bero{
private int beroHeight;
public int getBeroHeight(){
 return beroHeight;
}
public void setBeroHeight(int beroHeight){
 this.beroHeight=beroHeight;
}
public SteelBero(String beroType,String beroColour,int beroHeight){
 super(beroType,beroColour);
 this.beroHeight=beroHeight;
}
public void calculatePrice() {
 double totalPrice=0;
 if(beroHeight==3){
 totalPrice=5000;
 }
 else if (beroHeight==5){
 totalPrice=8000;
 }
 else if (beroHeight==7){
 totalPrice=10000;
 } 
 setPrice(totalPrice);
}
}