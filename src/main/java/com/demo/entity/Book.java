package com.demo.entity;

import com.demo.constants.BookGenre;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(name = "Book_publisher",
            joinColumns = @JoinColumn(name = "Book_publisher_book_id"),
            inverseJoinColumns = @JoinColumn(name = "Book_publisher_publisher_id")
    )
    private List<Publisher> publishers;

    @Column(name = "Book_CT")
    private String bookCT;

    public Book() {
        //method called by spring container
    }

    public Book(String title, String description, String publicationYear, String amazonRating, String genre, List<Publisher> publishers) {
        super(title, description);
        this.publicationYear = publicationYear;
        this.amazonRating = amazonRating;
        this.genre = genre;
        this.publishers = publishers;
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

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public String getBookCT() {
        return bookCT;
    }

    public void setBookCT(String bookCT) {
        this.bookCT = bookCT;
    }

    public void addPublishers(List<Publisher> publisherList) {
        if (publishers == null)
            publishers = new ArrayList<>();
        publishers.addAll(publisherList);
    }

    public void removePublishers(List<Publisher> publisherList) {
        if (publisherList != null)
            publishers.removeAll(publisherList);
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
                ", bookCT='" + bookCT + '\'' +
                '}';
    }
}
