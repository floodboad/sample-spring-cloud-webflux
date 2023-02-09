package pl.piomin.services.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.services.mail.model.Mail;
import pl.piomin.services.mail.service.impl.MailServiceImpl;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailServiceImpl mailService;

    @PostMapping("/sendMail")
    public Mono<Void> sendMail(){
        Mail mail = Mail.builder()
                .address("白石")
                .content("请我吃鸡腿")
                .subject("惊喜")
                .build();
        return mailService.sendMail(mail);
    }

}
