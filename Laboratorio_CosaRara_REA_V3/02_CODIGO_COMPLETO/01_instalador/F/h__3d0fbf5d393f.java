// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.ref.WeakReference;
import p007e.a;

/* JADX INFO: renamed from: f.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0118h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogC0119i f2476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f2477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f2478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AlertController$RecycleListView f2479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f2480f;
    public Button g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f2481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NestedScrollView f2482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f2483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f2484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f2485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f2486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f2487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ListAdapter f2488o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2490q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f2491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f2492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f2493t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f2494u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HandlerC0116f f2495v;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2489p = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ViewOnClickListenerC0113c f2496w = new ViewOnClickListenerC0113c(0, this);

    public C0118h(Context context, DialogC0119i dialogC0119i, Window window) {
        this.f2475a = context;
        this.f2476b = dialogC0119i;
        this.f2477c = window;
        HandlerC0116f handlerC0116f = new HandlerC0116f();
        handlerC0116f.f2474a = new WeakReference(dialogC0119i);
        this.f2495v = handlerC0116f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, a.f2230e, R.attr.alertDialogStyle, 0);
        this.f2490q = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f2491r = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f2492s = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f2493t = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f2494u = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC0119i.b().h(1);
    }

    public static ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}
