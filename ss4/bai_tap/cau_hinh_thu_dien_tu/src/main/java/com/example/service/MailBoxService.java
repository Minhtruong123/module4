package com.example.service;

import com.example.model.MailBox;
import com.example.repository.IMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxService implements IMailBoxService{
    @Autowired
    IMailBoxRepository iMailBoxRepository;
    @Override
    public MailBox mailBox() {
        return iMailBoxRepository.mailBox();
    }

    @Override
    public void updateMailBox(MailBox mailBox) {
        iMailBoxRepository.updateMailBox(mailBox);
    }
}
