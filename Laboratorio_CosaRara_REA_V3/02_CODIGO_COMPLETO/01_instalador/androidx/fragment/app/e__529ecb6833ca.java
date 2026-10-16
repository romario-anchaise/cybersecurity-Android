// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.EnumC0076n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Q.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0121k f1546a;

    public e(AbstractActivityC0121k abstractActivityC0121k) {
        this.f1546a = abstractActivityC0121k;
    }

    @Override // Q.d
    public final Bundle a() {
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        Bundle bundle = new Bundle();
        this.f1546a.markFragmentsCreated();
        this.f1546a.mFragmentLifecycleRegistry.f(EnumC0076n.ON_STOP);
        s sVar = this.f1546a.mFragments.f1556a.f1550c;
        Iterator it = sVar.b().iterator();
        while (it.hasNext()) {
            ((c) it.next()).getClass();
        }
        Iterator it2 = sVar.b().iterator();
        t tVar = null;
        if (it2.hasNext()) {
            ((c) it2.next()).a();
            throw null;
        }
        sVar.e(true);
        sVar.f1587s = true;
        sVar.f1593y.getClass();
        H.s sVar2 = sVar.f1572c;
        sVar2.getClass();
        HashMap map = (HashMap) sVar2.f233c;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            if (it3.next() != null) {
                throw new ClassCastException();
            }
        }
        if (!arrayList2.isEmpty()) {
            H.s sVar3 = sVar.f1572c;
            synchronized (((ArrayList) sVar3.f232b)) {
                try {
                    if (((ArrayList) sVar3.f232b).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) sVar3.f232b).size());
                        Iterator it4 = ((ArrayList) sVar3.f232b).iterator();
                        if (it4.hasNext()) {
                            if (it4.next() == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList3 = sVar.f1573d;
            if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                bVarArr = null;
            } else {
                bVarArr = new b[size];
                for (int i2 = 0; i2 < size; i2++) {
                    bVarArr[i2] = new b((a) sVar.f1573d.get(i2));
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + sVar.f1573d.get(i2));
                    }
                }
            }
            t tVar2 = new t();
            tVar2.f1599e = null;
            ArrayList arrayList4 = new ArrayList();
            tVar2.f1600f = arrayList4;
            ArrayList arrayList5 = new ArrayList();
            tVar2.g = arrayList5;
            tVar2.f1595a = arrayList2;
            tVar2.f1596b = arrayList;
            tVar2.f1597c = bVarArr;
            tVar2.f1598d = sVar.f1576h.get();
            arrayList4.addAll(sVar.f1577i.keySet());
            arrayList5.addAll(sVar.f1577i.values());
            tVar2.f1601h = new ArrayList(sVar.f1586r);
            tVar = tVar2;
        } else if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        if (tVar != null) {
            bundle.putParcelable("android:support:fragments", tVar);
        }
        return bundle;
    }
}
