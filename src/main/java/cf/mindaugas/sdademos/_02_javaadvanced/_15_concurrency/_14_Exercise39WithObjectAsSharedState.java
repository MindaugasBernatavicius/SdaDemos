package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

// TASK 39. Write a program that will solve the problem below.
//     There is a system that stores current results in competitions. Many screens read the current results, while
//     several sensors update these results. Write a program that allows continuous reading of data through many
//     screens (threads) and updating data by many sensors (threads).
//
//     To update results, the sensor must provide current results along with new ones. The system then verifies that
//     the sensor has current data and updates the data. If the system data has changed during this time, the sensor's
//     data update is rejected.
//
//     For simplicity, you can assume that the sensor is reading data, waiting a random amount of time, and
//     increasing the data by a random value.

// INTERESTING QUESTIONS:
// - What happens if you decrease the number of time ScreenV2 is reading the score from 6000 to 1000? Why is that happening?
// - What happens if you place Thread.sleep(5); after the updateScore() call in the SensorV2? Why is that happening?
// - Try to decrease or increase the sleep times in Sensors and Screens. What behavior do you observe? Can you explain it?
// - How would you test if the logic of this application is correct?

import lombok.*;

import static cf.mindaugas.sdademos._02_javaadvanced._15_concurrency._13_Exercise39WithStringBuilderAsSharedState.joinThreads;
import static cf.mindaugas.sdademos._02_javaadvanced._15_concurrency._13_Exercise39WithStringBuilderAsSharedState.startThreads;

public class _14_Exercise39WithObjectAsSharedState {
    public static void main(String[] args) throws InterruptedException {
        var system = new ScoringSystem(0, 0);

        var sc1 = new ScreenV2(system);
        // var sc2 = new ScreenV2(system);

        var snsr1 = new SensorV2(system);
        var snsr2 = new SensorV2(system);
        var snsr3 = new SensorV2(system);

        startThreads(sc1, snsr1, snsr2, snsr3);
        joinThreads(snsr1, snsr2, snsr3, sc1); // notice: reader threads joined later than writers
    }
}

@AllArgsConstructor
@ToString(includeFieldNames = false)
class ScoringSystem {
    private volatile int team1Score;
    private volatile int team2Score;

    public synchronized void updateScore(int t1Score, int t2Score, int t1ScoreUpdated,int t2ScoreUpdated){
        if(t1Score == team1Score && t2Score == team2Score){
            team1Score = t1ScoreUpdated;
            team2Score = t2ScoreUpdated;
        } else System.out.println("Update rejected: " + team1Score + " : " + team2Score + " vs " + t1Score + " : " + t2Score);
    }

    public synchronized int getTeam1Score() {
        return team1Score;
    }

    public synchronized int getTeam2Score() {
        return team2Score;
    }
}

@AllArgsConstructor
class ScreenV2 extends Thread {
    private ScoringSystem scoreSys;
    @Override
    public void run() {
        for (int i = 0; i < 6000; i++)
            System.out.println(scoreSys.getTeam1Score() + " : " + scoreSys.getTeam2Score());
    }
}

@AllArgsConstructor
class SensorV2 extends Thread {
    private ScoringSystem scoreSys;

    @Override
    public void run() {
        var min = 50;
        var max = 100;
        try {
            for (int i = 0; i < 10; i++) {
                // Thread.sleep((int)((Math.random() * (max - min)) + min));
                Thread.sleep(5);
                scoreSys.updateScore(
                    scoreSys.getTeam1Score(),
                    scoreSys.getTeam2Score(),
                    scoreSys.getTeam1Score() + 1,
                    scoreSys.getTeam2Score() + 1
                );
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}