// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f436a = new k();

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return false;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return l.f437a;
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        return Collections.EMPTY_MAP;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z2) {
        return z2;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f3) {
        return f3;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i3) {
        return i3;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j3) {
        return j3;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        return set;
    }
}
