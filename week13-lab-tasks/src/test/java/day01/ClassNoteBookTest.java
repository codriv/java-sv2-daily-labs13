package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    ClassNoteBook cnb = new ClassNoteBook();

    @Test
    void test() {
        cnb.addStudent(new Student(1, "egy"));
        cnb.addStudent(new Student(3, "harom"));
        cnb.addStudent(new Student(4, "negy"));
        cnb.addStudent(new Student(2, "ketto"));

        cnb.addMark(3, 4);
        System.out.println(cnb.getStudents());
    }

}