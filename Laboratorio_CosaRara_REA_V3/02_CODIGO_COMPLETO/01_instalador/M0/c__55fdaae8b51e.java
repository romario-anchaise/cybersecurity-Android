// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import E0.p;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c implements L0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final F0.j f372d;

    /* JADX WARN: Multi-variable type inference failed */
    public c(CharSequence charSequence, int i2, int i3, p pVar) {
        F0.i.e(charSequence, "input");
        this.f369a = charSequence;
        this.f370b = i2;
        this.f371c = i3;
        this.f372d = (F0.j) pVar;
    }

    @Override // L0.c
    public final Iterator iterator() {
        return new b(this);
    }
}
