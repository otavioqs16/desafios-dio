package com.digitalinnovationone.desafio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Conjuntos {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<String> conjuntos = new ArrayList<>();

        while(N != 0){
            for(int i = 0; i < N; i++){
                conjuntos.add(br.readLine());
            }
            conjuntos = conjuntos.stream().sorted().collect(Collectors.toList());

            String saida = "Conjunto bom";
            for(int i = 0; i < N - 1; i++){
                if(conjuntos.get(i + 1).startsWith(conjuntos.get(i))){
                    saida = "Conjunto ruim";
                }
            }

            System.out.println(saida);
            conjuntos.clear();
            N = Integer.valueOf(br.readLine());
        }
    }
}
