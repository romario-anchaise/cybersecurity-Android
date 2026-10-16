// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1660a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f1661b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1662c = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void b() {
    }
}
