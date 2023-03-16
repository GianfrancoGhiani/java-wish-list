package org.lessons.java.christmas;

import java.util.List;
import java.util.Random;

public class ChristmasLetter {
//    Contiene il nome e l’indirizzo del mittente e la lista dei desideri (List<String>).
//    Aggiungere opportuni costruttori e metodi getter e setter.
//    Aggiungere un metodo send(), che prova ad inviare la lettera a Babbo Natale:
//    se tutto va bene il metodo stampa a video la lettera, il nome e l’indirizzo
//    se la lista dei desideri supera i 5 elementi, il metodo deve sollevare un’eccezione
//    calcolare in modo random un booleano che rappresenta se il mittente è stato buono oppure no:
//          se il booleano è false il metodo si chiude sollevando un’eccezione.
    private String name;
    private String address;
    private List<String> wishes;

    //constructor
    public ChristmasLetter(String name, String address, List<String> wishes) throws IllegalArgumentException{


        if (name.isBlank()){
            throw new IllegalArgumentException("You need to pass a name!");
        }
        if (address.isBlank()){
            throw new IllegalArgumentException("You need to specify your address");
        }
        if(!(wishes.size()>0)){
            throw new IllegalArgumentException("You must have at least one wish");
        }
        this.name = name;
        this.address = address;
        this.wishes = wishes;
    }
    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isBlank()){
            throw new IllegalArgumentException("You need to pass a name!");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address.isBlank()){
            throw new IllegalArgumentException("You need to specify your address");
        }
        this.address = address;
    }

    public List<String> getWishes() {
        return wishes;
    }

    public void setWishes(List<String> wishes) throws IllegalArgumentException {
        if(!(wishes.size()>0)){
            throw new IllegalArgumentException("You must have at least one wish");
        }
        this.wishes = wishes;
    }

    //methods
    public void send() throws IllegalArgumentException, IllegalStateException {
        //import
        Random random = new Random();
        boolean badGuy = random.nextBoolean();
        if(badGuy){
            throw new IllegalStateException("You are not a good guy, try to be a kind person next year <3");
        } else {
            if(wishes.size() > 5){
                throw new IllegalArgumentException("You have to many wishes");
            }
            else {
                String wishList = "" ;
                for (int i = 0; i < wishes.size(); i++) {
                    wishList += wishes.get(i)+", \n";
                }
                System.out.print("Dear Santa Claus, " +
                        "\n" +
                        "I'm " + name+ " living in: "+ address+ " this is my wish list: "+ wishList + "please give me all, i'm a good guy");
            }
        }

        }

}
