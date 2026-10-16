// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import H.x;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import p011h.b;
import p011h.m;
import p011h.n;
import p011h.o;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f2517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public I f2518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z f2522f;

    public u(z zVar, Window.Callback callback) {
        this.f2522f = zVar;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f2517a = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f2519c = true;
            callback.onContentChanged();
        } finally {
            this.f2519c = false;
        }
    }

    public final boolean b(int i2, Menu menu) {
        return this.f2517a.onMenuOpened(i2, menu);
    }

    public final void c(int i2, Menu menu) {
        this.f2517a.onPanelClosed(i2, menu);
    }

    public final void d(List list, Menu menu, int i2) {
        n.a(this.f2517a, list, menu, i2);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2517a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z2 = this.f2520d;
        Window.Callback callback = this.f2517a;
        if (z2) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        return this.f2522f.v(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.f2517a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        z zVar = this.f2522f;
        zVar.B();
        AbstractC0111a abstractC0111a = zVar.f2585o;
        if (abstractC0111a != null && abstractC0111a.i(keyCode, keyEvent)) {
            return true;
        }
        y yVar = zVar.f2560M;
        if (yVar != null && zVar.G(yVar, keyEvent.getKeyCode(), keyEvent)) {
            y yVar2 = zVar.f2560M;
            if (yVar2 == null) {
                return true;
            }
            yVar2.f2539l = true;
            return true;
        }
        if (zVar.f2560M == null) {
            y yVarA = zVar.A(0);
            zVar.H(yVarA, keyEvent);
            boolean zG = zVar.G(yVarA, keyEvent.getKeyCode(), keyEvent);
            yVarA.f2538k = false;
            if (zG) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2517a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2517a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2517a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f2517a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f2517a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f2517a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f2519c) {
            this.f2517a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0 || (menu instanceof p013i.n)) {
            return this.f2517a.onCreatePanelMenu(i2, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i2) {
        I i3 = this.f2518b;
        if (i3 != null) {
            View view = i2 == 0 ? new View(i3.f2414a.f2417a.f3276a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f2517a.onCreatePanelView(i2);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f2517a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f2517a.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i2, Menu menu) {
        b(i2, menu);
        z zVar = this.f2522f;
        if (i2 == 108) {
            zVar.B();
            AbstractC0111a abstractC0111a = zVar.f2585o;
            if (abstractC0111a != null) {
                abstractC0111a.c(true);
            }
        } else {
            zVar.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i2, Menu menu) {
        if (this.f2521e) {
            this.f2517a.onPanelClosed(i2, menu);
            return;
        }
        c(i2, menu);
        z zVar = this.f2522f;
        if (i2 == 108) {
            zVar.B();
            AbstractC0111a abstractC0111a = zVar.f2585o;
            if (abstractC0111a != null) {
                abstractC0111a.c(false);
                return;
            }
            return;
        }
        if (i2 != 0) {
            zVar.getClass();
            return;
        }
        y yVarA = zVar.A(i2);
        if (yVarA.f2540m) {
            zVar.t(yVarA, false);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z2) {
        o.a(this.f2517a, z2);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i2, View view, Menu menu) {
        p013i.n nVar = menu instanceof p013i.n ? (p013i.n) menu : null;
        if (i2 == 0 && nVar == null) {
            return false;
        }
        if (nVar != null) {
            nVar.f2953x = true;
        }
        I i3 = this.f2518b;
        if (i3 != null && i2 == 0) {
            K k2 = i3.f2414a;
            if (!k2.f2420d) {
                k2.f2417a.f3286l = true;
                k2.f2420d = true;
            }
        }
        boolean zOnPreparePanel = this.f2517a.onPreparePanel(i2, view, menu);
        if (nVar != null) {
            nVar.f2953x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        p013i.n nVar = this.f2522f.A(0).f2535h;
        if (nVar != null) {
            d(list, nVar, i2);
        } else {
            d(list, menu, i2);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return m.a(this.f2517a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f2517a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        this.f2517a.onWindowFocusChanged(z2);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        z zVar = this.f2522f;
        zVar.getClass();
        if (i2 != 0) {
            return m.b(this.f2517a, callback, i2);
        }
        x xVar = new x(zVar.f2581k, callback);
        b bVarN = zVar.n(xVar);
        if (bVarN != null) {
            return xVar.g(bVarN);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f2517a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
