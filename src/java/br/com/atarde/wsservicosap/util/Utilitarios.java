package br.com.atarde.wsservicosap.util;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.topsys.util.TSUtil;

public final class Utilitarios {

    private Utilitarios() {

    }

    public static String tratarString(String valor) {
        if (!TSUtil.isEmpty(valor)) {
            valor = valor.trim().replaceAll("  ", " ");
        }

        return valor;
    }

    public static Long tratarLong(Long valor) {
        if ((!TSUtil.isEmpty(valor)) && (valor.equals(Long.valueOf(0L)))) {
            valor = null;
        }

        return valor;
    }

    public static String removerAcentos(String palavra) {
        if (TSUtil.isEmpty(palavra)) {
            return null;
        }

        return Normalizer.normalize(new StringBuilder(palavra), Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String gerarSenha() {
        Calendar rightNow = Calendar.getInstance();

        int diaAtual = rightNow.get(5);
        int mesAtual = rightNow.get(2) + 1;
        int anoAtual = rightNow.get(1);
        int horaAtual = rightNow.get(11);
        int minutoAtual = rightNow.get(12);
        int segAtual = rightNow.get(13);
        int miliAtual = rightNow.get(14);

        String senha = anoAtual + mesAtual + diaAtual + horaAtual + minutoAtual + segAtual + miliAtual + "";

        return senha;
    }

    public static String getSituacao(Boolean flagAtivo) {
        if ((!TSUtil.isEmpty(flagAtivo)) && (flagAtivo.booleanValue())) {
            return "Ativo";
        }

        return "Inativo";
    }

    public static String getDiaMesAno(Date data) {

        if (!TSUtil.isEmpty(data)) {
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            calendar.setTime(data);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            int mes = calendar.get(Calendar.MONTH);
            mes = mes + 1;
            String diaMesAno = "" + dia;
            if (mes < 10) {
                diaMesAno = diaMesAno + "0";
            }
            diaMesAno = diaMesAno + "_" + mes + "_" + calendar.get(Calendar.YEAR) + "_";
            return diaMesAno;

        }
        return null;
    }

    public static boolean isBetweenDateTime(Date dataReferencia, Date dataInicial, Date dataFinal) {

        Calendar dataInicialCalendar = Calendar.getInstance();

        dataInicialCalendar.setTime(dataInicial);
        dataInicialCalendar.set(Calendar.SECOND, 0);
        dataInicialCalendar.set(Calendar.MILLISECOND, 0);

        Calendar dataFinalCalendar = Calendar.getInstance();

        dataFinalCalendar.setTime(dataFinal);
        dataFinalCalendar.set(Calendar.SECOND, 0);
        dataFinalCalendar.set(Calendar.MILLISECOND, 0);

        Calendar dataCalendar = Calendar.getInstance();

        dataCalendar.setTime(dataReferencia);
        dataCalendar.set(Calendar.SECOND, 0);
        dataCalendar.set(Calendar.MILLISECOND, 0);

        return dataReferencia.after(dataInicialCalendar.getTime()) && dataReferencia.before(dataFinalCalendar.getTime()) || dataCalendar.equals(dataInicialCalendar) || dataCalendar.equals(dataFinalCalendar);

    }

    public static String getUrlAcesso(String url) {

        if (url.substring(url.length() - 1).contains("/")) {

            return url.substring(0, url.length() - 1);
        }

        return url;
    }

    public static String getTextoUTF8(String valor) {

        if (!TSUtil.isEmpty(tratarString(valor))) {
            valor = valor.replace("\u0000", "");
            valor = valor.replace("\u001e", "");
            return new String(valor.getBytes(), StandardCharsets.UTF_8);
        }

        return null;
    }

}
