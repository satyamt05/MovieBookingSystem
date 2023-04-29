package com.capgemini.moviesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Show")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "showId")
	private int showId;

	@Column(name = "showStartTime")
	private String showStartTime;

	@Column(name = "showEndTime")
	private String showEndTime;

	@Column(name = "availableSeats")
	private int availableSeats;

	@Column(name = "showName")
	private String showName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_Id", referencedColumnName = "movie_Id")
	private Movie movieId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screen_Id", referencedColumnName = "screen_Id")
	private Screen screenId;

	public Show() {
		super();
	}

	public Show(int showId, String showName) {
		super();
		this.showId = showId;
		this.showName = showName;
	}

	public Show(int showId, String showStartTime, String showEndTime, int availableSeats, String showName,
			Movie movieId, Screen screenId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.availableSeats = availableSeats;
		this.showName = showName;
		this.movieId = movieId;
		this.screenId = screenId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(String showStartTime) {
		this.showStartTime = showStartTime;
	}

	public String getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(String showEndTime) {
		this.showEndTime = showEndTime;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovieId() {
		return movieId;
	}

	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}

	public Screen getScreenId() {
		return screenId;
	}

	public void setScreenId(Screen screenId) {
		this.screenId = screenId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", availableSeats=" + availableSeats + ", showName=" + showName + ", movieId=" + movieId
				+ ", screenId=" + screenId + "]";
	}

}
