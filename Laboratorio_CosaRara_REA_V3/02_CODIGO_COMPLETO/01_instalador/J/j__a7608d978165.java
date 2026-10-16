// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import p013i.C0128b;
import p035u.b;

/* JADX INFO: renamed from: j.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0152j extends C0181y implements InterfaceC0156l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0154k f3203d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0152j(C0154k c0154k, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f3203d = c0154k;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        d.z(this, getContentDescription());
        setOnTouchListener(new C0128b(this, this));
    }

    @Override // p015j.InterfaceC0156l
    public final boolean a() {
        return false;
    }

    @Override // p015j.InterfaceC0156l
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f3203d.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            b.f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
