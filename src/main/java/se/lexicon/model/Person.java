package se.lexicon.model;
/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {
    //Fields
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Book[] books;

    //Constructors
    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
        this.books = new Book[0];
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Methods
    private static int getNextId(){
        return ++sequencer;
    }

    public void borrowBook(Book book){
        if(book.isAvailable()) {
            book.setAvailable(false);
            book.setBorrower(this);
            addBook(book);
            System.out.println(firstName + " " + lastName + " is Borrowing " + book.getTitle() + "...\n");
        } else {
            System.out.println(book.getTitle() + " is not available right now. \n");
        }
    }

    private void addBook(Book book){
        int newLength = books.length + 1;
        Book[] tempArray = new Book[newLength];
        for(int i = 0; i < books.length; i++) {
            tempArray[i] = books[i];
        }
        tempArray[newLength - 1] = book;
        books = tempArray;
    }

    public void returnBook(Book book){
        if(book.getBorrower() != null && book.getBorrower().equals(this)){
            book.setAvailable(true);
            book.setBorrower(null);
            removeBook(book);
            System.out.println(firstName + " " + lastName + " is Returning " + book.getTitle() + "...\n");
        } else {
            System.out.println(book.getTitle() + " is not borrowed by " + firstName + " " + lastName + "\n");
        }

    }

    public void removeBook(Book book){
        int newLength = books.length - 1;
        Book[] tempArray = new Book[newLength];
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getTitle().equals(book.getTitle())){
                continue;
            }
            tempArray[index] = books[i];
            index++;
        }
        books = tempArray;
    }

    public StringBuilder getPersonalInformation(){
        StringBuilder sb = new StringBuilder()
                .append("Name: ")
                .append(getFirstName())
                .append(" ")
                .append(getLastName())
                .append("\n")
                .append("Books borrowed: ")
                .append(books.length)
                .append("\n");
        if(books.length > 0){
            sb.append("Books: \n");
            for(Book book : books){
                sb.append(book.getBookInformation());
            }
            sb.append("\n");
        }
        return sb;
    }
}