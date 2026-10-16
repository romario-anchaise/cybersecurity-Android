// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: androidx.recyclerview.widget.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0106y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2067f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f2071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2072l;

    public final void a(View view) {
        int layoutPosition;
        int size = this.f2071k.size();
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            View view3 = ((c0) this.f2071k.get(i3)).itemView;
            O o2 = (O) view3.getLayoutParams();
            if (view3 != view && !o2.f1754a.isRemoved() && (layoutPosition = (o2.f1754a.getLayoutPosition() - this.f2065d) * this.f2066e) >= 0 && layoutPosition < i2) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i2 = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f2065d = -1;
        } else {
            this.f2065d = ((O) view2.getLayoutParams()).f1754a.getLayoutPosition();
        }
    }

    public final View b(U u2) {
        List list = this.f2071k;
        if (list == null) {
            View view = u2.k(this.f2065d, Long.MAX_VALUE).itemView;
            this.f2065d += this.f2066e;
            return view;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = ((c0) this.f2071k.get(i2)).itemView;
            O o2 = (O) view2.getLayoutParams();
            if (!o2.f1754a.isRemoved() && this.f2065d == o2.f1754a.getLayoutPosition()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
