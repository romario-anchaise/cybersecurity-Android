// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f93a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f94b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f95c;

    public a(int i2, m mVar, int i3) {
        this.f93a = i2;
        this.f94b = mVar;
        this.f95c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f93a);
        this.f94b.f103a.performAction(this.f95c, bundle);
    }
}
