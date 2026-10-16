// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.work.impl.WorkDatabase_Impl;
import g2.t;
import i2.y;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p.s;
import w1.j7;
import w1.n4;
import w1.n7;
import w1.o7;
import w1.q7;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements s, i2.e, n7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f5973e;

    public c(int i3) {
        this.f5971c = i3;
        switch (i3) {
            case 5:
                this.f5972d = new AtomicReference(t.f1734d);
                this.f5973e = new AtomicLong();
                break;
            case 8:
                this.f5972d = new androidx.lifecycle.h();
                this.f5973e = new a0.l();
                j(s.f2864b);
                break;
            case 11:
                this.f5972d = new AtomicBoolean();
                this.f5973e = new AtomicBoolean();
                break;
            default:
                this.f5972d = new AtomicBoolean();
                this.f5973e = new AtomicReference(g2.b.f1539e);
                break;
        }
    }

    public static void d(ArrayList arrayList, CharSequence charSequence) {
        if (charSequence == null) {
            return;
        }
        String strTrim = charSequence.toString().trim();
        if (strTrim.isEmpty() || arrayList.contains(strTrim)) {
            return;
        }
        arrayList.add(strTrim);
    }

    public void a(Object obj, String str) {
        int length = str.length();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(length + 1 + strValueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(strValueOf);
        ((ArrayList) this.f5972d).add(sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e4 A[PHI: r11 r13 r15
  0x00e4: PHI (r11v4 java.lang.Integer) = (r11v3 java.lang.Integer), (r11v8 java.lang.Integer) binds: [B:54:0x0111, B:36:0x00da] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r13v7 java.lang.Integer) = (r13v5 java.lang.Integer), (r13v3 java.lang.Integer) binds: [B:54:0x0111, B:36:0x00da] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r15v15 boolean) = (r15v9 boolean), (r15v18 boolean) binds: [B:54:0x0111, B:36:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x0163  */
    /* JADX WARN: Code duplicated, block: B:95:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // i2.e
    public void b(m2.i iVar, y yVar) {
        v2.g gVar;
        String strSubstring;
        g0.k kVar = yVar.f2298o;
        try {
            ((v2.g) this.f5972d).a(yVar, kVar);
            m2.l lVarC = kVar.c();
            i2.o oVar = yVar.f2292h;
            int size = oVar.size();
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            Integer numV = null;
            Integer numV2 = null;
            while (i4 < size) {
                if (v1.l.w(oVar.b(i4), "Sec-WebSocket-Extensions")) {
                    String strE = oVar.e(i4);
                    int i5 = i3;
                    while (true) {
                        int i6 = 1;
                        if (i5 >= strE.length()) {
                            break;
                        }
                        oVar = oVar;
                        int iH = j2.b.h(strE, ',', i5, i3, 4);
                        int iG = j2.b.g(strE, ';', i5, iH);
                        int iN = j2.b.n(i5, iG, strE);
                        String strSubstring2 = strE.substring(iN, j2.b.o(iN, iG, strE));
                        i5 = iG + 1;
                        if (strSubstring2.equalsIgnoreCase("permessage-deflate")) {
                            if (z2) {
                                z5 = true;
                            }
                            while (i5 < iH) {
                                int iG2 = j2.b.g(strE, ';', i5, iH);
                                int iG3 = j2.b.g(strE, '=', i5, iG2);
                                int iN2 = j2.b.n(i5, iG3, strE);
                                String strSubstring3 = strE.substring(iN2, j2.b.o(iN2, iG3, strE));
                                if (iG3 < iG2) {
                                    int iN3 = j2.b.n(iG3 + 1, iG2, strE);
                                    String strSubstring4 = strE.substring(iN3, j2.b.o(iN3, iG2, strE));
                                    iH = iH;
                                    strE = strE;
                                    if (strSubstring4.length() >= 2 && v1.l.z(strSubstring4, "\"", false) && strSubstring4.endsWith("\"")) {
                                        strSubstring = strSubstring4.substring(i6, strSubstring4.length() - 1);
                                    } else {
                                        strSubstring = strSubstring4;
                                    }
                                } else {
                                    iH = iH;
                                    strE = strE;
                                    strSubstring = null;
                                }
                                i5 = iG2 + 1;
                                if (strSubstring3.equalsIgnoreCase("client_max_window_bits")) {
                                    if (numV != null) {
                                        z5 = true;
                                    }
                                    numV = strSubstring != null ? v1.k.v(strSubstring, 10) : null;
                                    if (numV == null) {
                                        z5 = true;
                                    }
                                } else if (strSubstring3.equalsIgnoreCase("client_no_context_takeover")) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (strSubstring != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else {
                                    if (strSubstring3.equalsIgnoreCase("server_max_window_bits")) {
                                        if (numV2 != null) {
                                            z5 = true;
                                        }
                                        numV2 = strSubstring != null ? v1.k.v(strSubstring, 10) : null;
                                        if (numV2 == null) {
                                        }
                                    } else if (strSubstring3.equalsIgnoreCase("server_no_context_takeover")) {
                                        if (z4) {
                                            z5 = true;
                                        }
                                        if (strSubstring != null) {
                                            z5 = true;
                                        }
                                        z4 = true;
                                    }
                                    z5 = true;
                                }
                                i6 = 1;
                            }
                            i3 = 0;
                            z2 = true;
                        } else {
                            i3 = 0;
                            z5 = true;
                        }
                    }
                }
                i4++;
                i3 = i3;
                oVar = oVar;
            }
            ((v2.g) this.f5972d).f3308d = new v2.h(z2, numV, z3, numV2, z4, z5);
            if (z5 || numV != null) {
                gVar = (v2.g) this.f5972d;
                synchronized (gVar) {
                    gVar.f3318o.clear();
                    gVar.b("unexpected Sec-WebSocket-Extensions in response header", 1010);
                }
            } else if (numV2 != null) {
                s1.c cVar = new s1.c(8, 15, 1);
                int iIntValue = numV2.intValue();
                if (8 > iIntValue || iIntValue > cVar.f3230d) {
                    gVar = (v2.g) this.f5972d;
                    synchronized (gVar) {
                        gVar.f3318o.clear();
                        gVar.b("unexpected Sec-WebSocket-Extensions in response header", 1010);
                    }
                }
            }
            try {
                ((v2.g) this.f5972d).d(j2.b.f2367g + " WebSocket " + ((i2.q) ((b2.d) this.f5973e).f266c).f(), lVarC);
                v2.g gVar2 = (v2.g) this.f5972d;
                gVar2.f3305a.n(gVar2, yVar);
                ((v2.g) this.f5972d).e();
            } catch (Exception e3) {
                ((v2.g) this.f5972d).c(e3, null);
            }
        } catch (IOException e4) {
            ((v2.g) this.f5972d).c(e4, yVar);
            j2.b.d(yVar);
            if (kVar != null) {
                kVar.b(true, true, null);
            }
        }
    }

    @Override // i2.e
    public void c(m2.i iVar, IOException iOException) {
        ((v2.g) this.f5972d).c(iOException, null);
    }

    @Override // w1.n7
    public int e(o7 o7Var) {
        String str = (String) this.f5972d;
        j7 j7Var = o7Var.f4733l;
        if (j7Var != null && "ambiguous".equals(j7Var.f4341a) && !"locked".equals(str)) {
            str = "partial";
        }
        return n4.u((q7) this.f5973e, o7Var, str, false, true).getBytes(StandardCharsets.UTF_8).length;
    }

    public ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (ComponentName componentName : (List) this.f5973e) {
            if (componentName != null && z1.p.f6358h.contains(componentName.getPackageName())) {
                arrayList.add(componentName.flattenToShortString());
            }
        }
        return arrayList;
    }

    public List g() {
        CharSequence charSequenceLoadLabel;
        PackageItemInfo activityInfo;
        Context context = (Context) this.f5972d;
        if (context == null || !z1.p.f6357g.equals(context.getPackageName())) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Iterator it = z1.p.f6358h.iterator();
        while (it.hasNext()) {
            try {
                d(arrayList, packageManager.getApplicationInfo((String) it.next(), 0).loadLabel(packageManager));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        for (ComponentName componentName : (List) this.f5973e) {
            if (componentName != null && z1.p.f6358h.contains(componentName.getPackageName())) {
                Iterator it2 = Arrays.asList(new z1.n(packageManager, componentName, 0), new z1.n(packageManager, componentName, 1), new z1.n(packageManager, componentName, 2), new z1.n(packageManager, componentName, 3)).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        z1.n nVar = (z1.n) it2.next();
                        try {
                            switch (nVar.f6349a) {
                                case 0:
                                    activityInfo = nVar.f6350b.getActivityInfo(nVar.f6351c, 0);
                                    break;
                                case 1:
                                    activityInfo = nVar.f6350b.getServiceInfo(nVar.f6351c, 0);
                                    break;
                                case 2:
                                    activityInfo = nVar.f6350b.getReceiverInfo(nVar.f6351c, 0);
                                    break;
                                default:
                                    activityInfo = nVar.f6350b.getProviderInfo(nVar.f6351c, 0);
                                    break;
                            }
                            if (activityInfo != null) {
                                charSequenceLoadLabel = activityInfo.loadLabel(packageManager);
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                        }
                    } else {
                        charSequenceLoadLabel = null;
                    }
                }
                d(arrayList, charSequenceLoadLabel);
            }
        }
        return arrayList;
    }

    public ArrayList h(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f5972d;
        g.k kVarY = g.k.y("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    public void i(t tVar) {
        ((AtomicReference) this.f5972d).set(tVar);
        ((AtomicLong) this.f5973e).set(SystemClock.elapsedRealtime());
    }

    public void j(f fVar) {
        boolean z2;
        androidx.lifecycle.h hVar = (androidx.lifecycle.h) this.f5972d;
        synchronized (hVar.f189a) {
            z2 = hVar.f192d == androidx.lifecycle.h.f188h;
            hVar.f192d = fVar;
        }
        if (z2) {
            a.b bVarZ = a.b.z();
            a2.i iVar = hVar.f195g;
            a.d dVar = bVarZ.f3c;
            if (dVar.f7e == null) {
                synchronized (dVar.f5c) {
                    try {
                        if (dVar.f7e == null) {
                            dVar.f7e = Handler.createAsync(Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            dVar.f7e.post(iVar);
        }
        if (fVar instanceof p.r) {
            ((a0.l) this.f5973e).i((p.r) fVar);
        } else if (fVar instanceof p.p) {
            ((a0.l) this.f5973e).j(((p.p) fVar).f2862b);
        }
    }

    public boolean k(boolean z2, boolean z3) {
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f5972d;
        if (z2 || z3) {
            atomicBoolean.set(true);
        }
        return atomicBoolean.get();
    }

    public void l(g2.b bVar) {
        g2.b bVar2;
        Throwable th = bVar.f1543d;
        int i3 = bVar.f1542c;
        String str = bVar.f1541b;
        int i4 = bVar.f1540a;
        AtomicReference atomicReference = (AtomicReference) this.f5973e;
        if (((AtomicBoolean) this.f5972d).get()) {
            return;
        }
        if (i4 >= 0 || !str.isEmpty() || i3 >= 0 || th != null) {
            while (true) {
                g2.b bVar3 = (g2.b) atomicReference.get();
                String str2 = bVar3.f1541b;
                if (i4 >= 0 || !str.isEmpty() || i3 >= 0 || th != null) {
                    int i5 = bVar3.f1540a;
                    if (i5 < 0) {
                        i5 = i4;
                    }
                    if (str2.isEmpty()) {
                        str2 = str;
                    }
                    int i6 = bVar3.f1542c;
                    if (i6 < 0) {
                        i6 = i3;
                    }
                    Throwable th2 = bVar3.f1543d;
                    if (th2 == null) {
                        th2 = th;
                    }
                    bVar2 = new g2.b(i5, str2, i6, th2);
                } else {
                    bVar2 = bVar3;
                }
                if (bVar3 != bVar2) {
                    while (!atomicReference.compareAndSet(bVar3, bVar2)) {
                        if (atomicReference.get() != bVar3) {
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    public String toString() {
        switch (this.f5971c) {
            case 6:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f5973e.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f5972d;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    sb.append((String) arrayList.get(i3));
                    if (i3 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c(Object obj, Object obj2, int i3) {
        this.f5971c = i3;
        this.f5972d = obj;
        this.f5973e = obj2;
    }

    public c(e eVar, u0.b bVar) {
        this.f5971c = 3;
        this.f5973e = eVar;
        this.f5972d = bVar;
    }

    public /* synthetic */ c(Object obj) {
        this.f5971c = 6;
        this.f5973e = obj;
        this.f5972d = new ArrayList();
    }

    public c(WorkDatabase_Impl workDatabase_Impl) {
        this.f5971c = 0;
        this.f5972d = workDatabase_Impl;
        this.f5973e = new b(workDatabase_Impl, 0);
    }

    public c(String str, String str2) {
        this.f5971c = 7;
        this.f5972d = str;
        this.f5973e = str2 == null ? "" : str2;
    }

    public /* synthetic */ c(int i3, boolean z2) {
        this.f5971c = i3;
    }

    public c(Context context, ComponentName[] componentNameArr) {
        this.f5971c = 14;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.f5972d = applicationContext != null ? applicationContext : context;
        this.f5973e = Arrays.asList((ComponentName[]) componentNameArr.clone());
    }
}
