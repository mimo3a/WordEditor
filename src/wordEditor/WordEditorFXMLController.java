package wordEditor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class WordEditorFXMLController {
	
	@FXML private TextArea editor;

	@FXML
	protected void beenden(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	protected void neuKlick(ActionEvent event) {
		
		editor.setText("Load new file");

	}

}
