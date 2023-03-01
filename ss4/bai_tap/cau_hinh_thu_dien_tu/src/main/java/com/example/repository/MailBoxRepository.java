package com.example.repository;

import com.example.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static MailBox mailBox;
    private static List<String> languages;
    private static List<Integer> pageSize;
    static {
        mailBox = new MailBox("English", 25, true, "Thor");
        languages = new ArrayList<>();
        pageSize = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public List<String> listLanguages() {
        return languages;
    }

    @Override
    public List<Integer> listPageSize() {
        return pageSize;
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
