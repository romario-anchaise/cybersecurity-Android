// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f665c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f664b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f663a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f665c == null) {
            Activity activity = getActivity();
            h0.o.c(activity);
            this.f665c = new AlertDialog.Builder(activity).create();
        }
        return this.f665c;
    }
}
