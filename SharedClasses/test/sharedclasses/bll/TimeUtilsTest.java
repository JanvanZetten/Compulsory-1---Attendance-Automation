/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharedclasses.bll;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javafx.scene.chart.XYChart;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asbamz
 */
public class TimeUtilsTest
{
    private static TimeUtils tu;

    public TimeUtilsTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        tu = new TimeUtils();
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of minuteHourFormatFromMinutes method, of class TimeUtils.
     */
    @Test
    public void testMinuteHourFormatFromMinutes()
    {
        System.out.println("TimeUtilsTest:testMinuteHourFormatFromMinutes");

        assertEquals("01:00", tu.minuteHourFormatFromMinutes(60));
        assertEquals("01:30", tu.minuteHourFormatFromMinutes(90));
        assertEquals("600:00", tu.minuteHourFormatFromMinutes(36000));
        assertEquals("600:01", tu.minuteHourFormatFromMinutes(36001));
    }

    /**
     * Test of minuteHourFormatFromDate method, of class TimeUtils.
     */
    @Test
    public void testMinuteHourFormatFromDate()
    {
        System.out.println("TimeUtilsTest:testMinuteHourFormatFromDate");

        Calendar c = Calendar.getInstance(Locale.ENGLISH);

        c.clear();
        c.set(0, 0, 0, 1, 0, 0);
        assertEquals("01:00", tu.minuteHourFormatFromDate(c.getTime()));
        c.clear();
        c.set(0, 0, 0, 1, 30, 59);
        assertEquals("01:30", tu.minuteHourFormatFromDate(c.getTime()));
        c.clear();
        c.set(0, 0, 0, 1, 2, 60);
        assertEquals("01:03", tu.minuteHourFormatFromDate(c.getTime()));
        c.clear();
        c.set(0, 0, 0, 24, 0, 1);
        assertEquals("00:00", tu.minuteHourFormatFromDate(c.getTime()));
    }

    /**
     * Test of dateFromString method, of class TimeUtils.
     */
    @Test
    public void testDateFromString() throws Exception
    {
        System.out.println("TimeUtilsTest:testDateFromString");

        Calendar c = Calendar.getInstance(Locale.ENGLISH);

        c.clear();
        c.set(2018, 1, 2, 12, 45, 0);
        assertEquals(c.getTime(), tu.dateFromString("2018-02-02 12:45"));
        c.clear();
        c.set(2010, 11, 24, 23, 59, 0);
        assertEquals(c.getTime(), tu.dateFromString("2010-12-24 23:59"));
        c.set(0, 0, 0, 0, 0, 0);
        assertEquals(c.getTime(), tu.dateFromString("0000-01-00 00:00"));
    }

    /**
     * Test of dayFromDate method, of class TimeUtils.
     */
    @Test
    public void testDayFromDate()
    {
        System.out.println("TimeUtilsTest:testDayFromDate");

        Calendar c = Calendar.getInstance(Locale.ENGLISH);

        c.clear();
        c.set(2018, 3, 2, 18, 38, 0);
        assertEquals("Monday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 3, 18, 38, 0);
        assertEquals("Tuesday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 4, 18, 38, 0);
        assertEquals("Wednesday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 5, 18, 38, 0);
        assertEquals("Thursday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 6, 18, 38, 0);
        assertEquals("Friday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 7, 18, 38, 0);
        assertEquals("Saturday", tu.dayFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 8, 18, 38, 0);
        assertEquals("Sunday", tu.dayFromDate(c.getTime()));
    }

    /**
     * Test of minutesFromDate method, of class TimeUtils.
     */
    @Test
    public void testMinutesFromDate()
    {
        System.out.println("TimeUtilsTest:testMinutesFromDate");

        Calendar c = Calendar.getInstance(Locale.ENGLISH);

        c.clear();
        c.set(2018, 3, 2, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 3, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 4, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 5, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 6, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 7, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
        c.clear();
        c.set(2018, 3, 8, 18, 38, 0);
        assertEquals((c.get(Calendar.HOUR_OF_DAY) * 60) + c.get(Calendar.MINUTE), tu.minutesFromDate(c.getTime()));
    }

    /**
     * Test of getChartSeriesFromStudentAbsenceInWeekDays method, of class
     * TimeUtils.
     */
    @Test
    public void testGetChartSeriesFromStudentAbsenceInWeekDays()
    {
        System.out.println("TimeUtilsTest:testGetChartSeriesFromStudentAbsenceInWeekDays");

        Calendar sc = Calendar.getInstance(Locale.ENGLISH);
        Calendar ec = Calendar.getInstance(Locale.ENGLISH);
        Calendar c = Calendar.getInstance(Locale.ENGLISH);
        Calendar c2 = Calendar.getInstance(Locale.ENGLISH);
        Calendar c3 = Calendar.getInstance(Locale.ENGLISH);
        Calendar c4 = Calendar.getInstance(Locale.ENGLISH);
        XYChart.Series<String, Number> series;
        List<Date> listPresent;

        sc.clear();
        sc.set(2018, 3, 2, 12, 0, 0);
        ec.clear();
        ec.set(2018, 3, 2, 12, 0, 0);
        c.clear();
        c.set(2018, 3, 2, 12, 0, 0);

        listPresent = new ArrayList<>();

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(100.0, series.getData().get(0).getYValue());

        listPresent.add(c.getTime());

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(0.0, series.getData().get(0).getYValue());

        sc.clear();
        sc.set(2018, 3, 2, 12, 0, 0);
        ec.clear();
        ec.set(2018, 3, 9, 12, 0, 0);
        c.clear();
        c.set(2018, 3, 2, 12, 0, 0);
        c2.clear();
        c2.set(2018, 3, 9, 12, 0, 0);
        c3.clear();
        c3.set(2018, 3, 7, 12, 0, 0);
        c4.clear();
        c4.set(2018, 3, 8, 12, 0, 0);

        listPresent.clear();
        listPresent = new ArrayList<>();

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(100.0, series.getData().get(0).getYValue());
        assertEquals(100.0, series.getData().get(1).getYValue());
        assertEquals(100.0, series.getData().get(2).getYValue());
        assertEquals(100.0, series.getData().get(3).getYValue());
        assertEquals(100.0, series.getData().get(4).getYValue());

        listPresent.add(c.getTime());

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(50.0, series.getData().get(0).getYValue());
        assertEquals(100.0, series.getData().get(1).getYValue());
        assertEquals(100.0, series.getData().get(2).getYValue());
        assertEquals(100.0, series.getData().get(3).getYValue());
        assertEquals(100.0, series.getData().get(4).getYValue());

        listPresent.add(c2.getTime());

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(0.0, series.getData().get(0).getYValue());
        assertEquals(100.0, series.getData().get(1).getYValue());
        assertEquals(100.0, series.getData().get(2).getYValue());
        assertEquals(100.0, series.getData().get(3).getYValue());
        assertEquals(100.0, series.getData().get(4).getYValue());

        listPresent.add(c3.getTime());

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(0.0, series.getData().get(0).getYValue());
        assertEquals(100.0, series.getData().get(1).getYValue());
        assertEquals(100.0, series.getData().get(2).getYValue());
        assertEquals(100.0, series.getData().get(3).getYValue());
        assertEquals(100.0, series.getData().get(4).getYValue());

        listPresent.add(c4.getTime());

        series = tu.getChartSeriesFromStudentAbsenceInWeekDays(sc.getTime(), ec.getTime(), listPresent);
        assertEquals(0.0, series.getData().get(0).getYValue());
        assertEquals(100.0, series.getData().get(1).getYValue());
        assertEquals(100.0, series.getData().get(2).getYValue());
        assertEquals(100.0, series.getData().get(3).getYValue());
        assertEquals(100.0, series.getData().get(4).getYValue());
    }

    /**
     * Test of distinctDateListByDay method, of class TimeUtils.
     */
    @Test
    public void testDistinctDateListByDay()
    {
        System.out.println("TimeUtilsTest:testDistinctDateListByDay");

        Calendar c = Calendar.getInstance(Locale.ENGLISH);

        c.clear();
        c.set(2018, 3, 2, 12, 0, 0);

        List<Date> listWithDuplicates = new ArrayList<>();
        List<Date> listWithNoDuplicates = new ArrayList<>();
        listWithNoDuplicates.add(c.getTime());
        for (int i = 0; i < 10; i++)
        {
            listWithDuplicates.add(c.getTime());
        }

        assertArrayEquals(listWithNoDuplicates.toArray(), tu.distinctDateListByDay(listWithDuplicates).toArray());
    }

}
