// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p008e0;

import F0.j;
import X0.C0056c;
import X0.s;
import f1.d;
import f1.l;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j implements E0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f2252c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, int i2) {
        super(0);
        this.f2251b = i2;
        this.f2252c = bVar;
    }

    @Override // E0.a
    public final Object a() {
        b bVar = this.f2252c;
        switch (this.f2251b) {
            case 0:
                C0056c c0056c = C0056c.f947n;
                return l.L(bVar.f2258f);
            default:
                String strA = bVar.f2258f.a("Content-Type");
                if (strA == null) {
                    return null;
                }
                Pattern pattern = s.f1030d;
                try {
                    return d.q(strA);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }
}
