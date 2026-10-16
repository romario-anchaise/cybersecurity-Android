// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f3040i = p.m.f("WorkContinuationImpl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f3045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f3046f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y.c f3048h;

    public m(q qVar, String str, int i3, List list, int i4) {
        this.f3041a = qVar;
        this.f3042b = str;
        this.f3043c = i3;
        this.f3044d = list;
        this.f3045e = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            String string = ((p.u) list.get(i5)).f2865a.toString();
            string.getClass();
            this.f3045e.add(string);
            this.f3046f.add(string);
        }
    }

    public static HashSet b(m mVar) {
        HashSet hashSet = new HashSet();
        mVar.getClass();
        return hashSet;
    }

    public final p.s a() {
        if (this.f3047g) {
            p.m.d().g(f3040i, "Already enqueued work ids (" + TextUtils.join(", ", this.f3045e) + ")");
        } else {
            y.c cVar = new y.c(8);
            this.f3041a.f3058d.b(new z.c(this, cVar));
            this.f3048h = cVar;
        }
        return this.f3048h;
    }
}
