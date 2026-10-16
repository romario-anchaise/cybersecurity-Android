// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import d2.t;
import e2.h0;
import e2.i0;
import e2.j0;
import e2.k0;
import e2.k1;
import e2.l0;
import e2.l1;
import e2.m1;
import e2.s1;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledExecutorService;
import lyr.stable.runtime.ScreenMirrorService;
import w1.cf;
import w1.d5;
import w1.hc;
import w1.j5;
import w1.m3;
import w1.n3;
import w1.o1;
import w1.rd;
import w1.y8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f259f;

    public /* synthetic */ b(Object obj, long j3, Object obj2, int i3) {
        this.f256c = i3;
        this.f258e = obj;
        this.f257d = j3;
        this.f259f = obj2;
    }

    private final void a() {
        t tVar = (t) this.f258e;
        m1 m1Var = (m1) this.f259f;
        long j3 = this.f257d;
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) tVar.f614e;
        rd rdVar = ScreenMirrorService.n6;
        screenMirrorService.Y();
        synchronized (m1Var) {
            try {
                if (!m1Var.n && (j3 == Long.MAX_VALUE || j3 > m1Var.f875f)) {
                    k1 k1VarF = m1Var.f();
                    if (j3 == Long.MAX_VALUE) {
                        j3 = -1;
                    }
                    m1Var.f875f = j3;
                    m1Var.f876g = null;
                    m1Var.k();
                    m1.c(k1VarF);
                    m1Var.f870a.a(j3 == Long.MAX_VALUE ? "control_plane_lost" : "control_plane_generation_advanced");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((ScreenMirrorService) tVar.f614e).W();
    }

    private final void b() {
        e2.g gVar;
        boolean z2;
        l1 l1Var;
        m1[] m1VarArr = (m1[]) this.f258e;
        long j3 = this.f257d;
        h0 h0Var = (h0) this.f259f;
        boolean z3 = false;
        m1 m1Var = m1VarArr[0];
        if (m1Var != null) {
            synchronized (m1Var) {
                try {
                    gVar = null;
                    if (m1Var.n || j3 != m1Var.f875f) {
                        z2 = false;
                    } else {
                        e2.g gVarE = m1Var.e();
                        m1Var.f885q = h0Var;
                        int iOrdinal = h0Var.ordinal();
                        if (iOrdinal == 0) {
                            l1Var = l1.f862e;
                        } else if (iOrdinal == 1) {
                            l1Var = l1.f863f;
                        } else {
                            if (iOrdinal != 2) {
                                throw new h1.a();
                            }
                            l1Var = null;
                        }
                        m1Var.f886r = l1Var;
                        m1Var.f892x = null;
                        m1Var.f890v = i0.f819d;
                        j0 j0Var = m1Var.f883o;
                        if (j0Var == j0.f830g && h0Var == h0.f813d) {
                            m1Var.f888t = k0.f843f;
                            m1Var.f892x = h0.f814e;
                            z3 = true;
                        } else if (j0Var != j0.f829f || h0Var == h0.f813d) {
                            m1Var.f888t = k0.f841d;
                            if (m1Var.f889u != l0.f855h) {
                                m1Var.f889u = l0.f851d;
                            }
                        } else {
                            m1Var.f888t = k0.f842e;
                            m1Var.f890v = i0.f820e;
                        }
                        z2 = z3;
                        gVar = gVarE;
                        z3 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (gVar != null) {
                gVar.a();
            }
            if (z3) {
                m1Var.j();
                if (z2) {
                    m1Var.b(m1Var.f887s, j3);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:195:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:73:0x0126  */
    /* JADX WARN: Code duplicated, block: B:75:0x012c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0133  */
    /* JADX WARN: Code duplicated, block: B:82:0x0154  */
    /* JADX WARN: Code duplicated, block: B:85:0x015f A[Catch: all -> 0x019a, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0165 A[Catch: all -> 0x019a, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x016e  */
    /* JADX WARN: Code duplicated, block: B:90:0x016f A[Catch: all -> 0x019a, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0177 A[Catch: all -> 0x019a, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0183  */
    /* JADX WARN: Code duplicated, block: B:95:0x0187 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0193 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #6 {all -> 0x019a, blocks: (B:83:0x0155, B:85:0x015f, B:87:0x0165, B:90:0x016f, B:92:0x0177, B:95:0x0187, B:97:0x0190, B:99:0x0193, B:103:0x0199, B:96:0x0188), top: B:200:0x0155, inners: #2 }] */
    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i4;
        char c3;
        final j5 j5Var;
        o1 o1VarU;
        String str;
        d2.a aVar;
        int length;
        int iDigit;
        int unicodeChar;
        char c4;
        boolean z2;
        boolean z3 = false;
        c = 0;
        char c5 = 0;
        switch (this.f256c) {
            case 0:
                g gVar = (g) this.f258e;
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f259f;
                long j3 = this.f257d;
                synchronized (gVar.f287e) {
                    if (gVar.f291i == scheduledExecutorService && gVar.f292j == j3) {
                        gVar.f292j = 0L;
                        gVar.t();
                        return;
                    }
                    return;
                }
            case 1:
                m3 m3Var = (m3) this.f258e;
                n3 n3Var = (n3) this.f259f;
                long j4 = this.f257d;
                synchronized (m3Var) {
                    if (!m3Var.f4501i) {
                        long j5 = m3Var.f4500h;
                        if (j4 == j5) {
                            m3Var.f4497e = n3Var;
                            m3Var.f4498f = null;
                            m3Var.f4499g = null;
                            m3Var.f4495c.f3491d.Q4(n3Var, j5);
                            return;
                        }
                    }
                    return;
                }
            case 2:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f258e;
                n3 n3Var2 = (n3) this.f259f;
                long j6 = this.f257d;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.Q4(n3Var2, j6);
                return;
            case 3:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f258e;
                MediaCodec mediaCodec = (MediaCodec) this.f259f;
                long j7 = this.f257d;
                rd rdVar2 = ScreenMirrorService.n6;
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i5 = 0;
                while (screenMirrorService2.f2537s.get() && screenMirrorService2.Z3.get() == j7 && screenMirrorService2.o4 == mediaCodec) {
                    try {
                        int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (iDequeueOutputBuffer == -1) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            long j8 = jCurrentTimeMillis2 - jCurrentTimeMillis;
                            if (j8 >= 5000) {
                                float f3 = (i5 * 1000.0f) / j8;
                                long jS0 = cf.K() != null ? cf.K().S0() : -1L;
                                int i6 = screenMirrorService2.M3;
                                screenMirrorService2.M3 = z3 ? 1 : 0;
                                int i7 = screenMirrorService2.N3;
                                screenMirrorService2.N3 = z3 ? 1 : 0;
                                Log.i("ScreenMirror", String.format("[H264Diag] encoder=%.1ffps dropBP=%d dropQ=%d wsQueue=%dKB clients=%d", Float.valueOf(f3), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(jS0 / 1024), Integer.valueOf(screenMirrorService2.L3.size())));
                                i5 = z3 ? 1 : 0;
                                jCurrentTimeMillis = jCurrentTimeMillis2;
                            }
                        } else if (iDequeueOutputBuffer == -2) {
                            MediaFormat outputFormat = mediaCodec.getOutputFormat();
                            Log.i("ScreenMirror", "encoder format changed: " + outputFormat);
                            screenMirrorService2.U(outputFormat);
                        } else if (iDequeueOutputBuffer >= 0) {
                            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(iDequeueOutputBuffer);
                            if (outputBuffer == null) {
                                mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, z3);
                            } else {
                                outputBuffer.position(bufferInfo.offset);
                                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                byte[] bArr = new byte[bufferInfo.size];
                                outputBuffer.get(bArr);
                                int i8 = bufferInfo.flags;
                                char c6 = (i8 & 2) != 0 ? (char) 1 : z3 ? 1 : 0;
                                char c7 = (i8 & 1) != 0 ? (char) 1 : z3 ? 1 : 0;
                                if (c6 != 0) {
                                    screenMirrorService2.s4 = (byte[]) bArr.clone();
                                    i3 = 2;
                                } else {
                                    i3 = z3 ? 1 : 0;
                                }
                                if (c7 != 0) {
                                    i3 = (i3 == true ? 1 : 0) | 1;
                                }
                                MediaCodec mediaCodec2 = mediaCodec;
                                screenMirrorService2.L4++;
                                i5++;
                                screenMirrorService2.S(i3, bufferInfo.presentationTimeUs, bArr);
                                mediaCodec2.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                z3 = false;
                                mediaCodec = mediaCodec2;
                            }
                        }
                    } catch (IllegalStateException unused) {
                    } catch (Exception e3) {
                        Log.e("ScreenMirror", "encoder loop error: " + e3.getMessage());
                    }
                }
                Log.i("ScreenMirror", "encoder output loop exit");
                return;
            case 4:
                ScreenMirrorService screenMirrorService3 = (ScreenMirrorService) this.f258e;
                long j9 = this.f257d;
                KeyEvent keyEvent = (KeyEvent) this.f259f;
                rd rdVar3 = ScreenMirrorService.n6;
                if (!screenMirrorService3.w3(j9) || screenMirrorService3.f2534q2 || screenMirrorService3.Y1 != null || screenMirrorService3.X || screenMirrorService3.Y) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                final int keyCode = keyEvent.getKeyCode();
                if (keyCode < 7 || keyCode > 16) {
                    if (keyCode >= 144 && keyCode <= 153) {
                        i4 = keyCode - 96;
                    }
                    if (screenMirrorService3.U0.F(jUptimeMillis, "", screenMirrorService3.J3(), screenMirrorService3.W0.f4902d)) {
                        if (c5 != 0) {
                            screenMirrorService3.M1(c5, -1.0f, -1.0f, jUptimeMillis);
                            Log.d("ScreenMirror", "[PinFusion] key digit accepted");
                            return;
                        }
                        unicodeChar = keyEvent.getUnicodeChar();
                        if (unicodeChar > 0) {
                            c4 = (char) unicodeChar;
                            if (y8.q(c4)) {
                                if (c4 < '0' && c4 <= '9') {
                                    screenMirrorService3.M1(c4, -1.0f, -1.0f, jUptimeMillis);
                                    return;
                                }
                                screenMirrorService3.U0.s();
                                screenMirrorService3.U0.v(c4, jUptimeMillis);
                                Log.d("ScreenMirror", "[PinFusion] key password char accepted");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    c3 = c5;
                    try {
                        o1VarU = screenMirrorService3.u();
                        str = screenMirrorService3.k4;
                        aVar = o1VarU.f4683e;
                        if (c3 != 0) {
                            if (aVar.b(str, jUptimeMillis)) {
                                iDigit = Character.digit(c3, 10);
                                if (iDigit >= 0) {
                                    o1VarU.a((char) (iDigit + 48), str, "hw-key", jUptimeMillis);
                                }
                            } else {
                                o1VarU.p(str);
                                if (!aVar.b(str, jUptimeMillis)) {
                                    iDigit = Character.digit(c3, 10);
                                    if (iDigit >= 0) {
                                        o1VarU.a((char) (iDigit + 48), str, "hw-key", jUptimeMillis);
                                    }
                                }
                            }
                        } else if (keyCode == 67) {
                            synchronized (aVar) {
                                length = ((StringBuilder) aVar.f541e).length();
                            }
                            if (length > 0) {
                                aVar.d(jUptimeMillis);
                            }
                        }
                    } catch (Throwable th) {
                        a0.a.p(th, new StringBuilder("[AppPin] key fail: "), "ScreenMirror");
                    }
                    j5Var = screenMirrorService3.R5;
                    if (j5Var != null) {
                        try {
                            final int unicodeChar2 = keyEvent.getUnicodeChar();
                            final String str2 = screenMirrorService3.k4;
                            j5Var.l(new d5() { // from class: w1.c5
                                @Override // w1.d5
                                public final void c(y.e eVar) {
                                    final j5 j5Var2 = j5Var;
                                    j5Var2.getClass();
                                    final int i9 = keyCode;
                                    final int i10 = unicodeChar2;
                                    final String str3 = str2;
                                    eVar.n(new Runnable() { // from class: w1.z4
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            boolean z4;
                                            j5 j5Var3 = j5Var2;
                                            int i11 = i9;
                                            int i12 = i10;
                                            String str4 = str3;
                                            j5Var3.getClass();
                                            long jCurrentTimeMillis3 = System.currentTimeMillis();
                                            d2.y yVar = j5Var3.f4309c;
                                            synchronized (yVar) {
                                                long j10 = yVar.f653c;
                                                z4 = false;
                                                if (j10 >= 0 && jCurrentTimeMillis3 <= j10) {
                                                    z4 = str4 == null || str4.isEmpty() || ((String) yVar.f652b).isEmpty() || ((String) yVar.f652b).equals(str4);
                                                }
                                            }
                                            if (z4) {
                                                if (i11 == 67) {
                                                    j5Var3.f4309c.d();
                                                    return;
                                                }
                                                if (i11 == 66 || i11 == 160) {
                                                    j5Var3.y();
                                                } else {
                                                    if (i12 <= 0 || Character.isISOControl(i12)) {
                                                        return;
                                                    }
                                                    j5Var3.f4309c.e((char) i12, jCurrentTimeMillis3);
                                                }
                                            }
                                        }
                                    });
                                }
                            });
                            return;
                        } catch (Throwable th2) {
                            a0.a.p(th2, new StringBuilder("[KeyFusion] key fail: "), "ScreenMirror");
                            return;
                        }
                    }
                    return;
                }
                i4 = keyCode + 41;
                c5 = (char) i4;
                if (screenMirrorService3.U0.F(jUptimeMillis, "", screenMirrorService3.J3(), screenMirrorService3.W0.f4902d)) {
                    if (c5 != 0) {
                        screenMirrorService3.M1(c5, -1.0f, -1.0f, jUptimeMillis);
                        Log.d("ScreenMirror", "[PinFusion] key digit accepted");
                        return;
                    }
                    unicodeChar = keyEvent.getUnicodeChar();
                    if (unicodeChar > 0) {
                        c4 = (char) unicodeChar;
                        if (y8.q(c4)) {
                            if (c4 < '0') {
                            }
                            screenMirrorService3.U0.s();
                            screenMirrorService3.U0.v(c4, jUptimeMillis);
                            Log.d("ScreenMirror", "[PinFusion] key password char accepted");
                            return;
                        }
                        return;
                    }
                    return;
                }
                c3 = c5;
                o1VarU = screenMirrorService3.u();
                str = screenMirrorService3.k4;
                aVar = o1VarU.f4683e;
                if (c3 != 0) {
                    if (aVar.b(str, jUptimeMillis)) {
                        o1VarU.p(str);
                        if (!aVar.b(str, jUptimeMillis)) {
                            iDigit = Character.digit(c3, 10);
                            if (iDigit >= 0) {
                                o1VarU.a((char) (iDigit + 48), str, "hw-key", jUptimeMillis);
                            }
                        }
                    } else {
                        iDigit = Character.digit(c3, 10);
                        if (iDigit >= 0) {
                            o1VarU.a((char) (iDigit + 48), str, "hw-key", jUptimeMillis);
                        }
                    }
                } else if (keyCode == 67) {
                    synchronized (aVar) {
                        length = ((StringBuilder) aVar.f541e).length();
                        if (length > 0) {
                            aVar.d(jUptimeMillis);
                        }
                    }
                }
                j5Var = screenMirrorService3.R5;
                if (j5Var != null) {
                    final int unicodeChar3 = keyEvent.getUnicodeChar();
                    final String str3 = screenMirrorService3.k4;
                    j5Var.l(new d5() { // from class: w1.c5
                        @Override // w1.d5
                        public final void c(y.e eVar) {
                            final j5 j5Var2 = j5Var;
                            j5Var2.getClass();
                            final int i9 = keyCode;
                            final int i10 = unicodeChar3;
                            final String str4 = str3;
                            eVar.n(new Runnable() { // from class: w1.z4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    boolean z4;
                                    j5 j5Var3 = j5Var2;
                                    int i11 = i9;
                                    int i12 = i10;
                                    String str5 = str4;
                                    j5Var3.getClass();
                                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                                    d2.y yVar = j5Var3.f4309c;
                                    synchronized (yVar) {
                                        long j10 = yVar.f653c;
                                        z4 = false;
                                        if (j10 >= 0 && jCurrentTimeMillis3 <= j10) {
                                            z4 = str5 == null || str5.isEmpty() || ((String) yVar.f652b).isEmpty() || ((String) yVar.f652b).equals(str5);
                                        }
                                    }
                                    if (z4) {
                                        if (i11 == 67) {
                                            j5Var3.f4309c.d();
                                            return;
                                        }
                                        if (i11 == 66 || i11 == 160) {
                                            j5Var3.y();
                                        } else {
                                            if (i12 <= 0 || Character.isISOControl(i12)) {
                                                return;
                                            }
                                            j5Var3.f4309c.e((char) i12, jCurrentTimeMillis3);
                                        }
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
                return;
            case 5:
                ScreenMirrorService screenMirrorService4 = (ScreenMirrorService) this.f258e;
                long j10 = this.f257d;
                MotionEvent motionEvent = (MotionEvent) this.f259f;
                rd rdVar4 = ScreenMirrorService.n6;
                try {
                    if (screenMirrorService4.w3(j10)) {
                        screenMirrorService4.m5(motionEvent);
                        break;
                    }
                    return;
                } finally {
                    motionEvent.recycle();
                }
            case 6:
                a();
                return;
            case 7:
                hc hcVar = (hc) this.f258e;
                long j11 = this.f257d;
                MediaProjection mediaProjection = (MediaProjection) this.f259f;
                ScreenMirrorService screenMirrorService5 = hcVar.f4220c;
                if (screenMirrorService5.d4 == j11 && screenMirrorService5.m4 == mediaProjection) {
                    screenMirrorService5.d4 = -1L;
                    screenMirrorService5.P6();
                    s1 s1Var = screenMirrorService5.a4;
                    if (s1Var != null) {
                        s1Var.g(j11);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                b();
                return;
            default:
                t tVar = (t) this.f258e;
                long j12 = this.f257d;
                m1[] m1VarArr = (m1[]) this.f259f;
                Log.i("ScreenMirror", "RTC publisher connected generation=" + j12);
                ((ScreenMirrorService) tVar.f614e).e6(3);
                ((ScreenMirrorService) tVar.f614e).Y5("rtc_connected", true);
                m1 m1Var = m1VarArr[0];
                if (m1Var != null) {
                    synchronized (m1Var) {
                        z2 = (m1Var.n || j12 != m1Var.f875f || m1Var.f885q == h0.f815f) ? false : true;
                    }
                    if (z2) {
                        Log.i("ScreenMirror", "RTC media ready generation=" + j12);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, long j3, int i3) {
        this.f256c = i3;
        this.f258e = obj;
        this.f259f = obj2;
        this.f257d = j3;
    }
}
