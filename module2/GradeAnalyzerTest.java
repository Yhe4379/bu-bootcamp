import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {

    @Test
    public void testNormalAverage() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores), 0.0001);
    }

    @Test
    public void testEmptyListReturnsZero() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.0001);
    }

    @Test
    public void testSingleScore() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85));
        assertEquals(85.0, GradeAnalyzer.calculateAverage(scores), 0.0001);
    }

    @Test
    public void testAllSameValue() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(70, 70, 70, 70));
        assertEquals(70.0, GradeAnalyzer.calculateAverage(scores), 0.0001);
    }

    @Test
    public void testAverageIsNotIntegerDivision() {
        ArrayList<Integer> scores = new ArrayList<>(
            Arrays.asList(88, 92, 76, 45, 100, 63, 81, 57, 94, 72));

        assertEquals(76.8, GradeAnalyzer.calculateAverage(scores), 0.0001);
    }
}