// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p025o;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3970c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CancellationException f3971a;

    static {
        if (g.f3981d) {
            f3970c = null;
            f3969b = null;
        } else {
            f3970c = new a(false, null);
            f3969b = new a(true, null);
        }
    }

    public a(boolean z2, CancellationException cancellationException) {
        this.f3971a = cancellationException;
    }
}
