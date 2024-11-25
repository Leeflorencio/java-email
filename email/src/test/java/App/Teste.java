package App;

import com.br.jdev.enviando.email.EnviaEmail;

public class Teste {

    private String userName = "devleticia19@gmail.com";
    private String password = "wycg voyn cmhc uwbc";

    @org.junit.Test
    public void testeEmail() throws Exception{

        EnviaEmail enviaEmail = new EnviaEmail("Leticia Florêncio", "florenciolee63@gmail.com",
                "Testando nova classe e-mail", "Esse e-mail é para teste da classe EnviaEmail");

        enviaEmail.enviarEmail();

    }
}
