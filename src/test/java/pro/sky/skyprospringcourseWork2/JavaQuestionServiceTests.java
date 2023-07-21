package pro.sky.skyprospringcourseWork2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyprospringcourseWork2.domain.Question;
import pro.sky.skyprospringcourseWork2.services.api.QuestionService;
import pro.sky.skyprospringcourseWork2.services.impl.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTests {

    private QuestionService questionService;

    @BeforeEach
    public void setUp(){
        questionService = new JavaQuestionService();
    }


    @Test
    public void getAllTest(){
        Set<Question> expected = new HashSet<>();
        Set<Question> actual = questionService.getAll();

        assertEquals(expected, actual);
    }
    @Test
    public void addTest1(){
        Question q = new Question("hello", "world");
        Set<Question> expected = new HashSet<>();
        expected.add(q);

        questionService.add("hello", "world");
        Set<Question> actual = questionService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){
        Question q = new Question("hello", "world");
        Set<Question> expected = new HashSet<>();
        expected.add(q);

        questionService.add("hello", "world");
        questionService.add("hello", "world1");
        Set<Question> actual = questionService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        Question q1 = new Question("hello1", "world1");
        Set<Question> expected = new HashSet<>();
        expected.add(q1);

        questionService.add("hello1", "world1");
        questionService.add("hello2", "world2");
        questionService.remove("hello2", "world2");
        Set<Question> actual = questionService.getAll();

        assertEquals(expected, actual);
    }



}
