/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherclient.gui.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sharedclasses.be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import sharedclasses.be.SchoolClass;
import sharedclasses.bll.BLLException;
import sharedclasses.bll.TimeUtils;
import sharedclasses.gui.model.AbsenceGraph;
import teacherclient.bll.BllManager;
import teacherclient.dal.HBoxCell;

/**
 *
 * @author alexl
 */
public class AbsenceModel {

    private final String PRETEXT = "Absence in ";
    private final String POSTTEXT = ":";

    private SchoolClass schoolClass;
    private BllManager bll = new BllManager();
    private AbsenceGraph ag;
    private AnchorPane chartPane;
    private ObservableList<HBoxCell> ol;
    private LocalDate startDate;
    private LocalDate endDate;
    /**
     * Sets data class instances to be the same as other classes and sets items
     * from the view to be according to the mock data.
     *
     * @param labelClass
     * @param listviewStudents
     * @param chartPane
     * @param schoolClass
     * @param bll
     */
    public void setInformation(Label labelClass, ListView<HBoxCell> listviewStudents, AnchorPane chartPane, SchoolClass schoolClass, BllManager bll) {
        this.schoolClass = schoolClass;
        this.chartPane = chartPane;
        this.bll = bll;
        labelClass.setText(PRETEXT + schoolClass.getName() + POSTTEXT);
        try {
            setStudentList(listviewStudents);
        } catch (BLLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Getting students: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * Sets the list view to be filled with relevant students that prticipate in
     * that course.
     *
     * @param listviewStudents
     */
    private void setStudentList(ListView<HBoxCell> listviewStudents) throws BLLException {
        ol = FXCollections.observableArrayList();
        List<Student> studentsInClass = bll.getStudentsInClass(schoolClass);
        if (studentsInClass != null) {
            for (Student student : studentsInClass) {
                ol.add(new HBoxCell(student, this));
            }
            listviewStudents.setItems(ol);
            selectStudent(ol.get(0).getStudent());
        } else {
            System.out.println("StudentInClass is null");
        }
    }

    public void selectStudent(Student student) {
        chartPane.getChildren().clear();
        this.startDate = getStartDate();
        this.endDate = getEndDate();
        try {
            TimeUtils tu = new TimeUtils();
            Calendar startDate = Calendar.getInstance();
            startDate.set(this.startDate.getYear(), this.startDate.getMonthValue() - 1, this.startDate.getDayOfMonth());
            Calendar endDate = Calendar.getInstance();
            endDate.set(this.endDate.getYear(), this.endDate.getMonthValue() - 1, this.endDate.getDayOfMonth());
            // Months are 0-based indexed.
            ag = new AbsenceGraph(chartPane, tu.getChartSeriesFromStudentAbsenceInWeekDays(startDate.getTime(), endDate.getTime(), bll.getPresentDays(student)));
        } catch (BLLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Selecting student: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    public LocalDate getStartDate() {
        return bll.getIntevalStartDate();

    }
    
    public LocalDate getEndDate() {
        return bll.getIntevalEndDate();
    }

    /**
     * sets and saves the interval values
     * @param startValue the start date
     * @param endValue the end date 
     * @param currentStudent 
     * @throws NumberFormatException 
     */
    public void setInterval(LocalDate startValue, LocalDate endValue, Student currentStudent) throws NumberFormatException {
        if (startValue.toEpochDay() > endValue.toEpochDay()) {
            throw new NumberFormatException("the start date has to be before the end date");
        }
        
        bll.saveInterval(startValue,endValue);
        
        selectStudent(currentStudent);
    }


}
