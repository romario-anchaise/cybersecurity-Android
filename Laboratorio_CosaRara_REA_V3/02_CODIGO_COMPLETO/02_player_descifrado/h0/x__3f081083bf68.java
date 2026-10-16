// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.text.TextUtils;
import java.util.Arrays;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1937c;

    public x(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            o2.i("Given String is empty or null");
            throw null;
        }
        this.f1935a = str;
        if (TextUtils.isEmpty("com.google.android.gms")) {
            o2.i("Given String is empty or null");
            throw null;
        }
        this.f1936b = "com.google.android.gms";
        this.f1937c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return o.e(this.f1935a, xVar.f1935a) && o.e(this.f1936b, xVar.f1936b) && o.e(null, null) && this.f1937c == xVar.f1937c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1935a, this.f1936b, null, 4225, Boolean.valueOf(this.f1937c)});
    }

    public final String toString() {
        String str = this.f1935a;
        if (str != null) {
            return str;
        }
        o.c(null);
        throw null;
    }
}
