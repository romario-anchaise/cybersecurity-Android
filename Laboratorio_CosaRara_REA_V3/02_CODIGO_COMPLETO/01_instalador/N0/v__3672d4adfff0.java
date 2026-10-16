// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0239v extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.w()) {
            try {
                arrayList.add(Integer.valueOf(aVar.B()));
            } catch (NumberFormatException e2) {
                throw new p(e2);
            }
        }
        aVar.r();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
        bVar.f();
        int length = atomicIntegerArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            bVar.B(atomicIntegerArray.get(i2));
        }
        bVar.r();
    }
}
