// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p024n0.C0227i;
import p032r0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public final class g extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile y f3703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f3706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f3707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f3708f;

    public g(h hVar, boolean z2, boolean z3, m mVar, a aVar) {
        this.f3708f = hVar;
        this.f3704b = z2;
        this.f3705c = z3;
        this.f3706d = mVar;
        this.f3707e = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    @Override // p018k0.y
    public final Object a(s0.a aVar) throws IOException {
        if (this.f3704b) {
            aVar.P();
            return null;
        }
        y yVarB = this.f3703a;
        if (yVarB == null) {
            m mVar = this.f3706d;
            z zVar = this.f3708f;
            a aVar2 = this.f3707e;
            mVar.getClass();
            Objects.requireNonNull(zVar, "skipPast must not be null");
            C0227i c0227i = mVar.f3422d;
            c0227i.getClass();
            if (zVar == C0227i.f3925c) {
                zVar = c0227i;
            } else {
                ConcurrentHashMap concurrentHashMap = c0227i.f3927b;
                Class cls = aVar2.f4029a;
                z zVar2 = (z) concurrentHashMap.get(cls);
                if (zVar2 == null) {
                    p020l0.a aVar3 = (p020l0.a) cls.getAnnotation(p020l0.a.class);
                    if (aVar3 != null) {
                        Class clsValue = aVar3.value();
                        if (z.class.isAssignableFrom(clsValue)) {
                            z zVar3 = (z) c0227i.f3926a.t(new a(clsValue)).o();
                            z zVar4 = (z) concurrentHashMap.putIfAbsent(cls, zVar3);
                            if (zVar4 != null) {
                                zVar3 = zVar4;
                            }
                            if (zVar3 == zVar) {
                                zVar = c0227i;
                            }
                        }
                    }
                } else if (zVar2 == zVar) {
                    zVar = c0227i;
                }
            }
            Iterator it = mVar.f3423e.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    if (!z2) {
                        yVarB = mVar.b(aVar2);
                        break;
                    }
                    throw new IllegalArgumentException("GSON cannot serialize or deserialize " + aVar2);
                }
                z zVar5 = (z) it.next();
                if (z2) {
                    y yVarB2 = zVar5.b(mVar, aVar2);
                    if (yVarB2 != null) {
                        yVarB = yVarB2;
                        break;
                    }
                } else if (zVar5 == zVar) {
                    z2 = true;
                }
            }
            this.f3703a = yVarB;
        }
        return yVarB.a(aVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        if (this.f3705c) {
            bVar.w();
            return;
        }
        y yVarB = this.f3703a;
        if (yVarB == null) {
            m mVar = this.f3706d;
            z zVar = this.f3708f;
            a aVar = this.f3707e;
            mVar.getClass();
            Objects.requireNonNull(zVar, "skipPast must not be null");
            C0227i c0227i = mVar.f3422d;
            c0227i.getClass();
            if (zVar == C0227i.f3925c) {
                zVar = c0227i;
            } else {
                ConcurrentHashMap concurrentHashMap = c0227i.f3927b;
                Class cls = aVar.f4029a;
                z zVar2 = (z) concurrentHashMap.get(cls);
                if (zVar2 == null) {
                    p020l0.a aVar2 = (p020l0.a) cls.getAnnotation(p020l0.a.class);
                    if (aVar2 != null) {
                        Class clsValue = aVar2.value();
                        if (z.class.isAssignableFrom(clsValue)) {
                            z zVar3 = (z) c0227i.f3926a.t(new a(clsValue)).o();
                            z zVar4 = (z) concurrentHashMap.putIfAbsent(cls, zVar3);
                            if (zVar4 != null) {
                                zVar3 = zVar4;
                            }
                            if (zVar3 == zVar) {
                                zVar = c0227i;
                            }
                        }
                    }
                } else if (zVar2 == zVar) {
                    zVar = c0227i;
                }
            }
            Iterator it = mVar.f3423e.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    if (!z2) {
                        yVarB = mVar.b(aVar);
                        break;
                    } else {
                        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + aVar);
                    }
                }
                z zVar5 = (z) it.next();
                if (z2) {
                    y yVarB2 = zVar5.b(mVar, aVar);
                    if (yVarB2 != null) {
                        yVarB = yVarB2;
                        break;
                    }
                } else if (zVar5 == zVar) {
                    z2 = true;
                }
            }
            this.f3703a = yVarB;
        }
        yVarB.b(bVar, obj);
    }
}
