// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p030q0;

import java.sql.Timestamp;
import java.util.Date;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public final class d extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4021b = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f4022a;

    public d(y yVar) {
        this.f4022a = yVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) {
        Date date = (Date) this.f4022a.a(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) {
        this.f4022a.b(bVar, (Timestamp) obj);
    }
}
