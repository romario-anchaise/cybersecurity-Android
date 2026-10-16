// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends y {
    @Override // p018k0.y
    public final Object a(a aVar) {
        return new AtomicBoolean(aVar.z());
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        bVar.E(((AtomicBoolean) obj).get());
    }
}
