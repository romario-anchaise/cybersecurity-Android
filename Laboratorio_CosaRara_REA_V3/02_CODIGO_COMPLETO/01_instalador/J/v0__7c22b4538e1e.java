// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: j.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0176v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f3325a;

    static {
        Field declaredField = null;
        try {
            declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        f3325a = declaredField;
    }
}
