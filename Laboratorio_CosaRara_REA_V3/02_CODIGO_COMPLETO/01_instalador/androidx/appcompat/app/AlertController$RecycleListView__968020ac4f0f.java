// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import p007e.a;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1267b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2244t);
        this.f1267b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f1266a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
