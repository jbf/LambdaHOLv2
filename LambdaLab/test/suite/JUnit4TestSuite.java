package suite;

import exercises.DateTimeExercises;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={DateTimeExercises.class})
public class JUnit4TestSuite {
}
