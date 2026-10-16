// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import i2.c0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Serializable f262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f263d;

    public c(boolean z2, boolean z3, String str, k kVar) {
        this.f260a = z2;
        this.f261b = z3;
        this.f262c = str;
        this.f263d = kVar;
    }

    public i2.i a() {
        return new i2.i(this.f260a, this.f261b, (String[]) this.f262c, (String[]) this.f263d);
    }

    public void b(i2.h... hVarArr) {
        if (!this.f260a) {
            o2.i("no cipher suites for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(hVarArr.length);
        for (i2.h hVar : hVarArr) {
            arrayList.add(hVar.f2164a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.String[]] */
    public void c(String... strArr) {
        if (!this.f260a) {
            o2.i("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.f262c = (String[]) strArr.clone();
        } else {
            o2.i("At least one cipher suite is required");
        }
    }

    public void d(c0... c0VarArr) {
        if (!this.f260a) {
            o2.i("no TLS versions for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(c0VarArr.length);
        for (c0 c0Var : c0VarArr) {
            arrayList.add(c0Var.f2129c);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void e(String... strArr) {
        if (!this.f260a) {
            o2.i("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.f263d = (String[]) strArr.clone();
        } else {
            o2.i("At least one TLS version is required");
        }
    }

    public c() {
        this.f260a = true;
    }
}
