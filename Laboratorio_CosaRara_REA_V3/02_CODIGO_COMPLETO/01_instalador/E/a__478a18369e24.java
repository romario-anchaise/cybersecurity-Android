// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package E;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import lyr.stable.wrapper.MainActivity;
import p015j.f1;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f149a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f150b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MainActivity mainActivity, Handler handler) {
        super(handler);
        this.f150b = mainActivity;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f149a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        Cursor cursor;
        Object obj = this.f150b;
        switch (this.f149a) {
            case 0:
                f1 f1Var = (f1) obj;
                if (f1Var.f154b && (cursor = f1Var.f155c) != null && !cursor.isClosed()) {
                    f1Var.f153a = f1Var.f155c.requery();
                    break;
                }
                break;
            default:
                String str = MainActivity.f3569m0;
                ((MainActivity) obj).v();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f1 f1Var) {
        super(new Handler());
        this.f150b = f1Var;
    }
}
