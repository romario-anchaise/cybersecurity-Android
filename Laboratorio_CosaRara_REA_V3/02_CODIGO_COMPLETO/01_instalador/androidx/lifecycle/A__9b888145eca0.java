// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0070h {
    final /* synthetic */ B this$0;

    public static final class a extends AbstractC0070h {
        final /* synthetic */ B this$0;

        public a(B b2) {
            this.this$0 = b2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            F0.i.e(activity, "activity");
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            F0.i.e(activity, "activity");
            B b2 = this.this$0;
            int i2 = b2.f1627a + 1;
            b2.f1627a = i2;
            if (i2 == 1 && b2.f1630d) {
                b2.f1632f.f(EnumC0076n.ON_START);
                b2.f1630d = false;
            }
        }
    }

    public A(B b2) {
        this.this$0 = b2;
    }

    @Override // androidx.lifecycle.AbstractC0070h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        F0.i.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i2 = E.f1634b;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            F0.i.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((E) fragmentFindFragmentByTag).f1635a = this.this$0.f1633h;
        }
    }

    @Override // androidx.lifecycle.AbstractC0070h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        F0.i.e(activity, "activity");
        B b2 = this.this$0;
        int i2 = b2.f1628b - 1;
        b2.f1628b = i2;
        if (i2 == 0) {
            Handler handler = b2.f1631e;
            F0.i.b(handler);
            handler.postDelayed(b2.g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        F0.i.e(activity, "activity");
        z.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0070h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        F0.i.e(activity, "activity");
        B b2 = this.this$0;
        int i2 = b2.f1627a - 1;
        b2.f1627a = i2;
        if (i2 == 0 && b2.f1629c) {
            b2.f1632f.f(EnumC0076n.ON_STOP);
            b2.f1630d = true;
        }
    }
}
