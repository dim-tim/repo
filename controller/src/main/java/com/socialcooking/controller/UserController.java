package com.socialcooking.controller;

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

//        MailChimpClient mailChimpClient = new MailChimpClient();
//        ListSubscribeMethod listSubscribeMethod = new ListSubscribeMethod();
//        listSubscribeMethod.apikey = "******";
//        listSubscribeMethod.id = "******";
//        listSubscribeMethod.email_address = "vasya-pupkin@example.com";
//        listSubscribeMethod.double_optin = false;
//        listSubscribeMethod.update_existing = true;
//        listSubscribeMethod.merge_vars = new MergeVars("vasya-pupkin@example.com", "Vasya", "Pupkin");
//        mailChimpClient.execute(listSubscribeMethod);

        return "user/new";
    }
}
