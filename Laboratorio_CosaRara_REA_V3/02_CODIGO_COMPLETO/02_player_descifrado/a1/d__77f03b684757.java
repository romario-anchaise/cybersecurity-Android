// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import e2.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import w1.l8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f42d;

    public d(int i3) {
        switch (i3) {
            case 3:
                this.f42d = new IdentityHashMap();
                break;
            default:
                this.f42d = new l8[10];
                break;
        }
    }

    @Override // a1.e
    public void a(Object obj) {
        StringBuilder sb = (StringBuilder) this.f42d;
        sb.append((String) obj);
        if (this.f41c) {
            return;
        }
        sb.append((char) 30);
    }

    public y1 b(ArrayList arrayList) {
        int i3;
        l8[] l8VarArr = (l8[]) this.f42d;
        l8[] l8VarArr2 = new l8[10];
        int i4 = 0;
        while (true) {
            if (i4 >= arrayList.size()) {
                break;
            }
            l8 l8Var = (l8) arrayList.get(i4);
            if (l8Var != null && (i3 = l8Var.f4456a) >= 1 && i3 <= 9) {
                l8VarArr2[i3] = l8Var;
            }
            i4++;
        }
        if (!this.f41c) {
            for (int i5 = 0; i5 < l8VarArr.length; i5++) {
                l8VarArr[i5] = l8VarArr2[i5];
            }
            this.f41c = true;
            List list = Collections.EMPTY_LIST;
            return new y1(list, list, list, false);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 1; i6 <= 9; i6++) {
            l8 l8Var2 = l8VarArr2[i6];
            l8 l8Var3 = l8VarArr[i6];
            if (l8Var2 != null) {
                if ((l8Var2.f4460e || l8Var2.f4461f || l8Var2.f4462g || l8Var2.f4463h) && (l8Var3 == null || (!l8Var3.f4460e && !l8Var3.f4461f && !l8Var3.f4462g && !l8Var3.f4463h))) {
                    arrayList3.add(Integer.valueOf(i6));
                }
                if (l8Var3 != null && (!l8Var2.f4457b.equals(l8Var3.f4457b) || !l8Var2.f4458c.equals(l8Var3.f4458c) || !l8Var2.f4459d.equals(l8Var3.f4459d))) {
                    arrayList2.add(Integer.valueOf(i6));
                }
            }
        }
        for (int i7 = 0; i7 < l8VarArr.length; i7++) {
            l8VarArr[i7] = l8VarArr2[i7];
        }
        boolean z2 = arrayList2.size() >= 6;
        HashSet hashSet = new HashSet(arrayList3);
        if (!z2) {
            hashSet.addAll(arrayList2);
        }
        if (hashSet.isEmpty()) {
            return new y1(Collections.EMPTY_LIST, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList3), z2);
        }
        ArrayList arrayList4 = new ArrayList();
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            l8 l8Var4 = (l8) arrayList.get(i8);
            if (l8Var4 != null) {
                int i9 = l8Var4.f4456a;
                if (hashSet.contains(Integer.valueOf(i9)) && !arrayList4.contains(Integer.valueOf(i9))) {
                    arrayList4.add(Integer.valueOf(i9));
                }
            }
        }
        return new y1(Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList3), z2);
    }

    public void c() {
        synchronized (this) {
            try {
                if (this.f41c) {
                    return;
                }
                this.f41c = true;
                ArrayList arrayList = new ArrayList(((IdentityHashMap) this.f42d).values());
                ((IdentityHashMap) this.f42d).clear();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    try {
                        ((Runnable) obj).run();
                    } catch (RuntimeException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ d(Object obj, boolean z2) {
        this.f42d = obj;
        this.f41c = z2;
    }
}
