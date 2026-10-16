// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.util.Date;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: renamed from: n0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0223e implements z {
    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        if (aVar.f4029a == Date.class) {
            return new C0225g();
        }
        return null;
    }

    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}
