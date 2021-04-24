package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate.*;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;


    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }
    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }


    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Evaluate if a project is active.
     *
     * @return false if the project has open activities or the dateEnd is before than the system date.
     */
    public boolean isActive() {

        boolean active = false;

        if(LocalDate.now().isBefore(this.dateEnd) || LocalDate.now().isEqual(this.dateEnd) && LocalDate.now().isAfter(this.dateInit) || LocalDate.now().isEqual(this.dateInit))
        {
            for(Iteration i: this.iterations)
            {
                int a= 0;
                a+=i.CountOpenActivities();
                if(a > 0)
                {
                    active = true;
                }

            }
        }
        return active;
    }
    /**
     * Devuelve el numero de planes cerrados
     * @return d
     */
    public int CountOpenActivities()
    {
        int d=0;
        for (Iteration a: this.iterations)
        {
            d+=a.CountOpenActivities();
        }

        return d;
    }
    /**
     * Devuelve el numero de planes cerrados
     * @return d
     */
    public int CountClosedActivities()
    {
        int d=0;
        for (Iteration a: this.iterations)
        {
            d+=a.CountClosedActivities();
        }

        return d;
    }


}
