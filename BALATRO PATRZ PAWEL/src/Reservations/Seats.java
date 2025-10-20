package src.Reservations;
public class Seats{
    private final boolean VIP;
    private final int ROW;
    private final int SEAT_NUMBER;
    private int priceRange;
    private double price;
    private int roomNumber;
    static double[] prices = {15.99d, 25.99d, 30.99d, 60.99d};
    public Seats(int row, int num, int priceRange, boolean vip, int room){
        if(vip){
            this.priceRange = 3;
        }else{
            if(priceRange >= 0 && priceRange <= 2){
                this.priceRange = priceRange;
            }else{
                throw new IllegalArgumentException("ERROR: invalid price range");
            }
        }
        this.ROW = row;
        this.SEAT_NUMBER = num;
        this.VIP = vip;
        this.price = prices[priceRange];
        this.roomNumber = room;
    }
    public void setPriceRange(int priceRange){
        if(!this.VIP){
            if(priceRange >= 0 && priceRange <= 2){
                this.priceRange = priceRange;
            }else{
                throw new IllegalArgumentException("ERROR: invalid price range");
            }    
        }    
    }
    public int getPriceRange(){
        return this.priceRange;
    }
    public int getRow(){
        return this.ROW;
    }
    public double getPrice(){
        return this.price;
    }
    public int getSeatNum(){
        return this.SEAT_NUMBER;
    }
    public boolean isVIP(){
        return this.VIP;
    }
    public void displayInfo(){
        System.out.printf("Number: %d Row: %d Price: %f Vip seat: %b", this.SEAT_NUMBER, this.ROW, this.price, this.VIP);
    }
    public int getScreeningRoom() {
        return this.roomNumber;
    }
}
