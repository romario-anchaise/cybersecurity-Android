// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f6327l;

    public g(d.b bVar) {
        String str = bVar.f506a;
        this.f6316a = str == null ? "" : str;
        String str2 = (String) bVar.f512g;
        this.f6317b = str2 == null ? "" : str2;
        String str3 = (String) bVar.f513h;
        this.f6318c = str3 == null ? "" : str3;
        String str4 = (String) bVar.f514i;
        this.f6319d = str4 == null ? "" : str4;
        String str5 = (String) bVar.f515j;
        this.f6320e = str5 == null ? "" : str5;
        String str6 = (String) bVar.f516k;
        this.f6321f = str6 == null ? "" : str6;
        String str7 = (String) bVar.f517l;
        this.f6322g = str7 != null ? str7 : "";
        int i3 = bVar.f508c;
        this.f6323h = i3 == 0 ? 1 : i3;
        this.f6324i = bVar.f507b;
        this.f6325j = bVar.f509d;
        this.f6326k = bVar.f510e;
        this.f6327l = Collections.unmodifiableList(new ArrayList((ArrayList) bVar.f511f));
    }
}
