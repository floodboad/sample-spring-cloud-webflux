package pl.piomin.services.mail.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import pl.piomin.services.mail.model.Mail;

@Data
public class ReceiveMailEvent extends ApplicationEvent {
    private static final long serialVersionUID = -3910960183687086015L;

    private Mail mail;
    private String sender;

    public ReceiveMailEvent(Object source, Mail mail, String sender){
        super(source);
        this.mail = mail;
        this.sender = sender;
    }


}
