// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import m2.l;
import w1.j4;
import w1.o2;
import w2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.j f3332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f3333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w2.h f3342m;
    public final w2.h n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f3343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f3344p;

    public i(w2.j jVar, g gVar, boolean z2, boolean z3) {
        jVar.getClass();
        gVar.getClass();
        this.f3332c = jVar;
        this.f3333d = gVar;
        this.f3334e = z2;
        this.f3335f = z3;
        this.f3342m = new w2.h();
        this.n = new w2.h();
        this.f3344p = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        a aVar = this.f3343o;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void d() throws ProtocolException, EOFException {
        String strD;
        short s3;
        i iVar;
        j jVar;
        String strG;
        long j3 = this.f3338i;
        if (j3 > 0) {
            this.f3332c.b(j3, this.f3342m);
        }
        switch (this.f3337h) {
            case 8:
                w2.h hVar = this.f3342m;
                long j4 = hVar.f5777d;
                if (j4 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                l lVar = null;
                if (j4 != 0) {
                    s3 = hVar.readShort();
                    strD = this.f3342m.D();
                    if (s3 < 1000 || s3 >= 5000) {
                        strG = a0.a.g("Code must be in range [1000,5000): ", s3);
                    } else {
                        strG = ((1004 > s3 || s3 >= 1007) && (1015 > s3 || s3 >= 3000)) ? null : j4.c(s3, "Code ", " is reserved and may not be used.");
                    }
                    if (strG != null) {
                        throw new ProtocolException(strG);
                    }
                } else {
                    strD = "";
                    s3 = 1005;
                }
                g gVar = this.f3333d;
                gVar.getClass();
                if (s3 == -1) {
                    o2.i("Failed requirement.");
                    return;
                }
                synchronized (gVar) {
                    if (gVar.f3321r != -1) {
                        throw new IllegalStateException("already closed");
                    }
                    gVar.f3321r = s3;
                    gVar.f3322s = strD;
                    if (gVar.f3320q && gVar.f3318o.isEmpty()) {
                        l lVar2 = gVar.f3317m;
                        gVar.f3317m = null;
                        iVar = gVar.f3313i;
                        gVar.f3313i = null;
                        jVar = gVar.f3314j;
                        gVar.f3314j = null;
                        gVar.f3315k.e();
                        lVar = lVar2;
                    } else {
                        iVar = null;
                        jVar = null;
                    }
                }
                try {
                    gVar.f3305a.j(gVar, s3, strD);
                    if (lVar != null) {
                        gVar.f3305a.i(gVar, s3, strD);
                        break;
                    }
                    if (lVar != null) {
                        j2.b.d(lVar);
                    }
                    if (iVar != null) {
                        j2.b.d(iVar);
                    }
                    if (jVar != null) {
                        j2.b.d(jVar);
                    }
                    this.f3336g = true;
                    return;
                } catch (Throwable th) {
                    if (lVar != null) {
                        j2.b.d(lVar);
                    }
                    if (iVar != null) {
                        j2.b.d(iVar);
                    }
                    if (jVar != null) {
                        j2.b.d(jVar);
                    }
                    throw th;
                }
            case 9:
                g gVar2 = this.f3333d;
                w2.h hVar2 = this.f3342m;
                k kVarE = hVar2.e(hVar2.f5777d);
                synchronized (gVar2) {
                    try {
                        kVarE.getClass();
                        if (!gVar2.f3323t && (!gVar2.f3320q || !gVar2.f3318o.isEmpty())) {
                            gVar2.n.add(kVarE);
                            gVar2.f();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            case 10:
                g gVar3 = this.f3333d;
                w2.h hVar3 = this.f3342m;
                k kVarE2 = hVar3.e(hVar3.f5777d);
                synchronized (gVar3) {
                    kVarE2.getClass();
                    gVar3.f3325v = false;
                }
                return;
            default:
                int i3 = this.f3337h;
                byte[] bArr = j2.b.f2361a;
                String hexString = Integer.toHexString(i3);
                hexString.getClass();
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    public final void w() throws IOException {
        boolean z2;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (this.f3336g) {
            o2.l("closed");
            return;
        }
        w2.j jVar = this.f3332c;
        long jH = jVar.a().h();
        jVar.a().b();
        try {
            byte b3 = jVar.readByte();
            byte[] bArr = j2.b.f2361a;
            jVar.a().g(jH, timeUnit);
            int i3 = b3 & 15;
            this.f3337h = i3;
            boolean z3 = (b3 & 128) != 0;
            this.f3339j = z3;
            boolean z4 = (b3 & 8) != 0;
            this.f3340k = z4;
            if (z4 && !z3) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z5 = (b3 & 64) != 0;
            if (i3 == 1 || i3 == 2) {
                if (!z5) {
                    z2 = false;
                } else {
                    if (!this.f3334e) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z2 = true;
                }
                this.f3341l = z2;
            } else if (z5) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b3 & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b3 & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b4 = jVar.readByte();
            boolean z6 = (b4 & 128) != 0;
            if (z6) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j3 = b4 & 127;
            this.f3338i = j3;
            if (j3 == 126) {
                this.f3338i = jVar.readShort() & 65535;
            } else if (j3 == 127) {
                long j4 = jVar.readLong();
                this.f3338i = j4;
                if (j4 < 0) {
                    String hexString = Long.toHexString(this.f3338i);
                    hexString.getClass();
                    throw new ProtocolException("Frame length 0x" + hexString + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f3340k && this.f3338i > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                byte[] bArr2 = this.f3344p;
                bArr2.getClass();
                jVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            jVar.a().g(jH, timeUnit);
            throw th;
        }
    }
}
