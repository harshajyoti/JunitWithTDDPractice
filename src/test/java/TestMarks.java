import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMarks {

//    public static void main(String[] args) {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After class");
    }

    @BeforeEach
    public void testHasElements() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int size = allMarks.size();
        System.out.println("before each Size is: " + size);
        assertEquals(size, size);
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("after exec");
    }

    @Test
    public void testSize() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int size = allMarks.size();
        assertEquals(4, size);
    }

    @Test
    public void testPhysicsMarks() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int phyMarks = allMarks.get("Physics");
        assertEquals(90, phyMarks);
    }

    @Test
    public void testChemistryMarks() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int chMarks = allMarks.get("Chemistry");
        assertEquals(40, chMarks);
    }

    @Test
    public void testMathsMarks() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int matMarks = allMarks.get("Maths");
        assertEquals(70, matMarks);
    }

    @Test
    public void testCSMarks() {
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        int csMarks = allMarks.get("Computer Science");
        assertEquals(95, csMarks);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Physics", "Chemistry", "Maths", "Computer Science"})
    public void checkSubjects(){
        Marks marks = new Marks();
        HashMap<String, Integer> allMarks = marks.getMarks();
        assertEquals(true, allMarks.containsKey("Physics"));
    }

    @Test
    public void testGetMarksWithValidSubject(){
        Marks marks = new Marks();
        String subject = "Maths";
        int expectedMarks = 70;
        int mark = marks.getMarksBySub(subject);
        assertEquals(expectedMarks, mark);
    }

    @Test
    public void testGetMarksWithInValidSubject(){
        Marks marks = new Marks();
        String subject = "English";
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            marks.getMarksBySub(subject);
        });
        assertEquals("No such subject!", exception.getMessage());
    }

    @Test
    public void testGetMarksWithEmptyInput(){
        Marks marks = new Marks();
        String subject = "";
        Throwable exception = assertThrows(NullPointerException.class, () ->{
            marks.getMarksBySub(subject);
        });
        assertEquals("Input should not be empty!", exception.getMessage());
    }
}
