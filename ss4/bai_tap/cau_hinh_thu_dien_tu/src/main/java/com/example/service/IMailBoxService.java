package com.example.service;

import com.example.model.MailBox;

public interface IMailBoxService {
    MailBox mailBox();
    void updateMailBox(MailBox mailBox);
}
