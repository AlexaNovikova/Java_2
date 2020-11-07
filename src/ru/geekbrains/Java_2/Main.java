package ru.geekbrains.Java_2;

import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Первая задача: ");
        firstTask();
        System.out.println();
        System.out.println("Вторая задача: ");
        secondTask();

    }


// Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
// из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.

    private static void firstTask() {
        String [] words = {"кот","собака","лошадь","кот","тигр", "крот", "ворона","ворона","кот","слон","лошадь","попугай","кот","собака"};
        Map<Integer,String> mapWords= new HashMap<>();
        Integer key=0;
        int kolSimilarWordsInMass=0;
        for (String word:words) {
            for (int i = 0; i<word.length(); i++){
                key+=(int)(word.charAt(i));
            }
            mapWords.put(key,word);
            key=0;
        }
        for ( Map.Entry<Integer,String > entry: mapWords.entrySet()){
            for (String word:words) {
                if (word.equals(entry.getValue())) {
                    kolSimilarWordsInMass+=1;
                }
            }
            System.out.println(MessageFormat.format("Слово: {0} ", entry.getValue())+ " встречается " + kolSimilarWordsInMass+ " раз/а.");
            kolSimilarWordsInMass=0;
        }
        //System.out.println(mapWords);
    }

    // Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи.
    // С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
    // несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

    private static void secondTask() {
    TelephoneGuide telephoneGuide= new TelephoneGuide();
    telephoneGuide.addInfo("Петров", "8-999-987-92-11");
        telephoneGuide.addInfo("Иванов", "8-988-987-92-11");
        telephoneGuide.addInfo("Сидоров", "8-899-985-92-11");
        telephoneGuide.addInfo("Кучеров", "8-999-987-66-22");
        telephoneGuide.addInfo("Волков", "8-777-987-92-11");
        telephoneGuide.addInfo("Петров", "8-900-987-90-11");
        telephoneGuide.addInfo("Волков", "8-999-987-33-22");
        telephoneGuide.addInfo("Петров", "8-499-987-92-11");
        telephoneGuide.addInfo("Петров", "8-199-987-92-11");
        telephoneGuide.getInfo("Петров");
        telephoneGuide.getInfo("Сидоров");
    }
}
