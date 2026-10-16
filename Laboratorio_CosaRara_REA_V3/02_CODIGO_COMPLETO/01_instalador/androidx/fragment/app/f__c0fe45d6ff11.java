// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.EnumC0077o;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class f implements p000a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0121k f1547a;

    public f(AbstractActivityC0121k abstractActivityC0121k) {
        this.f1547a = abstractActivityC0121k;
    }

    @Override // p000a.b
    public final void a(androidx.activity.i iVar) {
        AbstractActivityC0121k abstractActivityC0121k = this.f1547a;
        g gVar = abstractActivityC0121k.mFragments.f1556a;
        s sVar = gVar.f1550c;
        if (sVar.f1580l != null) {
            throw new IllegalStateException("Already attached");
        }
        sVar.f1580l = gVar;
        sVar.f1581m = gVar;
        sVar.f1578j.add(gVar);
        AbstractActivityC0121k abstractActivityC0121k2 = gVar.f1551d;
        androidx.activity.o onBackPressedDispatcher = abstractActivityC0121k2.getOnBackPressedDispatcher();
        sVar.f1575f = onBackPressedDispatcher;
        onBackPressedDispatcher.getClass();
        androidx.lifecycle.w wVar = abstractActivityC0121k2.mFragmentLifecycleRegistry;
        if (wVar.f1692c != EnumC0077o.f1681a) {
            m mVar = sVar.g;
            mVar.f1561b.add(new androidx.activity.m(onBackPressedDispatcher, wVar, mVar));
            if (p039w.b.a()) {
                onBackPressedDispatcher.b();
                mVar.f1562c = onBackPressedDispatcher.f1262c;
            }
        }
        C.h hVar = new C.h(abstractActivityC0121k2.getViewModelStore(), u.g);
        String canonicalName = u.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        sVar.f1593y = (u) hVar.j("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), u.class);
        sVar.f1572c.getClass();
        g gVar2 = sVar.f1580l;
        if (gVar2 != null) {
            p002b.i activityResultRegistry = gVar2.f1551d.getActivityResultRegistry();
            sVar.f1583o = activityResultRegistry.b("FragmentManager:StartActivityForResult", new p(2), new l(sVar, 2));
            sVar.f1584p = activityResultRegistry.b("FragmentManager:StartIntentSenderForResult", new p(0), new l(sVar, 0));
            sVar.f1585q = activityResultRegistry.b("FragmentManager:RequestPermissions", new p(1), new l(sVar, 1));
        }
        Bundle bundleA = abstractActivityC0121k.getSavedStateRegistry().a("android:support:fragments");
        if (bundleA != null) {
            Parcelable parcelable = bundleA.getParcelable("android:support:fragments");
            s sVar2 = abstractActivityC0121k.mFragments.f1556a.f1550c;
            sVar2.getClass();
            if (parcelable == null) {
                return;
            }
            t tVar = (t) parcelable;
            if (tVar.f1595a == null) {
                return;
            }
            H.s sVar3 = sVar2.f1572c;
            ((HashMap) sVar3.f233c).clear();
            for (v vVar : tVar.f1595a) {
                if (vVar != null) {
                    if (sVar2.f1593y.f1602d.get(vVar.f1606b) != null) {
                        throw new ClassCastException();
                    }
                    ClassLoader classLoader = sVar2.f1580l.f1548a.getClassLoader();
                    sVar2.f1582n.a(vVar.f1605a);
                    Bundle bundle = vVar.f1613j;
                    if (bundle == null) {
                        throw null;
                    }
                    bundle.setClassLoader(classLoader);
                    throw null;
                }
            }
            u uVar = sVar2.f1593y;
            uVar.getClass();
            Iterator it = new ArrayList(uVar.f1602d.values()).iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            ArrayList arrayList = tVar.f1596b;
            ((ArrayList) sVar3.f232b).clear();
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    String str = (String) it2.next();
                    y.a(((HashMap) sVar3.f233c).get(str));
                    throw new IllegalStateException(F0.h.e("No instantiated fragment for (", str, ")"));
                }
            }
            if (tVar.f1597c != null) {
                sVar2.f1573d = new ArrayList(tVar.f1597c.length);
                int i2 = 0;
                while (true) {
                    b[] bVarArr = tVar.f1597c;
                    if (i2 >= bVarArr.length) {
                        break;
                    }
                    b bVar = bVarArr[i2];
                    bVar.getClass();
                    a aVar = new a(sVar2);
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int[] iArr = bVar.f1533a;
                        if (i3 >= iArr.length) {
                            break;
                        }
                        w wVar2 = new w();
                        int i5 = i3 + 1;
                        wVar2.f1617a = iArr[i3];
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i4 + " base fragment #" + iArr[i5]);
                        }
                        String str2 = (String) bVar.f1534b.get(i4);
                        if (str2 != null) {
                            y.a(((HashMap) sVar3.f233c).get(str2));
                        }
                        wVar2.f1622f = EnumC0077o.values()[bVar.f1535c[i4]];
                        wVar2.g = EnumC0077o.values()[bVar.f1536d[i4]];
                        int i6 = iArr[i5];
                        wVar2.f1618b = i6;
                        int i7 = iArr[i3 + 2];
                        wVar2.f1619c = i7;
                        int i8 = i3 + 4;
                        int i9 = iArr[i3 + 3];
                        wVar2.f1620d = i9;
                        i3 += 5;
                        int i10 = iArr[i8];
                        wVar2.f1621e = i10;
                        aVar.f1518b = i6;
                        aVar.f1519c = i7;
                        aVar.f1520d = i9;
                        aVar.f1521e = i10;
                        aVar.f1517a.add(wVar2);
                        wVar2.f1618b = aVar.f1518b;
                        wVar2.f1619c = aVar.f1519c;
                        wVar2.f1620d = aVar.f1520d;
                        wVar2.f1621e = aVar.f1521e;
                        i4++;
                    }
                    aVar.f1522f = bVar.f1537e;
                    aVar.f1523h = bVar.f1538f;
                    aVar.f1532q = bVar.g;
                    aVar.g = true;
                    aVar.f1524i = bVar.f1539h;
                    aVar.f1525j = bVar.f1540i;
                    aVar.f1526k = bVar.f1541j;
                    aVar.f1527l = bVar.f1542k;
                    aVar.f1528m = bVar.f1543l;
                    aVar.f1529n = bVar.f1544m;
                    aVar.f1530o = bVar.f1545n;
                    aVar.a(1);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVar.f1532q + "): " + aVar);
                        PrintWriter printWriter = new PrintWriter(new x());
                        aVar.b("  ", printWriter, false);
                        printWriter.close();
                    }
                    sVar2.f1573d.add(aVar);
                    i2++;
                }
            } else {
                sVar2.f1573d = null;
            }
            sVar2.f1576h.set(tVar.f1598d);
            String str3 = tVar.f1599e;
            if (str3 != null) {
                y.a(((HashMap) sVar3.f233c).get(str3));
            }
            ArrayList arrayList2 = tVar.f1600f;
            if (arrayList2 != null) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    Bundle bundle2 = (Bundle) tVar.g.get(i11);
                    bundle2.setClassLoader(sVar2.f1580l.f1548a.getClassLoader());
                    sVar2.f1577i.put(arrayList2.get(i11), bundle2);
                }
            }
            sVar2.f1586r = new ArrayDeque(tVar.f1601h);
        }
    }
}
