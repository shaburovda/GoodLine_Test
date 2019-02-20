package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //Уровень 1
        if (args.length != 0) {  // если в командной строек есть элементы

            String[] arrayFromCmd = new String[args.length - 1];// создаем дополнительный массив

            System.arraycopy(args, 1, arrayFromCmd, 0, arrayFromCmd.length); // передаем в дополнительный массив данные из командной строки
                  printArray(arrayFromCmd);// выводим полученный массив на экран
        //Уровень 2
            Arrays.sort(arrayFromCmd);// сортируем массив по алфавиту
                  printArray(arrayFromCmd);// выводим полученный результат на экран
        //Уровень 3
            List<String> listFromArray = uniqueWord(arrayFromCmd);// оставляем только уникальные слова с помощью специального метода
                  printList(listFromArray); // оставляем только уникальные слова с помощью специального метода
        //Уровень 4
            TreeMap<String, Integer> hm = quantityOfWords(arrayFromCmd); // создаем карту и помещаем в нее слова и количество их повторений TreeMap для того чтобы слова были по алфавиту
                 printMap(hm); // выводим результат

        }
        // Уровень 5
        else {//в случае если не передано ниодного параметра
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//считываем строки потока ввода
            String stringFromStream = reader.readLine();

            String stringBetween = betweenQuotes(stringFromStream);// находим строку между кавычками с помощью специального метода

            String [] arrayBetween = stringToArray(stringBetween, " "); // переводим строку в массив
                 printArray(arrayBetween); // выводим результат

            Arrays.sort(arrayBetween); // сортируем массив
                 printArray(arrayBetween);// выводим результат

            List<String> list = uniqueWord(arrayBetween);// оставляем только уникальные слова с помощью специального метода
                 printList(list);// выводим результат

            TreeMap<String, Integer> treeMap = quantityOfWords(arrayBetween);// создаем карту и помещаем в нее слова и количество их повторений TreeMap для того чтобы слова были по алфавиту
                 printMap(treeMap);// выводим результат
        }
    }
    //метод для нахождения текста между кавычек, для данного задания подойдет
    public static String betweenQuotes(String s){
        String massivForParser [] = s.split("\"");
        return massivForParser[1];
    }
    // метод для перевода строки в массив
    public static String[] stringToArray(String words, String div){
        String arrForParses [] = words.split(div);
        return arrForParses;
    }
    //Метод для удаления повторяющихся слов
    public static List uniqueWord(String [] array){
        List<String> listFromArray = new ArrayList<>();// создаем дополнительный список
        Collections.addAll(listFromArray, array); // передаем в него существующий массив
        List<String> sortedList = listFromArray.stream().distinct().collect(Collectors.toList());// удаляем повторяющиеся слова
        return sortedList; //возвращаем список только с уникальными словами
    }
    // Метод для подсчета повторяющихся слов
    public static TreeMap quantityOfWords (String [] array){
        TreeMap<String, Integer> hm = new TreeMap<String, Integer>(); // создаем дополнительную карту
        Integer am;// создаем дополнительную переменную
        for (String s : array) {
            am = hm.get(s);
            hm.put(s, am == null ? 1 : am + 1); //считаем количество повторений
        }
        return hm;
    }
    //метод для вывода массива
    public static void printArray (String[] array){
        for (String s : array) System.out.println(s);
    }
    //метод для вывода списка
    public static void printList (List<String> list){
        for (String s : list) System.out.println(s);
    }
    //метод для вывода карты
    public static void printMap (Map<String, Integer> map){
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey()+ " " + pair.getValue());
        }
    }
}
