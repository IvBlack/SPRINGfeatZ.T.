package spring_introduction;

class Dog implements Pet{

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}