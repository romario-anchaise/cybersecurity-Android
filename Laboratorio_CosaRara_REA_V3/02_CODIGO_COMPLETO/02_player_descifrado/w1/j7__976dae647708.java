// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4346f;

    public j7(String str, String str2, int i3, boolean z2, List list, List list2) {
        if (!"transition".equals(str) && !"ambiguous".equals(str)) {
            str = "stable";
        }
        this.f4341a = str;
        this.f4342b = str2 == null ? "" : str2;
        this.f4344d = Math.max(0, Math.min(100, i3));
        this.f4343c = z2;
        this.f4345e = o7.d(list);
        this.f4346f = o7.d(list2);
    }

    public boolean a() {
        return "stable".equals(this.f4341a);
    }

    public j7(String str, String str2, String str3, String str4, boolean z2, int i3) {
        this.f4341a = str;
        this.f4342b = str2;
        this.f4345e = str3;
        this.f4346f = str4;
        this.f4343c = z2;
        this.f4344d = i3;
    }
}
