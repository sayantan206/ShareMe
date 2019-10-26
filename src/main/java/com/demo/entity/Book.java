package com.demo.entity;

import com.demo.constants.BookGenre;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "Book_ID")),
        @AttributeOverride(name = "title", column = @Column(name = "Book_Title")),
        @AttributeOverride(name = "description", column = @Column(name = "Book_description"))
})
public class Book extends Bookmark {

    @Column(name = "Book_publish_year")
    private String publicationYear;

    @Column(name = "Book_amazon_rating")
    private String amazonRating;

    @Column(name = "Book_genre")
    private String genre;

    //todo: change cascade type to non delete
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Book_publisher",
            joinColumns = @JoinColumn(name = "Book_publisher_book_id"),
            inverseJoinColumns = @JoinColumn(name = "Book_publisher_publisher_id")
    )
    private Set<Publisher> publishers = new HashSet<>();

    @Column(name = "Book_CT")
    private String bookCT;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Book_author",
            joinColumns = @JoinColumn(name = "Book_author_book_id"),
            inverseJoinColumns = @JoinColumn(name = "Book_author_author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book() {
        //method called by spring container
    }

    public Book(String title, String description, String publicationYear, String amazonRating, String genre) {
        super(title, description);
        this.publicationYear = publicationYear;
        this.amazonRating = amazonRating;
        this.genre = genre;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(String amazonRating) {
        this.amazonRating = amazonRating;
    }

    public String getGenre() {
        return genre;
    }

    @Autowired
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<BookGenre> getGenreOptions() {
        return Arrays.asList(BookGenre.values());
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
        //create bi-directional link
        publishers.forEach(p -> p.addBook(this));
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
        authors.forEach(a -> a.addBook(this));
    }

    public String getBookCT() {
        return bookCT;
    }

    public void setBookCT(String bookCT) {
        this.bookCT = bookCT;
    }

    public void addPublisher(Publisher publisher) {
        this.getPublishers().add(publisher);
        publisher.getBooks().add(this);
    }

    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher);
        publisher.getBooks().remove(this);
    }

    public void addAuthor(Author author) {
        this.getAuthors().add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", amazonRating='" + amazonRating + '\'' +
                ", genre=" + genre +
                ", publishers=" + publishers +
                ", authors=" + authors +
                ", bookCT='" + bookCT + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return super.getId() != 0L && super.getId() == ((Book) o).getId();
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
