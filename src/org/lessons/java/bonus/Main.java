package org.lessons.java.bonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
//    Creare una List<String> dove salvare la lista dei desideri per Natale.
//    Continuare a chiedere all’utente di inserire un nuovo desiderio nella lista, fino a che l’utente sceglie di fermarsi.
//    Ad ogni iterazione mostrare quanti desideri sono già stati espressi e chiedere all’utente se vuole continuare o fermarsi.
//    Aggiungere ciascun desiderio alla lista. Al termine dell’inserimento stampare a video la lista ordinata

    public static void main(String[] args) {
        //import
        Scanner input = new Scanner(System.in);
        //  CHRISTMAS LETTER BASE LIST<STRING>
//        List<String> wishes = new ArrayList<>();
//        boolean quit = false;
//        do {
//            System.out.println("do you want to insert a wish? y/n");
//            String choice = input.nextLine();
//            if (Character.toLowerCase(choice.charAt(0)) == 'y'){
//                System.out.println("please insert your wish: ");
//                String wish = input.nextLine();
//                if (!(wish.isBlank())){
//                    wishes.add(wish);
//                }
//
//                System.out.println("Do you have a list of "+ wishes.size()+ " wishes");
//            } else if (Character.toLowerCase(choice.charAt(0)) == 'n') {
//                quit = true;
//            } else{
//                System.out.println("please insert a correct value (y/n)");
//            }
//        }while (!quit);
//        Collections.sort(wishes);
//
//        System.out.println("What's your name?");
//        String name = input.nextLine();
//        System.out.println("Where are you living?");
//        String address = input.nextLine();
//        ChristmasLetter letter = null;
//        try{
//             letter = new ChristmasLetter(name, address, wishes);
//        }catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }
//        if (letter != null){
//            try{
//                letter.contaDesideri();
//                letter.desideriUnici();
//                letter.send();
//            }catch (IllegalStateException e){
//                System.out.println(e.getMessage());
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//                System.out.println("Remove something please");
//                do{
//                    System.out.println("wich one do you want to remove?");
//                    String removingObj = input.nextLine();
//                    if(wishes.contains(removingObj)){
//                      wishes.remove(wishes.indexOf(removingObj));
//                    }else {
//                        System.out.println("retry with an other wish");
//                        System.out.println("This is your list"+ wishes);
//                    }
//                }while (wishes.size() != 5);
//                letter.send();
//            }
//        }
        /*
	 * - Creare un metodo contaDesideri(List<String> desideri) che conta quante volte ogni desiderio
	 * appare nella lista e restituisce una Map<String, Integer> con i relativi conteggi.
	 *
	 * - Vogliamo rimuovere i duplicati dalla lista. Creare un metodo desideriUnici(List<String> desideri) che restituisce
	 * un Set<String> contenente i desideri della lista (saranno già deduplicati per via del Set)
	 *
	 * - Creare una classe Desiderio che contiene nome e destinatario. Modificare il codice scritto in precedenza
	 * in maniera tale da non avere più i desideri come List<String> ma List<Desiderio> (dobbiamo di conseguenza chiedere all'utente
	 * non solo il desiderio ma anche il destinatario).
	 *
	 * Modificare adeguatamente anche i metodi creati contaDesideri e desideriUnici per farli funzionare correttamente
	 * con la nuova List<Desiderio>.
	 *
	 * Creare un nuovo metodo contaDesiderPerDestinatario(List<Desiderio> desideri) che funziona analogamente a
     * contaDesideri ma restituisce una Map<String, Integer> dove la chiave è il destinatario e il valore è
     * il numero dei suoi desideri.
	 */
        //CHRISTMAS LETTER FOR LIST<DESIDERIO>
        List<Desiderio> wishes = new ArrayList<>();
        boolean quit = false;
        do {
            System.out.println("do you want to insert a wish? y/n");
            String choice = input.nextLine();
            if (Character.toLowerCase(choice.charAt(0)) == 'y'){
                System.out.println("please insert your wish: ");
                String wish = input.nextLine();
                System.out.println("please insert your receiver: ");
                String receiver = input.nextLine();

                if (!(wish.isBlank()) && !(receiver.isBlank())){
                    wishes.add(new Desiderio(wish, receiver));
                }

                System.out.println("Do you have a list of "+ wishes.size()+ " wishes");
            } else if (Character.toLowerCase(choice.charAt(0)) == 'n') {
                quit = true;
            } else{
                System.out.println("please insert a correct value (y/n)");
            }
        }while (!quit);


        System.out.println("Where are you living?");
        String address = input.nextLine();
        ChristmasLetterDesiderio letter = null;
        try{
            letter = new ChristmasLetterDesiderio( address, wishes);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        if (letter != null){
            try{
                letter.contaDesideri();
                letter.desideriUnici();
                letter.contaDesiderPerDestinatario();
//                letter.send();
            }catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Remove something please");
                do{
                    System.out.println("wich one do you want to remove?");
                    String removingObj = input.nextLine();
                    if(wishes.contains(removingObj)){
                      wishes.remove(wishes.indexOf(removingObj));
                    }else {
                        System.out.println("retry with an other wish");
                        System.out.println("This is your list"+ wishes);
                    }
                }while (wishes.size() != 5);
//                letter.send();
            }
        }

        input.close();
    }
}
