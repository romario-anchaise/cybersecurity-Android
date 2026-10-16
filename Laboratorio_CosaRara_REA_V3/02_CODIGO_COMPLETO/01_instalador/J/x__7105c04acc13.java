// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import X0.C0062i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.C0084b;
import c1.g;
import f1.l;

/* JADX INFO: renamed from: j.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0179x extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3348c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0179x(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h1.a(context);
        this.f3348c = false;
        g1.a(this, getContext());
        C0084b c0084b = new C0084b(this);
        this.f3346a = c0084b;
        c0084b.k(attributeSet, i2);
        g gVar = new g(this);
        this.f3347b = gVar;
        gVar.b(attributeSet, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            c0084b.a();
        }
        g gVar = this.f3347b;
        if (gVar != null) {
            gVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0062i c0062i;
        g gVar = this.f3347b;
        if (gVar == null || (c0062i = (C0062i) gVar.f2195d) == null) {
            return null;
        }
        return (ColorStateList) c0062i.f985c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0062i c0062i;
        g gVar = this.f3347b;
        if (gVar == null || (c0062i = (C0062i) gVar.f2195d) == null) {
            return null;
        }
        return (PorterDuff.Mode) c0062i.f986d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f3347b.f2194c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        g gVar = this.f3347b;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        g gVar = this.f3347b;
        if (gVar != null && drawable != null && !this.f3348c) {
            gVar.f2193b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (gVar != null) {
            gVar.a();
            if (this.f3348c) {
                return;
            }
            ImageView imageView = (ImageView) gVar.f2194c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(gVar.f2193b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f3348c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        g gVar = this.f3347b;
        ImageView imageView = (ImageView) gVar.f2194c;
        if (i2 != 0) {
            Drawable drawableA = l.A(imageView.getContext(), i2);
            if (drawableA != null) {
                AbstractC0167q0.a(drawableA);
            }
            imageView.setImageDrawable(drawableA);
        } else {
            imageView.setImageDrawable(null);
        }
        gVar.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        g gVar = this.f3347b;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3346a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        g gVar = this.f3347b;
        if (gVar != null) {
            if (((C0062i) gVar.f2195d) == null) {
                gVar.f2195d = new C0062i();
            }
            C0062i c0062i = (C0062i) gVar.f2195d;
            c0062i.f985c = colorStateList;
            c0062i.f984b = true;
            gVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        g gVar = this.f3347b;
        if (gVar != null) {
            if (((C0062i) gVar.f2195d) == null) {
                gVar.f2195d = new C0062i();
            }
            C0062i c0062i = (C0062i) gVar.f2195d;
            c0062i.f986d = mode;
            c0062i.f983a = true;
            gVar.a();
        }
    }
}
