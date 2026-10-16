// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m0;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import i1.e;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import p.m;
import q2.c;
import w1.o2;
import y.j;
import y.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f2678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f2679b;

    public static final String a(Object[] objArr, int i3, int i4, e eVar) {
        StringBuilder sb = new StringBuilder((i4 * 3) + 2);
        sb.append("[");
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i3 + i5];
            if (obj == eVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static Parcelable c(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iR = r(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iR == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iR);
        return parcelable;
    }

    public static String d(Parcel parcel, int i3) {
        int iR = r(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iR == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iR);
        return string;
    }

    public static Object[] e(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iR = r(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iR == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iR);
        return objArrCreateTypedArray;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("%21", "!").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%7E", "~");
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void g(Parcel parcel, int i3) {
        if (parcel.dataPosition() == i3) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
        sb.append("Overread allowed size end=");
        sb.append(i3);
        throw new h1.a(sb.toString(), parcel);
    }

    public static final j h(o oVar) {
        oVar.getClass();
        return new j(oVar.f5999a, oVar.f6017t);
    }

    public static final int i(int i3, int i4, int i5) {
        if (i5 > 0) {
            if (i3 < i4) {
                int i6 = i4 % i5;
                if (i6 < 0) {
                    i6 += i5;
                }
                int i7 = i3 % i5;
                if (i7 < 0) {
                    i7 += i5;
                }
                int i8 = (i6 - i7) % i5;
                if (i8 < 0) {
                    i8 += i5;
                }
                return i4 - i8;
            }
        } else {
            if (i5 >= 0) {
                o2.i("Step is zero.");
                return 0;
            }
            if (i3 > i4) {
                int i9 = -i5;
                int i10 = i3 % i9;
                if (i10 < 0) {
                    i10 += i9;
                }
                int i11 = i4 % i9;
                if (i11 < 0) {
                    i11 += i9;
                }
                int i12 = (i10 - i11) % i9;
                if (i12 < 0) {
                    i12 += i9;
                }
                return i12 + i4;
            }
        }
        return i4;
    }

    public static String j(String str, String str2) {
        str.getClass();
        str2.getClass();
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }

    public static List k(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static final void l(Context context) {
        Map map;
        context.getClass();
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        databasePath.getClass();
        if (databasePath.exists()) {
            m.d().a(q.o.f3050a, "Migrating WorkDatabase to the no-backup directory");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            databasePath2.getClass();
            File file = new File(q.a.f3003a.a(context), "androidx.work.workdb");
            String[] strArr = q.o.f3051b;
            int iV = c.v(strArr.length);
            if (iV < 16) {
                iV = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iV);
            for (String str : strArr) {
                linkedHashMap.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap.isEmpty()) {
                Map mapSingletonMap = Collections.singletonMap(databasePath2, file);
                mapSingletonMap.getClass();
                map = mapSingletonMap;
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath2, file);
                map = linkedHashMap2;
            }
            for (Map.Entry entry : map.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        m.d().g(q.o.f3050a, "Over-writing contents of " + file3);
                    }
                    m.d().a(q.o.f3050a, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }

    public static String m(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        String lowerCase = Normalizer.normalize(charSequence, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(lowerCase.length());
        int iCharCount = 0;
        while (iCharCount < lowerCase.length()) {
            int iCodePointAt = lowerCase.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            int type = Character.getType(iCodePointAt);
            if (Character.isLetterOrDigit(iCodePointAt) || type == 10 || type == 11) {
                sb.appendCodePoint(iCodePointAt);
            }
        }
        return sb.toString();
    }

    public static long n(long j3, long j4, boolean z2) {
        if (!z2 || j3 <= 0) {
            return -1L;
        }
        return Math.max(0L, j4 - j3);
    }

    public static final boolean o(String str) {
        str.getClass();
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean p(Parcel parcel, int i3) {
        x(parcel, i3, 4);
        return parcel.readInt() != 0;
    }

    public static int q(Parcel parcel, int i3) {
        x(parcel, i3, 4);
        return parcel.readInt();
    }

    public static int r(Parcel parcel, int i3) {
        return (i3 & (-65536)) != -65536 ? (char) (i3 >> 16) : parcel.readInt();
    }

    public static final void s(Object[] objArr, int i3, int i4) {
        objArr.getClass();
        while (i3 < i4) {
            objArr[i3] = null;
            i3++;
        }
    }

    public static int t(x1.j jVar) {
        if (jVar.f5892b) {
            return 2;
        }
        if (!jVar.f5891a) {
            return 1;
        }
        if (jVar.f5893c) {
            return 2;
        }
        if (jVar.f5896f) {
            return jVar.f5894d ? 2 : 3;
        }
        if (jVar.f5897g) {
            return 4;
        }
        return jVar.f5895e ? 5 : 1;
    }

    public static void u(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + r(parcel, i3));
    }

    public static int v(Parcel parcel) {
        int i3 = parcel.readInt();
        int iR = r(parcel, i3);
        char c3 = (char) i3;
        int iDataPosition = parcel.dataPosition();
        if (c3 != 20293) {
            throw new h1.a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i3))), parcel);
        }
        int i4 = iR + iDataPosition;
        if (i4 >= iDataPosition && i4 <= parcel.dataSize()) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iDataPosition).length() + 32 + String.valueOf(i4).length());
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i4);
        throw new h1.a(sb.toString(), parcel);
    }

    public static String w(String str, Object... objArr) {
        int length;
        int iIndexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i3 = 0;
        int i4 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(y(objArr[i3]));
            i4 = iIndexOf + 2;
            i3++;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i3 < length) {
            String str2 = " [";
            while (i3 < objArr.length) {
                sb.append(str2);
                sb.append(y(objArr[i3]));
                i3++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void x(Parcel parcel, int i3, int i4) {
        int iR = r(parcel, i3);
        if (iR == i4) {
            return;
        }
        String hexString = Integer.toHexString(iR);
        int length = String.valueOf(i4).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(iR).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(iR);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new h1.a(sb.toString(), parcel);
    }

    public static String y(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e3) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append("@");
            sb.append(hexString);
            String string = sb.toString();
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(string), (Throwable) e3);
            String name2 = e3.getClass().getName();
            StringBuilder sb2 = new StringBuilder(string.length() + 8 + name2.length() + 1);
            sb2.append("<");
            sb2.append(string);
            sb2.append(" threw ");
            sb2.append(name2);
            sb2.append(">");
            return sb2.toString();
        }
    }

    public abstract List b(String str, List list);
}
