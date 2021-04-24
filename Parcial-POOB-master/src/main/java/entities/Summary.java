package entities;

import java.time.LocalDate;

public class Summary {

    private int activeProjects;
    private LocalDate date;
    private int openActivities;
    private int closedActivities;

    public Summary(int activeProjects, LocalDate date) {
        this.activeProjects=activeProjects;
        this.date = date;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public LocalDate getDate() {
        return date;
    }
}
