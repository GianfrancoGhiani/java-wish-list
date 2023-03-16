package org.lessons.java.bonus;

import java.util.*;

public class ChristmasLetterDesiderio {
//    Contiene il nome e l’indirizzo del mittente e la lista dei desideri (List<String>).
//    Aggiungere opportuni costruttori e metodi getter e setter.
//    Aggiungere un metodo send(), che prova ad inviare la lettera a Babbo Natale:
//    se tutto va bene il metodo stampa a video la lettera, il nome e l’indirizzo
//    se la lista dei desideri supera i 5 elementi, il metodo deve sollevare un’eccezione
//    calcolare in modo random un booleano che rappresenta se il mittente è stato buono oppure no:
//          se il booleano è false il metodo si chiude sollevando un’eccezione.

    private String address;
    private List<Desiderio> wishes;


    //constructor
    public ChristmasLetterDesiderio(String address, List<Desiderio> wishes) throws IllegalArgumentException{



        if (address.isBlank()){
            throw new IllegalArgumentException("You need to specify your address");
        }
        if(!(wishes.size()>0)){
            throw new IllegalArgumentException("You must have at least one wish");
        }

        this.address = address;
        this.wishes = wishes;
    }
    //getter and setter



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address.isBlank()){
            throw new IllegalArgumentException("You need to specify your address");
        }
        this.address = address;
    }

    public List<Desiderio> getWishes() {
        return wishes;
    }

    public void setWishes(List<Desiderio> wishes) throws IllegalArgumentException {
        if(!(wishes.size()>0)){
            throw new IllegalArgumentException("You must have at least one wish");
        }
        this.wishes = wishes;
    }

    //methods


    @Override
    public String toString() {
        return
                ", address='" + address + '\'' +
                ", wishes=" + wishes.toString() ;
    }
    public Map<Desiderio, Integer> contaDesideri(){
        Map<Desiderio, Integer> mappaDesideri = new HashMap<>();
        for (Desiderio wish : wishes) {
            if (mappaDesideri.containsKey(wish)){
                mappaDesideri.put(wish, (mappaDesideri.get(wish) +1));
            }else {
                mappaDesideri.put(wish, 1);
            }
        }
        System.out.println(mappaDesideri);
        return mappaDesideri;
    }
    public Set<Desiderio> desideriUnici(){
        System.out.println(new HashSet<>(wishes));
        return new HashSet<>(wishes);
    }
    public Map<String, Integer> contaDesiderPerDestinatario(){
        Map<String, Integer> mappaDestinatari = new HashMap<>();

        for (Desiderio wish: wishes) {
            String destinatario = wish.getDestinatario();
            if (mappaDestinatari.containsKey(destinatario)){
                mappaDestinatari.put(destinatario, (mappaDestinatari.get(destinatario) +1));
            }else {
                mappaDestinatari.put(destinatario, 1);
            }
        }
        System.out.println(mappaDestinatari);
        return mappaDestinatari;
    }

}
