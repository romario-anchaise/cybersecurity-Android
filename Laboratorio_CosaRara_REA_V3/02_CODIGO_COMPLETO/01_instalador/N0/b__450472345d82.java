// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import p018k0.m;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0220b extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0219a f3885c = new C0219a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0238u f3887b;

    public C0220b(m mVar, y yVar, Class cls) {
        this.f3887b = new C0238u(mVar, yVar, cls);
        this.f3886a = cls;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.w()) {
            arrayList.add(((y) this.f3887b.f3963c).a(aVar));
        }
        aVar.r();
        int size = arrayList.size();
        Class cls = this.f3886a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.w();
            return;
        }
        bVar.f();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f3887b.b(bVar, Array.get(obj, i2));
        }
        bVar.r();
    }
}
