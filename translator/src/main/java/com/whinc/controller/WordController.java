package com.whinc.controller;

import com.whinc.model.Data;
import com.whinc.model.Part;
import com.whinc.model.Symbol;
import com.whinc.model.Word;
import com.whinc.utils.BaiduTranslator;
import com.whinc.utils.Translator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

/**
 * Created by whinc on 2015/9/4.
 * E-mail: xiaohui_hubei@163.com
 */
public class WordController {
    @FXML
    public Button queryBtn;
    @FXML
    public TextField wordTxtField;
    @FXML
    public VBox result;
    private Translator translator;
    // 缓存最近查询过的单词
    private Map<String, Word> mCache = new HashMap<>(10);

    @FXML
    private void initialize() {
        translator = new BaiduTranslator();
    }

    @FXML
    public void query() {
        String text = this.wordTxtField.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        Word word = mCache.get(text);
        try {
            queryBtn.setDisable(true);
            if (word == null) {
                word = translator.queryWord(text);
                if (word.getErrno() != 0) {
                    // occur error
                    result.getChildren().clear();
                    return;
                }
                mCache.put(text, word);
            }
            show(word);
        } catch (Exception e) {
            e.printStackTrace();
            result.getChildren().clear();
            return;
        } finally {
            queryBtn.setDisable(false);
        }
    }

    public void resizeNode(TabPane tabPane) {
        wordTxtField.prefWidthProperty().bind(tabPane.prefWidthProperty()
                .subtract(queryBtn.prefWidthProperty()).subtract(30));
    }

    private void show(Word word) {
        result.getChildren().clear();
        Data data = word.getData();
        for (Symbol symbol : data.getSymbols()) {
            StringBuilder builder = new StringBuilder();
            String ph_am = symbol.getPh_am();
            String ph_en = symbol.getPh_en();
            List<Part> parts = symbol.getParts();
            builder.append(String.format("美：[%s] 英：[%s]\n", ph_am, ph_en));
            for (Part part : parts) {
                String partName = part.getPart();
                List<String> means = part.getMeans();
                builder.append(partName).append("\n");
                for (String mean : means) {
                    builder.append("    ").append(mean).append("\n");
                }
            }
            Text text = createText(builder.toString());
            result.getChildren().add(text);
        }
    }

    private Text createText(String s) {
        Text text = new Text(s);
        text.setLineSpacing(5.0);
        text.wrappingWidthProperty().bind(wordTxtField.widthProperty().add(queryBtn.widthProperty()));
        text.setFont(Font.font("consolas", 15));
        return text;
    }
}
