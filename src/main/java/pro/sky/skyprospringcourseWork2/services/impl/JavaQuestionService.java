
package pro.sky.skyprospringcourseWork2.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcourseWork2.domain.Question;
import pro.sky.skyprospringcourseWork2.services.api.QuestionService;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer){
        Question quest = new Question(question, answer);
        questions.add(quest);
        return quest;
    }

//    public Question add(Question question){
//        questions.add(question);
//        return question;
//    }

//    public Question remove(Question question){
//        questions.remove(question);
//        return question;
//    }

    public Question remove(String question, String answer){
        Question quest = new Question(question, answer);
        questions.remove(quest);
        return quest;
    }

    public Set<Question> getAll(){
        return questions;
    }

    public Question getRandomQuestion(){
        Random rand = new Random();
        List<Question> quests = new ArrayList<>(questions);
        return quests.get(rand.nextInt(questions.size()));
    }
}
