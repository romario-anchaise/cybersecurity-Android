// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p012h0;

import F0.i;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.InterfaceC0067e;
import androidx.lifecycle.InterfaceC0082u;

/* JADX INFO: loaded from: classes.dex */
public final class a implements InterfaceC0067e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2841b;

    public a(ImageView imageView) {
        this.f2841b = imageView;
    }

    @Override // androidx.lifecycle.InterfaceC0067e
    public final void e(InterfaceC0082u interfaceC0082u) {
        this.f2840a = false;
        h();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            if (i.a(this.f2841b, ((a) obj).f2841b)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.lifecycle.InterfaceC0067e
    public final void f(InterfaceC0082u interfaceC0082u) {
        this.f2840a = true;
        h();
    }

    public final void h() {
        Object drawable = this.f2841b.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.f2840a) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final int hashCode() {
        return this.f2841b.hashCode();
    }

    public final void i(Drawable drawable) {
        ImageView imageView = this.f2841b;
        Object drawable2 = imageView.getDrawable();
        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable != null) {
            animatable.stop();
        }
        imageView.setImageDrawable(drawable);
        h();
    }
}
