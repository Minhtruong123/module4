package com.example.repository;

import com.example.model.MailBox;

public interface IMailBoxRepository {
    MailBox mailBox();
    void updateMailBox(MailBox mailBox);
}
