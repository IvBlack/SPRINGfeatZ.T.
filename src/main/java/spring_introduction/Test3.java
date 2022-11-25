package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        //получаем из контекста наше животное и вставляем в конструктор Person
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);

        //создание зависимости вручную
        //Pet pet = new Cat();
        //Person person = new Person(pet);

        //после описания бинов в конфиге
        //вызываем бины из контекста
        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        context.close();
    }
}
