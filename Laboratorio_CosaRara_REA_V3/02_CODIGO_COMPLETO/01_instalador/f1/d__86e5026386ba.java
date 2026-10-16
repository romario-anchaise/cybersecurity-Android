// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import A.C0005e;
import A.I;
import A.InterfaceC0013m;
import A.W;
import A.X;
import A.c0;
import D.q;
import D.r;
import D.t;
import D.v;
import E0.p;
import H.C0028c;
import H.u;
import N0.AbstractC0029a;
import N0.C0033e;
import N0.C0041m;
import X0.C0061h;
import X0.s;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.EnumC0077o;
import androidx.lifecycle.InterfaceC0081t;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import k1.AbstractC0185a;
import k1.C0193i;
import k1.C0196l;
import p015j.C0143e0;
import p015j.s1;
import p015j.u1;
import p036u0.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements D.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2708a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2709b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2710c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f2711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f2712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f2713f;
    public static Class g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f2714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Field f2715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f2716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Field f2717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f2718l;

    /* JADX WARN: Multi-variable type inference failed */
    public static void A(p pVar, AbstractC0029a abstractC0029a, AbstractC0029a abstractC0029a2) {
        try {
            R0.a.f(p029q.j.l(((p044y0.a) pVar).a(abstractC0029a, abstractC0029a2)), p034t0.h.f4132b, null);
        } catch (Throwable th) {
            abstractC0029a2.b(p029q.j.b(th));
            throw th;
        }
    }

    public static J0.a B(J0.c cVar, int i2) {
        F0.i.e(cVar, "<this>");
        boolean z2 = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        if (z2) {
            if (cVar.f280c <= 0) {
                i2 = -i2;
            }
            return new J0.a(cVar.f278a, cVar.f279b, i2);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    public static long C(int i2) {
        if (i2 <= 0) {
            return 0L;
        }
        if (i2 >= 99) {
            return 25000L;
        }
        return Math.round((1.0d - Math.sqrt(1.0d - (((double) i2) / 99.0d))) * 25000.0d);
    }

    public static final List D(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            return size != 1 ? Collections.unmodifiableList(new ArrayList(arrayList)) : Collections.singletonList(p036u0.f.t(arrayList));
        }
        return p036u0.n.f4146a;
    }

    public static final Map E(Map map) {
        int size = map.size();
        if (size == 0) {
            return o.f4147a;
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) p036u0.f.s(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static J0.c F(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new J0.c(i2, i3 - 1, 1);
        }
        J0.c cVar = J0.c.f285d;
        return J0.c.f285d;
    }

    public static ActionMode.Callback G(ActionMode.Callback callback) {
        return (!(callback instanceof v) || Build.VERSION.SDK_INT < 26) ? callback : ((v) callback).f143a;
    }

    public static ActionMode.Callback H(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof v) || callback == null) ? callback : new v(callback, textView);
    }

    public static final void a(a1.a aVar, a1.c cVar, String str) {
        a1.d.f1236i.fine(cVar.f1230b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f1223a);
    }

    public static void b(StringBuilder sb, Object obj, E0.l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.d(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) String.valueOf(obj));
        }
    }

    public static final boolean c(int i2, int i3, int i4, byte[] bArr, byte[] bArr2) {
        F0.i.e(bArr, "a");
        F0.i.e(bArr2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(AbstractC0078p abstractC0078p, p044y0.c cVar) throws Throwable {
        p016j0.b bVar;
        AbstractC0078p abstractC0078p2;
        F0.n nVar;
        Throwable th;
        InterfaceC0081t interfaceC0081t;
        InterfaceC0081t interfaceC0081t2;
        if (cVar instanceof p016j0.b) {
            bVar = (p016j0.b) cVar;
            int i2 = bVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.g = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new p016j0.b(cVar);
            }
        } else {
            bVar = new p016j0.b(cVar);
        }
        Object obj = bVar.f3371f;
        p042x0.a aVar = p042x0.a.f4189a;
        int i3 = bVar.g;
        p034t0.h hVar = p034t0.h.f4132b;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = bVar.f3370e;
            abstractC0078p2 = bVar.f3369d;
            try {
                p029q.j.o(obj);
                interfaceC0081t2 = (InterfaceC0081t) nVar.f180a;
                if (interfaceC0081t2 != null) {
                    abstractC0078p2.c(interfaceC0081t2);
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
                interfaceC0081t = (InterfaceC0081t) nVar.f180a;
                if (interfaceC0081t != null) {
                    abstractC0078p2.c(interfaceC0081t);
                }
                throw th;
            }
        }
        p029q.j.o(obj);
        if (abstractC0078p.b().compareTo(EnumC0077o.f1684d) >= 0) {
            return hVar;
        }
        F0.n nVar2 = new F0.n();
        try {
            bVar.f3369d = abstractC0078p;
            bVar.f3370e = nVar2;
            bVar.g = 1;
            C0033e c0033e = new C0033e(p029q.j.l(bVar), 1);
            c0033e.q();
            p016j0.c cVar2 = new p016j0.c(c0033e);
            nVar2.f180a = cVar2;
            abstractC0078p.a(cVar2);
            if (c0033e.p() == aVar) {
                return aVar;
            }
            abstractC0078p2 = abstractC0078p;
            nVar = nVar2;
            interfaceC0081t2 = (InterfaceC0081t) nVar.f180a;
            if (interfaceC0081t2 != null) {
                abstractC0078p2.c(interfaceC0081t2);
            }
            return hVar;
        } catch (Throwable th3) {
            abstractC0078p2 = abstractC0078p;
            nVar = nVar2;
            th = th3;
            interfaceC0081t = (InterfaceC0081t) nVar.f180a;
            if (interfaceC0081t != null) {
                abstractC0078p2.c(interfaceC0081t);
            }
            throw th;
        }
    }

    public static void e(long j2, C0193i c0193i, int i2, ArrayList arrayList, int i3, int i4, ArrayList arrayList2) {
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        if (i3 >= i4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i9 = i3; i9 < i4; i9++) {
            if (((C0196l) arrayList.get(i9)).c() < i8) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        C0196l c0196l = (C0196l) arrayList.get(i3);
        C0196l c0196l2 = (C0196l) arrayList.get(i4 - 1);
        int i10 = -1;
        if (i8 == c0196l.c()) {
            int iIntValue = ((Number) arrayList2.get(i3)).intValue();
            int i11 = i3 + 1;
            C0196l c0196l3 = (C0196l) arrayList.get(i11);
            i5 = i11;
            i6 = iIntValue;
            c0196l = c0196l3;
        } else {
            i5 = i3;
            i6 = -1;
        }
        if (c0196l.h(i8) == c0196l2.h(i8)) {
            int iMin = Math.min(c0196l.c(), c0196l2.c());
            int i12 = 0;
            for (int i13 = i8; i13 < iMin && c0196l.h(i13) == c0196l2.h(i13); i13++) {
                i12++;
            }
            long j3 = 4;
            long j4 = (c0193i.f3482b / j3) + j2 + ((long) 2) + ((long) i12) + 1;
            c0193i.T(-i12);
            c0193i.T(i6);
            int i14 = i12 + i8;
            while (i8 < i14) {
                c0193i.T(c0196l.h(i8) & 255);
                i8++;
            }
            if (i5 + 1 == i4) {
                if (i14 != ((C0196l) arrayList.get(i5)).c()) {
                    throw new IllegalStateException("Check failed.");
                }
                c0193i.T(((Number) arrayList2.get(i5)).intValue());
                return;
            } else {
                C0193i c0193i2 = new C0193i();
                c0193i.T(((int) ((c0193i2.f3482b / j3) + j4)) * (-1));
                e(j4, c0193i2, i14, arrayList, i5, i4, arrayList2);
                c0193i.P(c0193i2);
                return;
            }
        }
        int i15 = 1;
        for (int i16 = i5 + 1; i16 < i4; i16++) {
            if (((C0196l) arrayList.get(i16 - 1)).h(i8) != ((C0196l) arrayList.get(i16)).h(i8)) {
                i15++;
            }
        }
        long j5 = 4;
        long j6 = (c0193i.f3482b / j5) + j2 + ((long) 2) + ((long) (i15 * 2));
        c0193i.T(i15);
        c0193i.T(i6);
        for (int i17 = i5; i17 < i4; i17++) {
            int iH = ((C0196l) arrayList.get(i17)).h(i8);
            if (i17 == i5 || iH != ((C0196l) arrayList.get(i17 - 1)).h(i8)) {
                c0193i.T(iH & 255);
            }
        }
        C0193i c0193i3 = new C0193i();
        int i18 = i5;
        while (i18 < i4) {
            byte bH = ((C0196l) arrayList.get(i18)).h(i8);
            int i19 = i18 + 1;
            int i20 = i19;
            while (true) {
                if (i20 >= i4) {
                    i7 = i4;
                    break;
                } else {
                    if (bH != ((C0196l) arrayList.get(i20)).h(i8)) {
                        i7 = i20;
                        break;
                    }
                    i20++;
                }
            }
            if (i19 == i7 && i8 + 1 == ((C0196l) arrayList.get(i18)).c()) {
                c0193i.T(((Number) arrayList2.get(i18)).intValue());
            } else {
                c0193i.T(((int) ((c0193i3.f3482b / j5) + j6)) * i10);
                e(j6, c0193i3, i8 + 1, arrayList, i18, i7, arrayList2);
            }
            c0193i3 = c0193i3;
            i18 = i7;
            i10 = -1;
        }
        c0193i.P(c0193i3);
    }

    public static final void f(View view) {
        F0.i.e(view, "<this>");
        c0 c0Var = new c0(view, null);
        L0.d dVar = new L0.d();
        dVar.f350d = c0Var.a(dVar, dVar);
        while (dVar.hasNext()) {
            View view2 = (View) dVar.next();
            F.a aVar = (F.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new F.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList = aVar.f160a;
            int iP = p036u0.g.p(arrayList);
            if (-1 < iP) {
                arrayList.get(iP).getClass();
                throw new ClassCastException();
            }
        }
    }

    public static final void g(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static X0.n i(X0.n nVar, X0.n nVar2) {
        C0005e c0005e = new C0005e(10);
        int size = nVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strB = nVar.b(i2);
            String strD = nVar.d(i2);
            if ((!"Warning".equalsIgnoreCase(strB) || !M0.m.R(strD, "1", false)) && ("Content-Length".equalsIgnoreCase(strB) || "Content-Encoding".equalsIgnoreCase(strB) || "Content-Type".equalsIgnoreCase(strB) || !s(strB) || nVar2.a(strB) == null)) {
                c0005e.A(strB, strD);
            }
        }
        int size2 = nVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String strB2 = nVar2.b(i3);
            if (!"Content-Length".equalsIgnoreCase(strB2) && !"Content-Encoding".equalsIgnoreCase(strB2) && !"Content-Type".equalsIgnoreCase(strB2) && s(strB2)) {
                c0005e.A(strB2, nVar2.d(i3));
            }
        }
        return c0005e.B();
    }

    public static final double j(int i2, int i3, int i4, int i5, g0.g gVar) {
        double d2 = ((double) i4) / ((double) i2);
        double d3 = ((double) i5) / ((double) i3);
        int iOrdinal = gVar.ordinal();
        if (iOrdinal == 0) {
            return Math.max(d2, d3);
        }
        if (iOrdinal == 1) {
            return Math.min(d2, d3);
        }
        throw new C0041m();
    }

    public static H.v k(Context context) {
        ProviderInfo providerInfo;
        V.a aVar;
        ApplicationInfo applicationInfo;
        C0028c dVar = Build.VERSION.SDK_INT >= 28 ? new H.d(0) : new C0028c(0);
        PackageManager packageManager = context.getPackageManager();
        p028p0.a.a(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            aVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrT = dVar.t(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrT) {
                    arrayList.add(signature.toByteArray());
                }
                aVar = new V.a(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                aVar = null;
            }
        }
        if (aVar == null) {
            return null;
        }
        return new H.v(new u(context, aVar));
    }

    public static boolean l(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = X.f14a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = W.f10d;
        W w2 = (W) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (w2 == null) {
            w2 = new W();
            w2.f11a = null;
            w2.f12b = null;
            w2.f13c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, w2);
        }
        WeakReference weakReference2 = w2.f13c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        w2.f13c = new WeakReference(keyEvent);
        if (w2.f12b == null) {
            w2.f12b = new SparseArray();
        }
        SparseArray sparseArray = w2.f12b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !I.b(view2) || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    public static boolean m(InterfaceC0013m interfaceC0013m, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (interfaceC0013m == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return interfaceC0013m.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window = activity.getWindow();
            if (window.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                    if (!f2708a) {
                        try {
                            f2709b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                        } catch (NoSuchMethodException unused) {
                        }
                        f2708a = true;
                    }
                    Method method = f2709b;
                    if (method != null) {
                        try {
                            Object objInvoke = method.invoke(actionBar, keyEvent);
                            if (objInvoke != null) {
                                zBooleanValue = ((Boolean) objInvoke).booleanValue();
                            }
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                    if (zBooleanValue) {
                        return true;
                    }
                }
            }
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (X.b(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
        }
        if (!(callback instanceof Dialog)) {
            return (view != null && X.b(view, keyEvent)) || interfaceC0013m.superDispatchKeyEvent(keyEvent);
        }
        Dialog dialog = (Dialog) callback;
        if (!f2710c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f2711d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f2710c = true;
        }
        Field field = f2711d;
        if (field != null) {
            try {
                onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused4) {
                onKeyListener = null;
            }
        } else {
            onKeyListener = null;
        }
        if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window2 = dialog.getWindow();
        if (window2.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView2 = window2.getDecorView();
        if (X.b(decorView2, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static X0.I n(String str) {
        F0.i.e(str, "javaName");
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return X0.I.f931d;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return X0.I.f930c;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return X0.I.f929b;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return X0.I.f932e;
            }
        } else if (str.equals("SSLv3")) {
            return X0.I.f933f;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }

    public static final String o(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j2 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public static X0.m p(SSLSession sSLSession) throws IOException {
        List listL;
        List listL2 = p036u0.n.f4146a;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        C0061h c0061hC = C0061h.f964b.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        X0.I iN = n(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listL = peerCertificates != null ? Y0.b.l(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listL2;
        } catch (SSLPeerUnverifiedException unused) {
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listL2 = Y0.b.l(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new X0.m(iN, c0061hC, listL2, new W.e(1, listL));
    }

    public static s q(String str) {
        F0.i.e(str, "<this>");
        Matcher matcher = s.f1030d.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }
        String strGroup = matcher.group(1);
        F0.i.d(strGroup, "typeSubtype.group(1)");
        Locale locale = Locale.US;
        F0.i.d(locale, "US");
        String lowerCase = strGroup.toLowerCase(locale);
        F0.i.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        F0.i.d(strGroup2, "typeSubtype.group(2)");
        F0.i.d(strGroup2.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = s.f1031e.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                F0.i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                sb.append(str);
                sb.append('\"');
                throw new IllegalArgumentException(sb.toString().toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (M0.m.R(strGroup4, "'", false) && M0.m.L(strGroup4, "'", false) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    F0.i.d(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new s(str, lowerCase, (String[]) arrayList.toArray(new String[0]));
    }

    public static p043y.b r(C0143e0 c0143e0) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new p043y.b(D.u.c(c0143e0));
        }
        TextPaint textPaint = new TextPaint(c0143e0.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int iA = D.s.a(c0143e0);
        int iD = D.s.d(c0143e0);
        if (c0143e0.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i2 < 28 || (c0143e0.getInputType() & 15) != 3) {
            boolean z2 = r.b(c0143e0) == 1;
            switch (r.c(c0143e0)) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z2) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(D.u.b(t.a(r.d(c0143e0)))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new p043y.b(textPaint, textDirectionHeuristic, iA, iD);
    }

    public static boolean s(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean t() {
        return e.f2719d;
    }

    public static final boolean u(String str) {
        F0.i.e(str, "method");
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static String v(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder("sha256/");
        C0196l c0196l = C0196l.f3483d;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        F0.i.d(encoded, "publicKey.encoded");
        int length = encoded.length;
        int i2 = 0;
        g(encoded.length, 0, length);
        C0196l c0196lB = new C0196l(p036u0.e.v(encoded, 0, length)).b("SHA-256");
        byte[] bArr = AbstractC0185a.f3464a;
        byte[] bArr2 = c0196lB.f3484a;
        F0.i.e(bArr2, "<this>");
        F0.i.e(bArr, "map");
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length2 = bArr2.length - (bArr2.length % 3);
        int i3 = 0;
        while (i2 < length2) {
            byte b2 = bArr2[i2];
            int i4 = i2 + 2;
            byte b3 = bArr2[i2 + 1];
            i2 += 3;
            byte b4 = bArr2[i4];
            bArr3[i3] = bArr[(b2 & 255) >> 2];
            bArr3[i3 + 1] = bArr[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i5 = i3 + 3;
            bArr3[i3 + 2] = bArr[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 += 4;
            bArr3[i5] = bArr[b4 & 63];
        }
        int length3 = bArr2.length - length2;
        if (length3 == 1) {
            byte b5 = bArr2[i2];
            bArr3[i3] = bArr[(b5 & 255) >> 2];
            bArr3[1 + i3] = bArr[(b5 & 3) << 4];
            bArr3[2 + i3] = 61;
            bArr3[i3 + 3] = 61;
        } else if (length3 == 2) {
            int i6 = i2 + 1;
            byte b6 = bArr2[i2];
            byte b7 = bArr2[i6];
            bArr3[i3] = bArr[(b6 & 255) >> 2];
            bArr3[1 + i3] = bArr[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr3[i3 + 2] = bArr[(b7 & 15) << 2];
            bArr3[i3 + 3] = 61;
        }
        sb.append(new String(bArr3, M0.a.f360a));
        return sb.toString();
    }

    public static I.b w(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i2 = byteBufferDuplicate.getShort() & 65535;
        if (i2 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                j2 = -1;
                break;
            }
            int i4 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i4) {
                break;
            }
            i3++;
        }
        if (j2 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j2 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i5 = 0; i5 < j3; i5++) {
                int i6 = byteBufferDuplicate.getInt();
                long j4 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i6 || 1701669481 == i6) {
                    byteBufferDuplicate.position((int) (j4 + j2));
                    I.b bVar = new I.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f5d = byteBufferDuplicate;
                    bVar.f2a = iPosition;
                    int i7 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f3b = i7;
                    bVar.f4c = ((ByteBuffer) bVar.f5d).getShort(i7);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void x(TextView textView, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            D.u.d(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = q.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void y(TextView textView, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = q.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void z(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            s1.a(view, charSequence);
            return;
        }
        u1 u1Var = u1.f3308k;
        if (u1Var != null && u1Var.f3310a == view) {
            u1.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new u1(view, charSequence);
            return;
        }
        u1 u1Var2 = u1.f3309l;
        if (u1Var2 != null && u1Var2.f3310a == view) {
            u1Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public abstract List h(List list, String str);
}
