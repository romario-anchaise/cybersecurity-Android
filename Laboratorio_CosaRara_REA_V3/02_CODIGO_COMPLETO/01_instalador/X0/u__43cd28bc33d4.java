// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.List;
import java.util.regex.Pattern;
import k1.C0193i;
import k1.C0196l;
import k1.InterfaceC0194j;

/* JADX INFO: loaded from: classes.dex */
public final class u extends B {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s f1037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s f1038f;
    public static final byte[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f1039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f1040i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0196l f1041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f1043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1044d;

    static {
        Pattern pattern = s.f1030d;
        f1037e = f1.d.q("multipart/mixed");
        f1.d.q("multipart/alternative");
        f1.d.q("multipart/digest");
        f1.d.q("multipart/parallel");
        f1038f = f1.d.q("multipart/form-data");
        g = new byte[]{58, 32};
        f1039h = new byte[]{13, 10};
        f1040i = new byte[]{45, 45};
    }

    public u(C0196l c0196l, s sVar, List list) {
        F0.i.e(c0196l, "boundaryByteString");
        F0.i.e(sVar, "type");
        this.f1041a = c0196l;
        this.f1042b = list;
        Pattern pattern = s.f1030d;
        this.f1043c = f1.d.q(sVar + "; boundary=" + c0196l.p());
        this.f1044d = -1L;
    }

    @Override // X0.B
    public final long a() {
        long j2 = this.f1044d;
        if (j2 != -1) {
            return j2;
        }
        long jD = d(null, true);
        this.f1044d = jD;
        return jD;
    }

    @Override // X0.B
    public final s b() {
        return this.f1043c;
    }

    @Override // X0.B
    public final void c(InterfaceC0194j interfaceC0194j) {
        d(interfaceC0194j, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long d(InterfaceC0194j interfaceC0194j, boolean z2) {
        C0193i c0193i;
        InterfaceC0194j c0193i2;
        if (z2) {
            c0193i2 = new C0193i();
            c0193i = c0193i2;
        } else {
            c0193i = 0;
            c0193i2 = interfaceC0194j;
        }
        List list = this.f1042b;
        int size = list.size();
        long j2 = 0;
        int i2 = 0;
        while (true) {
            C0196l c0196l = this.f1041a;
            byte[] bArr = f1040i;
            byte[] bArr2 = f1039h;
            if (i2 >= size) {
                F0.i.b(c0193i2);
                c0193i2.d(bArr);
                c0193i2.p(c0196l);
                c0193i2.d(bArr);
                c0193i2.d(bArr2);
                if (!z2) {
                    return j2;
                }
                F0.i.b(c0193i);
                long j3 = j2 + c0193i.f3482b;
                c0193i.t();
                return j3;
            }
            t tVar = (t) list.get(i2);
            n nVar = tVar.f1035a;
            F0.i.b(c0193i2);
            c0193i2.d(bArr);
            c0193i2.p(c0196l);
            c0193i2.d(bArr2);
            int size2 = nVar.size();
            for (int i3 = 0; i3 < size2; i3++) {
                c0193i2.k(nVar.b(i3)).d(g).k(nVar.d(i3)).d(bArr2);
            }
            B b2 = tVar.f1036b;
            s sVarB = b2.b();
            if (sVarB != null) {
                c0193i2.k("Content-Type: ").k(sVarB.f1032a).d(bArr2);
            }
            long jA = b2.a();
            if (jA != -1) {
                c0193i2.k("Content-Length: ").l(jA).d(bArr2);
            } else if (z2) {
                F0.i.b(c0193i);
                c0193i.t();
                return -1L;
            }
            c0193i2.d(bArr2);
            if (z2) {
                j2 += jA;
            } else {
                b2.c(c0193i2);
            }
            c0193i2.d(bArr2);
            i2++;
        }
    }
}
