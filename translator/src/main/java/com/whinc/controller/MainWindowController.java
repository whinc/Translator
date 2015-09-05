package com.whinc.controller;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Created by whinc on 2015/9/4.
 * E-mail: xiaohui_hubei@163.com
 */
public class MainWindowController {
    @FXML
    public TabPane tabPane;

    @FXML
    private void initialize() throws IOException {
        URL resource;

        resource = getClass().getResource("/fxml/Translate.fxml");
        Tab translateTab = new Tab("Translate", FXMLLoader.<Node>load(resource));
        translateTab.setClosable(false);

        resource = getClass().getResource("/fxml/Word.fxml");
        FXMLLoader wordFxmlLoader = new FXMLLoader(resource);
        Tab wordTab = new Tab("Query Word", wordFxmlLoader.<Node>load());
        wordTab.setClosable(false);
        WordController wordController = wordFxmlLoader.<WordController>getController();
        wordController.resizeNode(tabPane);

        tabPane.getTabs().addAll(translateTab, wordTab);
    }
}
