// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import H.s;
import java.util.concurrent.ConcurrentHashMap;
import p018k0.k;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p022m0.d;
import p032r0.a;

/* JADX INFO: renamed from: n0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0227i implements z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0226h f3925c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f3926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3927b = new ConcurrentHashMap();

    static {
        int i2 = 0;
        f3925c = new C0226h(i2);
        new C0226h(i2);
    }

    public C0227i(s sVar) {
        this.f3926a = sVar;
    }

    public final y a(s sVar, m mVar, a aVar, p020l0.a aVar2, boolean z2) {
        y yVarB;
        z zVar;
        Object objO = sVar.t(new a(aVar2.value())).o();
        boolean zNullSafe = aVar2.nullSafe();
        if (objO instanceof y) {
            yVarB = (y) objO;
        } else {
            if (!(objO instanceof z)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objO.getClass().getName() + " as a @JsonAdapter for " + d.k(aVar.f4030b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            z zVar2 = (z) objO;
            if (z2 && (zVar = (z) this.f3927b.putIfAbsent(aVar.f4029a, zVar2)) != null) {
                zVar2 = zVar;
            }
            yVarB = zVar2.b(mVar, aVar);
        }
        return (yVarB == null || !zNullSafe) ? yVarB : new k(yVarB, 2);
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        p020l0.a aVar2 = (p020l0.a) aVar.f4029a.getAnnotation(p020l0.a.class);
        if (aVar2 == null) {
            return null;
        }
        return a(this.f3926a, mVar, aVar, aVar2, true);
    }
}
