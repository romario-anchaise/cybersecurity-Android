// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: m1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0206j extends CompletableFuture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f3842a;

    public C0206j(y yVar) {
        this.f3842a = yVar;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        if (z2) {
            this.f3842a.cancel();
        }
        return super.cancel(z2);
    }
}
