package pl.piomin.services.mail.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import pl.piomin.services.mail.event.ReceiveMailEvent;

@Service
@Slf4j
public class MailReceiveEventListenService implements ApplicationListener<ReceiveMailEvent> {

    @Override
    public void onApplicationEvent(ReceiveMailEvent receiveMailEvent){
        log.info("MailReceiveEventListenService:  收到{}一封邮件： {}",receiveMailEvent.getSender(), receiveMailEvent.getMail());
    }
}
