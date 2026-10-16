// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.common.api.GoogleApiActivity;
import g0.w;
import java.util.ArrayList;
import java.util.Iterator;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f670c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f671d = new e();

    public static AlertDialog e(Activity activity, int i3, h0.l lVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i3 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(h0.k.b(activity, i3));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i3 == 1) {
            string = resources.getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_install_button);
        } else if (i3 != 2) {
            string = i3 != 3 ? resources.getString(R.string.ok) : resources.getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, lVar);
        }
        String strC = h0.k.c(activity, i3);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", a0.a.g("Creating dialog for Google Play services availability issue. ConnectionResult=", i3), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        h0.o.d(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        cVar.f663a = alertDialog;
        if (onCancelListener != null) {
            cVar.f664b = onCancelListener;
        }
        cVar.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i3, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogE = e(googleApiActivity, i3, new h0.l(super.a(i3, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogE == null) {
            return;
        }
        f(googleApiActivity, alertDialogE, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0308  */
    /* JADX WARN: Code duplicated, block: B:110:0x0311  */
    public final void g(Context context, int i3, PendingIntent pendingIntent) {
        int i4;
        int i5;
        Bundle bundle;
        int i6;
        ArrayList arrayList;
        Icon iconCreateWithBitmap;
        String resPackage;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        Uri uri;
        int i7;
        Log.w("GoogleApiAvailability", j4.c(i3, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i3 == 18) {
            new j(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i3 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i3 == 6 ? h0.k.e(context, "common_google_play_services_resolution_required_title") : h0.k.c(context, i3);
        if (strE == null) {
            strE = context.getResources().getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i3 == 6 || i3 == 19) ? h0.k.d(context, "common_google_play_services_resolution_required_text", h0.k.a(context)) : h0.k.b(context, i3);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        h0.o.c(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        d.b bVar = new d.b();
        ArrayList arrayList2 = new ArrayList();
        bVar.f511f = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        bVar.f507b = true;
        bVar.f509d = false;
        Notification notification = new Notification();
        bVar.f506a = null;
        String str = strD;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        bVar.f508c = 0;
        bVar.f512g = new ArrayList();
        bVar.f510e = true;
        bVar.f509d = true;
        notification.flags |= 16;
        bVar.f513h = d.b.a(strE);
        y.e eVar = new y.e();
        eVar.f5977d = d.b.a(str);
        if (((y.e) bVar.f516k) != eVar) {
            bVar.f516k = eVar;
            eVar.o(bVar);
        }
        PackageManager packageManager = context.getPackageManager();
        if (q2.k.f3148a == null) {
            q2.k.f3148a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (q2.k.f3148a.booleanValue()) {
            notification.icon = context.getApplicationInfo().icon;
            bVar.f508c = 2;
            if (q2.k.i(context)) {
                arrayList2.add(new d.a(resources.getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_open_on_phone), pendingIntent));
            } else {
                bVar.f515j = pendingIntent;
            }
        } else {
            notification.icon = R.drawable.stat_sys_warning;
            notification.tickerText = d.b.a(resources.getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_notification_ticker));
            notification.when = System.currentTimeMillis();
            bVar.f515j = pendingIntent;
            bVar.f514i = d.b.a(str);
        }
        synchronized (f670c) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(com.os9sp.yfwkcq0dwfxaf.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            i4 = 2;
        } else {
            i4 = 2;
            if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        bVar.f506a = "com.google.android.gms.availability";
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Notification.Builder builder = new Notification.Builder(context, bVar.f506a);
        Bundle bundle3 = bundle2;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle((CharSequence) bVar.f513h).setContentText((CharSequence) bVar.f514i).setContentInfo(null).setContentIntent((PendingIntent) bVar.f515j).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(bVar.f508c);
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            d.a aVar = (d.a) arrayList2.get(i8);
            if (aVar.f500b == null && (i7 = aVar.f503e) != 0) {
                aVar.f500b = IconCompat.a(i7);
            }
            IconCompat iconCompat = aVar.f500b;
            boolean z2 = aVar.f501c;
            int i10 = size;
            Bundle bundle4 = aVar.f499a;
            Bundle bundle5 = bundle3;
            if (iconCompat != null) {
                arrayList = arrayList2;
                int i11 = iconCompat.f162a;
                switch (i11) {
                    case -1:
                        notificationManager = notificationManager;
                        i9 = i9;
                        iconCreateWithBitmap = (Icon) iconCompat.f163b;
                        break;
                    case 0:
                    default:
                        o2.i("Unknown type");
                        return;
                    case 1:
                        notificationManager = notificationManager;
                        i9 = i9;
                        iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f163b);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 2:
                        notificationManager = notificationManager;
                        i9 = i9;
                        if (i11 == -1) {
                            resPackage = ((Icon) iconCompat.f163b).getResPackage();
                        } else {
                            if (i11 != i4) {
                                b2.a.f(iconCompat, "called getResPackage() on ");
                                return;
                            }
                            resPackage = TextUtils.isEmpty(iconCompat.f171j) ? ((String) iconCompat.f163b).split(":", -1)[0] : iconCompat.f171j;
                        }
                        iconCreateWithBitmap = Icon.createWithResource(resPackage, iconCompat.f166e);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 3:
                        i9 = i9;
                        iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f163b, iconCompat.f166e, iconCompat.f167f);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 4:
                        i9 = i9;
                        iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f163b);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 5:
                        i9 = i9;
                        iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) iconCompat.f163b);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 6:
                        if (i11 == -1) {
                            iconCompat = iconCompat;
                            uri = ((Icon) iconCompat.f163b).getUri();
                        } else {
                            if (i11 == 4) {
                                iconCompat = iconCompat;
                            } else if (i11 != 6) {
                                iconCompat = iconCompat;
                                b2.a.f(iconCompat, "called getUri() on ");
                                return;
                            }
                            iconCompat = iconCompat;
                            uri = Uri.parse((String) iconCompat.f163b);
                        }
                        iconCreateWithBitmap = Icon.createWithAdaptiveBitmapContentUri(uri);
                        colorStateList = iconCompat.f168g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.f169h;
                        if (mode != IconCompat.f161k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                }
            } else {
                notificationManager = notificationManager;
                arrayList = arrayList2;
                i9 = i9;
                iconCreateWithBitmap = null;
            }
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCreateWithBitmap, aVar.f504f, aVar.f505g);
            Bundle bundle6 = bundle4 != null ? new Bundle(bundle4) : new Bundle();
            bundle6.putBoolean("android.support.allowGeneratedReplies", z2);
            builder2.setAllowGeneratedReplies(z2);
            bundle6.putInt("android.support.action.semanticAction", 0);
            builder2.setSemanticAction(0);
            builder2.setContextual(false);
            bundle6.putBoolean("android.support.action.showsUserInterface", aVar.f502d);
            builder2.addExtras(bundle6);
            builder.addAction(builder2.build());
            size = i10;
            bundle3 = bundle5;
            arrayList2 = arrayList;
            i8 = i9;
            notificationManager = notificationManager;
            i4 = 2;
        }
        NotificationManager notificationManager2 = notificationManager;
        Bundle bundle7 = (Bundle) bVar.f517l;
        if (bundle7 != null) {
            bundle3.putAll(bundle7);
        }
        builder.setShowWhen(bVar.f507b);
        builder.setLocalOnly(bVar.f509d).setGroup(null).setGroupSummary(false).setSortKey(null);
        builder.setCategory(null).setColor(0).setVisibility(0).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList4 = (ArrayList) bVar.f512g;
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            int size2 = arrayList4.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj = arrayList4.get(i12);
                i12++;
                builder.addPerson((String) obj);
            }
        }
        if (arrayList3.size() > 0) {
            if (((Bundle) bVar.f517l) == null) {
                bVar.f517l = new Bundle();
            }
            Bundle bundle8 = ((Bundle) bVar.f517l).getBundle("android.car.EXTENSIONS");
            if (bundle8 == null) {
                bundle8 = new Bundle();
            }
            Bundle bundle9 = new Bundle(bundle8);
            Bundle bundle10 = new Bundle();
            int i13 = 0;
            while (i13 < arrayList3.size()) {
                String string2 = Integer.toString(i13);
                d.a aVar2 = (d.a) arrayList3.get(i13);
                Bundle bundle11 = new Bundle();
                if (aVar2.f500b == null && (i6 = aVar2.f503e) != 0) {
                    aVar2.f500b = IconCompat.a(i6);
                }
                IconCompat iconCompat2 = aVar2.f500b;
                int i14 = i13;
                Bundle bundle12 = aVar2.f499a;
                ArrayList arrayList5 = arrayList3;
                bundle11.putInt("icon", iconCompat2 != null ? iconCompat2.b() : 0);
                bundle11.putCharSequence("title", aVar2.f504f);
                bundle11.putParcelable("actionIntent", aVar2.f505g);
                Bundle bundle13 = bundle12 != null ? new Bundle(bundle12) : new Bundle();
                bundle13.putBoolean("android.support.allowGeneratedReplies", aVar2.f501c);
                bundle11.putBundle("extras", bundle13);
                bundle11.putParcelableArray("remoteInputs", null);
                bundle11.putBoolean("showsUserInterface", aVar2.f502d);
                bundle11.putInt("semanticAction", 0);
                bundle10.putBundle(string2, bundle11);
                i13 = i14 + 1;
                arrayList3 = arrayList5;
            }
            bundle8.putBundle("invisible_actions", bundle10);
            bundle9.putBundle("invisible_actions", bundle10);
            if (((Bundle) bVar.f517l) == null) {
                bVar.f517l = new Bundle();
            }
            ((Bundle) bVar.f517l).putBundle("android.car.EXTENSIONS", bundle8);
            bundle3.putBundle("android.car.EXTENSIONS", bundle9);
        }
        builder.setExtras((Bundle) bVar.f517l).setRemoteInputHistory(null);
        builder.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(bVar.f506a)) {
            builder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it = ((ArrayList) bVar.f511f).iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        builder.setAllowSystemGeneratedContextualActions(bVar.f510e);
        builder.setBubbleMetadata(null);
        y.e eVar2 = (y.e) bVar.f516k;
        if (eVar2 != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(null).bigText((CharSequence) eVar2.f5977d);
        }
        Notification notificationBuild = builder.build();
        if (eVar2 != null) {
            ((y.e) bVar.f516k).getClass();
        }
        if (eVar2 != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            h.f674a.set(false);
            i5 = 10436;
        } else {
            i5 = 39789;
        }
        notificationManager2.notify(i5, notificationBuild);
    }

    public final void h(Activity activity, w wVar, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i3, new h0.l(super.a(i3, activity, "d"), wVar, 1), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
