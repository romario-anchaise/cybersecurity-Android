// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p030q0;

import java.sql.Timestamp;
import java.util.Date;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public class c implements z {
    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        if (aVar.f4029a != Timestamp.class) {
            return null;
        }
        mVar.getClass();
        return new d(mVar.b(new a(Date.class)));
    }
}
