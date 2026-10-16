// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.io.IOException;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public final class j extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3411a;

    public /* synthetic */ j(int i2) {
        this.f3411a = i2;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        switch (this.f3411a) {
            case 0:
                if (aVar.J() != 9) {
                    return Double.valueOf(aVar.A());
                }
                aVar.F();
                return null;
            case 1:
                if (aVar.J() != 9) {
                    return Float.valueOf((float) aVar.A());
                }
                aVar.F();
                return null;
            default:
                aVar.P();
                return null;
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        switch (this.f3411a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    m.a(dDoubleValue);
                    bVar.A(dDoubleValue);
                } else {
                    bVar.w();
                }
                break;
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    m.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    bVar.C(numberValueOf);
                } else {
                    bVar.w();
                }
                break;
            default:
                bVar.w();
                break;
        }
    }

    public String toString() {
        switch (this.f3411a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
