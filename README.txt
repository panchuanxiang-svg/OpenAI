这是最终修正版。

本压缩包已经包含：

app/build.gradle.kts
common/build.gradle.kts
settings.gradle.kts
build.gradle.kts

步骤：

1. 下载原版 Bifrost
2. 删除：
desktop/
browser/
iosApp/

3. 用本压缩包覆盖原工程

4. 编译：

cd ~/Bifrost-master

pkg install openjdk-17 -y
pkg install gradle -y

gradle wrapper

chmod +x gradlew

./gradlew :app:assembleDebug