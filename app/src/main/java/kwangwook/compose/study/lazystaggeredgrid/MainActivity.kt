package kwangwook.compose.study.lazystaggeredgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kwangwook.compose.study.lazystaggeredgrid.ui.ListItem
import kwangwook.compose.study.lazystaggeredgrid.ui.theme.ComposeStudyLazyStaggeredGridTheme

class MainActivity : ComponentActivity() {
    
    private val exampleItems = List(100) {
        ListItem(
            height = (100..300).random().dp,
            color = Color((0xFF000000..0xFFFFFFFF).random()).copy(alpha = 1f)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyLazyStaggeredGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyLazyStaggeredGridTheme {
        Greeting("Android")
    }
}