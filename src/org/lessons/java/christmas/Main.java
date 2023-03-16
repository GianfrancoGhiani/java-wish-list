package org.lessons.java.christmas;

import java.util.*;

public class Main {
//    Creare una List<String> dove salvare la lista dei desideri per Natale.
//    Continuare a chiedere all’utente di inserire un nuovo desiderio nella lista, fino a che l’utente sceglie di fermarsi.
//    Ad ogni iterazione mostrare quanti desideri sono già stati espressi e chiedere all’utente se vuole continuare o fermarsi.
//    Aggiungere ciascun desiderio alla lista. Al termine dell’inserimento stampare a video la lista ordinata

    public static void main(String[] args) {
        //import
        Scanner input = new Scanner(System.in);

        List<String> wishes = new ArrayList<>();
        boolean quit = false;
        do {
            System.out.println("do you want to insert a wish? y/n");
            String choice = input.nextLine();
            if (Character.toLowerCase(choice.charAt(0)) == 'y'){
                System.out.println("please insert your wish: ");
                String wish = input.nextLine();
                if (!(wish.isBlank())){
                    wishes.add(wish);
                }

                System.out.println("Do you have a list of "+ wishes.size()+ " wishes");
            } else if (Character.toLowerCase(choice.charAt(0)) == 'n') {
                quit = true;
            } else{
                System.out.println("please insert a correct value (y/n)");
            }
        }while (!quit);
        Collections.sort(wishes);
        System.out.println(wishes);
    }
}
