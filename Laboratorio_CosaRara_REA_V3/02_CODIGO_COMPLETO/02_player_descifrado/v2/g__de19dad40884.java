// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import i2.v;
import i2.y;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import m2.l;
import w1.o2;
import w2.k;
import w2.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List f3304w = m0.a.k(v.f2262e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2.c f3305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f3306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f3308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m2.i f3311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f3312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f3313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f3314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l2.c f3315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f3317m;
    public final ArrayDeque n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque f3318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f3319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3321r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f3322s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3323t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3324u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3325v;

    public g(l2.e eVar, b2.d dVar, i2.c cVar, Random random, long j3, long j4) {
        eVar.getClass();
        this.f3305a = cVar;
        this.f3306b = random;
        this.f3307c = j3;
        this.f3308d = null;
        this.f3309e = j4;
        this.f3315k = eVar.e();
        this.n = new ArrayDeque();
        this.f3318o = new ArrayDeque();
        this.f3321r = -1;
        String str = dVar.f265b;
        if (!"GET".equals(str)) {
            b2.a.l(str, "Request must be GET: ");
            throw null;
        }
        k kVar = k.f5778f;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f3310f = e0.i.e(bArr).a();
    }

    public final void a(y yVar, g0.k kVar) {
        int i3 = yVar.f2290f;
        if (i3 != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + i3 + ' ' + yVar.f2289e + '\'');
        }
        String strD = y.d(yVar, "Connection");
        if (!"Upgrade".equalsIgnoreCase(strD)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strD + '\'');
        }
        String strD2 = y.d(yVar, "Upgrade");
        if (!"websocket".equalsIgnoreCase(strD2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strD2 + '\'');
        }
        String strD3 = y.d(yVar, "Sec-WebSocket-Accept");
        k kVar2 = k.f5778f;
        String strA = e0.i.d(this.f3310f + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").b("SHA-1").a();
        if (q1.e.a(strA, strD3)) {
            if (kVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + strD3 + '\'');
    }

    public final void b(String str, int i3) {
        String str2;
        synchronized (this) {
            k kVarD = null;
            try {
                if (i3 < 1000 || i3 >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i3;
                } else if ((1004 > i3 || i3 >= 1007) && (1015 > i3 || i3 >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i3 + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    k kVar = k.f5778f;
                    kVarD = e0.i.d(str);
                    if (kVarD.f5779c.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.f3323t && !this.f3320q) {
                    this.f3320q = true;
                    this.f3318o.add(new c(i3, kVarD));
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Exception exc, y yVar) {
        synchronized (this) {
            if (this.f3323t) {
                return;
            }
            this.f3323t = true;
            l lVar = this.f3317m;
            this.f3317m = null;
            i iVar = this.f3313i;
            this.f3313i = null;
            j jVar = this.f3314j;
            this.f3314j = null;
            this.f3315k.e();
            try {
                this.f3305a.k(this, exc, yVar);
            } finally {
                if (lVar != null) {
                    j2.b.d(lVar);
                }
                if (iVar != null) {
                    j2.b.d(iVar);
                }
                if (jVar != null) {
                    j2.b.d(jVar);
                }
            }
        }
    }

    public final void d(String str, l lVar) {
        h hVar = this.f3308d;
        hVar.getClass();
        synchronized (this) {
            try {
                this.f3316l = str;
                this.f3317m = lVar;
                this.f3314j = new j(lVar.f2739d, this.f3306b, hVar.f3326a, hVar.f3328c, this.f3309e);
                this.f3312h = new e(this);
                long j3 = this.f3307c;
                if (j3 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j3);
                    this.f3315k.c(new f(str.concat(" ping"), this, nanos), nanos);
                }
                if (!this.f3318o.isEmpty()) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3313i = new i(lVar.f2738c, this, hVar.f3326a, hVar.f3330e);
    }

    public final void e() {
        while (this.f3321r == -1) {
            i iVar = this.f3313i;
            iVar.getClass();
            iVar.w();
            if (iVar.f3340k) {
                iVar.d();
            } else {
                w2.h hVar = iVar.n;
                int i3 = iVar.f3337h;
                if (i3 != 1 && i3 != 2) {
                    byte[] bArr = j2.b.f2361a;
                    String hexString = Integer.toHexString(i3);
                    hexString.getClass();
                    throw new ProtocolException("Unknown opcode: ".concat(hexString));
                }
                while (true) {
                    if (!iVar.f3336g) {
                        long j3 = iVar.f3338i;
                        if (j3 > 0) {
                            iVar.f3332c.b(j3, hVar);
                        }
                        if (iVar.f3339j) {
                            if (iVar.f3341l) {
                                a aVar = iVar.f3343o;
                                if (aVar == null) {
                                    aVar = new a(1, iVar.f3335f);
                                    iVar.f3343o = aVar;
                                }
                                Inflater inflater = (Inflater) aVar.f3293f;
                                w2.h hVar2 = aVar.f3292e;
                                if (hVar2.f5777d != 0) {
                                    o2.i("Failed requirement.");
                                    return;
                                }
                                if (aVar.f3291d) {
                                    inflater.reset();
                                }
                                hVar2.I(hVar);
                                hVar2.L(65535);
                                long bytesRead = inflater.getBytesRead() + hVar2.f5777d;
                                do {
                                    ((n) aVar.f3294g).d(Long.MAX_VALUE, hVar);
                                } while (inflater.getBytesRead() < bytesRead);
                            }
                            g gVar = iVar.f3333d;
                            if (i3 != 1) {
                                k kVarE = hVar.e(hVar.f5777d);
                                gVar.getClass();
                                kVarE.getClass();
                                gVar.f3305a.m(gVar, kVarE);
                                break;
                            }
                            String strD = hVar.D();
                            gVar.getClass();
                            gVar.f3305a.l(strD, gVar);
                            break;
                        }
                        while (!iVar.f3336g) {
                            iVar.w();
                            if (!iVar.f3340k) {
                                break;
                            } else {
                                iVar.d();
                            }
                        }
                        if (iVar.f3337h != 0) {
                            int i4 = iVar.f3337h;
                            byte[] bArr2 = j2.b.f2361a;
                            String hexString2 = Integer.toHexString(i4);
                            hexString2.getClass();
                            throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
                        }
                    } else {
                        o2.l("closed");
                        return;
                    }
                }
            }
        }
    }

    public final void f() {
        byte[] bArr = j2.b.f2361a;
        e eVar = this.f3312h;
        if (eVar != null) {
            this.f3315k.c(eVar, 0L);
        }
    }

    public final synchronized boolean g(int i3, k kVar) {
        if (!this.f3323t && !this.f3320q) {
            long j3 = this.f3319p;
            byte[] bArr = kVar.f5779c;
            if (((long) bArr.length) + j3 > 16777216) {
                b(null, 1001);
                return false;
            }
            this.f3319p = j3 + ((long) bArr.length);
            this.f3318o.add(new d(i3, kVar));
            f();
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0070 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007f A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a5 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00de A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ee A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f8 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x010a A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0114  */
    /* JADX WARN: Code duplicated, block: B:72:0x0119  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0126 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0130 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:28:0x0070, B:31:0x007f, B:33:0x0083, B:34:0x008f, B:36:0x009b, B:39:0x009f, B:40:0x00a0, B:41:0x00a1, B:43:0x00a5, B:57:0x00ca, B:60:0x00ee, B:62:0x00f8, B:63:0x00fb, B:66:0x0106, B:68:0x010a, B:77:0x0123, B:78:0x0125, B:79:0x0126, B:80:0x012f, B:58:0x00de, B:81:0x0130, B:82:0x0135, B:65:0x0103, B:35:0x0090), top: B:95:0x006e, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x00de, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public final boolean h() {
        Object objPoll;
        String str;
        int i3;
        ?? r4;
        ?? r8;
        ?? r7;
        int i4;
        k kVar;
        w2.h hVar;
        d dVar;
        synchronized (this) {
            try {
                if (this.f3323t) {
                    return false;
                }
                j jVar = this.f3314j;
                Object objPoll2 = this.n.poll();
                String str2 = null;
                try {
                    if (objPoll2 == null) {
                        objPoll = this.f3318o.poll();
                        if (objPoll instanceof c) {
                            i3 = this.f3321r;
                            str = this.f3322s;
                            if (i3 != -1) {
                                l lVar = this.f3317m;
                                this.f3317m = null;
                                i iVar = this.f3313i;
                                this.f3313i = null;
                                j jVar2 = this.f3314j;
                                this.f3314j = null;
                                this.f3315k.e();
                                r4 = lVar;
                                r7 = iVar;
                                r8 = jVar2;
                            } else {
                                this.f3315k.c(new e(this.f3316l + " cancel", this), 60000000000L);
                                r4 = 0;
                                r7 = 0;
                                r8 = 0;
                            }
                        } else {
                            if (objPoll == null) {
                                return false;
                            }
                            str = null;
                        }
                        if (objPoll2 != null) {
                            jVar.getClass();
                            jVar.d(10, (k) objPoll2);
                        } else if (objPoll instanceof d) {
                            dVar = (d) objPoll;
                            jVar.getClass();
                            jVar.w(dVar.f3298a, dVar.f3299b);
                            synchronized (this) {
                                this.f3319p -= (long) dVar.f3299b.f5779c.length;
                            }
                        } else {
                            if (objPoll instanceof c) {
                                throw new AssertionError();
                            }
                            c cVar = (c) objPoll;
                            jVar.getClass();
                            i4 = cVar.f3296a;
                            kVar = cVar.f3297b;
                            k kVar2 = k.f5778f;
                            if (i4 >= 1000 || i4 >= 5000) {
                                str2 = "Code must be in range [1000,5000): " + i4;
                            } else if ((1004 <= i4 && i4 < 1007) || (1015 <= i4 && i4 < 3000)) {
                                str2 = "Code " + i4 + " is reserved and may not be used.";
                            }
                            if (str2 == null) {
                                throw new IllegalArgumentException(str2.toString());
                            }
                            hVar = new w2.h();
                            hVar.M(i4);
                            if (kVar != null) {
                                hVar.H(kVar);
                            }
                            try {
                                jVar.d(8, hVar.e(hVar.f5777d));
                                jVar.f3352j = true;
                                if (r4 != 0) {
                                    i2.c cVar2 = this.f3305a;
                                    str.getClass();
                                    cVar2.i(this, i3, str);
                                }
                            } catch (Throwable th) {
                                jVar.f3352j = true;
                                throw th;
                            }
                        }
                        if (r4 != 0) {
                            j2.b.d(r4);
                        }
                        if (r7 != 0) {
                            j2.b.d(r7);
                        }
                        if (r8 != 0) {
                            j2.b.d(r8);
                        }
                        return true;
                    }
                    objPoll = null;
                    str = null;
                    if (objPoll2 != null) {
                        jVar.getClass();
                        jVar.d(10, (k) objPoll2);
                    } else if (objPoll instanceof d) {
                        dVar = (d) objPoll;
                        jVar.getClass();
                        jVar.w(dVar.f3298a, dVar.f3299b);
                        synchronized (this) {
                            this.f3319p -= (long) dVar.f3299b.f5779c.length;
                        }
                    } else {
                        if (objPoll instanceof c) {
                            throw new AssertionError();
                        }
                        c cVar3 = (c) objPoll;
                        jVar.getClass();
                        i4 = cVar3.f3296a;
                        kVar = cVar3.f3297b;
                        k kVar3 = k.f5778f;
                        if (i4 >= 1000) {
                            str2 = "Code must be in range [1000,5000): " + i4;
                        } else {
                            str2 = "Code must be in range [1000,5000): " + i4;
                        }
                        if (str2 == null) {
                            throw new IllegalArgumentException(str2.toString());
                        }
                        hVar = new w2.h();
                        hVar.M(i4);
                        if (kVar != null) {
                            hVar.H(kVar);
                        }
                        jVar.d(8, hVar.e(hVar.f5777d));
                        jVar.f3352j = true;
                        if (r4 != 0) {
                            i2.c cVar4 = this.f3305a;
                            str.getClass();
                            cVar4.i(this, i3, str);
                        }
                    }
                    if (r4 != 0) {
                        j2.b.d(r4);
                    }
                    if (r7 != 0) {
                        j2.b.d(r7);
                    }
                    if (r8 != 0) {
                        j2.b.d(r8);
                    }
                    return true;
                } catch (Throwable th2) {
                    if (r4 != 0) {
                        j2.b.d(r4);
                    }
                    if (r7 != 0) {
                        j2.b.d(r7);
                    }
                    if (r8 != 0) {
                        j2.b.d(r8);
                    }
                    throw th2;
                }
                String str3 = str;
                String str4 = str3;
                i3 = -1;
                r4 = str4;
                r7 = str3;
                r8 = str4;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
