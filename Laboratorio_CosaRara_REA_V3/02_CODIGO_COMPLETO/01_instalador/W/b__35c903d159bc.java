// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import java.io.IOException;
import k1.C0193i;
import k1.I;
import k1.InterfaceC0195k;
import m1.C0218w;

/* JADX INFO: loaded from: classes.dex */
public final class b extends k1.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f735b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f736c;

    public /* synthetic */ b(I i2) {
        super(i2);
    }

    @Override // k1.q, k1.I
    public final long m(C0193i c0193i, long j2) throws Exception {
        switch (this.f735b) {
            case 0:
                try {
                    return super.m(c0193i, j2);
                } catch (Exception e2) {
                    this.f736c = e2;
                    throw e2;
                }
            default:
                try {
                    return super.m(c0193i, j2);
                } catch (IOException e3) {
                    ((C0218w) this.f736c).f3864d = e3;
                    throw e3;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(C0218w c0218w, InterfaceC0195k interfaceC0195k) {
        super(interfaceC0195k);
        this.f736c = c0218w;
    }
}
