/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license */

package com.mycompany.verificacao;

/* @author sonha */
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Verificacao {

    public static boolean verificaExpressao(String expressao) {
        LinkedList<Character> pilha = new LinkedList<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty() || !verificaCorrespondencia(pilha.pop(), caractere)) {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    private static boolean verificaCorrespondencia(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }

    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog("Digite uma expressao aritmetica:");

        if (expressao != null && verificaExpressao(expressao)) {
            JOptionPane.showMessageDialog(null, "Expressao correta.");
        } else {
            JOptionPane.showMessageDialog(null, "Expressao incorreta.");
        }
    }
}
