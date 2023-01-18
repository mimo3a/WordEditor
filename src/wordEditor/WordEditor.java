package wordEditor;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordEditor extends Application{

	@Override
	public void start(Stage myStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("editor.fxml"));
		Scene myScene = new Scene(root, 400,400);
		myStage.setTitle("Word FX Editor");
		myStage.setScene(myScene);
		myStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
