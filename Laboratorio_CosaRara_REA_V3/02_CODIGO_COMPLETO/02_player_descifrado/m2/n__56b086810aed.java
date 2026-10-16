// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends RuntimeException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IOException f2756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IOException f2757d;

    public n(IOException iOException) {
        super(iOException);
        this.f2756c = iOException;
        this.f2757d = iOException;
    }
}
