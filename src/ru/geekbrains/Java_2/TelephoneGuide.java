package ru.geekbrains.Java_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneGuide {

    public static Map<String,String> telephoneGuide;

    TelephoneGuide(){

        telephoneGuide=new HashMap<>();
    }
    public void addInfo(String surname, String telephoneNumber){

        telephoneGuide.put(telephoneNumber,surname);
    }
    public void getInfo(String surname){
        System.out.println("Список найденных номеров телефона для фамилии " + surname + ": ");
        for (Map.Entry<String,String> entry: telephoneGuide.entrySet()){
            if (surname.equals(entry.getValue()))
                System.out.println(entry.getKey());
        }
    }

}

