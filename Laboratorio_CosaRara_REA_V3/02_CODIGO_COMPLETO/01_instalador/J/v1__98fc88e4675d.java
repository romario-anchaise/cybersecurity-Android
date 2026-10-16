// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f3327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f3328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f3329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f3330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f3331f;
    public final int[] g;

    public v1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3329d = layoutParams;
        this.f3330e = new Rect();
        this.f3331f = new int[2];
        this.g = new int[2];
        this.f3326a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f3327b = viewInflate;
        this.f3328c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(v1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
