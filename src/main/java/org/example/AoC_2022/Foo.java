package org.example.AoC_2022;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Foo {

    private int index;
    private Integer num;

    public Foo(int index) {
        this.index = index;
    }

    public Foo(int index, Integer num) {
        this.index = index;
        this.num = num;
    }

    public int getIndex() {
        return index;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "{" + index + ", " + num + '}';
    }
}
