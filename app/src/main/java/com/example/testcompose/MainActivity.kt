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