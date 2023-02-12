package wordEditor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class WordEditorFXMLController {

	@FXML
	private TextArea editor;
	Stage meineStage;

	@FXML
	protected void beenden(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	protected void ladenKlick(ActionEvent event) {

		FileChooser oeffnenDialog = new FileChooser();
		oeffnenDialog.setTitle("Datei öffnen");
		oeffnenDialog.getExtensionFilters().add(new ExtensionFilter("Text Dateien", "*.txt"));

		oeffnenDialog.setInitialDirectory(new File(System.getProperty("user.home")));
		File datei = oeffnenDialog.showOpenDialog(null);
		if (datei != null)
			editor.setText(datenLesen(datei));

	}

	private String datenLesen(File dateiLesen) {

		int zeichen = 0;
		StringBuilder text = new StringBuilder();
		try (FileReader tempDatei = new FileReader(dateiLesen)) {
			zeichen = tempDatei.read();
			while (zeichen != -1) {
				text.append((char) zeichen);
				zeichen = tempDatei.read();
			}
		} catch (IOException e) {
			System.out.println("Beim Laden is ein Problem aufgetreffen");
		}

		return (text.toString());
	}

	@FXML
	protected void speichernKlick(ActionEvent event) {
		Alert myDialog = new Alert(AlertType.WARNING, "Die Daten werden geloscht");
		myDialog.setHeaderText("Bitte beachten");
		myDialog.showAndWait();
		FileChooser speicherDialog = new FileChooser();
		speicherDialog.setTitle("Detei speichern");
		speicherDialog.getExtensionFilters().add(new ExtensionFilter("Text dateien", "*.txt"));

		File datei = speicherDialog.showSaveDialog(null);
		if (datei != null) {
			datenSchreiben(datei);
		}

	}

	private void datenSchreiben(File dateiSchreiben) {
		try (FileWriter tempDatei = new FileWriter(dateiSchreiben)) {
			tempDatei.write(editor.getText());
		} catch (Exception e) {
			System.out.println("Beim Speichern ist ein Problem aufgetretten");
		}
	}

	@FXML
	protected void neuKlick(ActionEvent event) {
		editor.clear();
	}

	public void setMeinStage(Stage meineStage) {
		this.meineStage = meineStage;
	}
	
	@FXML 
	protected void cutKlick(ActionEvent event){
		
		editor.cut();
	}
	@FXML
	protected void copyKlick(ActionEvent event) {
		
		editor.copy();
	}
	@FXML
	protected void pasteKlick(ActionEvent event) {
		
		editor.paste();
	}

}
