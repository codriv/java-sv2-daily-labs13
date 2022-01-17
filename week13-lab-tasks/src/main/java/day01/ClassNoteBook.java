package day01;

import java.util.*;

public class ClassNoteBook {

    private Map<Student, Set<Integer>> students = new TreeMap<>();

    public void addStudent(Student student) {
        students.put(student, new HashSet<>());
    }

    public void addMark(int id, int mark) {
        for (Map.Entry<Student, Set<Integer>> student: students.entrySet()) {
            if (student.getKey().getId() == id) {
                student.getValue().add(mark);
            }
        }
    }
}
