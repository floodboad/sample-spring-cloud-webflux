package pl.piomin.services.mail.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import pl.piomin.services.mail.model.Mail;

@Data
public class AsyncSendMailEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3910960183687086015L;

    private String author;
    private Mail mail;

    public AsyncSendMailEvent(Object source, Mail mail, String author){
        super(source);
        this.mail = mail;
        this.author = author;
    }

//    public void sendMail(){
//
//    }



}
