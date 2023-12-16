package codefornature;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedNewsSection extends Application {

    private static final String[] SLIDES = {
            "Slide 1: This is the first slide.",
            "Slide 2: Another interesting slide.",
            "Slide 3: Here comes the third slide."
    };

    private int currentIndex = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2c3e50;"); // Dark background color

        Text slideText = new Text(SLIDES[0]);
        slideText.setFill(Color.WHITE);
        slideText.setStyle("-fx-font-size: 20;");

        root.getChildren().add(slideText);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), slideText);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(event -> {
            currentIndex = (currentIndex + 1) % SLIDES.length;
            slideText.setText(SLIDES[currentIndex]);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        });

        Scene scene = new Scene(root, 400, 300, Color.BLACK);

        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("CSS Slideshow Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        fadeTransition.play(); // Initial play
    }
}