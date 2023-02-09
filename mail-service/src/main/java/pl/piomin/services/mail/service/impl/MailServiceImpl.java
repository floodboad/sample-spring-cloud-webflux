package pl.piomin.services.mail.service.impl;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.piomin.services.mail.event.AsyncSendMailEvent;
import pl.piomin.services.mail.event.ReceiveMailEvent;
import pl.piomin.services.mail.model.Mail;
import reactor.core.publisher.Mono;

import static java.lang.Thread.sleep;

@Slf4j
@Service
public class MailServiceImpl {

    @Autowired
    private ApplicationContext applicationContext;

    public Mono<Void> sendMail(Mail mail){
        String sender = "小A";
        AsyncSendMailEvent sendMailEvent = new AsyncSendMailEvent(this, mail, sender);
        log.info("start send mail");
        applicationContext.publishEvent(sendMailEvent);
        log.info("mail sent");
        return Mono.empty();
    }

    public void receiveMail(Mail mail, String sender){
        ReceiveMailEvent receiveMailEvent = new ReceiveMailEvent(this, mail, sender);
        log.info("start receive mail");
        applicationContext.publishEvent(receiveMailEvent);
        log.info("mail received");
    }

    @EventListener
    public void listenSendMailEvent(AsyncSendMailEvent sendMailEvent){
        log.info("SendMailEvent: {} 发送了一封邮件， 邮件内容：{}",sendMailEvent.getAuthor(), sendMailEvent.getMail().toString());

        countDown(5);
        receiveMail(sendMailEvent.getMail(), sendMailEvent.getAuthor());
    }

    @EventListener
    public void listenReceiveMailEvent(ReceiveMailEvent receiveMailEvent){
        log.info("ReceiveMailEvent: 收到 {} 发送的一封邮件， 邮件内容：{}", receiveMailEvent.getSender(), receiveMailEvent.getMail());
    }

    private void countDown(int secents ){
        int s = secents;
        while (s>0){
            log.info("计时: {} \n",String.valueOf(s));
            s--;
            try {
                sleep(1);

            }catch (Exception e){
                log.warn(e.getMessage());
            }
        }
    }
}
