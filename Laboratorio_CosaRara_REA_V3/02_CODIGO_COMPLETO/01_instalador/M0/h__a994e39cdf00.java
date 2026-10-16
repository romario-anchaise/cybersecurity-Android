// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p028p0.d;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public final class h implements z, Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f3709c = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3710a = Collections.emptyList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3711b = Collections.emptyList();

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Class cls = aVar.f4029a;
        boolean zC = c(cls, true);
        boolean zC2 = c(cls, false);
        if (zC || zC2) {
            return new g(this, zC2, zC, mVar, aVar);
        }
        return null;
    }

    public final boolean c(Class cls, boolean z2) {
        if (!z2 && !Enum.class.isAssignableFrom(cls)) {
            p028p0.a aVar = d.f4001a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z2 ? this.f3710a : this.f3711b).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    public final Object clone() {
        try {
            return (h) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
