// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i2) {
        return callback.onWindowStartingActionMode(callback2, i2);
    }
}
