package pro.sky.skyprospringcourseWork2.services.api;

import pro.sky.skyprospringcourseWork2.domain.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    Question add(String question, String answer);

//    Question add(Question question);

//    Question remove(Question question);

    Question remove(String question, String answer);

    Set<Question> getAll();

    Question getRandomQuestion();
}
