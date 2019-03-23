/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.controle;

/**
 * Classe auxiliar para ações gerenalizadas
 * @author Lucas Zingaro
 */
public class Controle {
    /**
     * Verifica se é um numero inteiro (Simples)
     *
     * @param num - Objeto a ser avaliado
     * @return - Resposta verdadeira ou falsa
     */
    public static boolean isNumberInt(Object num) {
        try {
            Integer.parseInt(num.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica se é um numero inteiro (Sofisticado)
     *
     * @param num - String a ser avaliada
     * @return - Resposta verdadeira ou falsa
     */
    public static boolean isNumberInt(String num) {
        try {
            if (num.isEmpty() || num.length() < 1) {
                return false;
            }
            if (!Character.isDigit(num.charAt(0))) {
                return false;
            }
            for (int i = 0; i < num.length(); i++) {
                if (Character.isDigit(num.charAt(i)) == false) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica se é um numero qualquer (Simples)
     *
     * @param num - Objeto a ser avaliado
     * @return - Resposta verdadeira ou falsa
     */
    public static boolean isNumber(Object num) {
        try {
            num=num.toString().replace(',', '.');
            Integer.parseInt(num.toString());
            return true;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(num.toString());
                return true;
            } catch (NumberFormatException f) {
                try {
                    Float.parseFloat(num.toString());
                    return true;
                } catch (NumberFormatException g) {
                    return false;
                }
            }
        }
    }

    /**
     * Verifica se é um numero qualquer (Sofisticado)
     *
     * @param num - String a ser avaliada
     * @return - Resposta verdadeira ou falsa
     */
    public static boolean isNumber(String num) {
        try {
            num=num.replace(',', '.');
            if (num.isEmpty() || num.length() < 1) {
                return false;
            }
            if (Character.isDigit(num.charAt(0))) {
                return false;
            }
            int cont = 0;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == '.') {
                    cont++;
                } else if (Character.isDigit(num.charAt(i)) == false) {
                    return false;
                }
                if (cont > 1) {
                    return false;
                }

            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
