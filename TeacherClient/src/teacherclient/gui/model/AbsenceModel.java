/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherclient.gui.model;

import teacherclient.be.Student;
import teacherclient.data.CurrentData;
import teacherclient.data.MockData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author alexl
 */
public class AbsenceModel
{

    private CurrentData cData;
    private MockData mData;
    private AbsenceGraph ag;

    public void setInformation(Label labelClass, ListView<Student> listviewStudents, AnchorPane chartPane, CurrentData cData, MockData mData)
    {
        this.cData = cData;
        this.mData = mData;
        labelClass.setText("Absence in " + cData.getCurrentClass().getName() + ":");
        setStudentList(listviewStudents);

        // Some test value:
        XYChart.Series<String, Number> series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Total", 25.1));
        series.getData().add(new XYChart.Data("SCO", 5.0));
        series.getData().add(new XYChart.Data("SDE", 46.1));
        series.getData().add(new XYChart.Data("ITO", 35.5));
        series.getData().add(new XYChart.Data("DBOS", 0.2));
        ag = new AbsenceGraph(chartPane, series);
    }

    private void setStudentList(ListView<Student> listviewStudents)
    {
        ObservableList<Student> ol = FXCollections.observableArrayList();
        for (Student student : mData.getListAllStudents())
        {
            for (teacherclient.be.SchoolClass sClass : student.getClasses())
            {
                if (sClass.getName().equals(cData.getCurrentClass().getName()))
                {
                    ol.add(student);
                }
            }
        }
        listviewStudents.setItems(ol);
        listviewStudents.setCellFactory(param -> new ListCell<Student>()
        {
            @Override
            protected void updateItem(Student item, boolean empty)
            {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null)
                {
                    setText(null);
                }
                else
                {
                    setText(item.getName());
                }
            }
        });
    }
}
