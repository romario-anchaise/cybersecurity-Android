// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.DreamWakeReceiver;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3821a;

    public /* synthetic */ dc(ScreenMirrorService screenMirrorService) {
        this.f3821a = screenMirrorService;
    }

    public static void l() {
        l();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0048 A[EXC_TOP_SPLITTER, PHI: r1 r2
  0x0048: PHI (r1v2 android.view.accessibility.AccessibilityNodeInfo) = (r1v1 android.view.accessibility.AccessibilityNodeInfo), (r1v8 android.view.accessibility.AccessibilityNodeInfo) binds: [B:25:0x004d, B:22:0x0046] A[DONT_GENERATE, DONT_INLINE]
  0x0048: PHI (r2v1 long) = (r2v0 long), (r2v4 long) binds: [B:25:0x004d, B:22:0x0046] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public r1 a() {
        ScreenMirrorService screenMirrorService = this.f3821a;
        o7 o7Var = screenMirrorService.I3;
        AccessibilityNodeInfo rootInActiveWindow = null;
        if (o7Var == null) {
            return null;
        }
        long j3 = o7Var.f4722a;
        try {
            rootInActiveWindow = screenMirrorService.getRootInActiveWindow();
            String string = (rootInActiveWindow == null || rootInActiveWindow.getPackageName() == null) ? "" : rootInActiveWindow.getPackageName().toString();
            if (!string.isEmpty() && !o7Var.f4730i.isEmpty() && !string.equals(o7Var.f4730i)) {
                j3 = j3 == Long.MAX_VALUE ? Long.MIN_VALUE : j3 + 1;
            }
            if (rootInActiveWindow != null) {
                try {
                    rootInActiveWindow.recycle();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            if (rootInActiveWindow != null) {
                rootInActiveWindow.recycle();
            }
        }
        long j4 = j3;
        j7 j7Var = o7Var.f4733l;
        return new r1(j4, o7Var.f4723b, screenMirrorService.N2 || (j7Var == null || !j7Var.a()));
    }

    public void b(zf zfVar) {
        String str;
        ScreenMirrorService screenMirrorService = this.f3821a;
        if (screenMirrorService.X || screenMirrorService.Y) {
            return;
        }
        Path path = new Path();
        path.moveTo(zfVar.f5749a, zfVar.f5750b);
        path.lineTo(zfVar.f5751c, zfVar.f5752d);
        long j3 = 500;
        GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, j3)).build();
        screenMirrorService.B1();
        Handler handler = screenMirrorService.f2541t;
        if (handler == null) {
            return;
        }
        int iM = screenMirrorService.f2547v.m(new f4(screenMirrorService.O, e4.f3869d, new pb(screenMirrorService, SystemClock.uptimeMillis() + 4000, 0), new g2.l(screenMirrorService, gestureDescriptionBuild, handler, zfVar), new mc(screenMirrorService), j3, false));
        if (iM == 7 || iM == 8 || iM == 6 || iM == 5 || iM == 4) {
            return;
        }
        screenMirrorService.P.incrementAndGet();
        switch (iM) {
            case 1:
                str = "STARTED";
                break;
            case 2:
                str = "QUEUED";
                break;
            case 3:
                str = "COMPLETED";
                break;
            case 4:
                str = "DECLINED";
                break;
            case 5:
                str = "INVALID";
                break;
            case 6:
                str = "DISPATCH_REJECTED";
                break;
            case 7:
                str = "REJECTED_QUEUE_FULL";
                break;
            case 8:
                str = "REJECTED_CLOSED";
                break;
            default:
                str = "null";
                break;
        }
        Log.i("ScreenMirror", "[RemoteWake] stage=queued result=".concat(str));
    }

    public void c() {
        long j3 = this.f3821a.d4;
        if (j3 < 0) {
            Log.e("ScreenMirror", "legacy H264 display reconfigure failed; using JPEG fallback");
            this.f3821a.o7();
            this.f3821a.X6();
            return;
        }
        Log.e("ScreenMirror", "H264 display reconfigure failed; using WebP fallback");
        this.f3821a.d4 = -1L;
        this.f3821a.o7();
        e2.s1 s1Var = this.f3821a.a4;
        if (s1Var != null) {
            s1Var.g(j3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean d() {
        ScreenMirrorService screenMirrorService = this.f3821a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (a2.c.f52a) {
            try {
                File fileU = a2.c.u(screenMirrorService);
                if (fileU != null && fileU.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileU, "rw");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock fileLockLock = channel.lock();
                            try {
                                if (randomAccessFile.length() < 17) {
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                } else {
                                    randomAccessFile.seek(0L);
                                    if (randomAccessFile.readInt() == 1146244401) {
                                        if (randomAccessFile.readInt() == 1) {
                                            boolean z2 = randomAccessFile.readBoolean();
                                            long j3 = jElapsedRealtime - randomAccessFile.readLong();
                                            boolean z3 = z2 && j3 >= 0 && j3 <= 15000;
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                            return z3;
                                        }
                                        if (channel != null) {
                                            try {
                                                channel.close();
                                            } catch (Throwable th) {
                                                th.addSuppressed(th);
                                            }
                                        }
                                        throw th;
                                    }
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                }
                                randomAccessFile.close();
                                return false;
                            } catch (Throwable th2) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            if (channel != null) {
                                channel.close();
                            }
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                return false;
            } catch (Throwable th7) {
                Log.w("DreamActiveLease", "read failed: " + th7.getMessage());
                return false;
            }
        }
    }

    public int e() {
        if (this.f3821a.m4 == null || this.f3821a.n4 == null || this.f3821a.o4 == null || !Arrays.equals(this.f3821a.g4, ScreenMirrorService.q6)) {
            return (this.f3821a.A4 == null || !Arrays.equals(this.f3821a.g4, ScreenMirrorService.r6)) ? 3 : 2;
        }
        return 1;
    }

    public void f(int i3, Throwable th) {
        String str;
        if (i3 == 1) {
            str = "H264";
        } else if (i3 != 2) {
            str = i3 != 3 ? "null" : "INACTIVE";
        } else {
            str = "JPEG";
        }
        Log.e("ScreenMirror", "display reconfigure failed in ".concat(str), th);
        if (i3 == 2) {
            rd rdVar = ScreenMirrorService.n6;
            this.f3821a.j7();
        }
    }

    public void g(n2 n2Var) {
        ScreenMirrorService screenMirrorService = this.f3821a;
        rd rdVar = ScreenMirrorService.n6;
        if (n2Var.f4599a == 6 || !screenMirrorService.L.remove(n2Var)) {
            return;
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.BRAND;
        if (n4.Y()) {
            b2.e eVarM3 = screenMirrorService.m3();
            boolean z2 = eVarM3.f272b;
            String str3 = eVarM3.f273c;
            if (z2 || "com.hihonor.appmarket".equals(str3) || "com.android.vending".equals(str3)) {
                return;
            }
            y.c cVar = screenMirrorService.K;
            if (!cVar.k(screenMirrorService.J3(), screenMirrorService.C3()) ? false : ((AtomicBoolean) cVar.f5973e).compareAndSet(false, true)) {
                screenMirrorService.M = SystemClock.uptimeMillis();
                screenMirrorService.X5();
                screenMirrorService.J.set(false);
                Log.w("ScreenMirror", "[ControlAction] HONOR keyguard gesture callback timed out; circuit opened for current lock session installer=".concat(eVarM3.f273c.isEmpty() ? "<none>" : eVarM3.f273c));
            }
        }
    }

    public void h(long j3, Runnable runnable) {
        rd rdVar = ScreenMirrorService.n6;
        this.f3821a.d5(j3, runnable);
    }

    public void i(Runnable runnable) {
        rd rdVar = ScreenMirrorService.n6;
        this.f3821a.N5(runnable);
    }

    public boolean j(long j3, Intent intent) {
        ScreenMirrorService screenMirrorService = this.f3821a;
        if (screenMirrorService.f2537s.get()) {
            try {
                if (screenMirrorService.l4 == null) {
                    screenMirrorService.l4 = (MediaProjectionManager) screenMirrorService.getSystemService("media_projection");
                }
                if (screenMirrorService.l4 != null) {
                    if (screenMirrorService.m4 != null) {
                        screenMirrorService.d4 = -1L;
                        screenMirrorService.o7();
                    }
                    MediaProjection mediaProjection = screenMirrorService.l4.getMediaProjection(-1, new Intent(intent));
                    if (mediaProjection != null) {
                        screenMirrorService.m4 = mediaProjection;
                        screenMirrorService.d4 = j3;
                        mediaProjection.registerCallback(new hc(screenMirrorService, j3, mediaProjection), screenMirrorService.T3 != null ? screenMirrorService.T3 : new Handler(Looper.getMainLooper()));
                        screenMirrorService.j7();
                        screenMirrorService.W6();
                        boolean z2 = screenMirrorService.d4 == j3 && screenMirrorService.m4 == mediaProjection && screenMirrorService.o4 != null && screenMirrorService.n4 != null && Arrays.equals(screenMirrorService.g4, ScreenMirrorService.q6);
                        if (!z2) {
                            screenMirrorService.d4 = -1L;
                            screenMirrorService.j7();
                            screenMirrorService.o7();
                        }
                        return z2;
                    }
                }
            } catch (Throwable th) {
                Log.e("ScreenMirror", "MIR1 projection start failed generation=" + j3, th);
                screenMirrorService.d4 = -1L;
                screenMirrorService.j7();
                screenMirrorService.o7();
                return false;
            }
        }
        return false;
    }

    public void k(String str, long j3) {
        ScreenMirrorService screenMirrorService = this.f3821a;
        if (screenMirrorService.d4 < 0 || screenMirrorService.d4 == j3) {
            screenMirrorService.d4 = -1L;
            screenMirrorService.i7();
            StringBuilder sb = new StringBuilder("MIR1 projection stopped generation=");
            sb.append(j3);
            sb.append(" reason=");
            a0.a.o(sb, str, "ScreenMirror");
        }
    }

    public Intent m() {
        Context applicationContext = this.f3821a.getApplicationContext();
        synchronized (f2.l.f1249t) {
            try {
                if (f2.l.f1251v == -1 && f2.l.f1250u != null) {
                    Intent intent = new Intent(f2.l.f1250u);
                    f2.l.f1251v = 0;
                    f2.l.f1250u = null;
                    f2.i0.R(applicationContext, false, 0L);
                    if (applicationContext != null) {
                        if (j4.a(applicationContext) == 2) {
                            try {
                                cf.K().i0(applicationContext, "projection_grant_consumed");
                            } catch (Throwable unused) {
                            }
                        } else {
                            m mVarC = m.c(applicationContext);
                            mVarC.getClass();
                            mVarC.f(16, n.h0("projection_grant_consumed"));
                        }
                    }
                    return intent;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n() {
        int i3 = DreamWakeReceiver.f2588a;
        Context context = this.f3821a;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            context.sendBroadcast(new Intent("lyr.stable.runtime.action.WAKE_OWN_DREAM").setComponent(new ComponentName(context, (Class<?>) DreamWakeReceiver.class)).setPackage(context.getPackageName()));
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("explicit wake send failed: "), "DreamWakeReceiver");
        }
    }
}
