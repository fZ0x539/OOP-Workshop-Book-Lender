package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion
        // Initialize and display Book & Person instances
        // Simulate borrowing a book
        // Simulate returning a book
        Person person1 = new Person("Zuuhad", "Ali");
        Person person2 = new Person("Musse", "Pig");
        Book book1 = new Book("Medley", "Bungie", person1);
        Book book2 = new Book("Kalle Anka", "Walt Disney", person2);
        Book book3 = new Book("Trassel", "Walt Disney");

        System.out.println(person1.getPersonalInformation());
        person1.borrowBook(book3);
        person1.borrowBook(book2);
        System.out.println(person1.getPersonalInformation());
        person2.returnBook(book2);
        person1.borrowBook(book2);
        System.out.println(person1.getPersonalInformation());






    }

}
