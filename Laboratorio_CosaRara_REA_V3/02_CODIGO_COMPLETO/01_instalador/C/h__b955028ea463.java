// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C;

import H.C0028c;
import V.k;
import X0.u;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.I;
import androidx.lifecycle.L;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.Q;
import androidx.lifecycle.T;
import androidx.recyclerview.widget.j0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import k1.C0196l;
import org.xmlpull.v1.XmlPullParserException;
import p009f.M;
import p015j.C0171t;
import p015j.V;
import p016j0.l;
import p016j0.m;
import s.n;

/* JADX INFO: loaded from: classes.dex */
public final class h implements i, p008e0.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static h f110d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f113c;

    public h(k kVar, m mVar) {
        Object kVar2;
        this.f111a = kVar;
        this.f112b = mVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            if (!p016j0.a.f3368a) {
                kVar2 = (i2 == 26 || i2 == 27) ? new l() : new p016j0.k(true);
            }
            this.f113c = kVar2;
        }
        boolean z2 = p016j0.a.f3368a;
        kVar2 = new p016j0.k(false);
        this.f113c = kVar2;
    }

    public static final void h(h hVar, Network network, boolean z2) {
        p034t0.h hVar2;
        boolean z3;
        boolean z4 = false;
        for (Network network2 : ((ConnectivityManager) hVar.f111a).getAllNetworks()) {
            if (F0.i.a(network2, network)) {
                z3 = z2;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) hVar.f111a).getNetworkCapabilities(network2);
                z3 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z3) {
                z4 = true;
                break;
            }
        }
        m mVar = (m) hVar.f112b;
        synchronized (mVar) {
            try {
                if (((k) mVar.f3392a.get()) != null) {
                    mVar.f3396e = z4;
                    hVar2 = p034t0.h.f4132b;
                } else {
                    hVar2 = null;
                }
                if (hVar2 == null) {
                    mVar.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static p010f0.e i(p010f0.i iVar, Throwable th) {
        Drawable drawableB;
        if (th instanceof p010f0.l) {
            p010f0.c cVar = iVar.f2638B;
            drawableB = cVar.f2614l;
            p010f0.c cVar2 = p016j0.d.f3373a;
            if (drawableB == null) {
                drawableB = p016j0.d.b(iVar, iVar.f2663z, cVar.f2613k);
            }
        } else {
            drawableB = p016j0.d.b(iVar, iVar.f2663z, iVar.f2638B.f2613k);
        }
        return new p010f0.e(drawableB, iVar, th);
    }

    public static boolean o(p010f0.i iVar, Bitmap.Config config) {
        if (!f1.l.F(config)) {
            return true;
        }
        if (!iVar.f2648k) {
            return false;
        }
        p012h0.a aVar = iVar.f2641c;
        if (aVar != null) {
            ImageView imageView = aVar.f2841b;
            if (imageView.isAttachedToWindow() && !imageView.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public static h p(Context context, AttributeSet attributeSet, int[] iArr, int i2) {
        return new h(context, context.obtainStyledAttributes(attributeSet, iArr, i2, 0));
    }

    @Override // C.i
    public ClipDescription a() {
        return (ClipDescription) this.f113c;
    }

    @Override // C.i
    public Uri c() {
        return (Uri) this.f112b;
    }

    @Override // p008e0.e
    public void d() {
        ((ConnectivityManager) this.f111a).unregisterNetworkCallback((p008e0.f) this.f113c);
    }

    @Override // C.i
    public Object e() {
        return null;
    }

    @Override // p008e0.e
    public boolean f() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f111a;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    @Override // C.i
    public Uri g() {
        return (Uri) this.f111a;
    }

    public N j(String str, Class cls) {
        N nB;
        F0.i.e(str, "key");
        T t2 = (T) this.f111a;
        t2.getClass();
        LinkedHashMap linkedHashMap = t2.f1668a;
        N n2 = (N) linkedHashMap.get(str);
        boolean zIsInstance = cls.isInstance(n2);
        Q q2 = (Q) this.f112b;
        if (!zIsInstance) {
            M.c cVar = new M.c((M.b) this.f113c);
            cVar.f359a.put(O.f1664b, str);
            try {
                nB = q2.c(cls, cVar);
            } catch (AbstractMethodError unused) {
                nB = q2.b(cls);
            }
            F0.i.e(nB, "viewModel");
            N n3 = (N) linkedHashMap.put(str, nB);
            if (n3 != null) {
                n3.b();
            }
            return nB;
        }
        L l2 = q2 instanceof L ? (L) q2 : null;
        if (l2 != null) {
            F0.i.b(n2);
            AbstractC0078p abstractC0078p = l2.f1656d;
            if (abstractC0078p != null) {
                Q.e eVar = l2.f1657e;
                F0.i.b(eVar);
                I.a(n2, eVar, abstractC0078p);
            }
        }
        F0.i.c(n2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return n2;
    }

    public ColorStateList k(int i2) {
        int resourceId;
        ColorStateList colorStateListY;
        TypedArray typedArray = (TypedArray) this.f112b;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListY = f1.l.y((Context) this.f111a, resourceId)) == null) ? typedArray.getColorStateList(i2) : colorStateListY;
    }

    public Drawable l(int i2) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f112b;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) ? typedArray.getDrawable(i2) : f1.l.A((Context) this.f111a, resourceId);
    }

    public Drawable m(int i2) {
        int resourceId;
        Drawable drawableD;
        if (!((TypedArray) this.f112b).hasValue(i2) || (resourceId = ((TypedArray) this.f112b).getResourceId(i2, 0)) == 0) {
            return null;
        }
        C0171t c0171tA = C0171t.a();
        Context context = (Context) this.f111a;
        synchronized (c0171tA) {
            drawableD = c0171tA.f3302a.d(context, resourceId, true);
        }
        return drawableD;
    }

    public Typeface n(int i2, int i3, V v2) {
        int i4 = 3;
        int resourceId = ((TypedArray) this.f112b).getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f113c) == null) {
            this.f113c = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.f113c;
        ThreadLocal threadLocal = n.f4061a;
        Context context = (Context) this.f111a;
        if (context.isRestricted()) {
            return null;
        }
        Resources resources = context.getResources();
        resources.getValue(resourceId, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            v2.a();
            return null;
        }
        int i5 = typedValue.assetCookie;
        j0 j0Var = p033t.f.f4109b;
        Typeface typeface = (Typeface) j0Var.g(p033t.f.b(resources, resourceId, string, i5, i3));
        if (typeface != null) {
            new Handler(Looper.getMainLooper()).post(new O.g(v2, i4, typeface));
            return typeface;
        }
        try {
            if (string.toLowerCase().endsWith(".xml")) {
                s.e eVarC = s.b.c(resources.getXml(resourceId), resources);
                if (eVarC != null) {
                    return p033t.f.a(context, eVarC, resources, resourceId, string, typedValue.assetCookie, i3, v2);
                }
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                v2.a();
                return null;
            }
            int i6 = typedValue.assetCookie;
            Typeface typefaceF = p033t.f.f4108a.f(context, resources, resourceId, string, i3);
            if (typefaceF != null) {
                j0Var.k(p033t.f.b(resources, resourceId, string, i6, i3), typefaceF);
            }
            if (typefaceF != null) {
                new Handler(Looper.getMainLooper()).post(new O.g(v2, i4, typefaceF));
            } else {
                v2.a();
            }
            return typefaceF;
        } catch (IOException e2) {
            Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e2);
            v2.a();
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e3);
            v2.a();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    public p010f0.m q(p010f0.i iVar, g0.h hVar) {
        boolean z2;
        iVar.f2644f.getClass();
        Bitmap.Config config = iVar.f2642d;
        if (f1.l.F(config) && (!o(iVar, config) || !((p016j0.i) this.f113c).a(hVar))) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config2 = config;
        f1.d dVar = hVar.f2749a;
        g0.b bVar = g0.b.f2739m;
        g0.g gVar = (dVar.equals(bVar) || hVar.f2750b.equals(bVar)) ? g0.g.f2746b : iVar.f2660w;
        if (iVar.f2649l) {
            iVar.f2644f.getClass();
            if (config2 != Bitmap.Config.ALPHA_8) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return new p010f0.m(iVar.f2639a, config2, null, hVar, gVar, p016j0.d.a(iVar), z2, iVar.f2650m, null, iVar.f2645h, iVar.f2646i, iVar.f2661x, iVar.f2651n, iVar.f2652o, iVar.f2653p);
    }

    public void r() {
        ((TypedArray) this.f112b).recycle();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    public p010f0.m s(p010f0.m mVar) {
        boolean z2;
        Bitmap.Config config;
        p010f0.b bVar;
        boolean z3;
        Bitmap.Config config2 = mVar.f2667b;
        p010f0.b bVar2 = mVar.f2679o;
        boolean z4 = true;
        if (!f1.l.F(config2) || ((p016j0.i) this.f113c).b()) {
            z2 = false;
            config = config2;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z2 = true;
        }
        if (mVar.f2679o.f2602a) {
            m mVar2 = (m) this.f112b;
            synchronized (mVar2) {
                mVar2.a();
                z3 = mVar2.f3396e;
            }
            if (z3) {
                bVar = bVar2;
                z4 = z2;
            } else {
                bVar = p010f0.b.DISABLED;
            }
        } else {
            bVar = bVar2;
            z4 = z2;
        }
        return z4 ? new p010f0.m(mVar.f2666a, config, mVar.f2668c, mVar.f2669d, mVar.f2670e, mVar.f2671f, mVar.g, mVar.f2672h, mVar.f2673i, mVar.f2674j, mVar.f2675k, mVar.f2676l, mVar.f2677m, mVar.f2678n, bVar) : mVar;
    }

    public h(T t2, Q q2, M.b bVar) {
        F0.i.e(t2, "store");
        F0.i.e(bVar, "defaultCreationExtras");
        this.f111a = t2;
        this.f112b = q2;
        this.f113c = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(T t2, Q q2) {
        this(t2, q2, M.a.f358b);
        F0.i.e(t2, "store");
    }

    public h(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f111a = uri;
        this.f113c = clipDescription;
        this.f112b = uri2;
    }

    public h(Context context, TypedArray typedArray) {
        this.f111a = context;
        this.f112b = typedArray;
    }

    public h(Context context, LocationManager locationManager) {
        this.f113c = new M();
        this.f111a = context;
        this.f112b = locationManager;
    }

    public h(ConnectivityManager connectivityManager, m mVar) {
        this.f111a = connectivityManager;
        this.f112b = mVar;
        p008e0.f fVar = new p008e0.f(this);
        this.f113c = fVar;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), fVar);
    }

    public h() {
        String string = UUID.randomUUID().toString();
        F0.i.d(string, "randomUUID().toString()");
        C0196l c0196l = C0196l.f3483d;
        this.f111a = C0028c.p(string);
        this.f112b = u.f1037e;
        this.f113c = new ArrayList();
    }

    @Override // C.i
    public void b() {
    }
}
