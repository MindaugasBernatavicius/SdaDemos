package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.cqrs.traditionalarchitecture;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int scoreTeam1, scoreTeam2;
    private int initGameDurationMinutes;
    private Duration timeLeft;
    private List<Goal> goals = new ArrayList();

    public Game(int initialGameDuration){
        this.initGameDurationMinutes = initialGameDuration;
    }

    public Game start(int game) {
        timeLeft = Duration.ofMinutes(initGameDurationMinutes);
        return this;
    }
    public Game finish() {
        return this;
    }
    public Game period() {
        return this;
    }
    public Game extendTime(int minutes, int seconds) {
        timeLeft.plusMinutes(minutes);
        timeLeft.plusSeconds(seconds);
        return this;
    }

    // getters and setters
    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void incrementScoreTeam1() {
        this.scoreTeam1++;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    // this can also be considered
    // a special case of a setter method
    public void incrementScoreTeam2() {
        this.scoreTeam2++;
    }

    public Duration getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Duration timeLeft) {
        this.timeLeft = timeLeft;
    }

    public List<Goal> getGoals() {
        return goals;
    }
}

class Goal {
    private LocalDateTime timeOfGoal;
    private String teamName;
}
