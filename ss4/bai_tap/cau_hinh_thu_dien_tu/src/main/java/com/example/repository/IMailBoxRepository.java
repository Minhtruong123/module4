package com.example.repository;

import com.example.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    List<String> listLanguages();
    List<Integer> listPageSize();
    MailBox mailBox();
    void updateMailBox(MailBox mailBox);
}
