// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w;

import android.content.Context;
import java.util.LinkedHashSet;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f3364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f3365e;

    public e(Context context, r rVar) {
        this.f3361a = rVar;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.f3362b = applicationContext;
        this.f3363c = new Object();
        this.f3364d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(v.b bVar) {
        bVar.getClass();
        synchronized (this.f3363c) {
            if (this.f3364d.remove(bVar) && this.f3364d.isEmpty()) {
                e();
            }
        }
    }

    public final void c(Object obj) {
        synchronized (this.f3363c) {
            Object obj2 = this.f3365e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.f3365e = obj;
                ((b0.a) this.f3361a.f6034c).execute(new a2.h(i1.i.E(this.f3364d), this, 12));
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
