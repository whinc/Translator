package com.whinc.controller;

import com.whinc.utils.BaiduTranslator;
import com.whinc.utils.Direction;
import com.whinc.utils.Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.util.Pair;

/**
 * Created by whinc on 2015/8/20.
 * E-mail: xiaohui_hubei@163.com
 */
public class MainWindowController{
    @FXML public ProgressIndicator loadingBar;
    @FXML private TextArea sourceTxtArea;
    @FXML private TextArea targetTxtArea;
    @FXML private Button translateBtn;
    @FXML private Button clearBtn;
    @FXML private ComboBox<Pair<Direction, Direction>> mDirectionCbx;

    @FXML
    public void clear() {
        sourceTxtArea.clear();
        targetTxtArea.clear();
    }

    @FXML
    public void translate() {
        String source = sourceTxtArea.getText();
        if (source == null || source.isEmpty()) {
            return;
        }
        Translator translator = new BaiduTranslator();
        Pair<Direction, Direction> select = mDirectionCbx.getValue();
        loadingBar.setVisible(true);
        String target = translator.translate(select.getKey(), select.getValue(), source);
        if (target != null && !target.isEmpty()) {
            targetTxtArea.setText(target);
        }
        loadingBar.setVisible(false);
    }

    private ListCell<Pair<Direction, Direction>> createListCell() {
        return new ListCell<Pair<Direction, Direction>>() {
            @Override
            protected void updateItem(Pair<Direction, Direction> item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    if (item.getKey() == item.getValue() && item.getKey() == Direction.AUTO) {
                        setText(Direction.AUTO.getLang());
                    } else {
                        setText(String.format("%s->%s", item.getKey().getLang(), item.getValue().getLang()));
                    }
                } else {
                    setText(null);
                }
            }
        };
    }

    @FXML
    private void initialize() {
        mDirectionCbx.setCellFactory(param -> createListCell());
        mDirectionCbx.setButtonCell(createListCell());

        List<Pair<Direction, Direction>> data = new ArrayList<>();
        data.add(new Pair<>(Direction.AUTO, Direction.AUTO));
        data.add(new Pair<>(Direction.ZH, Direction.EN));
        data.add(new Pair<>(Direction.EN, Direction.ZH));
        data.add(new Pair<>(Direction.ZH, Direction.KOR));
        data.add(new Pair<>(Direction.ZH, Direction.JP));
        data.add(new Pair<>(Direction.ZH, Direction.WYW));
        mDirectionCbx.getItems().addAll(data);
        mDirectionCbx.setValue(data.get(0));
    }
}
