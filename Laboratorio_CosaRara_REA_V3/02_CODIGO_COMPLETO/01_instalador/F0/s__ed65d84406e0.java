// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import N0.AbstractC0049v;
import N0.C;
import N0.C0052y;
import N0.J;
import N0.S;
import R0.o;
import T0.d;
import V.k;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0082u;
import java.util.concurrent.CancellationException;
import p012h0.a;
import p016j0.f;

/* JADX INFO: loaded from: classes.dex */
public final class s implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f2691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0078p f2694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final S f2695e;

    public s(k kVar, i iVar, a aVar, AbstractC0078p abstractC0078p, S s2) {
        this.f2691a = kVar;
        this.f2692b = iVar;
        this.f2693c = aVar;
        this.f2694d = abstractC0078p;
        this.f2695e = s2;
    }

    @Override // androidx.lifecycle.InterfaceC0067e
    public final void c(InterfaceC0082u interfaceC0082u) {
        u uVarC = f.c(this.f2693c.f2841b);
        synchronized (uVarC) {
            try {
                C0052y c0052y = uVarC.f2698b;
                if (c0052y != null) {
                    AbstractC0049v.a(c0052y);
                }
                J j2 = J.f393a;
                d dVar = C.f385a;
                uVarC.f2698b = AbstractC0049v.i(j2, o.f569a.f512f, new t(uVarC, null), 2);
                uVarC.f2697a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p010f0.p
    public final void d() {
        a aVar = this.f2693c;
        if (aVar.f2841b.isAttachedToWindow()) {
            return;
        }
        u uVarC = f.c(aVar.f2841b);
        s sVar = uVarC.f2699c;
        if (sVar != null) {
            AbstractC0049v.a(sVar.f2695e);
            AbstractC0078p abstractC0078p = sVar.f2694d;
            a aVar2 = sVar.f2693c;
            if (aVar2 != null) {
                abstractC0078p.c(aVar2);
            }
            abstractC0078p.c(sVar);
        }
        uVarC.f2699c = this;
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // p010f0.p
    public final void start() {
        AbstractC0078p abstractC0078p = this.f2694d;
        abstractC0078p.a(this);
        a aVar = this.f2693c;
        if (aVar != null) {
            abstractC0078p.c(aVar);
            abstractC0078p.a(aVar);
        }
        u uVarC = f.c(aVar.f2841b);
        s sVar = uVarC.f2699c;
        if (sVar != null) {
            AbstractC0049v.a(sVar.f2695e);
            AbstractC0078p abstractC0078p2 = sVar.f2694d;
            a aVar2 = sVar.f2693c;
            if (aVar2 != null) {
                abstractC0078p2.c(aVar2);
            }
            abstractC0078p2.c(sVar);
        }
        uVarC.f2699c = this;
    }
}
