// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.regex.Pattern;
import k1.C0193i;
import k1.InterfaceC0195k;

/* JADX INFO: loaded from: classes.dex */
public final class F extends G {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC0195k f924e;

    public /* synthetic */ F(Object obj, long j2, InterfaceC0195k interfaceC0195k, int i2) {
        this.f921b = i2;
        this.f923d = obj;
        this.f922c = j2;
        this.f924e = interfaceC0195k;
    }

    @Override // X0.G
    public final long a() {
        switch (this.f921b) {
            case 0:
                break;
        }
        return this.f922c;
    }

    @Override // X0.G
    public final s f() {
        Object obj = this.f923d;
        switch (this.f921b) {
            case 0:
                return (s) obj;
            default:
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                Pattern pattern = s.f1030d;
                try {
                    return f1.d.q(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }

    @Override // X0.G
    public final InterfaceC0195k j() {
        switch (this.f921b) {
            case 0:
                return (C0193i) this.f924e;
            default:
                return (k1.C) this.f924e;
        }
    }
}
