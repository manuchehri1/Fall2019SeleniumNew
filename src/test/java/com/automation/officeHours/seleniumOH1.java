package com.automation.officeHours;

import java.util.ArrayList;
import java.util.Iterator;

public class seleniumOH1 {




    public static void main(String[] args) {

        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");



        Iterator iterator = keysToSearch.iterator();


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

      Iterator iterator1 = keysToSearch.iterator();

        while (iterator1.hasNext()){

        }


    }
}
