package com.socialcooking.controller;

import com.ecwid.mailchimp.MailChimpClient;
import com.ecwid.mailchimp.MailChimpException;
import com.socialcooking.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@RequestMapping("/socialcooking/user")
@Controller
public class UserController {

    @RequestMapping(value = "/new" ,method = RequestMethod.GET)
    public String saveCarForm(Model uiModel) throws IOException, MailChimpException {
        User user = new User();
        uiModel.addAttribute("user", user);
        MailChimpClient mailChimpClient = new MailChimpClient();

        return "user/new";
    }
}
