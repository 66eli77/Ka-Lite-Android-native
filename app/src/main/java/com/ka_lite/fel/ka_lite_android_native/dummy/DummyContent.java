package com.ka_lite.fel.ka_lite_android_native.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import android.os.Environment;
import android.graphics.Color;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
    private File root;
    private ArrayList<File> fileList = new ArrayList<File>();
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //constructor
    public DummyContent(){
        //getting SDcard root path
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
        getfile(root);

        if(fileList.size() > 0) {
            System.out.println("eliii > 0");
        }
        else {
            System.out.println("eliii == 0");
        }

        for (int i = 0; i < fileList.size(); i++) {

            if (fileList.get(i).isDirectory()) {
                DummyItem item = new DummyItem(i + "", "folder " + fileList.get(i).getName());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            }else{
                //addItem(new DummyItem(i + "", fileList.get(i).getName()));
                DummyItem item = new DummyItem(i + "", fileList.get(i).getName());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            }

            System.out.println(fileList.get(i).getName());
        }
    }

    public ArrayList<File> getfile(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    fileList.add(listFile[i]);
                    getfile(listFile[i]);

                } else {
                    if (listFile[i].getName().endsWith(".png")
                            || listFile[i].getName().endsWith(".jpg")
                            || listFile[i].getName().endsWith(".jpeg")
                            || listFile[i].getName().endsWith(".gif"))

                    {
                        fileList.add(listFile[i]);
                    }
                }

            }
        }
        return fileList;
    }

//    static {
//        // Add 3 sample items.
//        addItem(new DummyItem("1", "Item 1"));
//        addItem(new DummyItem("2", "Item 2"));
//        addItem(new DummyItem("3", "Item 3"));
//    }
//
//    public static void addItem(DummyItem item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
