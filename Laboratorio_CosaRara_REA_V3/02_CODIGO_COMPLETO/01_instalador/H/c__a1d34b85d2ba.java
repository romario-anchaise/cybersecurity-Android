// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import androidx.lifecycle.N;
import androidx.lifecycle.Q;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import k1.C0186b;
import k1.C0189e;
import k1.C0193i;
import k1.C0196l;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import p009f.InterfaceC0112b;

/* JADX INFO: renamed from: H.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0028c implements Q, O.e, p008e0.e, InterfaceC0112b, p013i.z, p022m0.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0028c f191b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f192a;

    public /* synthetic */ C0028c(int i2) {
        this.f192a = i2;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    public static final String e(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6 = -1;
        byte[] bArr3 = PublicSuffixDatabase.f3988e;
        int length = bArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = (i7 + length) / 2;
            while (i8 > i6 && bArr[i8] != 10) {
                i8 += i6;
            }
            int i9 = i8 + 1;
            int i10 = 1;
            while (true) {
                i3 = i9 + i10;
                if (bArr[i3] == 10) {
                    break;
                }
                i10++;
            }
            int i11 = i3 - i9;
            int i12 = i2;
            boolean z3 = false;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (z3) {
                    i4 = 46;
                    z2 = false;
                } else {
                    byte b2 = bArr2[i12][i13];
                    byte[] bArr4 = Y0.b.f1119a;
                    int i15 = b2 & 255;
                    z2 = z3;
                    i4 = i15;
                }
                byte b3 = bArr[i9 + i14];
                byte[] bArr5 = Y0.b.f1119a;
                i5 = i4 - (b3 & 255);
                if (i5 != 0) {
                    break;
                }
                i14++;
                i13++;
                if (i14 == i11) {
                    break;
                }
                if (bArr2[i12].length != i13) {
                    z3 = z2;
                } else {
                    if (i12 == bArr2.length - 1) {
                        break;
                    }
                    i12++;
                    z3 = true;
                    i13 = -1;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i16 = i11 - i14;
                    int length2 = bArr2[i12].length - i13;
                    int length3 = bArr2.length;
                    for (int i17 = i12 + 1; i17 < length3; i17++) {
                        length2 += bArr2[i17].length;
                    }
                    if (length2 < i16) {
                        length = i8;
                    } else if (length2 <= i16) {
                        Charset charset = StandardCharsets.UTF_8;
                        F0.i.d(charset, "UTF_8");
                        return new String(bArr, i9, i11, charset);
                    }
                }
                i7 = i3 + 1;
            } else {
                length = i8;
            }
            i6 = -1;
        }
        return null;
    }

    public static final void g(C0189e c0189e, long j2, boolean z2) {
        C0189e c0189e2;
        ReentrantLock reentrantLock = C0189e.f3471h;
        if (C0189e.f3475l == null) {
            C0189e.f3475l = new C0189e();
            C0186b c0186b = new C0186b("Okio Watchdog");
            c0186b.setDaemon(true);
            c0186b.start();
        }
        long jNanoTime = System.nanoTime();
        if (j2 != 0 && z2) {
            c0189e.g = Math.min(j2, c0189e.c() - jNanoTime) + jNanoTime;
        } else if (j2 != 0) {
            c0189e.g = j2 + jNanoTime;
        } else {
            if (!z2) {
                throw new AssertionError();
            }
            c0189e.g = c0189e.c();
        }
        long j3 = c0189e.g - jNanoTime;
        C0189e c0189e3 = C0189e.f3475l;
        F0.i.b(c0189e3);
        while (true) {
            c0189e2 = c0189e3.f3477f;
            if (c0189e2 == null || j3 < c0189e2.g - jNanoTime) {
                break;
            }
            F0.i.b(c0189e2);
            c0189e3 = c0189e2;
        }
        c0189e.f3477f = c0189e2;
        c0189e3.f3477f = c0189e;
        if (c0189e3 == C0189e.f3475l) {
            C0189e.f3472i.signal();
        }
    }

    public static final boolean h(k1.z zVar) {
        k1.z zVar2 = l1.f.f3546e;
        zVar.getClass();
        C0196l c0196l = l1.c.f3536a;
        C0196l c0196lN = zVar.f3518a;
        int iJ = C0196l.j(c0196lN, c0196l);
        if (iJ == -1) {
            iJ = C0196l.j(c0196lN, l1.c.f3537b);
        }
        if (iJ != -1) {
            c0196lN = C0196l.n(c0196lN, iJ + 1, 0, 2);
        } else if (zVar.g() != null && c0196lN.c() == 2) {
            c0196lN = C0196l.f3483d;
        }
        return !M0.m.L(c0196lN.p(), ".class", true);
    }

    public static ArrayList i(List list) {
        F0.i.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((X0.x) obj) != X0.x.f1090b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(p036u0.h.q(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((X0.x) it.next()).f1096a);
        }
        return arrayList2;
    }

    public static C0189e k() throws InterruptedException {
        C0189e c0189e = C0189e.f3475l;
        F0.i.b(c0189e);
        C0189e c0189e2 = c0189e.f3477f;
        if (c0189e2 == null) {
            long jNanoTime = System.nanoTime();
            C0189e.f3472i.await(C0189e.f3473j, TimeUnit.MILLISECONDS);
            C0189e c0189e3 = C0189e.f3475l;
            F0.i.b(c0189e3);
            if (c0189e3.f3477f != null || System.nanoTime() - jNanoTime < C0189e.f3474k) {
                return null;
            }
            return C0189e.f3475l;
        }
        long jNanoTime2 = c0189e2.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            C0189e.f3472i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        C0189e c0189e4 = C0189e.f3475l;
        F0.i.b(c0189e4);
        c0189e4.f3477f = c0189e2.f3477f;
        c0189e2.f3477f = null;
        c0189e2.f3476e = 2;
        return c0189e2;
    }

    public static byte[] m(List list) {
        F0.i.e(list, "protocols");
        C0193i c0193i = new C0193i();
        for (String str : i(list)) {
            c0193i.Q(str.length());
            c0193i.U(str);
        }
        return c0193i.C(c0193i.f3482b);
    }

    public static C0196l n(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (l1.b.a(str.charAt(i3 + 1)) + (l1.b.a(str.charAt(i3)) << 4));
        }
        return new C0196l(bArr);
    }

    public static C0196l p(String str) {
        F0.i.e(str, "<this>");
        byte[] bytes = str.getBytes(M0.a.f360a);
        F0.i.d(bytes, "getBytes(...)");
        C0196l c0196l = new C0196l(bytes);
        c0196l.f3486c = str;
        return c0196l;
    }

    public static k1.z q(String str, boolean z2) {
        F0.i.e(str, "<this>");
        C0196l c0196l = l1.c.f3536a;
        C0193i c0193i = new C0193i();
        c0193i.U(str);
        return l1.c.d(c0193i, z2);
    }

    public static k1.z s(File file) {
        String str = k1.z.f3517b;
        String string = file.toString();
        F0.i.d(string, "toString(...)");
        return q(string, false);
    }

    public static boolean u(J.b bVar, Editable editable, int i2, int i3, boolean z2) {
        int iMin;
        if (editable == null || i2 < 0 || i3 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            return false;
        }
        if (z2) {
            int iMax = Math.max(i2, 0);
            int length = editable.length();
            if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                loop0: while (true) {
                    boolean z3 = false;
                    while (true) {
                        if (iMax == 0) {
                            break loop0;
                        }
                        selectionStart--;
                        if (selectionStart < 0) {
                            if (!z3) {
                                selectionStart = 0;
                                break loop0;
                            }
                            break loop0;
                        }
                        char cCharAt = editable.charAt(selectionStart);
                        if (z3) {
                            if (Character.isHighSurrogate(cCharAt)) {
                                iMax--;
                            }
                        } else if (!Character.isSurrogate(cCharAt)) {
                            iMax--;
                        } else if (!Character.isHighSurrogate(cCharAt)) {
                            z3 = true;
                        }
                        selectionStart = -1;
                        break loop0;
                    }
                }
            }
            selectionStart = -1;
            break loop0;
            int iMax2 = Math.max(i3, 0);
            iMin = editable.length();
            if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                loop2: while (true) {
                    boolean z4 = false;
                    while (true) {
                        if (iMax2 != 0) {
                            if (selectionEnd >= iMin) {
                                if (!z4) {
                                    break loop2;
                                }
                                break loop2;
                            }
                            char cCharAt2 = editable.charAt(selectionEnd);
                            if (z4) {
                                if (Character.isLowSurrogate(cCharAt2)) {
                                    iMax2--;
                                    selectionEnd++;
                                }
                            } else if (!Character.isSurrogate(cCharAt2)) {
                                iMax2--;
                                selectionEnd++;
                            } else if (!Character.isLowSurrogate(cCharAt2)) {
                                selectionEnd++;
                                z4 = true;
                            }
                            iMin = -1;
                            break loop2;
                        }
                        iMin = selectionEnd;
                        break loop2;
                    }
                }
            }
            iMin = -1;
            break loop2;
            if (selectionStart == -1 || iMin == -1) {
                return false;
            }
        } else {
            selectionStart = Math.max(selectionStart - i2, 0);
            iMin = Math.min(selectionEnd + i3, editable.length());
        }
        A[] aArr = (A[]) editable.getSpans(selectionStart, iMin, A.class);
        if (aArr == null || aArr.length <= 0) {
            return false;
        }
        for (A a2 : aArr) {
            int spanStart = editable.getSpanStart(a2);
            int spanEnd = editable.getSpanEnd(a2);
            selectionStart = Math.min(spanStart, selectionStart);
            iMin = Math.max(spanEnd, iMin);
        }
        int iMax3 = Math.max(selectionStart, 0);
        int iMin2 = Math.min(iMin, editable.length());
        bVar.beginBatchEdit();
        editable.delete(iMax3, iMin2);
        bVar.endBatchEdit();
        return true;
    }

    public static boolean v() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    @Override // androidx.lifecycle.Q
    public N b(Class cls) {
        switch (this.f192a) {
            case 7:
                return new N.b();
            default:
                return new androidx.fragment.app.u(true);
        }
    }

    @Override // p008e0.e
    public boolean f() {
        return true;
    }

    @Override // p013i.z
    public boolean j(p013i.n nVar) {
        return false;
    }

    @Override // O.e
    public void l(int i2, Serializable serializable) {
        String str;
        switch (this.f192a) {
            case 8:
                break;
            default:
                switch (i2) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i2 == 6 || i2 == 7 || i2 == 8) {
                    Log.e("ProfileInstaller", str, (Throwable) serializable);
                } else {
                    Log.d("ProfileInstaller", str);
                }
                break;
        }
    }

    @Override // p022m0.o
    public Object o() {
        switch (this.f192a) {
            case 22:
                return new TreeSet();
            case 23:
                return new LinkedHashSet();
            case 24:
                return new ArrayDeque();
            case 25:
                return new ArrayList();
            case 26:
                return new ConcurrentSkipListMap();
            case 27:
                return new ConcurrentHashMap();
            case 28:
                return new TreeMap();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // O.e
    public void r() {
        switch (this.f192a) {
            case 8:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    public Signature[] t(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public boolean w(CharSequence charSequence) {
        return false;
    }

    private final void x() {
    }

    @Override // p008e0.e
    public void d() {
    }

    private final void y(int i2, Serializable serializable) {
    }

    @Override // p013i.z
    public void a(p013i.n nVar, boolean z2) {
    }
}
