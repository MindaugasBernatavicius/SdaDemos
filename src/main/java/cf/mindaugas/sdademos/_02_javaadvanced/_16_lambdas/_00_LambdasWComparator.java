package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _00_LambdasWComparator {
    public static List<Exercise> getTrainingSchedule(){
        return new ArrayList<>() {{
            add(new Exercise("Jogging", 1500));
            add(new Exercise("Weight Training", 4500));
            add(new Exercise("Stretches", 1200));
            add(new Exercise("Ab Crunches", 1200));
        }};
    }

    public static void main(String[] args) {
        List<Exercise> trainingSchedule = getTrainingSchedule();
        System.out.println("Before sorting: " + trainingSchedule);

        trainingSchedule.sort(new Comparator<Exercise>() {
            @Override
            public int compare(Exercise o1, Exercise o2) {
                if (o1.durationSeconds > o2.durationSeconds) return 1;
                else if (o1.durationSeconds == o2.durationSeconds) return o1.getName().compareTo(o2.name);
                else return -1;
            }
        });

        // We need 8 lines for sorting, with lambdas we need 5!

        // trainingSchedule.sort((o1, o2) -> {
        //     if (o1.durationSeconds > o2.durationSeconds) return 1;
        //     else if (o1.durationSeconds == o2.durationSeconds) return o1.getName().compareTo(o2.name);
        //     else return -1;
        // });

        System.out.println("Before sorting: " + trainingSchedule);
    }
}

@Data
@ToString(includeFieldNames = false)
@AllArgsConstructor
class Exercise implements Comparable<Exercise> {
    String name;
    int durationSeconds;

    @Override
    public int compareTo(Exercise o) {
        return getDurationSeconds() - o.getDurationSeconds();
    }
}
