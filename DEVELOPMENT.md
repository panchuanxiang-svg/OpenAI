# Samsung Firmware Downloader - Android Only

## 快速开始指南

### 项目结构初始化

此项目已从 [Bifrost](https://github.com/zacharee/Bifrost) 进行改造，仅保留 Android 架构。

### 下一步开发步骤

1. **复制 common 模块的 multiplatform 代码**
   ```bash
   git clone https://github.com/zacharee/Bifrost.git
   cp -r Bifrost/common/src/commonMain/* common/src/androidMain/
   ```

2. **实现固件下载逻辑**
   - 在 `FirmwareRepository` 实现具体下载和解密
   - 集成 Ktor HTTP 客户端与三星 OTA 服务器通信

3. **添加数据库支持**
   ```kotlin
   // 使用 Ketch SQLite 存储下载历史
   implementation(libs.ketch.sqlite)
   ```

4. **UI 完善**
   - 完成固件搜索结果列表
   - 下载进度显示
   - 解密状态提示

5. **本地存储配置**
   ```kotlin
   // 使用 multiplatformSettings 存储用户偏好设置
   val settings: Settings by di.inject()
   ```

### 构建和运行

```bash
# Debug 构建
./gradlew app:assembleDebug

# 安装到设备
./gradlew app:installDebug

# Release 构建
./gradlew app:assembleRelease
```

### 在 Acode 上编辑

此项目已优化为支持在移动 IDE 上进行开发：

1. 在 Acode 中打开项目
2. 使用 Terminal 插件运行 Gradle 命令
3. 直接在手机上实时编译和测试

### 远程依赖管理

项目使用 `libs.versions.toml` 管理所有依赖版本，便于版本控制和升级：

```toml
[versions]
compileSdk = "35"
targetSdk = "35"
minSdk = "26"
```

### 后续任务

- [ ] 完成 OTA/FUS API 集成
- [ ] 实现固件解密算法
- [ ] 添加数据库存储
- [ ] 完善 UI 交互
- [ ] 性能优化
- [ ] 单元测试

---

**项目链接**：https://github.com/panchuanxiang-svg/otaDownload

**分支**：`android-only-dev`
