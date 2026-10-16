// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package okhttp3.internal.publicsuffix;

import g2.y0;
import h0.g;
import i1.i;
import i1.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import m0.a;
import q1.e;
import q2.k;
import q2.m;
import u1.b;
import v1.d;
import w1.j4;
import w1.o2;
import w2.o;
import w2.r;
import w2.z;
import y.f;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f2813e = {42};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f2814f = a.k("*");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f2815g = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2816a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f2817b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f2818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f2819d;

    public static List c(String str) {
        List listH = d.H(str, new char[]{'.'});
        if (listH.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        if (!e.a(listH.get(listH.size() - 1), "")) {
            return listH;
        }
        int size = listH.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            o2.h(j4.c(size, "Requested element count ", " is less than zero."));
            return null;
        }
        q qVar = q.f2104c;
        if (size == 0) {
            return qVar;
        }
        if (size >= listH.size()) {
            return i.E(listH);
        }
        if (size == 1) {
            if (listH.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            return a.k(listH.get(0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = listH.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayList : a.k(arrayList.get(0));
        }
        return qVar;
    }

    public final String a(String str) {
        String strA;
        String strA2;
        String strA3;
        List listH;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List listC = c(unicode);
        List listH2 = q.f2104c;
        int i3 = 0;
        if (this.f2816a.get() || !this.f2816a.compareAndSet(false, true)) {
            try {
                this.f2817b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z2 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z2 = true;
                    } catch (IOException e3) {
                        m mVar = m.f3156a;
                        m.f3156a.getClass();
                        m.g("Failed to read public suffix list", 5, e3);
                        if (z2) {
                        }
                    }
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f2818c == null) {
            o2.k("Unable to load publicsuffixes.gz resource from the classpath.");
            return null;
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i4 = 0; i4 < size3; i4++) {
            String str2 = (String) listC.get(i4);
            Charset charset = StandardCharsets.UTF_8;
            charset.getClass();
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            bArr[i4] = bytes;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                strA = null;
                break;
            }
            byte[] bArr2 = this.f2818c;
            if (bArr2 == null) {
                e.c("publicSuffixListBytes");
                throw null;
            }
            strA = g.a(bArr2, bArr, i5);
            if (strA != null) {
                break;
            }
            i5++;
        }
        if (size3 <= 1) {
            strA2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                strA2 = null;
                break;
            }
            bArr3[i6] = f2813e;
            byte[] bArr4 = this.f2818c;
            if (bArr4 == null) {
                e.c("publicSuffixListBytes");
                throw null;
            }
            strA2 = g.a(bArr4, bArr3, i6);
            if (strA2 != null) {
                break;
            }
            i6++;
        }
        if (strA2 == null) {
            strA3 = null;
            break;
        }
        int i7 = size3 - 1;
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                strA3 = null;
                break;
            }
            byte[] bArr5 = this.f2819d;
            if (bArr5 == null) {
                e.c("publicSuffixExceptionListBytes");
                throw null;
            }
            strA3 = g.a(bArr5, bArr, i8);
            if (strA3 != null) {
                break;
            }
            i8++;
        }
        if (strA3 != null) {
            listH = d.H("!".concat(strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listH = f2814f;
        } else {
            List listH3 = strA != null ? d.H(strA, new char[]{'.'}) : listH2;
            if (strA2 != null) {
                listH2 = d.H(strA2, new char[]{'.'});
            }
            listH = listH3.size() > listH2.size() ? listH3 : listH2;
        }
        if (listC.size() == listH.size() && ((String) listH.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listH.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listH.size();
        } else {
            size = listC.size();
            size2 = listH.size() + 1;
        }
        int i9 = size - size2;
        b y0Var = new y0(c(str));
        if (i9 < 0) {
            o2.h(j4.c(i9, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i9 != 0) {
            y0Var = new u1.a(y0Var, i9);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : y0Var) {
            i3++;
            if (i3 > 1) {
                sb.append((CharSequence) ".");
            }
            k.a(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                Logger logger = o.f5792a;
                r rVar = new r(new w2.m(new w2.e(resourceAsStream, new z(), 1)));
                try {
                    long j3 = rVar.readInt();
                    rVar.p(j3);
                    byte[] bArrB = rVar.f5799d.B(j3);
                    long j4 = rVar.readInt();
                    rVar.p(j4);
                    byte[] bArrB2 = rVar.f5799d.B(j4);
                    rVar.close();
                    synchronized (this) {
                        this.f2818c = bArrB;
                        this.f2819d = bArrB2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        f.c(rVar, th);
                        throw th2;
                    }
                }
            }
            this.f2817b.countDown();
        } catch (Throwable th3) {
            this.f2817b.countDown();
            throw th3;
        }
    }
}
