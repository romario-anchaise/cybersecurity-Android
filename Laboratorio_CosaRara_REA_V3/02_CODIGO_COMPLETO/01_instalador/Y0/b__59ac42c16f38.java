// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p044y0;

import p040w0.d;
import p040w0.i;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4196a = new b();

    @Override // p040w0.d
    public final void b(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // p040w0.d
    public final i g() {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
