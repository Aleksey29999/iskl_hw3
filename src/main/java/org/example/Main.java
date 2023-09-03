package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

//import static sun.nio.fs.AbstractFileSystemProvider.split;

public class Main {
//    public static String fio;
//    public static String tell;
//    public static String data;
//    public static String fm;

    public static void main(String[] args) {

        String fio1 = fioInput();
        String data1 = dataInput();
        String tell1 = tellInput();
        String fm1 = fmInput();

        filecreate(fio1, data1, tell1, fm1);

    }

    public static String fioInput() {
        System.out.print("введите Фамилию Имя Отчество через пробел: ");
        Scanner inFio = new Scanner(System.in);
        String fio = inFio.nextLine();
        String[] words = fio.split(" ");
        if (fio.length() == 0) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        if (words.length != 3) {
            throw new RuntimeException("Неверный формат ввода");
        }
        System.out.println("Фамилия Имя Отчество : " + fio);

        return fio;
    }

    static String dataInput() {
        System.out.print("введите дату рождения дд.мм.гггг: ");
        Scanner inData = new Scanner(System.in);
        String data = inData.next();
        if ((data.length() == 0)) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        System.out.println("Дата рождения: " + data);
        return data;
    }

    static String tellInput() {
        System.out.print("введите номер телефона без +7");
        Scanner inTell = new Scanner(System.in);
        String tell = inTell.next();
        if ((tell.length() != 10)) {
            throw new RuntimeException("неверный формат ввода");
        }
        System.out.println("телефон: +7" + tell);
        return tell;
    }

    static String fmInput() {
        System.out.print("введите пол  f или m");
        Scanner inFm = new Scanner(System.in);
        String fm = inFm.next();
        if (fm.equals("f") | fm.equals("m")) {
            System.out.println("Пол: " + fm);
        } else {
            throw new RuntimeException("неверный формат ввода");
        }
        return fm;
    }

    static void filecreate(String fio1, String data1, String tell1, String fm1) {

        String[] words = fio1.split(" ");
//        String filename = Paths.get(words[0]);
        try (FileWriter fileWriter = new FileWriter(words[0], false)) {

            fileWriter.write("Фамилия Имя Отчество: " + fio1 + "\n");
            fileWriter.write("Дата рождения :" + data1 + "\n");
            fileWriter.write("Номер телефона: +7" + tell1 + "\n");
            fileWriter.write("пол: "+fm1 + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}