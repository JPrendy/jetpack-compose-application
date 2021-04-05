# template-repository

## Description

The existing repository is a template, I can generate new repositories with the same directory structure, branches, and files.

## Contents

- [Setup Steps](#setup-steps)
- [How to run the project locally](#how-to-run-the-project-locally)
- [Tools](#tools)
- [Update Dependencies](#update-dependencies)
- [Releases](#releases)
- [Documentations](#documentations)
- [Helpful resources](#helpful-resources)

## Setup Steps

```
Code here
```

<p><img src="images/exampleImage.png" width="300"/></p>

## How to run the project locally

```
Code here
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

The following link provides helpful information
- [link](https://github.com/JPrendy/template-repository).








https://nglauber.medium.com/jetpack-compose-part-ii-async-data-tabs-scroller-fab-state-efc8e267b914

https://www.youtube.com/watch?app=desktop&v=eMVxhlBsxEk

https://www.udemy.com/course/android-architecture-componentsmvvm-with-dagger-retrofit/

```kotlin
package com.example.testcompose

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    NewsStory()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

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
        Greeting("Android")
        NewsStory()
    }
}
```

```kotlin
dependencies {

    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.2.1'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha06'
    implementation 'androidx.activity:activity-compose:1.3.0-alpha02'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
}
```