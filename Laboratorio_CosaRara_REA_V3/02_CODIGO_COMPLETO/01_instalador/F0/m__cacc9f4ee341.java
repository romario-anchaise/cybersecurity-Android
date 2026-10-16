// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import X0.n;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import g0.g;
import g0.h;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f2667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorSpace f2668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f2669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f2670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2671f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n f2674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r f2675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o f2676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f2677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f2678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f2679o;

    public m(Context context, Bitmap.Config config, ColorSpace colorSpace, h hVar, g gVar, boolean z2, boolean z3, boolean z4, String str, n nVar, r rVar, o oVar, b bVar, b bVar2, b bVar3) {
        this.f2666a = context;
        this.f2667b = config;
        this.f2668c = colorSpace;
        this.f2669d = hVar;
        this.f2670e = gVar;
        this.f2671f = z2;
        this.g = z3;
        this.f2672h = z4;
        this.f2673i = str;
        this.f2674j = nVar;
        this.f2675k = rVar;
        this.f2676l = oVar;
        this.f2677m = bVar;
        this.f2678n = bVar2;
        this.f2679o = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (i.a(this.f2666a, mVar.f2666a) && this.f2667b == mVar.f2667b && ((Build.VERSION.SDK_INT < 26 || i.a(this.f2668c, mVar.f2668c)) && i.a(this.f2669d, mVar.f2669d) && this.f2670e == mVar.f2670e && this.f2671f == mVar.f2671f && this.g == mVar.g && this.f2672h == mVar.f2672h && i.a(this.f2673i, mVar.f2673i) && i.a(this.f2674j, mVar.f2674j) && i.a(this.f2675k, mVar.f2675k) && i.a(this.f2676l, mVar.f2676l) && this.f2677m == mVar.f2677m && this.f2678n == mVar.f2678n && this.f2679o == mVar.f2679o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f2667b.hashCode() + (this.f2666a.hashCode() * 31)) * 31;
        ColorSpace colorSpace = this.f2668c;
        int iHashCode2 = (Boolean.hashCode(this.f2672h) + ((Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f2671f) + ((this.f2670e.hashCode() + ((this.f2669d.hashCode() + ((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f2673i;
        return this.f2679o.hashCode() + ((this.f2678n.hashCode() + ((this.f2677m.hashCode() + ((this.f2676l.f2682a.hashCode() + ((this.f2675k.f2690a.hashCode() + ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f2674j.f1012a)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}
