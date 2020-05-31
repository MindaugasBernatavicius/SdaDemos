package cf.mindaugas.sdademos._04_codingadvanced.v2exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_VehicleIO {
    public static void main(String[] args) {
        // Žingsniai:
        // 1. Nuskaitome failą - pažiūrome ar veikia nuskaitymas
        // 2. Sukuriame klases Cars, Motorcycle, Tractors - su atitinkamais laukais, getteriais ir setteriais
        // 3. Sukuriame enumus Transmission, Shape (Shape bus Cars ir Motorcycle atskiri enumai)
        // 4. Inicializuojame duomenis (objektus iš gautus iš failo)


        File f = new File("target\\classes\\vehicles\\data.txt");
        List<Car> cars = new ArrayList<>();
        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while((line = br.readLine()) != null){
                // System.out.println(line);
                cars.add(new Car(line.split(", ")[1]));
            }
        } catch (IOException ex1){
            ex1.printStackTrace();
        }

        System.out.println(cars);
    }
}

class Car {
    private String make;

    public Car(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                '}';
    }
}
