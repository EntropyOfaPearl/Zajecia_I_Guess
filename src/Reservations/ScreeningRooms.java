package src.Reservations;
import src.CinemaManagment.*;

public class ScreeningRooms implements Interface{
    private int room_number;
    private int floor;
    private Seats[][] seatList;
    public ScreeningRooms(int room_number, int floor, int rows, int seats){
        if(rows < 10){
            throw new IllegalArgumentException("Please insert at least 10 rows of seats");
        }
        if(seats < 100){
            throw new IllegalArgumentException("Please insert at least 10 seats per row");
        }
        if(seats%rows != 0 ){
            throw new IllegalArgumentException("please have an even amount of seats in each row.");
        }
        int seatsPerRow = seats/rows;
        this.seatList = new Seats[rows][seatsPerRow];
        int seat = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < seatsPerRow; j++){
                this.seatList[i][j] = new Seats(i, seat, 0, false, room_number);
                seat +=1;
            }
        }
        for(int i = 0; i < seatsPerRow; i++){
            this.seatList[4][i]= new Seats(4, seat, 3 , true, room_number);
            seat+=1;
        }
        for(int i = 5; i < 8; i++){
            for(int j = 0; j<seatsPerRow; j++){
                this.seatList[i][j] = new Seats(i,seat,1, false, room_number);
                seat+=1;
            }
        }
        for(int i = 8; i < rows; i++){
            for(int j = 0; j<seatsPerRow; j++){
                this.seatList[i][j] = new Seats(i,seat,2, false, room_number);
                seat+=1;
            }
        }
        this.floor = floor;
        if(Cinema.getRoomByNumber(room_number) == null){
            this.room_number = room_number;
        }else{
            throw new IllegalArgumentException("ERROR: this room already exists");
        }
    }
    public int getRoomNumber() {
        return this.room_number;
    }
    public int getFloor(){
        return this.floor;
    }
    @Override
    public void displayInfo(){
        System.out.printf("Details: %n %n Room number: %d floor: %d",this.room_number, this.floor);
        System.out.println("Displaying the layout of the screening room.");
        for(int i = 0; i < this.seatList.length; i++){
            System.out.printf("Row %d :   ", i);
            for(int j = 0; j < this.seatList[i].length; j++){
                System.out.printf(" %d ",this.seatList[i][j].getSeatNum());
            }
            System.out.printf("%n");
        }
    }
    public Seats getSeatByNumber(int num){
        for(int i = 0; i < seatList.length; i++){
            for(int j = 0; j < seatList[i].length; j++){
                if(this.seatList[i][j].getSeatNum() == num){
                    return this.seatList[i][j];
                }
            }
        }
        return null;
    }

}
