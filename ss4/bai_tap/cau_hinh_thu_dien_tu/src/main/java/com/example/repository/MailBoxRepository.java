package com.example.repository;

import com.example.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static MailBox mailBox;
    static {
        mailBox = new MailBox("English", 25, true, "Thor");
    }


    @Override
    public MailBox mailBox() {
        return mailBox;
    }

    @Override
    public void updateMailBox(MailBox mailBoxUpdate) {
        mailBox.setLanguages(mailBoxUpdate.getLanguages());
        mailBox.setPageSize(mailBoxUpdate.getPageSize());
        mailBox.setSpamFilter(mailBoxUpdate.isSpamFilter());
        mailBox.setSignature(mailBoxUpdate.getSignature());
    }
}
