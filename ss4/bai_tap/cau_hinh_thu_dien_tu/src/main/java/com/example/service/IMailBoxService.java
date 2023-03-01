package com.example.service;

import com.example.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<String> listLanguages();
    List<Integer> listPageSize();
    MailBox mailBox();
    void updateMailBox(MailBox mailBox);
}
