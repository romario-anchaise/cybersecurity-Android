// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

import A.X;
import C.h;
import F0.i;
import X0.C0062i;
import X0.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import f1.l;
import p015j.AbstractC0167q0;
import p015j.C0171t;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2195d;

    public g(x xVar, int i2, String str) {
        this.f2192a = 0;
        this.f2194c = xVar;
        this.f2193b = i2;
        this.f2195d = str;
    }

    public void a() {
        C0062i c0062i;
        ImageView imageView = (ImageView) this.f2194c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC0167q0.a(drawable);
        }
        if (drawable == null || (c0062i = (C0062i) this.f2195d) == null) {
            return;
        }
        C0171t.d(drawable, c0062i, imageView.getDrawableState());
    }

    public void b(AttributeSet attributeSet, int i2) {
        int resourceId;
        ImageView imageView = (ImageView) this.f2194c;
        Context context = imageView.getContext();
        int[] iArr = p007e.a.f2231f;
        h hVarP = h.p(context, attributeSet, iArr, i2);
        X.g(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, i2);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) hVarP.f112b;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = l.A(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC0167q0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                D.g.c(imageView, hVarP.k(2));
            }
            if (typedArray.hasValue(3)) {
                D.g.d(imageView, AbstractC0167q0.b(typedArray.getInt(3, -1), null));
            }
        } finally {
            hVarP.r();
        }
    }

    public String toString() {
        switch (this.f2192a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                if (((x) this.f2194c) == x.f1090b) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.f2193b);
                sb.append(' ');
                sb.append((String) this.f2195d);
                String string = sb.toString();
                i.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    public g(ImageView imageView) {
        this.f2192a = 1;
        this.f2193b = 0;
        this.f2194c = imageView;
    }
}
