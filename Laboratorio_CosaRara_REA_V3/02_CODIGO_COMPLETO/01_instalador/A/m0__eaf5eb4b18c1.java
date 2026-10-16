// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f51c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f52d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Constructor f53e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f54f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowInsets f55a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p033t.c f56b;

    public m0() {
        this.f55a = e();
    }

    private static WindowInsets e() {
        if (!f52d) {
            try {
                f51c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f52d = true;
        }
        Field field = f51c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!f54f) {
            try {
                f53e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            f54f = true;
        }
        Constructor constructor = f53e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // A.q0
    public z0 b() {
        a();
        z0 z0VarC = z0.c(this.f55a, null);
        x0 x0Var = z0VarC.f91a;
        x0Var.o(null);
        x0Var.q(this.f56b);
        return z0VarC;
    }

    @Override // A.q0
    public void c(p033t.c cVar) {
        this.f56b = cVar;
    }

    @Override // A.q0
    public void d(p033t.c cVar) {
        WindowInsets windowInsets = this.f55a;
        if (windowInsets != null) {
            this.f55a = windowInsets.replaceSystemWindowInsets(cVar.f4103a, cVar.f4104b, cVar.f4105c, cVar.f4106d);
        }
    }

    public m0(z0 z0Var) {
        super(z0Var);
        this.f55a = z0Var.b();
    }
}
