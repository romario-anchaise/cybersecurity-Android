// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import H.C0028c;
import N0.C0041m;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.lifecycle.I;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import k1.A;
import k1.C;
import k1.C0191g;
import k1.L;
import k1.u;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class e extends F0.j implements E0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f744c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, Object obj) {
        super(0);
        this.f743b = i2;
        this.f744c = obj;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:18:0x009f  */
    /* JADX WARN: Code duplicated, block: B:272:0x0514 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:273:0x0516  */
    /* JADX WARN: Code duplicated, block: B:276:0x0527  */
    /* JADX WARN: Code duplicated, block: B:278:0x053c  */
    /* JADX WARN: Code duplicated, block: B:280:0x0545  */
    /* JADX WARN: Code duplicated, block: B:283:0x0562  */
    /* JADX WARN: Code duplicated, block: B:286:0x056b  */
    /* JADX WARN: Code duplicated, block: B:288:0x0575  */
    /* JADX WARN: Code duplicated, block: B:295:0x058f  */
    /* JADX WARN: Code duplicated, block: B:297:0x059d  */
    /* JADX WARN: Code duplicated, block: B:308:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:310:0x05d3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [E0.a, F0.j] */
    /* JADX WARN: Type inference failed for: r8v27, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [int] */
    /* JADX WARN: Type inference failed for: r9v26 */
    @Override // E0.a
    public final Object a() throws Exception {
        i iVar;
        Context context;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int iMin;
        double dMax;
        Bitmap bitmapDecodeStream;
        Exception exc;
        Matrix matrix;
        float width;
        float height;
        RectF rectF;
        float f2;
        Bitmap.Config config;
        Bitmap bitmapCreateBitmap;
        boolean z3;
        ColorSpace colorSpace;
        int iE;
        int iE2;
        int i6;
        ArrayList arrayList;
        p034t0.d dVar;
        p034t0.d dVar2;
        int i7 = 4;
        char c2 = 2;
        boolean z4 = false;
        Object obj = this.f744c;
        switch (this.f743b) {
            case 0:
                BitmapFactory.Options options = new BitmapFactory.Options();
                f fVar = (f) obj;
                o oVar = fVar.f745a;
                b bVar = new b(oVar.f());
                C cF = f1.l.f(bVar);
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new C0191g(f1.l.f(new A(cF)), 1), null, options);
                Exception exc2 = (Exception) bVar.f736c;
                if (exc2 != null) {
                    throw exc2;
                }
                options.inJustDecodeBounds = false;
                Paint paint = l.f763a;
                String str = options.outMimeType;
                LinkedHashSet linkedHashSet = m.f764a;
                int iOrdinal = fVar.f748d.ordinal();
                if (iOrdinal == 0) {
                    iVar = i.f756c;
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new C0041m();
                        }
                    } else if (str == null || !m.f764a.contains(str)) {
                        iVar = i.f756c;
                    }
                    K.g gVar = new K.g(new j(new C0191g(f1.l.f(new A(cF)), 1)));
                    K.c cVarC = gVar.c("Orientation");
                    if (cVarC == null) {
                        iE = 1;
                    } else {
                        try {
                            iE = cVarC.e(gVar.f337f);
                        } catch (NumberFormatException unused) {
                            iE = 1;
                        }
                    }
                    boolean z5 = iE == 2 || iE == 7 || iE == 4 || iE == 5;
                    K.c cVarC2 = gVar.c("Orientation");
                    if (cVarC2 == null) {
                        iE2 = 1;
                    } else {
                        try {
                            iE2 = cVarC2.e(gVar.f337f);
                        } catch (NumberFormatException unused2) {
                            iE2 = 1;
                        }
                    }
                    switch (iE2) {
                        case 3:
                        case 4:
                            i6 = 180;
                            break;
                        case 5:
                        case 8:
                            i6 = 270;
                            break;
                        case 6:
                        case 7:
                            i6 = 90;
                            break;
                        default:
                            i6 = 0;
                            break;
                    }
                    iVar = new i(i6, z5);
                }
                Exception exc3 = (Exception) bVar.f736c;
                if (exc3 != null) {
                    throw exc3;
                }
                options.inMutable = false;
                int i8 = Build.VERSION.SDK_INT;
                p010f0.m mVar = fVar.f746b;
                if (i8 >= 26 && (colorSpace = mVar.f2668c) != null) {
                    options.inPreferredColorSpace = colorSpace;
                }
                options.inPremultiplied = mVar.f2672h;
                int i9 = iVar.f758b;
                Bitmap.Config config2 = mVar.f2667b;
                boolean z6 = iVar.f757a;
                if ((z6 || i9 > 0) && (config2 == null || f1.l.F(config2))) {
                    config2 = Bitmap.Config.ARGB_8888;
                }
                if (mVar.g && config2 == Bitmap.Config.ARGB_8888 && F0.i.a(options.outMimeType, "image/jpeg")) {
                    config2 = Bitmap.Config.RGB_565;
                }
                if (i8 >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && config2 != Bitmap.Config.HARDWARE) {
                    config2 = Bitmap.Config.RGBA_F16;
                }
                options.inPreferredConfig = config2;
                f1.l lVarA = oVar.a();
                boolean z7 = lVarA instanceof p;
                Context context2 = mVar.f2666a;
                g0.h hVar = mVar.f2669d;
                try {
                    if (!z7 || !F0.i.a(hVar, g0.h.f2748c)) {
                        int i10 = options.outWidth;
                        if (i10 <= 0 || (i4 = options.outHeight) <= 0) {
                            context = context2;
                            i2 = i9;
                            i3 = 1;
                            options.inSampleSize = 1;
                            z2 = false;
                            options.inScaled = false;
                        } else {
                            int i11 = (i9 == 90 || i9 == 270) ? i4 : i10;
                            if (i9 != 90 && i9 != 270) {
                                i10 = i4;
                            }
                            g0.h hVar2 = g0.h.f2748c;
                            boolean zA = F0.i.a(hVar, hVar2);
                            g0.g gVar2 = mVar.f2670e;
                            int iE3 = zA ? i11 : p016j0.f.e(hVar.f2749a, gVar2);
                            int iE4 = F0.i.a(hVar, hVar2) ? i10 : p016j0.f.e(hVar.f2750b, gVar2);
                            int iHighestOneBit = Integer.highestOneBit(i11 / iE3);
                            int iHighestOneBit2 = Integer.highestOneBit(i10 / iE4);
                            int iOrdinal2 = gVar2.ordinal();
                            if (iOrdinal2 != 0) {
                                i5 = 1;
                                if (iOrdinal2 != 1) {
                                    throw new C0041m();
                                }
                                iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                            } else {
                                i5 = 1;
                                iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                            }
                            if (iMin < i5) {
                                iMin = 1;
                            }
                            options.inSampleSize = iMin;
                            double d2 = iMin;
                            context = context2;
                            double d3 = ((double) i10) / d2;
                            i2 = i9;
                            double d4 = ((double) iE3) / (((double) i11) / d2);
                            double d5 = ((double) iE4) / d3;
                            int iOrdinal3 = gVar2.ordinal();
                            if (iOrdinal3 == 0) {
                                dMax = Math.max(d4, d5);
                            } else {
                                if (iOrdinal3 != 1) {
                                    throw new C0041m();
                                }
                                dMax = Math.min(d4, d5);
                            }
                            if (mVar.f2671f && dMax > 1.0d) {
                                dMax = 1.0d;
                            }
                            boolean z8 = dMax == 1.0d;
                            options.inScaled = !z8;
                            if (!z8) {
                                if (dMax > 1.0d) {
                                    options.inDensity = f1.l.S(((double) Integer.MAX_VALUE) / dMax);
                                    options.inTargetDensity = Integer.MAX_VALUE;
                                } else {
                                    options.inDensity = Integer.MAX_VALUE;
                                    options.inTargetDensity = f1.l.S(((double) Integer.MAX_VALUE) * dMax);
                                }
                            }
                        }
                        bitmapDecodeStream = BitmapFactory.decodeStream(new C0191g(cF, i3), null, options);
                        f1.l.m(cF, null);
                        exc = (Exception) bVar.f736c;
                        if (exc == null) {
                            throw exc;
                        }
                        if (bitmapDecodeStream != null) {
                            throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                        }
                        bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                        if (z6 || i2 > 0) {
                            matrix = new Matrix();
                            width = bitmapDecodeStream.getWidth() / 2.0f;
                            height = bitmapDecodeStream.getHeight() / 2.0f;
                            if (z6) {
                                matrix.postScale(-1.0f, 1.0f, width, height);
                            }
                            if (i2 > 0) {
                                matrix.postRotate(i2, width, height);
                            }
                            rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                            matrix.mapRect(rectF);
                            f2 = rectF.left;
                            if (f2 == 0.0f || rectF.top != 0.0f) {
                                matrix.postTranslate(-f2, -rectF.top);
                            }
                            if (i2 != 90 || i2 == 270) {
                                int height2 = bitmapDecodeStream.getHeight();
                                int width2 = bitmapDecodeStream.getWidth();
                                config = bitmapDecodeStream.getConfig();
                                if (config == null) {
                                    config = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config);
                            } else {
                                int width3 = bitmapDecodeStream.getWidth();
                                int height3 = bitmapDecodeStream.getHeight();
                                Bitmap.Config config3 = bitmapDecodeStream.getConfig();
                                if (config3 == null) {
                                    config3 = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config3);
                            }
                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, l.f763a);
                            bitmapDecodeStream.recycle();
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                        z3 = true;
                        if (options.inSampleSize <= 1 && !options.inScaled) {
                            z3 = z2;
                        }
                        return new h(bitmapDrawable, z3);
                    }
                    options.inSampleSize = 1;
                    options.inScaled = true;
                    options.inDensity = ((p) lVarA).f771c;
                    options.inTargetDensity = context2.getResources().getDisplayMetrics().densityDpi;
                    context = context2;
                    i2 = i9;
                    bitmapDecodeStream = BitmapFactory.decodeStream(new C0191g(cF, i3), null, options);
                    f1.l.m(cF, null);
                    exc = (Exception) bVar.f736c;
                    if (exc == null) {
                        throw exc;
                    }
                    if (bitmapDecodeStream != null) {
                        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    }
                    bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                    if (z6) {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z6) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i2 > 0) {
                            matrix.postRotate(i2, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f2 = rectF.left;
                        if (f2 == 0.0f) {
                            matrix.postTranslate(-f2, -rectF.top);
                        } else {
                            matrix.postTranslate(-f2, -rectF.top);
                        }
                        if (i2 != 90) {
                            int height4 = bitmapDecodeStream.getHeight();
                            int width4 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height4, width4, config);
                        } else {
                            int height5 = bitmapDecodeStream.getHeight();
                            int width5 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height5, width5, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, l.f763a);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    } else {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z6) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i2 > 0) {
                            matrix.postRotate(i2, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f2 = rectF.left;
                        if (f2 == 0.0f) {
                            matrix.postTranslate(-f2, -rectF.top);
                        } else {
                            matrix.postTranslate(-f2, -rectF.top);
                        }
                        if (i2 != 90) {
                            int height6 = bitmapDecodeStream.getHeight();
                            int width6 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height6, width6, config);
                        } else {
                            int height7 = bitmapDecodeStream.getHeight();
                            int width7 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height7, width7, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, l.f763a);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    }
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                    z3 = true;
                    if (options.inSampleSize <= 1) {
                        z3 = z2;
                    }
                    return new h(bitmapDrawable2, z3);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        f1.l.m(cF, th);
                        throw th2;
                    }
                }
                i3 = 1;
                z2 = false;
                break;
                break;
            case 1:
                return (List) obj;
            case 2:
                try {
                    return (List) ((F0.j) obj).a();
                } catch (SSLPeerUnverifiedException unused3) {
                    return p036u0.n.f4146a;
                }
            case 3:
                return I.d((androidx.activity.i) obj);
            default:
                l1.f fVar2 = (l1.f) obj;
                ClassLoader classLoader = fVar2.f3547b;
                Enumeration<URL> resources = classLoader.getResources("");
                F0.i.d(resources, "getResources(...)");
                ArrayList list = Collections.list(resources);
                F0.i.d(list, "list(...)");
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    k1.o oVar2 = fVar2.f3548c;
                    if (!zHasNext) {
                        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                        F0.i.d(resources2, "getResources(...)");
                        ArrayList list2 = Collections.list(resources2);
                        F0.i.d(list2, "list(...)");
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            URL url = (URL) it2.next();
                            F0.i.b(url);
                            ?? string = url.toString();
                            F0.i.d(string, "toString(...)");
                            if (M0.m.R(string, "jar:file:", z4)) {
                                ?? V2 = (6 & c2) != 0 ? M0.e.V(string) : z4;
                                F0.i.e(string, "<this>");
                                F0.i.e("!", "string");
                                int iLastIndexOf = string.lastIndexOf("!", V2);
                                if (iLastIndexOf == -1) {
                                    arrayList = arrayList3;
                                    dVar = null;
                                } else {
                                    String str2 = z.f3517b;
                                    String strSubstring = string.substring(i7, iLastIndexOf);
                                    F0.i.d(strSubstring, "substring(...)");
                                    z zVarS = C0028c.s(new File(URI.create(strSubstring)));
                                    u uVarG = oVar2.g(zVarS);
                                    try {
                                        long jA = uVarG.a() - ((long) 22);
                                        long j2 = 0;
                                        if (jA < 0) {
                                            throw new IOException("not a zip: size=" + uVarG.a());
                                        }
                                        long jMax = Math.max(jA - 65536, 0L);
                                        while (true) {
                                            C cF2 = f1.l.f(uVarG.f(jA));
                                            try {
                                                if (cF2.t() == 101010256) {
                                                    int iW = cF2.w() & 65535;
                                                    int iW2 = cF2.w() & 65535;
                                                    arrayList = arrayList3;
                                                    long jW = cF2.w() & 65535;
                                                    if (jW != (cF2.w() & 65535) || iW != 0 || iW2 != 0) {
                                                        throw new IOException("unsupported zip: spanned");
                                                    }
                                                    cF2.A(4L);
                                                    long jT = ((long) cF2.t()) & 4294967295L;
                                                    int iW3 = 65535 & cF2.w();
                                                    l1.d dVar3 = new l1.d(jW, jT, iW3);
                                                    cF2.x(iW3);
                                                    cF2.close();
                                                    long j3 = jA - ((long) 20);
                                                    long j4 = 0;
                                                    if (j3 > 0) {
                                                        C cF3 = f1.l.f(uVarG.f(j3));
                                                        try {
                                                            if (cF3.t() == 117853008) {
                                                                int iT = cF3.t();
                                                                long jU = cF3.u();
                                                                if (cF3.t() != 1 || iT != 0) {
                                                                    throw new IOException("unsupported zip: spanned");
                                                                }
                                                                C cF4 = f1.l.f(uVarG.f(jU));
                                                                try {
                                                                    int iT2 = cF4.t();
                                                                    if (iT2 != 101075792) {
                                                                        throw new IOException("bad zip: expected " + l1.b.c(101075792) + " but was " + l1.b.c(iT2));
                                                                    }
                                                                    cF4.A(12L);
                                                                    int iT3 = cF4.t();
                                                                    int iT4 = cF4.t();
                                                                    long jU2 = cF4.u();
                                                                    if (jU2 != cF4.u() || iT3 != 0 || iT4 != 0) {
                                                                        throw new IOException("unsupported zip: spanned");
                                                                    }
                                                                    cF4.A(8L);
                                                                    l1.d dVar4 = new l1.d(jU2, cF4.u(), iW3);
                                                                    f1.l.m(cF4, null);
                                                                    dVar3 = dVar4;
                                                                } catch (Throwable th3) {
                                                                    try {
                                                                        throw th3;
                                                                    } catch (Throwable th4) {
                                                                        f1.l.m(cF4, th3);
                                                                        throw th4;
                                                                    }
                                                                }
                                                            }
                                                            f1.l.m(cF3, null);
                                                        } catch (Throwable th5) {
                                                            try {
                                                                throw th5;
                                                            } catch (Throwable th6) {
                                                                f1.l.m(cF3, th5);
                                                                throw th6;
                                                            }
                                                        }
                                                    }
                                                    long j5 = dVar3.f3542b;
                                                    ArrayList arrayList4 = new ArrayList();
                                                    C cF5 = f1.l.f(uVarG.f(j5));
                                                    try {
                                                        long j6 = dVar3.f3541a;
                                                        while (j4 < j6) {
                                                            l1.g gVarD = l1.b.d(cF5);
                                                            long j7 = j6;
                                                            if (gVarD.g >= j5) {
                                                                throw new IOException("bad zip: local file header offset >= central directory offset");
                                                            }
                                                            z zVar = l1.f.f3546e;
                                                            if (C0028c.h(gVarD.f3550a)) {
                                                                arrayList4.add(gVarD);
                                                            }
                                                            j4++;
                                                            j6 = j7;
                                                        }
                                                        f1.l.m(cF5, null);
                                                        L l2 = new L(zVarS, oVar2, l1.b.b(arrayList4));
                                                        f1.l.m(uVarG, null);
                                                        dVar = new p034t0.d(l2, l1.f.f3546e);
                                                    } catch (Throwable th7) {
                                                        try {
                                                            throw th7;
                                                        } catch (Throwable th8) {
                                                            f1.l.m(cF5, th7);
                                                            throw th8;
                                                        }
                                                    }
                                                    try {
                                                        throw th;
                                                    } catch (Throwable th9) {
                                                        f1.l.m(uVarG, th);
                                                        throw th9;
                                                    }
                                                }
                                                long j8 = j2;
                                                ArrayList arrayList5 = arrayList3;
                                                cF2.close();
                                                jA--;
                                                if (jA < jMax) {
                                                    throw new IOException("not a zip: end of central directory signature not found");
                                                }
                                                arrayList3 = arrayList5;
                                                j2 = j8;
                                            } catch (Throwable th10) {
                                                cF2.close();
                                                throw th10;
                                            }
                                        }
                                    } catch (Throwable th11) {
                                        throw th11;
                                    }
                                }
                            } else {
                                arrayList = arrayList3;
                                dVar = null;
                            }
                            ArrayList arrayList6 = arrayList;
                            if (dVar != null) {
                                arrayList6.add(dVar);
                            }
                            arrayList3 = arrayList6;
                            it2 = it2;
                            i7 = 4;
                            c2 = 2;
                            z4 = false;
                        }
                        return p036u0.f.y(arrayList2, arrayList3);
                    }
                    URL url2 = (URL) it.next();
                    F0.i.b(url2);
                    if (F0.i.a(url2.getProtocol(), "file")) {
                        String str3 = z.f3517b;
                        dVar2 = new p034t0.d(oVar2, C0028c.s(new File(url2.toURI())));
                    } else {
                        dVar2 = null;
                    }
                    if (dVar2 != null) {
                        arrayList2.add(dVar2);
                    }
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(E0.a aVar) {
        super(0);
        this.f743b = 2;
        this.f744c = (F0.j) aVar;
    }
}
