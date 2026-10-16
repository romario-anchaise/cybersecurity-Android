// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0065c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f1672b;

    public C0065c(Method method, int i2) {
        this.f1671a = i2;
        this.f1672b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0065c)) {
            return false;
        }
        C0065c c0065c = (C0065c) obj;
        return this.f1671a == c0065c.f1671a && this.f1672b.getName().equals(c0065c.f1672b.getName());
    }

    public final int hashCode() {
        return this.f1672b.getName().hashCode() + (this.f1671a * 31);
    }
}
