// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import androidx.recyclerview.widget.C0099q;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0099q f3729i = new C0099q(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f3732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f3735f;
    public l g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f3736h;

    public n(boolean z2) {
        C0099q c0099q = f3729i;
        this.f3733d = 0;
        this.f3734e = 0;
        this.f3730a = c0099q;
        this.f3731b = z2;
        this.f3735f = new m(z2);
    }

    public final m a(Object obj, boolean z2) {
        int iCompareTo;
        m mVar;
        m mVar2 = this.f3732c;
        C0099q c0099q = f3729i;
        Comparator comparator = this.f3730a;
        if (mVar2 != null) {
            Comparable comparable = comparator == c0099q ? (Comparable) obj : null;
            while (true) {
                Object obj2 = mVar2.f3726f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return mVar2;
                }
                m mVar3 = iCompareTo < 0 ? mVar2.f3722b : mVar2.f3723c;
                if (mVar3 == null) {
                    break;
                }
                mVar2 = mVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        m mVar4 = this.f3735f;
        if (mVar2 != null) {
            mVar = new m(this.f3731b, mVar2, obj, mVar4, mVar4.f3725e);
            if (iCompareTo < 0) {
                mVar2.f3722b = mVar;
            } else {
                mVar2.f3723c = mVar;
            }
            b(mVar2, true);
        } else {
            if (comparator == c0099q && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            mVar = new m(this.f3731b, mVar2, obj, mVar4, mVar4.f3725e);
            this.f3732c = mVar;
        }
        this.f3733d++;
        this.f3734e++;
        return mVar;
    }

    public final void b(m mVar, boolean z2) {
        while (mVar != null) {
            m mVar2 = mVar.f3722b;
            m mVar3 = mVar.f3723c;
            int i2 = mVar2 != null ? mVar2.f3728i : 0;
            int i3 = mVar3 != null ? mVar3.f3728i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                m mVar4 = mVar3.f3722b;
                m mVar5 = mVar3.f3723c;
                int i5 = (mVar4 != null ? mVar4.f3728i : 0) - (mVar5 != null ? mVar5.f3728i : 0);
                if (i5 == -1 || (i5 == 0 && !z2)) {
                    e(mVar);
                } else {
                    f(mVar3);
                    e(mVar);
                }
                if (z2) {
                    return;
                }
            } else if (i4 == 2) {
                m mVar6 = mVar2.f3722b;
                m mVar7 = mVar2.f3723c;
                int i6 = (mVar6 != null ? mVar6.f3728i : 0) - (mVar7 != null ? mVar7.f3728i : 0);
                if (i6 == 1 || (i6 == 0 && !z2)) {
                    f(mVar);
                } else {
                    e(mVar2);
                    f(mVar);
                }
                if (z2) {
                    return;
                }
            } else if (i4 == 0) {
                mVar.f3728i = i2 + 1;
                if (z2) {
                    return;
                }
            } else {
                mVar.f3728i = Math.max(i2, i3) + 1;
                if (!z2) {
                    return;
                }
            }
            mVar = mVar.f3721a;
        }
    }

    public final void c(m mVar, boolean z2) {
        m mVar2;
        m mVar3;
        int i2;
        if (z2) {
            m mVar4 = mVar.f3725e;
            mVar4.f3724d = mVar.f3724d;
            mVar.f3724d.f3725e = mVar4;
        }
        m mVar5 = mVar.f3722b;
        m mVar6 = mVar.f3723c;
        m mVar7 = mVar.f3721a;
        int i3 = 0;
        if (mVar5 == null || mVar6 == null) {
            if (mVar5 != null) {
                d(mVar, mVar5);
                mVar.f3722b = null;
            } else if (mVar6 != null) {
                d(mVar, mVar6);
                mVar.f3723c = null;
            } else {
                d(mVar, null);
            }
            b(mVar7, false);
            this.f3733d--;
            this.f3734e++;
            return;
        }
        if (mVar5.f3728i > mVar6.f3728i) {
            m mVar8 = mVar5.f3723c;
            while (true) {
                m mVar9 = mVar8;
                mVar3 = mVar5;
                mVar5 = mVar9;
                if (mVar5 == null) {
                    break;
                } else {
                    mVar8 = mVar5.f3723c;
                }
            }
        } else {
            m mVar10 = mVar6.f3722b;
            while (true) {
                mVar2 = mVar6;
                mVar6 = mVar10;
                if (mVar6 == null) {
                    break;
                } else {
                    mVar10 = mVar6.f3722b;
                }
            }
            mVar3 = mVar2;
        }
        c(mVar3, false);
        m mVar11 = mVar.f3722b;
        if (mVar11 != null) {
            i2 = mVar11.f3728i;
            mVar3.f3722b = mVar11;
            mVar11.f3721a = mVar3;
            mVar.f3722b = null;
        } else {
            i2 = 0;
        }
        m mVar12 = mVar.f3723c;
        if (mVar12 != null) {
            i3 = mVar12.f3728i;
            mVar3.f3723c = mVar12;
            mVar12.f3721a = mVar3;
            mVar.f3723c = null;
        }
        mVar3.f3728i = Math.max(i2, i3) + 1;
        d(mVar, mVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f3732c = null;
        this.f3733d = 0;
        this.f3734e++;
        m mVar = this.f3735f;
        mVar.f3725e = mVar;
        mVar.f3724d = mVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        m mVarA = null;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return mVarA != null;
    }

    public final void d(m mVar, m mVar2) {
        m mVar3 = mVar.f3721a;
        mVar.f3721a = null;
        if (mVar2 != null) {
            mVar2.f3721a = mVar3;
        }
        if (mVar3 == null) {
            this.f3732c = mVar2;
        } else if (mVar3.f3722b == mVar) {
            mVar3.f3722b = mVar2;
        } else {
            mVar3.f3723c = mVar2;
        }
    }

    public final void e(m mVar) {
        m mVar2 = mVar.f3722b;
        m mVar3 = mVar.f3723c;
        m mVar4 = mVar3.f3722b;
        m mVar5 = mVar3.f3723c;
        mVar.f3723c = mVar4;
        if (mVar4 != null) {
            mVar4.f3721a = mVar;
        }
        d(mVar, mVar3);
        mVar3.f3722b = mVar;
        mVar.f3721a = mVar3;
        int iMax = Math.max(mVar2 != null ? mVar2.f3728i : 0, mVar4 != null ? mVar4.f3728i : 0) + 1;
        mVar.f3728i = iMax;
        mVar3.f3728i = Math.max(iMax, mVar5 != null ? mVar5.f3728i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        l lVar = this.g;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.g = lVar2;
        return lVar2;
    }

    public final void f(m mVar) {
        m mVar2 = mVar.f3722b;
        m mVar3 = mVar.f3723c;
        m mVar4 = mVar2.f3722b;
        m mVar5 = mVar2.f3723c;
        mVar.f3722b = mVar5;
        if (mVar5 != null) {
            mVar5.f3721a = mVar;
        }
        d(mVar, mVar2);
        mVar2.f3723c = mVar;
        mVar.f3721a = mVar2;
        int iMax = Math.max(mVar3 != null ? mVar3.f3728i : 0, mVar5 != null ? mVar5.f3728i : 0) + 1;
        mVar.f3728i = iMax;
        mVar2.f3728i = Math.max(iMax, mVar4 != null ? mVar4.f3728i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
                mVarA = null;
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            return mVarA.f3727h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        l lVar = this.f3736h;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f3736h = lVar2;
        return lVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f3731b) {
            throw new NullPointerException("value == null");
        }
        m mVarA = a(obj, true);
        Object obj3 = mVarA.f3727h;
        mVarA.f3727h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
                mVarA = null;
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            c(mVarA, true);
        }
        if (mVarA != null) {
            return mVarA.f3727h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f3733d;
    }
}
