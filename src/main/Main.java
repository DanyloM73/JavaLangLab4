package main;

import main.animals.*;
import main.enclosures.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        BirdEnclosure<Bird> birdEnclosure = new BirdEnclosure<>(3);
        LionEnclosure<Lion> lionEnclosure = new LionEnclosure<>(2);
        HoofedEnclosure<Hoofed> hoofedEnclosure = new HoofedEnclosure<>(4);

        zoo.addEnclosure(birdEnclosure);
        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(hoofedEnclosure);

        birdEnclosure.addAnimal(new Eagle());
        birdEnclosure.addAnimal(new Eagle());
        birdEnclosure.addAnimal(new Eagle());
        lionEnclosure.addAnimal(new Lion());
        lionEnclosure.addAnimal(new Lion());
        hoofedEnclosure.addAnimal(new Zebra());
        hoofedEnclosure.addAnimal(new Zebra());
        hoofedEnclosure.addAnimal(new Giraffe());
        hoofedEnclosure.addAnimal(new Giraffe());

        System.out.println("The number of animals in the zoo: " + zoo.getCountOfAnimals());
    }
}