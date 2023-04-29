package com.capgemini.moviebookingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "showName")
	private String showName;

	@Column(name = "movieName")
	private String movieName;

	@Column(name = "screenId")
	private int screenId;

	@Column(name = "theaterId")
	private int theaterId;

	public Show() {
		super();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
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

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Show(int showId, String showStartTime, String showEndTime, String showName, String movieName, int screenId,
			int theaterId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", showName=" + showName + ", movieName=" + movieName + ", screenId=" + screenId + ", theaterId="
				+ theaterId + "]";
	}
}
