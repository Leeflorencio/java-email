package App;

import com.br.jdev.enviando.email.EnviaEmail;

public class Teste {

    private String userName = "devleticia19@gmail.com";
    private String password = "wycg voyn cmhc uwbc";

    @org.junit.Test
    public void testeEmail() throws Exception{

        StringBuilder stringBuilderTextoEmail = new StringBuilder();

        stringBuilderTextoEmail.append("<br/><h1>Olá, <br/><br/></h1>");
        stringBuilderTextoEmail.append("Você está recebendo o acesso ao curso de Java <br/><br/>");


        EnviaEmail enviaEmail = new EnviaEmail("Leticia Florêncio", "florenciolee63@gmail.com",
                "Testando nova classe e-mail com HTML", "Teste html" + stringBuilderTextoEmail.toString());

        enviaEmail.enviarEmail(true);

    }
}
