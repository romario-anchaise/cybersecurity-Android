// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f3169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f3170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f3171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f3172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f3173e;

    public e1(View view) {
        this.f3169a = (TextView) view.findViewById(R.id.text1);
        this.f3170b = (TextView) view.findViewById(R.id.text2);
        this.f3171c = (ImageView) view.findViewById(R.id.icon1);
        this.f3172d = (ImageView) view.findViewById(R.id.icon2);
        this.f3173e = (ImageView) view.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.edit_query);
    }
}
