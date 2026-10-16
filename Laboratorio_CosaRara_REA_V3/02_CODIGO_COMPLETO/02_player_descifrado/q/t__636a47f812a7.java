// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.oe;
import w1.w2;
import w1.x2;
import w1.y2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f3081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f3084h;

    public t(Context context, oe oeVar) {
        y2 y2VarY = y2.y(context.getApplicationContext());
        this.f3079c = new Handler(Looper.getMainLooper());
        this.f3080d = Executors.newSingleThreadExecutor(new a2.l(17));
        this.f3081e = new AtomicBoolean(false);
        this.f3082f = new AtomicBoolean(false);
        this.f3083g = new a2.i(14, this);
        this.f3084h = new x2(this, 0);
        this.f3077a = y2VarY;
        this.f3078b = oeVar;
    }

    public static ArrayList a(ArrayList arrayList, List list) {
        HashSet hashSet = new HashSet(c(arrayList));
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (hashSet.contains(str) && hashSet2.add(str)) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList c(ArrayList arrayList) {
        String str;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            w2 w2Var = (w2) obj;
            if (w2Var != null && (str = w2Var.f5384a) != null && !str.isEmpty()) {
                arrayList2.add(str);
            }
        }
        return arrayList2;
    }

    public void b() {
        if (((AtomicBoolean) this.f3081e).get()) {
            try {
                ((ExecutorService) this.f3080d).execute(new x2(this, 1));
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("schedule flush fail: "), "CredOutboxReporter");
            }
        }
    }

    public t(Context context, p.b bVar, y.r rVar, h hVar, WorkDatabase workDatabase, y.o oVar, ArrayList arrayList) {
        new h0.g();
        this.f3077a = context.getApplicationContext();
        this.f3079c = rVar;
        this.f3078b = hVar;
        this.f3080d = bVar;
        this.f3081e = workDatabase;
        this.f3082f = oVar;
        this.f3084h = arrayList;
    }
}
