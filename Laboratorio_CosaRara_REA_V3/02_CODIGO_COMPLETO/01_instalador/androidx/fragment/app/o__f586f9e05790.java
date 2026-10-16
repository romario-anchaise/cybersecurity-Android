// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f1566a;

    public o(r rVar) {
        this.f1566a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1566a.e(true);
    }
}
