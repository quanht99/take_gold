
public class Person extends Thread{
    public int person_number;
    public String status;
    public Door door;
    public Bridge bridge;
    public int turn;

    public Person(int num, int turn, Door door, Bridge bridge){
        this.person_number = num;
        this.status = "Đợi";
        this.bridge = bridge;
        this.door = door;
        this.turn=turn;
    }

    public void run(){
        try {
            while(bridge.number_of_gold > 0){
                door.start_holding_gate(this);
                bridge.cross_bridge_and_get_gold(this);
            }
            this.setStatus("Stopped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setStatus(String status){
        this.status = status;
    }

}
