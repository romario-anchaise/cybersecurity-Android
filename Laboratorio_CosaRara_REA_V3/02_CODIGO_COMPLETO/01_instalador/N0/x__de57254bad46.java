// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0051x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f464a = 0;

    static {
        String property;
        int i2 = R0.v.f576a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            RunnableC0050w runnableC0050w = RunnableC0050w.f462i;
            return;
        }
        T0.d dVar = C.f385a;
        O0.c cVar = R0.o.f569a;
        O0.c cVar2 = cVar.f512f;
        if (cVar instanceof InterfaceC0053z) {
            return;
        }
        RunnableC0050w runnableC0050w2 = RunnableC0050w.f462i;
    }
}
