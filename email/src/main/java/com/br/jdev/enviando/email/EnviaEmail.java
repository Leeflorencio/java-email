package com.br.jdev.enviando.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviaEmail {

    private String userName = "devleticia19@gmail.com";
    private String password = "wycg voyn cmhc uwbc";
    private String nomeRemetente = "";
    private String listaDestinatarios = "";
    private String assuntoEmail = "";
    private String textoEmail = "";

    public EnviaEmail(String nomeRemetente, String listaDestinatarios, String assuntoEmail, String textoEmail) {
        this.nomeRemetente = nomeRemetente;
        this.listaDestinatarios = listaDestinatarios;
        this.assuntoEmail = assuntoEmail;
        this.textoEmail = textoEmail;
    }

    public void enviarEmail(boolean envioHtml) throws Exception {
        Properties properties = new Properties();

        properties.put("mail.smtp.ssl.trust", "*"); //autenticacao
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

        Address[] toUser = InternetAddress.parse(listaDestinatarios);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName, nomeRemetente)); //quem esta enviando
        message.setRecipients(Message.RecipientType.TO, toUser);// email de destino
        message.setSubject(assuntoEmail); //Assunto do e-mail

        if(envioHtml){
            message.setContent(textoEmail, "text/html; charset=utf-8");
        }else {
            message.setText(textoEmail);
        }

        Transport.send(message);

    }
}
