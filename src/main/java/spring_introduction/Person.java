package spring_introduction;

public class Person {
    //у каждого Person - свое животное
    //приступаем к DI
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    //откликается животное, прописанное в конфиге
    public void callYourPet() {
        System.out.println("Hey, my cute pet!");
        pet.say();
    }
}
