// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package okhttp3.internal.publicsuffix;

import F0.i;
import H.C0028c;
import L0.b;
import L0.c;
import L0.g;
import M0.e;
import f1.d;
import f1.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k1.C;
import k1.s;
import p029q.j;
import p036u0.f;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f3988e = {42};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f3989f = j.m("*");
    public static final PublicSuffixDatabase g = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3990a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f3991b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f3992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f3993d;

    public static List c(String str) {
        List listE0 = e.e0(str, new char[]{'.'});
        if (!i.a(f.x(listE0), "")) {
            return listE0;
        }
        int size = listE0.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(("Requested element count " + size + " is less than zero.").toString());
        }
        n nVar = n.f4146a;
        if (size == 0) {
            return nVar;
        }
        if (size >= listE0.size()) {
            return f.B(listE0);
        }
        if (size == 1) {
            return j.m(f.s(listE0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = listE0.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayList : j.m(arrayList.get(0));
        }
        return nVar;
    }

    public final String a(String str) {
        String strE;
        String strE2;
        String strE3;
        List listE0;
        int size;
        int size2;
        int i2 = 0;
        int i3 = 1;
        String unicode = IDN.toUnicode(str);
        i.d(unicode, "unicodeDomain");
        List listC = c(unicode);
        if (this.f3990a.get() || !this.f3990a.compareAndSet(false, true)) {
            try {
                this.f3991b.await();
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
                    } catch (IOException e2) {
                        f1.n nVar = f1.n.f2736a;
                        f1.n.f2736a.getClass();
                        f1.n.i("Failed to read public suffix list", 5, e2);
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
        if (this.f3992c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i4 = 0; i4 < size3; i4++) {
            String str2 = (String) listC.get(i4);
            Charset charset = StandardCharsets.UTF_8;
            i.d(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            i.d(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i4] = bytes;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                strE = null;
                break;
            }
            byte[] bArr2 = this.f3992c;
            if (bArr2 == null) {
                i.h("publicSuffixListBytes");
                throw null;
            }
            strE = C0028c.e(bArr2, bArr, i5);
            if (strE != null) {
                break;
            }
            i5++;
        }
        if (size3 <= 1) {
            strE2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                strE2 = null;
                break;
            }
            bArr3[i6] = f3988e;
            byte[] bArr4 = this.f3992c;
            if (bArr4 == null) {
                i.h("publicSuffixListBytes");
                throw null;
            }
            strE2 = C0028c.e(bArr4, bArr3, i6);
            if (strE2 != null) {
                break;
            }
            i6++;
        }
        if (strE2 == null) {
            strE3 = null;
            break;
        }
        int i7 = size3 - 1;
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                strE3 = null;
                break;
            }
            byte[] bArr5 = this.f3993d;
            if (bArr5 == null) {
                i.h("publicSuffixExceptionListBytes");
                throw null;
            }
            strE3 = C0028c.e(bArr5, bArr, i8);
            if (strE3 != null) {
                break;
            }
            i8++;
        }
        if (strE3 != null) {
            listE0 = e.e0("!".concat(strE3), new char[]{'.'});
        } else if (strE == null && strE2 == null) {
            listE0 = f3989f;
        } else {
            List listE1 = n.f4146a;
            List listE2 = strE != null ? e.e0(strE, new char[]{'.'}) : listE1;
            if (strE2 != null) {
                listE1 = e.e0(strE2, new char[]{'.'});
            }
            listE0 = listE2.size() > listE1.size() ? listE2 : listE1;
        }
        if (listC.size() == listE0.size() && ((String) listE0.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listE0.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listE0.size();
        } else {
            size = listC.size();
            size2 = listE0.size() + 1;
        }
        int i9 = size - size2;
        c gVar = new g(i3, c(str));
        if (i9 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i9 + " is less than zero.").toString());
        }
        if (i9 != 0) {
            gVar = new b(gVar, i9);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : gVar) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ".");
            }
            d.b(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        i.d(string, "toString(...)");
        return string;
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream == null) {
                this.f3991b.countDown();
                return;
            }
            C cF = l.f(new s(l.W(resourceAsStream)));
            try {
                long jR = cF.r();
                cF.z(jR);
                byte[] bArrC = cF.f3442b.C(jR);
                long jR2 = cF.r();
                cF.z(jR2);
                byte[] bArrC2 = cF.f3442b.C(jR2);
                l.m(cF, null);
                synchronized (this) {
                    this.f3992c = bArrC;
                    this.f3993d = bArrC2;
                }
                this.f3991b.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    l.m(cF, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.f3991b.countDown();
            throw th3;
        }
    }
}
