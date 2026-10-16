// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f605d;

    public /* synthetic */ p(u uVar, int i3) {
        this.f604c = i3;
        this.f605d = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f604c;
        u uVar = this.f605d;
        switch (i3) {
            case 0:
                uVar.a();
                return;
        }
        while (!uVar.f620f.get()) {
            try {
                m mVarA = n.a(uVar.f615a);
                synchronized (uVar.f619e) {
                    uVar.f621g.c(mVarA.f599a, mVarA.f600b, uVar.f616b);
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                uVar.a();
                throw th;
            }
        }
        uVar.a();
    }
}
