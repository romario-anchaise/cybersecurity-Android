// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: N0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0038j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O f434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0.l f435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f437e;

    public C0038j(Object obj, O o2, E0.l lVar, Object obj2, Throwable th) {
        this.f433a = obj;
        this.f434b = o2;
        this.f435c = lVar;
        this.f436d = obj2;
        this.f437e = th;
    }

    public static C0038j a(C0038j c0038j, O o2, CancellationException cancellationException, int i2) {
        Object obj = c0038j.f433a;
        if ((i2 & 2) != 0) {
            o2 = c0038j.f434b;
        }
        O o3 = o2;
        E0.l lVar = c0038j.f435c;
        Object obj2 = c0038j.f436d;
        Throwable th = cancellationException;
        if ((i2 & 16) != 0) {
            th = c0038j.f437e;
        }
        c0038j.getClass();
        return new C0038j(obj, o3, lVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0038j)) {
            return false;
        }
        C0038j c0038j = (C0038j) obj;
        return F0.i.a(this.f433a, c0038j.f433a) && F0.i.a(this.f434b, c0038j.f434b) && F0.i.a(this.f435c, c0038j.f435c) && F0.i.a(this.f436d, c0038j.f436d) && F0.i.a(this.f437e, c0038j.f437e);
    }

    public final int hashCode() {
        Object obj = this.f433a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        O o2 = this.f434b;
        int iHashCode2 = (iHashCode + (o2 == null ? 0 : o2.hashCode())) * 31;
        E0.l lVar = this.f435c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f436d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f437e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f433a + ", cancelHandler=" + this.f434b + ", onCancellation=" + this.f435c + ", idempotentResume=" + this.f436d + ", cancelCause=" + this.f437e + ')';
    }

    public /* synthetic */ C0038j(Object obj, O o2, E0.l lVar, CancellationException cancellationException, int i2) {
        this(obj, (i2 & 2) != 0 ? null : o2, (i2 & 4) != 0 ? null : lVar, (Object) null, (i2 & 16) != 0 ? null : cancellationException);
    }
}
