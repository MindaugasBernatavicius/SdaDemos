package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static cf.mindaugas.sdademos._02_javaadvanced._16_lambdas._00_LambdasWComparator.getTrainingSchedule;

public class _05_LambdaScopeThisAndSuper {

    public static void printSelectedExercises(List<Exercise> exercises, int durationLimitS) {
        for (var exercise : exercises)
            if (exercise.durationSeconds > durationLimitS) System.out.println(exercise);
    }

    interface Filter<T> {
        boolean accept(T t);
    }

    public static void printSelectedExercises(List<Exercise> exercises, Filter<Exercise> filter) {
        for (var exercise : exercises)
            if (filter.accept(exercise)) System.out.println(exercise);
    }

    public static void _00_ExampleNoLambda() {
        var exercises = getTrainingSchedule();
        // this method has no part that can be provided as a lambda, because
        // ... a lambda encapsulates a certain algorithm, a procedure in a variable
        // ... the only things that this method requires are 2 regular data carrying variables
        printSelectedExercises(exercises, 1300);
    }

    public static void _01_ExampleWLambda() {
        var exercises = getTrainingSchedule();
        printSelectedExercises(exercises, exercise -> exercise.durationSeconds > 1400);
    }

    public static void _02_ReachingExternalScope() {
        var exercises = getTrainingSchedule();
        var limitSeconds = 1400; // captured local variable - can't be modified
        // limitSeconds = 1450; // if you try to reassign it, then it is no longer effectively final IF YOU REASSIGN IT
        Filter<Exercise> filter = exercise -> exercise.durationSeconds > limitSeconds;
        // limitSeconds = 1450; // this also will not work, because lambda is only invoked inside printSelectedExercises
        printSelectedExercises(exercises, filter);
        // limitSeconds = 1450; // even this is eliminated as a possibility to avoid confusion
        // ... why? Because a lambda can outlive the context in which it was declared (Runnable), the variable
        // ... is allocated on the stack so the lambda can't use it. Instead it uses a copy, but changing the
        // ... value is implemented to avoid confusion.
    }

    public static void _03_CapturedLocalVariablesCantBeChangedEvenInsideLambda() {
        // lets count short exercises
        var exercises = getTrainingSchedule();
        var limitSeconds = 1400;

        // ... you will be able to modify a list
        var shortExercises = new ArrayList<Exercise>();

        // for (var exercise : exercises)
        //     if (exercise.durationSeconds < limitSeconds)
        //         shortExercises.add(exercise);

        // exercises.forEach(exercise -> {
        //     if (exercise.durationSeconds < limitSeconds)
        //         shortExercises.add(exercise);
        // });

        // this would work, but the best practice is to avoid any
        // ... side effects (like modifying the mutable structures) inside lambda
        // ... this example below is in danger of ConcurrentModificationException
        exercises.parallelStream().forEach(exercise -> {
            if (exercise.durationSeconds < limitSeconds)
                shortExercises.add(exercise);
        });

        System.out.println(shortExercises);

        // // ... but not perform any operations that would reassign a variable
        // var shortExerciseCount = 0;
        // for (var exercise : exercises)
        //     if (exercise.durationSeconds < limitSeconds)
        //         shortExerciseCount++;
        //
        // exercises.forEach(exercise -> {
        //     if (exercise.durationSeconds < limitSeconds)
        //         shortExerciseCount++;
        // });
    }

    public void _04_ThisAndSuper(){
        // inside an anon class this refers to the instance of that class and super to the instance of the parent class
        // inside lambda this refers to the instance where lambda is declared and super refers to the parent of enclosing class
        var exercises = getTrainingSchedule();
        // exercises.forEach(exercise -> System.out.println(this.getClass()));
        exercises.forEach(exercise -> System.out.println(super.getClass()));
        // exercises.forEach(new Consumer<Exercise>() {
        //     @Override
        //     public void accept(Exercise exercise) {
        //         // System.out.println(this);
        //         System.out.println(super.getClass());
        //     }
        // });
    }

    public static void main(String[] args) {
        // _00_ExampleNoLambda();
        // _01_ExampleWLambda();
        // _02_ReachingExternalScope();
        // _03_CapturedLocalVariablesCantBeChangedEvenInsideLambda();
        (new _05_LambdaScopeThisAndSuper())._04_ThisAndSuper();
    }
}
