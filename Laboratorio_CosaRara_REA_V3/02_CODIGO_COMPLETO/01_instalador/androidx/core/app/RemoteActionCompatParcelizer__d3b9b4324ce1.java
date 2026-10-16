// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.app;

import U.a;
import U.b;
import U.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f1468a;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f1468a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f1469b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f628e);
        }
        remoteActionCompat.f1469b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1470c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f628e);
        }
        remoteActionCompat.f1470c = charSequence2;
        remoteActionCompat.f1471d = (PendingIntent) aVar.f(remoteActionCompat.f1471d, 4);
        boolean z2 = remoteActionCompat.f1472e;
        if (aVar.e(5)) {
            z2 = ((b) aVar).f628e.readInt() != 0;
        }
        remoteActionCompat.f1472e = z2;
        boolean z3 = remoteActionCompat.f1473f;
        if (aVar.e(6)) {
            z3 = ((b) aVar).f628e.readInt() != 0;
        }
        remoteActionCompat.f1473f = z3;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1468a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1469b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f628e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1470c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f1471d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z2 = remoteActionCompat.f1472e;
        aVar.h(5);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = remoteActionCompat.f1473f;
        aVar.h(6);
        parcel.writeInt(z3 ? 1 : 0);
    }
}
