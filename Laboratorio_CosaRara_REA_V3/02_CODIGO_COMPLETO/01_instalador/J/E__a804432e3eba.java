// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import A.C0007g;
import A.InterfaceC0006f;
import A.X;
import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC0006f c0005e;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                c0005e = new C0005e(clipData, 3);
            } else {
                C0007g c0007g = new C0007g();
                c0007g.f39b = clipData;
                c0007g.f40c = 3;
                c0005e = c0007g;
            }
            X.f(textView, c0005e.k());
            return true;
        } finally {
            textView.endBatchEdit();
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC0006f c0005e;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            c0005e = new C0005e(clipData, 3);
        } else {
            C0007g c0007g = new C0007g();
            c0007g.f39b = clipData;
            c0007g.f40c = 3;
            c0005e = c0007g;
        }
        X.f(view, c0005e.k());
        return true;
    }
}
