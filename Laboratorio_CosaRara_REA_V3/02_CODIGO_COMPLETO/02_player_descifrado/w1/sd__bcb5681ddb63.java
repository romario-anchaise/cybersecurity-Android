// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.util.LruCache;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class sd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f5094e = {83, 77, 83, 49};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Serializable f5095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5098d;

    public sd(String str, String str2, String str3, LinkedHashMap linkedHashMap) {
        this.f5096b = str;
        this.f5095a = str2;
        this.f5097c = str3;
        this.f5098d = linkedHashMap == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
    }

    public static String h(String str) {
        if (str.length() < 7) {
            return "***";
        }
        return str.substring(0, 3) + "****" + str.substring(str.length() - 3);
    }

    public static String j(ContentResolver contentResolver, long j3, String str) {
        ContentResolver contentResolver2;
        int columnIndex;
        String string;
        try {
            contentResolver2 = contentResolver;
            try {
                Cursor cursorQuery = contentResolver2.query(Telephony.Sms.CONTENT_URI, new String[]{"address"}, "thread_id=?", new String[]{String.valueOf(j3)}, "date DESC LIMIT 1");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst() && (string = cursorQuery.getString(0)) != null && !string.isEmpty()) {
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            contentResolver2 = contentResolver;
        }
        if (str != null && !str.isEmpty()) {
            try {
                Cursor cursorQuery2 = contentResolver2.query(Uri.parse("content://mms-sms/canonical-addresses"), null, "_id=?", new String[]{str.split("\\s+")[0]}, null);
                if (cursorQuery2 != null) {
                    try {
                        if (cursorQuery2.moveToFirst() && (columnIndex = cursorQuery2.getColumnIndex("address")) >= 0) {
                            String string2 = cursorQuery2.getString(columnIndex);
                            if (string2 == null) {
                                string2 = "";
                            }
                            cursorQuery2.close();
                            return string2;
                        }
                    } catch (Throwable th3) {
                        try {
                            cursorQuery2.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                }
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
            } catch (Throwable unused3) {
            }
        }
        return "";
    }

    public static void l(DataOutputStream dataOutputStream, int i3, int i4, String str) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", str);
            m(dataOutputStream, i3, i4, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void m(DataOutputStream dataOutputStream, int i3, int i4, JSONObject jSONObject) throws IOException {
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        dataOutputStream.write(f5094e);
        dataOutputStream.writeInt(i4);
        dataOutputStream.writeInt(i3);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        dataOutputStream.writeLong(0L);
    }

    public void a(boolean z2) {
        Runnable runnable = (Runnable) this.f5098d;
        if (((AtomicBoolean) this.f5095a).compareAndSet(false, true)) {
            if (z2) {
                try {
                    Runnable runnable2 = (Runnable) this.f5097c;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } finally {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        }
    }

    public void b(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        Throwable th;
        Cursor cursor;
        String str;
        int i4;
        int i5;
        int count;
        int i6 = i3;
        DataOutputStream dataOutputStream2 = dataOutputStream;
        String str2 = "_id";
        if (!g("android.permission.READ_SMS")) {
            l(dataOutputStream2, i6, 1, "缺少 READ_SMS 权限");
            return;
        }
        int iOptInt = jSONObject.optInt("limit", 200);
        int iOptInt2 = jSONObject.optInt("offset", 0);
        JSONArray jSONArray = new JSONArray();
        ContentResolver contentResolver = ((Context) this.f5096b).getContentResolver();
        try {
            Cursor cursorQuery = contentResolver.query(Uri.parse("content://mms-sms/conversations?simple=true"), null, null, null, "date DESC LIMIT " + iOptInt + " OFFSET " + iOptInt2);
            try {
                if (cursorQuery == null) {
                    l(dataOutputStream2, i6, 3, "cursor null（小米/HyperOS 可能限制了访问）");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_id");
                    if (columnIndex < 0) {
                        columnIndex = cursorQuery.getColumnIndex("thread_id");
                    }
                    int i7 = columnIndex;
                    int columnIndex2 = cursorQuery.getColumnIndex("snippet");
                    int columnIndex3 = cursorQuery.getColumnIndex("message_count");
                    if (columnIndex3 < 0) {
                        columnIndex3 = cursorQuery.getColumnIndex("msg_count");
                    }
                    int i8 = columnIndex3;
                    int columnIndex4 = cursorQuery.getColumnIndex("date");
                    int columnIndex5 = cursorQuery.getColumnIndex("recipient_ids");
                    while (cursorQuery.moveToNext()) {
                        long j3 = i7 >= 0 ? cursorQuery.getLong(i7) : 0L;
                        if (columnIndex2 >= 0) {
                            String string = cursorQuery.getString(columnIndex2);
                            if (string == null) {
                                string = "";
                            }
                            str = string;
                        } else {
                            str = "";
                        }
                        int i9 = i8 >= 0 ? cursorQuery.getInt(i8) : 0;
                        int i10 = i7;
                        int i11 = columnIndex4;
                        long j4 = columnIndex4 >= 0 ? cursorQuery.getLong(columnIndex4) : 0L;
                        long j5 = j3;
                        cursor = cursorQuery;
                        try {
                            String strJ = j(contentResolver, j5, columnIndex5 >= 0 ? cursorQuery.getString(columnIndex5) : "");
                            int i12 = columnIndex2;
                            try {
                                int i13 = i8;
                                try {
                                    try {
                                        i5 = i12;
                                        i4 = i13;
                                        try {
                                            Cursor cursorQuery2 = contentResolver.query(Telephony.Sms.CONTENT_URI, new String[]{str2}, "thread_id=? AND read=0", new String[]{String.valueOf(j5)}, null);
                                            if (cursorQuery2 == null) {
                                                count = 0;
                                            } else {
                                                try {
                                                    count = cursorQuery2.getCount();
                                                } catch (Throwable th2) {
                                                    try {
                                                        cursorQuery2.close();
                                                    } catch (Throwable th3) {
                                                        th2.addSuppressed(th3);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            if (cursorQuery2 != null) {
                                                cursorQuery2.close();
                                            }
                                        } catch (Throwable unused) {
                                            count = 0;
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("threadId", j5);
                                            jSONObject2.put("address", strJ);
                                            jSONObject2.put("name", k(contentResolver, strJ));
                                            jSONObject2.put("snippet", str);
                                            jSONObject2.put("date", j4);
                                            jSONObject2.put("messageCount", i9);
                                            jSONObject2.put("unreadCount", count);
                                            jSONArray.put(jSONObject2);
                                            i6 = i3;
                                            dataOutputStream2 = dataOutputStream;
                                            str2 = str2;
                                            cursorQuery = cursor;
                                            columnIndex2 = i5;
                                            i7 = i10;
                                            columnIndex4 = i11;
                                            i8 = i4;
                                        }
                                    } catch (Throwable unused2) {
                                        i4 = i13;
                                        i5 = i12;
                                    }
                                } catch (Throwable unused3) {
                                    i5 = i12;
                                    i4 = i13;
                                }
                            } catch (Throwable unused4) {
                                i4 = i8;
                                i5 = i12;
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("threadId", j5);
                            jSONObject3.put("address", strJ);
                            jSONObject3.put("name", k(contentResolver, strJ));
                            jSONObject3.put("snippet", str);
                            jSONObject3.put("date", j4);
                            jSONObject3.put("messageCount", i9);
                            jSONObject3.put("unreadCount", count);
                            jSONArray.put(jSONObject3);
                            i6 = i3;
                            dataOutputStream2 = dataOutputStream;
                            str2 = str2;
                            cursorQuery = cursor;
                            columnIndex2 = i5;
                            i7 = i10;
                            columnIndex4 = i11;
                            i8 = i4;
                        } catch (Throwable th4) {
                            th = th4;
                            i6 = i3;
                            dataOutputStream2 = dataOutputStream;
                            th = th;
                            if (cursor == null) {
                                throw th;
                            }
                            try {
                                cursor.close();
                                throw th;
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                                throw th;
                            }
                        }
                    }
                    try {
                        cursorQuery.close();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("conversations", jSONArray);
                        m(dataOutputStream, i3, 0, jSONObject4);
                    } catch (SecurityException e3) {
                        e = e3;
                        i6 = i3;
                        dataOutputStream2 = dataOutputStream;
                        l(dataOutputStream2, i6, 1, "SecurityException: " + e.getMessage());
                    } catch (Throwable th6) {
                        th = th6;
                        i6 = i3;
                        dataOutputStream2 = dataOutputStream;
                        l(dataOutputStream2, i6, 3, "query fail: " + th.getMessage());
                    }
                } catch (Throwable th7) {
                    th = th7;
                    cursor = cursorQuery;
                }
            } catch (Throwable th8) {
                th = th8;
                cursor = cursorQuery;
            }
        } catch (SecurityException e4) {
            e = e4;
            l(dataOutputStream2, i6, 1, "SecurityException: " + e.getMessage());
        } catch (Throwable th9) {
            th = th9;
            l(dataOutputStream2, i6, 3, "query fail: " + th.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0175 A[Catch: all -> 0x0111, TryCatch #1 {all -> 0x0111, blocks: (B:29:0x00eb, B:30:0x00f1, B:32:0x00f7, B:34:0x0104, B:38:0x011d, B:40:0x0122, B:42:0x0129, B:44:0x012e, B:47:0x0136, B:49:0x013b, B:52:0x0143, B:54:0x0148, B:56:0x014f, B:58:0x0154, B:60:0x015b, B:62:0x0160, B:67:0x016e, B:69:0x0175, B:72:0x0185), top: B:100:0x00eb }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0180  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r1v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r20v3, types: [org.json.JSONArray] */
    public void c(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        int i4;
        String[] strArr;
        String str;
        DataOutputStream dataOutputStream2;
        int i5;
        String string;
        String string2;
        int i6;
        ?? r1;
        int i7;
        if (!g("android.permission.READ_SMS")) {
            l(dataOutputStream, i3, 1, "缺少 READ_SMS 权限");
            return;
        }
        long jOptLong = jSONObject.optLong("threadId", -1L);
        String strOptString = jSONObject.optString("address", "");
        int iOptInt = jSONObject.optInt("limit", 500);
        int iOptInt2 = jSONObject.optInt("offset", 0);
        JSONArray jSONArray = new JSONArray();
        ContentResolver contentResolver = ((Context) this.f5096b).getContentResolver();
        String[] strArr2 = {"_id", "thread_id", "address", "body", "date", "type", "read", "sub_id"};
        if (jOptLong > 0) {
            i4 = 0;
            strArr = new String[]{String.valueOf(jOptLong)};
            str = "thread_id=?";
        } else if (strOptString.isEmpty()) {
            l(dataOutputStream, i3, 2, "需要 threadId 或 address");
            return;
        } else {
            i4 = 0;
            strArr = new String[]{strOptString};
            str = "address=?";
        }
        try {
            Cursor cursorQuery = contentResolver.query(Telephony.Sms.CONTENT_URI, strArr2, str, strArr, "date ASC LIMIT " + iOptInt + " OFFSET " + iOptInt2);
            try {
                if (cursorQuery == null) {
                    l(dataOutputStream, i3, 3, "cursor null");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                int columnIndex = cursorQuery.getColumnIndex("_id");
                int columnIndex2 = cursorQuery.getColumnIndex("thread_id");
                int columnIndex3 = cursorQuery.getColumnIndex("address");
                int columnIndex4 = cursorQuery.getColumnIndex("body");
                int columnIndex5 = cursorQuery.getColumnIndex("date");
                int columnIndex6 = cursorQuery.getColumnIndex("type");
                try {
                    int columnIndex7 = cursorQuery.getColumnIndex("read");
                    try {
                        int columnIndex8 = cursorQuery.getColumnIndex("sub_id");
                        ?? r11 = jSONArray;
                        while (cursorQuery.moveToNext()) {
                            ?? r20 = r11;
                            ?? jSONObject2 = new JSONObject();
                            int i8 = columnIndex8;
                            jSONObject2.put("id", columnIndex >= 0 ? cursorQuery.getLong(columnIndex) : 0L);
                            jSONObject2.put("threadId", columnIndex2 >= 0 ? cursorQuery.getLong(columnIndex2) : jOptLong);
                            if (columnIndex3 < 0 || (string = cursorQuery.getString(columnIndex3)) == null) {
                                string = "";
                            }
                            jSONObject2.put("address", string);
                            if (columnIndex4 < 0 || (string2 = cursorQuery.getString(columnIndex4)) == null) {
                                string2 = "";
                            }
                            jSONObject2.put("body", string2);
                            jSONObject2.put("date", columnIndex5 >= 0 ? cursorQuery.getLong(columnIndex5) : 0L);
                            jSONObject2.put("type", columnIndex6 >= 0 ? cursorQuery.getInt(columnIndex6) : i4);
                            if (columnIndex7 >= 0) {
                                i6 = columnIndex7;
                                if (cursorQuery.getInt(i6) != 0) {
                                    r1 = 1;
                                }
                                jSONObject2.put("read", r1);
                                if (i8 >= 0) {
                                    columnIndex8 = i8;
                                    i7 = cursorQuery.getInt(columnIndex8);
                                } else {
                                    columnIndex8 = i8;
                                    i7 = -1;
                                }
                                int i9 = i6;
                                jSONObject2.put("subId", i7);
                                r20.put(jSONObject2);
                                r11 = r20;
                                columnIndex = columnIndex;
                                columnIndex7 = i9;
                            } else {
                                i6 = columnIndex7;
                            }
                            r1 = i4;
                            jSONObject2.put("read", r1);
                            if (i8 >= 0) {
                                columnIndex8 = i8;
                                i7 = cursorQuery.getInt(columnIndex8);
                            } else {
                                columnIndex8 = i8;
                                i7 = -1;
                            }
                            int i10 = i6;
                            jSONObject2.put("subId", i7);
                            r20.put(jSONObject2);
                            r11 = r20;
                            columnIndex = columnIndex;
                            columnIndex7 = i10;
                        }
                        ?? r0 = r11;
                        try {
                            cursorQuery.close();
                            ?? jSONObject3 = new JSONObject();
                            jSONObject3.put("messages", r0);
                            m(dataOutputStream, i3, i4, jSONObject3);
                            return;
                        } catch (SecurityException e3) {
                            e = e3;
                            i5 = i3;
                            dataOutputStream2 = dataOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            i5 = i3;
                            dataOutputStream2 = dataOutputStream;
                            l(dataOutputStream2, i5, 3, "query fail: " + th.getMessage());
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i5 = i3;
                        dataOutputStream2 = dataOutputStream;
                        Throwable th3 = th;
                        if (cursorQuery == null) {
                            throw th3;
                        }
                        try {
                            try {
                                cursorQuery.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        } catch (SecurityException e4) {
                            e = e4;
                        } catch (Throwable th5) {
                            th = th5;
                            l(dataOutputStream2, i5, 3, "query fail: " + th.getMessage());
                            return;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    dataOutputStream2 = dataOutputStream;
                    i5 = i3;
                }
            } catch (Throwable th7) {
                th = th7;
                dataOutputStream2 = dataOutputStream;
                i5 = i3;
            }
        } catch (SecurityException e5) {
            e = e5;
            dataOutputStream2 = dataOutputStream;
            i5 = i3;
        } catch (Throwable th8) {
            th = th8;
            dataOutputStream2 = dataOutputStream;
            i5 = i3;
        }
        l(dataOutputStream2, i5, 1, "SecurityException: " + e.getMessage());
    }

    public void d(DataInputStream dataInputStream, DataOutputStream dataOutputStream, String str) {
        try {
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            if (bArr[0] == 83 && bArr[1] == 77 && bArr[2] == 83 && bArr[3] == 49) {
                int i3 = dataInputStream.readInt();
                int i4 = dataInputStream.readInt();
                int i5 = dataInputStream.readInt();
                if (i5 >= 0 && i5 <= 1000000) {
                    byte[] bArr2 = new byte[i5];
                    if (i5 > 0) {
                        dataInputStream.readFully(bArr2);
                    }
                    JSONObject jSONObject = i5 > 0 ? new JSONObject(new String(bArr2, StandardCharsets.UTF_8)) : new JSONObject();
                    if (i3 == 1) {
                        f(i4, dataOutputStream);
                    } else if (i3 == 2) {
                        b(i4, dataOutputStream, jSONObject);
                    } else if (i3 == 3) {
                        c(i4, dataOutputStream, jSONObject);
                    } else if (i3 == 4) {
                        e(i4, dataOutputStream, jSONObject);
                    } else if (i3 != 5) {
                        l(dataOutputStream, i4, 2, "unknown cmd " + i3);
                    } else {
                        String strTrim = jSONObject.optString("address", "").trim();
                        String strK = k(((Context) this.f5096b).getContentResolver(), strTrim);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("address", strTrim);
                        jSONObject2.put("name", strK);
                        m(dataOutputStream, i4, 0, jSONObject2);
                    }
                    dataOutputStream.flush();
                    return;
                }
                l(dataOutputStream, i4, 2, "metaLen out of range");
                dataOutputStream.flush();
                return;
            }
            Log.w("MirrorSmsSrv", "bad magic from ".concat(str));
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("handleRequest (", str, "): "), "MirrorSmsSrv");
        }
    }

    public void e(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        ArrayList<String> arrayList;
        if (!g("android.permission.SEND_SMS")) {
            l(dataOutputStream, i3, 1, "缺少 SEND_SMS 权限");
            return;
        }
        String strTrim = jSONObject.optString("address", "").trim();
        String strOptString = jSONObject.optString("body", "");
        int iOptInt = jSONObject.optInt("subId", -1);
        if (strTrim.isEmpty() || strOptString.isEmpty()) {
            l(dataOutputStream, i3, 2, "address/body 不能为空");
            return;
        }
        try {
            SmsManager smsManagerI = i(iOptInt);
            ArrayList<String> arrayListDivideMessage = smsManagerI.divideMessage(strOptString);
            if (arrayListDivideMessage.size() <= 1) {
                smsManagerI.sendTextMessage(strTrim, null, strOptString, null, null);
                arrayList = arrayListDivideMessage;
            } else {
                arrayList = arrayListDivideMessage;
                smsManagerI.sendMultipartTextMessage(strTrim, null, arrayList, null, null);
            }
            Log.i("MirrorSmsSrv", "SMS sent to " + h(strTrim) + " parts=" + arrayList.size() + " subId=" + iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ok", true);
            jSONObject2.put("address", strTrim);
            jSONObject2.put("length", strOptString.length());
            m(dataOutputStream, i3, 0, jSONObject2);
        } catch (SecurityException e3) {
            l(dataOutputStream, i3, 1, "SecurityException: " + e3.getMessage());
        } catch (Throwable th) {
            l(dataOutputStream, i3, 4, "sendTextMessage fail: " + th.getMessage());
        }
    }

    public void f(int i3, DataOutputStream dataOutputStream) throws JSONException, IOException {
        boolean z2;
        SubscriptionManager subscriptionManager;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hasRead", g("android.permission.READ_SMS"));
        jSONObject.put("hasSend", g("android.permission.SEND_SMS"));
        jSONObject.put("hasContacts", g("android.permission.READ_CONTACTS"));
        Context context = (Context) this.f5096b;
        try {
            String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context);
            z2 = defaultSmsPackage != null && defaultSmsPackage.equals(context.getPackageName());
        } catch (Throwable unused) {
        }
        jSONObject.put("isDefaultSmsApp", z2);
        JSONArray jSONArray = new JSONArray();
        try {
            if (g("android.permission.READ_PHONE_STATE") && (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) != null && (activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList()) != null) {
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("subId", subscriptionInfo.getSubscriptionId());
                    jSONObject2.put("slotIndex", subscriptionInfo.getSimSlotIndex());
                    jSONObject2.put("carrierName", String.valueOf(subscriptionInfo.getCarrierName()));
                    jSONObject2.put("displayName", String.valueOf(subscriptionInfo.getDisplayName()));
                    try {
                        String number = subscriptionInfo.getNumber();
                        if (number == null) {
                            number = "";
                        }
                        jSONObject2.put("number", number);
                    } catch (Throwable unused2) {
                        jSONObject2.put("number", "");
                    }
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("listSims: "), "MirrorSmsSrv");
        }
        jSONObject.put("sims", jSONArray);
        jSONObject.put("model", Build.MANUFACTURER + " " + Build.MODEL);
        jSONObject.put("sdkInt", Build.VERSION.SDK_INT);
        m(dataOutputStream, i3, 0, jSONObject);
    }

    public boolean g(String str) {
        return ((Context) this.f5096b).checkSelfPermission(str) == 0;
    }

    public SmsManager i(int i3) {
        try {
            if (Build.VERSION.SDK_INT < 31) {
                return i3 > 0 ? SmsManager.getSmsManagerForSubscriptionId(i3) : SmsManager.getDefault();
            }
            SmsManager smsManager = (SmsManager) ((Context) this.f5096b).getSystemService(SmsManager.class);
            if (smsManager == null) {
                smsManager = SmsManager.getDefault();
            }
            return i3 > 0 ? smsManager.createForSubscriptionId(i3) : smsManager;
        } catch (Throwable unused) {
            return SmsManager.getDefault();
        }
    }

    public String k(ContentResolver contentResolver, String str) {
        LruCache lruCache = (LruCache) this.f5098d;
        if (str != null && !str.isEmpty()) {
            String str2 = (String) lruCache.get(str);
            if (str2 != null) {
                return str2;
            }
            if (!g("android.permission.READ_CONTACTS")) {
                lruCache.put(str, "");
                return "";
            }
            try {
                Cursor cursorQuery = contentResolver.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(0);
                            if (string == null) {
                                string = "";
                            }
                            lruCache.put(str, string);
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
            }
            lruCache.put(str, "");
        }
        return "";
    }

    public sd(JSONObject jSONObject, v8 v8Var, d2.r rVar) {
        this.f5095a = new AtomicBoolean(false);
        this.f5096b = jSONObject == null ? new JSONObject() : jSONObject;
        this.f5097c = v8Var;
        this.f5098d = rVar;
    }
}
