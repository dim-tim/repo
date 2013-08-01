package com.socialcooking.controller;

import com.ecwid.mailchimp.MailChimpObject;

/**
 * @author Mikalai Kisel
 */
public class MergeVars extends MailChimpObject {
    @Field
    public String EMAIL, FNAME, LNAME;

    public MergeVars() { }

    public MergeVars(String email, String fname, String lname) {
        this.EMAIL = email;
        this.FNAME = fname;
        this.LNAME = lname;
    }
}
