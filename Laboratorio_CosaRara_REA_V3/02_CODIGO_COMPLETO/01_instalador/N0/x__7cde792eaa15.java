// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0241x extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() != 9) {
            return Float.valueOf((float) aVar.A());
        }
        aVar.F();
        return null;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            bVar.w();
            return;
        }
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(numberValueOf.floatValue());
        }
        bVar.C(numberValueOf);
    }
}
