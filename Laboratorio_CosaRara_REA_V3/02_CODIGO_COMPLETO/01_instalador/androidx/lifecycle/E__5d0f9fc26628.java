// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import A.C0005e;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class E extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1634b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0005e f1635a;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final D Companion = new D();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            F0.i.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            F0.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            F0.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            F0.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            F0.i.e(activity, "activity");
            int i2 = E.f1634b;
            C.a(activity, EnumC0076n.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            F0.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            F0.i.e(activity, "activity");
            F0.i.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            F0.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            F0.i.e(activity, "activity");
        }
    }

    public final void a(EnumC0076n enumC0076n) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            F0.i.d(activity, "activity");
            C.a(activity, enumC0076n);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(EnumC0076n.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(EnumC0076n.ON_DESTROY);
        this.f1635a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(EnumC0076n.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        C0005e c0005e = this.f1635a;
        if (c0005e != null) {
            ((B) c0005e.f34b).a();
        }
        a(EnumC0076n.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        C0005e c0005e = this.f1635a;
        if (c0005e != null) {
            B b2 = (B) c0005e.f34b;
            int i2 = b2.f1627a + 1;
            b2.f1627a = i2;
            if (i2 == 1 && b2.f1630d) {
                b2.f1632f.f(EnumC0076n.ON_START);
                b2.f1630d = false;
            }
        }
        a(EnumC0076n.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(EnumC0076n.ON_STOP);
    }
}
