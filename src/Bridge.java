import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Bridge {
    public Semaphore mutex = new Semaphore(1);
    public int number_of_gold;
    public Bridge(int gold){
        this.number_of_gold = gold;
    }
    public void cross_bridge_and_get_gold(Person person) throws InterruptedException {
        while (!this.bridge_is_free()){

        }
        person.door.stop_holding_gate();
        mutex.acquire();
        if(this.number_of_gold > 0){
            this.number_of_gold--;
            person.setStatus("Get Gold");
            sleep(5000);
        }else{
            person.setStatus("On bridge but not gold");
            sleep(2000);
        }
        go_out();
        person.setStatus("Go out");
    }

    public void go_out(){
        mutex.release();
    }

    boolean bridge_is_free(){
        return this.mutex.availablePermits() > 0;
    }
}
