// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f47a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f48b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f49c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f50d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f47a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f48b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f49c = declaredField3;
            declaredField3.setAccessible(true);
            f50d = true;
        } catch (ReflectiveOperationException e2) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
        }
    }
}
