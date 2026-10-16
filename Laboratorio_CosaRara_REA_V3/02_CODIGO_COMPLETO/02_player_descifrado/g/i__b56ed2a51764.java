// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.content.Context;
import e2.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import q.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1398b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Executor f1402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Executor f1403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f1404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1405i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1408l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashSet f1411p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1399c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1400d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f1401e = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1406j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1407k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1409m = -1;
    public final n1 n = new n1(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashSet f1410o = new LinkedHashSet();

    public i(Context context, String str) {
        this.f1397a = context;
        this.f1398b = str;
    }

    public final void a(h.a... aVarArr) {
        if (this.f1411p == null) {
            this.f1411p = new HashSet();
        }
        for (h.a aVar : aVarArr) {
            HashSet hashSet = this.f1411p;
            hashSet.getClass();
            hashSet.add(Integer.valueOf(aVar.f1853a));
            HashSet hashSet2 = this.f1411p;
            hashSet2.getClass();
            hashSet2.add(Integer.valueOf(aVar.f1854b));
        }
        this.n.e((h.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
