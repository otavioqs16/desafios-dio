package com.digitalinnovationone.desafio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidaSenha {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha;

        while((senha = br.readLine()) != null){
            boolean containsSimbol = !senha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
            boolean tamanhoSenha = senha.length() >= 6 && senha.length() <= 32;
            boolean containsDigit = false;
            boolean containsUpper = false;
            boolean containsLower = false;

            for(int i = 0; i < senha.length(); i++){
                if(Character.isDigit(senha.charAt(i))){
                    containsDigit = true;
                }else if(Character.isUpperCase(senha.charAt(i))){
                    containsUpper = true;
                }else if(Character.isLowerCase(senha.charAt(i))){
                    containsLower = true;
                }
            }

            if(tamanhoSenha && containsDigit && containsLower&& containsUpper && !containsSimbol){
                System.out.println("Senha valida.");
            }else{
                System.out.println("Senha invalida.");
            }
        }


    }
}
