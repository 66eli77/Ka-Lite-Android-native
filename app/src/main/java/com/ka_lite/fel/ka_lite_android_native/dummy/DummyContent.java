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
        populateItemMap();

    }

    private void populateItemMap() {
        // getting SDcard root path
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());

        for (File f : root.listFiles()) {
            if (f.isDirectory()) {
                DummyItem item = new DummyItem("", "folder " + f.getName(), f.getPath());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            } else {
                //addItem(new DummyItem(i + "", fileList.get(i).getName()));
                DummyItem item = new DummyItem("", f.getName(), f.getPath());
                ITEMS.add(item);
                ITEM_MAP.put(item.id, item);
            }
        }
    }

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
