package com.whinc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpUtils;
import com.whinc.utils.BaiduTranslator;
import com.whinc.utils.Translator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

/**
 * Created by whinc on 2015/8/20.
 * E-mail: xiaohui_hubei@163.com
 */
public class MainWindowController {

    @FXML
    private TextArea sourceTxtArea;

    @FXML
    private TextArea targetTxtArea;

    @FXML
    private Button translateBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    public void clear() {
        sourceTxtArea.clear();
        targetTxtArea.clear();
    }

    @FXML
    public void translate() {
        String source = sourceTxtArea.getText();
        Translator translator = new BaiduTranslator();
        String target = translator.translate("auto", "auto", source);
        targetTxtArea.setText(target);
    }
}
