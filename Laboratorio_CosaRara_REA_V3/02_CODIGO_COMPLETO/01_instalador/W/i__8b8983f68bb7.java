// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
