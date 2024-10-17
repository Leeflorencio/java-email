package App;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Teste {

    private String userName = "";
    private String password = "";

    @org.junit.Test
    public void testeEmail(){
        //Olhe as configurações smtp do seu email
        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true); //autorização
            properties.put("mail.smtp.starttls", true); //autenticação
            properties.put("mail.smtp.host","smtp.gmail.com"); //servidor gmail google
            properties.put("mail.smtp.port", "465"); //porta do servidor
            properties.put("mail.smtp.socketFactory.port", "465"); //Especifica a porta a ser conectada pelo socket
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket de conexão ao SMTP

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Address[] toUser = InternetAddress.parse("devleticia19@gmail.com");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName)); //quem esta enviando
            message.setRecipients(Message.RecipientType.TO, toUser);// email de destino
            message.setSubject("E-mail enviado por Java!!"); //Assunto do e-mail
            message.setText("Olá programador(a), você está recebendo um e-mail enviado com Java :)");

            Transport.send(message);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
