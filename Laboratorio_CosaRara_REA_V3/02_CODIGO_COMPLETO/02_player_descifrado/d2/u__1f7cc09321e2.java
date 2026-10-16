// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.se;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataOutputStream f616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final se f617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f619e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f620f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v f621g;

    public u(v vVar, InputStream inputStream, OutputStream outputStream, se seVar, Set set) {
        this.f621g = vVar;
        this.f615a = inputStream;
        this.f616b = new DataOutputStream(outputStream);
        this.f617c = seVar;
        this.f618d = set;
    }

    public final void a() {
        if (this.f620f.compareAndSet(false, true)) {
            this.f618d.remove(this);
            se seVar = this.f617c;
            if (seVar == null) {
                return;
            }
            try {
                seVar.run();
            } catch (RuntimeException unused) {
            }
        }
    }
}
