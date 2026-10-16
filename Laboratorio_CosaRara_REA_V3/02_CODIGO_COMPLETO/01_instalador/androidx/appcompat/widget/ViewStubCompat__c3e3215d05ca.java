// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import p015j.x1;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f1463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f1464d;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1461a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p007e.a.f2225A, 0, 0);
        this.f1462b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f1461a = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(0, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f1461a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f1464d;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f1461a, viewGroup, false);
        int i2 = this.f1462b;
        if (i2 != -1) {
            viewInflate.setId(i2);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f1463c = new WeakReference(viewInflate);
        return viewInflate;
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1462b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1464d;
    }

    public int getLayoutResource() {
        return this.f1461a;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i2) {
        this.f1462b = i2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1464d = layoutInflater;
    }

    public void setLayoutResource(int i2) {
        this.f1461a = i2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        WeakReference weakReference = this.f1463c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i2);
            return;
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            a();
        }
    }

    public void setOnInflateListener(x1 x1Var) {
    }
}
