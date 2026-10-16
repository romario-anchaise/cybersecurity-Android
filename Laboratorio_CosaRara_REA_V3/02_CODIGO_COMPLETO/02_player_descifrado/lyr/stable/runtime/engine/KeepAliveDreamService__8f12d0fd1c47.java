// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a2.c;
import a2.i;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.service.dreams.DreamService;
import android.view.View;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class KeepAliveDreamService extends DreamService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f2603d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f2605b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2606c = new i(1, this);

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        f2603d.set(this);
        c.y(getApplicationContext(), true, SystemClock.elapsedRealtime());
        try {
            setInteractive(false);
            setFullscreen(true);
            View view = new View(this);
            this.f2604a = view;
            view.setKeepScreenOn(true);
            this.f2604a.setBackgroundColor(-16777216);
            this.f2604a.setFocusable(false);
            this.f2604a.setClickable(false);
            this.f2604a.setFocusableInTouchMode(false);
            setContentView(this.f2604a);
        } catch (Throwable unused) {
        }
    }

    @Override // android.service.dreams.DreamService, android.app.Service
    public final void onDestroy() {
        AtomicReference atomicReference;
        do {
            atomicReference = f2603d;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        c.y(getApplicationContext(), false, SystemClock.elapsedRealtime());
        this.f2605b.removeCallbacks(this.f2606c);
        super.onDestroy();
    }

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        AtomicReference atomicReference;
        do {
            atomicReference = f2603d;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        c.y(getApplicationContext(), false, SystemClock.elapsedRealtime());
        this.f2605b.removeCallbacks(this.f2606c);
        this.f2604a = null;
        super.onDetachedFromWindow();
    }

    @Override // android.service.dreams.DreamService
    public final void onDreamingStarted() {
        i iVar = this.f2606c;
        Handler handler = this.f2605b;
        super.onDreamingStarted();
        try {
            c.y(getApplicationContext(), true, SystemClock.elapsedRealtime());
            c.c(getApplicationContext());
            handler.removeCallbacks(iVar);
            handler.postDelayed(iVar, 5000L);
        } catch (Throwable unused) {
        }
    }

    @Override // android.service.dreams.DreamService
    public final void onDreamingStopped() {
        super.onDreamingStopped();
        try {
            c.y(getApplicationContext(), false, SystemClock.elapsedRealtime());
            this.f2605b.removeCallbacks(this.f2606c);
            c.c(getApplicationContext());
        } catch (Throwable unused) {
        }
    }
}
