package survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

/**
 * @author Seunghyun Kim
 * @since 2020-04-02
 */

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @RequestMapping(method = RequestMethod.GET)
    public String form(Model model) {
        List<Question> questions = createQuestions();
        model.addAttribute("questions", questions);
        return "survey/surveyForm";
    }

//    위 코드와 동일하다.
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView form() {
//        List<Question> questions = createQuestions();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("questions", questions);
//        mav.setViewName("survey/surveyForm");
//        return mav;
//    }

    private List<Question> createQuestions() {
        Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버", "프론트", "풀스택"));
        Question q2 = new Question("가장 많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("Eclipse", "Intellij", "Sublime"));
        Question q3 = new Question("하고 싶은 말을 적어주세요.");
        return Arrays.asList(q1, q2, q3);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("ansData") AnsweredData data) {
        return "survey/submitted";
    }
}
