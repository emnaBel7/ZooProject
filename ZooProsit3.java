public class ZooProsit3 {
    public static void main(String[] args) {
        Animal lion = new Animal("Felidae", "Lion", 6, true);
        Animal tigre = new Animal("Felidae", "Tigre", 4, true);
        Animal cobra = new Animal("Elapidae", "Cobra", 2, false);

        Zoo myZoo = new Zoo("EspritZoo", "Ariana");

        System.out.println(myZoo.addAnimal(lion));
        System.out.println(myZoo.addAnimal(tigre));
        System.out.println(myZoo.addAnimal(cobra));

        System.out.println(myZoo.addAnimal(new Animal("Felidae", "Lion", 3, true)));
        System.out.println(myZoo.removeAnimal(cobra));

        myZoo.displayAnimals();
        System.out.println(myZoo.searchAnimal(new Animal("", "Tigre", 0, true)));
        System.out.println(myZoo.isZooFull());

        Zoo other = new Zoo("CityZoo", "Tunis");
        other.addAnimal(new Animal("Canidae", "Loup", 5, true));

        Zoo bigger = Zoo.comparerZoo(myZoo, other);
        System.out.println(bigger == myZoo ? "myZoo" : "other");
    }
}

class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    boolean sameByName(Animal other) {
        if (other == null) return false;
        if (this.name == null) return false;
        return this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', family='" + family + "', age=" + age + ", isMammal=" + isMammal + "}";
    }
}

class Zoo {
    public static final int NBR_CAGES = 25;

    Animal[] animals;
    int animalsCount;
    String name;
    String city;

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
        this.animalsCount = 0;
    }

    public boolean addAnimal(Animal a) {
        if (a == null) return false;
        if (isZooFull()) return false;
        if (searchAnimal(a) != -1) return false;
        animals[animalsCount++] = a;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animaux (" + animalsCount + "):");
        for (int i = 0; i < animalsCount; i++) {
            System.out.println(i + " -> " + animals[i]);
        }
        if (animalsCount == 0) System.out.println("(aucun)");
    }

    public int searchAnimal(Animal target) {
        if (target == null) return -1;
        for (int i = 0; i < animalsCount; i++) {
            if (animals[i] != null && animals[i].sameByName(target)) return i;
        }
        return -1;
    }

    public boolean removeAnimal(Animal target) {
        int idx = searchAnimal(target);
        if (idx == -1) return false;
        animals[idx] = animals[animalsCount - 1];
        animals[animalsCount - 1] = null;
        animalsCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalsCount >= NBR_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        return z1.animalsCount >= z2.animalsCount ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', cages=" + NBR_CAGES + ", nbAnimaux=" + animalsCount + "}";
    }
}
