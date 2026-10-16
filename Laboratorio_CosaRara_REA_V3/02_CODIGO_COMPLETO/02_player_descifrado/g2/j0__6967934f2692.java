// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1639a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f1646h;

    public j0(j0 j0Var) {
        this.f1640b = j0Var.f1640b;
        this.f1641c = j0Var.f1641c;
        this.f1642d = j0Var.f1642d;
        this.f1643e = j0Var.f1643e;
        this.f1644f = j0Var.f1644f;
        this.f1645g = j0Var.f1645g;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (v0 v0Var : v0.values()) {
            linkedHashMap.put(v0Var.f1771c, new i0((x0) j0Var.f1646h.get(v0Var)));
        }
        this.f1646h = Collections.unmodifiableMap(linkedHashMap);
    }

    public final String toString() {
        switch (this.f1639a) {
            case 0:
                StringBuilder sb = new StringBuilder("{generation=");
                sb.append(this.f1640b);
                sb.append(",transport=");
                sb.append(this.f1641c ? "v2" : "v1");
                sb.append(",queuedBytes=");
                sb.append(this.f1643e);
                sb.append(",inFlightBytes=");
                sb.append(this.f1645g);
                sb.append(",lanes=");
                sb.append(this.f1646h);
                sb.append("}");
                return sb.toString();
            default:
                StringBuilder sb2 = new StringBuilder("{generation=");
                sb2.append(this.f1640b);
                sb2.append(",transport=");
                sb2.append(this.f1641c ? "v2" : "v1");
                sb2.append(",queuedBytes=");
                sb2.append(this.f1643e);
                sb2.append(",inFlightBytes=");
                sb2.append(this.f1645g);
                sb2.append(",lanes=");
                sb2.append(this.f1646h);
                sb2.append("}");
                return sb2.toString();
        }
    }

    public j0(long j3, boolean z2, int i3, long j4, int i4, long j5, EnumMap enumMap) {
        this.f1640b = j3;
        this.f1641c = z2;
        this.f1642d = i3;
        this.f1643e = j4;
        this.f1644f = i4;
        this.f1645g = j5;
        this.f1646h = Collections.unmodifiableMap(enumMap);
    }
}
