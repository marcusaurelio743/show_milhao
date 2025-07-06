package br.com.showmilhao.application;
	
import br.com.showmilhao.util.LogUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	private static final String FILE_MUSIC = "src/main/resources/sons/som-abertura-2.mp3";
	@Override
	public void start(Stage primaryStage) {
		
		try {
			primaryStage.setTitle("Janela inicial java FX 123");
			
			LogUtil.getLogger(Main.class).info(primaryStage.getTitle());
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			ContinuousReprodution reproducao = new ContinuousReprodution(FILE_MUSIC,Boolean.TRUE);
			reproducao.start();
			
		//	JLayer jLayer = new JLayer();
		//	File mp3 = new File("src/main/resources/sons/tire-a-carta-do-baralho-voice.mp3");
			
		//	jLayer.tocar(mp3);
		//	jLayer.start();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
