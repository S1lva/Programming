package com.company;
import java.io.*;
import java.util.*;


public class Main {
    //БЛОК ОПИСАНИЯ ХРАНИМЫХ В КОЛЛЕКЦИИ КЛАССОВ(начало)
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
    //БЛОК ОПИСАНИЯ ХРАНИМЫХ В КОЛЛЕКЦИИ КЛАССОВ(конец)

    public static void main(String[] args) throws IOException {
        //коллекция
        TreeSet<String> collection = new TreeSet<String>();//данные типа string сортируются в алфавитном порядке

        /*// БЛОК ЗАПИСИ ФАЙЛА ИЗ КОНСОЛИ И ВЫВОД ДАННЫХ ИЗ ФАЙЛА В КОНСОЛЬ В ВИДЕ КОЛЛЕКЦИИ(начало)

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
        }*/
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
        // БЛОК ЗАПИСИ ФАЙЛА ИЗ КОНСОЛИ И ВЫВОД ДАННЫХ ИЗ ФАЙЛА В КОНСОЛЬ В ВИДЕ КОЛЛЕКЦИИ(конец)

        // БЛОК КОМАНД(начало)

        while(true) {

            System.out.print("Введите команду: ");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            //счетчик команд()
            //...надо дописать
            // история пользовательского ввода(массив)
            //...надо дописать


                    switch (command) {
                case "help":
                    BufferedReader br = new BufferedReader(new FileReader("help.txt"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    break;
                case "info"://вывод инфо о коллекции
                    System.out.printf("коллекция содержит %d элементов \n", collection.size());//количество элементов в коллекции
                    System.out.println("коллекция была создана 08.05.2021 в 19:20");
                    break;
                case "show"://выводит все элементы коллекции
                    System.out.println(collection);
                    break;
                case "add element":

                    System.out.print("Введите элемент: ");
                    String element = sc.nextLine();
                    collection.add(element);//добавить элемент в коллекцию
                    System.out.println(collection);
                    break;
                case "update id"://выполняет замену элемента по id

                    System.out.print("Введите id желаемого элемента:  ");
                    int id = sc.nextInt();
                    //...
                    System.out.print("Введите новый элемент: ");
                    String newelement = sc.nextLine();
                    //...
                    //тут осталось дописать как выполнить замену элемента по id
                    break;
                case "remove_by_id"://выполняет удаление элемента по id
                    System.out.print("введите id элемента который хотите удалить: ");
                    int remove = sc.nextInt();
                    collection.remove(remove);
                    System.out.println(collection);
                    break;
                //почему-то не хочет выполняться. Исправить.
                case "clear"://полная очистка коллекции
                    collection.clear();
                    System.out.println(collection);
                    break;
                case "save"://тут требуется единичное действие - сохранить коллекцию в файл одной командой
                /*//используем запись в csv файл с помощью класса java.io.BufferedWriter
                try(BufferedReader bm = new BufferedReader (new InputStreamReader(System.in));
                    BufferedWriter bw = new BufferedWriter(new FileWriter("sample.csv")))
                {
                    // чтение построчно
                    String text;
                    while(!(text=bm.readLine()).equals("esc")){

                        bw.write(text + "\n");
                        bw.flush();
                    }
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }*/
                    break;
                case "execute_script"://выполнить указанный скрипт
                    System.out.print("введите название исполняемого файла: ");
                    String script = sc.nextLine();
                    break;
                case "exit"://здесь он должен выходить из цикла, но у меня почеему-то не хочет
                    break;

            case "add_if_min"://добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                System.out.print("введите новый элемент коллекции: ");
                String min_el = sc.nextLine();

//                if (min_el < collection.first())//
//                    collection.add(min_el);
//                else
//                    System.out.print("введенный элемент больше наименьшего!");

                break;
            case "remove_lower"://удалить из коллекции все элементы, меньшие, чем заданный
                System.out.print("введите элемент: ");
                String lower = sc.nextLine();
                break;
            case "history":
                System.out.print("vsdvsdfs");
                break;
            case "filter_less_than_students_count"://вывести элементы, значение поля studentsCount которых меньше заданного
                System.out.print("vsdvsdfs");
                break;
            case "filter_greater_than_expelled_students"://вывести элементы, значение поля expelledStudents которых больше заданного
                System.out.print("vsdvsdfs");
                break;
            case "print_descending"://вывод коллекцию задом наперед
                NavigableSet<String> navSet = collection.descendingSet();
                System.out.println(navSet);
                break;
            }
        }




        // БЛОК КОМАНД(конец)


    }



//конец главного метода
}





