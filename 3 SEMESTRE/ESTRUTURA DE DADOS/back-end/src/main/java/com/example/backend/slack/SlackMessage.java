package com.example.backend.slack;

import org.json.JSONObject;
public class SlackMessage {


    public static void messagemCanal1(String mensagem) {
        SlackConnetion slack = new SlackConnetion();
        JSONObject json = new JSONObject();

        slack.setUrl("https://hooks.slack.com/services/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");

        try {
            json.put("text", mensagem);
            slack.sendMessage(json);
        } catch (Exception erro) {
            System.err.println(erro);
        }
    }

    public static void messagemMulherSegura(String mensagem) {
        SlackConnetion slack = new SlackConnetion();
        JSONObject json = new JSONObject();

        slack.setUrl("https://hooks.slack.com/services/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");

        try {
            json.put("text", mensagem);
            slack.sendMessage(json);
        } catch (Exception erro) {
            System.err.println(erro);
        }
    }

    public static void messagemOutros(String mensagem) {
        SlackConnetion slack = new SlackConnetion();
        JSONObject json = new JSONObject();

        slack.setUrl("https://hooks.slack.com/services/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");

        try {
            json.put("text", mensagem);
            slack.sendMessage(json);
        } catch (Exception erro) {
            System.err.println(erro);
        }
    }
}
