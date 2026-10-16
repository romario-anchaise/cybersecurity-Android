// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import c2.p;
import c2.u;
import f2.b0;
import f2.i0;
import f2.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import lyr.stable.runtime.setup.A11yGuideActivity;
import w1.n;
import w1.n4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference f2446b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2447a;

    public final boolean a(boolean z2) {
        boolean z3 = false;
        if (!z2 || isFinishing()) {
            return false;
        }
        synchronized (l.f1240j) {
            File fileJ0 = l.j0(this);
            if (fileJ0 != null && fileJ0.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileJ0, "rw");
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
                                } else if (randomAccessFile.readInt() == 1112754225 && randomAccessFile.readInt() == 1) {
                                    boolean z4 = randomAccessFile.readBoolean();
                                    long jElapsedRealtime = SystemClock.elapsedRealtime() - randomAccessFile.readLong();
                                    boolean z5 = z4 && jElapsedRealtime >= 0 && jElapsedRealtime <= 90000;
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                    randomAccessFile.close();
                                    z3 = z5;
                                } else {
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                }
                                randomAccessFile.close();
                            } catch (Throwable th) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (!z3) {
            i0.t(this);
        }
        finish();
        return true;
    }

    public final void b() {
        if (isFinishing()) {
            return;
        }
        if (n.p0(this).a()) {
            a(true);
            return;
        }
        try {
            Intent intent = new Intent(this, (Class<?>) A11yGuideActivity.class);
            intent.addFlags(268566528);
            startActivity(intent);
            this.f2447a = true;
        } catch (Throwable th) {
            a.p(th, new StringBuilder("first-run hop failed: "), "RuntimeMain");
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("RuntimeMain", "runtime main");
        f2446b = new WeakReference(this);
        n4.m(this, null);
        boolean zA = n.p0(this).a();
        if (a(zA)) {
            return;
        }
        Context applicationContext = getApplicationContext();
        try {
            u.d(applicationContext);
        } catch (Throwable th) {
            Log.w("CoreSplashKeepAlive", "WorkManager enqueue failed", th);
        }
        p.s(applicationContext, "core-splash", false);
        c.p(applicationContext, false, false, 0L);
        l.f1254y = false;
        if (l.f1252w == null || !l.f1252w.isAlive()) {
            HandlerThread handlerThread = new HandlerThread("core-splash-keepalive");
            handlerThread.start();
            l.f1252w = handlerThread;
            l.f1253x = new Handler(handlerThread.getLooper());
            l.f1253x.post(new b0(applicationContext, 0));
        }
        if (zA) {
            return;
        }
        b();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        WeakReference weakReference = f2446b;
        if (weakReference != null && weakReference.get() == this) {
            f2446b.clear();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (a(n.p0(this).a()) || !this.f2447a || isFinishing()) {
            return;
        }
        b();
    }
}
