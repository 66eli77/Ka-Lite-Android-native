package com.ka_lite.fel.ka_lite_android_native.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import android.os.Environment;

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
    public DummyContent() {
        //getting SDcard root path
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
        getfile(root);

        for (int i = 0; i < fileList.size(); i++) {

            if (fileList.get(i).isDirectory()) {
                DummyItem item = new DummyItem(i + "", "folder " + fileList.get(i).getName(), fileList.get(i).getPath());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            }else{
                //addItem(new DummyItem(i + "", fileList.get(i).getName()));
                DummyItem item = new DummyItem(i + "", fileList.get(i).getName(), fileList.get(i).getPath());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            }
        }
    }

    private boolean found = false;
    private String CONTENTLOAD_ROOT = "CONTENTLOAD_ROOT";
    public ArrayList<File> getfile(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    //    fileList.add(listFile[i]);
                    //getfile(listFile[i]);
                    if(!listFile[i].getName().equals(CONTENTLOAD_ROOT)) {
                        System.out.println("nono found");
                        getfile(listFile[i]);
                        //found = true;
                    }else{
                        System.out.println("elieli found");
                        File targetFile[] = listFile[i].listFiles();
                        for(int j =0; j < targetFile.length; j++){
                            fileList.add(targetFile[j]);
                        }
                    }
                }

//              } else {
//                    if (listFile[i].getName().endsWith(".png")
//                            || listFile[i].getName().endsWith(".jpg")
//                            || listFile[i].getName().endsWith(".jpeg")
//                            || listFile[i].getName().endsWith(".gif"))
//
//                    {
//                        fileList.add(listFile[i]);
//                    }

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
        public String path;

        public DummyItem(String id, String content, String path) {
            this.id = id;
            this.content = content;
            this.path = path;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
