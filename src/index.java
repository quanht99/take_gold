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

        Door door = new Door();
        Bridge bridge = new Bridge(number_of_gold);

        Person[] persons = new Person[number_of_person];
        for(int i=0; i<number_of_person; i++){
            persons[i] = new Person(i, door, bridge);
            persons[i].start();
        }

        while (true){
            for(int i=0; i<number_of_person; i++){
                System.out.println("Person number : " + i + " in " + persons[i].status);
            }
            System.out.println("-----------------------------------------------------");
            sleep(1000);
        }
    }
}
