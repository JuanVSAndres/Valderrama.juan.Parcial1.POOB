package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {

    private List<Group> groups;
    private List<Summary> summaries;
    private List<Course> courses;
    private List<Student> students;

    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList<>();
    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    /**
     * Create a summary entry in the current date.
     * - Calculate the count of active projects.
     *
     * @return The new Summary entry.
     */
    public Summary createSummaryEntry()
    {
        int count=0;
        for (Group group : groups) {
            count += (group.CountActiveProjects());
        }
        Summary summary= new Summary(count,LocalDate.now());
        summaries.add(summary);
        System.out.print(count);
        return summary;
    }
}
