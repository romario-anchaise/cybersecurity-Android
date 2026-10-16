// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import lyr.stable.runtime.defense.AppUninstallActivity;
import lyr.stable.runtime.defense.SelfUninstallActivity;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f5978a;

    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = m1.a.f2682a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = l1.a.f2407a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static Intent b(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) AppUninstallActivity.class);
        intent.putExtra("lyr.stable.runtime.defense.EXTRA_APP_UNINSTALL_TARGET_PACKAGE", str);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("lyr.stable.runtime.defense.EXTRA_APP_UNINSTALL_REQUEST_ID", str2);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static final void c(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                a(th, th2);
            }
        }
    }

    public static float d(float f3, float f4, float f5) {
        if (f4 <= f5) {
            if (f3 < f4) {
                return f4;
            }
            return f3 > f5 ? f5 : f3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f5 + " is less than minimum " + f4 + '.');
    }

    public static int e(int i3, int i4) {
        if (i4 < 0) {
            o2.i(j4.c(i4, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
            return 0;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3 > i4 ? i4 : i3;
    }

    public static long f(long j3, long j4, long j5) {
        if (j4 <= j5) {
            if (j3 < j4) {
                return j4;
            }
            return j3 > j5 ? j5 : j3;
        }
        StringBuilder sbJ = a0.a.j(j5, "Cannot coerce value to an empty range: maximum ", " is less than minimum ");
        sbJ.append(j4);
        sbJ.append('.');
        throw new IllegalArgumentException(sbJ.toString());
    }

    public static final void g(int i3, int i4) {
        if (i3 <= i4) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i4 + ").");
    }

    public static byte[] h(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = a1.a.f38h;
        int i3 = (length / 3) * 4;
        if (length % 3 > 0) {
            i3 += 4;
        }
        if (length > 0) {
            i3 += ((length - 1) / 57) + 1;
        }
        byte[] bArr3 = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 19;
        while (true) {
            int i7 = i4 + 3;
            if (i7 > length) {
                break;
            }
            int i8 = (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
            bArr3[i5] = bArr2[(i8 >> 18) & 63];
            bArr3[i5 + 1] = bArr2[(i8 >> 12) & 63];
            bArr3[i5 + 2] = bArr2[(i8 >> 6) & 63];
            bArr3[i5 + 3] = bArr2[i8 & 63];
            int i9 = i5 + 4;
            i6--;
            if (i6 == 0) {
                i5 += 5;
                bArr3[i9] = 10;
                i6 = 19;
            } else {
                i5 = i9;
            }
            i4 = i7;
        }
        if (i4 == length - 1) {
            int i10 = (bArr[i4] & 255) << 4;
            bArr3[i5] = bArr2[(i10 >> 6) & 63];
            bArr3[i5 + 1] = bArr2[i10 & 63];
            bArr3[i5 + 2] = 61;
            bArr3[i5 + 3] = 61;
            bArr3[i5 + 4] = 10;
            return bArr3;
        }
        if (i4 != length - 2) {
            if (i5 > 0 && i6 != 19) {
                bArr3[i5] = 10;
            }
            return bArr3;
        }
        int i11 = ((bArr[i4 + 1] & 255) << 2) | ((bArr[i4] & 255) << 10);
        bArr3[i5] = bArr2[(i11 >> 12) & 63];
        bArr3[i5 + 1] = bArr2[(i11 >> 6) & 63];
        bArr3[i5 + 2] = bArr2[i11 & 63];
        bArr3[i5 + 3] = 61;
        bArr3[i5 + 4] = 10;
        return bArr3;
    }

    public static boolean i(boolean z2, boolean z3, boolean z4, boolean z5) {
        return z2 && !z3 && !z4 && z5;
    }

    public static final List j(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        j1.c cVar = new j1.c(10);
        while (cursor.moveToNext()) {
            int i3 = cursor.getInt(columnIndex);
            int i4 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            string.getClass();
            String string2 = cursor.getString(columnIndex4);
            string2.getClass();
            cVar.add(new i.c(i3, i4, string, string2));
        }
        cVar.f();
        cVar.f2332e = true;
        if (cVar.f2331d <= 0) {
            cVar = j1.c.f2329f;
        }
        cVar.getClass();
        if (cVar.a() <= 1) {
            return i1.i.E(cVar);
        }
        Object[] array = cVar.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static final i.d k(k.c cVar, String str, boolean z2) throws IOException {
        Cursor cursorE = cVar.E(new j.a(a0.a.h("PRAGMA index_xinfo(`", str, "`)")));
        try {
            int columnIndex = cursorE.getColumnIndex("seqno");
            int columnIndex2 = cursorE.getColumnIndex("cid");
            int columnIndex3 = cursorE.getColumnIndex("name");
            int columnIndex4 = cursorE.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorE.moveToNext()) {
                    if (cursorE.getInt(columnIndex2) >= 0) {
                        int i3 = cursorE.getInt(columnIndex);
                        String string = cursorE.getString(columnIndex3);
                        String str2 = cursorE.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i3);
                        string.getClass();
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i3), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                collectionValues.getClass();
                List listE = i1.i.E(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                collectionValues2.getClass();
                i.d dVar = new i.d(str, z2, listE, i1.i.E(collectionValues2));
                cursorE.close();
                return dVar;
            }
            cursorE.close();
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c(cursorE, th);
                throw th2;
            }
        }
    }

    public static Intent l(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SelfUninstallActivity.class);
        if (str == null || str.isEmpty()) {
            str = "device-trash-delete";
        }
        intent.putExtra("lyr.stable.runtime.defense.EXTRA_SELF_UNINSTALL_REASON", str);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static s1.a m(s1.c cVar, int i3) {
        cVar.getClass();
        boolean z2 = i3 > 0;
        Integer numValueOf = Integer.valueOf(i3);
        if (!z2) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i4 = cVar.f3229c;
        int i5 = cVar.f3230d;
        if (cVar.f3231e <= 0) {
            i3 = -i3;
        }
        return new s1.a(i4, i5, i3);
    }

    public static void n(w2.g gVar, byte[] bArr) {
        long j3;
        gVar.getClass();
        bArr.getClass();
        int length = bArr.length;
        int i3 = 0;
        do {
            byte[] bArr2 = gVar.f5773g;
            int i4 = gVar.f5774h;
            int i5 = gVar.f5775i;
            if (bArr2 != null) {
                while (i4 < i5) {
                    int i6 = i3 % length;
                    bArr2[i4] = (byte) (bArr2[i4] ^ bArr[i6]);
                    i4++;
                    i3 = i6 + 1;
                }
            }
            long j4 = gVar.f5772f;
            w2.h hVar = gVar.f5769c;
            hVar.getClass();
            if (j4 == hVar.f5777d) {
                o2.k("no more bytes");
                return;
            }
            j3 = gVar.f5772f;
        } while (gVar.w(j3 == -1 ? 0L : j3 + ((long) (gVar.f5775i - gVar.f5774h))) != -1);
    }

    public static s1.c o(int i3, int i4) {
        if (i4 > Integer.MIN_VALUE) {
            return new s1.c(i3, i4 - 1, 1);
        }
        s1.c cVar = s1.c.f3236f;
        return s1.c.f3236f;
    }

    public static void p(int i3, int i4) {
        String strW;
        if (i3 < 0 || i3 >= i4) {
            if (i3 < 0) {
                strW = m0.a.w("%s (%s) must not be negative", "index", Integer.valueOf(i3));
            } else {
                if (i4 < 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
                    sb.append("negative size: ");
                    sb.append(i4);
                    throw new IllegalArgumentException(sb.toString());
                }
                strW = m0.a.w("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
            }
            throw new IndexOutOfBoundsException(strW);
        }
    }

    public static void q(int i3, int i4, int i5) {
        String strR;
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            if (i3 < 0 || i3 > i5) {
                strR = r(i3, i5, "start index");
            } else {
                strR = (i4 < 0 || i4 > i5) ? r(i4, i5, "end index") : m0.a.w("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strR);
        }
    }

    public static String r(int i3, int i4, String str) {
        if (i3 < 0) {
            return m0.a.w("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return m0.a.w("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
        sb.append("negative size: ");
        sb.append(i4);
        throw new IllegalArgumentException(sb.toString());
    }
}
