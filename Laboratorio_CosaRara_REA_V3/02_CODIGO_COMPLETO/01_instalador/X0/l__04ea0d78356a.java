// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k1.C0193i;
import k1.InterfaceC0194j;

/* JADX INFO: loaded from: classes.dex */
public final class l extends B {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f1005c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1007b;

    static {
        Pattern pattern = s.f1030d;
        f1005c = f1.d.q("application/x-www-form-urlencoded");
    }

    public l(ArrayList arrayList, ArrayList arrayList2) {
        F0.i.e(arrayList, "encodedNames");
        F0.i.e(arrayList2, "encodedValues");
        this.f1006a = Y0.b.w(arrayList);
        this.f1007b = Y0.b.w(arrayList2);
    }

    @Override // X0.B
    public final long a() {
        return d(null, true);
    }

    @Override // X0.B
    public final s b() {
        return f1005c;
    }

    @Override // X0.B
    public final void c(InterfaceC0194j interfaceC0194j) {
        d(interfaceC0194j, false);
    }

    public final long d(InterfaceC0194j interfaceC0194j, boolean z2) {
        C0193i c0193iB;
        if (z2) {
            c0193iB = new C0193i();
        } else {
            F0.i.b(interfaceC0194j);
            c0193iB = interfaceC0194j.b();
        }
        List list = this.f1006a;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                c0193iB.Q(38);
            }
            c0193iB.U((String) list.get(i2));
            c0193iB.Q(61);
            c0193iB.U((String) this.f1007b.get(i2));
        }
        if (!z2) {
            return 0L;
        }
        long j2 = c0193iB.f3482b;
        c0193iB.t();
        return j2;
    }
}
