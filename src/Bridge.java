import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Bridge {
    public Semaphore mutex = new Semaphore(1);
    public int number_of_gold;

    public Bridge(int gold){
        this.number_of_gold = gold;
    }

    public void cross_bridge_and_get_gold(Person person) throws InterruptedException {

        if(person.bridge.number_of_gold > 0){
            while (!this.bridge_is_free()){

            }
            this.mutex.acquire();
            person.door.stop_holding_gate();
            if(this.number_of_gold > 0){
                this.number_of_gold--;
                person.turn--;
                person.setStatus("Get Gold            ");
                sleep(500);
            }else{
                person.setStatus("On bridge + not gold");
            }
            go_out();
        }else{
            person.door.stop_holding_gate();
        }
        person.setStatus("Đợi                 ");
    }

    public void go_out(){
        this.mutex.release();
    }

    boolean bridge_is_free(){
        return this.mutex.availablePermits() > 0;
    }


}
