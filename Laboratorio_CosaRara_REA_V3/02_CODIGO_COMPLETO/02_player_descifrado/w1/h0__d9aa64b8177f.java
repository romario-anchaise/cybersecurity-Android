// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f4159d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static h0 f4160e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4161c;

    public h0(Context context) {
        super(context, "a11y_telemetry_outbox.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f4161c = context.getApplicationContext();
    }

    public static JSONObject A(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        z(jSONObject2, jSONObject);
        jSONObject2.remove("delivery_version");
        jSONObject2.remove("supersedes_event_id");
        return jSONObject2;
    }

    public static int B(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM events WHERE sync_state=?", new String[]{String.valueOf(0)});
        try {
            int i3 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
            cursorRawQuery.close();
            return i3;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void C(SQLiteDatabase sQLiteDatabase, f0 f0Var) {
        String str = f0Var.f3949a;
        String str2 = f0Var.f3950b;
        if (sQLiteDatabase.delete("active_episodes", "episode_type=? AND episode_id=?", new String[]{str, str2}) == 1) {
            return;
        }
        b2.a.m(str2, "episode close failed: ");
    }

    public static int D(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, int i3) {
        if (i3 <= 0) {
            return 0;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 2];
        strArr2[0] = String.valueOf(0);
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        strArr2[length + 1] = String.valueOf(Math.min(i3, 64));
        return sQLiteDatabase.delete("events", a0.a.h("enqueue_seq IN (SELECT candidate.enqueue_seq FROM events candidate WHERE candidate.sync_state=? AND (", str, ") ORDER BY candidate.enqueue_seq ASC LIMIT ?)"), strArr2);
    }

    public static String E(int i3, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str + ":" + str2);
        sb.append(":v");
        sb.append(i3);
        return sb.toString();
    }

    public static long F(SQLiteDatabase sQLiteDatabase, String str, long j3) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MIN(observed_at_ms) FROM events WHERE transition_id=? AND kind=?", new String[]{str, "security_breach"});
        try {
            if (!cursorRawQuery.moveToFirst() || cursorRawQuery.isNull(0)) {
                cursorRawQuery.close();
                return i0(j3);
            }
            long jI0 = i0(cursorRawQuery.getLong(0));
            cursorRawQuery.close();
            return jI0;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String H(SQLiteDatabase sQLiteDatabase, String str, String str2, JSONObject jSONObject, long j3, boolean z2) throws JSONException {
        long j4;
        int i3;
        JSONObject jSONObjectA;
        String str3;
        long j5;
        JSONObject jSONObjectH0;
        int i4;
        long j6;
        String strD;
        Object objOpt;
        Object objOpt2;
        String string;
        String strD2 = s.d(str);
        if (strD2.isEmpty()) {
            strD2 = "unknown";
        }
        f0 f0VarD = d(sQLiteDatabase, "lost");
        if (f0VarD == null) {
            f0VarD = d(sQLiteDatabase, "unbind");
        }
        if (f0VarD == null) {
            j4 = j3;
            f0VarD = new f0(j4, "unbind", UUID.randomUUID().toString());
            U(sQLiteDatabase, f0VarD);
        } else {
            j4 = j3;
        }
        f0 f0Var = f0VarD;
        JSONObject jSONObjectH1 = h0(s.h(s.g(jSONObject)).toString());
        jSONObjectH1.put("breach_type", strD2);
        if ("service_destroyed".equals(strD2)) {
            i3 = 0;
        } else {
            i3 = (!"task_removed".equals(strD2) && ("a11y_unbind_settings_on".equals(strD2) || "a11y_disabled".equals(strD2))) ? 2 : 1;
        }
        if (f0Var.f3959k.isEmpty()) {
            jSONObjectH0 = A(jSONObjectH1);
            i4 = i3;
            j6 = j4;
            j5 = 0;
            strD = s.d(str2);
        } else {
            g0 g0VarM = M(sQLiteDatabase, f0Var.f3959k);
            if (g0VarM == null) {
                throw new SQLiteException("active breach version missing: " + f0Var.f3959k);
            }
            JSONObject jSONObjectH2 = h0(f0Var.f3955g);
            boolean z3 = i3 > f0Var.f3954f;
            if (z3) {
                jSONObjectA = A(jSONObjectH2);
                z(jSONObjectA, jSONObjectH1);
            } else {
                JSONObject jSONObjectA2 = A(jSONObjectH2);
                Iterator<String> itKeys = jSONObjectH1.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObjectA2.optString(next, "");
                    String strOptString2 = jSONObjectH1.optString(next, "");
                    if (jSONObjectA2.has(next)) {
                        str3 = strD2;
                        if ((strOptString == null || strOptString.isEmpty() || "unknown".equalsIgnoreCase(strOptString) || "null".equalsIgnoreCase(strOptString)) && strOptString2 != null && !strOptString2.isEmpty() && !"unknown".equalsIgnoreCase(strOptString2) && !"null".equalsIgnoreCase(strOptString2)) {
                        }
                        strD2 = str3;
                    } else {
                        str3 = strD2;
                    }
                    jSONObjectA2.put(next, jSONObjectH1.opt(next));
                    strD2 = str3;
                }
                jSONObjectA = jSONObjectA2;
            }
            j5 = 0;
            strD2 = z3 ? strD2 : f0Var.f3953e;
            jSONObjectA.put("breach_type", strD2);
            if (!z3) {
                i3 = f0Var.f3954f;
            }
            String strD3 = z3 ? s.d(str2) : f0Var.f3956h;
            long j7 = f0Var.f3957i;
            if (j7 <= 0) {
                j7 = j4;
            }
            jSONObjectH0 = h0(s.h(s.g(jSONObjectA)).toString());
            if (!z3 && jSONObjectH2.length() == jSONObjectH0.length()) {
                Iterator<String> itKeys2 = jSONObjectH2.keys();
                do {
                    if (!itKeys2.hasNext()) {
                        if (f0Var.f3952d > 0 && g0VarM.f4062d.isEmpty()) {
                            break;
                        }
                        return g0VarM.f4059a;
                    }
                    String next2 = itKeys2.next();
                    if (!jSONObjectH0.has(next2)) {
                        break;
                    }
                    objOpt = jSONObjectH2.opt(next2);
                    objOpt2 = jSONObjectH0.opt(next2);
                } while (((objOpt == null || objOpt == JSONObject.NULL) ? "" : String.valueOf(objOpt)).equals((objOpt2 == null || objOpt2 == JSONObject.NULL) ? "" : String.valueOf(objOpt2)));
            }
            i4 = i3;
            j6 = j7;
            strD = strD3;
        }
        String str4 = strD2;
        long j8 = f0Var.f3960l;
        if (j8 > j5) {
            jSONObjectH0.put("recovery_ts", j8);
            jSONObjectH0.put("downtime_ms", Math.max(j5, f0Var.f3960l - j6));
        }
        String string2 = s.h(s.g(jSONObjectH0)).toString();
        int i5 = f0Var.f3958j + 1;
        JSONObject jSONObjectH3 = h0(string2);
        jSONObjectH3.put("delivery_version", i5);
        if (!f0Var.f3959k.isEmpty()) {
            jSONObjectH3.put("supersedes_event_id", f0Var.f3959k);
        }
        if (z2) {
            string = UUID.nameUUIDFromBytes(("legacy-breach-event:" + f0Var.f3950b + ":v" + i5).getBytes(StandardCharsets.UTF_8)).toString();
        } else {
            string = null;
        }
        String str5 = f0Var.f3950b;
        String str6 = strD;
        String strV = V(sQLiteDatabase, string, "security_breach", str5, f0Var.f3952d > 0 ? str5 : "", j4, str6, jSONObjectH3, i4, i5, E(i5, str5, "security_breach"));
        if (strV != null) {
            o0(sQLiteDatabase, f0Var, str4, i4, string2, str6, j6, i5, strV, f0Var.f3960l);
            return strV;
        }
        if (f0Var.f3959k.isEmpty()) {
            return null;
        }
        return f0Var.f3959k;
    }

    public static f0 K(Cursor cursor) {
        f0 f0Var = new f0(cursor.getLong(2), cursor.getString(0), cursor.getString(1));
        f0Var.f3952d = cursor.getLong(3);
        f0Var.f3953e = cursor.getString(4);
        f0Var.f3954f = cursor.getInt(5);
        f0Var.f3955g = cursor.getString(6);
        f0Var.f3956h = cursor.getString(7);
        f0Var.f3957i = cursor.getLong(8);
        f0Var.f3958j = cursor.getInt(9);
        f0Var.f3959k = cursor.getString(10);
        f0Var.f3960l = cursor.getLong(11);
        return f0Var;
    }

    public static g0 L(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("events", O(), "dedupe_key=?", new String[]{str}, null, null, null, "1");
        try {
            g0 g0VarQ = cursorQuery.moveToFirst() ? Q(cursorQuery) : null;
            cursorQuery.close();
            return g0VarQ;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static g0 M(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("events", O(), "id=?", new String[]{str}, null, null, null, "1");
        try {
            g0 g0VarQ = cursorQuery.moveToFirst() ? Q(cursorQuery) : null;
            cursorQuery.close();
            return g0VarQ;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static g0 N(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorQuery = sQLiteDatabase.query("events", O(), "transition_id=? AND kind=? AND delivery_version=?", new String[]{str, str2, String.valueOf(1)}, null, null, "enqueue_seq ASC", "1");
        try {
            g0 g0VarQ = cursorQuery.moveToFirst() ? Q(cursorQuery) : null;
            cursorQuery.close();
            return g0VarQ;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static String[] O() {
        return new String[]{"id", "kind", "transition_id", "episode_id", "observed_at_ms", "source", "detail_json", "priority", "delivery_version", "sync_state"};
    }

    public static boolean P(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("events", new String[]{"id"}, "transition_id=? OR (transition_id='' AND episode_id=?)", new String[]{str, str}, null, null, null, "1");
        try {
            boolean zMoveToFirst = cursorQuery.moveToFirst();
            cursorQuery.close();
            return zMoveToFirst;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static g0 Q(Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        String string3 = cursor.getString(2);
        String string4 = cursor.getString(3);
        long j3 = cursor.getLong(4);
        String string5 = cursor.getString(5);
        String string6 = cursor.getString(6);
        int i3 = cursor.getInt(7);
        int i4 = cursor.getInt(8);
        cursor.getInt(9);
        return new g0(i3, i4, j3, string, string2, string3, string4, string5, string6);
    }

    public static h0 R(Context context) {
        h0 h0Var;
        synchronized (f4159d) {
            if (f4160e == null) {
                h0 h0Var2 = new h0(context.getApplicationContext());
                try {
                    h0Var2.d0();
                    f4160e = h0Var2;
                } catch (Error | RuntimeException e3) {
                    try {
                        h0Var2.close();
                    } catch (Throwable unused) {
                    }
                    throw e3;
                }
            }
            h0Var = f4160e;
        }
        return h0Var;
    }

    public static String S(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("state", new String[]{"value"}, "key=?", new String[]{str}, null, null, null, "1");
        try {
            String string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
            return string;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static boolean T(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
        try {
            int columnIndex = cursorRawQuery.getColumnIndex("name");
            while (cursorRawQuery.moveToNext()) {
                if (columnIndex >= 0 && str2.equals(cursorRawQuery.getString(columnIndex))) {
                    cursorRawQuery.close();
                    return true;
                }
            }
            cursorRawQuery.close();
            return false;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void U(SQLiteDatabase sQLiteDatabase, f0 f0Var) {
        ContentValues contentValues = new ContentValues();
        String str = f0Var.f3949a;
        contentValues.put("episode_type", str);
        String str2 = f0Var.f3950b;
        contentValues.put("episode_id", str2);
        contentValues.put("started_at_ms", Long.valueOf(f0Var.f3951c));
        contentValues.put("confirmed_at_ms", Long.valueOf(f0Var.f3952d));
        contentValues.put("breach_type", f0Var.f3953e);
        contentValues.put("breach_priority", Integer.valueOf(f0Var.f3954f));
        contentValues.put("breach_detail_json", f0Var.f3955g);
        contentValues.put("breach_source", f0Var.f3956h);
        contentValues.put("breach_observed_at_ms", Long.valueOf(f0Var.f3957i));
        contentValues.put("breach_version", Integer.valueOf(f0Var.f3958j));
        contentValues.put("breach_event_id", f0Var.f3959k);
        contentValues.put("recovered_at_ms", Long.valueOf(f0Var.f3960l));
        if (sQLiteDatabase.insert("active_episodes", null, contentValues) == -1) {
            f0 f0VarD = d(sQLiteDatabase, str);
            if (f0VarD == null || !str2.equals(f0VarD.f3950b)) {
                b2.a.m(str, "episode insert failed: ");
            }
        }
    }

    public static String V(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, long j3, String str5, JSONObject jSONObject, int i3, int i4, String str6) {
        try {
            return W(sQLiteDatabase, str, str2, str3, str4, j3, str5, jSONObject, i3, i4, str6);
        } catch (SQLiteException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new SQLiteException("event serialization failed", e4);
        }
    }

    public static String W(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, long j3, String str5, JSONObject jSONObject, int i3, int i4, String str6) throws r {
        LinkedHashMap linkedHashMap;
        String str7;
        int iA;
        int i5;
        long j4;
        String string = (str == null || str.isEmpty()) ? UUID.randomUUID().toString() : str;
        String strD = s.d(str5);
        long jI0 = i0(j3);
        List list = s.f5035a;
        LinkedHashMap linkedHashMapG = s.g(jSONObject);
        String strD2 = s.d(strD);
        while (true) {
            String string2 = s.h(linkedHashMapG).toString();
            LinkedHashMap linkedHashMap2 = linkedHashMapG;
            long j5 = jI0;
            jI0 = j5;
            try {
                s.b(Collections.singletonList(new e0(0L, string, str2, str3, str4, j5, strD2, string2)), true);
                g0 g0VarL = L(sQLiteDatabase, str6);
                if (g0VarL != null) {
                    n0(g0VarL, str2, str3, str4, jI0, strD, string2, i3, i4, str6);
                    return g0VarL.f4059a;
                }
                String str8 = string;
                String str9 = strD;
                int i6 = 64;
                boolean z2 = true;
                int iB = B(sQLiteDatabase);
                if (iB < 128) {
                    i5 = i4;
                } else {
                    int iMin = Math.min(64, Math.max(1, iB - 127));
                    if ("security_breach".equals(str2)) {
                        i5 = i4;
                        if (i5 > 1 && str3 != null && !str3.isEmpty()) {
                            int iD = D(sQLiteDatabase, "candidate.kind=? AND candidate.transition_id=? AND candidate.delivery_version<?", new String[]{"security_breach", str3, String.valueOf(i5)}, iMin);
                            i6 = 64 - iD;
                            iB -= iD;
                        }
                    } else {
                        i5 = i4;
                    }
                    if (iB >= 128 && i6 > 0) {
                        int iD2 = D(sQLiteDatabase, "candidate.kind=? AND EXISTS (SELECT 1 FROM events newer WHERE newer.transition_id=candidate.transition_id AND newer.kind=candidate.kind AND newer.delivery_version>candidate.delivery_version AND newer.sync_state IN (?,?))", new String[]{"security_breach", String.valueOf(0), String.valueOf(1)}, Math.min(i6, Math.max(1, iB - 127)));
                        i6 -= iD2;
                        iB -= iD2;
                    }
                    if (iB >= 128 && i6 > 0) {
                        iB -= D(sQLiteDatabase, "candidate.kind=? AND candidate.episode_id='' AND NOT EXISTS (SELECT 1 FROM active_episodes active WHERE active.episode_id=candidate.transition_id)", new String[]{"a11y_unbind"}, Math.min(i6, Math.max(1, iB - 127)));
                    }
                    z2 = iB < 128;
                }
                if (!z2) {
                    String strS = S(sQLiteDatabase, "outbox_omission_debt_v1");
                    if (strS == null) {
                        strS = "";
                    }
                    try {
                        j4 = Long.parseLong(strS);
                    } catch (NumberFormatException unused) {
                        j4 = 0;
                    }
                    long jMax = Math.max(0L, j4);
                    k0(sQLiteDatabase, "outbox_omission_debt_v1", String.valueOf(jMax != Long.MAX_VALUE ? 1 + jMax : Long.MAX_VALUE));
                    return null;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", str8);
                contentValues.put("kind", str2);
                contentValues.put("transition_id", str3);
                contentValues.put("episode_id", str4);
                contentValues.put("observed_at_ms", Long.valueOf(jI0));
                contentValues.put("source", str9);
                contentValues.put("detail_json", string2);
                contentValues.put("priority", Integer.valueOf(i3));
                contentValues.put("delivery_version", Integer.valueOf(i5));
                contentValues.put("dedupe_key", str6);
                contentValues.put("sync_state", (Integer) 0);
                if (sQLiteDatabase.insertWithOnConflict("events", null, contentValues, 4) != -1) {
                    return str8;
                }
                g0 g0VarL2 = L(sQLiteDatabase, str6);
                if (g0VarL2 == null) {
                    throw new SQLiteException("event insert failed without existing dedupe row");
                }
                n0(g0VarL2, str2, str3, str4, jI0, str9, string2, i3, i5, str6);
                return g0VarL2.f4059a;
            } catch (r e3) {
                String str10 = strD;
                List list2 = list;
                String str11 = string;
                String str12 = null;
                for (String str13 : linkedHashMap2.keySet()) {
                    if (!list2.contains(str13)) {
                        str12 = str13;
                    }
                }
                if (str12 != null) {
                    linkedHashMap = linkedHashMap2;
                    linkedHashMap.remove(str12);
                } else {
                    linkedHashMap = linkedHashMap2;
                    String str14 = null;
                    int i7 = 64;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        if (!"breach_type".equals(entry.getKey()) && (iA = s.a((String) entry.getValue())) > i7) {
                            str14 = (String) entry.getKey();
                            i7 = iA;
                        }
                    }
                    if (str14 != null) {
                        String str15 = (String) linkedHashMap.get(str14);
                        linkedHashMap.put(str14, s.i(str15, Math.max(64, str15.codePointCount(0, str15.length()) / 2)));
                    } else {
                        int size = list2.size() - 1;
                        while (true) {
                            if (size < 0) {
                                str7 = null;
                                break;
                            }
                            str7 = (String) list2.get(size);
                            if (!"breach_type".equals(str7) && linkedHashMap.containsKey(str7)) {
                                break;
                            }
                            size--;
                        }
                        if (str7 != null) {
                            linkedHashMap.remove(str7);
                        } else {
                            String str16 = (String) linkedHashMap.get("breach_type");
                            if (str16 == null || str16.codePointCount(0, str16.length()) <= 64) {
                                throw e3;
                            }
                            linkedHashMap.put("breach_type", s.i(str16, 64));
                        }
                    }
                }
                strD = str10;
                string = str11;
                list = list2;
                linkedHashMapG = linkedHashMap;
            }
        }
    }

    public static g0 X(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorQuery = sQLiteDatabase.query("events", O(), "transition_id=? AND kind=?", new String[]{str, str2}, null, null, "delivery_version DESC,enqueue_seq DESC", "1");
        try {
            g0 g0VarQ = cursorQuery.moveToFirst() ? Q(cursorQuery) : null;
            cursorQuery.close();
            return g0VarQ;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static void a0(SQLiteDatabase sQLiteDatabase, f0 f0Var, long j3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("recovered_at_ms", Long.valueOf(j3));
        String str = f0Var.f3949a;
        String str2 = f0Var.f3950b;
        if (sQLiteDatabase.update("active_episodes", contentValues, "episode_type=? AND episode_id=?", new String[]{str, str2}) == 1) {
            f0Var.f3960l = j3;
        } else {
            b2.a.m(str2, "episode recovery update failed: ");
        }
    }

    public static f0 d(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("active_episodes", new String[]{"episode_type", "episode_id", "started_at_ms", "confirmed_at_ms", "breach_type", "breach_priority", "breach_detail_json", "breach_source", "breach_observed_at_ms", "breach_version", "breach_event_id", "recovered_at_ms"}, "episode_type=?", new String[]{str}, null, null, null, "1");
        try {
            f0 f0VarK = cursorQuery.moveToFirst() ? K(cursorQuery) : null;
            cursorQuery.close();
            return f0VarK;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static JSONObject h0(String str) {
        return (str == null || str.isEmpty()) ? new JSONObject() : new JSONObject(str);
    }

    public static long i0(long j3) {
        if (j3 > 0) {
            return j3;
        }
        return 1L;
    }

    public static void k0(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        if (sQLiteDatabase.insertWithOnConflict("state", null, contentValues, 5) == -1) {
            throw new SQLiteException("state write failed: ".concat(str));
        }
    }

    public static void m0(SQLiteDatabase sQLiteDatabase, String str) {
        long j3;
        f0 f0VarD = d(sQLiteDatabase, "lost");
        if (f0VarD == null || !str.equals(f0VarD.f3950b)) {
            g0 g0VarX = X(sQLiteDatabase, str, "a11y_reenabled");
            g0 g0VarX2 = X(sQLiteDatabase, str, "security_breach");
            if (g0VarX == null || g0VarX2 == null) {
                return;
            }
            try {
                JSONObject jSONObjectA = A(h0(g0VarX2.f4065g));
                String strOptString = jSONObjectA.optString("recovery_ts", "");
                try {
                    j3 = Long.parseLong(strOptString != null ? strOptString : "");
                } catch (NumberFormatException unused) {
                    j3 = 0;
                }
                if (j3 > 0) {
                    return;
                }
                long jI0 = i0(g0VarX.f4063e);
                long jF = F(sQLiteDatabase, str, g0VarX2.f4063e);
                jSONObjectA.put("recovery_ts", jI0);
                jSONObjectA.put("downtime_ms", Math.max(0L, jI0 - jF));
                String string = s.h(s.g(jSONObjectA)).toString();
                int i3 = g0VarX2.f4067i + 1;
                JSONObject jSONObjectH0 = h0(string);
                jSONObjectH0.put("delivery_version", i3);
                jSONObjectH0.put("supersedes_event_id", g0VarX2.f4059a);
                V(sQLiteDatabase, UUID.nameUUIDFromBytes(("legacy-v2-recovery-event:" + str + ":v" + i3).getBytes(StandardCharsets.UTF_8)).toString(), "security_breach", str, str, jI0, g0VarX2.f4064f, jSONObjectH0, g0VarX2.f4066h, i3, E(i3, str, "security_breach"));
            } catch (SQLiteException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new SQLiteException("legacy v2 recovery repair failed", e4);
            }
        }
    }

    public static void n0(g0 g0Var, String str, String str2, String str3, long j3, String str4, String str5, int i3, int i4, String str6) {
        if (!str.equals(g0Var.f4060b) || !str2.equals(g0Var.f4061c) || !str3.equals(g0Var.f4062d) || j3 != g0Var.f4063e || !str4.equals(g0Var.f4064f) || !str5.equals(g0Var.f4065g) || i3 != g0Var.f4066h || i4 != g0Var.f4067i) {
            throw new SQLiteException("immutable dedupe collision: ".concat(str6));
        }
    }

    public static void o0(SQLiteDatabase sQLiteDatabase, f0 f0Var, String str, int i3, String str2, String str3, long j3, int i4, String str4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("breach_type", str);
        contentValues.put("breach_priority", Integer.valueOf(i3));
        contentValues.put("breach_detail_json", str2);
        contentValues.put("breach_source", str3);
        contentValues.put("breach_observed_at_ms", Long.valueOf(j3));
        contentValues.put("breach_version", Integer.valueOf(i4));
        contentValues.put("breach_event_id", str4);
        contentValues.put("recovered_at_ms", Long.valueOf(j4));
        String str5 = f0Var.f3949a;
        String str6 = f0Var.f3950b;
        if (sQLiteDatabase.update("active_episodes", contentValues, "episode_type=? AND episode_id=?", new String[]{str5, str6}) != 1) {
            b2.a.m(str6, "episode breach update failed: ");
            return;
        }
        f0Var.f3953e = str;
        f0Var.f3954f = i3;
        f0Var.f3955g = str2;
        f0Var.f3956h = str3;
        f0Var.f3957i = j3;
        f0Var.f3958j = i4;
        f0Var.f3959k = str4;
        f0Var.f3960l = j4;
    }

    public static void w(SQLiteDatabase sQLiteDatabase, f0 f0Var, long j3) {
        if (f0Var.f3959k.isEmpty()) {
            return;
        }
        g0 g0VarM = M(sQLiteDatabase, f0Var.f3959k);
        if (g0VarM == null) {
            throw new SQLiteException("active breach version missing: " + f0Var.f3959k);
        }
        if (g0VarM.f4062d.isEmpty()) {
            try {
                int i3 = f0Var.f3958j + 1;
                JSONObject jSONObjectH0 = h0(f0Var.f3955g);
                jSONObjectH0.put("delivery_version", i3);
                jSONObjectH0.put("supersedes_event_id", f0Var.f3959k);
                String str = f0Var.f3950b;
                String strV = V(sQLiteDatabase, null, "security_breach", str, str, j3, f0Var.f3956h, jSONObjectH0, f0Var.f3954f, i3, E(i3, str, "security_breach"));
                if (strV == null) {
                    return;
                }
                o0(sQLiteDatabase, f0Var, f0Var.f3953e, f0Var.f3954f, f0Var.f3955g, f0Var.f3956h, f0Var.f3957i, i3, strV, f0Var.f3960l);
            } catch (SQLiteException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new SQLiteException("confirmed breach evidence promotion failed", e4);
            }
        }
    }

    public static f0 y(f0 f0Var, String str, long j3) {
        f0 f0Var2 = new f0(i0(j3), str, f0Var.f3950b);
        f0Var2.f3952d = f0Var.f3952d;
        f0Var2.f3953e = f0Var.f3953e;
        f0Var2.f3954f = f0Var.f3954f;
        f0Var2.f3955g = f0Var.f3955g;
        f0Var2.f3956h = f0Var.f3956h;
        f0Var2.f3957i = f0Var.f3957i;
        f0Var2.f3958j = f0Var.f3958j;
        f0Var2.f3959k = f0Var.f3959k;
        f0Var2.f3960l = f0Var.f3960l;
        return f0Var2;
    }

    public static void z(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, jSONObject2.opt(next));
        }
    }

    public final synchronized String G(String str, JSONObject jSONObject) {
        String strH;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    strH = H(writableDatabase, str, "service_lifecycle", jSONObject, i0(jCurrentTimeMillis), false);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (SQLiteException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw new SQLiteException("breach enqueue failed", e4);
                }
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        return strH;
        return strH;
    }

    public final synchronized void I(JSONObject jSONObject, long j3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long jI0 = i0(j3);
            f0 f0VarD = d(writableDatabase, "lost");
            if (f0VarD == null) {
                f0 f0VarD2 = d(writableDatabase, "unbind");
                if (f0VarD2 == null) {
                    f0VarD = new f0(jI0, "lost", UUID.randomUUID().toString());
                } else {
                    C(writableDatabase, f0VarD2);
                    f0VarD = y(f0VarD2, "lost", jI0);
                }
                f0VarD.f3952d = jI0;
                U(writableDatabase, f0VarD);
            }
            if (N(writableDatabase, f0VarD.f3950b, "a11y_lost") == null) {
                String str = f0VarD.f3950b;
                V(writableDatabase, null, "a11y_lost", str, str, jI0, "secure_observer", jSONObject, 0, 1, E(1, str, "a11y_lost"));
            }
            w(writableDatabase, f0VarD, jI0);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final String J(Boolean bool, long j3) {
        String strV;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long jI0 = i0(j3);
            f0 f0VarD = d(writableDatabase, "lost");
            if (f0VarD == null) {
                f0VarD = d(writableDatabase, "unbind");
            }
            if (f0VarD == null) {
                f0VarD = new f0(jI0, "unbind", UUID.randomUUID().toString());
                U(writableDatabase, f0VarD);
            }
            g0 g0VarN = N(writableDatabase, f0VarD.f3950b, "a11y_unbind");
            if (g0VarN != null) {
                strV = g0VarN.f4059a;
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("settingsOn", bool);
                    String str = f0VarD.f3950b;
                    strV = V(writableDatabase, null, "a11y_unbind", str, f0VarD.f3952d > 0 ? str : "", jI0, "service_on_unbind", jSONObject, 0, 1, E(1, str, "a11y_unbind"));
                } catch (Exception e3) {
                    throw new SQLiteException("settings evidence serialization failed", e3);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return strV;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final synchronized ArrayList Y() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = getReadableDatabase().query("events", new String[]{"enqueue_seq", "id", "kind", "transition_id", "episode_id", "observed_at_ms", "source", "detail_json"}, "sync_state=?", new String[]{String.valueOf(0)}, null, null, "enqueue_seq ASC", String.valueOf(Math.min(20, 128)));
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(new e0(cursorQuery.getLong(0), cursorQuery.getString(1), cursorQuery.getString(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getLong(5), cursorQuery.getString(6), cursorQuery.getString(7)));
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final synchronized void Z(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            HashSet hashSet = new HashSet();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                String str = (String) arrayList.get(i3);
                if (str != null && !str.isEmpty() && hashSet.add(str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sync_state", (Integer) 1);
                    contentValues.put("acked_at_ms", Long.valueOf(jCurrentTimeMillis));
                    if (writableDatabase.update("events", contentValues, "id=? AND sync_state=?", new String[]{str, String.valueOf(0)}) != 1) {
                        Cursor cursorQuery = writableDatabase.query("events", new String[]{"sync_state"}, "id=?", new String[]{str}, null, null, null, "1");
                        try {
                            int i5 = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : -1;
                            cursorQuery.close();
                            if (i5 != 1) {
                                throw new SQLiteException("ACK did not match pending immutable event: " + str);
                            }
                        } catch (Throwable th) {
                            if (cursorQuery == null) {
                                throw th;
                            }
                            try {
                                cursorQuery.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i3 = i4;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
    }

    public final synchronized String b0(long j3) {
        SQLiteDatabase writableDatabase;
        String strV;
        long j4;
        f0 f0Var;
        long j5;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                long jI0 = i0(j3);
                f0 f0VarD = d(writableDatabase, "lost");
                if (f0VarD == null) {
                    f0VarD = d(writableDatabase, "unbind");
                }
                f0 f0Var2 = f0VarD;
                if (f0Var2 != null) {
                    if (!P(writableDatabase, f0Var2.f3950b)) {
                        String strS = S(writableDatabase, "outbox_omission_debt_v1");
                        if (strS == null) {
                            strS = "";
                        }
                        try {
                            j5 = Long.parseLong(strS);
                        } catch (NumberFormatException unused) {
                            j5 = 0;
                        }
                        if (Math.max(0L, j5) == 0) {
                            throw new SQLiteException("active transition has no durable event: " + f0Var2.f3950b);
                        }
                    }
                    if (f0Var2.f3959k.isEmpty() || f0Var2.f3960l > 0) {
                        j4 = 0;
                        f0Var = f0Var2;
                        if (f0Var.f3960l <= 0) {
                            a0(writableDatabase, f0Var, jI0);
                        }
                    } else {
                        JSONObject jSONObjectH0 = h0(f0Var2.f3955g);
                        jSONObjectH0.put("breach_type", f0Var2.f3953e);
                        jSONObjectH0.put("recovery_ts", jI0);
                        jSONObjectH0.put("downtime_ms", Math.max(0L, jI0 - f0Var2.f3957i));
                        String string = s.h(s.g(jSONObjectH0)).toString();
                        JSONObject jSONObjectH1 = h0(string);
                        int i3 = f0Var2.f3958j + 1;
                        jSONObjectH1.put("delivery_version", i3);
                        jSONObjectH1.put("supersedes_event_id", f0Var2.f3959k);
                        j4 = 0;
                        String str = f0Var2.f3950b;
                        String strV2 = V(writableDatabase, null, "security_breach", str, f0Var2.f3952d > 0 ? str : "", jI0, f0Var2.f3956h, jSONObjectH1, f0Var2.f3954f, i3, E(i3, str, "security_breach"));
                        if (strV2 != null) {
                            o0(writableDatabase, f0Var2, f0Var2.f3953e, f0Var2.f3954f, string, f0Var2.f3956h, f0Var2.f3957i, i3, strV2, jI0);
                            f0Var = f0Var2;
                            jI0 = jI0;
                        } else {
                            f0Var = f0Var2;
                        }
                    }
                    if (f0Var.f3952d > j4) {
                        g0 g0VarN = N(writableDatabase, f0Var.f3950b, "a11y_reenabled");
                        if (g0VarN != null) {
                            strV = g0VarN.f4059a;
                        } else {
                            String str2 = f0Var.f3950b;
                            strV = V(writableDatabase, null, "a11y_reenabled", str2, str2, jI0, "service_connected", new JSONObject(), 0, 1, E(1, f0Var.f3950b, "a11y_reenabled"));
                        }
                    } else {
                        strV = null;
                    }
                    C(writableDatabase, f0Var);
                } else {
                    strV = null;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception e3) {
                if (e3 instanceof SQLiteException) {
                    throw ((SQLiteException) e3);
                }
                throw new SQLiteException("mark recovery failed", e3);
            }
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
        return strV;
    }

    public final synchronized String c0(String str, JSONObject jSONObject, long j3, String str2) {
        String strS;
        String str3 = "legacy_breach_migration_v2:" + UUID.nameUUIDFromBytes("legacy-breach-marker:".concat(str2).getBytes(StandardCharsets.UTF_8)).toString();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            strS = S(writableDatabase, str3);
            if (strS == null) {
                try {
                    strS = H(writableDatabase, str, "legacy_breach_slot", jSONObject, i0(j3), true);
                    if (strS != null) {
                        if (M(writableDatabase, strS) == null) {
                            throw new SQLiteException("durable event not proven: ".concat(strS));
                        }
                        k0(writableDatabase, str3, strS);
                    }
                } catch (SQLiteException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw new SQLiteException("breach enqueue failed", e4);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
        return strS;
    }

    public final synchronized void d0() {
        e0();
    }

    public final synchronized void e0() {
        SharedPreferences sharedPreferences = this.f4161c.getSharedPreferences("a11y_telemetry", 0);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            String strS = S(writableDatabase, "legacy_lost_migration_v2");
            if (S(writableDatabase, "legacy_lost_migration_v2_recovery_repair_v1_done") == null) {
                String str = "none";
                if (strS != null) {
                    String strSubstring = strS.startsWith("done:") ? strS.substring(5) : strS;
                    if (!strSubstring.isEmpty()) {
                        str = strSubstring;
                    }
                }
                if (!"none".equals(str)) {
                    m0(writableDatabase, str);
                }
                k0(writableDatabase, "legacy_lost_migration_v2_recovery_repair_v1_done", str);
            }
            if (S(writableDatabase, "legacy_lost_shared_prefs_v1_done") == null) {
                if (strS == null) {
                    strS = f0(writableDatabase, sharedPreferences);
                } else {
                    if (strS.startsWith("done:")) {
                        strS = strS.substring(5);
                    }
                    if (strS.isEmpty()) {
                        strS = "none";
                    }
                }
                k0(writableDatabase, "legacy_lost_shared_prefs_v1_done", strS);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            try {
                if (!sharedPreferences.edit().remove("lost_pending").commit()) {
                    Log.w("A11yEventOutbox", "legacy lost flag cleanup failed");
                }
            } catch (Throwable th) {
                Log.w("A11yEventOutbox", "legacy lost flag cleanup unavailable: " + th.getMessage());
            }
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    public final String f0(SQLiteDatabase sQLiteDatabase, SharedPreferences sharedPreferences) {
        if (!sharedPreferences.getBoolean("lost_pending", false) || !n.C0(this.f4161c)) {
            return "none";
        }
        f0 f0VarD = d(sQLiteDatabase, "lost");
        if (f0VarD == null) {
            long jI0 = i0(System.currentTimeMillis());
            f0 f0VarD2 = d(sQLiteDatabase, "unbind");
            if (f0VarD2 == null) {
                f0VarD = new f0(jI0, "lost", UUID.randomUUID().toString());
            } else {
                C(sQLiteDatabase, f0VarD2);
                f0VarD = y(f0VarD2, "lost", jI0);
            }
            f0VarD.f3952d = f0VarD.f3951c;
            U(sQLiteDatabase, f0VarD);
        }
        String str = f0VarD.f3950b;
        if (N(sQLiteDatabase, str, "a11y_lost") == null) {
            String string = UUID.nameUUIDFromBytes(a0.a.h("legacy-lost-event:", str, ":v1").getBytes(StandardCharsets.UTF_8)).toString();
            String str2 = f0VarD.f3950b;
            V(sQLiteDatabase, string, "a11y_lost", str2, str2, f0VarD.f3951c, "legacy_lost_pending", new JSONObject(), 0, 1, E(1, str, "a11y_lost"));
        }
        return str;
    }

    public final synchronized long g0() {
        long j3;
        String strS = S(getReadableDatabase(), "outbox_omission_debt_v1");
        if (strS == null) {
            strS = "";
        }
        try {
            j3 = Long.parseLong(strS);
        } catch (NumberFormatException unused) {
            j3 = 0;
        }
        return Math.max(0L, j3);
    }

    public final synchronized void j0() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long jCurrentTimeMillis = System.currentTimeMillis();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.execSQL("DELETE FROM events WHERE enqueue_seq IN (SELECT enqueue_seq FROM events WHERE sync_state=? AND transition_id NOT IN (SELECT episode_id FROM active_episodes) AND acked_at_ms>0 AND acked_at_ms<? ORDER BY enqueue_seq ASC LIMIT ?)", new Object[]{1, Long.valueOf(jCurrentTimeMillis - 604800000), 64});
            writableDatabase.execSQL("DELETE FROM events WHERE enqueue_seq IN (SELECT enqueue_seq FROM (SELECT enqueue_seq FROM events WHERE sync_state=? AND transition_id NOT IN (SELECT episode_id FROM active_episodes) ORDER BY enqueue_seq DESC LIMIT -1 OFFSET ?) ORDER BY enqueue_seq ASC LIMIT ?)", new Object[]{1, 256, 64});
            writableDatabase.execSQL("DELETE FROM events WHERE enqueue_seq IN (SELECT enqueue_seq FROM events WHERE sync_state=? AND transition_id NOT IN (SELECT episode_id FROM active_episodes) AND (quarantined_at_ms<? OR enqueue_seq IN (SELECT enqueue_seq FROM events WHERE sync_state=? AND transition_id NOT IN (SELECT episode_id FROM active_episodes) ORDER BY enqueue_seq DESC LIMIT -1 OFFSET ?)) ORDER BY enqueue_seq ASC LIMIT ?)", new Object[]{2, Long.valueOf(jCurrentTimeMillis - 86400000), 2, 64, 64});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final synchronized void l0(e0 e0Var, String str) {
        if (e0Var != null) {
            if (e0Var.f3832a > 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sync_state", (Integer) 2);
                    if (str.length() > 256) {
                        str = str.substring(0, 256);
                    }
                    contentValues.put("quarantine_reason", str);
                    contentValues.put("quarantined_at_ms", Long.valueOf(System.currentTimeMillis()));
                    if (writableDatabase.update("events", contentValues, "enqueue_seq=? AND sync_state=?", new String[]{String.valueOf(e0Var.f3832a), String.valueOf(0)}) != 1) {
                        Cursor cursorQuery = writableDatabase.query("events", new String[]{"sync_state"}, "enqueue_seq=?", new String[]{String.valueOf(e0Var.f3832a)}, null, null, null, "1");
                        try {
                            int i3 = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : -1;
                            cursorQuery.close();
                            if (i3 != 2) {
                                throw new SQLiteException("quarantine did not match pending immutable event seq=" + e0Var.f3832a);
                            }
                        } catch (Throwable th) {
                            if (cursorQuery == null) {
                                throw th;
                            }
                            try {
                                cursorQuery.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th3) {
                    writableDatabase.endTransaction();
                    throw th3;
                }
            }
        }
        throw new SQLiteException("cannot quarantine event without sequence");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (enqueue_seq INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT NOT NULL UNIQUE,kind TEXT NOT NULL,transition_id TEXT NOT NULL DEFAULT '',episode_id TEXT NOT NULL DEFAULT '',observed_at_ms INTEGER NOT NULL,source TEXT NOT NULL DEFAULT '',detail_json TEXT NOT NULL DEFAULT '{}',priority INTEGER NOT NULL DEFAULT 0,delivery_version INTEGER NOT NULL DEFAULT 1,dedupe_key TEXT NOT NULL UNIQUE,sync_state INTEGER NOT NULL DEFAULT 0,acked_at_ms INTEGER NOT NULL DEFAULT 0,quarantine_reason TEXT NOT NULL DEFAULT '',quarantined_at_ms INTEGER NOT NULL DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_pending_idx ON events (sync_state, enqueue_seq)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_episode_idx ON events (episode_id, kind, delivery_version)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_transition_idx ON events (transition_id, kind, delivery_version)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_episodes (episode_type TEXT PRIMARY KEY NOT NULL,episode_id TEXT NOT NULL UNIQUE,started_at_ms INTEGER NOT NULL,confirmed_at_ms INTEGER NOT NULL DEFAULT 0,breach_type TEXT NOT NULL DEFAULT '',breach_priority INTEGER NOT NULL DEFAULT -1,breach_detail_json TEXT NOT NULL DEFAULT '{}',breach_source TEXT NOT NULL DEFAULT '',breach_observed_at_ms INTEGER NOT NULL DEFAULT 0,breach_version INTEGER NOT NULL DEFAULT 0,breach_event_id TEXT NOT NULL DEFAULT '',recovered_at_ms INTEGER NOT NULL DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS state (key TEXT PRIMARY KEY NOT NULL,value TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        int i5;
        int i6;
        long jI0;
        char c3;
        String str;
        String str2;
        String str3;
        long j3;
        f0 f0Var;
        char c4 = 2;
        if (i3 < 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events_v2_migration");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events_v2_migration (enqueue_seq INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT NOT NULL UNIQUE,kind TEXT NOT NULL,transition_id TEXT NOT NULL DEFAULT '',episode_id TEXT NOT NULL DEFAULT '',observed_at_ms INTEGER NOT NULL,source TEXT NOT NULL DEFAULT '',detail_json TEXT NOT NULL DEFAULT '{}',priority INTEGER NOT NULL DEFAULT 0,delivery_version INTEGER NOT NULL DEFAULT 1,dedupe_key TEXT NOT NULL UNIQUE,sync_state INTEGER NOT NULL DEFAULT 0,acked_at_ms INTEGER NOT NULL DEFAULT 0,quarantine_reason TEXT NOT NULL DEFAULT '',quarantined_at_ms INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("INSERT INTO events_v2_migration (id,kind,episode_id,observed_at_ms,source,detail_json,priority,delivery_version,dedupe_key,sync_state,acked_at_ms) SELECT id,kind,episode_id,observed_at_ms,source,detail_json,priority,1,dedupe_key,sync_state,CASE WHEN sync_state=1 THEN observed_at_ms ELSE 0 END FROM events ORDER BY observed_at_ms ASC,id ASC");
            sQLiteDatabase.execSQL("DROP TABLE events");
            sQLiteDatabase.execSQL("ALTER TABLE events_v2_migration RENAME TO events");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_pending_idx ON events (sync_state, enqueue_seq)");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_episode_idx ON events (episode_id, kind, delivery_version)");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_transition_idx ON events (transition_id, kind, delivery_version)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_episodes (episode_type TEXT PRIMARY KEY NOT NULL,episode_id TEXT NOT NULL UNIQUE,started_at_ms INTEGER NOT NULL,confirmed_at_ms INTEGER NOT NULL DEFAULT 0,breach_type TEXT NOT NULL DEFAULT '',breach_priority INTEGER NOT NULL DEFAULT -1,breach_detail_json TEXT NOT NULL DEFAULT '{}',breach_source TEXT NOT NULL DEFAULT '',breach_observed_at_ms INTEGER NOT NULL DEFAULT 0,breach_version INTEGER NOT NULL DEFAULT 0,breach_event_id TEXT NOT NULL DEFAULT '',recovered_at_ms INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS state (key TEXT PRIMARY KEY NOT NULL,value TEXT NOT NULL)");
            String strS = S(sQLiteDatabase, "active_episode_id");
            String strS2 = S(sQLiteDatabase, "active_episode_type");
            String strS3 = S(sQLiteDatabase, "active_episode_started");
            if (strS == null || strS2 == null || !P(sQLiteDatabase, strS)) {
                str = "active_episode_id";
                str2 = "active_episode_type";
                str3 = "active_episode_started";
                i5 = 3;
            } else {
                if (strS3 == null) {
                    strS3 = "";
                }
                try {
                    j3 = Long.parseLong(strS3);
                } catch (NumberFormatException unused) {
                    j3 = 1;
                }
                f0 f0Var2 = new f0(i0(j3), strS2, strS);
                str3 = "active_episode_started";
                str = "active_episode_id";
                str2 = "active_episode_type";
                Cursor cursorQuery = sQLiteDatabase.query("events", new String[]{"id", "source", "detail_json", "priority", "delivery_version", "observed_at_ms"}, "episode_id=? AND kind=?", new String[]{strS, "security_breach"}, null, null, "priority DESC,delivery_version DESC,enqueue_seq DESC", "1");
                try {
                    if (cursorQuery.moveToFirst()) {
                        f0Var = f0Var2;
                        f0Var.f3959k = cursorQuery.getString(0);
                        f0Var.f3956h = cursorQuery.getString(1);
                        c4 = 2;
                        f0Var.f3955g = cursorQuery.getString(2);
                        i5 = 3;
                        f0Var.f3954f = cursorQuery.getInt(3);
                        f0Var.f3958j = cursorQuery.getInt(4);
                        f0Var.f3957i = cursorQuery.getLong(5);
                        try {
                            f0Var.f3953e = new JSONObject(f0Var.f3955g).optString("breach_type", "");
                        } catch (Exception unused2) {
                            f0Var.f3953e = "";
                        }
                    } else {
                        f0Var = f0Var2;
                        c4 = 2;
                        i5 = 3;
                    }
                    cursorQuery.close();
                    U(sQLiteDatabase, f0Var);
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            sQLiteDatabase.delete("state", "key IN (?,?,?)", new String[]{str, str2, str3});
        } else {
            i5 = 3;
        }
        if (i3 < i5) {
            if (!T(sQLiteDatabase, "events", "transition_id")) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN transition_id TEXT NOT NULL DEFAULT ''");
            }
            sQLiteDatabase.execSQL("UPDATE events SET transition_id=episode_id WHERE transition_id=''");
            if (!T(sQLiteDatabase, "active_episodes", "confirmed_at_ms")) {
                sQLiteDatabase.execSQL("ALTER TABLE active_episodes ADD COLUMN confirmed_at_ms INTEGER NOT NULL DEFAULT 0");
            }
            sQLiteDatabase.execSQL("UPDATE active_episodes SET confirmed_at_ms=started_at_ms WHERE episode_type=? AND confirmed_at_ms=0", new Object[]{"lost"});
            ArrayList arrayList = new ArrayList();
            char c5 = c4;
            Cursor cursorQuery2 = sQLiteDatabase.query("active_episodes", new String[]{"episode_type", "episode_id", "started_at_ms", "confirmed_at_ms", "breach_type", "breach_priority", "breach_detail_json", "breach_source", "breach_observed_at_ms", "breach_version", "breach_event_id", "recovered_at_ms"}, null, null, null, null, "episode_type ASC");
            while (cursorQuery2.moveToNext()) {
                try {
                    arrayList.add(K(cursorQuery2));
                } catch (Throwable th3) {
                    if (cursorQuery2 == null) {
                        throw th3;
                    }
                    try {
                        cursorQuery2.close();
                        throw th3;
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                        throw th3;
                    }
                }
            }
            cursorQuery2.close();
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                byte b3 = -1;
                f0 f0Var3 = null;
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i7);
                    i7++;
                    f0 f0Var4 = (f0) obj;
                    String str4 = f0Var4.f3949a;
                    if ("lost".equals(str4)) {
                        c3 = c5;
                    } else {
                        c3 = "unbind".equals(str4) ? (char) 1 : (char) 0;
                    }
                    if (f0Var3 == null || c3 > b3) {
                        b3 = c3;
                        f0Var3 = f0Var4;
                    }
                }
                sQLiteDatabase.delete("active_episodes", null, null);
                String str5 = f0Var3.f3949a;
                long j4 = f0Var3.f3951c;
                String str6 = "lost".equals(str5) ? "lost" : "unbind";
                if ("lost".equals(str6)) {
                    long j5 = f0Var3.f3952d;
                    if (j5 <= 0) {
                        j5 = j4;
                    }
                    jI0 = i0(j5);
                } else {
                    jI0 = 0;
                }
                if (jI0 > 0) {
                    j4 = jI0;
                }
                f0 f0VarY = y(f0Var3, str6, j4);
                f0VarY.f3952d = jI0;
                U(sQLiteDatabase, f0VarY);
            }
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_pending_idx ON events (sync_state, enqueue_seq)");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_episode_idx ON events (episode_id, kind, delivery_version)");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS a11y_events_transition_idx ON events (transition_id, kind, delivery_version)");
            i6 = 3;
        } else {
            i6 = i5;
        }
        if (i4 > i6) {
            throw new SQLiteException(a0.a.g("unsupported a11y outbox version ", i4));
        }
    }
}
