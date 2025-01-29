package se.lexicon.model;


import java.util.UUID;

/**
 * This class represents a Book model with properties and methods
 * to manage book-related information and operations.
 */
public class Book {
    // todo: needs completion
    //Fields
    private String id;
    private String title;
    private String author;
    private boolean available = true;
    private Person borrower;

    //Constructors
    public Book(String title, String author, Person borrower) {
        this(title, author);
        borrower.borrowBook(this);
    }

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
        this.id = generateId();
    }

    //Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title is null or empty");
        }
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if(author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Author is null or empty");
        }
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        setAvailable(borrower == null);
        this.borrower = borrower;
    }

    //Methods

    public StringBuilder getBookInformation(){
        StringBuilder builder = new StringBuilder();
        builder.append("Book{");
        builder.append("id='").append(id).append('\'');
        builder.append(", title='").append(title).append('\'');
        builder.append(", author='").append(author).append('\'');
        builder.append(", available=").append(available);
        if(!available && borrower != null) {
            builder.append(", borrower=").append(borrower.getFirstName()).append(" ").append(borrower.getLastName()).append(", borrowerId=").append(borrower.getId());
        }
        builder.append("}\n");
        return builder;
    }

    private String generateId(){
        //Generate a UUID string and assign it to id
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}