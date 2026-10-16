// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.common.api.Status;
import i2.d0;
import i2.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import w1.e5;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5977d;

    public e(int i3) {
        switch (i3) {
            case 6:
                e0.e eVar = e0.e.f671d;
                this.f5976c = new SparseIntArray();
                this.f5977d = eVar;
                break;
            case 8:
                this.f5976c = new Object();
                this.f5977d = new LinkedHashMap();
                break;
            case 11:
                this.f5976c = new h2.i();
                this.f5977d = new HashSet();
                break;
            default:
                this.f5976c = Collections.synchronizedMap(new WeakHashMap());
                this.f5977d = Collections.synchronizedMap(new WeakHashMap());
                break;
        }
    }

    public static String d(c cVar) {
        String languageTags;
        Context context = (Context) cVar.f5972d;
        String strC = z1.p.c(context != null ? context.getPackageName() : "");
        if (context == null) {
            languageTags = "und";
        } else {
            try {
                languageTags = context.getResources().getConfiguration().getLocales().toLanguageTags();
            } catch (Throwable unused) {
                languageTags = "und";
            }
        }
        String strC2 = z1.p.c(languageTags);
        String str = strC2.isEmpty() ? "und" : strC2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListF = cVar.f();
        int size = arrayListF.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListF.get(i3);
            i3++;
            String str2 = (String) obj;
            if (str2 != null) {
                arrayList.add(str2.trim().toLowerCase(Locale.ROOT));
            }
        }
        arrayList.sort(Comparator.naturalOrder());
        return strC + '\n' + str + '\n' + String.join("\n", arrayList);
    }

    public static e m(String str) {
        Object obj = null;
        if (str == null) {
            return null;
        }
        return new e(str, obj);
    }

    @Override // i2.d0
    public v2.g a(b2.d dVar, i2.c cVar) {
        return ((u) this.f5976c).a(dVar, new g2.a(cVar, (c) this.f5977d));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00ea  */
    public void b(String str) {
        int i3;
        w0.i iVar;
        int i4;
        int length = str.length();
        boolean z2 = false;
        int numericValue = Character.getNumericValue(str.charAt(0));
        e1.d dVar = new e1.d(numericValue);
        if (numericValue < 0 || numericValue > 6) {
            throw new e1.b("unknown packet type " + dVar.f694a);
        }
        if (5 == numericValue || 6 == numericValue) {
            if (!str.contains("-") || length <= 1) {
                throw new e1.b("illegal attachments");
            }
            StringBuilder sb = new StringBuilder();
            i3 = 0;
            while (true) {
                i3++;
                if (str.charAt(i3) == '-') {
                    break;
                } else {
                    sb.append(str.charAt(i3));
                }
            }
            dVar.f698e = Integer.parseInt(sb.toString());
        } else {
            i3 = 0;
        }
        int i5 = i3 + 1;
        if (length <= i5 || '/' != str.charAt(i5)) {
            dVar.f696c = "/";
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                i4 = i3 + 1;
                char cCharAt = str.charAt(i4);
                if (',' == cCharAt) {
                    break;
                }
                sb2.append(cCharAt);
                if (i3 + 2 == length) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            dVar.f696c = sb2.toString();
            i3 = i4;
        }
        int i6 = i3 + 1;
        if (length > i6 && Character.getNumericValue(str.charAt(i6)) > -1) {
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                int i7 = i3 + 1;
                char cCharAt2 = str.charAt(i7);
                if (Character.getNumericValue(cCharAt2) < 0) {
                    break;
                }
                sb3.append(cCharAt2);
                if (i3 + 2 == length) {
                    i3 = i7;
                    break;
                }
                i3 = i7;
            }
            try {
                dVar.f695b = Integer.parseInt(sb3.toString());
            } catch (NumberFormatException unused) {
                throw new e1.b("invalid payload");
            }
        }
        int i8 = i3 + 1;
        if (length > i8) {
            try {
                str.charAt(i8);
                Object objNextValue = new JSONTokener(str.substring(i8)).nextValue();
                dVar.f697d = objNextValue;
                switch (dVar.f694a) {
                    case 0:
                    case 4:
                        z2 = objNextValue instanceof JSONObject;
                        break;
                    case 1:
                        if (objNextValue == null) {
                            z2 = true;
                        }
                        break;
                    case 2:
                    case 5:
                        if (objNextValue instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) objNextValue;
                            if (jSONArray.length() > 0 && !jSONArray.isNull(0)) {
                                z2 = true;
                            }
                        }
                        break;
                    case 3:
                    case 6:
                        z2 = objNextValue instanceof JSONArray;
                        break;
                }
                if (!z2) {
                    throw new e1.b("invalid payload");
                }
            } catch (JSONException e3) {
                e1.c.f693a.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e3);
                throw new e1.b("invalid payload");
            }
        }
        Logger logger = e1.c.f693a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("decoded " + str + " as " + dVar);
        }
        int i9 = dVar.f694a;
        if (5 != i9 && 6 != i9) {
            w0.i iVar2 = (w0.i) this.f5977d;
            if (iVar2 != null) {
                iVar2.f3392a.a("packet", dVar);
                return;
            }
            return;
        }
        c cVar = new c(2, false);
        cVar.f5972d = dVar;
        cVar.f5973e = new ArrayList();
        this.f5976c = cVar;
        if (((e1.d) cVar.f5972d).f698e != 0 || (iVar = (w0.i) this.f5977d) == null) {
            return;
        }
        iVar.f3392a.a("packet", dVar);
    }

    public void c(byte[] bArr) {
        c cVar = (c) this.f5976c;
        if (cVar == null) {
            throw new RuntimeException("got binary data when not reconstructing a packet");
        }
        ((ArrayList) cVar.f5973e).add(bArr);
        int size = ((ArrayList) cVar.f5973e).size();
        e1.d dVar = (e1.d) cVar.f5972d;
        if (size == dVar.f698e) {
            ArrayList arrayList = (ArrayList) cVar.f5973e;
            byte[][] bArr2 = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
            Logger logger = e1.a.f692a;
            dVar.f697d = e1.a.b(dVar.f697d, bArr2);
            dVar.f698e = -1;
            cVar.f5972d = null;
            cVar.f5973e = new ArrayList();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            this.f5976c = null;
            w0.i iVar = (w0.i) this.f5977d;
            if (iVar != null) {
                iVar.f3392a.a("packet", dVar);
            }
        }
    }

    public boolean e(j jVar) {
        boolean zContainsKey;
        synchronized (this.f5976c) {
            zContainsKey = ((LinkedHashMap) this.f5977d).containsKey(jVar);
        }
        return zContainsKey;
    }

    public void f(e5 e5Var) {
        h2.i iVar = (h2.i) this.f5976c;
        synchronized (iVar) {
            if (iVar.f2052a) {
                return;
            }
            iVar.f2052a = true;
            HashSet<Runnable> hashSet = (HashSet) this.f5977d;
            for (Runnable runnable : hashSet) {
                Handler handler = e5Var.f3874b;
                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
            }
            hashSet.clear();
        }
    }

    public Long g(String str) {
        WorkDatabase workDatabase = (WorkDatabase) this.f5976c;
        g.k kVarY = g.k.y("SELECT long_value FROM Preference where `key`=?", 1);
        kVarY.m(str, 1);
        workDatabase.b();
        Cursor cursorM = workDatabase.m(kVarY);
        try {
            Long lValueOf = null;
            if (cursorM.moveToFirst() && !cursorM.isNull(0)) {
                lValueOf = Long.valueOf(cursorM.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public void h(d dVar) {
        WorkDatabase workDatabase = (WorkDatabase) this.f5976c;
        workDatabase.b();
        workDatabase.c();
        try {
            ((b) this.f5977d).p(dVar);
            workDatabase.o();
        } finally {
            workDatabase.k();
        }
    }

    public List i(String str) {
        List listE;
        str.getClass();
        synchronized (this.f5976c) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f5977d;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (q1.e.a(((j) entry.getKey()).f5987a, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    ((LinkedHashMap) this.f5977d).remove((j) it.next());
                }
                listE = i1.i.E(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return listE;
    }

    public q.l j(j jVar) {
        q.l lVar;
        synchronized (this.f5976c) {
            lVar = (q.l) ((LinkedHashMap) this.f5977d).remove(jVar);
        }
        return lVar;
    }

    public synchronized z1.p k(ScreenMirrorService screenMirrorService, ComponentName... componentNameArr) {
        return l(new c(screenMirrorService, componentNameArr));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007c A[Catch: all -> 0x001b, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0015, B:12:0x001d, B:14:0x0023, B:16:0x002a, B:20:0x0043, B:22:0x0051, B:24:0x005d, B:27:0x0066, B:29:0x0070, B:32:0x007e, B:31:0x007c), top: B:41:0x0001 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public synchronized z1.p l(c cVar) {
        ?? arrayList;
        String strD = d(cVar);
        if (((z1.p) this.f5977d) != null && strD.equals((String) this.f5976c)) {
            return (z1.p) this.f5977d;
        }
        Context context = (Context) cVar.f5972d;
        String packageName = context != null ? context.getPackageName() : "";
        String languageTags = "und";
        Context context2 = (Context) cVar.f5972d;
        if (context2 != null) {
            try {
                languageTags = context2.getResources().getConfiguration().getLocales().toLanguageTags();
            } catch (Throwable unused) {
            }
        }
        List listG = cVar.g();
        ArrayList arrayListF = cVar.f();
        Context context3 = (Context) cVar.f5972d;
        if (context3 != null) {
            String str = z1.p.f6357g;
            if (str.equals(context3.getPackageName())) {
                String str2 = t9.f5174e;
                if (str.equals(str2)) {
                    arrayList = Collections.EMPTY_LIST;
                } else {
                    arrayList = new ArrayList();
                    PackageManager packageManager = context3.getPackageManager();
                    try {
                        c.d(arrayList, packageManager.getApplicationInfo(str2, 0).loadLabel(packageManager));
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                }
            } else {
                arrayList = Collections.EMPTY_LIST;
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        z1.p pVarA = z1.p.a(packageName, languageTags, listG, arrayListF, arrayList);
        this.f5977d = pVarA;
        this.f5976c = strD;
        return pVarA;
    }

    public void n(Runnable runnable) {
        ((h2.i) this.f5976c).a(runnable);
    }

    public void o(d.b bVar) {
        if (((d.b) this.f5976c) != bVar) {
            this.f5976c = bVar;
            if (((e) bVar.f516k) != this) {
                bVar.f516k = this;
                o(bVar);
            }
        }
    }

    public q.l p(j jVar) {
        q.l lVar;
        synchronized (this.f5976c) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f5977d;
                Object lVar2 = linkedHashMap.get(jVar);
                if (lVar2 == null) {
                    lVar2 = new q.l(jVar);
                    linkedHashMap.put(jVar, lVar2);
                }
                lVar = (q.l) lVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public void q(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f5976c)) {
            map = new HashMap((Map) this.f5976c);
        }
        synchronized (((Map) this.f5977d)) {
            map2 = new HashMap((Map) this.f5977d);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((u0.b) entry2.getKey()).a(new f0.a(status));
            }
        }
    }

    public /* synthetic */ e(Object obj, Object obj2) {
        this.f5976c = obj;
        this.f5977d = obj2;
    }
}
