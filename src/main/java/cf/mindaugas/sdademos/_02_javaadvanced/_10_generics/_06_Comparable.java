package cf.mindaugas.sdademos._02_javaadvanced._10_generics;

public class _06_Comparable {
    public static void main(String[] args) {
        SportsCar car1 = new SportsCar(200);
        SportsCar car2 = new SportsCar(150);
        if (car1.compareTo(car2) > 0) {
            System.out.println("car1 is faster!");
        }
    }
}

class SportsCar implements Comparable<SportsCar> {
    private int maxSpeed;

    public SportsCar(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(SportsCar otherSportsCar) {
        return this.maxSpeed - otherSportsCar.maxSpeed;
    }
}
