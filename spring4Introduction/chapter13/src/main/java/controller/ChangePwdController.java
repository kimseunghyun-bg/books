package controller;

import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;

import javax.servlet.http.HttpSession;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

    @Setter
    private ChangePasswordService changePasswordService;

    @RequestMapping(method = RequestMethod.GET)
    public String form(@ModelAttribute("command") ChangePwdCommand changePwdCommand) {
        return "edit/changePwdForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") ChangePwdCommand changePwdCommand,
                         Errors errors,
                         HttpSession session) {
        new ChangePwdCommandValidator().validate(changePwdCommand, errors);
        if (errors.hasErrors()) {
            return "edit/changePwdForm";
        }
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        try {
            changePasswordService.changePassword(
                    authInfo.getEmail(),
                    changePwdCommand.getCurrentPassword(),
                    changePwdCommand.getNewPassword()
            );
            return "edit/changedPwd";
        } catch (IdPasswordNotMatchingException e) {
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }
}
