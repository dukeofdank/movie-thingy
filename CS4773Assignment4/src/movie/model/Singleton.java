package movie.model;

import java.util.Observable;

public class Singleton extends Observable {
	private static Singleton instance = null;
	
	private Movie model;
	
	private Singleton() {
		model = new Movie(null, 0, null, null, 0);
		System.out.println("Singleton initialized");
	}
	
	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public void setMovieTitle(String title) {
		model.setMovieTitle(title);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getMovieTitle() {
		return model.getMovieTitle();
	}
	
	public void setReleaseYear(int year) {
		model.setReleaseYear(year);
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getReleaseYear() {
		return model.getReleaseYear();
	}
	
	public void setDirector(String director) {
		model.setDirector(director);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getDirector() {
		return model.getDirector();
	}
	
	public void setWriter(String writer) {
		model.setWriter(writer);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getWriter() {
		return model.getWriter();
	}
	
	public void setRating(int rating) {
		model.setRating(rating);
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getRating() {
		return model.getRating();
	}
}
