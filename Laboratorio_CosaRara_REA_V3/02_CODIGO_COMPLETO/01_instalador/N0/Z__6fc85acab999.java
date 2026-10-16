// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class Z extends y {
    @Override // p018k0.y
    public final Object a(a aVar) {
        try {
            return new AtomicInteger(aVar.B());
        } catch (NumberFormatException e2) {
            throw new p(e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        bVar.B(((AtomicInteger) obj).get());
    }
}
