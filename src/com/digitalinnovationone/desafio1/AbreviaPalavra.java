package com.digitalinnovationone.desafio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AbreviaPalavra {

    public static Map<String, Integer> qtdPalavra;
    public static Map<Character, String> abreviacao;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String frase;

        while(!(frase = br.readLine()).equals(".")){
            StringTokenizer st = new StringTokenizer(frase);
            qtdPalavra = new HashMap<>();
            abreviacao = new TreeMap<>();
            while(st.hasMoreTokens()){
                String palavra = st.nextToken();
                if(palavra.length() > 2){
                    qtdPalavra.put(palavra, qtdPalavra.containsKey(palavra) ? qtdPalavra.get(palavra) + 1 : 1);
                    abreviacao.put(palavra.charAt(0), abreviaPalavra(palavra));
                }
            }
            imprimir(frase);
        }
    }

    private static String abreviaPalavra(String palavra) {
        if (!abreviacao.containsKey(palavra.charAt(0))) {
            return palavra;
        }
        int novaReducaoCaracteres = qtdPalavra.get(palavra) * (palavra.length() - 2);
        String abreviadaAtual = abreviacao.get(palavra.charAt(0));
        int reducaoAtualCaracteres = qtdPalavra.get(abreviadaAtual) * (abreviadaAtual.length() - 2);
        return novaReducaoCaracteres > reducaoAtualCaracteres ? palavra : abreviadaAtual;
    }

    private static void imprimir(String line) {
        List<String> listaPalavraAbreviada = new ArrayList<>();
        for (Character c : abreviacao.keySet()) {
            String palavraAbreviada = abreviacao.get(c);
            line = line.replaceAll("\\b" + palavraAbreviada + "\\b", " " + c + ". ");
            listaPalavraAbreviada.add(c + ". = " + palavraAbreviada);
        }
        System.out.println(line.trim());
        System.out.println(listaPalavraAbreviada.size());
        listaPalavraAbreviada.forEach(System.out::println);
    }
}
