// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class o extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOException f2168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f2169b;

    public o(IOException iOException) {
        super(iOException);
        this.f2168a = iOException;
        this.f2169b = iOException;
    }
}
