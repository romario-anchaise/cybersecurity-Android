// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3049a;

    public /* synthetic */ n(Context context) {
        this.f3049a = context;
    }

    @Override // j.c
    public j.d a(j.b bVar) {
        String str = (String) bVar.f2305d;
        g.j jVar = (g.j) bVar.f2306e;
        jVar.getClass();
        if (str != null && str.length() != 0) {
            return new k.g(this.f3049a, str, jVar, true, true);
        }
        o2.i("Must set a non-null database name to a configuration that uses the no backup directory.");
        return null;
    }
}
