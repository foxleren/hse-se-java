package Library;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private final String name;

    private final String description;

    private final String date;

    private final ArrayList<String> authors;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public Book(String name, String description, String date, ArrayList<String> authors) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.authors = authors;
    }

    public boolean equals(Book other) {
        return Objects.equals(this.name, other.name) && Objects.equals(this.description, other.description) && Objects.equals(this.authors, other.authors) && Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Description: " + this.description + ", Author: " + this.authors + ", Date: " + this.date;
    }
}
