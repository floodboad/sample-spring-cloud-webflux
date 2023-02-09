package pl.piomin.services.mail.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mail {
    private String address;
    private String subject;
    private String content;
}
