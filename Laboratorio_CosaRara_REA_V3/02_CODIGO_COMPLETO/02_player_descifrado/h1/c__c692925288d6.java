// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h1;

import java.io.Serializable;
import q1.f;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f1948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Object f1949d = e.f1952b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f1950e = this;

    /* JADX WARN: Multi-variable type inference failed */
    public c(p1.a aVar) {
        this.f1948c = (f) aVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, p1.a, q1.f] */
    public final Object a() {
        Object objD;
        Object obj = this.f1949d;
        e eVar = e.f1952b;
        if (obj != eVar) {
            return obj;
        }
        synchronized (this.f1950e) {
            objD = this.f1949d;
            if (objD == eVar) {
                ?? r1 = this.f1948c;
                r1.getClass();
                objD = r1.d();
                this.f1949d = objD;
                this.f1948c = null;
            }
        }
        return objD;
    }

    public final String toString() {
        return this.f1949d != e.f1952b ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
