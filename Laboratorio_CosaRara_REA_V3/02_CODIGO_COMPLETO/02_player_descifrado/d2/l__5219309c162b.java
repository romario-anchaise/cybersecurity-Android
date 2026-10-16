// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f596c = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})\\.ndjson$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f598b = new HashMap();

    public l(File file) {
        this.f597a = file;
    }

    public static k e(File file, String str, boolean z2) throws IOException {
        MessageDigest messageDigest;
        int i3;
        String str2;
        if (z2) {
            messageDigest = null;
        } else {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e3) {
                throw new AssertionError("SHA-256 unavailable", e3);
            }
        }
        byte[] bArr = new byte[65536];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 65536);
        long j3 = 0;
        while (true) {
            try {
                int i4 = bufferedInputStream.read(bArr);
                i3 = 0;
                if (i4 == -1) {
                    break;
                }
                if (messageDigest != null) {
                    messageDigest.update(bArr, 0, i4);
                }
                while (i3 < i4) {
                    if (bArr[i3] == 10) {
                        j3++;
                    }
                    i3++;
                }
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        bufferedInputStream.close();
        long length = file.length();
        long jLastModified = file.lastModified();
        if (z2) {
            str2 = "";
        } else {
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = new char[bArrDigest.length * 2];
            char[] charArray = "0123456789abcdef".toCharArray();
            while (i3 < bArrDigest.length) {
                byte b3 = bArrDigest[i3];
                int i5 = i3 * 2;
                cArr[i5] = charArray[(b3 & 255) >>> 4];
                cArr[i5 + 1] = charArray[b3 & 15];
                i3++;
            }
            str2 = new String(cArr);
        }
        return new k(str, j3, length, jLastModified, str2, z2);
    }

    public static String f(File file) {
        if (!file.isFile()) {
            return null;
        }
        Matcher matcher = f596c.matcher(file.getName());
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        try {
            LocalDate.parse(strGroup);
            return strGroup;
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    public final void a(File file) {
        final String absolutePath = file.getAbsolutePath();
        this.f598b.keySet().removeIf(new Predicate() { // from class: d2.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((j) obj).f587a.equals(absolutePath);
            }
        });
    }

    public final synchronized List b(String str) {
        k kVarE;
        File[] fileArrListFiles = this.f597a.listFiles();
        if (fileArrListFiles == null) {
            if (!this.f597a.exists()) {
                return Collections.EMPTY_LIST;
            }
            throw new IOException("cannot list keylog directory: " + this.f597a);
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            String strF = f(file);
            if (strF != null) {
                if (strF.equals(str)) {
                    kVarE = e(file, strF, true);
                } else {
                    j jVar = new j(file.length(), file.lastModified(), file.getAbsolutePath());
                    HashMap map = this.f598b;
                    k kVar = (k) map.get(jVar);
                    if (kVar != null) {
                        kVarE = kVar;
                    } else {
                        a(file);
                        kVarE = e(file, strF, false);
                        map.put(jVar, kVarE);
                    }
                }
                arrayList.add(kVarE);
            }
        }
        arrayList.sort(Comparator.comparing(new i(0)).reversed());
        return arrayList;
    }

    public final synchronized void c(File file) {
        if (file.exists()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                long length = randomAccessFile.length();
                if (length == 0) {
                    randomAccessFile.close();
                    return;
                }
                long j3 = length - 1;
                randomAccessFile.seek(j3);
                if (randomAccessFile.read() == 10) {
                    randomAccessFile.close();
                    return;
                }
                byte[] bArr = new byte[65536];
                long j4 = 0;
                while (j3 > 0 && j4 == 0) {
                    int iMin = (int) Math.min(65536, j3);
                    j3 -= (long) iMin;
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(bArr, 0, iMin);
                    for (int i3 = iMin - 1; i3 >= 0; i3--) {
                        if (bArr[i3] == 10) {
                            j4 = ((long) i3) + j3 + 1;
                            break;
                        }
                    }
                }
                randomAccessFile.setLength(j4);
                randomAccessFile.close();
                a(file);
                return;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
            throw th;
        }
    }

    public final synchronized void d() {
        try {
            File[] fileArrListFiles = this.f597a.listFiles();
            if (fileArrListFiles == null) {
                if (this.f597a.exists()) {
                    throw new IOException("cannot list keylog directory: " + this.f597a);
                }
                return;
            }
            IOException iOException = null;
            for (File file : fileArrListFiles) {
                if (f(file) != null) {
                    try {
                        c(file);
                    } catch (IOException e3) {
                        if (iOException == null) {
                            iOException = e3;
                        } else {
                            iOException.addSuppressed(e3);
                        }
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
