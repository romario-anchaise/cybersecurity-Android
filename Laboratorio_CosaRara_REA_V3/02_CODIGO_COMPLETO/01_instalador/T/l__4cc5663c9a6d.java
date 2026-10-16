// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static ParcelFileDescriptor a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
    }
}
