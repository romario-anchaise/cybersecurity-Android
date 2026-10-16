// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class p extends p004c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1567a;

    public /* synthetic */ p(int i2) {
        this.f1567a = i2;
    }

    @Override // p004c.a
    public final Object a(Intent intent, int i2) {
        switch (this.f1567a) {
            case 0:
                return new p002b.a(intent, i2);
            case 1:
                p036u0.o oVar = p036u0.o.f4147a;
                if (i2 != -1 || intent == null) {
                    return oVar;
                }
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return oVar;
                }
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i3 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i3 == 0));
                }
                ArrayList arrayListX = p036u0.e.x(stringArrayExtra);
                Iterator it = arrayListX.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(p036u0.h.q(arrayListX), p036u0.h.q(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new p034t0.d(it.next(), it2.next()));
                }
                return p036u0.q.q(arrayList2);
            default:
                return new p002b.a(intent, i2);
        }
    }
}
