package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import movie.model.Singleton;
import javafx.fxml.Initializable;

public class MovieController implements Initializable, Observer {

    @FXML
    private TextField movieTitle;

    @FXML
    private TextField director;

    @FXML
    private TextField releaseYear;

    @FXML
    private TextField writer;

    @FXML
    private Label ratingText;

    @FXML
    private Slider ratingSlider;
    
    private Singleton model;

    public MovieController() {
    	model = Singleton.getInstance();
    	model.addObserver(this);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		movieTitle.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				model.setMovieTitle(newValue);
			}			
		});
		director.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				model.setDirector(newValue);
			}			
		});
		releaseYear.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String numeric = newValue;
				if (!newValue.matches("\\d*")) {
					numeric = newValue.replaceAll("[^\\d]", "");
					releaseYear.setText(numeric);
				}
				model.setReleaseYear(Integer.valueOf(numeric));
			}			
		});
		writer.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				model.setWriter(newValue);
			}			
		});
		ratingSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				ratingText.textProperty().setValue(Integer.toString(newValue.intValue()));
				model.setRating(newValue.intValue());
			}
		});		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		Singleton temp = (Singleton) o;
		movieTitle.textProperty().setValue(temp.getMovieTitle());
		director.textProperty().setValue(temp.getDirector());
		releaseYear.textProperty().setValue(Integer.toString(temp.getReleaseYear()));
		writer.textProperty().setValue(temp.getWriter());
		ratingText.textProperty().setValue(Integer.toString(temp.getRating()));
	}

}
