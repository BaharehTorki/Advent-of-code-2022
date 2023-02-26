package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void name() throws IOException {
        List<String> list = Files.readAllLines(new File("src/test/resources/CaloriesList.txt").toPath(), Charset.defaultCharset());
        List<String> collect = list.stream()
                .dropWhile(i->i.isEmpty())
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}