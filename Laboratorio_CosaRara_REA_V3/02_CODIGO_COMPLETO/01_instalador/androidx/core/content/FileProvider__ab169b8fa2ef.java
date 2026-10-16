// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lyr.stable.wrapper.MainActivity;
import org.xmlpull.v1.XmlPullParserException;
import p031r.b;
import p031r.e;
import p031r.f;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f1474c = {"_display_name", "_size"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final File f1475d = new File("/");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f1476e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1478b;

    public static f b(Context context, String str) {
        f fVarD;
        HashMap map = f1476e;
        synchronized (map) {
            try {
                fVarD = (f) map.get(str);
                if (fVarD == null) {
                    try {
                        try {
                            fVarD = d(context, str);
                            map.put(str, fVarD);
                        } catch (IOException e2) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                        }
                    } catch (XmlPullParserException e3) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVarD;
    }

    public static Uri c(MainActivity mainActivity, String str, File file) {
        f fVarB = b(mainActivity, str);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : fVarB.f4028b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Uri.Builder().scheme("content").authority(fVarB.f4027a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    public static f d(Context context, String str) throws XmlPullParserException, IOException {
        f fVar = new f(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return fVar;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f1475d;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrB = b.b(context, null);
                    if (fileArrB.length > 0) {
                        externalStorageDirectory = fileArrB[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrA = b.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] fileArrA2 = e.a(context);
                    if (fileArrA2.length > 0) {
                        externalStorageDirectory = fileArrA2[0];
                    }
                }
                if (externalStorageDirectory == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        externalStorageDirectory = new File(externalStorageDirectory, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        fVar.f4028b.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e2) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e2);
                    }
                }
            }
        }
    }

    public final f a() {
        f fVar;
        synchronized (this) {
            try {
                if (this.f1477a == null) {
                    this.f1477a = b(getContext(), this.f1478b);
                }
                fVar = this.f1477a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f1478b = providerInfo.authority.split(";")[0];
        HashMap map = f1476e;
        synchronized (map) {
            map.remove(this.f1478b);
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return a().a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        File fileA = a().a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i2;
        File fileA = a().a(uri);
        if ("r".equals(str)) {
            i2 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i2 = 738197504;
        } else if ("wa".equals(str)) {
            i2 = 704643072;
        } else if ("rw".equals(str)) {
            i2 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException("Invalid mode: " + str);
            }
            i2 = 1006632960;
        }
        return ParcelFileDescriptor.open(fileA, i2);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File fileA = a().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f1474c;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = queryParameter == null ? fileA.getName() : queryParameter;
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i3] = "_size";
                    i2 = i3 + 1;
                    objArr[i3] = Long.valueOf(fileA.length());
                }
            }
            i3 = i2;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
