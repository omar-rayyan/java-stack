package com.axsosacademy.booksclub.mvc.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books_tble")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @NotNull(message = "Cannot be null")
	@Size(min=1,message = "Please enter the title.")
    private String title;

    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Please enter the author.")
    private String author;

    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Please type your thoughts.")
    private String thoughts;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Book(){}
    
    public Book( String title, String author, String thoughts) {
        this.title = title;
        this.author = author;
        this.thoughts=thoughts;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

    
}