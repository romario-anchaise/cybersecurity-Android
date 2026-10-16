// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p021m.c;
import p021m.e;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3720b;

    public /* synthetic */ l(Map map, int i2) {
        this.f3719a = i2;
        this.f3720b = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f3719a) {
            case 0:
                ((n) this.f3720b).clear();
                break;
            case 1:
                ((n) this.f3720b).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        m mVarA;
        switch (this.f3719a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                n nVar = (n) this.f3720b;
                nVar.getClass();
                Object key = entry.getKey();
                m mVar = null;
                if (key != null) {
                    try {
                        mVarA = nVar.a(key, false);
                    } catch (ClassCastException unused) {
                        mVarA = null;
                    }
                    break;
                } else {
                    mVarA = null;
                }
                if (mVarA != null && Objects.equals(mVarA.f3727h, entry.getValue())) {
                    mVar = mVarA;
                }
                return mVar != null;
            case 1:
                return ((n) this.f3720b).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3719a) {
            case 0:
                return new k((n) this.f3720b, 0);
            case 1:
                return new k((n) this.f3720b, 1);
            default:
                return new c((e) this.f3720b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        m mVarA;
        switch (this.f3719a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                n nVar = (n) this.f3720b;
                nVar.getClass();
                Object key = entry.getKey();
                m mVar = null;
                if (key != null) {
                    try {
                        mVarA = nVar.a(key, false);
                    } catch (ClassCastException unused) {
                        mVarA = null;
                    }
                    break;
                } else {
                    mVarA = null;
                }
                if (mVarA != null && Objects.equals(mVarA.f3727h, entry.getValue())) {
                    mVar = mVarA;
                }
                if (mVar == null) {
                    return false;
                }
                nVar.c(mVar, true);
                return true;
            case 1:
                n nVar2 = (n) this.f3720b;
                nVar2.getClass();
                m mVarA2 = null;
                if (obj != null) {
                    try {
                        mVarA2 = nVar2.a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (mVarA2 != null) {
                    nVar2.c(mVarA2, true);
                }
                return mVarA2 != null;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f3719a) {
            case 0:
                return ((n) this.f3720b).f3733d;
            case 1:
                return ((n) this.f3720b).f3733d;
            default:
                return ((e) this.f3720b).f3689c;
        }
    }
}
