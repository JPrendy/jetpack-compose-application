# Jetpack Compose application

## Description

A Kotlin Application that uses Jetpack Compose to show how you can create a layout without using a xml file, it also includes an interface class and explains why you would want to use interfaces when developing an application.

## Contents

- [Setup Steps](#setup-steps)
- [How to run the project locally](#how-to-run-the-project-locally)
- [Tools](#tools)
- [Update Dependencies](#update-dependencies)
- [Releases](#releases)
- [Documentations](#documentations)
- [Helpful resources](#helpful-resources)

## Setup Steps

The following is a brief example of how you can create a layout without needing a xml file with Jetpack Compose, this is important as Jetpack Compose will be the future of how we create layout for Android development.

The following is a brief example of how you can set text and images using Jetpack Compose.

```kotlin
package com.example.testcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val standardPackage = PackageFactory.getHostingFrom(PackageType.STANDARD)
        val inheritedInterfaceFunction = PremiumPackage().getServices()
        val interfaceFunction = PremiumPackage().getDiscount()
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(inheritedInterfaceFunction, interfaceFunction)
                }
            }
        }
    }
}

@Composable
fun Greeting(inherited: String, nonInherited: String) {
    Column {
        Text(
            text = "Hello $inherited!",
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = "Hello $nonInherited!",
            modifier = Modifier
                .padding(8.dp)
        )
        NewsStory()
    }
}

@Composable
fun NewsStory() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.regigigas),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Text("A day in Shark Fin Cove", style = typography.body2)
            Text("Davenport, California", style = typography.body2)
            Text("December 2018", style = typography.body2)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestComposeTheme {
        Greeting("Inherited", "Non Inherited")
        NewsStory()
    }
}
```

We also have some Interface examples in this application. Interfaces are good as whenever we inherit an interface, we must also implement methods defined in our interface, we can inherit multiple inferfaces where we can only inherit one class.

Also, The key point is that interfaces provide a layer of abstraction so that you can write code that is ignorant of unnecessary details. Interfaces can also be used for Factory patterns which controls which objects to instantiate, see the following [link](https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android#toc-anchor-006:~:text=maintain.-,Factory)

Another good part about Interfaces is it allows for parallel development, let's say two teams working on different components that must co-operate. If the two teams sit down on day 1 and agree on a set of interfaces, then they can go their separate ways and implement their components around those interfaces.

```kotlin
package com.example.testcompose

interface SimpleInterface {
    fun getServices(): String
}

enum class PackageType {
    STANDARD,
    PREMIUM
}

class StandardPackage: SimpleInterface {
    override fun getServices(): String {
        return "standard package"
    }
}

class PremiumPackage: SimpleInterface {
    override fun getServices(): String {
        return "premium package"
    }

    fun getDiscount(): String {
        return "15 %"
    }
}

class PlatinumPackage: SimpleInterface {
    //have to implement members when using an interface
    override fun getServices(): String {
        TODO("Not yet implemented")
    }

}

object PackageFactory {
    fun getHostingFrom(type: PackageType): String {
        return when(type){
            PackageType.STANDARD -> {
                StandardPackage().getServices()
            }
            PackageType.PREMIUM -> {
                PremiumPackage().getServices()
            }
        }
    }
}
```

## How to run the project locally

To run the unit tests locally.

```kotlin
./gradlew testdebugUnitTest
```

To run the ui tests locally, but first we need an emulator to be open.

```kotlin
./gradlew connectedCheck
```

## Tools

**Linter:** we use the following linter [link](https://github.com/github/super-linter).

**Uploading Artifacts:**  we use the following way to upload Artifacts, they allow you to persist data like test results after a job has completed, see the following documentation [link](https://docs.github.com/en/actions/configuring-and-managing-workflows/persisting-workflow-data-using-artifacts).

**Creating images/icons:** we use Figma to create images and icon. Figma makes it very easy to create designs in many different formats.

**Creating a Mock Server:** we use a mock server with Postman to quickly test apis, to see how to create a mock server, see the following video [link](https://www.youtube.com/watch?v=rJY8uUH2TIk). 

### Mobile Specific Tools:
 
**Fastlane:** Fastlane allows us to automate our development and release process [link](https://docs.fastlane.tools/).

**App Center:** App Center is used to distribute an app, making it very easy to test on a physical device by using a fastlane plugin [link](https://github.com/microsoft/fastlane-plugin-appcenter).

**Proxyman:** we use Proxyman to view HTTP/HTTPS requests as they happen, it is easier to debug network connections on mobile on Proxyman where we can test and mock specific network responses, see the following documentation [link](https://docs.proxyman.io/debug-devices/ios-simulator). 

## Update Dependencies

**Npm:** How to update a npm package.
- [link](https://docs.npmjs.com/cli/update).

**Gemfile:** How to update a Gemfile package.
- [link](https://bundler.io/man/bundle-update.1.html#UPDATING-A-LIST-OF-GEMS).

## Documentations

**Git Squash:** How to Git Squash with VS Code [link](documentations/gitSquashDocument.md).

**Git Worktree:** How to use Git Worktree [link](documentations/gitWorktreeDocument.md).

**Git Empty Commit:** How to use Git Empty Commit [link](documentations/gitEmptyCommitDocument.md).

**Common Design Patterns and App Architectures for Mobile**: [link](https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android#toc-anchor-001) and [link](https://dev.to/codalreef/learn-dependency-injection-with-doug-the-goldfish-3j43). 

## Releases

How to manage releases in a repository [link](https://help.github.com/en/github/administering-a-repository/managing-releases-in-a-repository). 

## Helpful resources

The following link provides a video that explains how you parse api data using `Retrofit` and display that data with `Jetpack Compose`.
- [link](https://www.youtube.com/watch?app=desktop&v=eMVxhlBsxEk).

The following link provides a Udemy course on `Android Jetpack, clean architecture & Testing`. 
- [link](https://www.udemy.com/course/android-architecture-componentsmvvm-with-dagger-retrofit/).

The following link provides help on how you add a newline to `Jetpack Compose` text. 
- [link](https://stackoverflow.com/questions/65877507/in-jetpack-compose-text-causes-newline).

The following link provides information on why you would want to use `interfaces`. 
- [link](https://stackoverflow.com/questions/240152/why-would-i-want-to-use-interfaces).

The following link provides Guide to Kotlin `interfaces` and how they work, it is quite helpful. 
- [link](https://www.baeldung.com/kotlin/interfaces).