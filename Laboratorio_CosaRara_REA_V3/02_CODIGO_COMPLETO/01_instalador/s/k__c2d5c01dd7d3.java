// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f4056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f4057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4058c;

    public k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f4056a = colorStateList;
        this.f4057b = configuration;
        this.f4058c = theme == null ? 0 : theme.hashCode();
    }
}
