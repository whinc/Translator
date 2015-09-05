package com.whinc.net;

import com.alibaba.fastjson.JSON;
import com.whinc.model.Data;
import com.whinc.model.Part;
import com.whinc.model.Symbol;
import com.whinc.model.Word;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by whinc on 2015/8/23.
 * E-mail: xiaohui_hubei@163.com
 */
public class MainWindowTest {
    @Test
    public void testExecute() throws Exception {
//        Part part = new Part();
//        part.setMeans(Arrays.asList("否定句", "代替动词", "加强语气"));
//        part.setPart("aux.");
//        Symbol symbol = new Symbol();
//        symbol.setParts(Arrays.asList(part));
//        symbol.setPh_am("du");
//        symbol.setPh_en("du:");
//        Data data = new Data();
//        data.setSymbols(Arrays.asList(symbol));
//        data.setWord_name("do");
//        Word word = new Word();
//        word.setData(data);
//        word.setErrno(0);
//        word.setFrom("en");
//        word.setTo("zh");
//        String s = JSON.toJSONString(word);
//        System.out.println(s);

        InputStream is = getClass().getResourceAsStream("/word.json");
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        System.out.println(builder);
        Word word = JSON.parseObject(builder.toString(), Word.class);
        System.out.println(word);
    }
}