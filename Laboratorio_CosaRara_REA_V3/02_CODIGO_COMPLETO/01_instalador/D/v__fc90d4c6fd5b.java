// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class v implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionMode.Callback f143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f148f = false;

    public v(ActionMode.Callback callback, TextView textView) {
        this.f143a = callback;
        this.f144b = textView;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f143a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f143a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f143a.onDestroyActionMode(actionMode);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        String str;
        TextView textView = this.f144b;
        Context context = textView.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (!this.f148f) {
            this.f148f = true;
            try {
                Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.f145c = cls;
                this.f146d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.f147e = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.f145c = null;
                this.f146d = null;
                this.f147e = false;
            }
        }
        try {
            Method declaredMethod = (this.f147e && this.f145c.isInstance(menu)) ? this.f146d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    declaredMethod.invoke(menu, Integer.valueOf(size));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0)) {
                    if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo.exported && ((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                        }
                    }
                    arrayList.add(resolveInfo);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i2);
                MenuItem menuItemAdd = menu.add(0, 0, i2 + 100, resolveInfo2.loadLabel(packageManager));
                Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                menuItemAdd.setIntent(intentPutExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return this.f143a.onPrepareActionMode(actionMode, menu);
    }
}
