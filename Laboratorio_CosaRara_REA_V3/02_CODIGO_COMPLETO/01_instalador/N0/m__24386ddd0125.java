// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0041m extends RuntimeException {
    public C0041m(m1.O o2) {
        StringBuilder sb = new StringBuilder("HTTP ");
        X0.D d2 = o2.f3818a;
        sb.append(d2.f907d);
        sb.append(" ");
        sb.append(d2.f906c);
        super(sb.toString());
    }
}
