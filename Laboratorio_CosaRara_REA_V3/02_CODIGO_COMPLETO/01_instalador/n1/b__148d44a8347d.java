// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n1;

import F0.i;
import X0.s;
import X0.z;
import f1.d;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import k1.C0192h;
import k1.C0193i;
import k1.C0196l;
import m1.InterfaceC0209m;
import p018k0.m;
import p018k0.y;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0209m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f3966c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f3968b;

    static {
        Pattern pattern = s.f1030d;
        f3966c = d.q("application/json; charset=UTF-8");
    }

    public b(m mVar, y yVar) {
        this.f3967a = mVar;
        this.f3968b = yVar;
    }

    @Override // m1.InterfaceC0209m
    public final Object p(Object obj) throws IOException {
        C0193i c0193i = new C0193i();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new C0192h(c0193i), StandardCharsets.UTF_8);
        m mVar = this.f3967a;
        s0.b bVar = new s0.b(outputStreamWriter);
        bVar.y(mVar.g);
        bVar.f4098i = mVar.f3424f;
        bVar.f4097h = 2;
        bVar.f4100k = false;
        this.f3968b.b(bVar, obj);
        bVar.close();
        C0196l c0196lD = c0193i.D(c0193i.f3482b);
        i.e(c0196lD, "content");
        return new z(f3966c, c0196lD);
    }
}
