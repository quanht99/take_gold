import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Door {
    public Semaphore mutex = new Semaphore(1);

    public void start_holding_gate(Person person) throws InterruptedException {
        while (!this.door_is_free()){

        }
        mutex.acquire();
        person.setStatus("Holding door");
        if (person.bridge.number_of_gold <= 0){
            sleep(1000);
        }else{
            sleep(5000);
        }
    }

    public void stop_holding_gate(){
        mutex.release();
    }

    boolean door_is_free(){
        return this.mutex.availablePermits() > 0;
    }
}

