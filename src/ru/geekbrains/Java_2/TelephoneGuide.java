package ru.geekbrains.Java_2;

import java.util.*;

public class TelephoneGuide {

    public static Map<String, Set<String>> telephoneGuide;

    TelephoneGuide(){

        telephoneGuide=new HashMap<>();
    }
    public void addInfo(String surname, String telephoneNumber){
        Set<String>phones = getPhones(surname);
        phones.add(telephoneNumber);
    }

    private Set<String> getPhones(String  surname){
        Set <String>phones = telephoneGuide.getOrDefault(surname, new HashSet<>());
        if (phones.isEmpty()){
            telephoneGuide.put(surname,phones);
        }
        return phones;
    }

    public void  getInfo(String surname){
        System.out.println("Список найденных номеров телефона для фамилии " + surname + ": ");
                System.out.println(getPhones(surname));
        }

}

