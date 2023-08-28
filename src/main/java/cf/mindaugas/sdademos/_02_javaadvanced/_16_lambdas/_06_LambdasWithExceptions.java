package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

import java.io.FileWriter;
import java.io.IOException;

import static cf.mindaugas.sdademos._02_javaadvanced._16_lambdas._00_LambdasWComparator.getTrainingSchedule;

public class _06_LambdasWithExceptions {
    public static void main(String[] args) {
        var exercises = getTrainingSchedule();

        // lambda expression is allowed to throw an exception if the method signature
        // ... that the lambda is providing the implementation of has a declaration of throwing that exception
        // ... most people seem to agree that in this case a simple loop would be better than forEach with lambda

        try(var writer = new FileWriter("exercises.txt")){
            exercises.forEach(exercise -> {
                try {
                    writer.write(exercise.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
