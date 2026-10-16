// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f5806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f5807g;

    public s(byte[] bArr, int i3, int i4, boolean z2, boolean z3) {
        bArr.getClass();
        this.f5801a = bArr;
        this.f5802b = i3;
        this.f5803c = i4;
        this.f5804d = z2;
        this.f5805e = z3;
    }

    public final s a() {
        s sVar = this.f5806f;
        if (sVar == this) {
            sVar = null;
        }
        s sVar2 = this.f5807g;
        sVar2.getClass();
        sVar2.f5806f = this.f5806f;
        s sVar3 = this.f5806f;
        sVar3.getClass();
        sVar3.f5807g = this.f5807g;
        this.f5806f = null;
        this.f5807g = null;
        return sVar;
    }

    public final void b(s sVar) {
        sVar.getClass();
        sVar.f5807g = this;
        sVar.f5806f = this.f5806f;
        s sVar2 = this.f5806f;
        sVar2.getClass();
        sVar2.f5807g = sVar;
        this.f5806f = sVar;
    }

    public final s c() {
        this.f5804d = true;
        return new s(this.f5801a, this.f5802b, this.f5803c, true, false);
    }

    public final void d(s sVar, int i3) {
        sVar.getClass();
        byte[] bArr = sVar.f5801a;
        if (!sVar.f5805e) {
            o2.k("only owner can write");
            return;
        }
        int i4 = sVar.f5803c;
        int i5 = i4 + i3;
        if (i5 > 8192) {
            if (sVar.f5804d) {
                throw new IllegalArgumentException();
            }
            int i6 = sVar.f5802b;
            if (i5 - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            i1.h.s(bArr, bArr, 0, i6, i4);
            sVar.f5803c -= sVar.f5802b;
            sVar.f5802b = 0;
        }
        int i7 = sVar.f5803c;
        int i8 = this.f5802b;
        i1.h.s(this.f5801a, bArr, i7, i8, i8 + i3);
        sVar.f5803c += i3;
        this.f5802b += i3;
    }

    public s() {
        this.f5801a = new byte[8192];
        this.f5805e = true;
        this.f5804d = false;
    }
}
