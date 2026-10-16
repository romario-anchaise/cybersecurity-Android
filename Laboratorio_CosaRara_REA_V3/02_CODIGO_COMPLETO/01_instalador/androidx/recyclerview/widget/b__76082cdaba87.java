// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import X0.C0062i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p015j.AbstractC0167q0;
import p015j.C0171t;

/* JADX INFO: renamed from: androidx.recyclerview.widget.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0084b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1896f;

    public C0084b(View view) {
        this.f1891a = -1;
        this.f1892b = view;
        this.f1893c = C0171t.a();
    }

    public void a() {
        View view = (View) this.f1892b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((C0062i) this.f1894d) != null) {
                if (((C0062i) this.f1896f) == null) {
                    this.f1896f = new C0062i();
                }
                C0062i c0062i = (C0062i) this.f1896f;
                c0062i.f985c = null;
                c0062i.f984b = false;
                c0062i.f986d = null;
                c0062i.f983a = false;
                WeakHashMap weakHashMap = A.X.f14a;
                ColorStateList colorStateListG = A.L.g(view);
                if (colorStateListG != null) {
                    c0062i.f984b = true;
                    c0062i.f985c = colorStateListG;
                }
                PorterDuff.Mode modeH = A.L.h(view);
                if (modeH != null) {
                    c0062i.f983a = true;
                    c0062i.f986d = modeH;
                }
                if (c0062i.f984b || c0062i.f983a) {
                    C0171t.d(background, c0062i, view.getDrawableState());
                    return;
                }
            }
            C0062i c0062i2 = (C0062i) this.f1895e;
            if (c0062i2 != null) {
                C0171t.d(background, c0062i2, view.getDrawableState());
                return;
            }
            C0062i c0062i3 = (C0062i) this.f1894d;
            if (c0062i3 != null) {
                C0171t.d(background, c0062i3, view.getDrawableState());
            }
        }
    }

    public boolean b(int i2) {
        ArrayList arrayList = (ArrayList) this.f1894d;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0083a c0083a = (C0083a) arrayList.get(i3);
            int i4 = c0083a.f1887a;
            if (i4 == 8) {
                if (g(c0083a.f1890d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = c0083a.f1888b;
                int i6 = c0083a.f1890d + i5;
                while (i5 < i6) {
                    if (g(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.f1894d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((D) this.f1895e).a((C0083a) arrayList.get(i2));
        }
        q(arrayList);
        this.f1891a = 0;
    }

    public void d() {
        c();
        ArrayList arrayList = (ArrayList) this.f1893c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0083a c0083a = (C0083a) arrayList.get(i2);
            int i3 = c0083a.f1887a;
            D d2 = (D) this.f1895e;
            if (i3 == 1) {
                d2.a(c0083a);
                d2.d(c0083a.f1888b, c0083a.f1890d);
            } else if (i3 == 2) {
                d2.a(c0083a);
                int i4 = c0083a.f1888b;
                int i5 = c0083a.f1890d;
                RecyclerView recyclerView = d2.f1703a;
                recyclerView.N(i4, i5, true);
                recyclerView.f1804i0 = true;
                recyclerView.f1799f0.f1876b += i5;
            } else if (i3 == 4) {
                d2.a(c0083a);
                d2.c(c0083a.f1888b, c0083a.f1890d, c0083a.f1889c);
            } else if (i3 == 8) {
                d2.a(c0083a);
                d2.e(c0083a.f1888b, c0083a.f1890d);
            }
        }
        q(arrayList);
        this.f1891a = 0;
    }

    public void e(C0083a c0083a) {
        int i2;
        int i3 = c0083a.f1887a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iU = u(c0083a.f1888b, i3);
        int i4 = c0083a.f1888b;
        int i5 = c0083a.f1887a;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0083a);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < c0083a.f1890d; i7++) {
            int iU2 = u((i2 * i7) + c0083a.f1888b, c0083a.f1887a);
            int i8 = c0083a.f1887a;
            if (i8 == 2 ? iU2 != iU : !(i8 == 4 && iU2 == iU + 1)) {
                C0083a c0083aL = l(c0083a.f1889c, i8, iU, i6);
                f(c0083aL, i4);
                c0083aL.f1889c = null;
                ((b1.p) this.f1892b).e(c0083aL);
                if (c0083a.f1887a == 4) {
                    i4 += i6;
                }
                i6 = 1;
                iU = iU2;
            } else {
                i6++;
            }
        }
        Object obj = c0083a.f1889c;
        c0083a.f1889c = null;
        ((b1.p) this.f1892b).e(c0083a);
        if (i6 > 0) {
            C0083a c0083aL2 = l(obj, c0083a.f1887a, iU, i6);
            f(c0083aL2, i4);
            c0083aL2.f1889c = null;
            ((b1.p) this.f1892b).e(c0083aL2);
        }
    }

    public void f(C0083a c0083a, int i2) {
        D d2 = (D) this.f1895e;
        d2.a(c0083a);
        int i3 = c0083a.f1887a;
        if (i3 != 2) {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            d2.c(i2, c0083a.f1890d, c0083a.f1889c);
        } else {
            int i4 = c0083a.f1890d;
            RecyclerView recyclerView = d2.f1703a;
            recyclerView.N(i2, i4, true);
            recyclerView.f1804i0 = true;
            recyclerView.f1799f0.f1876b += i4;
        }
    }

    public int g(int i2, int i3) {
        ArrayList arrayList = (ArrayList) this.f1894d;
        int size = arrayList.size();
        while (i3 < size) {
            C0083a c0083a = (C0083a) arrayList.get(i3);
            int i4 = c0083a.f1887a;
            if (i4 == 8) {
                int i5 = c0083a.f1888b;
                if (i5 == i2) {
                    i2 = c0083a.f1890d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (c0083a.f1890d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = c0083a.f1888b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = c0083a.f1890d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += c0083a.f1890d;
                }
            }
            i3++;
        }
        return i2;
    }

    public ColorStateList h() {
        C0062i c0062i = (C0062i) this.f1895e;
        if (c0062i != null) {
            return (ColorStateList) c0062i.f985c;
        }
        return null;
    }

    public PorterDuff.Mode i() {
        C0062i c0062i = (C0062i) this.f1895e;
        if (c0062i != null) {
            return (PorterDuff.Mode) c0062i.f986d;
        }
        return null;
    }

    public boolean j() {
        return ((ArrayList) this.f1893c).size() > 0;
    }

    public void k(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListF;
        View view = (View) this.f1892b;
        Context context = view.getContext();
        int[] iArr = p007e.a.f2250z;
        C.h hVarP = C.h.p(context, attributeSet, iArr, i2);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        View view2 = (View) this.f1892b;
        A.X.g(view2, view2.getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, i2);
        try {
            if (typedArray.hasValue(0)) {
                this.f1891a = typedArray.getResourceId(0, -1);
                C0171t c0171t = (C0171t) this.f1893c;
                Context context2 = view.getContext();
                int i3 = this.f1891a;
                synchronized (c0171t) {
                    colorStateListF = c0171t.f3302a.f(context2, i3);
                }
                if (colorStateListF != null) {
                    r(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                A.L.q(view, hVarP.k(1));
            }
            if (typedArray.hasValue(2)) {
                A.L.r(view, AbstractC0167q0.b(typedArray.getInt(2, -1), null));
            }
            hVarP.r();
        } catch (Throwable th) {
            hVarP.r();
            throw th;
        }
    }

    public C0083a l(Object obj, int i2, int i3, int i4) {
        C0083a c0083a = (C0083a) ((b1.p) this.f1892b).a();
        if (c0083a != null) {
            c0083a.f1887a = i2;
            c0083a.f1888b = i3;
            c0083a.f1890d = i4;
            c0083a.f1889c = obj;
            return c0083a;
        }
        C0083a c0083a2 = new C0083a();
        c0083a2.f1887a = i2;
        c0083a2.f1888b = i3;
        c0083a2.f1890d = i4;
        c0083a2.f1889c = obj;
        return c0083a2;
    }

    public void m() {
        this.f1891a = -1;
        r(null);
        a();
    }

    public void n(int i2) {
        ColorStateList colorStateListF;
        this.f1891a = i2;
        C0171t c0171t = (C0171t) this.f1893c;
        if (c0171t != null) {
            Context context = ((View) this.f1892b).getContext();
            synchronized (c0171t) {
                colorStateListF = c0171t.f3302a.f(context, i2);
            }
        } else {
            colorStateListF = null;
        }
        r(colorStateListF);
        a();
    }

    public void o(C0083a c0083a) {
        ((ArrayList) this.f1894d).add(c0083a);
        int i2 = c0083a.f1887a;
        D d2 = (D) this.f1895e;
        if (i2 == 1) {
            d2.d(c0083a.f1888b, c0083a.f1890d);
            return;
        }
        if (i2 == 2) {
            int i3 = c0083a.f1888b;
            int i4 = c0083a.f1890d;
            RecyclerView recyclerView = d2.f1703a;
            recyclerView.N(i3, i4, false);
            recyclerView.f1804i0 = true;
            return;
        }
        if (i2 == 4) {
            d2.c(c0083a.f1888b, c0083a.f1890d, c0083a.f1889c);
        } else if (i2 == 8) {
            d2.e(c0083a.f1888b, c0083a.f1890d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0083a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x018f  */
    /* JADX WARN: Code duplicated, block: B:104:0x019d  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:184:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x000d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x000d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:33:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x0090  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:76:0x0137  */
    /* JADX WARN: Code duplicated, block: B:77:0x0139  */
    /* JADX WARN: Code duplicated, block: B:79:0x013f  */
    /* JADX WARN: Code duplicated, block: B:82:0x014a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0155  */
    /* JADX WARN: Code duplicated, block: B:88:0x0160  */
    /* JADX WARN: Code duplicated, block: B:89:0x0166  */
    /* JADX WARN: Code duplicated, block: B:90:0x0168  */
    /* JADX WARN: Code duplicated, block: B:92:0x016e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0179  */
    /* JADX WARN: Code duplicated, block: B:98:0x0184  */
    public void p() {
        byte b2;
        boolean z2;
        byte b3;
        C0083a c0083aL;
        int i2;
        int i3;
        int i4;
        C0083a c0083aL2;
        boolean z3;
        boolean z4;
        C0083a c0083aL3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList = (ArrayList) this.f1893c;
        L l2 = (L) this.f1896f;
        l2.getClass();
        while (true) {
            int size = arrayList.size() - 1;
            boolean z5 = false;
            while (true) {
                b2 = -1;
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((C0083a) arrayList.get(size)).f1887a != 8) {
                    z5 = true;
                } else if (z5) {
                    break;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i13 = size + 1;
            C0083a c0083a = (C0083a) arrayList.get(size);
            C0083a c0083a2 = (C0083a) arrayList.get(i13);
            int i14 = c0083a2.f1887a;
            if (i14 != 1) {
                C0084b c0084b = (C0084b) l2.f1721b;
                if (i14 == 2) {
                    int i15 = c0083a.f1888b;
                    int i16 = c0083a.f1890d;
                    if (i15 < i16) {
                        z4 = c0083a2.f1888b == i15 && c0083a2.f1890d == i16 - i15;
                        z3 = false;
                    } else if (c0083a2.f1888b == i16 + 1 && c0083a2.f1890d == i15 - i16) {
                        z4 = true;
                        z3 = true;
                    } else {
                        z3 = true;
                        z4 = false;
                    }
                    int i17 = c0083a2.f1888b;
                    if (i16 < i17) {
                        c0083a2.f1888b = i17 - 1;
                    } else {
                        int i18 = c0083a2.f1890d;
                        if (i16 < i17 + i18) {
                            c0083a2.f1890d = i18 - 1;
                            c0083a.f1887a = 2;
                            c0083a.f1890d = 1;
                            if (c0083a2.f1890d == 0) {
                                arrayList.remove(i13);
                                c0084b.getClass();
                                c0083a2.f1889c = null;
                                ((b1.p) c0084b.f1892b).e(c0083a2);
                            }
                        }
                    }
                    int i19 = c0083a.f1888b;
                    int i20 = c0083a2.f1888b;
                    if (i19 <= i20) {
                        c0083a2.f1888b = i20 + 1;
                    } else {
                        int i21 = i20 + c0083a2.f1890d;
                        if (i19 < i21) {
                            c0083aL3 = c0084b.l(null, 2, i19 + 1, i21 - i19);
                            c0083a2.f1890d = c0083a.f1888b - c0083a2.f1888b;
                        }
                        if (z4) {
                            arrayList.set(size, c0083a2);
                            arrayList.remove(i13);
                            c0084b.getClass();
                            c0083a.f1889c = null;
                            ((b1.p) c0084b.f1892b).e(c0083a);
                        } else {
                            if (z3) {
                                if (c0083aL3 != null) {
                                    i11 = c0083a.f1888b;
                                    if (i11 > c0083aL3.f1888b) {
                                        c0083a.f1888b = i11 - c0083aL3.f1890d;
                                    }
                                    i12 = c0083a.f1890d;
                                    if (i12 > c0083aL3.f1888b) {
                                        c0083a.f1890d = i12 - c0083aL3.f1890d;
                                    }
                                }
                                i9 = c0083a.f1888b;
                                if (i9 > c0083a2.f1888b) {
                                    c0083a.f1888b = i9 - c0083a2.f1890d;
                                }
                                i10 = c0083a.f1890d;
                                if (i10 > c0083a2.f1888b) {
                                    c0083a.f1890d = i10 - c0083a2.f1890d;
                                }
                            } else {
                                if (c0083aL3 != null) {
                                    i7 = c0083a.f1888b;
                                    if (i7 >= c0083aL3.f1888b) {
                                        c0083a.f1888b = i7 - c0083aL3.f1890d;
                                    }
                                    i8 = c0083a.f1890d;
                                    if (i8 >= c0083aL3.f1888b) {
                                        c0083a.f1890d = i8 - c0083aL3.f1890d;
                                    }
                                }
                                i5 = c0083a.f1888b;
                                if (i5 >= c0083a2.f1888b) {
                                    c0083a.f1888b = i5 - c0083a2.f1890d;
                                }
                                i6 = c0083a.f1890d;
                                if (i6 >= c0083a2.f1888b) {
                                    c0083a.f1890d = i6 - c0083a2.f1890d;
                                }
                            }
                            arrayList.set(size, c0083a2);
                            if (c0083a.f1888b != c0083a.f1890d) {
                                arrayList.set(i13, c0083a);
                            } else {
                                arrayList.remove(i13);
                            }
                            if (c0083aL3 != null) {
                                arrayList.add(size, c0083aL3);
                            }
                        }
                    }
                    c0083aL3 = null;
                    if (z4) {
                        arrayList.set(size, c0083a2);
                        arrayList.remove(i13);
                        c0084b.getClass();
                        c0083a.f1889c = null;
                        ((b1.p) c0084b.f1892b).e(c0083a);
                    } else {
                        if (z3) {
                            if (c0083aL3 != null) {
                                i11 = c0083a.f1888b;
                                if (i11 > c0083aL3.f1888b) {
                                    c0083a.f1888b = i11 - c0083aL3.f1890d;
                                }
                                i12 = c0083a.f1890d;
                                if (i12 > c0083aL3.f1888b) {
                                    c0083a.f1890d = i12 - c0083aL3.f1890d;
                                }
                            }
                            i9 = c0083a.f1888b;
                            if (i9 > c0083a2.f1888b) {
                                c0083a.f1888b = i9 - c0083a2.f1890d;
                            }
                            i10 = c0083a.f1890d;
                            if (i10 > c0083a2.f1888b) {
                                c0083a.f1890d = i10 - c0083a2.f1890d;
                            }
                        } else {
                            if (c0083aL3 != null) {
                                i7 = c0083a.f1888b;
                                if (i7 >= c0083aL3.f1888b) {
                                    c0083a.f1888b = i7 - c0083aL3.f1890d;
                                }
                                i8 = c0083a.f1890d;
                                if (i8 >= c0083aL3.f1888b) {
                                    c0083a.f1890d = i8 - c0083aL3.f1890d;
                                }
                            }
                            i5 = c0083a.f1888b;
                            if (i5 >= c0083a2.f1888b) {
                                c0083a.f1888b = i5 - c0083a2.f1890d;
                            }
                            i6 = c0083a.f1890d;
                            if (i6 >= c0083a2.f1888b) {
                                c0083a.f1890d = i6 - c0083a2.f1890d;
                            }
                        }
                        arrayList.set(size, c0083a2);
                        if (c0083a.f1888b != c0083a.f1890d) {
                            arrayList.set(i13, c0083a);
                        } else {
                            arrayList.remove(i13);
                        }
                        if (c0083aL3 != null) {
                            arrayList.add(size, c0083aL3);
                        }
                    }
                } else if (i14 == 4) {
                    int i22 = c0083a.f1890d;
                    int i23 = c0083a2.f1888b;
                    if (i22 < i23) {
                        c0083a2.f1888b = i23 - 1;
                    } else {
                        int i24 = c0083a2.f1890d;
                        if (i22 < i23 + i24) {
                            c0083a2.f1890d = i24 - 1;
                            c0083aL = c0084b.l(c0083a2.f1889c, 4, c0083a.f1888b, 1);
                        }
                        i2 = c0083a.f1888b;
                        i3 = c0083a2.f1888b;
                        if (i2 <= i3) {
                            c0083a2.f1888b = i3 + 1;
                        } else {
                            i4 = i3 + c0083a2.f1890d;
                            if (i2 < i4) {
                                int i25 = i4 - i2;
                                c0083aL2 = c0084b.l(c0083a2.f1889c, 4, i2 + 1, i25);
                                c0083a2.f1890d -= i25;
                            }
                            arrayList.set(i13, c0083a);
                            if (c0083a2.f1890d > 0) {
                                arrayList.set(size, c0083a2);
                            } else {
                                arrayList.remove(size);
                                c0084b.getClass();
                                c0083a2.f1889c = null;
                                ((b1.p) c0084b.f1892b).e(c0083a2);
                            }
                            if (c0083aL != null) {
                                arrayList.add(size, c0083aL);
                            }
                            if (c0083aL2 != null) {
                                arrayList.add(size, c0083aL2);
                            }
                        }
                        c0083aL2 = null;
                        arrayList.set(i13, c0083a);
                        if (c0083a2.f1890d > 0) {
                            arrayList.set(size, c0083a2);
                        } else {
                            arrayList.remove(size);
                            c0084b.getClass();
                            c0083a2.f1889c = null;
                            ((b1.p) c0084b.f1892b).e(c0083a2);
                        }
                        if (c0083aL != null) {
                            arrayList.add(size, c0083aL);
                        }
                        if (c0083aL2 != null) {
                            arrayList.add(size, c0083aL2);
                        }
                    }
                    c0083aL = null;
                    i2 = c0083a.f1888b;
                    i3 = c0083a2.f1888b;
                    if (i2 <= i3) {
                        c0083a2.f1888b = i3 + 1;
                    } else {
                        i4 = i3 + c0083a2.f1890d;
                        if (i2 < i4) {
                            int i26 = i4 - i2;
                            c0083aL2 = c0084b.l(c0083a2.f1889c, 4, i2 + 1, i26);
                            c0083a2.f1890d -= i26;
                        }
                        arrayList.set(i13, c0083a);
                        if (c0083a2.f1890d > 0) {
                            arrayList.set(size, c0083a2);
                        } else {
                            arrayList.remove(size);
                            c0084b.getClass();
                            c0083a2.f1889c = null;
                            ((b1.p) c0084b.f1892b).e(c0083a2);
                        }
                        if (c0083aL != null) {
                            arrayList.add(size, c0083aL);
                        }
                        if (c0083aL2 != null) {
                            arrayList.add(size, c0083aL2);
                        }
                    }
                    c0083aL2 = null;
                    arrayList.set(i13, c0083a);
                    if (c0083a2.f1890d > 0) {
                        arrayList.set(size, c0083a2);
                    } else {
                        arrayList.remove(size);
                        c0084b.getClass();
                        c0083a2.f1889c = null;
                        ((b1.p) c0084b.f1892b).e(c0083a2);
                    }
                    if (c0083aL != null) {
                        arrayList.add(size, c0083aL);
                    }
                    if (c0083aL2 != null) {
                        arrayList.add(size, c0083aL2);
                    }
                }
            } else {
                int i27 = c0083a.f1890d;
                int i28 = c0083a2.f1888b;
                int i29 = i27 < i28 ? -1 : 0;
                int i30 = c0083a.f1888b;
                if (i30 < i28) {
                    i29++;
                }
                if (i28 <= i30) {
                    c0083a.f1888b = i30 + c0083a2.f1890d;
                }
                int i31 = c0083a2.f1888b;
                if (i31 <= i27) {
                    c0083a.f1890d = i27 + c0083a2.f1890d;
                }
                c0083a2.f1888b = i31 + i29;
                arrayList.set(size, c0083a2);
                arrayList.set(i13, c0083a);
            }
        }
        int size2 = arrayList.size();
        int i32 = 0;
        while (i32 < size2) {
            C0083a c0083aL4 = (C0083a) arrayList.get(i32);
            int i33 = c0083aL4.f1887a;
            if (i33 != 1) {
                D d2 = (D) this.f1895e;
                if (i33 == 2) {
                    int i34 = c0083aL4.f1888b;
                    int i35 = c0083aL4.f1890d + i34;
                    int i36 = i34;
                    int i37 = 0;
                    byte b4 = -1;
                    while (i36 < i35) {
                        if (d2.b(i36) != null || b(i36)) {
                            if (b4 == 0) {
                                e(l(null, 2, i34, i37));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            b3 = 1;
                        } else {
                            if (b4 == 1) {
                                o(l(null, 2, i34, i37));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            b3 = 0;
                        }
                        if (z2) {
                            i36 -= i37;
                            i35 -= i37;
                            i37 = 1;
                        } else {
                            i37++;
                        }
                        i36++;
                        b4 = b3;
                    }
                    if (i37 != c0083aL4.f1890d) {
                        c0083aL4.f1889c = null;
                        ((b1.p) this.f1892b).e(c0083aL4);
                        c0083aL4 = l(null, 2, i34, i37);
                    }
                    if (b4 == 0) {
                        e(c0083aL4);
                    } else {
                        o(c0083aL4);
                    }
                } else if (i33 == 4) {
                    int i38 = c0083aL4.f1888b;
                    int i39 = c0083aL4.f1890d + i38;
                    int i40 = i38;
                    int i41 = 0;
                    while (i38 < i39) {
                        if (d2.b(i38) != null || b(i38)) {
                            if (b2 == 0) {
                                e(l(c0083aL4.f1889c, 4, i40, i41));
                                i40 = i38;
                                i41 = 0;
                            }
                            b2 = 1;
                        } else {
                            if (b2 == 1) {
                                o(l(c0083aL4.f1889c, 4, i40, i41));
                                i40 = i38;
                                i41 = 0;
                            }
                            b2 = 0;
                        }
                        i41++;
                        i38++;
                    }
                    if (i41 != c0083aL4.f1890d) {
                        Object obj = c0083aL4.f1889c;
                        c0083aL4.f1889c = null;
                        ((b1.p) this.f1892b).e(c0083aL4);
                        c0083aL4 = l(obj, 4, i40, i41);
                    }
                    if (b2 == 0) {
                        e(c0083aL4);
                    } else {
                        o(c0083aL4);
                    }
                } else if (i33 == 8) {
                    o(c0083aL4);
                }
            } else {
                o(c0083aL4);
            }
            i32++;
            b2 = -1;
        }
        arrayList.clear();
    }

    public void q(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0083a c0083a = (C0083a) arrayList.get(i2);
            c0083a.f1889c = null;
            ((b1.p) this.f1892b).e(c0083a);
        }
        arrayList.clear();
    }

    public void r(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((C0062i) this.f1894d) == null) {
                this.f1894d = new C0062i();
            }
            C0062i c0062i = (C0062i) this.f1894d;
            c0062i.f985c = colorStateList;
            c0062i.f984b = true;
        } else {
            this.f1894d = null;
        }
        a();
    }

    public void s(ColorStateList colorStateList) {
        if (((C0062i) this.f1895e) == null) {
            this.f1895e = new C0062i();
        }
        C0062i c0062i = (C0062i) this.f1895e;
        c0062i.f985c = colorStateList;
        c0062i.f984b = true;
        a();
    }

    public void t(PorterDuff.Mode mode) {
        if (((C0062i) this.f1895e) == null) {
            this.f1895e = new C0062i();
        }
        C0062i c0062i = (C0062i) this.f1895e;
        c0062i.f986d = mode;
        c0062i.f983a = true;
        a();
    }

    public int u(int i2, int i3) {
        int i4;
        int i5;
        ArrayList arrayList = (ArrayList) this.f1894d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0083a c0083a = (C0083a) arrayList.get(size);
            int i6 = c0083a.f1887a;
            if (i6 == 8) {
                int i7 = c0083a.f1888b;
                int i8 = c0083a.f1890d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            c0083a.f1888b = i7 + 1;
                            c0083a.f1890d = i8 + 1;
                        } else if (i3 == 2) {
                            c0083a.f1888b = i7 - 1;
                            c0083a.f1890d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        c0083a.f1890d = i8 + 1;
                    } else if (i3 == 2) {
                        c0083a.f1890d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        c0083a.f1888b = i7 + 1;
                    } else if (i3 == 2) {
                        c0083a.f1888b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = c0083a.f1888b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= c0083a.f1890d;
                    } else if (i6 == 2) {
                        i2 += c0083a.f1890d;
                    }
                } else if (i3 == 1) {
                    c0083a.f1888b = i9 + 1;
                } else if (i3 == 2) {
                    c0083a.f1888b = i9 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C0083a c0083a2 = (C0083a) arrayList.get(size2);
            if (c0083a2.f1887a == 8) {
                int i10 = c0083a2.f1890d;
                if (i10 == c0083a2.f1888b || i10 < 0) {
                    arrayList.remove(size2);
                    c0083a2.f1889c = null;
                    ((b1.p) this.f1892b).e(c0083a2);
                }
            } else if (c0083a2.f1890d <= 0) {
                arrayList.remove(size2);
                c0083a2.f1889c = null;
                ((b1.p) this.f1892b).e(c0083a2);
            }
        }
        return i2;
    }

    public C0084b(D d2) {
        this.f1892b = new b1.p(30);
        this.f1893c = new ArrayList();
        this.f1894d = new ArrayList();
        this.f1891a = 0;
        this.f1895e = d2;
        this.f1896f = new L(2, this);
    }
}
