package com.capgemini.moviesystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@SequenceGenerator(name = "seqm", initialValue = 3001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqm")
	@Column(name = "movie_id", length = 10)
	private int id;
	@Column(name = "movie_name", length = 20)
	private String name;
	@Column(name = "movie_genre", length = 15)
	private String genre;
	@Column(name = "movie_director", length = 20)
	private String director;
	@Column(name = "language", length = 10)
	private String language;
	@Column(name = "movie_length", length = 7)
	private int length;
	@Column(name = " movie_release_date", length = 20)
	private Date releaseDate;

	public Movie() {
	}

	public Movie(int id, String name, String genre, String director, String language, int length, Date releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.director = director;
		this.language = language;
		this.length = length;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", director=" + director + ", language="
				+ language + ", length=" + length + ", releaseDate=" + releaseDate + "]";
	}

}
