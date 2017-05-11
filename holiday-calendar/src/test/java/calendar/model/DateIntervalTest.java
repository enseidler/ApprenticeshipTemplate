package calendar.model;

import calendar.model.utils.DateInterval;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class DateIntervalTest {

    @Test(expected = RuntimeException.class)
    public void test01StartDateMustBeSoonerThanEndDate(){
        LocalDate start = LocalDate.of(2017, 1, 1);
        LocalDate end = LocalDate.of(2016, 12, 1);
        DateInterval interval = new DateInterval(start, end);
    }

    @Test
    public void test02ADateCanBeContainedByAnInterval(){
        LocalDate start = LocalDate.of(2017, 1, 1);
        LocalDate end = LocalDate.of(2017, 12, 1);
        DateInterval interval = new DateInterval(start, end);
        LocalDate aDate = LocalDate.of(2017, 10, 1);
        Assert.assertTrue(interval.contains(aDate));
    }

    @Test
    public void test03TheStartDateIsContainedByInterval(){
        LocalDate start = LocalDate.of(2017, 1, 1);
        LocalDate end = LocalDate.of(2017, 12, 1);
        DateInterval interval = new DateInterval(start, end);
        LocalDate aDate = LocalDate.of(2017, 1, 1);
        Assert.assertTrue(interval.contains(aDate));
    }

    @Test
    public void test04TheEndDateIsContainedByInterval(){
        LocalDate start = LocalDate.of(2017, 1, 1);
        LocalDate end = LocalDate.of(2017, 12, 1);
        DateInterval interval = new DateInterval(start, end);
        LocalDate aDate = LocalDate.of(2017, 12, 1);
        Assert.assertTrue(interval.contains(aDate));
    }

    @Test
    public void test05ADateCannotBeContainedByAnInterval(){
            LocalDate start = LocalDate.of(2017, 1, 1);
            LocalDate end = LocalDate.of(2017, 12, 1);
            DateInterval interval = new DateInterval(start, end);
            LocalDate aDate = LocalDate.of(2018, 1, 1);
            Assert.assertFalse(interval.contains(aDate));
        }
    }
