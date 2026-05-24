# Samsung Firmware Downloader - Android Only Edition

纯 Android 架构的三星固件下载器

## 项目结构

基于 [Bifrost](https://github.com/zacharee/Bifrost) 官方项目改造，移除了桌面和 iOS 模块，专注于 Android 平台开发。

### 模块

- **app** - Android 应用程序
- **common** - 共享业务逻辑（固件下载、解密等）

## 功能特性

### ✅ 已实现
- 从三星 OTA/FUS 服务器直接获取原厂加密固件
- 自动解密固件为 Odin 可用格式
- 跨版本和区域搜索固件

### 🚀 后续计划
1. **测试版&OTA固件搜索** - 支持自定义接口添加非正式版本固件源
2. **大版本测试版支持** - 能够检测和下载早期版本
3. **移动开发环境集成** - 兼容 Acode/Terminal 编辑和打包
4. **自动化工作流** - 集成到 CI/CD 固件发布流程

## 快速开始

### 前置条件
- Android SDK 26+
- Java 21+
- Gradle 8.x

### 构建

```bash
# 构建 APK
./gradlew app:assembleDebug

# 构建 Release
./gradlew app:assembleRelease

# 在设备上运行
./gradlew app:installDebug
```

## 架构说明

### 移除的模块
- ✗ `desktop` - JVM 桌面应用
- ✗ `iosApp` - iOS 应用
- ✗ 跨平台 Compose Multiplatform 配置
- ✗ CocoaPods 和 Darwin 目标

### 保留的依赖
- Jetpack Compose UI 框架
- Ktor HTTP 客户端
- Kotlin Coroutines
- SQLite (通过 Ketch)
- Material Design 3

## 开发指南

### 固件解密接口

在 `common` 模块中实现固件解密逻辑：

```kotlin
interface FirmwareDecryptor {
    suspend fun decryptFirmware(
        encryptedPath: String,
        outputPath: String,
        decryptionKey: String
    ): Result<String>
}
```

### 自定义固件源

通过接口添加自定义固件搜索源：

```kotlin
interface FirmwareSource {
    suspend fun searchFirmware(
        model: String,
        region: String,
        includeBeta: Boolean = false
    ): List<FirmwareInfo>
}
```

## 后续开发任务

- [ ] 实现自定义固件源接口
- [ ] 添加测试版固件搜索
- [ ] 优化解密性能
- [ ] 增加 Acode IDE 集成支持
- [ ] 构建自动化脚本
- [ ] 单元测试覆盖
- [ ] CI/CD 管道配置

## License

MIT License - 基于原 Bifrost 项目

## 相关链接

- 原项目：https://github.com/zacharee/Bifrost
- 固件来源：三星官方 OTA/FUS 服务器
