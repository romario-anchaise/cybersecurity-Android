// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a2.b;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Window;
import f2.l;
import g0.s;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import w1.f;
import w1.f9;
import w1.m;
import w1.n;
import w1.n4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class MediaProjectionRequestActivity extends Activity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2448d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f2449a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f9 f2451c;

    public final void a(Intent intent) {
        boolean z2 = intent != null && intent.getBooleanExtra("task5_projection_result", false);
        f9 f9Var = null;
        if (intent != null && intent.getBooleanExtra("task5_projection_result", false)) {
            try {
                f9Var = new f9(intent.getStringExtra("task5_request_id"), intent.getLongExtra("task5_generation", -1L));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (z2 && f9Var == null) {
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        boolean z3 = this.f2450b;
        if (f9Var == null) {
            if (z3 || ((f9) this.f2449a.f1486b) != null) {
                return;
            }
            this.f2450b = true;
            d();
            return;
        }
        if (z3) {
            this.f2451c = f9Var;
            return;
        }
        s sVar = this.f2449a;
        f9 f9Var2 = (f9) sVar.f1486b;
        if (f9Var2 == null) {
            sVar.f1486b = f9Var;
            e(f9Var);
        } else {
            if (f9Var.equals(f9Var2) || f9Var.equals((f9) sVar.f1487c)) {
                return;
            }
            sVar.f1487c = f9Var;
        }
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 36 && "samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
            new Handler(Looper.getMainLooper()).postDelayed(new b(26, this), 600L);
        } else {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    public final void c(Intent intent, int i3) {
        f9 f9Var;
        f9 f9Var2;
        if (this.f2450b) {
            this.f2450b = false;
            f9 f9Var3 = this.f2451c;
            this.f2451c = null;
            f9Var2 = f9Var3;
            f9Var = null;
        } else {
            s sVar = this.f2449a;
            f9Var = (f9) sVar.f1486b;
            if (f9Var != null) {
                f9Var2 = (f9) sVar.f1487c;
                sVar.f1486b = f9Var2;
                sVar.f1487c = null;
                sVar.f1485a = false;
            } else {
                f9Var = null;
                f9Var2 = null;
            }
        }
        boolean z2 = f9Var != null;
        try {
            m.c(this).b(z2, z2 ? f9Var.f4017a : -1L, z2 ? f9Var.f4018b : null, i3, intent, l.n(this) == 3 && (l.q(this) || l.v(this, 3, System.currentTimeMillis())));
        } catch (Exception e3) {
            Log.w("MPRequest", "projection result delivery failed: " + e3.getMessage());
        }
        if (f9Var2 == null) {
            b();
            return;
        }
        s sVar2 = this.f2449a;
        f9 f9Var4 = (f9) sVar2.f1486b;
        if (f9Var4 == null) {
            if (f9Var4 == null) {
                sVar2.f1486b = f9Var2;
            } else if (!f9Var2.equals(f9Var4) && !f9Var2.equals((f9) sVar2.f1487c)) {
                sVar2.f1487c = f9Var2;
            }
        }
        e(f9Var2);
    }

    public final void d() {
        Intent intentCreateScreenCaptureIntent;
        s sVar = this.f2449a;
        f9 f9Var = (f9) sVar.f1486b;
        if (f9Var != null) {
            if (f9Var == null) {
                o2.k("no active projection request");
                return;
            }
            sVar.f1485a = true;
        }
        try {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    Class<?> cls = Class.forName("android.media.projection.MediaProjectionConfig");
                    intentCreateScreenCaptureIntent = (Intent) mediaProjectionManager.getClass().getMethod("createScreenCaptureIntent", cls).invoke(mediaProjectionManager, cls.getMethod("createConfigForDefaultDisplay", null).invoke(null, null));
                } catch (Throwable th) {
                    Log.w("MPRequest", "MediaProjectionConfig unavailable: ".concat(th.getClass().getSimpleName()));
                    intentCreateScreenCaptureIntent = null;
                }
            } else {
                intentCreateScreenCaptureIntent = null;
            }
            if (intentCreateScreenCaptureIntent == null) {
                intentCreateScreenCaptureIntent = mediaProjectionManager.createScreenCaptureIntent();
            }
            startActivityForResult(intentCreateScreenCaptureIntent, 19792);
        } catch (Exception e3) {
            Log.e("MPRequest", "launch projection dialog failed: " + e3.getMessage());
            c(null, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011a  */
    /* JADX WARN: Code duplicated, block: B:103:0x0126  */
    /* JADX WARN: Code duplicated, block: B:93:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    public final void e(f9 f9Var) {
        boolean z2;
        boolean z3;
        if (f9Var != null) {
            long j3 = f9Var.f4017a;
            String str = f9Var.f4018b;
            if (str == null || str.isEmpty()) {
                z3 = false;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                synchronized (n.J) {
                    try {
                        File fileZ0 = n.z0(this);
                        if (fileZ0.exists()) {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(fileZ0, "rw");
                            try {
                                FileChannel channel = randomAccessFile.getChannel();
                                try {
                                    FileLock fileLockLock = channel.lock();
                                    try {
                                        if (randomAccessFile.length() < 29) {
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                        } else {
                                            randomAccessFile.seek(0L);
                                            if (randomAccessFile.readInt() == 1347570225 && randomAccessFile.readInt() == 1) {
                                                boolean z4 = randomAccessFile.readBoolean();
                                                long j4 = randomAccessFile.readLong();
                                                long j5 = jElapsedRealtime - randomAccessFile.readLong();
                                                z3 = z4 && j5 >= 0 && j5 <= 45000 && j3 == j4 && str.equals(randomAccessFile.readUTF()) && f.a(this, null).b(SystemClock.elapsedRealtime());
                                                if (fileLockLock != null) {
                                                    fileLockLock.close();
                                                }
                                                channel.close();
                                                randomAccessFile.close();
                                            } else {
                                                if (fileLockLock != null) {
                                                    fileLockLock.close();
                                                }
                                                channel.close();
                                                randomAccessFile.close();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        if (fileLockLock == null) {
                                            throw th;
                                        }
                                        try {
                                            fileLockLock.close();
                                            throw th;
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                            throw th;
                                        }
                                        try {
                                            randomAccessFile.close();
                                            throw th;
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    if (channel == null) {
                                        throw th4;
                                    }
                                    try {
                                        channel.close();
                                        throw th4;
                                    } catch (Throwable th5) {
                                        th4.addSuppressed(th5);
                                        throw th4;
                                    }
                                    Log.w("ProjectionReqLease", "read failed: " + th.getMessage());
                                    z3 = false;
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!(!n.K(this) && z2)) {
                                        d();
                                        return;
                                    }
                                    s sVar = this.f2449a;
                                    sVar.f1486b = null;
                                    sVar.f1487c = null;
                                    sVar.f1485a = false;
                                    b();
                                }
                            } catch (Throwable th6) {
                                randomAccessFile.close();
                                throw th6;
                            }
                        }
                    } catch (Throwable th7) {
                        Log.w("ProjectionReqLease", "read failed: " + th7.getMessage());
                    }
                    z3 = false;
                }
            }
            if (z3) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!(!n.K(this) && z2)) {
            d();
            return;
        }
        s sVar2 = this.f2449a;
        sVar2.f1486b = null;
        sVar2.f1487c = null;
        sVar2.f1485a = false;
        b();
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i3 == 19792) {
            c(intent, i4);
        } else {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        f9 f9Var;
        super.onCreate(bundle);
        n4.t(this);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
        window.setStatusBarColor(-16777216);
        window.setNavigationBarColor(-16777216);
        window.getDecorView().setSystemUiVisibility(4102);
        window.addFlags(128);
        if (bundle != null) {
            f9 f9Var2 = null;
            if (bundle.containsKey("projection_active_generation")) {
                try {
                    f9Var = new f9(bundle.getString("projection_active_request_id"), bundle.getLong("projection_active_generation", -1L));
                } catch (IllegalArgumentException unused) {
                    f9Var = null;
                }
            } else {
                f9Var = null;
            }
            if (bundle.containsKey("projection_queued_generation")) {
                try {
                    f9Var2 = new f9(bundle.getString("projection_queued_request_id"), bundle.getLong("projection_queued_generation", -1L));
                } catch (IllegalArgumentException unused2) {
                }
            }
            boolean z2 = bundle.getBoolean("projection_legacy_active", false);
            this.f2450b = z2;
            if (f9Var != null || f9Var2 != null || z2) {
                if (z2) {
                    this.f2451c = f9Var2;
                    this.f2449a = new s();
                } else {
                    boolean z3 = bundle.getBoolean("projection_dialog_in_flight", false);
                    s sVar = new s();
                    sVar.f1486b = f9Var;
                    sVar.f1487c = f9Var2;
                    sVar.f1485a = z3;
                    this.f2449a = sVar;
                }
                s sVar2 = this.f2449a;
                boolean z4 = sVar2.f1485a;
                if (z4) {
                    return;
                }
                f9 f9Var3 = (f9) sVar2.f1486b;
                if (f9Var3 != null && !z4) {
                    e(f9Var3);
                    return;
                }
            }
        }
        a(getIntent());
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        n4.t(this);
        setIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        s sVar = this.f2449a;
        f9 f9Var = (f9) sVar.f1486b;
        f9 f9Var2 = (f9) sVar.f1487c;
        boolean z2 = sVar.f1485a;
        if (f9Var != null) {
            bundle.putLong("projection_active_generation", f9Var.f4017a);
            bundle.putString("projection_active_request_id", f9Var.f4018b);
        }
        if (this.f2450b) {
            f9Var2 = this.f2451c;
        }
        if (f9Var2 != null) {
            bundle.putLong("projection_queued_generation", f9Var2.f4017a);
            bundle.putString("projection_queued_request_id", f9Var2.f4018b);
        }
        bundle.putBoolean("projection_dialog_in_flight", z2);
        bundle.putBoolean("projection_legacy_active", this.f2450b);
    }
}
