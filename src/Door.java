import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Door {
    public Semaphore mutex = new Semaphore(1);
    public static Person[] persons;
    public void setPersons(Person[] pers) {
        persons = pers;
    }

    public void start_holding_gate(Person person) throws InterruptedException {
        while(person.turn < max_of_turn() && person.bridge.number_of_gold > 0){

        }
        while (!this.door_is_free()){

        }
        mutex.acquire();
        person.setStatus("Holding door");
        if (person.bridge.number_of_gold <= 0){
            sleep(1000);
        }else{
            sleep(2000);
        }
    }

    public void stop_holding_gate(){
        mutex.release();
    }

    boolean door_is_free(){
        return this.mutex.availablePermits() > 0;
    }
    public static int max_of_turn(){
        int max = persons[0].turn;
        for(int i=0; i<persons.length; i++){
            if(persons[i].turn > max){
                max = persons[i].turn;
            }
        }
        return max;
    };
}

