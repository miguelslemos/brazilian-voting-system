package lala

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton
import javax.inject.Inject



/**
 * Created by miguellemos on 23/10/17.
 */

/**
 * Provides methods to navigate to the different views in the application.
 */

@Singleton
class Navigator @Inject constructor(){

    lateinit var stage: Stage;

    public fun toStart(stage: Stage): Unit {
        this.stage = stage
        toSettings()
        show()
    }
    public fun toSettings() = replaceSceneContent("urna_settings.fxml")

    public fun toLoadElector() = replaceSceneContent("urna_step1.fxml")

    public fun toChooseCandidate() = replaceSceneContent("urna_step2.fxml")

    public fun toConfirmCandidate() = replaceSceneContent("urna_step3.fxml")

    public fun toEnd() = replaceSceneContent("urna_step4.fxml")


    @Throws(Exception::class)
    private fun replaceSceneContent(@NotNull fxml: String): Parent {
        val page = FXMLLoader.load<Parent>(javaClass.classLoader.getResource(fxml))
//        var scene: Scene = stage.getScene()
        //        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("urna_step3.fxml"));
        //        Scene frame = new Scene(root);
        //        primaryStage.show();
        //        primaryStage.setTitle("Urna eletrônica");
        //        primaryStage.setResizable(false);
        //        primaryStage.setScene(frame);
        //        primaryStage.centerOnScreen();
        //        primaryStage.show();
        var scene: Scene? = stage!!.scene
        //        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("urna_step3.fxml"));
        //        Scene frame = new Scene(root);
        //        primaryStage.show();
        //        primaryStage.setTitle("Urna eletrônica");
        //        primaryStage.setResizable(false);
        //        primaryStage.setScene(frame);
        //        primaryStage.centerOnScreen();
        //        primaryStage.show();
        if (scene == null) {
            scene = Scene(page, 1280.0, 640.0)
            //            scene.getStylesheets().add(getClass().getClassLoader().getResource("demo.css").toExternalForm());
            stage!!.scene = scene
        } else {
            stage!!.scene.root = page
        }
        stage!!.sizeToScene()
        return page
    }

    private fun show() = stage.show();
}