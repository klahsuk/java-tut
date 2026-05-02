import Polymorphism.Car;
import Polymorphism.Ford;
import Polymorphism.Holden;
import Polymorphism.Mitsubishi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());


    }

    //coding ex 1
    public static void checkNumber(int number) {
        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else System.out.println("zero");
    }

    //coding ex 3
    public static void printMegaBytesAndKiloBytes(int kb) {
        int rest = kb % 1024;
        int mb = kb / 1024;

        String output = (kb < 0) ? "Invalid Value" : kb + " KB = " + mb + " MB and " + rest + " KB";
        System.out.println(output);
    }

    //coding ex 4
    public static boolean isCatPlaying(boolean summer, int temp){
        int limit = (summer)? 45 : 35;
        int lowerLimit = 25;

        return temp <= limit && temp >= lowerLimit;
    }

    //coding ex 5
    public static boolean shouldWakeUp(boolean barking, int hour){
        //early validation for hour
        if(hour < 0 || hour > 23){return false;}
        //is the time within critical bounds
        boolean dangerHours = (hour < 8 || hour > 22);
        //if dog barks within these critical hours
        return barking && dangerHours;
    }

    //coding ex 6
    public static boolean isLeapYear(int year){
        //year validation
        if(year < 1 || year > 9999) { return false; }
        return divisibleBy4(year) && (!divisibleBy100(year) || divisibleBy400(year)) ;
    }

    //support functions
    public static boolean divisibleBy4(int year){
        return year % 4 == 0 ;
    }

    public static boolean divisibleBy100(int year){
        return year % 100 == 0 ;
    }

    public static boolean divisibleBy400(int year){
        return year % 400 == 0 ;
    }
}