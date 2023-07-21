package pro.sky.skyprospringcourseWork2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringcourseWork2.domain.Question;
import pro.sky.skyprospringcourseWork2.services.api.ExaminerService;

import java.util.Set;
@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "exam/questions/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }

}
