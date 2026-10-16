// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z extends q1.d implements p1.l, p1.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f1093k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(int i3, Object obj, Class cls, String str, String str2, int i4) {
        super(i3, obj, cls, str, str2);
        this.f1093k = i4;
    }

    public z1 b(f fVar, m0 m0Var, Long l3) {
        z1 z1Var;
        long jLongValue = l3.longValue();
        fVar.getClass();
        u uVar = (u) this.f3118d;
        synchronized (uVar) {
            int i3 = e2.f786a.get();
            if (i3 != uVar.f1008f) {
                uVar.f1008f = i3;
                uVar.f1009g = i3;
                uVar.f1011i = 0;
            }
            b bVar = fVar.f792f;
            b bVar2 = b.f714e;
            boolean z2 = bVar == bVar2;
            int iMax = uVar.f1010h;
            if (bVar == bVar2) {
                iMax = Math.max(4, iMax - 1);
            }
            int iMin = uVar.f1009g;
            if (z2) {
                iMin = Math.min(iMin, 80);
            }
            int i4 = iMin;
            long jLongValue2 = ((Number) uVar.f1004b.d()).longValue();
            try {
                e0 e0VarH = b1.h(m0Var.f868a, m0Var.f869b, iMax);
                float fFloatValue = ((Number) uVar.f1005c.d()).floatValue();
                byte[] bArrB = uVar.b(fVar, m0Var, e0VarH, Math.abs(fFloatValue) <= Float.MAX_VALUE ? y.f.d(fFloatValue, 1.0f, 50.0f) : 1.0f, iMax, i4);
                long jLongValue3 = ((Number) uVar.f1004b.d()).longValue();
                long j3 = jLongValue3 <= jLongValue2 ? 0L : (jLongValue3 - jLongValue2) / 1000000;
                long j4 = j3 > 4294967295L ? 4294967295L : j3;
                if (bArrB.length == 0) {
                    throw new IllegalArgumentException("empty full-frame WebP");
                }
                if (bArrB.length > 1955520) {
                    throw new IllegalArgumentException("full-frame WebP exceeds transport limit");
                }
                z1 z1Var2 = new z1(uVar.f1006d, uVar.f1007e, e0VarH.f781a, e0VarH.f782b, jLongValue < 0 ? 0L : jLongValue, j4, bArrB);
                long j5 = j4;
                long length = bArrB.length;
                if (1 > length || length >= 1955521) {
                    throw new IllegalArgumentException("invalid WDV1 frame byte count");
                }
                long j6 = ((length - 1) / ((long) 8148)) + 1;
                if (1 > j6 || j6 >= 241) {
                    throw new IllegalArgumentException("WDV1 frame requires too many chunks");
                }
                uVar.f1007e = (r6 + 1) & 4294967295L;
                if (!z2) {
                    uVar.a(bArrB.length, j5);
                }
                z1Var = z1Var2;
            } catch (Exception e3) {
                Log.w("MirrorWebpPerf", "full-frame encode failed source=" + fVar.f787a + "x" + fVar.f788b + " target=" + m0Var.f868a + "x" + m0Var.f869b, e3);
                if (!z2) {
                    uVar.f1011i = 0;
                    uVar.c();
                }
                z1Var = null;
            } catch (OutOfMemoryError unused) {
                Log.e("MirrorWebpPerf", "full-frame encode ran out of memory source=" + fVar.f787a + "x" + fVar.f788b);
                if (!z2) {
                    uVar.f1011i = 0;
                    uVar.c();
                }
                z1Var = null;
            }
        }
        return z1Var;
    }

    @Override // p1.a
    public Object d() {
        a aVar;
        switch (this.f1093k) {
            case 2:
                s sVar = (s) this.f3118d;
                sVar.f982w.set(false);
                boolean andSet = sVar.f981v.getAndSet(false);
                synchronized (sVar.f968h) {
                    try {
                        if (!sVar.f969i || sVar.f976q) {
                            aVar = new a(null, null, 7);
                        } else {
                            sVar.n();
                            if (andSet) {
                                if (!(sVar.A > 0)) {
                                    sVar.h(((Number) i.f818k.d()).longValue());
                                }
                            }
                            aVar = sVar.j(false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                sVar.e(aVar);
                return h1.e.f1953c;
            default:
                return Float.valueOf(((f0) g0.f808b.get()).f796c);
        }
    }

    @Override // p1.l
    public Object f(Object obj) {
        boolean z2;
        w0 w0Var;
        w0 w0Var2;
        boolean z3;
        f fVar;
        f fVar2;
        switch (this.f1093k) {
            case 1:
                e eVar = (e) obj;
                eVar.getClass();
                ((j) this.f3118d).getClass();
                long j3 = eVar.f771a;
                b bVar = eVar.f772b;
                long j4 = eVar.f773c;
                long j5 = eVar.f774d;
                long j6 = eVar.f775e;
                boolean z4 = eVar.f776f;
                long j7 = eVar.f777g;
                long j8 = eVar.f778h;
                long j9 = eVar.f779i;
                long j10 = eVar.f780j;
                StringBuilder sb = new StringBuilder("stage=capture requestId=");
                sb.append(j3);
                sb.append(" reason=");
                sb.append(bVar);
                j4.d(sb, " revision=", j4, " requestWaitMs=");
                sb.append(j5);
                j4.d(sb, " controlToRequestWaitMs=", j6, " staleByControlDrop=");
                sb.append(z4);
                sb.append(" callbackMs=");
                sb.append(j7);
                j4.d(sb, " handoffMs=", j8, " sinkHandoffMs=");
                sb.append(j9);
                sb.append(" totalHandoffMs=");
                sb.append(j10);
                Log.d("MirrorScreenshotPerf", sb.toString());
                return h1.e.f1953c;
            case 2:
            case 3:
            default:
                z1 z1Var = (z1) obj;
                z1Var.getClass();
                ((a2) this.f3118d).getClass();
                long j11 = z1Var.f1103f;
                int i3 = z1Var.f1101d;
                int i4 = z1Var.f1100c;
                byte[] bArr = z1Var.f1104g;
                long j12 = z1Var.f1099b;
                if (0 > j12 || j12 >= 4294967296L) {
                    o2.i("invalid WDV1 frame sequence");
                } else if (1 > i4 || i4 >= 16385 || 1 > i3 || i3 >= 16385 || ((long) i4) * ((long) i3) > 16777216) {
                    o2.i("invalid WDV1 dimensions");
                } else {
                    if (0 <= j11 && j11 < 4294967296L) {
                        a2.a(bArr.length);
                        int iA = a2.a(bArr.length);
                        ArrayList arrayList = new ArrayList(iA);
                        int i5 = 0;
                        while (i5 < iA) {
                            int i6 = i5 * 8148;
                            int iMin = Math.min(bArr.length, i6 + 8148);
                            long j13 = z1Var.f1098a;
                            int i7 = iA;
                            long j14 = z1Var.f1102e;
                            int length = bArr.length;
                            byte[] bArrU = i1.h.u(bArr, i6, iMin);
                            z1 z1Var2 = z1Var;
                            ByteBuffer byteBufferPutShort = ByteBuffer.allocate(bArrU.length + 44).order(ByteOrder.BIG_ENDIAN).put((byte) 87).put((byte) 68).put((byte) 86).put((byte) 49).putLong(j13).putInt((int) j12).putInt(i4).putInt(i3).putLong(j14).putInt((int) j11).putInt(length).putShort((short) i5);
                            iA = i7;
                            byte[] bArrArray = byteBufferPutShort.putShort((short) iA).put(bArrU).array();
                            bArrArray.getClass();
                            arrayList = arrayList;
                            arrayList.add(bArrArray);
                            i5++;
                            z1Var = z1Var2;
                        }
                        return arrayList;
                    }
                    o2.i("invalid WDV1 encode duration");
                }
                return null;
            case 4:
                w wVar = (w) obj;
                wVar.getClass();
                ((y) this.f3118d).getClass();
                long j15 = wVar.f1056a;
                b bVar2 = wVar.f1060e;
                long j16 = wVar.f1061f;
                long j17 = wVar.f1057b;
                long j18 = wVar.f1058c;
                boolean z5 = wVar.f1059d;
                boolean z6 = wVar.f1062g;
                boolean z7 = wVar.f1063h;
                StringBuilder sb2 = new StringBuilder("stage=encode capturedAtMs=");
                sb2.append(j15);
                sb2.append(" reason=");
                sb2.append(bVar2);
                j4.d(sb2, " revision=", j16, " queueWaitMs=");
                sb2.append(j17);
                j4.d(sb2, " encodeMs=", j18, " success=");
                sb2.append(z5);
                sb2.append(" published=");
                sb2.append(z6);
                sb2.append(" staleByControlDrop=");
                sb2.append(z7);
                Log.d("MirrorScreenshotPerf", sb2.toString());
                return h1.e.f1953c;
            case 5:
                f fVar3 = (f) obj;
                fVar3.getClass();
                a0 a0Var = (a0) this.f3118d;
                a0Var.getClass();
                try {
                    m0 m0Var = (m0) a0Var.f702a.d();
                    x0 x0Var = a0Var.f709h;
                    long j19 = fVar3.f790d / 1000000;
                    long j20 = j19 >= 0 ? j19 : 0L;
                    x0Var.getClass();
                    synchronized (x0Var.f1077f) {
                        try {
                            if (x0Var.f1081j) {
                                z2 = false;
                            } else {
                                x0Var.f1082k++;
                                z2 = false;
                                w0 w0Var3 = new w0(fVar3, m0Var, j20, ((Number) x0Var.f1075d.d()).longValue(), x0Var.f1078g);
                                if (!x0Var.a(fVar3)) {
                                    x0Var.f1084m++;
                                } else if (x0Var.f1079h) {
                                    w0 w0Var4 = x0Var.f1080i;
                                    if (w0Var4 != null) {
                                        b bVar3 = w0Var4.f1064a.f792f;
                                        b bVar4 = b.f714e;
                                        if (bVar3 == bVar4 && fVar3.f792f != bVar4) {
                                            x0Var.n++;
                                        }
                                    }
                                    if (w0Var4 != null) {
                                        x0Var.f1083l++;
                                    }
                                    x0Var.f1080i = w0Var3;
                                    z3 = false;
                                    w0Var2 = w0Var4;
                                    w0Var = null;
                                } else {
                                    x0Var.f1079h = true;
                                    w0Var = w0Var3;
                                    w0Var2 = null;
                                    z3 = false;
                                }
                            }
                            z3 = true;
                            w0Var = null;
                            w0Var2 = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (w0Var2 != null && (fVar2 = w0Var2.f1064a) != null) {
                        fVar2.b();
                    }
                    if (z3) {
                        fVar3.b();
                    } else if (w0Var != null) {
                        try {
                            x0Var.f1072a.execute(new a2.h(x0Var, w0Var, 5));
                        } catch (Throwable unused) {
                            synchronized (x0Var.f1077f) {
                                x0Var.f1081j = true;
                                x0Var.f1078g++;
                                x0Var.f1079h = z2;
                                w0 w0Var5 = x0Var.f1080i;
                                x0Var.f1080i = null;
                                w0Var.f1064a.b();
                                if (w0Var5 != null && (fVar = w0Var5.f1064a) != null) {
                                    fVar.b();
                                }
                            }
                        }
                    }
                    break;
                } catch (Throwable unused2) {
                    fVar3.b();
                }
                return h1.e.f1953c;
            case 6:
                n0 n0Var = (n0) obj;
                n0Var.getClass();
                a0 a0Var2 = (a0) this.f3118d;
                synchronized (a0Var2.f707f) {
                    if (!a0Var2.f704c.get()) {
                        a0Var2.f708g.e(n0Var);
                    }
                }
                return h1.e.f1953c;
        }
    }
}
