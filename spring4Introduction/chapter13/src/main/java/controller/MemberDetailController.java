package controller;

import lombok.Setter;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;

/**
 * @author Seunghyun Kim
 * @since 2020-04-07
 */
@Controller
public class MemberDetailController {

    @Setter
    private MemberDao memberDao;

    @RequestMapping("/member/detail/{id}")
    public String detail(@PathVariable("id") Long memberId, Model model) {
        Member member = memberDao.selectById(memberId);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        model.addAttribute("member", memberDao);
        return "member/memberDetail";
    }

    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "member/invalidId";
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public String handleNotFoundException() {
        return "member/noMember";
    }
}
