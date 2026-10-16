// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class O extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f1754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f1755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1757d;

    public O(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1755b = new Rect();
        this.f1756c = true;
        this.f1757d = false;
    }

    public O(int i2, int i3) {
        super(i2, i3);
        this.f1755b = new Rect();
        this.f1756c = true;
        this.f1757d = false;
    }

    public O(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1755b = new Rect();
        this.f1756c = true;
        this.f1757d = false;
    }

    public O(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1755b = new Rect();
        this.f1756c = true;
        this.f1757d = false;
    }

    public O(O o2) {
        super((ViewGroup.LayoutParams) o2);
        this.f1755b = new Rect();
        this.f1756c = true;
        this.f1757d = false;
    }
}
