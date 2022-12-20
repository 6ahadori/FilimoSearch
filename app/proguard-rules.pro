# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keep class **.R$*

### Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
 **[] $VALUES;
 public *;
 }
 # Uncomment for DexGuard only
 #-keepresourcexmlelements manifest/application/meta-data@value=GlideMod
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
**[] $VALUES;
public *;
}


 ### Retrofit 2
 # Platform calls Class.forName on types which do not exist on Android to determine platform.
 -dontnote retrofit2.Platform
 # Platform used when running on RoboVM on iOS. Will not be used at runtime.
 -dontnote retrofit2.Platform$IOS$MainThreadExecutor
 # Platform used when running on Java 8 VMs. Will not be used at runtime.
 -dontwarn retrofit2.Platform$Java8
 # Retain generic type information for use by reflection by converters and adapters.
 -keepattributes Signature
 # Retain declared checked exceptions for use by a Proxy instance.
 -keepattributes Exceptions

 -dontwarn retrofit2.adapter.rxjava.CompletableHelper$** # https://github.com/square/retrofit/issues/2034
 #Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
 # EnclosingMethod is required to use InnerClasses.
 -keepattributes Signature, InnerClasses, EnclosingMethod
 # Retain service method parameters when optimizing.
 -keepclassmembers,allowshrinking,allowobfuscation interface * {
     @retrofit2.http.* <methods>;
 }
 # Retrofit does reflection on method and parameter annotations.
 -keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
 # Ignore annotation used for build tooling.
 -dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 # Ignore JSR 305 annotations for embedding nullability information.
 -dontwarn javax.annotation.**
 # Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
 -dontwarn kotlin.Unit
 # Top-level functions that can only be used by Kotlin.
 -dontwarn retrofit2.KotlinExtensions
 -dontwarn retrofit2.KotlinExtensions$*
 # With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
 # and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
 -if interface * { @retrofit2.http.* <methods>; }
 -keep,allowobfuscation interface <1>

 ### OkHttp3
 -dontwarn okhttp3.**
 -dontwarn okio.**
 -dontwarn javax.annotation.**
 # A resource is loaded with a relative path so the package of this class must be preserved.
 -keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
 -dontnote okhttp3.**, okio.**, retrofit2.**
 -dontwarn retrofit2.**
 -keep class retrofit2.** { *; }
