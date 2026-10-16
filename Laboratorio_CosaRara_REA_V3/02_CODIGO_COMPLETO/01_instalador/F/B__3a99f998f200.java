// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class B implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f2400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f2401d;

    public B(View view, String str) {
        this.f2398a = view;
        this.f2399b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f2400c != null) {
            break;
        }
        View view2 = this.f2398a;
        Context context = view2.getContext();
        while (true) {
            String str2 = this.f2399b;
            if (context == null) {
                int id = view2.getId();
                if (id == -1) {
                    str = "";
                } else {
                    str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
            }
            try {
                if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                    this.f2400c = method;
                    this.f2401d = context;
                    break;
                }
            } catch (NoSuchMethodException unused) {
            }
            context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
        }
        try {
            this.f2400c.invoke(this.f2401d, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
