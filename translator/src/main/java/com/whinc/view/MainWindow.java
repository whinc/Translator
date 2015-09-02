package com.whinc.view;

import java.net.URL;

import javax.naming.Binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by whinc on 2015/8/18.
 * E-mail: xiaohui_hubei@163.com
 */
public class MainWindow extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        URL mainFxml = getClass().getResource("/fxml/main.fxml");
        FXMLLoader mainFxmlLoader = new FXMLLoader(mainFxml);
        Parent root = mainFxmlLoader.<Parent>load();

        TabPane tabPane = (TabPane) root.lookup("#tabPanel");
        Tab translateTab = new Tab("Translate", FXMLLoader.load(getClass().getResource("/fxml/translate.fxml")));
        translateTab.setClosable(false);
        Tab wordTab = new Tab("Word", FXMLLoader.load(getClass().getResource("/fxml/word.fxml")));
        TextField input = (TextField)wordTab.getContent().lookup("#textField");
        Button queryBtn = (Button) wordTab.getContent().lookup("#queryBtn");
        input.minWidthProperty().bind(tabPane.widthProperty()
                .subtract(queryBtn.minWidthProperty())
                .subtract(30)
        );
        wordTab.setClosable(false);
        tabPane.getTabs().addAll(translateTab, wordTab);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(MainWindow.class, args);
    }
}
