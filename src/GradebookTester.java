import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTester {
    GradeBook book1;
    GradeBook book2;

    @Before
    public void setUp(){
        book1 = new GradeBook(5);

        book1.addScore(43.5);
        book1.addScore(30);
        book1.addScore(100);

        book2 = new GradeBook(5);

        book2.addScore(0);
        book2.addScore(56.78);
        book2.addScore(90);
        book2.addScore(100);
    }

    @After
    public void tearDown(){
        book1 = null;
        book2 = null;
    }

    @Test
    public void addScore() {
        assertTrue("Book 1 contents not as expected", book1.toString().equals("43.5 30.0 100.0"));
        assertTrue("Book 2 contents not as expected", book2.toString().equals("0.0 56.78 90.0 100.0"));
        assertEquals("Book 1 score size incorrect", book1.getScoreSize(), 3);
        assertEquals("Book 2 score size incorrect", book2.getScoreSize(), 4);
    }

    @Test
    public void sum() {
        assertEquals("Book 1 sum incorrect", book1.sum(), 43.5 + 30.0 + 100.0, 0.01);
        assertEquals("Book 2 sum incorrect", book2.sum(), 0.0 + 56.78 + 90.0 + 100.0, 0.01);
    }

    @Test
    public void minimum() {
        assertEquals("Book 1 minimum incorrect", book1.minimum(), 30.0, 0.01);
        assertEquals("Book 2 minimum incorrect", book2.minimum(), 0.0, 0.01);
    }

    @Test
    public void finalScore() {
        assertEquals("Book 1 final score incorrect", book1.finalScore(), 43.5 + 100.0, 0.01);
        assertEquals("Book 2 final score incorrect", book2.finalScore(), 56.78 + 90.0 + 100.0, 0.01);
    }
}
