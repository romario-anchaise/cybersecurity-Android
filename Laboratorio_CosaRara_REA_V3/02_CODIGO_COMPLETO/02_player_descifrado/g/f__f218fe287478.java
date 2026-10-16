// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.work.impl.WorkDatabase_Impl;
import e2.y1;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f1382m = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f1383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f1386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f1387e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f1388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile k.i f1389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y1 f1390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b.e f1391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f1392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f1393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a2.i f1394l;

    public f(WorkDatabase_Impl workDatabase_Impl, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        this.f1383a = workDatabase_Impl;
        this.f1384b = map;
        this.f1390h = new y1(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap()).getClass();
        this.f1391i = new b.e();
        this.f1392j = new Object();
        this.f1393k = new Object();
        this.f1385c = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.f1385c.put(lowerCase2, Integer.valueOf(i3));
            String str2 = (String) this.f1384b.get(strArr[i3]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i3] = lowerCase2;
        }
        this.f1386d = strArr2;
        for (Map.Entry entry : this.f1384b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            locale2.getClass();
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.f1385c.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                LinkedHashMap linkedHashMap = this.f1385c;
                linkedHashMap.getClass();
                Object obj = linkedHashMap.get(lowerCase3);
                if (obj == null && !linkedHashMap.containsKey(lowerCase3)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase3) + " is missing in the map.");
                }
                linkedHashMap.put(lowerCase4, obj);
            }
        }
        this.f1394l = new a2.i(6, this);
    }

    public final boolean a() {
        k.c cVar = this.f1383a.f210a;
        if (!q1.e.a(cVar != null ? Boolean.valueOf(cVar.f2373c.isOpen()) : null, Boolean.TRUE)) {
            return false;
        }
        if (!this.f1388f) {
            this.f1383a.h().r();
        }
        if (this.f1388f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(k.c cVar, int i3) {
        cVar.A("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)");
        String str = this.f1386d[i3];
        for (int i4 = 0; i4 < 3; i4++) {
            String str2 = f1382m[i4];
            cVar.A("CREATE TEMP TRIGGER IF NOT EXISTS " + m0.a.j(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i3 + " AND invalidated = 0; END");
        }
    }

    public final void c(k.c cVar) {
        cVar.getClass();
        if (cVar.C()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.f1383a.f217h.readLock();
            lock.getClass();
            lock.lock();
            try {
                synchronized (this.f1392j) {
                    try {
                        int[] iArrB = this.f1390h.b();
                        if (iArrB != null) {
                            if (cVar.D()) {
                                cVar.w();
                            } else {
                                cVar.d();
                            }
                            try {
                                int length = iArrB.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    int i5 = iArrB[i3];
                                    int i6 = i4 + 1;
                                    if (i5 == 1) {
                                        b(cVar, i4);
                                    } else if (i5 == 2) {
                                        String str = this.f1386d[i4];
                                        String[] strArr = f1382m;
                                        for (int i7 = 0; i7 < 3; i7++) {
                                            cVar.A("DROP TRIGGER IF EXISTS ".concat(m0.a.j(str, strArr[i7])));
                                        }
                                    }
                                    i3++;
                                    i4 = i6;
                                }
                                cVar.F();
                                cVar.z();
                            } catch (Throwable th) {
                                cVar.z();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                lock.unlock();
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        } catch (SQLiteException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        } catch (IllegalStateException e4) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
        }
    }
}
