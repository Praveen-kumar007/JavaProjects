//Bero
public abstract class Bero {
 
 protected String beroType;
 protected String beroColour;
 protected double price;
Bero(String beroType, String beroColour){
 this.beroType=beroType;
 this.beroColour=beroColour;
}
public String getBeroType(){
 return beroType;
}
public void setBeroType(String beroType){
 this.beroType=beroType;
}
public String getBeroColour(){
 return beroColour;
}
public void setBeroColour(String beroColour){
 this.beroColour=beroColour;
}
public double getPrice(){
 return price;
}
public void setPrice(double price){
 this.price=price;
}
public abstract void calculatePrice();
}