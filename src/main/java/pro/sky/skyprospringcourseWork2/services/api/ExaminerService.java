package pro.sky.skyprospringcourseWork2.services.api;

import pro.sky.skyprospringcourseWork2.domain.Question;

import java.util.List;
import java.util.Set;

public interface ExaminerService {

    Set<Question> getQuestions(int amount);

}
