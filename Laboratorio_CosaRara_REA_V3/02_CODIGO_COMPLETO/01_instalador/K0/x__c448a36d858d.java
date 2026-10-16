// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import N0.C0041m;
import java.io.IOException;
import p022m0.d;
import s0.a;
import s0.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f3429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f3430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ x[] f3431c;

    static {
        t tVar = new t();
        f3429a = tVar;
        u uVar = new u();
        f3430b = uVar;
        f3431c = new x[]{tVar, uVar, new x() { // from class: k0.v
            public static Double b(String str, a aVar) throws c {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (aVar.f4087o != 1) {
                            throw new c("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.v(true));
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e2) {
                    throw new C0041m("Cannot parse " + str + "; at path " + aVar.v(true), e2);
                }
            }

            @Override // p018k0.x
            public final Number a(a aVar) throws IOException {
                String strH = aVar.H();
                if (strH.indexOf(46) >= 0) {
                    return b(strH, aVar);
                }
                try {
                    return Long.valueOf(Long.parseLong(strH));
                } catch (NumberFormatException unused) {
                    return b(strH, aVar);
                }
            }
        }, new x() { // from class: k0.w
            @Override // p018k0.x
            public final Number a(a aVar) throws IOException {
                String strH = aVar.H();
                try {
                    return d.i(strH);
                } catch (NumberFormatException e2) {
                    throw new C0041m("Cannot parse " + strH + "; at path " + aVar.v(true), e2);
                }
            }
        }};
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f3431c.clone();
    }

    public abstract Number a(a aVar);
}
