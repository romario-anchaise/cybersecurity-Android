// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f2778f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f2780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f2781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f2782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f2783e;

    public e(Context context, int i2) {
        super(context);
        this.f2779a = i2;
    }

    public final void a(Configuration configuration) {
        if (this.f2783e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f2782d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f2782d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f2780b == null) {
            this.f2780b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2780b.setTo(theme);
            }
        }
        this.f2780b.applyStyle(this.f2779a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f2783e == null) {
            Configuration configuration = this.f2782d;
            if (configuration == null) {
                this.f2783e = super.getResources();
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    if (f2778f == null) {
                        Configuration configuration2 = new Configuration();
                        configuration2.fontScale = 0.0f;
                        f2778f = configuration2;
                    }
                    if (configuration.equals(f2778f)) {
                        this.f2783e = super.getResources();
                    }
                }
                this.f2783e = d.a(this, this.f2782d).getResources();
            }
        }
        return this.f2783e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2781c == null) {
            this.f2781c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2781c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f2780b;
        if (theme != null) {
            return theme;
        }
        if (this.f2779a == 0) {
            this.f2779a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f2780b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        if (this.f2779a != i2) {
            this.f2779a = i2;
            b();
        }
    }
}
