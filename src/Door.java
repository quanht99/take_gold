import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Door {
    public Semaphore mutex = new Semaphore(1);
    public Person[] persons;
    public void setPersons(Person[] pers) {
        this.persons = pers;
    }

    public void start_holding_gate(Person person) {
        while(person.turn < (int) this.max_of_turn() && person.bridge.number_of_gold > 0 || !this.door_is_free()){
//            System.out.print("");
        }
//        System.out.println("Person turn: " + person.turn + "Max_turn: " + this.max_of_turn());
        try {
            this.mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person.setStatus("Holding door        ");
    }

    public void stop_holding_gate(){
        this.mutex.release();
    }

    boolean door_is_free(){
        return this.mutex.availablePermits() > 0;
    }
    public int max_of_turn(){
        int max = this.persons[0].turn;
        for(int i=0; i<this.persons.length; i++){
            if(this.persons[i].turn > max){
                max = this.persons[i].turn;
            }
        }
        return max;
    };
}

