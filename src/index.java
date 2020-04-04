import java.util.Scanner;

import static java.lang.Thread.sleep;

public class index {
    public static void main(String[] args) throws InterruptedException {
        int number_of_person;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number of person");
        number_of_person= myObj.nextInt();

        int number_of_gold;
        System.out.println("Enter number of gold");
        number_of_gold= myObj.nextInt();

        int turn = number_of_gold / number_of_person + 1;

        Door door = new Door();
        Bridge bridge = new Bridge(number_of_gold);
        Person[] persons = new Person[number_of_person];
        for(int i=0; i<number_of_person; i++){
            persons[i] = new Person(i, turn, door, bridge);
        }
        door.setPersons(persons);
        for(int i=0; i<number_of_person; i++){
            persons[i].start();
        }
        while (!all_stop(persons)){
            for(int i=0; i<number_of_person; i++){
                System.out.println("Person number : " + i + "        Status: " + persons[i].status + "             Số turn còn lại:  " + persons[i].turn);
            }
            System.out.println("-----------------------------------------------------");
            sleep(1000);
        }
        for(int i=0; i<number_of_person; i++){
            System.out.println("Person number : " + persons[i].person_number + " lấy được " + (turn - persons[i].turn));
        }

    }

    public static boolean all_stop(Person[] persons){
        for(int i=0; i<persons.length; i++){
            if(persons[i].isAlive()){
                return false;
            }
        }
        return true;
    }
}
