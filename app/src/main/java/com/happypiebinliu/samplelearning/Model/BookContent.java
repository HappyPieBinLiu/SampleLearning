package com.happypiebinliu.samplelearning.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ope001 on 2016/12/13.
 */

public class BookContent {

    public static class Book{
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    // List
    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
    // 使用静态初始化代码，将book对象加载到list

    private static void addItem(Book book){
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }
    static {
        addItem(new Book(1, "三位一体001", "科幻小说001"));
        addItem(new Book(2, "三位一体002", "科幻小说002"));
        addItem(new Book(3, "三位一体003", "科幻小说003"));
    }

}
