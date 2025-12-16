// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorBrowserOpener",
    platforms: [.iOS(.v15)],
    products: [
        .library(
            name: "CapacitorBrowserOpener",
            targets: ["BrowserOpenerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "8.0.0")
    ],
    targets: [
        .target(
            name: "BrowserOpenerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/BrowserOpenerPlugin"),
        .testTarget(
            name: "BrowserOpenerPluginTests",
            dependencies: ["BrowserOpenerPlugin"],
            path: "ios/Tests/BrowserOpenerPluginTests")
    ]
)