package slackSendMessage;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class wasdSlack {
    private static String maquinaCadastroUrl = "https://hooks.slack.com/services/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";
    private static String monitoramentoUrl = "https://hooks.slack.com/services/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";
    private static String slackChannel = "";  // nao é necessario passar string do canal, apenas URL no payload!

    public static void main(String[] args) {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        //Maquina maquina = looca.getMaquina();

        sendMessageToMaquinaCadastro(sistema.toString());
        System.out.println("Chegou aqui");
        sendMessageToMonitoramento("1111");
        System.out.println("Passou la");
    }

    public static void sendMessageToMaquinaCadastro(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);
            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
            WebhookResponse wbResp = Slack.getInstance().send(maquinaCadastroUrl, payload);
            //System.exit(0);  // MATA A APLICACAO;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void sendMessageToMonitoramento(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);
            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
            WebhookResponse wbResp = Slack.getInstance().send(monitoramentoUrl, payload);
            System.exit(0);  // MATA A APLICACAO;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
