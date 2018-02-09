/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherclient.data;

import teacherclient.be.Student;
import teacherclient.be.SchoolClass;
import java.util.ArrayList;
import java.util.List;
import teacherclient.be.ClassRoom;
import teacherclient.be.Course;
import teacherclient.be.ScheduleDay;
import teacherclient.be.ScheduleItem;

/**
 *
 * @author alexl
 */
public class MockData
{

    private ArrayList<SchoolClass> listAllClasses;
    private ArrayList<SchoolClass> listOne;
    private ArrayList<SchoolClass> listTwo;
    private ArrayList<SchoolClass> listThree;

    private SchoolClass CS2017A;
    private SchoolClass CS2017B;
    private SchoolClass CS2016A;
    private SchoolClass CS2016B;

    private ArrayList<Student> listAllStudents;

    private Student Alex;
    private Student Asbjørn;
    private Student Jan;

    public void createMockData()
    {
        CS2017A = new SchoolClass(1, "CS2017A");
        CS2017B = new SchoolClass(2, "CS2017B");
        CS2016A = new SchoolClass(3, "CS2016A");
        CS2016B = new SchoolClass(4, "CS2016B");

        listAllClasses = new ArrayList<SchoolClass>();
        listAllClasses.add(CS2017A);
        listAllClasses.add(CS2017B);
        listAllClasses.add(CS2016A);
        listAllClasses.add(CS2016B);

        listOne = new ArrayList<SchoolClass>();
        listOne.add(CS2017A);
        listOne.add(CS2016A);

        listTwo = new ArrayList<SchoolClass>();
        listTwo.add(CS2017A);
        listTwo.add(CS2017B);
        listTwo.add(CS2016A);

        listThree = new ArrayList<SchoolClass>();
        listThree.add(CS2017B);
        listThree.add(CS2016B);

        Alex = new Student(1, "Alex Tygesen", listOne);
        Asbjørn = new Student(2, "Asbjørn Mansa EtEllerAndet", listTwo);
        Jan = new Student(3, "JanvanZetten", listThree);

        listAllStudents = new ArrayList<Student>();
        listAllStudents.add(Alex);
        listAllStudents.add(Asbjørn);
        listAllStudents.add(Jan);
    }

    public List<SchoolClass> getListAllClasses()
    {
        return listAllClasses;
    }

    public List<Student> getListAllStudents()
    {
        return listAllStudents;
    }

    public List<ScheduleItem> getSchedueleItems()
    {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("SDE"));
        courses.add(new Course("SCO"));
        courses.add(new Course("ITO"));
        courses.add(new Course("DBOS"));

        List<String> teachers = new ArrayList<>();
        teachers.add("Peter");
        teachers.add("Mads");
        teachers.add("Lars");
        teachers.add("Bent");

        List<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClasses.add(new SchoolClass(1, "CS2017A"));

        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms.add(new ClassRoom("C3"));

        List<ScheduleItem> scheduleItems = new ArrayList<>();

        scheduleItems.add(new ScheduleItem(courses.get(1), teachers.get(1), "", schoolClasses.get(0), classRooms.get(0), ScheduleDay.MONDAY, 540, 645));
        scheduleItems.add(new ScheduleItem(courses.get(0), teachers.get(0), "Read chapters 1-6", schoolClasses.get(0), classRooms.get(0), ScheduleDay.MONDAY, 645, 810));
        scheduleItems.add(new ScheduleItem(courses.get(0), teachers.get(0), "", schoolClasses.get(0), classRooms.get(0), ScheduleDay.TUESDAY, 540, 690));
        scheduleItems.add(new ScheduleItem(courses.get(2), teachers.get(2), "", schoolClasses.get(0), classRooms.get(0), ScheduleDay.TUESDAY, 720, 915));
        scheduleItems.add(new ScheduleItem(courses.get(3), teachers.get(3), "", schoolClasses.get(0), classRooms.get(0), ScheduleDay.WEDNESDAY, 540, 765));
        scheduleItems.add(new ScheduleItem(courses.get(1), teachers.get(1), "", schoolClasses.get(0), classRooms.get(0), ScheduleDay.THURSDAY, 540, 765));
        scheduleItems.add(new ScheduleItem(courses.get(1), teachers.get(1), null, schoolClasses.get(0), classRooms.get(0), ScheduleDay.FRIDAY, 540, 765));

        return scheduleItems;
    }
}
