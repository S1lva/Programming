package com.company;
import java.io.*;
import java.util.*;


public class Main {
    //БЛОК ОПИСАНИЯ ХРАНИМЫХ В КОЛЛЕКЦИИ КЛАССОВ
    public class StudyGroup {
        private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
        private Integer expelledStudents; //Значение поля должно быть больше 0, Поле не может быть null
        private long shouldBeExpelled; //Значение поля должно быть больше 0
        private FormOfEducation formOfEducation; //Поле не может быть null
        private Person groupAdmin; //Поле может быть null
    }
    public class Coordinates {
        private Float x; //Поле не может быть null
        private double y;
    }
    public class Person {
        private String name; //Поле не может быть null, Строка не может быть пустой
        private long height; //Значение поля должно быть больше 0
        private Color hairColor; //Поле не может быть null
        private Location location; //Поле может быть null
    }
    public class Location {
        private Integer x; //Поле не может быть null
        private Float y; //Поле не может быть null
        private String name; //Поле может быть null
    }
    public enum FormOfEducation {
        DISTANCE_EDUCATION,
        FULL_TIME_EDUCATION,
        EVENING_CLASSES;
    }
    public enum Color {
        GREEN,
        RED,
        BLACK,
        WHITE,
        BROWN;
    }
    //БЛОК ОПИСАНИЯ ХРАНИМЫХ В КОЛЛЕКЦИИ КЛАССОВ

    public static void main(String[] args) {
        //коллекция
        TreeSet<String> collection = new TreeSet<String>();
        // БЛОК ЗАПИСИ ФАЙЛА ИЗ КОНСОЛИ И ВЫВОД ДАННЫХ ИЗ ФАЙЛА В КОНСОЛЬ В ВИДЕ КОЛЛЕКЦИИ

        //используем запись в csv файл с помощью класса java.io.BufferedWriter
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("sample.csv")))
        {
            // чтение построчно
            String text;
            while(!(text=br.readLine()).equals("esc")){

                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        //используем считывание из файла с помощью класса java.io.BufferedReader
        try(BufferedReader br = new BufferedReader(new FileReader("sample.csv")))
        {
            //чтение построчно
            String s;
            //считываем csv и заполняем коллекцию
            while((s=br.readLine())!=null){
                collection.add(s);

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(collection);
        // БЛОК ЗАПИСИ ФАЙЛА ИЗ КОНСОЛИ И ВЫВОД ДАННЫХ ИЗ ФАЙЛА В КОНСОЛЬ В ВИДЕ КОЛЛЕКЦИИ

        //БЛОК КОМАНД
        String a = dwefwe//здесь должен быть пользовательский ввод
        switch(a){
            case 1 (help):
                System.out.println("все команды*");
                break;
        }
        //БЛОК КОМАНД

//конец главного метода
    }
}
