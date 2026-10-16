// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C;

import android.view.inputmethod.EditorInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }
}
