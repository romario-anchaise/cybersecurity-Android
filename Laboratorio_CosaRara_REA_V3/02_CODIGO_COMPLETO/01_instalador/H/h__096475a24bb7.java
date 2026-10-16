// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class h implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class[] f2791c = {MenuItem.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f2793b;

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Method method = this.f2793b;
        try {
            Class<?> returnType = method.getReturnType();
            Class<?> cls = Boolean.TYPE;
            Object obj = this.f2792a;
            if (returnType == cls) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
