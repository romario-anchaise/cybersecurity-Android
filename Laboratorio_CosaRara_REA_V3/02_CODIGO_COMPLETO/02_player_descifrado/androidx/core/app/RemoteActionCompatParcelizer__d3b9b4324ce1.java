// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import o.a;
import o.b;
import o.c;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f155a;
        boolean z2 = true;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f155a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f156b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f2779e);
        }
        remoteActionCompat.f156b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f157c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f2779e);
        }
        remoteActionCompat.f157c = charSequence2;
        remoteActionCompat.f158d = (PendingIntent) aVar.f(remoteActionCompat.f158d, 4);
        boolean z3 = remoteActionCompat.f159e;
        if (aVar.e(5)) {
            z3 = ((b) aVar).f2779e.readInt() != 0;
        }
        remoteActionCompat.f159e = z3;
        boolean z4 = remoteActionCompat.f160f;
        if (!aVar.e(6)) {
            z2 = z4;
        } else if (((b) aVar).f2779e.readInt() == 0) {
            z2 = false;
        }
        remoteActionCompat.f160f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f155a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f156b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f2779e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f157c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f158d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z2 = remoteActionCompat.f159e;
        aVar.h(5);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = remoteActionCompat.f160f;
        aVar.h(6);
        parcel.writeInt(z3 ? 1 : 0);
    }
}
