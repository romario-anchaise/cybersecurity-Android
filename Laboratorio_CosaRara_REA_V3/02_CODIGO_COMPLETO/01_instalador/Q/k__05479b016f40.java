// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import android.app.NotificationManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static boolean a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static int b(NotificationManager notificationManager) {
        return notificationManager.getImportance();
    }
}
