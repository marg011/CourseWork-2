package pro.sky.skyprospringcourseWork2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringcourseWork2.domain.Question;
import pro.sky.skyprospringcourseWork2.exceptions.TooBigAmountException;
import pro.sky.skyprospringcourseWork2.services.api.ExaminerService;
import pro.sky.skyprospringcourseWork2.services.api.QuestionService;
import pro.sky.skyprospringcourseWork2.services.impl.ExaminerServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {

    private ExaminerService examinerService;
    @Mock
    private QuestionService questionService;

    @BeforeEach
    public void SetUp(){
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void getQuestionsTest(){
        Set<Question> questions= new HashSet<>();
        questions.add(new Question("hello", "world"));
        questions.add(new Question("hello1", "world1"));

        Mockito.when(questionService.getAll()).thenReturn(questions);

        Question randomQuestion = new Question("hello", "world");

        Mockito.when(questionService.getRandomQuestion()).thenReturn(randomQuestion);

        Set<Question> expected = new HashSet<>();
        expected.add(new Question("hello", "world"));

        Set<Question> actual = examinerService.getQuestions(1);

        assertEquals(expected, actual);
    }


    @Test
    public void getQuestionsTestException(){
        Set<Question> questions= new HashSet<>();
        questions.add(new Question("hello", "world"));
        questions.add(new Question("hello1", "world1"));

        Mockito.when(questionService.getAll()).thenReturn(questions);

        assertThrows(TooBigAmountException.class, () -> examinerService.getQuestions(3));
    }


}
