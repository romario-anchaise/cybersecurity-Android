// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import H.C0028c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0028c f484a = new C0028c(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f485b = {112, 114, 111, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f486c = {112, 114, 109, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f487d = {48, 49, 53, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f488e = {48, 49, 48, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f489f = {48, 48, 57, 0};
    public static final byte[] g = {48, 48, 53, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f490h = {48, 48, 49, 0};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f491i = {48, 48, 49, 0};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f492j = {48, 48, 50, 0};

    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static byte[] b(c[] cVarArr, byte[] bArr) throws IOException {
        int length = 0;
        for (c cVar : cVarArr) {
            length += ((((cVar.g * 2) + 7) & (-8)) / 8) + (cVar.f480e * 2) + d(cVar.f476a, cVar.f477b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + cVar.f481f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, f489f)) {
            for (c cVar2 : cVarArr) {
                p(byteArrayOutputStream, cVar2, d(cVar2.f476a, cVar2.f477b, bArr));
                r(byteArrayOutputStream, cVar2);
                int[] iArr = cVar2.f482h;
                int length2 = iArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length2) {
                    int i4 = iArr[i2];
                    u(byteArrayOutputStream, i4 - i3);
                    i2++;
                    i3 = i4;
                }
                q(byteArrayOutputStream, cVar2);
            }
        } else {
            for (c cVar3 : cVarArr) {
                p(byteArrayOutputStream, cVar3, d(cVar3.f476a, cVar3.f477b, bArr));
            }
            for (c cVar4 : cVarArr) {
                r(byteArrayOutputStream, cVar4);
                int[] iArr2 = cVar4.f482h;
                int length3 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length3) {
                    int i7 = iArr2[i5];
                    u(byteArrayOutputStream, i7 - i6);
                    i5++;
                    i6 = i7;
                }
                q(byteArrayOutputStream, cVar4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file2 : fileArrListFiles) {
            z2 = c(file2) && z2;
        }
        return z2;
    }

    public static String d(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f490h;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = g;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append((Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!");
        sb.append(str2);
        return sb.toString();
    }

    public static void e(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] f(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                throw new IllegalStateException(F0.h.b(i2, "Not enough bytes to read: "));
            }
            i3 += i4;
        }
        return bArr;
    }

    public static int[] g(ByteArrayInputStream byteArrayInputStream, int i2) {
        int[] iArr = new int[i2];
        int iM = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iM += (int) m(byteArrayInputStream, 2);
            iArr[i3] = iM;
        }
        return iArr;
    }

    public static byte[] h(FileInputStream fileInputStream, int i2, int i3) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i2) {
                int i5 = fileInputStream.read(bArr2);
                if (i5 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i2 + " bytes");
                }
                inflater.setInput(bArr2, 0, i5);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i3 - iInflate);
                    i4 += i5;
                } catch (DataFormatException e2) {
                    throw new IllegalStateException(e2.getMessage());
                }
            }
            if (i4 == i2) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i2 + " actual=" + i4);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static c[] i(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, c[] cVarArr) throws IOException {
        byte[] bArr3 = f491i;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f492j)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iM = (int) m(fileInputStream, 2);
            byte[] bArrH = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
            try {
                c[] cVarArrK = k(byteArrayInputStream, bArr2, iM, cVarArr);
                byteArrayInputStream.close();
                return cVarArrK;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f487d, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iM2 = (int) m(fileInputStream, 1);
        byte[] bArrH2 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrH2);
        try {
            c[] cVarArrJ = j(byteArrayInputStream2, iM2, cVarArr);
            byteArrayInputStream2.close();
            return cVarArrJ;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static c[] j(ByteArrayInputStream byteArrayInputStream, int i2, c[] cVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i2 != cVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iM = (int) m(byteArrayInputStream, 2);
            iArr[i3] = (int) m(byteArrayInputStream, 2);
            strArr[i3] = new String(f(byteArrayInputStream, iM), StandardCharsets.UTF_8);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            c cVar = cVarArr[i4];
            if (!cVar.f477b.equals(strArr[i4])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i5 = iArr[i4];
            cVar.f480e = i5;
            cVar.f482h = g(byteArrayInputStream, i5);
        }
        return cVarArr;
    }

    public static c[] k(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, c[] cVarArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i2 != cVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            m(byteArrayInputStream, 2);
            String str = new String(f(byteArrayInputStream, (int) m(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jM = m(byteArrayInputStream, 4);
            int iM = (int) m(byteArrayInputStream, 2);
            c cVar = null;
            if (cVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i4 = 0; i4 < cVarArr.length; i4++) {
                    if (cVarArr[i4].f477b.equals(strSubstring)) {
                        cVar = cVarArr[i4];
                        break;
                    }
                }
            }
            if (cVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            cVar.f479d = jM;
            int[] iArrG = g(byteArrayInputStream, iM);
            if (Arrays.equals(bArr, f490h)) {
                cVar.f480e = iM;
                cVar.f482h = iArrG;
            }
        }
        return cVarArr;
    }

    public static c[] l(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, f488e)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iM = (int) m(fileInputStream, 1);
        byte[] bArrH = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
        try {
            c[] cVarArrN = n(byteArrayInputStream, str, iM);
            byteArrayInputStream.close();
            return cVarArrN;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(InputStream inputStream, int i2) throws IOException {
        byte[] bArrF = f(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += ((long) (bArrF[i3] & 255)) << (i3 * 8);
        }
        return j2;
    }

    public static c[] n(ByteArrayInputStream byteArrayInputStream, String str, int i2) throws IOException {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        c[] cVarArr = new c[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iM = (int) m(byteArrayInputStream, 2);
            int iM2 = (int) m(byteArrayInputStream, 2);
            cVarArr[i3] = new c(str, new String(f(byteArrayInputStream, iM), StandardCharsets.UTF_8), m(byteArrayInputStream, 4), iM2, (int) m(byteArrayInputStream, 4), (int) m(byteArrayInputStream, 4), new int[iM2], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            c cVar = cVarArr[i4];
            int iAvailable = byteArrayInputStream.available() - cVar.f481f;
            int iM3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = cVar.f483i;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                iM3 += (int) m(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iM3), 1);
                for (int iM4 = (int) m(byteArrayInputStream, 2); iM4 > 0; iM4--) {
                    m(byteArrayInputStream, 2);
                    int iM5 = (int) m(byteArrayInputStream, 1);
                    if (iM5 != 6 && iM5 != 7) {
                        while (iM5 > 0) {
                            m(byteArrayInputStream, 1);
                            for (int iM6 = (int) m(byteArrayInputStream, 1); iM6 > 0; iM6--) {
                                m(byteArrayInputStream, 2);
                            }
                            iM5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            cVar.f482h = g(byteArrayInputStream, cVar.f480e);
            int i5 = cVar.g;
            BitSet bitSetValueOf = BitSet.valueOf(f(byteArrayInputStream, (((i5 * 2) + 7) & (-8)) / 8));
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = bitSetValueOf.get(i6) ? 2 : 0;
                if (bitSetValueOf.get(i6 + i5)) {
                    i7 |= 4;
                }
                if (i7 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i6));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i6), Integer.valueOf(i7 | num.intValue()));
                }
            }
        }
        return cVarArr;
    }

    public static boolean o(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, c[] cVarArr) throws IOException {
        long j2;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f487d;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f488e;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrB = b(cVarArr, bArr3);
                t(byteArrayOutputStream, cVarArr.length, 1);
                t(byteArrayOutputStream, bArrB.length, 4);
                byte[] bArrA = a(bArrB);
                t(byteArrayOutputStream, bArrA.length, 4);
                byteArrayOutputStream.write(bArrA);
                return true;
            }
            byte[] bArr4 = g;
            if (Arrays.equals(bArr, bArr4)) {
                t(byteArrayOutputStream, cVarArr.length, 1);
                for (c cVar : cVarArr) {
                    int size = cVar.f483i.size() * 4;
                    String strD = d(cVar.f476a, cVar.f477b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    u(byteArrayOutputStream, strD.getBytes(charset).length);
                    u(byteArrayOutputStream, cVar.f482h.length);
                    t(byteArrayOutputStream, size, 4);
                    t(byteArrayOutputStream, cVar.f478c, 4);
                    byteArrayOutputStream.write(strD.getBytes(charset));
                    Iterator it = cVar.f483i.keySet().iterator();
                    while (it.hasNext()) {
                        u(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        u(byteArrayOutputStream, 0);
                    }
                    for (int i3 : cVar.f482h) {
                        u(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr5 = f489f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrB2 = b(cVarArr, bArr5);
                t(byteArrayOutputStream, cVarArr.length, 1);
                t(byteArrayOutputStream, bArrB2.length, 4);
                byte[] bArrA2 = a(bArrB2);
                t(byteArrayOutputStream, bArrA2.length, 4);
                byteArrayOutputStream.write(bArrA2);
                return true;
            }
            byte[] bArr6 = f490h;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            u(byteArrayOutputStream, cVarArr.length);
            for (c cVar2 : cVarArr) {
                String strD2 = d(cVar2.f476a, cVar2.f477b, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                u(byteArrayOutputStream, strD2.getBytes(charset2).length);
                TreeMap treeMap = cVar2.f483i;
                u(byteArrayOutputStream, treeMap.size());
                u(byteArrayOutputStream, cVar2.f482h.length);
                t(byteArrayOutputStream, cVar2.f478c, 4);
                byteArrayOutputStream.write(strD2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    u(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : cVar2.f482h) {
                    u(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            u(byteArrayOutputStream2, cVarArr.length);
            int i5 = 2;
            int i6 = 2;
            for (c cVar3 : cVarArr) {
                t(byteArrayOutputStream2, cVar3.f478c, 4);
                t(byteArrayOutputStream2, cVar3.f479d, 4);
                t(byteArrayOutputStream2, cVar3.g, 4);
                String strD3 = d(cVar3.f476a, cVar3.f477b, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strD3.getBytes(charset3).length;
                u(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(strD3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            o oVar = new o(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(oVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < cVarArr.length) {
                try {
                    c cVar4 = cVarArr[i7];
                    u(byteArrayOutputStream3, i7);
                    u(byteArrayOutputStream3, cVar4.f480e);
                    i8 = i8 + 4 + (cVar4.f480e * 2);
                    int[] iArr = cVar4.f482h;
                    int length3 = iArr.length;
                    int i9 = i2;
                    while (i2 < length3) {
                        int i10 = iArr[i2];
                        u(byteArrayOutputStream3, i10 - i9);
                        i2++;
                        i9 = i10;
                    }
                    i7++;
                    i2 = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            o oVar2 = new o(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(oVar2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i11 = 0;
            int i12 = 0;
            while (i11 < cVarArr.length) {
                try {
                    c cVar5 = cVarArr[i11];
                    Iterator it3 = cVar5.f483i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        q(byteArrayOutputStream5, cVar5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            r(byteArrayOutputStream6, cVar5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            u(byteArrayOutputStream4, i11);
                            int length4 = byteArray3.length + i5 + byteArray4.length;
                            int i13 = i12 + 6;
                            ArrayList arrayList4 = arrayList3;
                            t(byteArrayOutputStream4, length4, 4);
                            u(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i12 = i13 + length4;
                            i11++;
                            arrayList3 = arrayList4;
                            i5 = 2;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i12 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray5.length);
            }
            o oVar3 = new o(4, byteArray5, true);
            byteArrayOutputStream4.close();
            arrayList2.add(oVar3);
            long j3 = 4;
            long size2 = j3 + j3 + 4 + ((long) (arrayList2.size() * 16));
            t(byteArrayOutputStream, arrayList2.size(), 4);
            int i14 = 0;
            while (i14 < arrayList2.size()) {
                o oVar4 = (o) arrayList2.get(i14);
                int i15 = oVar4.f506a;
                if (i15 == 1) {
                    j2 = 0;
                } else if (i15 == 2) {
                    j2 = 1;
                } else if (i15 == 3) {
                    j2 = 2;
                } else if (i15 == 4) {
                    j2 = 3;
                } else {
                    if (i15 != 5) {
                        throw null;
                    }
                    j2 = 4;
                }
                t(byteArrayOutputStream, j2, 4);
                t(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = oVar4.f507b;
                if (oVar4.f508c) {
                    long length5 = bArr7.length;
                    byte[] bArrA3 = a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrA3);
                    t(byteArrayOutputStream, bArrA3.length, 4);
                    t(byteArrayOutputStream, length5, 4);
                    length = bArrA3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    t(byteArrayOutputStream, bArr7.length, 4);
                    t(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i14++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i16 = 0; i16 < arrayList6.size(); i16++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i16));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void p(ByteArrayOutputStream byteArrayOutputStream, c cVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        u(byteArrayOutputStream, str.getBytes(charset).length);
        u(byteArrayOutputStream, cVar.f480e);
        t(byteArrayOutputStream, cVar.f481f, 4);
        t(byteArrayOutputStream, cVar.f478c, 4);
        t(byteArrayOutputStream, cVar.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void q(ByteArrayOutputStream byteArrayOutputStream, c cVar) throws IOException {
        byte[] bArr = new byte[(((cVar.g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : cVar.f483i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i2 = iIntValue / 8;
                bArr[i2] = (byte) (bArr[i2] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i3 = iIntValue + cVar.g;
                int i4 = i3 / 8;
                bArr[i4] = (byte) ((1 << (i3 % 8)) | bArr[i4]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void r(ByteArrayOutputStream byteArrayOutputStream, c cVar) throws IOException {
        int i2 = 0;
        for (Map.Entry entry : cVar.f483i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                u(byteArrayOutputStream, iIntValue - i2);
                u(byteArrayOutputStream, 0);
                i2 = iIntValue;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0187 A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #33 {all -> 0x019d, blocks: (B:99:0x017b, B:101:0x0187, B:112:0x01a0, B:113:0x01a5), top: B:270:0x017b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01a0 A[Catch: all -> 0x019d, TRY_ENTER, TryCatch #33 {all -> 0x019d, blocks: (B:99:0x017b, B:101:0x0187, B:112:0x01a0, B:113:0x01a5), top: B:270:0x017b }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x01b2 A[Catch: IllegalStateException -> 0x0196, IOException -> 0x0198, FileNotFoundException -> 0x019b, TRY_LEAVE, TryCatch #30 {FileNotFoundException -> 0x019b, IOException -> 0x0198, IllegalStateException -> 0x0196, blocks: (B:97:0x0173, B:102:0x0191, B:121:0x01b2, B:119:0x01af, B:118:0x01ac), top: B:276:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:132:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ec A[Catch: all -> 0x01fb, TRY_LEAVE, TryCatch #20 {all -> 0x01fb, blocks: (B:138:0x01e0, B:140:0x01ec, B:149:0x01fe), top: B:256:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x01fe A[Catch: all -> 0x01fb, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x01fb, blocks: (B:138:0x01e0, B:140:0x01ec, B:149:0x01fe), top: B:256:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x021c  */
    /* JADX WARN: Code duplicated, block: B:165:0x0226  */
    /* JADX WARN: Code duplicated, block: B:166:0x022a  */
    /* JADX WARN: Code duplicated, block: B:174:0x0244 A[Catch: all -> 0x0267, TRY_LEAVE, TryCatch #7 {all -> 0x0267, blocks: (B:171:0x023c, B:172:0x023e, B:174:0x0244), top: B:234:0x023c }] */
    /* JADX WARN: Code duplicated, block: B:217:0x0296  */
    /* JADX WARN: Code duplicated, block: B:220:0x029f  */
    /* JADX WARN: Code duplicated, block: B:225:0x02ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:227:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:270:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0173 A[EXC_TOP_SPLITTER, PHI: r6
  0x0173: PHI (r6v26 char) = (r6v25 char), (r6v33 char), (r6v30 char) binds: [B:92:0x0169, B:94:0x016d, B:95:0x016f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x015f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0167  */
    /* JADX WARN: Code duplicated, block: B:93:0x016b  */
    /* JADX WARN: Code duplicated, block: B:95:0x016f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void s(Context context, Executor executor, e eVar, boolean z2) throws Throwable {
        byte[] bArr;
        ?? A2;
        IOException iOException;
        int i2;
        c[] cVarArrL;
        c[] cVarArr;
        b bVar;
        e eVar2;
        c[] cVarArr2;
        ?? r6;
        byte[] bArr2;
        ?? r7;
        boolean z3;
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        byte[] bArr3;
        int i3;
        byte[] bArr4;
        ByteArrayOutputStream byteArrayOutputStream;
        int i4;
        char c2;
        FileInputStream fileInputStreamA;
        boolean zEquals;
        ?? r11;
        boolean z4;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            ?? r15 = 1;
            if (!z2) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j2 = dataInputStream.readLong();
                            dataInputStream.close();
                            z4 = j2 == packageInfo.lastUpdateTime;
                            if (z4) {
                                eVar.l(2, null);
                            }
                        } catch (Throwable th2) {
                            try {
                                dataInputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (IOException unused) {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                if (z4) {
                    Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                    n.c(context, false);
                    return;
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            int i5 = Build.VERSION.SDK_INT;
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            b bVar2 = new b(assets, executor, eVar, name, file2);
            byte[] bArr5 = bVar2.f471c;
            if (bArr5 == null) {
                bVar2.b(3, Integer.valueOf(i5));
            } else {
                try {
                    try {
                        if (file2.exists()) {
                            if (!file2.canWrite()) {
                                bVar2.b(4, null);
                            }
                            if (z3 || !z2) {
                                r11 = 0;
                            } else {
                                r11 = r15;
                            }
                            n.c(context, r11);
                        }
                        try {
                            file2.createNewFile();
                        } catch (IOException unused2) {
                            bVar2.b(4, null);
                            z3 = false;
                        }
                        A2 = bVar2.a(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e2) {
                        eVar.l(6, e2);
                        A2 = 0;
                    } catch (IOException e3) {
                        eVar.l(7, e3);
                        A2 = 0;
                    }
                    if (A2 != 0) {
                        try {
                            if (!Arrays.equals(bArr, f(A2, 4))) {
                                throw new IllegalStateException("Invalid magic");
                            }
                            cVarArrL = l(A2, f(A2, 4), bVar2.f473e);
                            try {
                                A2.close();
                                A2 = A2;
                            } catch (IOException e4) {
                                IOException iOException2 = e4;
                                eVar.l(7, iOException2);
                                A2 = iOException2;
                            }
                            bVar2.g = cVarArrL;
                        } catch (IOException e5) {
                            i2 = 7;
                            eVar.l(7, e5);
                            try {
                                A2.close();
                            } catch (IOException e6) {
                                iOException = e6;
                                eVar.l(i2, iOException);
                                cVarArrL = null;
                                A2 = A2;
                                bVar2.g = cVarArrL;
                                cVarArr = bVar2.g;
                                if (cVarArr != null) {
                                    i4 = Build.VERSION.SDK_INT;
                                    A2 = 34;
                                    if (i4 > 34) {
                                        bVar = bVar2;
                                    } else {
                                        c2 = 24;
                                        if (i4 != 24) {
                                            c2 = 25;
                                            A2 = 25;
                                            c2 = 25;
                                            if (i4 != 25) {
                                                switch (i4) {
                                                    case 31:
                                                    case 32:
                                                    case 33:
                                                    case 34:
                                                        try {
                                                            fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                                            if (fileInputStreamA != null) {
                                                                try {
                                                                    zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                                    if (!zEquals) {
                                                                        throw new IllegalStateException("Invalid magic");
                                                                    }
                                                                    bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                                    fileInputStreamA.close();
                                                                    bVar = bVar2;
                                                                    A2 = zEquals;
                                                                } catch (Throwable th4) {
                                                                    try {
                                                                        fileInputStreamA.close();
                                                                        throw th4;
                                                                    } catch (Throwable th5) {
                                                                        th4.addSuppressed(th5);
                                                                        throw th4;
                                                                    }
                                                                }
                                                            } else {
                                                                if (fileInputStreamA != null) {
                                                                    fileInputStreamA.close();
                                                                }
                                                                bVar = null;
                                                                A2 = c2;
                                                            }
                                                        } catch (FileNotFoundException e7) {
                                                            eVar.l(9, e7);
                                                        } catch (IOException e8) {
                                                            eVar.l(7, e8);
                                                        } catch (IllegalStateException e9) {
                                                            bVar2.g = null;
                                                            eVar.l(8, e9);
                                                        }
                                                        if (bVar == null) {
                                                            bVar = bVar2;
                                                        }
                                                        break;
                                                    default:
                                                        bVar = bVar2;
                                                        break;
                                                }
                                            } else {
                                                fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                                if (fileInputStreamA != null) {
                                                    zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                    if (!zEquals) {
                                                        throw new IllegalStateException("Invalid magic");
                                                    }
                                                    bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                    fileInputStreamA.close();
                                                    bVar = bVar2;
                                                    A2 = zEquals;
                                                } else {
                                                    if (fileInputStreamA != null) {
                                                        fileInputStreamA.close();
                                                    }
                                                    bVar = null;
                                                    A2 = c2;
                                                }
                                                if (bVar == null) {
                                                    bVar = bVar2;
                                                }
                                            }
                                        } else {
                                            fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                            if (fileInputStreamA != null) {
                                                zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                if (!zEquals) {
                                                    throw new IllegalStateException("Invalid magic");
                                                }
                                                bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                fileInputStreamA.close();
                                                bVar = bVar2;
                                                A2 = zEquals;
                                            } else {
                                                if (fileInputStreamA != null) {
                                                    fileInputStreamA.close();
                                                }
                                                bVar = null;
                                                A2 = c2;
                                            }
                                            if (bVar == null) {
                                                bVar = bVar2;
                                            }
                                        }
                                    }
                                } else {
                                    bVar = bVar2;
                                }
                                eVar2 = bVar.f470b;
                                cVarArr2 = bVar.g;
                                r6 = A2;
                                if (cVarArr2 != null) {
                                    if (!bVar.f474f) {
                                        r6 = bArr4;
                                        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    }
                                    try {
                                        r6 = bArr4;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            byteArrayOutputStream.write(bArr);
                                            byteArrayOutputStream.write(bArr4);
                                            if (o(byteArrayOutputStream, bArr4, cVarArr2)) {
                                                bVar.f475h = byteArrayOutputStream.toByteArray();
                                                byteArrayOutputStream.close();
                                                bVar.g = null;
                                                r6 = bArr4;
                                            } else {
                                                eVar2.l(5, null);
                                                bVar.g = null;
                                                byteArrayOutputStream.close();
                                                r6 = bArr4;
                                            }
                                        } catch (Throwable th6) {
                                            try {
                                                byteArrayOutputStream.close();
                                                throw th6;
                                            } catch (Throwable th7) {
                                                th6.addSuppressed(th7);
                                                throw th6;
                                            }
                                        }
                                    } catch (IOException e10) {
                                        eVar2.l(7, e10);
                                    } catch (IllegalStateException e11) {
                                        eVar2.l(8, e11);
                                    }
                                }
                                r6 = bArr4;
                                bArr2 = bVar.f475h;
                                if (bArr2 == null) {
                                    z3 = false;
                                    r15 = 1;
                                } else {
                                    try {
                                        if (!bVar.f474f) {
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        try {
                                            try {
                                                byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                                try {
                                                    fileOutputStream = new FileOutputStream(bVar.f472d);
                                                    try {
                                                        try {
                                                            bArr3 = new byte[512];
                                                            while (true) {
                                                                i3 = byteArrayInputStream.read(bArr3);
                                                                if (i3 > 0) {
                                                                    fileOutputStream.write(bArr3, 0, i3);
                                                                } else {
                                                                    r15 = 1;
                                                                    try {
                                                                        bVar.b(1, null);
                                                                        fileOutputStream.close();
                                                                        byteArrayInputStream.close();
                                                                        bVar.f475h = null;
                                                                        bVar.g = null;
                                                                        z3 = true;
                                                                    } catch (Throwable th8) {
                                                                        th = th8;
                                                                    }
                                                                }
                                                                th = th;
                                                                try {
                                                                    fileOutputStream.close();
                                                                    throw th;
                                                                } catch (Throwable th9) {
                                                                    th.addSuppressed(th9);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            Throwable th11 = th;
                                                            try {
                                                                byteArrayInputStream.close();
                                                                throw th11;
                                                            } catch (Throwable th12) {
                                                                th11.addSuppressed(th12);
                                                                throw th11;
                                                            }
                                                        }
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                }
                                            } catch (FileNotFoundException e12) {
                                                e = e12;
                                                bVar.b(6, e);
                                                r7 = r6;
                                                bVar.f475h = null;
                                                bVar.g = null;
                                                z3 = false;
                                                r15 = r7;
                                            } catch (IOException e13) {
                                                e = e13;
                                                bVar.b(7, e);
                                                r7 = r6;
                                                bVar.f475h = null;
                                                bVar.g = null;
                                                z3 = false;
                                                r15 = r7;
                                            }
                                        } catch (FileNotFoundException e14) {
                                            e = e14;
                                            r6 = 1;
                                            bVar.b(6, e);
                                            r7 = r6;
                                            bVar.f475h = null;
                                            bVar.g = null;
                                            z3 = false;
                                            r15 = r7;
                                        } catch (IOException e15) {
                                            e = e15;
                                            r6 = 1;
                                            bVar.b(7, e);
                                            r7 = r6;
                                            bVar.f475h = null;
                                            bVar.g = null;
                                            z3 = false;
                                            r15 = r7;
                                        }
                                    } catch (Throwable th15) {
                                        bVar.f475h = null;
                                        bVar.g = null;
                                        throw th15;
                                    }
                                }
                                if (z3) {
                                    e(packageInfo, filesDir);
                                }
                                if (z3) {
                                    r11 = 0;
                                } else {
                                    r11 = 0;
                                }
                                n.c(context, r11);
                            }
                            cVarArrL = null;
                            A2 = A2;
                        } catch (IllegalStateException e16) {
                            try {
                                eVar.l(8, e16);
                                try {
                                    A2.close();
                                } catch (IOException e17) {
                                    iOException = e17;
                                    i2 = 7;
                                    eVar.l(i2, iOException);
                                    cVarArrL = null;
                                    A2 = A2;
                                    bVar2.g = cVarArrL;
                                    cVarArr = bVar2.g;
                                    if (cVarArr != null) {
                                        i4 = Build.VERSION.SDK_INT;
                                        A2 = 34;
                                        if (i4 > 34) {
                                            bVar = bVar2;
                                        } else {
                                            c2 = 24;
                                            if (i4 != 24) {
                                                c2 = 25;
                                                A2 = 25;
                                                c2 = 25;
                                                if (i4 != 25) {
                                                    switch (i4) {
                                                        case 31:
                                                        case 32:
                                                        case 33:
                                                        case 34:
                                                            fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                                            if (fileInputStreamA != null) {
                                                                zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                                if (!zEquals) {
                                                                    throw new IllegalStateException("Invalid magic");
                                                                }
                                                                bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                                fileInputStreamA.close();
                                                                bVar = bVar2;
                                                                A2 = zEquals;
                                                            } else {
                                                                if (fileInputStreamA != null) {
                                                                    fileInputStreamA.close();
                                                                }
                                                                bVar = null;
                                                                A2 = c2;
                                                            }
                                                            if (bVar == null) {
                                                                bVar = bVar2;
                                                            }
                                                            break;
                                                        default:
                                                            bVar = bVar2;
                                                            break;
                                                    }
                                                } else {
                                                    fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                                    if (fileInputStreamA != null) {
                                                        zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                        if (!zEquals) {
                                                            throw new IllegalStateException("Invalid magic");
                                                        }
                                                        bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                        fileInputStreamA.close();
                                                        bVar = bVar2;
                                                        A2 = zEquals;
                                                    } else {
                                                        if (fileInputStreamA != null) {
                                                            fileInputStreamA.close();
                                                        }
                                                        bVar = null;
                                                        A2 = c2;
                                                    }
                                                    if (bVar == null) {
                                                        bVar = bVar2;
                                                    }
                                                }
                                            } else {
                                                fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                                if (fileInputStreamA != null) {
                                                    zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                    if (!zEquals) {
                                                        throw new IllegalStateException("Invalid magic");
                                                    }
                                                    bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                    fileInputStreamA.close();
                                                    bVar = bVar2;
                                                    A2 = zEquals;
                                                } else {
                                                    if (fileInputStreamA != null) {
                                                        fileInputStreamA.close();
                                                    }
                                                    bVar = null;
                                                    A2 = c2;
                                                }
                                                if (bVar == null) {
                                                    bVar = bVar2;
                                                }
                                            }
                                        }
                                    } else {
                                        bVar = bVar2;
                                    }
                                    eVar2 = bVar.f470b;
                                    cVarArr2 = bVar.g;
                                    r6 = A2;
                                    if (cVarArr2 != null) {
                                        if (!bVar.f474f) {
                                            r6 = bArr4;
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        r6 = bArr4;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        byteArrayOutputStream.write(bArr);
                                        byteArrayOutputStream.write(bArr4);
                                        if (o(byteArrayOutputStream, bArr4, cVarArr2)) {
                                            eVar2.l(5, null);
                                            bVar.g = null;
                                            byteArrayOutputStream.close();
                                            r6 = bArr4;
                                        } else {
                                            bVar.f475h = byteArrayOutputStream.toByteArray();
                                            byteArrayOutputStream.close();
                                            bVar.g = null;
                                            r6 = bArr4;
                                        }
                                    }
                                    r6 = bArr4;
                                    bArr2 = bVar.f475h;
                                    if (bArr2 == null) {
                                        if (!bVar.f474f) {
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                        fileOutputStream = new FileOutputStream(bVar.f472d);
                                        bArr3 = new byte[512];
                                        while (true) {
                                            i3 = byteArrayInputStream.read(bArr3);
                                            if (i3 > 0) {
                                                fileOutputStream.write(bArr3, 0, i3);
                                            } else {
                                                r15 = 1;
                                                bVar.b(1, null);
                                                fileOutputStream.close();
                                                byteArrayInputStream.close();
                                                bVar.f475h = null;
                                                bVar.g = null;
                                                z3 = true;
                                            }
                                            th = th;
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    }
                                    z3 = false;
                                    r15 = 1;
                                    if (z3) {
                                        e(packageInfo, filesDir);
                                    }
                                    if (z3) {
                                        r11 = 0;
                                    } else {
                                        r11 = 0;
                                    }
                                    n.c(context, r11);
                                }
                                cVarArrL = null;
                                A2 = A2;
                            } catch (Throwable th16) {
                                th = th16;
                                Throwable th17 = th;
                                try {
                                    A2.close();
                                    throw th17;
                                } catch (IOException e18) {
                                    eVar.l(7, e18);
                                    throw th17;
                                }
                            }
                        }
                    }
                    cVarArr = bVar2.g;
                    if (cVarArr != null) {
                        i4 = Build.VERSION.SDK_INT;
                        A2 = 34;
                        if (i4 > 34) {
                            bVar = bVar2;
                        } else {
                            c2 = 24;
                            if (i4 != 24) {
                                c2 = 25;
                                A2 = 25;
                                c2 = 25;
                                if (i4 != 25) {
                                    switch (i4) {
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                            fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                            if (fileInputStreamA != null) {
                                                zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                                if (!zEquals) {
                                                    throw new IllegalStateException("Invalid magic");
                                                }
                                                bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                                fileInputStreamA.close();
                                                bVar = bVar2;
                                                A2 = zEquals;
                                            } else {
                                                if (fileInputStreamA != null) {
                                                    fileInputStreamA.close();
                                                }
                                                bVar = null;
                                                A2 = c2;
                                            }
                                            if (bVar == null) {
                                                bVar = bVar2;
                                            }
                                            break;
                                        default:
                                            bVar = bVar2;
                                            break;
                                    }
                                } else {
                                    fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                    if (fileInputStreamA != null) {
                                        zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                        if (!zEquals) {
                                            throw new IllegalStateException("Invalid magic");
                                        }
                                        bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                        fileInputStreamA.close();
                                        bVar = bVar2;
                                        A2 = zEquals;
                                    } else {
                                        if (fileInputStreamA != null) {
                                            fileInputStreamA.close();
                                        }
                                        bVar = null;
                                        A2 = c2;
                                    }
                                    if (bVar == null) {
                                        bVar = bVar2;
                                    }
                                }
                            } else {
                                fileInputStreamA = bVar2.a(assets, "dexopt/baseline.profm");
                                if (fileInputStreamA != null) {
                                    zEquals = Arrays.equals(f486c, f(fileInputStreamA, 4));
                                    if (!zEquals) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    bVar2.g = i(fileInputStreamA, f(fileInputStreamA, 4), bArr5, cVarArr);
                                    fileInputStreamA.close();
                                    bVar = bVar2;
                                    A2 = zEquals;
                                } else {
                                    if (fileInputStreamA != null) {
                                        fileInputStreamA.close();
                                    }
                                    bVar = null;
                                    A2 = c2;
                                }
                                if (bVar == null) {
                                    bVar = bVar2;
                                }
                            }
                        }
                    } else {
                        bVar = bVar2;
                    }
                    eVar2 = bVar.f470b;
                    cVarArr2 = bVar.g;
                    r6 = A2;
                    if (cVarArr2 != null && (bArr4 = bVar.f471c) != null) {
                        if (!bVar.f474f) {
                            r6 = bArr4;
                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        }
                        r6 = bArr4;
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(bArr);
                        byteArrayOutputStream.write(bArr4);
                        if (o(byteArrayOutputStream, bArr4, cVarArr2)) {
                            eVar2.l(5, null);
                            bVar.g = null;
                            byteArrayOutputStream.close();
                            r6 = bArr4;
                        } else {
                            bVar.f475h = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            bVar.g = null;
                            r6 = bArr4;
                        }
                    }
                    r6 = bArr4;
                    bArr2 = bVar.f475h;
                    if (bArr2 == null) {
                        if (!bVar.f474f) {
                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        }
                        byteArrayInputStream = new ByteArrayInputStream(bArr2);
                        fileOutputStream = new FileOutputStream(bVar.f472d);
                        bArr3 = new byte[512];
                        while (true) {
                            i3 = byteArrayInputStream.read(bArr3);
                            if (i3 > 0) {
                                fileOutputStream.write(bArr3, 0, i3);
                            } else {
                                r15 = 1;
                                bVar.b(1, null);
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                bVar.f475h = null;
                                bVar.g = null;
                                z3 = true;
                            }
                            th = th;
                            fileOutputStream.close();
                            throw th;
                        }
                    }
                    z3 = false;
                    r15 = 1;
                    if (z3) {
                        e(packageInfo, filesDir);
                    }
                    if (z3) {
                        r11 = 0;
                    } else {
                        r11 = 0;
                    }
                    n.c(context, r11);
                } catch (Throwable th18) {
                    th = th18;
                }
                bVar2.f474f = true;
                bArr = f485b;
            }
            z3 = false;
            if (z3) {
                r11 = 0;
            } else {
                r11 = 0;
            }
            n.c(context, r11);
        } catch (PackageManager.NameNotFoundException e19) {
            eVar.l(7, e19);
            n.c(context, false);
        }
    }

    public static void t(ByteArrayOutputStream byteArrayOutputStream, long j2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((j2 >> (i3 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void u(ByteArrayOutputStream byteArrayOutputStream, int i2) throws IOException {
        t(byteArrayOutputStream, i2, 2);
    }
}
