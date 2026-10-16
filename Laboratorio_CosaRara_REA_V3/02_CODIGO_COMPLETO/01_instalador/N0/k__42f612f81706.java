// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.util.Calendar;
import java.util.GregorianCalendar;
import p018k0.m;
import p018k0.x;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: renamed from: n0.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0229k implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3933b;

    public /* synthetic */ C0229k(int i2, Object obj) {
        this.f3932a = i2;
        this.f3933b = obj;
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        switch (this.f3932a) {
            case 0:
                if (aVar.f4029a == Number.class) {
                    return (C0230l) this.f3933b;
                }
                return null;
            case 1:
                if (aVar.f4029a == Object.class) {
                    return new C0231m(mVar, (x) this.f3933b);
                }
                return null;
            default:
                Class cls = aVar.f4029a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (M) this.f3933b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f3932a) {
            case 2:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((M) this.f3933b) + "]";
            default:
                return super.toString();
        }
    }
}
