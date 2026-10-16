// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import H.t;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f1260a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f1262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f1263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f1264e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f1261b = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1265f = false;

    public o(Runnable runnable) {
        this.f1260a = runnable;
        if (p039w.b.a()) {
            this.f1262c = new j(this);
            this.f1263d = l.a(new t(5, this));
        }
    }

    public final void a() {
        int size;
        Iterator itDescendingIterator = this.f1261b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            androidx.fragment.app.m mVar = (androidx.fragment.app.m) itDescendingIterator.next();
            if (mVar.f1560a) {
                r rVar = mVar.f1563d;
                rVar.e(true);
                if (!rVar.g.f1560a) {
                    rVar.f1575f.a();
                    return;
                }
                rVar.e(false);
                rVar.d(true);
                ArrayList arrayList = rVar.f1590v;
                ArrayList arrayList2 = rVar.f1591w;
                ArrayList arrayList3 = rVar.f1573d;
                if (arrayList3 != null && (size = arrayList3.size() - 1) >= 0) {
                    arrayList.add(rVar.f1573d.remove(size));
                    arrayList2.add(Boolean.TRUE);
                    rVar.f1571b = true;
                    try {
                        rVar.i(rVar.f1590v, rVar.f1591w);
                        rVar.a();
                    } catch (Throwable th) {
                        rVar.a();
                        throw th;
                    }
                }
                rVar.j();
                ((HashMap) rVar.f1572c.f233c).values().removeAll(Collections.singleton(null));
                return;
            }
        }
        Runnable runnable = this.f1260a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void b() {
        boolean z2;
        Iterator itDescendingIterator = this.f1261b.descendingIterator();
        while (true) {
            if (!itDescendingIterator.hasNext()) {
                z2 = false;
                break;
            } else if (((androidx.fragment.app.m) itDescendingIterator.next()).f1560a) {
                z2 = true;
                break;
            }
        }
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1264e;
        if (onBackInvokedDispatcher != null) {
            if (z2 && !this.f1265f) {
                l.b(onBackInvokedDispatcher, 0, this.f1263d);
                this.f1265f = true;
            } else {
                if (z2 || !this.f1265f) {
                    return;
                }
                l.c(onBackInvokedDispatcher, this.f1263d);
                this.f1265f = false;
            }
        }
    }
}
