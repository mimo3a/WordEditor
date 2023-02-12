package wordEditor;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordEditor extends Application{

	@Override
	public void start(Stage myStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("editor.fxml"));
		
//		andere art 
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
		Parent root = meinLoader.load();
		
		WordEditorFXMLController meinController = meinLoader.getController();
		meinController.setMeinStage(myStage);
//				plus in class WordEditorFXMLController add noch ein method setMeinStage
		Scene myScene = new Scene(root, 400,400);
		myStage.setTitle("Word FX Editor");
		myStage.setScene(myScene);
		myStage.show();
		myStage.setMaximized(true);
//		myStage.setFullScreen(true);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
