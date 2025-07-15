package br.com.alura.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {

    public void test() {

        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        listaDeNumeros.stream()
                .flatMap(List::stream)
                .filter(this::isPrime)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
