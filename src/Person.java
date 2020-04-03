
public class Person extends Thread{
    public int person_number;
    public String status;
    public Door door;
    public Bridge bridge;

    public Person(int num, Door door, Bridge bridge){
        this.person_number = num;
        this.status = "Đợi";
        this.bridge = bridge;
        this.door = door;
    }

    public void run(){
        try {
            door.start_holding_gate(this);
            bridge.cross_bridge_and_get_gold(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setStatus(String status){
        this.status = status;
    }

}
