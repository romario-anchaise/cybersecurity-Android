// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.inputmethod.EditorInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f105a = new String[0];

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }
}
