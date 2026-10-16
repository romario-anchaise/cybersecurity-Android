// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static boolean a(ListView listView, int i2) {
        return listView.canScrollList(i2);
    }

    public static void b(ListView listView, int i2) {
        listView.scrollListBy(i2);
    }
}
