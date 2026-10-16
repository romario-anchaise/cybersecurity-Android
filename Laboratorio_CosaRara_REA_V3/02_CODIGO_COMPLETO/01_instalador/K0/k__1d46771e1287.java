// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public final class k extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f3413b;

    public /* synthetic */ k(y yVar, int i2) {
        this.f3412a = i2;
        this.f3413b = yVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        switch (this.f3412a) {
            case 0:
                return new AtomicLong(((Number) this.f3413b.a(aVar)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.w()) {
                    arrayList.add(Long.valueOf(((Number) this.f3413b.a(aVar)).longValue()));
                }
                aVar.r();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            default:
                if (aVar.J() != 9) {
                    return this.f3413b.a(aVar);
                }
                aVar.F();
                return null;
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        switch (this.f3412a) {
            case 0:
                this.f3413b.b(bVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.f();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f3413b.b(bVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                bVar.r();
                break;
            default:
                if (obj == null) {
                    bVar.w();
                } else {
                    this.f3413b.b(bVar, obj);
                }
                break;
        }
    }
}
