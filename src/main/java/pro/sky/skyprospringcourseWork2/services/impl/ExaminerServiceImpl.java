package pro.sky.skyprospringcourseWork2.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcourseWork2.domain.Question;
import pro.sky.skyprospringcourseWork2.exceptions.TooBigAmountException;
import pro.sky.skyprospringcourseWork2.services.api.ExaminerService;
import pro.sky.skyprospringcourseWork2.services.api.QuestionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount){
            throw new TooBigAmountException("Amount is too big for given pool of questions");
        }
        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
