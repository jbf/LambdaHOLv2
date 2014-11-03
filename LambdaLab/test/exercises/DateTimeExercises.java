package exercises;

/*
* DATE TIME PROGRAMMING LABORATORY
*
* For each exercise, develop a solution using Java SE 8 Date & Time API
* and remove the @Ignore tag. Then run the tests.
*
* In NetBeans, Ctrl-F6 will run the project's tests, which default to
* the unsolved exercises (as opposed to the solutions). Alt-F6 [PC] or
* or Cmd-F6 [Mac] will run just the tests in the currently selected file.
* */

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DateTimeExercises {

// ========================================================
// DATE EXERCISES
// ========================================================


    /**
     * Find out which weekday Christmas Eve 2014 occurs
     */
    @Test @Ignore
    public void ex01_XMas2014DayOfWeek() {
        DayOfWeek xmasEve2014Day = null; //fixme

        assertEquals(DayOfWeek.WEDNESDAY, xmasEve2014Day);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use LocalDate.of.
    // </editor-fold>


    /**
     * Find out which date the next Sunday after October 28 2014 is.
     */
    @Test @Ignore
    public void ex02_sundayAfterOct28() {
        LocalDate oct28 = null; //fixme
        LocalDate sundayAfter =  null; //fixme

        assertEquals(LocalDate.of(2014,  11,  2), sundayAfter);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use a utility method from TemporalAdjusters
    // </editor-fold>



    /**
     * You fly from San Fransisco to Tokyo, the flight leaves at July
     * 20, 2013, at 7:30 a.m,
     * the flight takes 6 hours and 50 minutes.
     * What is the local date and time when you land?
     * Use the ZoneId's SF_TZ and TOKYO_TZ defined for you at the bottom
     of this file.
     */
    @Test @Ignore
    public void ex03_flightArrivalTime() {
        LocalDateTime localArrivalTime = null; //fixme

        assertEquals(LocalDateTime.of(2013,  Month.JULY,  21, 10, 20),
                localArrivalTime);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use ZonedDateTime.withZoneSameInstant
    // </editor-fold>


    /**
     * Find out the difference in ms between two timestamps in the same
     * timezone.
     * 7:12:11:300 -> 7:12:10:600
     */
    @Test @Ignore
    public void ex04_msBetweenTimestampsSameTimezone() {
        long differenceMs  = 0L; //fixme

        assertEquals(1300, differenceMs);
    }
    // HINT 1:
    // <editor-fold>
    // use Duration
    // </editor-fold>

    /** Complete the class definition for JavaRelease, create the method parseReleases().
     */

    public static class JavaRelease {
        Object date; //change me!
        String name;

        public JavaRelease(List<String> unparsed) {
            date = unparsed.get(1); // change me!
            name = unparsed.get(0);
        }
    }

    // This should return a Stream<JavaRelease> by transforming JAVA_RELEASES a List<List<String>>
    public Stream<JavaRelease> parseReleases() {
        // JAVA_RELEASES
        return null;
    }

    @Test @Ignore
    public void ex05_ParseJavaReleases() {
        validateEx5(parseReleases());
    }

    // Hint 1:
    // <editor-fold>
    // Use LocalDate
    // </editor-fold>
    //
    // Hint 2:
    // <editor-fold>
    // Use LocalDate.parse
    // </editor-fold>


    @Test @Ignore
    public void ex06_TimeBetweenRelease() {
        Object timeBetween1and9 = null; // fix me

        validateEx6(timeBetween1and9);
    }

// ========================================================
// END OF EXERCISES -- CONGRATULATIONS!
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


    ZoneId SF_TZ = ZoneId.of("America/Los_Angeles");
    ZoneId TOKYO_TZ = ZoneId.of("Asia/Tokyo");

    List<List<String>> JAVA_RELEASES = Arrays.asList(
            Arrays.asList("JDK 1.0", "1996-01-21"),
            Arrays.asList("JDK 1.1", "1997-02-19"),
            Arrays.asList("J2SE 1.2", "1998-12-08"),
            Arrays.asList("J2SE 1.3", "2000-05-08"),
            Arrays.asList("J2SE 1.4", "2002-02-06"),
            Arrays.asList("J2SE 5.0", "2004-09-30"),
            Arrays.asList("Java SE 6", "2006-12-11"),
            Arrays.asList("Java SE 7", "2011-07-28"),
            Arrays.asList("Java SE 8", "2014-03-18")
    );

    @Before
    public void z_setUpBufferedReader() throws IOException {
    }

    @After
    public void z_closeBufferedReader() throws IOException {
    }

    public void validateEx5(Stream<JavaRelease> r) {
        List<JavaRelease> result = r.collect(Collectors.toList());

        // assert first
        assertEquals(result.get(0).date, LocalDate.of(1996, Month.JANUARY, 21));
        // assert last
        assertEquals(result.size(), 9);
        assertEquals(result.get(8).date, LocalDate.of(2014, Month.MARCH, 18));

        // assert instanceof
        result.forEach(rr -> assertTrue(rr.date instanceof LocalDate));
    }

    public void validateEx6(Object o) {
        assertTrue(o instanceof Period);
        Period p = (Period)o;
        assertEquals(p, Period.of(18, 1, 25));
    }
}

