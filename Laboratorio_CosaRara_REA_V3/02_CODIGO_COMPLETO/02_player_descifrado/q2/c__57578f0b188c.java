// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import i2.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import w1.j4;
import w1.o2;
import y.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final byte[] A(Set set) throws IOException {
        set.getClass();
        if (set.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    p.c cVar = (p.c) it.next();
                    objectOutputStream.writeUTF(cVar.f2830a.toString());
                    objectOutputStream.writeBoolean(cVar.f2831b);
                }
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray.getClass();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    y.f.c(objectOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                y.f.c(byteArrayOutputStream, th3);
                throw th4;
            }
        }
    }

    public static final int B(int i3) {
        if (i3 == 0) {
            throw null;
        }
        int iA = g.d.a(i3);
        if (iA == 0) {
            return 0;
        }
        int i4 = 1;
        if (iA != 1) {
            i4 = 2;
            if (iA != 2) {
                i4 = 3;
                if (iA != 3) {
                    i4 = 4;
                    if (iA != 4) {
                        if (iA == 5) {
                            return 5;
                        }
                        throw new h1.a();
                    }
                }
            }
        }
        return i4;
    }

    public static final String C(String str) {
        str.getClass();
        int i3 = -1;
        int i4 = 0;
        if (!v1.d.B(str, ":")) {
            try {
                String ascii = IDN.toASCII(str);
                ascii.getClass();
                Locale locale = Locale.US;
                locale.getClass();
                String lowerCase = ascii.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i5 = 0; i5 < length; i5++) {
                    char cCharAt = lowerCase.charAt(i5);
                    if (q1.e.b(cCharAt, 31) <= 0 || q1.e.b(cCharAt, 127) >= 0 || v1.d.D(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressI = (v1.l.z(str, "[", false) && str.endsWith("]")) ? i(1, str.length() - 1, str) : i(0, str.length(), str);
        if (inetAddressI == null) {
            return null;
        }
        byte[] address = inetAddressI.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressI.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < address.length) {
            int i8 = i6;
            while (i8 < 16 && address[i8] == 0 && address[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i6;
            if (i9 > i7 && i9 >= 4) {
                i3 = i6;
                i7 = i9;
            }
            i6 = i8 + 2;
        }
        w2.h hVar = new w2.h();
        while (i4 < address.length) {
            if (i4 == i3) {
                hVar.J(58);
                i4 += i7;
                if (i4 == 16) {
                    hVar.J(58);
                }
            } else {
                if (i4 > 0) {
                    hVar.J(58);
                }
                byte b3 = address[i4];
                byte[] bArr = j2.b.f2361a;
                hVar.K(((b3 & 255) << 8) | (address[i4 + 1] & 255));
                i4 += 2;
            }
        }
        return hVar.D();
    }

    public static final void D(q.h hVar, final WorkDatabase workDatabase, p.b bVar, final List list, final o oVar, final Set set) {
        final String str = oVar.f5999a;
        final o oVarH = workDatabase.t().h(str);
        if (oVarH == null) {
            o2.i(a0.a.h("Worker with ", str, " doesn't exist"));
            return;
        }
        if (a0.a.b(oVarH.f6000b)) {
            return;
        }
        if (oVarH.d() ^ oVar.d()) {
            StringBuilder sb = new StringBuilder("Can't update ");
            sb.append(oVarH.d() ? "Periodic" : "OneTime");
            sb.append(" Worker to ");
            sb.append(oVar.d() ? "Periodic" : "OneTime");
            sb.append(" Worker. Update operation must preserve worker's type.");
            throw new UnsupportedOperationException(sb.toString());
        }
        final boolean zD = hVar.d(str);
        if (!zD) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((q.j) it.next()).a(str);
            }
        }
        Runnable runnable = new Runnable() { // from class: q.s
            @Override // java.lang.Runnable
            public final void run() {
                WorkDatabase workDatabase2 = workDatabase;
                workDatabase2.getClass();
                list.getClass();
                String str2 = str;
                str2.getClass();
                Set set2 = set;
                set2.getClass();
                y.p pVarT = workDatabase2.t();
                y.r rVarU = workDatabase2.u();
                y.o oVar2 = oVarH;
                y.o oVarB = y.o.b(oVar, null, oVar2.f6000b, oVar2.f6009k, oVar2.n, oVar2.f6017t + 1, 515069);
                WorkDatabase_Impl workDatabase_Impl = pVarT.f6018a;
                workDatabase_Impl.b();
                workDatabase_Impl.c();
                try {
                    y.h hVar2 = pVarT.f6020c;
                    k.i iVarA = hVar2.a();
                    try {
                        hVar2.o(iVarA, oVarB);
                        iVarA.d();
                        hVar2.m(iVarA);
                        workDatabase_Impl.o();
                        workDatabase_Impl.k();
                        WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) rVarU.f6032a;
                        workDatabase_Impl2.b();
                        y.h hVar3 = (y.h) rVarU.f6034c;
                        k.i iVarA2 = hVar3.a();
                        iVarA2.m(str2, 1);
                        workDatabase_Impl2.c();
                        try {
                            iVarA2.d();
                            workDatabase_Impl2.o();
                            workDatabase_Impl2.k();
                            hVar3.m(iVarA2);
                            rVarU.d(str2, set2);
                            if (zD) {
                                return;
                            }
                            pVarT.j(str2, -1L);
                            workDatabase2.s().g(str2);
                        } catch (Throwable th) {
                            workDatabase_Impl2.k();
                            hVar3.m(iVarA2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        hVar2.m(iVarA);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    workDatabase_Impl.k();
                    throw th3;
                }
            }
        };
        workDatabase.c();
        try {
            runnable.run();
            workDatabase.o();
            workDatabase.k();
            if (zD) {
                return;
            }
            q.k.a(bVar, workDatabase, list);
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }

    public static void E(Parcel parcel, int i3, Parcelable parcelable, int i4) {
        if (parcelable == null) {
            return;
        }
        int I = I(parcel, i3);
        parcelable.writeToParcel(parcel, i4);
        J(parcel, I);
    }

    public static void F(Parcel parcel, int i3, String str) {
        if (str == null) {
            return;
        }
        int I = I(parcel, i3);
        parcel.writeString(str);
        J(parcel, I);
    }

    public static void G(Parcel parcel, int i3, Parcelable[] parcelableArr, int i4) {
        if (parcelableArr == null) {
            return;
        }
        int I = I(parcel, i3);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i4);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        J(parcel, I);
    }

    public static void H(Parcel parcel, int i3, int i4) {
        parcel.writeInt(i3 | (i4 << 16));
    }

    public static int I(Parcel parcel, int i3) {
        parcel.writeInt(i3 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void J(Parcel parcel, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(iDataPosition - i3);
        parcel.setDataPosition(iDataPosition);
    }

    public static final void a(l2.a aVar, l2.c cVar, String str) {
        l2.e.f2422i.fine(cVar.f2415b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f2408a);
    }

    public static ArrayList b(List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((v) obj) != v.f2261d) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(i1.k.A(arrayList));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((v) obj2).f2268c);
        }
        return arrayList2;
    }

    public static final LinkedHashSet c(byte[] bArr) throws IOException {
        bArr.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int i3 = objectInputStream.readInt();
                    for (int i4 = 0; i4 < i3; i4++) {
                        Uri uri = Uri.parse(objectInputStream.readUTF());
                        boolean z2 = objectInputStream.readBoolean();
                        uri.getClass();
                        linkedHashSet.add(new p.c(uri, z2));
                    }
                    objectInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        y.f.c(objectInputStream, th);
                        throw th2;
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            byteArrayInputStream.close();
            return linkedHashSet;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                y.f.c(byteArrayInputStream, th3);
                throw th4;
            }
        }
    }

    public static void g(int i3) {
        if (2 > i3 || i3 >= 37) {
            StringBuilder sbI = a0.a.i(i3, "radix ", " was not in valid range ");
            sbI.append(new s1.c(2, 36, 1));
            throw new IllegalArgumentException(sbI.toString());
        }
    }

    public static byte[] h(List list) {
        list.getClass();
        w2.h hVar = new w2.h();
        ArrayList arrayListB = b(list);
        int size = arrayListB.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListB.get(i3);
            i3++;
            String str = (String) obj;
            hVar.J(str.length());
            hVar.O(str);
        }
        return hVar.B(hVar.f5777d);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac A[LOOP:1: B:54:0x00a0->B:57:0x00ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x00b2 A[EDGE_INSN: B:79:0x00b2->B:58:0x00b2 BREAK  A[LOOP:1: B:54:0x00a0->B:57:0x00ac], SYNTHETIC] */
    public static final InetAddress i(int i3, int i4, String str) {
        int i5;
        int i6;
        int iR;
        byte[] bArr = new byte[16];
        int i7 = i3;
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        while (i7 < i4) {
            if (i8 == 16) {
                return null;
            }
            int i11 = i7 + 2;
            if (i11 <= i4 && v1.l.y(str, "::", i7, false)) {
                if (i9 != -1) {
                    return null;
                }
                i8 += 2;
                i9 = i8;
                if (i11 == i4) {
                    break;
                }
                i10 = i11;
                i5 = 0;
                i7 = i10;
                while (i7 < i4) {
                    iR = j2.b.r(str.charAt(i7));
                    if (iR != -1) {
                        break;
                        break;
                    }
                    i5 = (i5 << 4) + iR;
                    i7++;
                }
                i6 = i7 - i10;
                return i6 == 0 ? null : null;
            }
            if (i8 != 0) {
                if (!v1.l.y(str, ":", i7, false)) {
                    if (!v1.l.y(str, ".", i7, false)) {
                        return null;
                    }
                    int i12 = i8 - 2;
                    int i13 = i12;
                    while (i10 < i4) {
                        if (i13 == 16) {
                            return null;
                        }
                        if (i13 != i12) {
                            if (str.charAt(i10) != '.') {
                                return null;
                            }
                            i10++;
                        }
                        int i14 = 0;
                        int i15 = i10;
                        while (i15 < i4) {
                            char cCharAt = str.charAt(i15);
                            if (q1.e.b(cCharAt, 48) < 0 || q1.e.b(cCharAt, 57) > 0) {
                                break;
                            }
                            if ((i14 == 0 && i10 != i15) || (i14 = ((i14 * 10) + cCharAt) - 48) > 255) {
                                return null;
                            }
                            i15++;
                        }
                        if (i15 - i10 == 0) {
                            return null;
                        }
                        bArr[i13] = (byte) i14;
                        i13++;
                        i10 = i15;
                    }
                    if (i13 != i8 + 2) {
                        return null;
                    }
                    i8 += 2;
                    break;
                }
                i7++;
            }
            i10 = i7;
            i5 = 0;
            i7 = i10;
            while (i7 < i4) {
                iR = j2.b.r(str.charAt(i7));
                if (iR != -1) {
                    break;
                }
                i5 = (i5 << 4) + iR;
                i7++;
            }
            i6 = i7 - i10;
            if (i6 == 0 && i6 <= 4) {
                int i16 = i8 + 1;
                bArr[i8] = (byte) (255 & (i5 >>> 8));
                i8 += 2;
                bArr[i16] = (byte) (i5 & 255);
            }
        }
        if (i8 != 16) {
            if (i9 == -1) {
                return null;
            }
            int i17 = i8 - i9;
            System.arraycopy(bArr, i9, bArr, 16 - i17, i17);
            Arrays.fill(bArr, i9, (16 - i8) + i9, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static String j(Map map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(m0.a.f((String) entry.getKey()));
            sb.append("=");
            sb.append(m0.a.f((String) entry.getValue()));
        }
        return sb.toString();
    }

    public static final boolean k(char c3, char c4, boolean z2) {
        if (c3 == c4) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c3);
        char upperCase2 = Character.toUpperCase(c4);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final String l(long j3) {
        String str;
        if (j3 <= -999500000) {
            str = ((j3 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j3 <= -999500) {
            str = ((j3 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j3 <= 0) {
            str = ((j3 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j3 < 999500) {
            str = ((j3 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j3 < 999500000) {
            str = ((j3 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j3 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public static final int m(Cursor cursor, String str) {
        String string;
        cursor.getClass();
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            columnNames.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i3 = 0;
            for (String str2 : columnNames) {
                i3++;
                if (i3 > 1) {
                    sb.append((CharSequence) ", ");
                }
                k.a(sb, str2, null);
            }
            sb.append((CharSequence) "");
            string = sb.toString();
        } catch (Exception e3) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e3);
            string = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }

    public static final int n(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        o2.i(j4.c(i3, "Could not convert ", " to BackoffPolicy"));
        return 0;
    }

    public static final int o(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 == 4) {
            return 5;
        }
        if (i3 == 5) {
            return 6;
        }
        o2.i(j4.c(i3, "Could not convert ", " to NetworkType"));
        return 0;
    }

    public static final int p(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        o2.i(j4.c(i3, "Could not convert ", " to OutOfQuotaPolicy"));
        return 0;
    }

    public static final int q(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 == 4) {
            return 5;
        }
        if (i3 == 5) {
            return 6;
        }
        o2.i(j4.c(i3, "Could not convert ", " to State"));
        return 0;
    }

    public static boolean r() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean s(int i3) {
        return i3 >= 0 && i3 <= 33554432;
    }

    public static boolean t(String str) {
        return "com.android.settings".equals(str) || str.endsWith(".settings") || str.contains("securitycenter") || str.contains("systemmanager");
    }

    public static boolean u(char c3) {
        return Character.isWhitespace(c3) || Character.isSpaceChar(c3);
    }

    public static int v(int i3) {
        if (i3 < 0) {
            return i3;
        }
        if (i3 < 3) {
            return i3 + 1;
        }
        if (i3 < 1073741824) {
            return (int) ((i3 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final int w(int i3) {
        if (i3 == 0) {
            throw null;
        }
        int iA = g.d.a(i3);
        if (iA == 0) {
            return 0;
        }
        int i4 = 1;
        if (iA != 1) {
            i4 = 2;
            if (iA != 2) {
                i4 = 3;
                if (iA != 3) {
                    i4 = 4;
                    if (iA != 4) {
                        if (i3 == 6) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + a0.a.A(i3) + " to int");
                    }
                }
            }
        }
        return i4;
    }

    public static g.j x(String str) throws ProtocolException {
        int i3;
        String strSubstring;
        boolean z2 = v1.l.z(str, "HTTP/1.", false);
        v vVar = v.f2261d;
        if (z2) {
            i3 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                vVar = v.f2262e;
            }
        } else {
            if (!v1.l.z(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i3 = 4;
        }
        int i4 = i3 + 3;
        if (str.length() < i4) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i5 = Integer.parseInt(str.substring(i3, i4));
            if (str.length() <= i4) {
                strSubstring = "";
            } else {
                if (str.charAt(i4) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i3 + 4);
            }
            return new g.j(vVar, i5, strSubstring, 2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public abstract boolean d(a0.j jVar, a0.e eVar, a0.e eVar2);

    public abstract boolean e(a0.j jVar, Object obj, Object obj2);

    public abstract boolean f(a0.j jVar, a0.i iVar, a0.i iVar2);

    public abstract void y(a0.i iVar, a0.i iVar2);

    public abstract void z(a0.i iVar, Thread thread);
}
