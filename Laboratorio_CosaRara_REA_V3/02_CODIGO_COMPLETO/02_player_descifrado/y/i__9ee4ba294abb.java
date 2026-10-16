// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase_Impl;
import f2.i0;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f5983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5986d;

    public i(String str, Collection collection) {
        String str2 = y1.j.f6206a;
        String lowerCase = str == null ? "" : str.toString().trim().toLowerCase(Locale.ROOT);
        this.f5983a = lowerCase;
        String strA = y1.j.a("lyr.stable.runtime.ScreenMirrorService");
        this.f5984b = strA;
        this.f5985c = lowerCase + "/" + strA;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String strO = y1.j.o((CharSequence) it.next());
                if (strO.length() >= 2) {
                    linkedHashSet.add(strO);
                }
            }
        }
        this.f5986d = Collections.unmodifiableSet(linkedHashSet);
    }

    public void a(m2.f fVar) {
        fVar.f2712d.decrementAndGet();
        ArrayDeque arrayDeque = (ArrayDeque) this.f5985c;
        synchronized (this) {
            if (!arrayDeque.remove(fVar)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        d();
    }

    public g b(j jVar) {
        String str = jVar.f5987a;
        int i3 = jVar.f5988b;
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f5983a;
        g.k kVarY = g.k.y("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        kVarY.h(2, i3);
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "work_spec_id");
            int iM2 = q2.c.m(cursorM, "generation");
            int iM3 = q2.c.m(cursorM, "system_id");
            g gVar = null;
            String string = null;
            if (cursorM.moveToFirst()) {
                if (!cursorM.isNull(iM)) {
                    string = cursorM.getString(iM);
                }
                gVar = new g(cursorM.getInt(iM2), cursorM.getInt(iM3), string);
            }
            return gVar;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public void c(g gVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f5983a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((b) this.f5984b).p(gVar);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0063  */
    /* JADX WARN: Code duplicated, block: B:24:0x0071 A[Catch: all -> 0x009e, TryCatch #4 {all -> 0x009e, blocks: (B:22:0x006b, B:24:0x0071, B:27:0x00a0), top: B:53:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0071, please report this as an issue */
    public void d() {
        int size;
        boolean z2;
        int i3;
        m2.f fVar;
        byte[] bArr = j2.b.f2361a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.f5984b).iterator();
                it.getClass();
                while (it.hasNext()) {
                    m2.f fVar2 = (m2.f) it.next();
                    if (((ArrayDeque) this.f5985c).size() >= 64) {
                        break;
                    }
                    if (fVar2.f2712d.get() < 5) {
                        it.remove();
                        fVar2.f2712d.incrementAndGet();
                        arrayList.add(fVar2);
                        ((ArrayDeque) this.f5985c).add(fVar2);
                    }
                }
                synchronized (this) {
                    ((ArrayDeque) this.f5985c).size();
                    ((ArrayDeque) this.f5986d).size();
                }
                size = arrayList.size();
                z2 = false;
                for (i3 = 0; i3 < size; i3++) {
                    fVar = (m2.f) arrayList.get(i3);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.f5983a) == null) {
                                this.f5983a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new j2.a(j2.b.f2367g + " Dispatcher", z2));
                            }
                            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f5983a;
                            threadPoolExecutor.getClass();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    fVar.getClass();
                    m2.i iVar = fVar.f2713e;
                    i iVar2 = iVar.f2716c.f2238c;
                    byte[] bArr2 = j2.b.f2361a;
                    try {
                        try {
                            threadPoolExecutor.execute(fVar);
                        } catch (RejectedExecutionException e3) {
                            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                            interruptedIOException.initCause(e3);
                            iVar.i(interruptedIOException);
                            fVar.f2711c.c(iVar, interruptedIOException);
                            iVar.f2716c.f2238c.a(fVar);
                        }
                    } catch (Throwable th2) {
                        iVar.f2716c.f2238c.a(fVar);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        size = arrayList.size();
        z2 = false;
        while (i3 < size) {
            fVar = (m2.f) arrayList.get(i3);
            synchronized (this) {
                if (((ThreadPoolExecutor) this.f5983a) == null) {
                    this.f5983a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new j2.a(j2.b.f2367g + " Dispatcher", z2));
                }
                ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) this.f5983a;
                threadPoolExecutor2.getClass();
                fVar.getClass();
                m2.i iVar3 = fVar.f2713e;
                i iVar4 = iVar3.f2716c.f2238c;
                byte[] bArr3 = j2.b.f2361a;
                threadPoolExecutor2.execute(fVar);
            }
        }
    }

    public JSONObject e(int i3) {
        String strL;
        JSONObject jSONObjectOptJSONObject = ((JSONObject) this.f5983a).optJSONObject("steps");
        if (jSONObjectOptJSONObject == null || (strL = i0.L(i3)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject(strL);
    }

    public i(JSONObject jSONObject, String str, String str2, String str3) {
        this.f5983a = jSONObject;
        this.f5984b = str;
        this.f5985c = str2;
        this.f5986d = str3;
    }
}
