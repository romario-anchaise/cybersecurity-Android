// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements K0.a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient K0.a f165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f170f;

    public c(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f166b = obj;
        this.f167c = cls;
        this.f168d = str;
        this.f169e = str2;
        this.f170f = z2;
    }

    public final d b() {
        Class cls = this.f167c;
        if (this.f170f) {
            o.f181a.getClass();
            return new k(cls);
        }
        o.f181a.getClass();
        return new e(cls);
    }
}
