package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        System.out.println("Number of animals: " + animalArrayList.size());
        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());

        animalArrayList.add(new Parrot("Dolly"));
        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);
        System.out.println("Louie's position is: " + animalArrayList.indexOf(louie));

        animalArrayList.sort(Animal.AnimalNameComparator);

        printAllAnimals(animalArrayList);
        System.out.println("Louie's position after sorting is: " + animalArrayList.indexOf(louie));

        System.out.println(Arrays.toString(animals));
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
