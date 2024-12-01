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
        stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo <br/><br/>");

        stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://projetojavaweb.com/certificado-aluno/login\">Acessar Portal do Aluno</a>");

        stringBuilderTextoEmail.append("<br/><span style=\"font-size:14px\">Ass.: Leticia Florêncio");



        EnviaEmail enviaEmail = new EnviaEmail("Leticia Florêncio", "florenciolee63@gmail.com",
                "Testando nova classe e-mail com HTML", "Teste html" + stringBuilderTextoEmail.toString());

        enviaEmail.enviarEmail(true);

    }
}
