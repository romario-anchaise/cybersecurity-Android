// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
        return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
    }
}
