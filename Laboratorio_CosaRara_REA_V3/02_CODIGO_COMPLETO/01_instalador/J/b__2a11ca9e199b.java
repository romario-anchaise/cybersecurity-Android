// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* JADX INFO: renamed from: j.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0136b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f3139a;

    public C0136b(ActionBarContainer actionBarContainer) {
        this.f3139a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f3139a;
        if (actionBarContainer.g) {
            Drawable drawable = actionBarContainer.f1302f;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1300d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f1301e;
        if (drawable3 == null || !actionBarContainer.f1303h) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f3139a;
        if (actionBarContainer.g) {
            if (actionBarContainer.f1302f != null) {
                actionBarContainer.f1300d.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f1300d;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
