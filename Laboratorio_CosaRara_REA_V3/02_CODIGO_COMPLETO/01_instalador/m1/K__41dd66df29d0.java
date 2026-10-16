// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* JADX INFO: loaded from: classes.dex */
public final class K extends C0198b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3771h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ K(int i2) {
        super(7);
        this.f3771h = i2;
    }

    @Override // m1.C0198b
    public String c(Method method, int i2) {
        switch (this.f3771h) {
            case 1:
                Parameter parameter = method.getParameters()[i2];
                if (!parameter.isNamePresent()) {
                    return super.c(method, i2);
                }
                return "parameter '" + parameter.getName() + '\'';
            default:
                return super.c(method, i2);
        }
    }

    @Override // m1.C0198b
    public final Object d(Object obj, Method method, Object[] objArr) {
        switch (this.f3771h) {
            case 0:
                if (Build.VERSION.SDK_INT >= 26) {
                    return W.k(obj, method, objArr);
                }
                throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
            default:
                return W.k(obj, method, objArr);
        }
    }

    @Override // m1.C0198b
    public final boolean e(Method method) {
        switch (this.f3771h) {
            case 0:
                break;
        }
        return method.isDefault();
    }
}
