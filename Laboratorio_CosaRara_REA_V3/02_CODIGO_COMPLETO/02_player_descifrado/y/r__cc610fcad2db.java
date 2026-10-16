// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.database.Cursor;
import android.util.Log;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.f3;
import w1.sd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6034c;

    public void a(boolean z2) {
        try {
            if (((AtomicBoolean) this.f6033b).compareAndSet(false, true)) {
                try {
                    ((sd) this.f6032a).a(z2);
                    synchronized (((f3) this.f6034c).f3975k) {
                        ((f3) this.f6034c).f3978o = false;
                    }
                } catch (RuntimeException e3) {
                    Log.w("TelemetryReporter", "capture health completion failed: " + e3.getMessage());
                    synchronized (((f3) this.f6034c).f3975k) {
                        ((f3) this.f6034c).f3978o = false;
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (((f3) this.f6034c).f3975k) {
                ((f3) this.f6034c).f3978o = false;
                throw th;
            }
        }
    }

    public void b(Runnable runnable) {
        ((z.l) this.f6032a).execute(runnable);
    }

    public ArrayList c(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f6032a;
        g.k kVarY = g.k.y("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.isNull(0) ? null : cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public void d(String str, Set set) {
        str.getClass();
        set.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            q qVar = new q((String) it.next(), str);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f6032a;
            workDatabase_Impl.b();
            workDatabase_Impl.c();
            try {
                ((b) this.f6033b).p(qVar);
                workDatabase_Impl.o();
                workDatabase_Impl.k();
            } catch (Throwable th) {
                workDatabase_Impl.k();
                throw th;
            }
        }
    }
}
