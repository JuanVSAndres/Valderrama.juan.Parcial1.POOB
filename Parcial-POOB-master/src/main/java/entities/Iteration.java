package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Iteration {

    private String goal;
    private LocalDate dateInit;
    private LocalDate dateEnd;

    private List<Activity> activities;
    private Project project;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public int countOpenActivities(){
        int conte =0;
        for (Activity activity : activities) {
            if (activity.isActive()) {
                conte++;
            }
        }
        return conte;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

}
