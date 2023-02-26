package org.example.AoC_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalorieCounting {
    public List<String> readFile(String fileName) {
        List<String> input = new ArrayList<>();

        String file = this.getClass().getClassLoader().getResource(fileName).getFile();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                input.add(s);
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static int index = 1;

    public void solution1() {
        List<String> inputs = readFile("caloriesList.txt");

        int max = inputs.stream()
                .map(this::toFoo)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Foo::getIndex))
                .values().stream()
                .map(foos -> foos.stream()
                        .map(Foo::getNum)
                        .reduce(Integer::sum).get())
                .mapToInt(i -> i)
                .max()
                .getAsInt();

        System.out.println(max);
    }

    private Foo toFoo(String s) {
        if (s.length() == 0) {
            index++;
            return null;
        } else {
            return new Foo(index, Integer.parseInt(s));
        }
    }
}
