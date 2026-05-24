# Bifrost 项目架构迁移文档

## 概述
本文档记录了 Bifrost 项目从跨平台架构向纯 Android 架构的迁移过程。

## 迁移详情

### 阶段一：架构精简 ✅

#### 移除的模块
- ❌ `desktop` - JVM 桌面应用
- ❌ `iosApp` - iOS 应用
- ❌ `jvmMain` - JVM 编译目标
- ❌ `iosArm64Main` / `iosSimulatorArm64Main` - iOS 编译目标
- ❌ `darwinMain` - macOS 编译目标

#### 保留的模块
- ✅ `app` (原 `android`) - Android 应用
- ✅ `common` - 共享业务逻辑（纯 Android)

#### 修改的配置文件
- `settings.gradle.kts` - 移除 `:desktop` 模块，重命名 `:android` 为 `:app`
- `build.gradle.kts` - 移除桌面和 iOS 相关插件
- `common/build.gradle.kts` - 移除多平台配置，仅保留 Android

### 阶段二：固件下载核心功能 ⏳

计划添加以下功能模块：

#### 1. **固件获取引擎** (`firmware-loader`)
```
app/src/main/kotlin/tk/zwander/bifrost/firmware/
├── FirmwareDownloader.kt        # 固件下载管理
├── OtaClient.kt                 # OTA 服务器通信
├── FusClient.kt                 # FUS 服务器通信
└── FirmwareParser.kt            # 固件信息解析
```

#### 2. **解密系统** (`firmware-decryptor`)
```
app/src/main/kotlin/tk/zwander/bifrost/crypto/
├── FirmwareDecryptor.kt         # 固件解密核心
├── KeyManager.kt                # 密钥管理
└── OdinPackager.kt              # Odin 格式打包
```

#### 3. **搜索接口** (`firmware-search`)
```
app/src/main/kotlin/tk/zwander/bifrost/search/
├── FirmwareSearchEngine.kt      # 搜索引擎
├── BetaFirmwareProvider.kt      # 测试版固件源
├── OtaProvider.kt               # OTA 更新源
└── SearchFilters.kt             # 搜索过滤器
```

### 阶段三：UI 和集成 ⏳

- Compose UI 优化（专为移动设计）
- Terminal 集成接口
- 本地固件管理

## 构建命令

### 开发环境
```bash
# 同步 Gradle
./gradlew assemble

# 构建调试 APK
./gradlew :app:assembleDebug

# 构建发布 APK
./gradlew :app:assembleRelease
```

### 清理
```bash
./gradlew clean
```

## 分支信息

- **主分支**: `master` - 原始跨平台版本
- **开发分支**: `dev/android-only` - 纯 Android 开发分支

## 后续计划

- [ ] 完成 Gradle 配置精简
- [ ] 实现固件下载器
- [ ] 实现固件解密系统
- [ ] 创建搜索接口
- [ ] Acode Terminal 集成
- [ ] 完整测试

## 注意事项

1. **依赖管理**: 已移除所有桌面和 iOS 相关依赖
2. **编译目标**: 仅编译 Android 平台
3. **测试**: 需要 Android SDK 26+ (API Level 26)
4. **密钥**: Bugsnag API 密钥已保留（仅 Android）

## 联系方式

如有问题，请提交 Issue 或 Pull Request。
