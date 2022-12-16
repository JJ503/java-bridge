package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grades {
    private final List<Boolean> grades = new ArrayList<>();

    public void addGrade(Boolean grade) {
        grades.add(grade);
    }

    public List<Boolean> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public void resetGrades() {
        grades.clear();
    }
}
