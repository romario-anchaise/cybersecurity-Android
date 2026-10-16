// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class s implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f3501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C f3502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f3503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f3504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f3505e;

    public s(I i2) {
        F0.i.e(i2, "source");
        C c2 = new C(i2);
        this.f3502b = c2;
        Inflater inflater = new Inflater(true);
        this.f3503c = inflater;
        this.f3504d = new t(c2, inflater);
        this.f3505e = new CRC32();
    }

    public static void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3)));
        }
    }

    @Override // k1.I
    public final K c() {
        return this.f3502b.f3441a.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3504d.close();
    }

    public final void f(C0193i c0193i, long j2, long j3) {
        D d2 = c0193i.f3481a;
        F0.i.b(d2);
        while (true) {
            int i2 = d2.f3446c;
            int i3 = d2.f3445b;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= (long) (i2 - i3);
            d2 = d2.f3449f;
            F0.i.b(d2);
        }
        while (j3 > 0) {
            int i4 = (int) (((long) d2.f3445b) + j2);
            int iMin = (int) Math.min(d2.f3446c - i4, j3);
            this.f3505e.update(d2.f3444a, i4, iMin);
            j3 -= (long) iMin;
            d2 = d2.f3449f;
            F0.i.b(d2);
            j2 = 0;
        }
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) throws IOException {
        C0193i c0193i2;
        long j3;
        F0.i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        byte b2 = this.f3501a;
        CRC32 crc32 = this.f3505e;
        C c2 = this.f3502b;
        if (b2 == 0) {
            c2.z(10L);
            C0193i c0193i3 = c2.f3442b;
            byte bX = c0193i3.x(3L);
            boolean z2 = ((bX >> 1) & 1) == 1;
            if (z2) {
                f(c0193i3, 0L, 10L);
            }
            a("ID1ID2", 8075, c2.v());
            c2.A(8L);
            if (((bX >> 2) & 1) == 1) {
                c2.z(2L);
                if (z2) {
                    f(c0193i3, 0L, 2L);
                }
                long jH = c0193i3.H() & 65535;
                c2.z(jH);
                if (z2) {
                    f(c0193i3, 0L, jH);
                    j3 = jH;
                } else {
                    j3 = jH;
                }
                c2.A(j3);
            }
            if (((bX >> 3) & 1) == 1) {
                c0193i2 = c0193i3;
                long jF = c2.f((byte) 0, 0L, Long.MAX_VALUE);
                if (jF == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    f(c0193i2, 0L, jF + 1);
                }
                
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b8: INVOKE (r4v3 ?? I:??[OBJECT, ARRAY]), (wrap long:0x00b6: ARITH (r14v3 'jF' long) + (1 long) A[WRAPPED] (LINE:183)) VIRTUAL call: k1.C.A(long):void A[MD:(long):void (m)] (LINE:185) in method: k1.s.m(k1.i, long):long, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v3 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    */
                /*
                    Method dump skipped, instruction units count: 371
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: k1.s.m(k1.i, long):long");
            }
        }
