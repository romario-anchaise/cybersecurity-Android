// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: j.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0170s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f3296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f3297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f3298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3299d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f3296a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f3297b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f3298c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f3299d = true;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
    }
}
