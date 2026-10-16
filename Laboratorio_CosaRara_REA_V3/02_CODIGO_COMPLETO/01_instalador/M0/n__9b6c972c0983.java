// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import E0.p;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class n extends F0.j implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f377d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, boolean z2, int i2) {
        super(2);
        this.f375b = i2;
        this.f377d = obj;
        this.f376c = z2;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac A[LOOP:0: B:28:0x0078->B:39:0x00ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:67:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f7 A[SYNTHETIC] */
    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        int i2;
        int i3;
        boolean z2;
        Object next;
        p034t0.d dVar;
        Object next2;
        String str;
        String str2;
        switch (this.f375b) {
            case 0:
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Number) obj2).intValue();
                F0.i.e(charSequence, "$this$$receiver");
                int iZ = e.Z(charSequence, (char[]) this.f377d, iIntValue, this.f376c);
                if (iZ < 0) {
                    return null;
                }
                return new p034t0.d(Integer.valueOf(iZ), 1);
            default:
                CharSequence charSequence2 = (CharSequence) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                F0.i.e(charSequence2, "$this$$receiver");
                List list = (List) this.f377d;
                boolean z3 = this.f376c;
                if (z3 || list.size() != 1) {
                    if (iIntValue2 < 0) {
                        iIntValue2 = 0;
                    }
                    J0.c cVar = new J0.c(iIntValue2, charSequence2.length(), 1);
                    boolean z4 = charSequence2 instanceof String;
                    int i4 = cVar.f280c;
                    int i5 = cVar.f279b;
                    if (z4) {
                        if ((i4 <= 0 || iIntValue2 > i5) && (i4 >= 0 || i5 > iIntValue2)) {
                            dVar = null;
                        } else {
                            while (true) {
                                Iterator it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        str2 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str = (String) next2;
                                    if (str != null) {
                                        dVar = new p034t0.d(Integer.valueOf(iIntValue2), str);
                                    } else if (iIntValue2 != i5) {
                                        iIntValue2 += i4;
                                    } else {
                                        dVar = null;
                                    }
                                } while (!m.O(0, iIntValue2, str2.length(), str2, (String) charSequence2, z3));
                                str = (String) next2;
                                if (str != null) {
                                    dVar = new p034t0.d(Integer.valueOf(iIntValue2), str);
                                } else if (iIntValue2 != i5) {
                                    iIntValue2 += i4;
                                } else {
                                    dVar = null;
                                }
                            }
                        }
                    } else if ((i4 <= 0 || iIntValue2 > i5) && (i4 >= 0 || i5 > iIntValue2)) {
                        dVar = null;
                    } else {
                        int i6 = iIntValue2;
                        while (true) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    String str3 = (String) next;
                                    i2 = i5;
                                    i3 = i4;
                                    z2 = z3;
                                    if (!e.b0(str3, 0, charSequence2, i6, str3.length(), z3)) {
                                        z3 = z2;
                                        i5 = i2;
                                        i4 = i3;
                                    }
                                } else {
                                    i2 = i5;
                                    i3 = i4;
                                    z2 = z3;
                                    next = null;
                                }
                            }
                            String str4 = (String) next;
                            if (str4 != null) {
                                dVar = new p034t0.d(Integer.valueOf(i6), str4);
                            } else if (i6 != i2) {
                                i6 += i3;
                                z3 = z2;
                                i5 = i2;
                                i4 = i3;
                            } else {
                                dVar = null;
                            }
                        }
                    }
                } else {
                    int size = list.size();
                    if (size == 0) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    if (size != 1) {
                        throw new IllegalArgumentException("List has more than one element.");
                    }
                    String str5 = (String) list.get(0);
                    int iY = e.Y(charSequence2, str5, iIntValue2, false, 4);
                    if (iY < 0) {
                        dVar = null;
                    } else {
                        dVar = new p034t0.d(Integer.valueOf(iY), str5);
                    }
                }
                if (dVar == null) {
                    return null;
                }
                return new p034t0.d(dVar.f4126a, Integer.valueOf(((String) dVar.f4127b).length()));
        }
    }
}
