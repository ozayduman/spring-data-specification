package com.ozayduman.customer;

import io.vavr.API;
import static io.vavr.Predicates.*;

import static io.vavr.API.*;

public class MainTest
{
    public static void main(String[] args) {
       int vize = 50, finalNotu = 50;
       double puan = (vize * 0.4) + (finalNotu * 0.6);
       System.out.println("Yıl sonu notunuz = " + puan);
       String result =  Match(puan).of(
                Case($(n -> n > 90), "AA ile dersi geçtiniz." ),
                Case($(n -> n > 85), "BA ile dersi geçtiniz." ),
                Case($(n -> n > 80), "BB ile dersi geçtiniz." ),
                Case($(n -> n > 85), "BA ile dersi geçtiniz." ),
                Case($(n -> n > 75), "CB ile dersi geçtiniz." ),
                Case($(n -> n > 50), "Kosullu geçtiniz." ),
                Case($(), "Dersi geçtiniz.")
        );
        System.out.println(result);
    }
}
